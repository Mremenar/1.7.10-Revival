# OreSpawn Dimensions Pack (Forge 1.20.1)

Includes **Utopia, Danger Dimension II, Mining, Crystal, Ice, Dragon Realm, Farming**.

## Install
Unzip into your mod project root so that the `src/` folder merges with your existing `src/`.

## Wire-up steps
1. Open `Reg.java` and paste contents of `snippets/Reg_Dimensions_snippet.java` near your other BLOCK/ITEM registrations.
2. In your creative tab builder, add lines from `snippets/CreativeTabs_Dimensions_snippet.java` so the igniter items show up.
3. Build with `gradlew build` and test. Dimensions are data-driven (JSON); portal logic is placeholder and will be finalized in a later pass.

## Notes
- Biomes are simple starting points. We’ll refine spawn lists and features when we port mobs and structures.
- Farming Dimension is included and designed as high-vegetation fields.
- Crystal Dimension uses vanilla amethyst features.
- Cherry trees are referenced via `minecraft:trees_cherry` in Utopia biome, which will drop your OreSpawn cherries per prior integration.
