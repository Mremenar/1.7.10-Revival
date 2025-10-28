package mremenar.revival.client.renderer;

import mremenar.revival.entity.EntityBabyDrake;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityBabyDrakeRenderer extends MobRenderer<EntityBabyDrake, HumanoidModel<EntityBabyDrake>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("revival", "textures/entity/baby_drake.png");

    public EntityBabyDrakeRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBabyDrake entity) {
        return TEXTURE;
    }
}