package mremenar.revival;

import mremenar.revival.entity.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RevivalMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RevivalEntities {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RevivalMain.DRAKE.get(), EntityDrake.createAttributes().build());
        event.put(RevivalMain.BABY_DRAKE.get(), EntityBabyDrake.createAttributes().build());
        event.put(RevivalMain.TARBOSAURUS.get(), EntityTarbosaurus.createAttributes().build());
    }
}