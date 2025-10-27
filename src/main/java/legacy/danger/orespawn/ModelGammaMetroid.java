// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelGammaMetroid extends ModelBase
{
    private float wingspeed;
    ModelRenderer Shell3;
    ModelRenderer Shell4;
    ModelRenderer Head;
    ModelRenderer BeakUpper;
    ModelRenderer BeakLower;
    ModelRenderer LeftTusk;
    ModelRenderer MiddleTusk;
    ModelRenderer RightTusk;
    ModelRenderer LeftFrontUpperLeg;
    ModelRenderer LeftFrontLowerLeg;
    ModelRenderer LeftRearUpperLeg;
    ModelRenderer LeftRearLowerLeg;
    ModelRenderer RightFrontUpperLeg;
    ModelRenderer RightFrontLowerLeg;
    ModelRenderer RightRearUpperLeg;
    ModelRenderer RightRearLowerLeg;
    ModelRenderer Core;
    ModelRenderer Bellyinside;
    ModelRenderer Bellyoutside;
    ModelRenderer Shell1;
    ModelRenderer Shell2;
    
    public ModelGammaMetroid(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 64;
        (this.Shell3 = new ModelRenderer((ModelBase)this, 128, 0)).func_78789_a(-6.0f, -6.0f, 0.0f, 12, 12, 7);
        this.Shell3.func_78793_a(0.0f, 7.0f, 10.0f);
        this.Shell3.func_78787_b(256, 64);
        this.Shell3.field_78809_i = true;
        this.setRotation(this.Shell3, -0.9599311f, 0.6283185f, 0.5235988f);
        (this.Shell4 = new ModelRenderer((ModelBase)this, 48, 34)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 6, 8);
        this.Shell4.func_78793_a(-3.0f, 9.0f, 13.0f);
        this.Shell4.func_78787_b(256, 64);
        this.Shell4.field_78809_i = true;
        this.setRotation(this.Shell4, -0.2792527f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 48, 48)).func_78789_a(0.0f, 0.0f, 0.0f, 16, 8, 6);
        this.Head.func_78793_a(-8.0f, -1.0f, -11.0f);
        this.Head.func_78787_b(256, 64);
        this.Head.field_78809_i = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.BeakUpper = new ModelRenderer((ModelBase)this, 114, 44)).func_78789_a(-3.0f, 0.0f, -3.0f, 6, 4, 6);
        this.BeakUpper.func_78793_a(0.0f, 5.0f, -11.0f);
        this.BeakUpper.func_78787_b(256, 64);
        this.BeakUpper.field_78809_i = true;
        this.setRotation(this.BeakUpper, 0.1047198f, 0.7853982f, 0.1047198f);
        (this.BeakLower = new ModelRenderer((ModelBase)this, 120, 54)).func_78789_a(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.BeakLower.func_78793_a(0.0f, 9.0f, -12.0f);
        this.BeakLower.func_78787_b(256, 64);
        this.BeakLower.field_78809_i = true;
        this.setRotation(this.BeakLower, 0.1396263f, 0.7853982f, 0.1396263f);
        (this.LeftTusk = new ModelRenderer((ModelBase)this, 76, 50)).func_78789_a(0.0f, 0.0f, -12.0f, 2, 2, 12);
        this.LeftTusk.func_78793_a(5.0f, 6.0f, -10.0f);
        this.LeftTusk.func_78787_b(256, 64);
        this.LeftTusk.field_78809_i = true;
        this.setRotation(this.LeftTusk, 0.1047198f, 0.0872665f, 0.0f);
        (this.MiddleTusk = new ModelRenderer((ModelBase)this, 76, 50)).func_78789_a(-1.0f, 0.0f, -12.0f, 2, 2, 12);
        this.MiddleTusk.func_78793_a(0.0f, -2.0f, -10.0f);
        this.MiddleTusk.func_78787_b(256, 64);
        this.MiddleTusk.field_78809_i = true;
        this.setRotation(this.MiddleTusk, 0.122173f, 0.0f, 0.0f);
        (this.RightTusk = new ModelRenderer((ModelBase)this, 76, 50)).func_78789_a(-2.0f, 0.0f, -12.0f, 2, 2, 12);
        this.RightTusk.func_78793_a(-5.0f, 6.0f, -10.0f);
        this.RightTusk.func_78787_b(256, 64);
        this.RightTusk.field_78809_i = true;
        this.setRotation(this.RightTusk, 0.1047198f, -0.0872665f, 0.0f);
        (this.LeftFrontUpperLeg = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(0.0f, 0.0f, -1.5f, 3, 8, 3);
        this.LeftFrontUpperLeg.func_78793_a(8.0f, 8.0f, -2.0f);
        this.LeftFrontUpperLeg.func_78787_b(256, 64);
        this.LeftFrontUpperLeg.field_78809_i = true;
        this.setRotation(this.LeftFrontUpperLeg, -0.1745329f, 0.0f, -0.6632251f);
        (this.LeftFrontLowerLeg = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.LeftFrontLowerLeg.func_78793_a(14.0f, 13.0f, -3.5f);
        this.LeftFrontLowerLeg.func_78787_b(256, 64);
        this.LeftFrontLowerLeg.field_78809_i = true;
        this.setRotation(this.LeftFrontLowerLeg, -0.2617994f, 0.1396263f, 0.0f);
        (this.LeftRearUpperLeg = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-1.0f, 0.0f, -1.5f, 3, 8, 3);
        this.LeftRearUpperLeg.func_78793_a(8.0f, 9.0f, 7.0f);
        this.LeftRearUpperLeg.func_78787_b(256, 64);
        this.LeftRearUpperLeg.field_78809_i = true;
        this.setRotation(this.LeftRearUpperLeg, 0.1745329f, 0.0f, -0.8203047f);
        (this.LeftRearLowerLeg = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.LeftRearLowerLeg.func_78793_a(14.0f, 14.0f, 8.5f);
        this.LeftRearLowerLeg.func_78787_b(256, 64);
        this.LeftRearLowerLeg.field_78809_i = true;
        this.setRotation(this.LeftRearLowerLeg, 0.3141593f, -0.1570796f, -0.2792527f);
        (this.RightFrontUpperLeg = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-3.0f, 0.0f, -1.5f, 3, 8, 3);
        this.RightFrontUpperLeg.func_78793_a(-8.0f, 8.0f, -2.0f);
        this.RightFrontUpperLeg.func_78787_b(256, 64);
        this.RightFrontUpperLeg.field_78809_i = true;
        this.setRotation(this.RightFrontUpperLeg, -0.1745329f, 0.0f, 0.6632251f);
        (this.RightFrontLowerLeg = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.RightFrontLowerLeg.func_78793_a(-14.0f, 13.0f, -3.5f);
        this.RightFrontLowerLeg.func_78787_b(256, 64);
        this.RightFrontLowerLeg.field_78809_i = true;
        this.setRotation(this.RightFrontLowerLeg, -0.2617994f, -0.1396263f, 0.0f);
        (this.RightRearUpperLeg = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-2.0f, 0.0f, -1.5f, 3, 8, 3);
        this.RightRearUpperLeg.func_78793_a(-8.0f, 9.0f, 7.0f);
        this.RightRearUpperLeg.func_78787_b(256, 64);
        this.RightRearUpperLeg.field_78809_i = true;
        this.setRotation(this.RightRearUpperLeg, 0.1745329f, 0.0f, 0.8203047f);
        (this.RightRearLowerLeg = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.RightRearLowerLeg.func_78793_a(-14.0f, 14.0f, 8.5f);
        this.RightRearLowerLeg.func_78787_b(256, 64);
        this.RightRearLowerLeg.field_78809_i = true;
        this.setRotation(this.RightRearLowerLeg, 0.3141593f, 0.1570796f, 0.2792527f);
        (this.Core = new ModelRenderer((ModelBase)this, 82, 33)).func_78789_a(-3.0f, 0.0f, -3.0f, 6, 6, 6);
        this.Core.func_78793_a(0.0f, 8.0f, 3.0f);
        this.Core.func_78787_b(256, 64);
        this.Core.field_78809_i = true;
        this.setRotation(this.Core, -0.122173f, 0.0f, 0.0f);
        (this.Bellyinside = new ModelRenderer((ModelBase)this, 150, 3)).func_78789_a(-8.0f, -1.0f, -8.0f, 16, 1, 16);
        this.Bellyinside.func_78793_a(0.0f, 8.0f, 2.0f);
        this.Bellyinside.func_78787_b(256, 64);
        this.Bellyinside.field_78809_i = true;
        this.setRotation(this.Bellyinside, -0.122173f, 0.0f, 0.0f);
        (this.Bellyoutside = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-8.0f, -6.0f, -8.0f, 16, 14, 16);
        this.Bellyoutside.func_78793_a(0.0f, 8.0f, 2.0f);
        this.Bellyoutside.func_78787_b(256, 64);
        this.Bellyoutside.field_78809_i = true;
        this.setRotation(this.Bellyoutside, -0.122173f, 0.0f, 0.0f);
        (this.Shell1 = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(-10.0f, -10.0f, 2.0f, 19, 19, 12);
        this.Shell1.func_78793_a(0.0f, 4.0f, -7.0f);
        this.Shell1.func_78787_b(256, 64);
        this.Shell1.field_78809_i = true;
        this.setRotation(this.Shell1, 0.0f, 0.0f, 0.7853982f);
        (this.Shell2 = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(-9.0f, -9.0f, 0.0f, 16, 16, 8);
        this.Shell2.func_78793_a(0.0f, 4.5f, 5.0f);
        this.Shell2.func_78787_b(256, 64);
        this.Shell2.field_78809_i = true;
        this.setRotation(this.Shell2, -0.5235988f, 0.3665191f, 0.715585f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final GammaMetroid e = (GammaMetroid)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.func_76134_b(f2 * 0.81f * this.wingspeed) * 3.1415927f * 0.08f;
        this.LeftTusk.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.87f * this.wingspeed) * 3.1415927f * 0.08f;
        this.RightTusk.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.99f * this.wingspeed) * 3.1415927f * 0.08f;
        this.MiddleTusk.field_78795_f = newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.11f * this.wingspeed) * 3.1415927f * 0.08f;
        this.LeftTusk.field_78796_g = newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.17f * this.wingspeed) * 3.1415927f * 0.08f;
        this.RightTusk.field_78796_g = newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.25f * this.wingspeed) * 3.1415927f * 0.08f;
        this.MiddleTusk.field_78796_g = newangle;
        float nextangle = 0.0f;
        float upangle = 0.0f;
        newangle = MathHelper.func_76134_b(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.func_76134_b((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftFLeg(this.LeftFrontUpperLeg, this.LeftFrontLowerLeg, newangle, upangle);
        this.doRightFLeg(this.RightFrontUpperLeg, this.RightFrontLowerLeg, -newangle, upangle);
        this.doLeftRLeg(this.LeftRearUpperLeg, this.LeftRearLowerLeg, -newangle, upangle);
        this.doRightRLeg(this.RightRearUpperLeg, this.RightRearLowerLeg, newangle, upangle);
        newangle = MathHelper.func_76134_b(f2 * 0.4f * this.wingspeed) * 3.1415927f * 0.05f;
        if (e.func_70906_o()) {
            newangle = 0.0f;
        }
        this.Shell1.field_78795_f = newangle / 4.0f;
        this.Shell1.field_78796_g = -(newangle / 4.0f);
        this.Shell2.field_78795_f = newangle - 0.49f;
        this.Shell2.field_78796_g = -newangle + 0.33f;
        this.Shell3.field_78795_f = newangle - 0.96f;
        this.Shell3.field_78796_g = -newangle + 0.63f;
        this.Shell4.field_78795_f = newangle - 0.28f;
        newangle = MathHelper.func_76134_b(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.1f;
        newangle = Math.abs(newangle);
        this.BeakLower.field_78795_f = newangle + 0.14f;
        this.BeakLower.field_78808_h = newangle + 0.14f;
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.Core.func_78785_a(f5);
        this.Shell3.func_78785_a(f5);
        this.Shell4.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.BeakUpper.func_78785_a(f5);
        this.BeakLower.func_78785_a(f5);
        this.LeftTusk.func_78785_a(f5);
        this.MiddleTusk.func_78785_a(f5);
        this.RightTusk.func_78785_a(f5);
        this.LeftFrontUpperLeg.func_78785_a(f5);
        this.LeftFrontLowerLeg.func_78785_a(f5);
        this.LeftRearUpperLeg.func_78785_a(f5);
        this.LeftRearLowerLeg.func_78785_a(f5);
        this.RightFrontUpperLeg.func_78785_a(f5);
        this.RightFrontLowerLeg.func_78785_a(f5);
        this.RightRearUpperLeg.func_78785_a(f5);
        this.RightRearLowerLeg.func_78785_a(f5);
        this.Bellyinside.func_78785_a(f5);
        this.Shell1.func_78785_a(f5);
        this.Shell2.func_78785_a(f5);
        this.Bellyoutside.func_78785_a(f5);
        GL11.glDisable(3042);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
    }
    
    private void doLeftFLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle, final float upangle) {
        seg2.field_78795_f = angle - 0.17f;
        seg3.field_78795_f = angle - 0.26f;
        seg3.field_78798_e = (float)(seg2.field_78798_e + Math.sin(seg2.field_78795_f) * 7.0) - 0.5f;
        seg2.field_78808_h = -upangle - 0.66f;
        seg3.field_78808_h = -upangle;
        seg3.field_78797_d = seg2.field_78797_d + (float)(5.0 * Math.cos(seg2.field_78795_f));
        seg3.field_78800_c = (float)(seg2.field_78800_c + Math.abs(Math.sin(seg2.field_78808_h) * 7.0) + 1.0);
    }
    
    private void doLeftRLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle, final float upangle) {
        seg2.field_78795_f = angle + 0.17f;
        seg3.field_78795_f = angle + 0.31f;
        seg3.field_78798_e = (float)(seg2.field_78798_e + Math.sin(seg2.field_78795_f) * 7.0) - 0.5f;
        seg2.field_78808_h = -upangle - 0.82f;
        seg3.field_78808_h = -upangle;
        seg3.field_78797_d = seg2.field_78797_d + (float)(5.0 * Math.cos(seg2.field_78795_f));
        seg3.field_78800_c = (float)(seg2.field_78800_c + Math.abs(Math.sin(seg2.field_78808_h) * 7.0) + 1.5);
    }
    
    private void doRightFLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle, final float upangle) {
        seg2.field_78795_f = angle - 0.17f;
        seg3.field_78795_f = angle - 0.26f;
        seg3.field_78798_e = (float)(seg2.field_78798_e + Math.sin(seg2.field_78795_f) * 7.0) - 0.5f;
        seg2.field_78808_h = -upangle + 0.34f;
        seg3.field_78808_h = -upangle;
        seg3.field_78797_d = seg2.field_78797_d + (float)(5.0 * Math.cos(seg2.field_78795_f));
        seg3.field_78800_c = (float)(seg2.field_78800_c - Math.abs(Math.sin(seg2.field_78808_h) * 7.0) - 1.0);
    }
    
    private void doRightRLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle, final float upangle) {
        seg2.field_78795_f = angle + 0.17f;
        seg3.field_78795_f = angle + 0.31f;
        seg3.field_78798_e = (float)(seg2.field_78798_e + Math.sin(seg2.field_78795_f) * 7.0) - 0.5f;
        seg2.field_78808_h = -upangle + 0.82f;
        seg3.field_78808_h = -upangle;
        seg3.field_78797_d = seg2.field_78797_d + (float)(5.0 * Math.cos(seg2.field_78795_f));
        seg3.field_78800_c = (float)(seg2.field_78800_c - Math.abs(Math.sin(seg2.field_78808_h) * 7.0) - 1.5);
    }
}
