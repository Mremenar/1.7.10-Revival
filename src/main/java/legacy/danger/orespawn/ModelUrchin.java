// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelUrchin extends ModelBase
{
    private float wingspeed;
    ModelRenderer if1;
    ModelRenderer if2;
    ModelRenderer if3;
    ModelRenderer if4;
    ModelRenderer of1;
    ModelRenderer of2;
    ModelRenderer of3;
    ModelRenderer of4;
    ModelRenderer center;
    ModelRenderer tis1;
    ModelRenderer tis2;
    ModelRenderer tis3;
    ModelRenderer tis4;
    ModelRenderer tos1;
    ModelRenderer tos2;
    ModelRenderer tos3;
    ModelRenderer tos4;
    
    public ModelUrchin(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.if1 = new ModelRenderer((ModelBase)this, 0, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.if1.func_78793_a(0.0f, 16.0f, 0.0f);
        this.if1.func_78787_b(128, 128);
        this.if1.field_78809_i = true;
        this.setRotation(this.if1, 0.2617994f, 0.0f, 0.0f);
        (this.if2 = new ModelRenderer((ModelBase)this, 5, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.if2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.if2.func_78787_b(128, 128);
        this.if2.field_78809_i = true;
        this.setRotation(this.if2, -0.2617994f, 0.0f, 0.0f);
        (this.if3 = new ModelRenderer((ModelBase)this, 10, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.if3.func_78793_a(0.0f, 16.0f, 0.0f);
        this.if3.func_78787_b(128, 128);
        this.if3.field_78809_i = true;
        this.setRotation(this.if3, 0.0f, 0.0f, 0.2617994f);
        (this.if4 = new ModelRenderer((ModelBase)this, 15, 35)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.if4.func_78793_a(0.0f, 16.0f, 0.0f);
        this.if4.func_78787_b(128, 128);
        this.if4.field_78809_i = true;
        this.setRotation(this.if4, 0.0f, 0.0f, -0.2617994f);
        (this.of1 = new ModelRenderer((ModelBase)this, 0, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.of1.func_78793_a(2.0f, 16.0f, 0.0f);
        this.of1.func_78787_b(128, 128);
        this.of1.field_78809_i = true;
        this.setRotation(this.of1, 0.0f, 0.0f, -0.5235988f);
        (this.of2 = new ModelRenderer((ModelBase)this, 5, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.of2.func_78793_a(-2.0f, 16.0f, 0.0f);
        this.of2.func_78787_b(128, 128);
        this.of2.field_78809_i = true;
        this.setRotation(this.of2, 0.0f, 0.0f, 0.5235988f);
        (this.of3 = new ModelRenderer((ModelBase)this, 10, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.of3.func_78793_a(0.0f, 16.0f, -2.0f);
        this.of3.func_78787_b(128, 128);
        this.of3.field_78809_i = true;
        this.setRotation(this.of3, -0.5235988f, 0.0f, 0.0f);
        (this.of4 = new ModelRenderer((ModelBase)this, 15, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.of4.func_78793_a(0.0f, 16.0f, 2.0f);
        this.of4.func_78787_b(128, 128);
        this.of4.field_78809_i = true;
        this.setRotation(this.of4, 0.5235988f, 0.0f, 0.0f);
        (this.center = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -30.0f, 0.0f, 1, 30, 1);
        this.center.func_78793_a(0.0f, 16.0f, 0.0f);
        this.center.func_78787_b(128, 128);
        this.center.field_78809_i = true;
        this.setRotation(this.center, 0.0f, 0.0f, 0.0f);
        (this.tis1 = new ModelRenderer((ModelBase)this, 25, 0)).func_78789_a(0.0f, -25.0f, 0.0f, 1, 25, 1);
        this.tis1.func_78793_a(0.0f, 16.0f, 0.0f);
        this.tis1.func_78787_b(128, 128);
        this.tis1.field_78809_i = true;
        this.setRotation(this.tis1, 0.2617994f, 0.0f, 0.0f);
        (this.tis2 = new ModelRenderer((ModelBase)this, 30, 0)).func_78789_a(0.0f, -25.0f, 0.0f, 1, 25, 1);
        this.tis2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.tis2.func_78787_b(128, 128);
        this.tis2.field_78809_i = true;
        this.setRotation(this.tis2, -0.2617994f, 0.0f, 0.0f);
        (this.tis3 = new ModelRenderer((ModelBase)this, 35, 0)).func_78789_a(0.0f, -25.0f, 0.0f, 1, 25, 1);
        this.tis3.func_78793_a(0.0f, 16.0f, 0.0f);
        this.tis3.func_78787_b(128, 128);
        this.tis3.field_78809_i = true;
        this.setRotation(this.tis3, 0.0f, 0.0f, 0.2617994f);
        (this.tis4 = new ModelRenderer((ModelBase)this, 40, 0)).func_78789_a(0.0f, -25.0f, 0.0f, 1, 25, 1);
        this.tis4.func_78793_a(0.0f, 16.0f, 0.0f);
        this.tis4.func_78787_b(128, 128);
        this.tis4.field_78809_i = true;
        this.setRotation(this.tis4, 0.0f, 0.0f, -0.2617994f);
        (this.tos1 = new ModelRenderer((ModelBase)this, 5, 0)).func_78789_a(0.0f, -20.0f, 0.0f, 1, 20, 1);
        this.tos1.func_78793_a(0.0f, 16.0f, 2.0f);
        this.tos1.func_78787_b(128, 128);
        this.tos1.field_78809_i = true;
        this.setRotation(this.tos1, -0.5235988f, 0.0f, 0.0f);
        (this.tos2 = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-2.0f, -20.0f, 0.0f, 1, 20, 1);
        this.tos2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.tos2.func_78787_b(128, 128);
        this.tos2.field_78809_i = true;
        this.setRotation(this.tos2, 0.0f, 0.0f, -0.5235988f);
        (this.tos3 = new ModelRenderer((ModelBase)this, 15, 0)).func_78789_a(0.0f, -20.0f, 0.0f, 1, 20, 1);
        this.tos3.func_78793_a(2.0f, 16.0f, 0.0f);
        this.tos3.func_78787_b(128, 128);
        this.tos3.field_78809_i = true;
        this.setRotation(this.tos3, 0.0f, 0.0f, 0.5235988f);
        (this.tos4 = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(0.0f, -20.0f, 0.0f, 1, 20, 1);
        this.tos4.func_78793_a(0.0f, 16.0f, -2.0f);
        this.tos4.func_78787_b(128, 128);
        this.tos4.field_78809_i = true;
        this.setRotation(this.tos4, 0.5235988f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Urchin u = (Urchin)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle;
        float newangle2;
        float newangle3;
        float newangle4;
        float newangle5;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle2 = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle3 = MathHelper.func_76134_b(f2 * 1.65f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle4 = MathHelper.func_76134_b(f2 * 1.75f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle5 = MathHelper.func_76134_b(f2 * 1.8f * this.wingspeed) * 3.1415927f * 0.15f * f1;
        }
        else {
            newangle = 0.0f;
            newangle2 = 0.0f;
            newangle3 = 0.0f;
            newangle4 = 0.0f;
            newangle5 = 0.0f;
        }
        this.if1.field_78795_f = 0.261f + newangle2;
        this.if2.field_78795_f = -0.261f - newangle3;
        this.if3.field_78795_f = newangle4;
        this.if4.field_78795_f = -newangle5;
        this.of1.field_78808_h = -0.523f + newangle;
        this.of2.field_78808_h = 0.523f - newangle;
        this.of3.field_78795_f = -0.523f + newangle;
        this.of4.field_78795_f = 0.523f - newangle;
        float newangle6;
        float newangle7;
        float newangle8;
        float newangle9;
        if (u.getAttacking() != 0) {
            newangle = (float)(f2 * 0.2f % 6.283185307179586);
            newangle2 = MathHelper.func_76134_b(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle3 = MathHelper.func_76134_b(f2 * 0.65f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle4 = MathHelper.func_76134_b(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle5 = MathHelper.func_76134_b(f2 * 0.8f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle6 = MathHelper.func_76134_b(f2 * 0.55f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle7 = MathHelper.func_76134_b(f2 * 0.45f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle8 = MathHelper.func_76134_b(f2 * 0.35f * this.wingspeed) * 3.1415927f * 0.06f;
            newangle9 = MathHelper.func_76134_b(f2 * 0.4f * this.wingspeed) * 3.1415927f * 0.06f;
        }
        else {
            newangle = (float)(f2 * 0.02f % 6.283185307179586);
            newangle2 = MathHelper.func_76134_b(f2 * 0.07f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle3 = MathHelper.func_76134_b(f2 * 0.065f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle4 = MathHelper.func_76134_b(f2 * 0.075f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle5 = MathHelper.func_76134_b(f2 * 0.08f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle6 = MathHelper.func_76134_b(f2 * 0.055f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle7 = MathHelper.func_76134_b(f2 * 0.045f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle8 = MathHelper.func_76134_b(f2 * 0.035f * this.wingspeed) * 3.1415927f * 0.02f;
            newangle9 = MathHelper.func_76134_b(f2 * 0.04f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.center.field_78796_g = newangle;
        this.tis1.field_78795_f = 0.261f + newangle2;
        this.tis2.field_78795_f = -0.261f + newangle3;
        this.tis3.field_78795_f = newangle4;
        this.tis4.field_78795_f = newangle5;
        this.tis1.field_78808_h = newangle6;
        this.tis2.field_78808_h = newangle7;
        this.tis3.field_78808_h = 0.261f + newangle8;
        this.tis4.field_78808_h = -0.261f + newangle9;
        this.tos1.field_78795_f = -0.532f + newangle2;
        this.tos2.field_78795_f = newangle8;
        this.tos3.field_78795_f = newangle4;
        this.tos4.field_78795_f = 0.532f + newangle6;
        this.tos1.field_78808_h = newangle5;
        this.tos2.field_78808_h = -0.523f + newangle7;
        this.tos3.field_78808_h = 0.523f + newangle3;
        this.tos4.field_78808_h = newangle9;
        this.if1.func_78785_a(f5);
        this.if2.func_78785_a(f5);
        this.if3.func_78785_a(f5);
        this.if4.func_78785_a(f5);
        this.of1.func_78785_a(f5);
        this.of2.func_78785_a(f5);
        this.of3.func_78785_a(f5);
        this.of4.func_78785_a(f5);
        this.center.func_78785_a(f5);
        this.tis1.func_78785_a(f5);
        this.tis2.func_78785_a(f5);
        this.tis3.func_78785_a(f5);
        this.tis4.func_78785_a(f5);
        this.tos1.func_78785_a(f5);
        this.tos2.func_78785_a(f5);
        this.tos3.func_78785_a(f5);
        this.tos4.func_78785_a(f5);
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
