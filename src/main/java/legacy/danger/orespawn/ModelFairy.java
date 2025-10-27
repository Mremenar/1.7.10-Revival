// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFairy extends ModelBase
{
    private float wingspeed;
    ModelRenderer head;
    ModelRenderer chest;
    ModelRenderer waist;
    ModelRenderer hips;
    ModelRenderer lleg1;
    ModelRenderer lleg2;
    ModelRenderer rleg;
    ModelRenderer b1;
    ModelRenderer b2;
    ModelRenderer larm;
    ModelRenderer rarm;
    ModelRenderer lwing2;
    ModelRenderer lwing1;
    ModelRenderer rwing2;
    ModelRenderer rwing1;
    
    public ModelFairy(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.5f, -5.0f, -2.5f, 5, 5, 5);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78787_b(64, 64);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.chest = new ModelRenderer((ModelBase)this, 31, 5)).func_78789_a(-3.5f, 0.0f, -1.0f, 7, 4, 3);
        this.chest.func_78793_a(0.0f, 0.0f, 0.0f);
        this.chest.func_78787_b(64, 64);
        this.chest.field_78809_i = true;
        this.setRotation(this.chest, 0.0f, 0.0f, 0.0f);
        (this.waist = new ModelRenderer((ModelBase)this, 33, 13)).func_78789_a(-2.5f, 4.0f, -1.0f, 5, 3, 3);
        this.waist.func_78793_a(0.0f, 0.0f, 0.0f);
        this.waist.func_78787_b(64, 64);
        this.waist.field_78809_i = true;
        this.setRotation(this.waist, 0.0f, 0.0f, 0.0f);
        (this.hips = new ModelRenderer((ModelBase)this, 31, 20)).func_78789_a(-3.0f, 7.0f, -1.0f, 6, 4, 4);
        this.hips.func_78793_a(0.0f, 0.0f, 0.0f);
        this.hips.func_78787_b(64, 64);
        this.hips.field_78809_i = true;
        this.setRotation(this.hips, 0.0f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase)this, 53, 8)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 7, 2);
        this.lleg1.func_78793_a(1.0f, 10.0f, 0.0f);
        this.lleg1.func_78787_b(64, 64);
        this.lleg1.field_78809_i = true;
        this.setRotation(this.lleg1, -0.7853982f, 0.0f, 0.0f);
        (this.lleg2 = new ModelRenderer((ModelBase)this, 53, 18)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 8, 2);
        this.lleg2.func_78793_a(1.0f, 15.0f, -5.0f);
        this.lleg2.func_78787_b(64, 64);
        this.lleg2.field_78809_i = true;
        this.setRotation(this.lleg2, 0.7679449f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase)this, 51, 30)).func_78789_a(-3.0f, 0.0f, 0.0f, 2, 13, 2);
        this.rleg.func_78793_a(0.0f, 11.0f, 0.0f);
        this.rleg.func_78787_b(64, 64);
        this.rleg.field_78809_i = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
        (this.b1 = new ModelRenderer((ModelBase)this, 42, 1)).func_78789_a(1.0f, 1.0f, -2.0f, 2, 2, 1);
        this.b1.func_78793_a(0.0f, 1.0f, 0.0f);
        this.b1.func_78787_b(64, 64);
        this.b1.field_78809_i = true;
        this.setRotation(this.b1, 0.0f, 0.0f, 0.0f);
        (this.b2 = new ModelRenderer((ModelBase)this, 32, 1)).func_78789_a(-3.0f, 2.0f, -2.0f, 2, 2, 1);
        this.b2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.b2.func_78787_b(64, 64);
        this.b2.field_78809_i = true;
        this.setRotation(this.b2, 0.0f, 0.0f, 0.0f);
        (this.larm = new ModelRenderer((ModelBase)this, 7, 14)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.larm.func_78793_a(3.0f, 0.0f, 0.0f);
        this.larm.func_78787_b(64, 64);
        this.larm.field_78809_i = true;
        this.setRotation(this.larm, -0.0174533f, 0.0f, -0.122173f);
        (this.rarm = new ModelRenderer((ModelBase)this, 2, 14)).func_78789_a(-1.0f, 0.0f, 0.0f, 1, 10, 1);
        this.rarm.func_78793_a(-3.0f, 0.0f, 0.0f);
        this.rarm.func_78787_b(64, 64);
        this.rarm.field_78809_i = true;
        this.setRotation(this.rarm, -0.0174533f, 0.0f, 0.122173f);
        (this.lwing2 = new ModelRenderer((ModelBase)this, 0, 47)).func_78789_a(0.0f, -9.0f, 0.0f, 26, 16, 0);
        this.lwing2.func_78793_a(2.0f, 0.0f, 2.0f);
        this.lwing2.func_78787_b(64, 64);
        this.lwing2.field_78809_i = true;
        this.setRotation(this.lwing2, 0.0f, -0.5934119f, 0.0f);
        (this.lwing1 = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(0.0f, -7.0f, 0.0f, 24, 16, 0);
        this.lwing1.func_78793_a(2.0f, 3.0f, 2.0f);
        this.lwing1.func_78787_b(64, 64);
        this.lwing1.field_78809_i = true;
        this.setRotation(this.lwing1, 0.0f, -0.8203047f, 0.0f);
        (this.rwing2 = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(0.0f, -7.0f, 0.0f, 24, 16, 0);
        this.rwing2.func_78793_a(-2.0f, 3.0f, 2.0f);
        this.rwing2.func_78787_b(64, 64);
        this.rwing2.field_78809_i = true;
        this.setRotation(this.rwing2, 0.0f, -2.356194f, 0.0f);
        (this.rwing1 = new ModelRenderer((ModelBase)this, 0, 47)).func_78789_a(0.0f, -9.0f, 0.0f, 26, 16, 0);
        this.rwing1.func_78793_a(-2.0f, 0.0f, 2.0f);
        this.rwing1.func_78787_b(64, 64);
        this.rwing1.field_78809_i = true;
        this.setRotation(this.rwing1, 0.0f, -2.548181f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Fairy fly = (Fairy)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float onoff = 0.0f;
        this.lwing1.field_78796_g = -0.6f + MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.35f;
        this.rwing1.field_78796_g = -2.55f - MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.35f;
        this.lwing2.field_78796_g = -0.6f + MathHelper.func_76134_b(f2 * this.wingspeed * 0.85f) * 3.1415927f * 0.25f;
        this.rwing2.field_78796_g = -2.55f - MathHelper.func_76134_b(f2 * this.wingspeed * 0.85f) * 3.1415927f * 0.25f;
        this.head.field_78796_g = (float)Math.toRadians(f3) * 0.45f;
        if (this.head.field_78796_g > 0.45f) {
            this.head.field_78796_g = 0.45f;
        }
        if (this.head.field_78796_g < -0.45f) {
            this.head.field_78796_g = -0.45f;
        }
        this.head.field_78795_f = (float)Math.toRadians(f4);
        this.larm.field_78795_f = -0.2f + MathHelper.func_76134_b(f2 * this.wingspeed * 0.15f) * 3.1415927f * 0.05f;
        this.rarm.field_78795_f = -0.2f + MathHelper.func_76134_b(f2 * this.wingspeed * 0.12f) * 3.1415927f * 0.05f;
        this.larm.field_78808_h = -0.15f + MathHelper.func_76134_b(f2 * this.wingspeed * 0.1f) * 3.1415927f * 0.03f;
        this.rarm.field_78808_h = 0.15f + MathHelper.func_76134_b(f2 * this.wingspeed * 0.11f) * 3.1415927f * 0.03f;
        this.lwing2.func_78785_a(f5);
        this.lwing1.func_78785_a(f5);
        this.rwing2.func_78785_a(f5);
        this.rwing1.func_78785_a(f5);
        onoff = fly.getBlink();
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, onoff, 240.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.head.func_78785_a(f5);
        this.chest.func_78785_a(f5);
        this.waist.func_78785_a(f5);
        this.hips.func_78785_a(f5);
        this.lleg1.func_78785_a(f5);
        this.lleg2.func_78785_a(f5);
        this.rleg.func_78785_a(f5);
        this.b1.func_78785_a(f5);
        this.b2.func_78785_a(f5);
        this.larm.func_78785_a(f5);
        this.rarm.func_78785_a(f5);
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
