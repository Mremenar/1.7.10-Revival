// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelBasilisk extends ModelBase
{
    private float wingspeed;
    ModelRenderer body3;
    ModelRenderer body2;
    ModelRenderer body1;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer neck2;
    ModelRenderer neck1;
    ModelRenderer head;
    ModelRenderer rog_1;
    ModelRenderer rog_2;
    ModelRenderer rog_3;
    ModelRenderer rog_4;
    ModelRenderer rog_5;
    ModelRenderer rog_6;
    ModelRenderer snout;
    ModelRenderer jaw;
    
    public ModelBasilisk(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 64;
        (this.body3 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body3.func_78793_a(-8.0f, 8.0f, 0.0f);
        this.body3.func_78787_b(256, 64);
        this.body3.field_78809_i = true;
        this.setRotation(this.body3, 0.0f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body2.func_78793_a(-8.0f, 4.0f, -10.0f);
        this.body2.func_78787_b(256, 64);
        this.body2.field_78809_i = true;
        this.setRotation(this.body2, -0.2974289f, 0.0f, 0.0f);
        (this.body1 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body1.func_78793_a(-8.0f, 2.0f, -25.0f);
        this.body1.func_78787_b(256, 64);
        this.body1.field_78809_i = true;
        this.setRotation(this.body1, -0.1487144f, 0.0f, 0.0f);
        (this.body4 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body4.func_78793_a(-8.0f, 8.0f, 13.0f);
        this.body4.func_78787_b(256, 64);
        this.body4.field_78809_i = true;
        this.setRotation(this.body4, 0.1487144f, 0.0f, 0.0f);
        (this.body5 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.body5.func_78793_a(-8.0f, 5.8f, 28.8f);
        this.body5.func_78787_b(256, 64);
        this.body5.field_78809_i = true;
        this.setRotation(this.body5, 0.0f, 0.0f, 0.0f);
        (this.body6 = new ModelRenderer((ModelBase)this, 148, 4)).func_78789_a(0.0f, 0.0f, 0.0f, 15, 15, 17);
        this.body6.func_78793_a(-7.5f, 6.166667f, 44.0f);
        this.body6.func_78787_b(256, 64);
        this.body6.field_78809_i = true;
        this.setRotation(this.body6, -0.1115358f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 140, 36)).func_78789_a(0.0f, 0.0f, 0.0f, 13, 13, 15);
        this.tail1.func_78793_a(-6.5f, 9.0f, 58.0f);
        this.tail1.func_78787_b(256, 64);
        this.tail1.field_78809_i = true;
        this.setRotation(this.tail1, 0.1115358f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 64, 41)).func_78789_a(0.0f, 0.0f, 0.0f, 10, 10, 13);
        this.tail2.func_78793_a(-5.0f, 10.0f, 70.0f);
        this.tail2.func_78787_b(256, 64);
        this.tail2.field_78809_i = true;
        this.setRotation(this.tail2, 0.4089647f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 64, 20)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 8, 13);
        this.tail3.func_78793_a(-4.0f, 6.0f, 82.0f);
        this.tail3.func_78787_b(256, 64);
        this.tail3.field_78809_i = true;
        this.setRotation(this.tail3, 0.2230717f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, 64, 1)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 6, 13);
        this.tail4.func_78793_a(-3.0f, 4.0f, 95.0f);
        this.tail4.func_78787_b(256, 64);
        this.tail4.field_78809_i = true;
        this.setRotation(this.tail4, -0.0743572f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.neck2.func_78793_a(-8.0f, -4.9f, -26.0f);
        this.neck2.func_78787_b(256, 64);
        this.neck2.field_78809_i = true;
        this.setRotation(this.neck2, -0.8464847f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase)this, 0, 32)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.neck1.func_78793_a(-8.0f, -15.0f, -29.0f);
        this.neck1.func_78787_b(256, 64);
        this.neck1.field_78809_i = true;
        this.setRotation(this.neck1, -1.181092f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 18, 10);
        this.head.func_78793_a(-8.0f, -21.0f, -30.0f);
        this.head.func_78787_b(256, 64);
        this.head.field_78809_i = true;
        this.setRotation(this.head, -1.404164f, 0.0f, 0.0f);
        (this.rog_1 = new ModelRenderer((ModelBase)this, 110, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 3, 5);
        this.rog_1.func_78793_a(3.0f, -21.0f, -32.0f);
        this.rog_1.func_78787_b(256, 64);
        this.rog_1.field_78809_i = true;
        this.setRotation(this.rog_1, 0.6320364f, 0.2230717f, 0.0f);
        (this.rog_2 = new ModelRenderer((ModelBase)this, 110, 45)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 3, 5);
        this.rog_2.func_78793_a(-6.0f, -21.0f, -32.8f);
        this.rog_2.func_78787_b(256, 64);
        this.rog_2.field_78809_i = true;
        this.setRotation(this.rog_2, 0.6320364f, -0.2230705f, 0.0f);
        (this.rog_3 = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.rog_3.func_78793_a(0.4666667f, -21.0f, -31.0f);
        this.rog_3.func_78787_b(256, 64);
        this.rog_3.field_78809_i = true;
        this.setRotation(this.rog_3, 0.6320364f, 0.2230717f, 0.0f);
        (this.rog_4 = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.rog_4.func_78793_a(-2.466667f, -21.0f, -31.46667f);
        this.rog_4.func_78787_b(256, 64);
        this.rog_4.field_78809_i = true;
        this.setRotation(this.rog_4, 0.6320364f, -0.2230705f, 0.0f);
        (this.rog_5 = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.rog_5.func_78793_a(-8.0f, -17.0f, -32.0f);
        this.rog_5.func_78787_b(256, 64);
        this.rog_5.field_78809_i = true;
        this.setRotation(this.rog_5, 0.6320364f, -0.6692139f, 0.0f);
        (this.rog_6 = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.rog_6.func_78793_a(6.4f, -17.0f, -32.0f);
        this.rog_6.func_78787_b(256, 64);
        this.rog_6.field_78809_i = true;
        this.setRotation(this.rog_6, 0.6320364f, 0.6692116f, 0.0f);
        (this.snout = new ModelRenderer((ModelBase)this, 102, 1)).func_78789_a(0.0f, 0.0f, 0.0f, 14, 16, 9);
        this.snout.func_78793_a(-7.0f, -17.0f, -43.0f);
        this.snout.func_78787_b(256, 64);
        this.snout.field_78809_i = true;
        this.setRotation(this.snout, -1.404164f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase)this, 106, 26)).func_78789_a(0.0f, 0.0f, 0.0f, 14, 16, 3);
        this.jaw.func_78793_a(-7.0f, -11.0f, -39.0f);
        this.jaw.func_78787_b(256, 64);
        this.jaw.field_78809_i = true;
        this.setRotation(this.jaw, -0.8836633f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Basilisk e = (Basilisk)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        }
        else {
            newangle = 0.0f;
        }
        final float pi4 = 0.7853975f;
        this.body1.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        this.body2.field_78798_e = this.body1.field_78798_e + (float)Math.cos(this.body1.field_78796_g) * 12.0f;
        this.body2.field_78800_c = this.body1.field_78800_c + (float)Math.sin(this.body1.field_78796_g) * 12.0f;
        this.body2.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - pi4) * 3.1415927f * 0.1f * f1;
        this.body3.field_78798_e = this.body2.field_78798_e + (float)Math.cos(this.body2.field_78796_g) * 11.0f;
        this.body3.field_78800_c = this.body2.field_78800_c + (float)Math.sin(this.body2.field_78796_g) * 11.0f;
        this.body3.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 2.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.body4.field_78798_e = this.body3.field_78798_e + (float)Math.cos(this.body3.field_78796_g) * 12.0f;
        this.body4.field_78800_c = this.body3.field_78800_c + (float)Math.sin(this.body3.field_78796_g) * 12.0f;
        this.body4.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 3.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.body5.field_78798_e = this.body4.field_78798_e + (float)Math.cos(this.body4.field_78796_g) * 12.0f;
        this.body5.field_78800_c = this.body4.field_78800_c + (float)Math.sin(this.body4.field_78796_g) * 12.0f;
        this.body5.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 4.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.body6.field_78798_e = this.body5.field_78798_e + (float)Math.cos(this.body5.field_78796_g) * 12.0f;
        this.body6.field_78800_c = this.body5.field_78800_c + 0.5f + (float)Math.sin(this.body5.field_78796_g) * 12.0f;
        this.body6.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 5.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.tail1.field_78798_e = this.body6.field_78798_e + (float)Math.cos(this.body6.field_78796_g) * 12.0f;
        this.tail1.field_78800_c = this.body6.field_78800_c + 1.0f + (float)Math.sin(this.body6.field_78796_g) * 12.0f;
        this.tail1.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 6.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.tail2.field_78798_e = this.tail1.field_78798_e + (float)Math.cos(this.tail1.field_78796_g) * 10.0f;
        this.tail2.field_78800_c = this.tail1.field_78800_c + 1.5f + (float)Math.sin(this.tail1.field_78796_g) * 10.0f;
        this.tail2.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 7.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.tail3.field_78798_e = this.tail2.field_78798_e + (float)Math.cos(this.tail2.field_78796_g) * 10.0f;
        this.tail3.field_78800_c = this.tail2.field_78800_c + 1.0f + (float)Math.sin(this.tail2.field_78796_g) * 10.0f;
        this.tail3.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 8.0f * pi4) * 3.1415927f * 0.1f * f1;
        this.tail4.field_78798_e = this.tail3.field_78798_e + (float)Math.cos(this.tail3.field_78796_g) * 10.0f;
        this.tail4.field_78800_c = this.tail3.field_78800_c + 1.0f + (float)Math.sin(this.tail3.field_78796_g) * 10.0f;
        this.tail4.field_78796_g = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed - 9.0f * pi4) * 3.1415927f * 0.1f * f1;
        if (e.getAttacking() != 0) {
            this.jaw.field_78795_f = -1.0f + MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.18f;
        }
        else {
            this.jaw.field_78795_f = -1.1f;
        }
        this.body3.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.body1.func_78785_a(f5);
        this.body4.func_78785_a(f5);
        this.body5.func_78785_a(f5);
        this.body6.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        this.tail4.func_78785_a(f5);
        this.neck2.func_78785_a(f5);
        this.neck1.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.rog_1.func_78785_a(f5);
        this.rog_2.func_78785_a(f5);
        this.rog_3.func_78785_a(f5);
        this.rog_4.func_78785_a(f5);
        this.rog_5.func_78785_a(f5);
        this.rog_6.func_78785_a(f5);
        this.snout.func_78785_a(f5);
        this.jaw.func_78785_a(f5);
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
