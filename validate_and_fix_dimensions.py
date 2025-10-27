import os
import json
from pathlib import Path

# Combined validator and auto-fixer for Orespawn mod dimensions (Forge 1.20.1)
# Now includes automatic schema correction for invalid monster_spawn_light_level arrays

DEFAULTS = {
    "infiniburn": "#minecraft:infiniburn_overworld",
    "piglin_safe": False,
    "effects": "minecraft:overworld",
    "min_y": 0,
    "height": 384,
    "logical_height": 384,
    "monster_spawn_light_level": {
        "type": "minecraft:uniform",
        "value": {"min_inclusive": 0, "max_inclusive": 7}
    },
    "monster_spawn_block_light_limit": 0
}

def load_json(path: Path):
    try:
        with open(path, 'r', encoding='utf-8') as f:
            return json.load(f)
    except Exception as e:
        print(f"❌ Failed to parse {path.name}: {e}")
        return None

def save_json(path: Path, data: dict):
    backup = path.with_suffix(path.suffix + '.bak')
    os.replace(path, backup)
    with open(path, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=2)

def fix_monster_spawn_field(data):
    if isinstance(data.get('monster_spawn_light_level'), list):
        print("🧩 Fixed invalid monster_spawn_light_level array → object schema")
        data['monster_spawn_light_level'] = {
            "type": "minecraft:uniform",
            "value": {
                "min_inclusive": data['monster_spawn_light_level'][0] if len(data['monster_spawn_light_level']) > 0 else 0,
                "max_inclusive": data['monster_spawn_light_level'][1] if len(data['monster_spawn_light_level']) > 1 else 7
            }
        }

def fix_dimension_type_files(base_folder: Path):
    dim_type_dir = base_folder / 'dimension_type'
    print(f"\n🔍 Scanning {dim_type_dir} ...")

    for file in dim_type_dir.glob('*.json'):
        data = load_json(file)
        if not data:
            continue

        modified = False

        fix_monster_spawn_field(data)

        for key, default in DEFAULTS.items():
            if key not in data:
                data[key] = default
                print(f"🧩 {file.name}: Added missing key '{key}' with default value.")
                modified = True

        if modified:
            save_json(file, data)
            print(f"✅ {file.name}: Fixed and backed up.")
        else:
            print(f"✔️ {file.name}: No changes needed.")

def fix_dimension_links(base_folder: Path):
    dim_dir = base_folder / 'dimension'
    dim_type_dir = base_folder / 'dimension_type'

    print("\n--- Validating dimension ↔ type links ---\n")

    for file in dim_dir.glob('*.json'):
        data = load_json(file)
        if not data:
            continue

        name = file.stem
        type_name = name.replace('_dimension', '_type') if name.endswith('_dimension') else name + '_type'
        expected_type_path = dim_type_dir / f"{type_name}.json"

        if 'type' not in data or data['type'].startswith('minecraft:'):
            if expected_type_path.exists():
                data['type'] = f'orespawn:{type_name}'
                save_json(file, data)
                print(f"🔧 Updated 'type': 'orespawn:{type_name}' → {file.name}")
            else:
                print(f"⚠️ No matching type found for {file.name}")
        else:
            print(f"✔️ {file.name}: OK")

    print("\n✅ All dimension <-> type links validated and fixed where possible.")

if __name__ == '__main__':
    base = Path('src/main/resources/data/orespawn')

    if not base.exists():
        print(f"❌ Folder not found: {base}")
    else:
        print("\n=== 🛠️ Orespawn Dimension Repair Tool (Forge 1.20.1) ===\n")
        fix_dimension_type_files(base)
        fix_dimension_links(base)
        print("\n🎉 Complete! All dimension JSONs are validated and auto-fixed.")
