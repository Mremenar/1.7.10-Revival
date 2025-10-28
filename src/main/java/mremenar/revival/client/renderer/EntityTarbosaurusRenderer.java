package mremenar.revival.client.renderer;

import mremenar.revival.entity.EntityTarbosaurus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityTarbosaurusRenderer extends MobRenderer<EntityTarbosaurus, HumanoidModel<EntityTarbosaurus>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("revival", "textures/entity/tarbosaurus.png");

    public EntityTarbosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTarbosaurus entity) {
        return TEXTURE;
    }
}