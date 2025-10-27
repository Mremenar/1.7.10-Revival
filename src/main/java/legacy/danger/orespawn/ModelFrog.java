// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFrog extends ModelBase
{
    private float wingspeed;
    ModelRenderer body;
    ModelRenderer jaw;
    ModelRenderer lfleg;
    ModelRenderer rfleg;
    ModelRenderer lleg1;
    ModelRenderer rleg1;
    ModelRenderer lleg2;
    ModelRenderer rleg2;
    ModelRenderer leye;
    ModelRenderer reye;
    
    public ModelFrog(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.body = new ModelRenderer((ModelBase)this, 41, 0)).func_78789_a(-4.0f, -10.0f, 0.0f, 8, 11, 2);
        this.body.func_78793_a(0.0f, 24.0f, 2.0f);
        this.body.func_78787_b(64, 64);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.7330383f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase)this, 42, 15)).func_78789_a(-4.0f, -8.0f, 0.0f, 8, 8, 1);
        this.jaw.func_78793_a(0.0f, 24.0f, 2.0f);
        this.jaw.func_78787_b(64, 64);
        this.jaw.field_78809_i = true;
        this.setRotation(this.jaw, 1.22173f, 0.0f, 0.0f);
        (this.lfleg = new ModelRenderer((ModelBase)this, 14, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.lfleg.func_78793_a(3.0f, 20.0f, 0.0f);
        this.lfleg.func_78787_b(64, 64);
        this.lfleg.field_78809_i = true;
        this.setRotation(this.lfleg, -0.5235988f, 0.0f, -0.4712389f);
        (this.rfleg = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(-1.0f, 0.0f, 0.0f, 1, 5, 1);
        this.rfleg.func_78793_a(-3.0f, 20.0f, 0.0f);
        this.rfleg.func_78787_b(64, 64);
        this.rfleg.field_78809_i = true;
        this.setRotation(this.rfleg, -0.5235988f, 0.0f, 0.4712389f);
        (this.lleg1 = new ModelRenderer((ModelBase)this, 10, 8)).func_78789_a(0.0f, -9.0f, -1.0f, 1, 9, 2);
        this.lleg1.func_78793_a(3.0f, 24.0f, 3.0f);
        this.lleg1.func_78787_b(64, 64);
        this.lleg1.field_78809_i = true;
        this.setRotation(this.lleg1, 0.0f, 0.0f, 0.2268928f);
        (this.rleg1 = new ModelRenderer((ModelBase)this, 18, 8)).func_78789_a(-1.0f, -9.0f, -1.0f, 1, 9, 2);
        this.rleg1.func_78793_a(-3.0f, 24.0f, 3.0f);
        this.rleg1.func_78787_b(64, 64);
        this.rleg1.field_78809_i = true;
        this.setRotation(this.rleg1, 0.0f, 0.0f, -0.2268928f);
        (this.lleg2 = new ModelRenderer((ModelBase)this, 11, 20)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.lleg2.func_78793_a(5.0f, 15.0f, 3.0f);
        this.lleg2.func_78787_b(64, 64);
        this.lleg2.field_78809_i = true;
        this.setRotation(this.lleg2, 0.0f, 0.0f, -0.3839724f);
        (this.rleg2 = new ModelRenderer((ModelBase)this, 19, 20)).func_78789_a(-1.0f, 0.0f, 0.0f, 1, 10, 1);
        this.rleg2.func_78793_a(-5.0f, 15.0f, 3.0f);
        this.rleg2.func_78787_b(64, 64);
        this.rleg2.field_78809_i = true;
        this.setRotation(this.rleg2, 0.0f, 0.0f, 0.3839724f);
        (this.leye = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.leye.func_78793_a(2.0f, 17.0f, -2.0f);
        this.leye.func_78787_b(64, 64);
        this.leye.field_78809_i = true;
        this.setRotation(this.leye, 0.7330383f, 0.0f, 0.0f);
        (this.reye = new ModelRenderer((ModelBase)this, 0, 4)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.reye.func_78793_a(-3.0f, 17.0f, -2.0f);
        this.reye.func_78787_b(64, 64);
        this.reye.field_78809_i = true;
        this.setRotation(this.reye, 0.7330383f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Frog c = (Frog)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * this.wingspeed * 1.4f) * 3.1415927f * 0.55f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.lfleg.field_78796_g = newangle;
        this.rfleg.field_78796_g = -newangle;
        this.lleg2.field_78796_g = -newangle / 2.0f;
        this.rleg2.field_78796_g = newangle / 2.0f;
        if (c.getSinging() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 0.85f * this.wingspeed) * 3.1415927f * 0.15f;
        }
        else {
            newangle = 0.0f;
        }
        this.jaw.field_78795_f = newangle + 1.22f;
        if (c.field_70181_x > 0.10000000149011612 || c.field_70181_x < -0.10000000149011612) {
            this.lleg1.field_78808_h = 2.44f;
            this.rleg1.field_78808_h = -2.44f;
        }
        else {
            this.lleg1.field_78808_h = 0.227f;
            this.rleg1.field_78808_h = -0.227f;
        }
        this.lleg2.field_78797_d = this.lleg1.field_78797_d - (float)Math.cos(this.lleg1.field_78808_h) * 9.0f;
        this.lleg2.field_78800_c = this.lleg1.field_78800_c + (float)Math.sin(this.lleg1.field_78808_h) * 9.0f;
        this.rleg2.field_78797_d = this.rleg1.field_78797_d - (float)Math.cos(this.rleg1.field_78808_h) * 9.0f;
        this.rleg2.field_78800_c = this.rleg1.field_78800_c + (float)Math.sin(this.rleg1.field_78808_h) * 9.0f;
        this.body.func_78785_a(f5);
        this.jaw.func_78785_a(f5);
        this.lfleg.func_78785_a(f5);
        this.rfleg.func_78785_a(f5);
        this.lleg1.func_78785_a(f5);
        this.rleg1.func_78785_a(f5);
        this.lleg2.func_78785_a(f5);
        this.rleg2.func_78785_a(f5);
        this.leye.func_78785_a(f5);
        this.reye.func_78785_a(f5);
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
