// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderBoyfriend extends RenderBiped
{
    protected ModelBiped model;
    
    public RenderBoyfriend(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelBiped)this.field_77045_g;
    }
    
    public void renderBoyfriend(final Boyfriend par1EntityBoyfriend, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.func_76986_a((EntityLiving)par1EntityBoyfriend, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderBoyfriend((Boyfriend)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderBoyfriend((Boyfriend)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        final Boyfriend g = (Boyfriend)entity;
        return g.getTexture();
    }
}
