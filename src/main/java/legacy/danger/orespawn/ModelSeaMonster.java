// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelSeaMonster extends ModelBase
{
    private float wingspeed;
    ModelRenderer TailTip;
    ModelRenderer TailBase;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer BodyBack;
    ModelRenderer Neck6;
    ModelRenderer BodyFront;
    ModelRenderer NeckBase;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Neck4;
    ModelRenderer Neck5;
    ModelRenderer BottomJaw;
    ModelRenderer FinBackRight;
    ModelRenderer FinBackLeft;
    ModelRenderer FinFrontLeft;
    ModelRenderer FinFrontRight;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer TopJaw;
    ModelRenderer RightEye;
    ModelRenderer LeftEye;
    
    public ModelSeaMonster(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 128;
        (this.TailTip = new ModelRenderer((ModelBase)this, 158, 36)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 6);
        this.TailTip.func_78793_a(0.0f, 16.0f, 70.0f);
        this.TailTip.func_78787_b(256, 128);
        this.TailTip.field_78809_i = true;
        this.setRotation(this.TailTip, 0.0f, 0.0f, 0.0f);
        (this.TailBase = new ModelRenderer((ModelBase)this, 68, 64)).func_78789_a(-7.0f, -7.0f, 0.0f, 14, 14, 12);
        this.TailBase.func_78793_a(0.0f, 16.0f, 26.0f);
        this.TailBase.func_78787_b(256, 128);
        this.TailBase.field_78809_i = true;
        this.setRotation(this.TailBase, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 74, 90)).func_78789_a(-6.0f, -6.0f, 0.0f, 12, 12, 8);
        this.Tail2.func_78793_a(0.0f, 16.0f, 38.0f);
        this.Tail2.func_78787_b(256, 128);
        this.Tail2.field_78809_i = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase)this, 78, 110)).func_78789_a(-5.0f, -5.0f, 0.0f, 10, 10, 6);
        this.Tail3.func_78793_a(0.0f, 16.0f, 46.0f);
        this.Tail3.func_78787_b(256, 128);
        this.Tail3.field_78809_i = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.BodyBack = new ModelRenderer((ModelBase)this, 62, 32)).func_78789_a(-8.0f, -8.0f, 0.0f, 16, 16, 16);
        this.BodyBack.func_78793_a(0.0f, 16.0f, 10.0f);
        this.BodyBack.func_78787_b(256, 128);
        this.BodyBack.field_78809_i = true;
        this.setRotation(this.BodyBack, 0.0f, 0.0f, 0.0f);
        (this.Neck6 = new ModelRenderer((ModelBase)this, 20, 28)).func_78789_a(-2.0f, -6.0f, -2.0f, 4, 6, 4);
        this.Neck6.func_78793_a(0.0f, -21.0f, -25.0f);
        this.Neck6.func_78787_b(256, 128);
        this.Neck6.field_78809_i = true;
        this.setRotation(this.Neck6, 1.22173f, 0.0f, 0.0f);
        (this.BodyFront = new ModelRenderer((ModelBase)this, 62, 0)).func_78789_a(-8.0f, -8.0f, -16.0f, 16, 16, 16);
        this.BodyFront.func_78793_a(0.0f, 16.0f, 10.0f);
        this.BodyFront.func_78787_b(256, 128);
        this.BodyFront.field_78809_i = true;
        this.setRotation(this.BodyFront, 0.0f, 0.0f, 0.0f);
        (this.NeckBase = new ModelRenderer((ModelBase)this, 8, 96)).func_78789_a(-5.0f, -10.0f, -5.0f, 10, 10, 10);
        this.NeckBase.func_78793_a(0.0f, 12.0f, -2.0f);
        this.NeckBase.func_78787_b(256, 128);
        this.NeckBase.field_78809_i = true;
        this.setRotation(this.NeckBase, 0.7853982f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase)this, 14, 78)).func_78789_a(-3.0f, -10.0f, -4.0f, 6, 10, 8);
        this.Neck2.func_78793_a(0.0f, 6.0f, -9.0f);
        this.Neck2.func_78787_b(256, 128);
        this.Neck2.field_78809_i = true;
        this.setRotation(this.Neck2, 0.6981317f, 0.0f, 0.0f);
        (this.Neck3 = new ModelRenderer((ModelBase)this, 16, 62)).func_78789_a(-3.0f, -10.0f, -3.0f, 6, 10, 6);
        this.Neck3.func_78793_a(0.0f, -1.0f, -15.0f);
        this.Neck3.func_78787_b(256, 128);
        this.Neck3.field_78809_i = true;
        this.setRotation(this.Neck3, 0.5235988f, 0.0f, 0.0f);
        (this.Neck4 = new ModelRenderer((ModelBase)this, 20, 48)).func_78789_a(-2.0f, -10.0f, -2.0f, 4, 10, 4);
        this.Neck4.func_78793_a(0.0f, -9.0f, -20.0f);
        this.Neck4.func_78787_b(256, 128);
        this.Neck4.field_78809_i = true;
        this.setRotation(this.Neck4, 0.2617994f, 0.0f, 0.0f);
        (this.Neck5 = new ModelRenderer((ModelBase)this, 20, 38)).func_78789_a(-2.0f, -6.0f, -2.0f, 4, 6, 4);
        this.Neck5.func_78793_a(0.0f, -17.6f, -22.0f);
        this.Neck5.func_78787_b(256, 128);
        this.Neck5.field_78809_i = true;
        this.setRotation(this.Neck5, 0.7853982f, 0.0f, 0.0f);
        (this.BottomJaw = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-4.0f, 0.0f, -10.0f, 8, 3, 10);
        this.BottomJaw.func_78793_a(0.0f, -23.0f, -29.0f);
        this.BottomJaw.func_78787_b(256, 128);
        this.BottomJaw.field_78809_i = true;
        this.setRotation(this.BottomJaw, 0.1745329f, 0.0f, 0.0f);
        (this.FinBackRight = new ModelRenderer((ModelBase)this, 132, 95)).func_78789_a(-8.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinBackRight.func_78793_a(-7.0f, 16.0f, 16.0f);
        this.FinBackRight.func_78787_b(256, 128);
        this.FinBackRight.field_78809_i = true;
        this.setRotation(this.FinBackRight, -0.5235988f, -0.6981317f, 0.0f);
        (this.FinBackLeft = new ModelRenderer((ModelBase)this, 132, 61)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinBackLeft.func_78793_a(7.0f, 16.0f, 16.0f);
        this.FinBackLeft.func_78787_b(256, 128);
        this.FinBackLeft.field_78809_i = true;
        this.setRotation(this.FinBackLeft, -0.5235988f, 0.6981317f, 0.0f);
        (this.FinFrontLeft = new ModelRenderer((ModelBase)this, 132, 44)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinFrontLeft.func_78793_a(7.0f, 16.0f, -1.0f);
        this.FinFrontLeft.func_78787_b(256, 128);
        this.FinFrontLeft.field_78809_i = true;
        this.setRotation(this.FinFrontLeft, -0.5235988f, 0.6981317f, 0.0f);
        (this.FinFrontRight = new ModelRenderer((ModelBase)this, 132, 78)).func_78789_a(-8.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinFrontRight.func_78793_a(-7.0f, 16.0f, -1.0f);
        this.FinFrontRight.func_78787_b(256, 128);
        this.FinFrontRight.field_78809_i = true;
        this.setRotation(this.FinFrontRight, -0.5235988f, -0.6981317f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase)this, 152, 0)).func_78789_a(-4.0f, -4.0f, 0.0f, 8, 8, 6);
        this.Tail4.func_78793_a(0.0f, 16.0f, 52.0f);
        this.Tail4.func_78787_b(256, 128);
        this.Tail4.field_78809_i = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase)this, 154, 14)).func_78789_a(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.Tail5.func_78793_a(0.0f, 16.0f, 58.0f);
        this.Tail5.func_78787_b(256, 128);
        this.Tail5.field_78809_i = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase)this, 156, 26)).func_78789_a(-2.0f, -2.0f, 0.0f, 4, 4, 6);
        this.Tail6.func_78793_a(0.0f, 16.0f, 64.0f);
        this.Tail6.func_78787_b(256, 128);
        this.Tail6.field_78809_i = true;
        this.setRotation(this.Tail6, 0.0f, 0.0f, 0.0f);
        (this.TopJaw = new ModelRenderer((ModelBase)this, 10, 13)).func_78789_a(-4.0f, -4.0f, -10.0f, 8, 4, 10);
        this.TopJaw.func_78793_a(0.0f, -23.0f, -29.0f);
        this.TopJaw.func_78787_b(256, 128);
        this.TopJaw.field_78809_i = true;
        this.setRotation(this.TopJaw, 0.0f, 0.0f, 0.0f);
        (this.RightEye = new ModelRenderer((ModelBase)this, 46, 16)).func_78789_a(-3.0f, -6.0f, -5.0f, 2, 2, 1);
        this.RightEye.func_78793_a(0.0f, -23.0f, -29.0f);
        this.RightEye.func_78787_b(256, 128);
        this.RightEye.field_78809_i = true;
        this.setRotation(this.RightEye, 0.0f, 0.0f, 0.0f);
        (this.LeftEye = new ModelRenderer((ModelBase)this, 4, 16)).func_78789_a(1.0f, -6.0f, -5.0f, 2, 2, 1);
        this.LeftEye.func_78793_a(0.0f, -23.0f, -29.0f);
        this.LeftEye.func_78787_b(256, 128);
        this.LeftEye.field_78809_i = true;
        this.setRotation(this.LeftEye, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final SeaMonster e = (SeaMonster)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float pi4 = 0.7853982f;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.2f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.TailBase.field_78796_g = newangle / 7.0f;
        this.Tail2.field_78798_e = this.TailBase.field_78798_e + (float)Math.cos(this.TailBase.field_78796_g) * 10.0f;
        this.Tail2.field_78800_c = this.TailBase.field_78800_c + (float)Math.sin(this.TailBase.field_78796_g) * 10.0f;
        this.Tail2.field_78796_g = newangle / 6.0f;
        this.Tail3.field_78798_e = this.Tail2.field_78798_e + (float)Math.cos(this.Tail2.field_78796_g) * 7.0f;
        this.Tail3.field_78800_c = this.Tail2.field_78800_c + (float)Math.sin(this.Tail2.field_78796_g) * 7.0f;
        this.Tail3.field_78796_g = newangle / 5.0f;
        this.Tail4.field_78798_e = this.Tail3.field_78798_e + (float)Math.cos(this.Tail3.field_78796_g) * 5.0f;
        this.Tail4.field_78800_c = this.Tail3.field_78800_c + (float)Math.sin(this.Tail3.field_78796_g) * 5.0f;
        this.Tail4.field_78796_g = newangle / 4.0f;
        this.Tail5.field_78798_e = this.Tail4.field_78798_e + (float)Math.cos(this.Tail4.field_78796_g) * 5.0f;
        this.Tail5.field_78800_c = this.Tail4.field_78800_c + (float)Math.sin(this.Tail4.field_78796_g) * 5.0f;
        this.Tail5.field_78796_g = newangle / 3.0f;
        this.Tail6.field_78798_e = this.Tail5.field_78798_e + (float)Math.cos(this.Tail5.field_78796_g) * 5.0f;
        this.Tail6.field_78800_c = this.Tail5.field_78800_c + (float)Math.sin(this.Tail5.field_78796_g) * 5.0f;
        this.Tail6.field_78796_g = newangle / 2.0f;
        this.TailTip.field_78798_e = this.Tail6.field_78798_e + (float)Math.cos(this.Tail6.field_78796_g) * 5.0f;
        this.TailTip.field_78800_c = this.Tail6.field_78800_c + (float)Math.sin(this.Tail6.field_78796_g) * 5.0f;
        this.TailTip.field_78796_g = newangle;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.2f * f1;
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.FinFrontLeft.field_78795_f = newangle - 0.523f;
        this.FinFrontLeft.field_78796_g = newangle + 0.698f;
        this.FinBackLeft.field_78795_f = -newangle - 0.523f;
        this.FinBackLeft.field_78796_g = -newangle + 0.698f;
        this.FinFrontRight.field_78795_f = newangle - 0.523f;
        this.FinFrontRight.field_78796_g = newangle - 0.698f;
        this.FinBackRight.field_78795_f = -newangle - 0.523f;
        this.FinBackRight.field_78796_g = -newangle - 0.698f;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = 0.455f * f1 + MathHelper.func_76134_b(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.NeckBase.field_78795_f = 0.455f + newangle / 5.0f;
        this.Neck2.field_78798_e = this.NeckBase.field_78798_e - (float)Math.sin(this.NeckBase.field_78795_f) * 9.0f;
        this.Neck2.field_78797_d = this.NeckBase.field_78797_d - (float)Math.cos(this.NeckBase.field_78795_f) * 9.0f;
        this.Neck2.field_78795_f = this.NeckBase.field_78795_f + newangle / 4.0f;
        this.Neck3.field_78798_e = this.Neck2.field_78798_e - (float)Math.sin(this.Neck2.field_78795_f) * 9.0f;
        this.Neck3.field_78797_d = this.Neck2.field_78797_d - (float)Math.cos(this.Neck2.field_78795_f) * 9.0f;
        this.Neck3.field_78795_f = this.Neck2.field_78795_f + newangle / 3.0f;
        this.Neck4.field_78798_e = this.Neck3.field_78798_e - (float)Math.sin(this.Neck3.field_78795_f) * 9.0f;
        this.Neck4.field_78797_d = this.Neck3.field_78797_d - (float)Math.cos(this.Neck3.field_78795_f) * 9.0f;
        this.Neck4.field_78795_f = this.Neck3.field_78795_f + newangle / 2.0f;
        this.Neck5.field_78798_e = this.Neck4.field_78798_e - (float)Math.sin(this.Neck4.field_78795_f) * 9.0f;
        this.Neck5.field_78797_d = this.Neck4.field_78797_d - (float)Math.cos(this.Neck4.field_78795_f) * 9.0f;
        this.Neck5.field_78795_f = this.Neck4.field_78795_f - newangle / 2.0f;
        this.Neck6.field_78798_e = this.Neck5.field_78798_e - (float)Math.sin(this.Neck5.field_78795_f) * 5.0f;
        this.Neck6.field_78797_d = this.Neck5.field_78797_d - (float)Math.cos(this.Neck5.field_78795_f) * 5.0f;
        this.Neck6.field_78795_f = this.Neck5.field_78795_f - newangle / 3.0f;
        final ModelRenderer bottomJaw = this.BottomJaw;
        final ModelRenderer leftEye = this.LeftEye;
        final ModelRenderer rightEye = this.RightEye;
        final ModelRenderer topJaw = this.TopJaw;
        final float n = this.Neck6.field_78798_e - (float)Math.sin(this.Neck6.field_78795_f) * 5.0f;
        topJaw.field_78798_e = n;
        rightEye.field_78798_e = n;
        leftEye.field_78798_e = n;
        bottomJaw.field_78798_e = n;
        final ModelRenderer bottomJaw2 = this.BottomJaw;
        final ModelRenderer leftEye2 = this.LeftEye;
        final ModelRenderer rightEye2 = this.RightEye;
        final ModelRenderer topJaw2 = this.TopJaw;
        final float n2 = this.Neck6.field_78797_d - (float)Math.cos(this.Neck6.field_78795_f) * 5.0f;
        topJaw2.field_78797_d = n2;
        rightEye2.field_78797_d = n2;
        leftEye2.field_78797_d = n2;
        bottomJaw2.field_78797_d = n2;
        newangle = (float)Math.toRadians(f3) * 0.5f;
        final ModelRenderer bottomJaw3 = this.BottomJaw;
        final ModelRenderer leftEye3 = this.LeftEye;
        final ModelRenderer rightEye3 = this.RightEye;
        final ModelRenderer topJaw3 = this.TopJaw;
        final float n3 = newangle;
        topJaw3.field_78796_g = n3;
        rightEye3.field_78796_g = n3;
        leftEye3.field_78796_g = n3;
        bottomJaw3.field_78796_g = n3;
        if (e.getAttacking() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.17f;
            this.BottomJaw.field_78795_f = 0.45f + newangle;
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * 0.2f * this.wingspeed) * 3.1415927f * 0.05f;
            this.BottomJaw.field_78795_f = 0.17f + newangle;
        }
        this.TailTip.func_78785_a(f5);
        this.TailBase.func_78785_a(f5);
        this.Tail2.func_78785_a(f5);
        this.Tail3.func_78785_a(f5);
        this.BodyBack.func_78785_a(f5);
        this.Neck6.func_78785_a(f5);
        this.BodyFront.func_78785_a(f5);
        this.NeckBase.func_78785_a(f5);
        this.Neck2.func_78785_a(f5);
        this.Neck3.func_78785_a(f5);
        this.Neck4.func_78785_a(f5);
        this.Neck5.func_78785_a(f5);
        this.BottomJaw.func_78785_a(f5);
        this.FinBackRight.func_78785_a(f5);
        this.FinBackLeft.func_78785_a(f5);
        this.FinFrontLeft.func_78785_a(f5);
        this.FinFrontRight.func_78785_a(f5);
        this.Tail4.func_78785_a(f5);
        this.Tail5.func_78785_a(f5);
        this.Tail6.func_78785_a(f5);
        this.TopJaw.func_78785_a(f5);
        this.RightEye.func_78785_a(f5);
        this.LeftEye.func_78785_a(f5);
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
