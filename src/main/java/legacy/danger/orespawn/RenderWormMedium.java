// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderWormMedium extends RenderLiving
{
    protected ModelWormMedium model;
    private float scale;
    private static final ResourceLocation texture;
    
    public RenderWormMedium(final ModelWormMedium par1ModelBase, final float par2, final float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelWormMedium)this.field_77045_g;
        this.scale = par3;
    }
    
    public void renderWormMedium(final WormMedium par1WormMedium, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.func_76986_a((EntityLiving)par1WormMedium, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderWormMedium((WormMedium)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderWormMedium((WormMedium)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void preRenderScale(final WormMedium par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((WormMedium)par1EntityLiving, par2);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderWormMedium.texture;
    }
    
    static {
        texture = new ResourceLocation("orespawn", "WormMediumtexture.png");
    }
}
