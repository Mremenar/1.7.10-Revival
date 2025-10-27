package mremenar.revival;

import mremenar.revival.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(RevivalMain.MODID)
public class RevivalMain {
    public static final String MODID = "revival";

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<EntityDrake>> DRAKE = ENTITIES.register("drake",
            () -> EntityType.Builder.of(EntityDrake::new, MobCategory.MONSTER)
                    .sized(4.0F, 3.5F)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .build("drake"));

    public static final RegistryObject<EntityType<EntityBabyDrake>> BABY_DRAKE = ENTITIES.register("baby_drake",
            () -> EntityType.Builder.of(EntityBabyDrake::new, MobCategory.CREATURE)
                    .sized(1.5F, 1.2F)
                    .clientTrackingRange(32)
                    .updateInterval(5)
                    .build("baby_drake"));

    public static final RegistryObject<EntityType<EntityTarbosaurus>> TARBOSAURUS = ENTITIES.register("tarbosaurus",
            () -> EntityType.Builder.of(EntityTarbosaurus::new, MobCategory.MONSTER)
                    .sized(2.8F, 2.8F)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .build("tarbosaurus"));

    public RevivalMain() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(modBus);
	RevivalItems.ITEMS.register(modBus);
    }
}