// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelAttackSquid extends ModelBase
{
    private float wingspeed;
    ModelRenderer tent1;
    ModelRenderer tent2;
    ModelRenderer tent3;
    ModelRenderer tent4;
    ModelRenderer tent5;
    ModelRenderer tent6;
    ModelRenderer tent7;
    ModelRenderer body;
    ModelRenderer tent8;
    
    public ModelAttackSquid(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.tent1 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.tent1.func_78793_a(5.0f, 15.0f, -1.0f);
        this.tent1.func_78787_b(64, 32);
        this.tent1.field_78809_i = true;
        this.setRotation(this.tent1, -0.9250245f, -1.745329f, 0.0f);
        (this.tent2 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-8.0f, -1.0f, -1.0f, 8, 2, 2);
        this.tent2.func_78793_a(-2.0f, 15.0f, -3.0f);
        this.tent2.func_78787_b(64, 32);
        this.tent2.field_78809_i = true;
        this.setRotation(this.tent2, -0.1745329f, -0.6632251f, -0.2443461f);
        (this.tent3 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent3.func_78793_a(1.0f, 15.0f, -4.0f);
        this.tent3.func_78787_b(64, 32);
        this.tent3.field_78809_i = true;
        this.setRotation(this.tent3, -1.134464f, 0.3316126f, 0.0f);
        (this.tent4 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent4.func_78793_a(-3.0f, 15.0f, -1.0f);
        this.tent4.func_78787_b(64, 32);
        this.tent4.field_78809_i = true;
        this.setRotation(this.tent4, 0.5585054f, -1.692969f, 0.0f);
        (this.tent5 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent5.func_78793_a(1.0f, 15.0f, 3.0f);
        this.tent5.func_78787_b(64, 32);
        this.tent5.field_78809_i = true;
        this.setRotation(this.tent5, 0.5410521f, 0.2268928f, 0.0f);
        (this.tent6 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 8);
        this.tent6.func_78793_a(-2.0f, 15.0f, 2.0f);
        this.tent6.func_78787_b(64, 32);
        this.tent6.field_78809_i = true;
        this.setRotation(this.tent6, -0.418879f, -0.6806784f, 0.0f);
        (this.tent7 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(0.0f, -1.0f, -1.0f, 8, 2, 2);
        this.tent7.func_78793_a(3.0f, 15.0f, 1.0f);
        this.tent7.func_78787_b(64, 32);
        this.tent7.field_78809_i = true;
        this.setRotation(this.tent7, -0.1919862f, -0.6632251f, 0.418879f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -10.0f, -4.0f, 8, 10, 8);
        this.body.func_78793_a(1.0f, 16.0f, -1.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, -0.1919862f, -0.6806784f, 0.0f);
        (this.tent8 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-1.0f, -1.0f, -8.0f, 2, 2, 8);
        this.tent8.func_78793_a(3.0f, 15.0f, -4.0f);
        this.tent8.func_78787_b(64, 32);
        this.tent8.field_78809_i = true;
        this.setRotation(this.tent8, 0.1919862f, -0.6806784f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final AttackSquid e = (AttackSquid)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangleA = 0.0f;
        float newangleB = 0.0f;
        float newangle8 = 0.0f;
        float newangle9 = 0.0f;
        float newangle10 = 0.0f;
        float newangle11 = 0.0f;
        float newangle12 = 0.0f;
        float newangle13 = 0.0f;
        float newangle14 = 0.0f;
        float newangle15 = 0.0f;
        final float pi4 = 0.7853982f;
        if (f1 > 0.1) {
            newangleA = MathHelper.func_76134_b(f2 * 0.25f * this.wingspeed) * 3.1415927f * 0.04f * f1;
            newangleB = MathHelper.func_76134_b(f2 * 0.39f * this.wingspeed) * 3.1415927f * 0.04f * f1;
            newangle9 = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle10 = MathHelper.func_76134_b(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle11 = MathHelper.func_76134_b(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle12 = MathHelper.func_76134_b(f2 * 1.9f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle13 = MathHelper.func_76134_b(f2 * 1.8f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle14 = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle15 = MathHelper.func_76134_b(f2 * 1.6f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle8 = MathHelper.func_76134_b(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.4f * f1;
        }
        else {
            newangleA = MathHelper.func_76134_b(f2 * 0.25f * this.wingspeed) * 3.1415927f * 0.01f;
            newangleB = MathHelper.func_76134_b(f2 * 0.39f * this.wingspeed) * 3.1415927f * 0.01f;
            newangle9 = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle10 = MathHelper.func_76134_b(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle11 = MathHelper.func_76134_b(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle12 = MathHelper.func_76134_b(f2 * 1.9f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle13 = MathHelper.func_76134_b(f2 * 1.8f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle14 = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle15 = MathHelper.func_76134_b(f2 * 1.6f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle8 = MathHelper.func_76134_b(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.1f;
        }
        this.tent1.field_78795_f = newangle9 - 1.03f;
        this.tent7.field_78808_h = newangle10 + 0.37f;
        this.tent5.field_78795_f = newangle11 + 0.6f;
        this.tent6.field_78795_f = newangle12 - 0.48f;
        this.tent4.field_78795_f = newangle13 + 0.63f;
        this.tent2.field_78808_h = newangle14 - 0.26f;
        this.tent3.field_78795_f = newangle15 - 1.03f;
        this.tent8.field_78795_f = newangle8 + 0.43f;
        this.body.field_78795_f = newangleA;
        this.body.field_78808_h = newangleB;
        newangleA = (float)Math.toRadians(f3) * 0.75f;
        this.body.field_78796_g = newangleA;
        this.tent1.func_78785_a(f5);
        this.tent2.func_78785_a(f5);
        this.tent3.func_78785_a(f5);
        this.tent4.func_78785_a(f5);
        this.tent5.func_78785_a(f5);
        this.tent6.func_78785_a(f5);
        this.tent7.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.tent8.func_78785_a(f5);
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
