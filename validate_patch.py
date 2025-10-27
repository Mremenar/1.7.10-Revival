import os, json, sys

def validate_json(path):
    try:
        with open(path) as f:
            data = json.load(f)
    except Exception as e:
        return f"❌ {os.path.basename(path)}: Invalid JSON ({e})"
    if "has_raids" not in str(data):
        return f"⚠️ {os.path.basename(path)}: Missing 'has_raids' key"
    return f"✔️ {os.path.basename(path)} OK"

def main():
    base = "src/main/resources/data/orespawn"
    for folder in ["dimension_type", "forge/biome_modifier"]:
        p = os.path.join(base, folder)
        if not os.path.exists(p):
            print(f"❌ Folder not found: {p}")
            continue
        for file in os.listdir(p):
            if file.endswith(".json"):
                print(validate_json(os.path.join(p, file)))

if __name__ == "__main__":
    main()
