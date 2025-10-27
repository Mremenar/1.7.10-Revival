// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelRotator extends ModelBase
{
    float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    
    public ModelRotator(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(-2.0f, 3.9f, 0.0f, 4, 1, 1);
        this.Shape1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape1.func_78787_b(64, 32);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 7)).func_78789_a(-4.0f, 7.6f, 0.0f, 8, 2, 2);
        this.Shape2.func_78793_a(0.0f, 0.0f, -0.5f);
        this.Shape2.func_78787_b(64, 32);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-7.0f, 13.7f, 0.0f, 14, 3, 3);
        this.Shape3.func_78793_a(0.0f, 0.0f, -1.0f);
        this.Shape3.func_78787_b(64, 32);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Rotator r = (Rotator)entity;
        RenderInfo ri = null;
        float newangle = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        ri = r.getRenderInfo();
        GL11.glRotatef(ri.rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape1.field_78808_h = newangle;
            this.Shape1.func_78785_a(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 1.0f, 0.0f, 0.0f);
        newangle = 0.0f;
        GL11.glRotatef(ri.rf1, 0.0f, 1.0f, 0.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape2.field_78808_h = newangle;
            this.Shape2.func_78785_a(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 0.0f, 1.0f, 0.0f);
        newangle = 0.0f;
        GL11.glRotatef(ri.rf1, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape3.field_78808_h = newangle;
            this.Shape3.func_78785_a(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 0.0f, 0.0f, 1.0f);
        final RenderInfo renderInfo = ri;
        renderInfo.rf1 += 2.0f;
        if (ri.rf1 > 359.0) {
            ri.rf1 = 0.0f;
        }
        r.setRenderInfo(ri);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
    }
}
