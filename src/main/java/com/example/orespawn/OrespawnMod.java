package com.yourname.orespawn;  // Change 'yourname' to yours, e.g., mremenar

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("orespawn")
public class OrespawnMod {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "orespawn");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "orespawn");

    public static final RegistryObject<EntityType<DrakeEntity>> DRAKE = ENTITIES.register("drake",
        () -> EntityType.Builder.of(DrakeEntity::new, MobCategory.CREATURE)
            .sized(2.4F, 1.4F)  // Orespawn dragon sizes approx.
            .build("orespawn:drake"));
    
    public static final RegistryObject<EntityType<BabyDrakeEntity>> BABY_DRAKE = ENTITIES.register("baby_drake",
        () -> EntityType.Builder.of(BabyDrakeEntity::new, MobCategory.CREATURE)
            .sized(1.2F, 0.7F)
            .build("orespawn:baby_drake"));

    public static final RegistryObject<Item> DRAKE_SPAWN_EGG = ITEMS.register("drake_spawn_egg",
        () -> new SpawnEggItem(DRAKE, 0x8B0000, 0xFF4500, new Item.Properties()));  // Red/orange egg
    public static final RegistryObject<Item> BABY_DRAKE_SPAWN_EGG = ITEMS.register("baby_drake_spawn_egg",
        () -> new SpawnEggItem(BABY_DRAKE, 0xA52A2A, 0xFF6347, new Item.Properties()));

    public OrespawnMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}