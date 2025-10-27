package com.example.orespawn.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = "orespawn", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "orespawn");

    public static final RegistryObject<EntityType<Drake>> DRAKE = ENTITIES.register("drake", () ->
        EntityType.Builder.of(Drake::new, MobCategory.CREATURE).sized(2.0f, 4.0f).build("drake"));

    public static final RegistryObject<EntityType<BabyDrake>> BABY_DRAKE = ENTITIES.register("baby_drake", () ->
        EntityType.Builder.of(BabyDrake::new, MobCategory.CREATURE).sized(1.0f, 1.5f).build("baby_drake"));

    public static void register() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}