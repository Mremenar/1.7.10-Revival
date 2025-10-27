// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCaterKiller extends ModelBase
{
    private float wingspeed;
    ModelRenderer Head;
    ModelRenderer falsehead;
    ModelRenderer seg1;
    ModelRenderer ltusk1;
    ModelRenderer ltusk2;
    ModelRenderer rtusk1;
    ModelRenderer rtusk2;
    ModelRenderer ljaw;
    ModelRenderer rjaw;
    ModelRenderer seg1lspike;
    ModelRenderer seg1rspike;
    ModelRenderer seg1ltopspike;
    ModelRenderer seg1rtopspike;
    ModelRenderer seg1lleg;
    ModelRenderer seg1rleg;
    ModelRenderer seg2;
    ModelRenderer seg2lfoot;
    ModelRenderer seg2rfoot;
    ModelRenderer seg2ltopspike;
    ModelRenderer seg2rtopspike;
    ModelRenderer seg2lspike;
    ModelRenderer seg2rspike;
    ModelRenderer seg3;
    ModelRenderer seg3lfoot;
    ModelRenderer seg3rfoot;
    ModelRenderer seg3lspike;
    ModelRenderer seg3rspike;
    ModelRenderer seg3ltopspike;
    ModelRenderer seg3rtopspike;
    ModelRenderer seg3lbackspike;
    ModelRenderer seg3rbackspike;
    
    public ModelCaterKiller(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 512;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 50)).func_78789_a(-8.0f, -8.0f, -8.0f, 16, 16, 8);
        this.Head.func_78793_a(0.0f, -8.0f, -12.0f);
        this.Head.func_78787_b(64, 32);
        this.Head.field_78809_i = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.falsehead = new ModelRenderer((ModelBase)this, 0, 100)).func_78789_a(-10.0f, -27.0f, -11.0f, 20, 20, 10);
        this.falsehead.func_78793_a(0.0f, -8.0f, -12.0f);
        this.falsehead.func_78787_b(64, 32);
        this.falsehead.field_78809_i = true;
        this.setRotation(this.falsehead, -0.1570796f, 0.0f, 0.0f);
        (this.seg1 = new ModelRenderer((ModelBase)this, 0, 200)).func_78789_a(-14.0f, -31.0f, 0.0f, 28, 32, 14);
        this.seg1.func_78793_a(0.0f, -8.0f, -12.0f);
        this.seg1.func_78787_b(64, 32);
        this.seg1.field_78809_i = true;
        this.setRotation(this.seg1, 0.0f, 0.0f, 0.0f);
        (this.ltusk1 = new ModelRenderer((ModelBase)this, 0, 140)).func_78789_a(-1.0f, -1.0f, -1.0f, 33, 3, 3);
        this.ltusk1.func_78793_a(9.0f, -25.0f, -19.0f);
        this.ltusk1.func_78787_b(64, 32);
        this.ltusk1.field_78809_i = true;
        this.setRotation(this.ltusk1, 0.0f, 0.5585054f, 0.0f);
        (this.ltusk2 = new ModelRenderer((ModelBase)this, 0, 160)).func_78789_a(0.0f, 0.0f, 0.0f, 20, 1, 1);
        this.ltusk2.func_78793_a(36.0f, -25.0f, -36.0f);
        this.ltusk2.func_78787_b(64, 32);
        this.ltusk2.field_78809_i = true;
        this.setRotation(this.ltusk2, 0.0f, 0.8028515f, 0.0f);
        (this.rtusk1 = new ModelRenderer((ModelBase)this, 0, 150)).func_78789_a(-33.0f, 0.0f, 0.0f, 33, 3, 3);
        this.rtusk1.func_78793_a(-8.0f, -25.0f, -17.0f);
        this.rtusk1.func_78787_b(64, 32);
        this.rtusk1.field_78809_i = true;
        this.setRotation(this.rtusk1, 0.0f, -0.5585054f, 0.0f);
        (this.rtusk2 = new ModelRenderer((ModelBase)this, 0, 170)).func_78789_a(-20.0f, 0.0f, 0.0f, 20, 1, 1);
        this.rtusk2.func_78793_a(-36.0f, -24.0f, -34.0f);
        this.rtusk2.func_78787_b(64, 32);
        this.rtusk2.field_78809_i = true;
        this.setRotation(this.rtusk2, 0.0f, -0.8028515f, 0.0f);
        (this.ljaw = new ModelRenderer((ModelBase)this, 100, 50)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 4);
        this.ljaw.func_78793_a(4.0f, -1.0f, -18.0f);
        this.ljaw.func_78787_b(64, 32);
        this.ljaw.field_78809_i = true;
        this.setRotation(this.ljaw, 0.0f, 0.0f, 0.1396263f);
        (this.rjaw = new ModelRenderer((ModelBase)this, 125, 50)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 7, 4);
        this.rjaw.func_78793_a(-5.0f, -1.0f, -18.0f);
        this.rjaw.func_78787_b(64, 32);
        this.rjaw.field_78809_i = true;
        this.setRotation(this.rjaw, 0.0f, 0.0f, -0.1396263f);
        (this.seg1lspike = new ModelRenderer((ModelBase)this, 0, 260)).func_78789_a(-1.0f, -1.0f, -1.0f, 33, 2, 2);
        this.seg1lspike.func_78793_a(14.0f, -32.0f, -6.0f);
        this.seg1lspike.func_78787_b(64, 32);
        this.seg1lspike.field_78809_i = true;
        this.setRotation(this.seg1lspike, 0.0f, 0.3316126f, -0.122173f);
        (this.seg1rspike = new ModelRenderer((ModelBase)this, 0, 270)).func_78789_a(-33.0f, -1.0f, -1.0f, 33, 2, 2);
        this.seg1rspike.func_78793_a(-13.0f, -32.0f, -6.0f);
        this.seg1rspike.func_78787_b(64, 32);
        this.seg1rspike.field_78809_i = true;
        this.setRotation(this.seg1rspike, 0.0f, -0.3316126f, 0.122173f);
        (this.seg1ltopspike = new ModelRenderer((ModelBase)this, 125, 260)).func_78789_a(-2.0f, -8.0f, -2.0f, 4, 9, 4);
        this.seg1ltopspike.func_78793_a(8.0f, -39.0f, -6.0f);
        this.seg1ltopspike.func_78787_b(64, 32);
        this.seg1ltopspike.field_78809_i = true;
        this.setRotation(this.seg1ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg1rtopspike = new ModelRenderer((ModelBase)this, 150, 260)).func_78789_a(-2.0f, -8.0f, -2.0f, 4, 9, 4);
        this.seg1rtopspike.func_78793_a(-10.0f, -39.0f, -6.0f);
        this.seg1rtopspike.func_78787_b(64, 32);
        this.seg1rtopspike.field_78809_i = true;
        this.setRotation(this.seg1rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg1lleg = new ModelRenderer((ModelBase)this, 125, 200)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 16, 2);
        this.seg1lleg.func_78793_a(8.0f, -8.0f, -5.0f);
        this.seg1lleg.func_78787_b(64, 32);
        this.seg1lleg.field_78809_i = true;
        this.setRotation(this.seg1lleg, 0.0f, 0.0f, 0.1570796f);
        (this.seg1rleg = new ModelRenderer((ModelBase)this, 150, 200)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 16, 2);
        this.seg1rleg.func_78793_a(-9.0f, -8.0f, -5.0f);
        this.seg1rleg.func_78787_b(64, 32);
        this.seg1rleg.field_78809_i = true;
        this.setRotation(this.seg1rleg, 0.0f, 0.0f, -0.1570796f);
        (this.seg2 = new ModelRenderer((ModelBase)this, 0, 300)).func_78789_a(-20.0f, -17.0f, -9.0f, 40, 34, 18);
        this.seg2.func_78793_a(0.0f, -2.0f, 32.0f);
        this.seg2.func_78787_b(64, 32);
        this.seg2.field_78809_i = true;
        this.setRotation(this.seg2, 0.0f, 0.0f, 0.0f);
        (this.seg2lfoot = new ModelRenderer((ModelBase)this, 125, 300)).func_78789_a(-5.0f, 0.0f, -5.0f, 10, 10, 10);
        this.seg2lfoot.func_78793_a(13.0f, 14.0f, 32.0f);
        this.seg2lfoot.func_78787_b(64, 32);
        this.seg2lfoot.field_78809_i = true;
        this.setRotation(this.seg2lfoot, 0.0f, 0.0f, 0.0f);
        (this.seg2rfoot = new ModelRenderer((ModelBase)this, 175, 300)).func_78789_a(-5.0f, 0.0f, -5.0f, 10, 10, 10);
        this.seg2rfoot.func_78793_a(-13.0f, 14.0f, 32.0f);
        this.seg2rfoot.func_78787_b(64, 32);
        this.seg2rfoot.field_78809_i = true;
        this.setRotation(this.seg2rfoot, 0.0f, 0.0f, 0.0f);
        (this.seg2ltopspike = new ModelRenderer((ModelBase)this, 100, 360)).func_78789_a(-2.0f, -9.0f, -2.0f, 4, 9, 4);
        this.seg2ltopspike.func_78793_a(14.0f, -18.0f, 32.0f);
        this.seg2ltopspike.func_78787_b(64, 32);
        this.seg2ltopspike.field_78809_i = true;
        this.setRotation(this.seg2ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg2rtopspike = new ModelRenderer((ModelBase)this, 125, 360)).func_78789_a(-2.0f, -9.0f, -2.0f, 4, 9, 4);
        this.seg2rtopspike.func_78793_a(-14.0f, -18.0f, 32.0f);
        this.seg2rtopspike.func_78787_b(64, 32);
        this.seg2rtopspike.field_78809_i = true;
        this.setRotation(this.seg2rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg2lspike = new ModelRenderer((ModelBase)this, 0, 360)).func_78789_a(0.0f, -1.0f, -1.0f, 20, 2, 2);
        this.seg2lspike.func_78793_a(18.0f, -9.0f, 32.0f);
        this.seg2lspike.func_78787_b(64, 32);
        this.seg2lspike.field_78809_i = true;
        this.setRotation(this.seg2lspike, 0.0f, 0.0f, -0.0698132f);
        (this.seg2rspike = new ModelRenderer((ModelBase)this, 0, 370)).func_78789_a(-20.0f, -1.0f, -1.0f, 20, 2, 2);
        this.seg2rspike.func_78793_a(-18.0f, -9.0f, 32.0f);
        this.seg2rspike.func_78787_b(64, 32);
        this.seg2rspike.field_78809_i = true;
        this.setRotation(this.seg2rspike, 0.0f, 0.0f, 0.0698132f);
        (this.seg3 = new ModelRenderer((ModelBase)this, 0, 400)).func_78789_a(-15.0f, -14.0f, -7.0f, 30, 28, 14);
        this.seg3.func_78793_a(0.0f, 3.0f, 48.0f);
        this.seg3.func_78787_b(64, 32);
        this.seg3.field_78809_i = true;
        this.setRotation(this.seg3, 0.0f, 0.0f, 0.0f);
        (this.seg3lfoot = new ModelRenderer((ModelBase)this, 100, 400)).func_78789_a(-4.0f, 0.0f, -6.0f, 8, 8, 12);
        this.seg3lfoot.func_78793_a(10.0f, 16.0f, 48.0f);
        this.seg3lfoot.func_78787_b(64, 32);
        this.seg3lfoot.field_78809_i = true;
        this.setRotation(this.seg3lfoot, 0.0f, 0.0f, 0.0f);
        (this.seg3rfoot = new ModelRenderer((ModelBase)this, 150, 400)).func_78789_a(-4.0f, 0.0f, -6.0f, 8, 8, 12);
        this.seg3rfoot.func_78793_a(-10.0f, 16.0f, 48.0f);
        this.seg3rfoot.func_78787_b(64, 32);
        this.seg3rfoot.field_78809_i = true;
        this.setRotation(this.seg3rfoot, 0.0f, 0.0f, 0.0f);
        (this.seg3lspike = new ModelRenderer((ModelBase)this, 0, 450)).func_78789_a(0.0f, -1.0f, -1.0f, 14, 2, 2);
        this.seg3lspike.func_78793_a(14.0f, -4.0f, 48.0f);
        this.seg3lspike.func_78787_b(64, 32);
        this.seg3lspike.field_78809_i = true;
        this.setRotation(this.seg3lspike, 0.0f, 0.0f, -0.0698132f);
        (this.seg3rspike = new ModelRenderer((ModelBase)this, 0, 460)).func_78789_a(-14.0f, -1.0f, -1.0f, 14, 2, 2);
        this.seg3rspike.func_78793_a(-14.0f, -4.0f, 48.0f);
        this.seg3rspike.func_78787_b(64, 32);
        this.seg3rspike.field_78809_i = true;
        this.setRotation(this.seg3rspike, 0.0f, 0.0f, 0.0698132f);
        (this.seg3ltopspike = new ModelRenderer((ModelBase)this, 100, 450)).func_78789_a(-2.0f, -13.0f, -2.0f, 3, 13, 3);
        this.seg3ltopspike.func_78793_a(10.0f, -10.0f, 48.0f);
        this.seg3ltopspike.func_78787_b(64, 32);
        this.seg3ltopspike.field_78809_i = true;
        this.setRotation(this.seg3ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg3rtopspike = new ModelRenderer((ModelBase)this, 120, 450)).func_78789_a(-2.0f, -13.0f, -2.0f, 3, 13, 3);
        this.seg3rtopspike.func_78793_a(-10.0f, -10.0f, 48.0f);
        this.seg3rtopspike.func_78787_b(64, 32);
        this.seg3rtopspike.field_78809_i = true;
        this.setRotation(this.seg3rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg3lbackspike = new ModelRenderer((ModelBase)this, 50, 450)).func_78789_a(-2.0f, -20.0f, -2.0f, 4, 20, 4);
        this.seg3lbackspike.func_78793_a(13.0f, -8.0f, 54.0f);
        this.seg3lbackspike.func_78787_b(64, 32);
        this.seg3lbackspike.field_78809_i = true;
        this.setRotation(this.seg3lbackspike, -0.9773844f, 0.2792527f, 0.1396263f);
        (this.seg3rbackspike = new ModelRenderer((ModelBase)this, 75, 450)).func_78789_a(-2.0f, -20.0f, -2.0f, 4, 20, 4);
        this.seg3rbackspike.func_78793_a(-13.0f, -8.0f, 54.0f);
        this.seg3rbackspike.func_78787_b(64, 32);
        this.seg3rbackspike.field_78809_i = true;
        this.setRotation(this.seg3rbackspike, -0.9773844f, -0.3490659f, 0.1396263f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final CaterKiller e = (CaterKiller)entity;
        float newangle = 0.0f;
        float headoff = 0.0f;
        float zpi = 0.0f;
        float zdist = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        if (e.getAttacking() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.07f;
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.025f;
        }
        this.ljaw.field_78808_h = 0.139f + newangle;
        this.rjaw.field_78808_h = -0.139f - newangle;
        if (e.getAttacking() != 0) {
            headoff = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 8.0f;
        }
        else {
            headoff = MathHelper.func_76134_b(f2 * 0.3f * this.wingspeed) * 2.0f;
        }
        this.Head.field_78797_d = -8.0f + headoff;
        this.falsehead.field_78797_d = -8.0f + headoff;
        this.ltusk1.field_78797_d = -25.0f + headoff;
        this.ltusk2.field_78797_d = -25.0f + headoff;
        this.rtusk1.field_78797_d = -25.0f + headoff;
        this.rtusk2.field_78797_d = -25.0f + headoff;
        this.ljaw.field_78797_d = -1.0f + headoff;
        this.rjaw.field_78797_d = -1.0f + headoff;
        newangle = MathHelper.func_76134_b(f2 * 2.11f * this.wingspeed) * 3.1415927f * 0.08f;
        this.ltusk2.field_78796_g = 0.802f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.08f;
        this.rtusk2.field_78796_g = -0.802f + newangle;
        this.Head.func_78785_a(f5);
        this.falsehead.func_78785_a(f5);
        this.ltusk1.func_78785_a(f5);
        this.ltusk2.func_78785_a(f5);
        this.rtusk1.func_78785_a(f5);
        this.rtusk2.func_78785_a(f5);
        this.ljaw.func_78785_a(f5);
        this.rjaw.func_78785_a(f5);
        for (int i = 0; i < 3; ++i) {
            this.seg1.field_78797_d = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1lspike.field_78797_d = -32.0f + headoff / (i + 1) + 8 * i;
            this.seg1rspike.field_78797_d = -32.0f + headoff / (i + 1) + 8 * i;
            this.seg1ltopspike.field_78797_d = -39.0f + headoff / (i + 1) + 8 * i;
            this.seg1rtopspike.field_78797_d = -39.0f + headoff / (i + 1) + 8 * i;
            this.seg1lleg.field_78797_d = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1rleg.field_78797_d = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1.field_78798_e = (float)(-12 + 14 * i);
            this.seg1lspike.field_78798_e = (float)(-6 + 14 * i);
            this.seg1rspike.field_78798_e = (float)(-6 + 14 * i);
            this.seg1ltopspike.field_78798_e = (float)(-6 + 14 * i);
            this.seg1rtopspike.field_78798_e = (float)(-6 + 14 * i);
            this.seg1lleg.field_78798_e = (float)(-5 + 14 * i);
            this.seg1rleg.field_78798_e = (float)(-5 + 14 * i);
            newangle = MathHelper.func_76134_b((float)(f2 * 0.91f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f * 0.08f;
            this.seg1lspike.field_78808_h = newangle;
            this.seg1rspike.field_78808_h = -newangle;
            if (e.getAttacking() != 0) {
                newangle = MathHelper.func_76134_b((float)(f2 * 2.91f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f * 0.15f;
            }
            else {
                newangle = MathHelper.func_76134_b((float)(f2 * 0.35f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f * 0.04f;
            }
            this.seg1lleg.field_78795_f = newangle;
            this.seg1rleg.field_78795_f = -newangle;
            this.seg1.func_78785_a(f5);
            this.seg1lspike.func_78785_a(f5);
            this.seg1rspike.func_78785_a(f5);
            this.seg1ltopspike.func_78785_a(f5);
            this.seg1rtopspike.func_78785_a(f5);
            this.seg1lleg.func_78785_a(f5);
            this.seg1rleg.func_78785_a(f5);
        }
        for (int i = 0; i < 6; ++i) {
            zdist = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed + zpi) * 1.5f * f1;
            this.seg2.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2lfoot.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2rfoot.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2ltopspike.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2rtopspike.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2lspike.field_78798_e = 39.0f + (16.0f + zdist) * i;
            this.seg2rspike.field_78798_e = 39.0f + (16.0f + zdist) * i;
            newangle = MathHelper.func_76134_b((float)(f2 * 0.4f * this.wingspeed - 0.39269908169872414 * i)) * 3.1415927f * 0.07f;
            this.seg2lspike.field_78808_h = newangle;
            this.seg2rspike.field_78808_h = -newangle;
            this.seg2.func_78785_a(f5);
            this.seg2lfoot.func_78785_a(f5);
            this.seg2rfoot.func_78785_a(f5);
            this.seg2ltopspike.func_78785_a(f5);
            this.seg2rtopspike.func_78785_a(f5);
            this.seg2lspike.func_78785_a(f5);
            this.seg2rspike.func_78785_a(f5);
            zpi += 0.7853982f;
        }
        this.seg3.field_78798_e = this.seg2rspike.field_78798_e + 16.0f;
        this.seg3lfoot.field_78798_e = this.seg3.field_78798_e;
        this.seg3rfoot.field_78798_e = this.seg3.field_78798_e;
        this.seg3lspike.field_78798_e = this.seg3.field_78798_e;
        this.seg3rspike.field_78798_e = this.seg3.field_78798_e;
        this.seg3ltopspike.field_78798_e = this.seg3.field_78798_e;
        this.seg3rtopspike.field_78798_e = this.seg3.field_78798_e;
        this.seg3lbackspike.field_78798_e = this.seg3.field_78798_e + 6.0f;
        this.seg3rbackspike.field_78798_e = this.seg3.field_78798_e + 6.0f;
        int i = 6;
        newangle = MathHelper.func_76134_b((float)(f2 * 0.4f * this.wingspeed - 0.39269908169872414 * i)) * 3.1415927f * 0.07f;
        this.seg3lspike.field_78808_h = newangle;
        this.seg3rspike.field_78808_h = -newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.81f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3lbackspike.field_78795_f = -0.977f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.87f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3rbackspike.field_78795_f = -0.977f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.11f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3lbackspike.field_78796_g = 0.28f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3rbackspike.field_78796_g = -0.28f + newangle;
        this.seg3.func_78785_a(f5);
        this.seg3lfoot.func_78785_a(f5);
        this.seg3rfoot.func_78785_a(f5);
        this.seg3lspike.func_78785_a(f5);
        this.seg3rspike.func_78785_a(f5);
        this.seg3ltopspike.func_78785_a(f5);
        this.seg3rtopspike.func_78785_a(f5);
        this.seg3lbackspike.func_78785_a(f5);
        this.seg3rbackspike.func_78785_a(f5);
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
