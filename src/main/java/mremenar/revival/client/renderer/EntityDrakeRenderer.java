package mremenar.revival.client.renderer;

import mremenar.revival.entity.EntityDrake;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityDrakeRenderer extends MobRenderer<EntityDrake, HumanoidModel<EntityDrake>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("revival", "textures/entity/drake.png");

    public EntityDrakeRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 2.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDrake entity) {
        return TEXTURE;
    }
}