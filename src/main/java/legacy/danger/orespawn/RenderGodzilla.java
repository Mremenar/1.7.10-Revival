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

public class RenderGodzilla extends RenderLiving
{
    protected ModelGodzilla model;
    private float scale;
    private static final ResourceLocation texture;
    
    public RenderGodzilla(final ModelGodzilla par1ModelBase, final float par2, final float par3) {
        super((ModelBase)par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelGodzilla)this.field_77045_g;
        this.scale = par3;
    }
    
    public void renderGodzilla(final Godzilla par1EntityGodzilla, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.func_76986_a((EntityLiving)par1EntityGodzilla, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderGodzilla((Godzilla)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderGodzilla((Godzilla)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void preRenderScale(final Godzilla par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.getPlayNicely() != 0) {
            GL11.glScalef(this.scale / 4.0f, this.scale / 4.0f, this.scale / 4.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Godzilla)par1EntityLiving, par2);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderGodzilla.texture;
    }
    
    static {
        texture = new ResourceLocation("orespawn", "Godzillatexture.png");
    }
}
