package mremenar.revival.item;

import mremenar.revival.RevivalMain;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RevivalItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, RevivalMain.MODID);

    public static final RegistryObject<Item> DRAKE_SPAWN_EGG = ITEMS.register("drake_spawn_egg",
        () -> new ForgeSpawnEggItem(RevivalMain.DRAKE, 0x8B4513, 0xFFD700, new Item.Properties()));

    public static final RegistryObject<Item> BABY_DRAKE_SPAWN_EGG = ITEMS.register("baby_drake_spawn_egg",
        () -> new ForgeSpawnEggItem(RevivalMain.BABY_DRAKE, 0x8B4513, 0xFFFF00, new Item.Properties()));

    public static final RegistryObject<Item> TARBOSAURUS_SPAWN_EGG = ITEMS.register("tarbosaurus_spawn_egg",
        () -> new ForgeSpawnEggItem(RevivalMain.TARBOSAURUS, 0x654321, 0xFFFFFF, new Item.Properties()));
}