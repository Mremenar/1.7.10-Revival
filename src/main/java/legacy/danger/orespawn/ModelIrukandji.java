// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelIrukandji extends ModelBase
{
    private float wingspeed;
    ModelRenderer body;
    ModelRenderer t11;
    ModelRenderer t12;
    ModelRenderer t21;
    ModelRenderer t22;
    ModelRenderer t31;
    ModelRenderer t32;
    ModelRenderer t41;
    ModelRenderer t42;
    
    public ModelIrukandji(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((ModelBase)this, 0, 9)).func_78789_a(-2.0f, 0.0f, -2.0f, 4, 4, 4);
        this.body.func_78793_a(0.0f, 6.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.t11 = new ModelRenderer((ModelBase)this, 25, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t11.func_78793_a(1.0f, 10.0f, -2.0f);
        this.t11.func_78787_b(64, 32);
        this.t11.field_78809_i = true;
        this.setRotation(this.t11, 0.0f, 0.0f, 0.0f);
        (this.t12 = new ModelRenderer((ModelBase)this, 5, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t12.func_78793_a(1.0f, 17.0f, -2.0f);
        this.t12.func_78787_b(64, 32);
        this.t12.field_78809_i = true;
        this.setRotation(this.t12, 0.0f, 0.0f, 0.0f);
        (this.t21 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t21.func_78793_a(-2.0f, 10.0f, -2.0f);
        this.t21.func_78787_b(64, 32);
        this.t21.field_78809_i = true;
        this.setRotation(this.t21, 0.0f, 0.0f, 0.0f);
        (this.t22 = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t22.func_78793_a(-2.0f, 17.0f, -2.0f);
        this.t22.func_78787_b(64, 32);
        this.t22.field_78809_i = true;
        this.setRotation(this.t22, 0.0f, 0.0f, 0.0f);
        (this.t31 = new ModelRenderer((ModelBase)this, 30, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t31.func_78793_a(1.0f, 10.0f, 1.0f);
        this.t31.func_78787_b(64, 32);
        this.t31.field_78809_i = true;
        this.setRotation(this.t31, 0.0f, 0.0f, 0.0f);
        (this.t32 = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t32.func_78793_a(1.0f, 17.0f, 1.0f);
        this.t32.func_78787_b(64, 32);
        this.t32.field_78809_i = true;
        this.setRotation(this.t32, 0.0f, 0.0f, 0.0f);
        (this.t41 = new ModelRenderer((ModelBase)this, 35, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t41.func_78793_a(-2.0f, 10.0f, 1.0f);
        this.t41.func_78787_b(64, 32);
        this.t41.field_78809_i = true;
        this.setRotation(this.t41, 0.0f, 0.0f, 0.0f);
        (this.t42 = new ModelRenderer((ModelBase)this, 15, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 1);
        this.t42.func_78793_a(-2.0f, 17.0f, 1.0f);
        this.t42.func_78787_b(64, 32);
        this.t42.field_78809_i = true;
        this.setRotation(this.t42, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Irukandji e = (Irukandji)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.t11.field_78795_f = newangle;
        float d1 = (float)(Math.sin(newangle) * 7.0);
        float d2 = (float)(Math.cos(newangle) * 7.0);
        this.t12.field_78798_e = this.t11.field_78798_e + d1;
        newangle = MathHelper.func_76134_b(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.t11.field_78808_h = newangle;
        float d3 = (float)(Math.cos(newangle) * d2);
        float d4 = (float)(Math.sin(newangle) * d2);
        this.t12.field_78800_c = this.t11.field_78800_c - d4;
        this.t12.field_78797_d = this.t11.field_78797_d + d3;
        newangle = MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.15f;
        this.t12.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.25f) * 3.1415927f * 0.1f;
        this.t12.field_78808_h = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.65f) * 3.1415927f * 0.15f;
        this.t21.field_78795_f = newangle;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t22.field_78798_e = this.t21.field_78798_e + d1;
        newangle = MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.1f;
        this.t21.field_78808_h = newangle;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        this.t22.field_78800_c = this.t21.field_78800_c - d4;
        this.t22.field_78797_d = this.t21.field_78797_d + d3;
        newangle = MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.t22.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.t22.field_78808_h = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.5f) * 3.1415927f * 0.15f;
        this.t31.field_78795_f = newangle;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t32.field_78798_e = this.t31.field_78798_e + d1;
        newangle = MathHelper.func_76134_b(f2 * 0.3f) * 3.1415927f * 0.1f;
        this.t31.field_78808_h = newangle;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        this.t32.field_78800_c = this.t31.field_78800_c - d4;
        this.t32.field_78797_d = this.t31.field_78797_d + d3;
        newangle = MathHelper.func_76134_b(f2 * 0.4f) * 3.1415927f * 0.15f;
        this.t32.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.2f) * 3.1415927f * 0.1f;
        this.t32.field_78808_h = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.57f) * 3.1415927f * 0.15f;
        this.t41.field_78795_f = newangle;
        d1 = (float)(Math.sin(newangle) * 7.0);
        d2 = (float)(Math.cos(newangle) * 7.0);
        this.t42.field_78798_e = this.t41.field_78798_e + d1;
        newangle = MathHelper.func_76134_b(f2 * 0.37f) * 3.1415927f * 0.1f;
        this.t41.field_78808_h = newangle;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        this.t42.field_78800_c = this.t41.field_78800_c - d4;
        this.t42.field_78797_d = this.t41.field_78797_d + d3;
        newangle = MathHelper.func_76134_b(f2 * 0.48f) * 3.1415927f * 0.15f;
        this.t42.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.29f) * 3.1415927f * 0.1f;
        this.t42.field_78808_h = newangle;
        this.body.func_78785_a(f5);
        this.t11.func_78785_a(f5);
        this.t12.func_78785_a(f5);
        this.t21.func_78785_a(f5);
        this.t22.func_78785_a(f5);
        this.t31.func_78785_a(f5);
        this.t32.func_78785_a(f5);
        this.t41.func_78785_a(f5);
        this.t42.func_78785_a(f5);
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
