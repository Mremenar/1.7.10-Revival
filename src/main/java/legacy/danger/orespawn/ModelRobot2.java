// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelRobot2 extends ModelBase
{
    private float wingspeed;
    ModelRenderer rleg1;
    ModelRenderer rleg2;
    ModelRenderer Shape3;
    ModelRenderer lleg2;
    ModelRenderer lleg1;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer rarm3;
    ModelRenderer rarm2;
    ModelRenderer rarm1;
    ModelRenderer larm3;
    ModelRenderer larm2;
    ModelRenderer larm1;
    ModelRenderer head;
    
    public ModelRobot2(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 512;
        (this.rleg1 = new ModelRenderer((ModelBase)this, 10, 250)).func_78789_a(-14.0f, 24.0f, -7.0f, 16, 24, 16);
        this.rleg1.func_78793_a(-10.0f, -24.0f, 0.0f);
        this.rleg1.func_78787_b(256, 512);
        this.rleg1.field_78809_i = true;
        this.setRotation(this.rleg1, 0.0f, 0.0f, 0.0f);
        (this.rleg2 = new ModelRenderer((ModelBase)this, 10, 150)).func_78789_a(-12.0f, 0.0f, -6.0f, 12, 24, 12);
        this.rleg2.func_78793_a(-10.0f, -24.0f, 1.0f);
        this.rleg2.func_78787_b(256, 512);
        this.rleg2.field_78809_i = true;
        this.setRotation(this.rleg2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 10, 50)).func_78789_a(-4.0f, 0.0f, -2.0f, 26, 8, 12);
        this.Shape3.func_78793_a(-9.0f, -32.0f, -3.0f);
        this.Shape3.func_78787_b(256, 512);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.lleg2 = new ModelRenderer((ModelBase)this, 10, 200)).func_78789_a(0.0f, 0.0f, -6.0f, 12, 24, 12);
        this.lleg2.func_78793_a(10.0f, -24.0f, 1.0f);
        this.lleg2.func_78787_b(256, 512);
        this.lleg2.field_78809_i = true;
        this.setRotation(this.lleg2, 0.0f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase)this, 10, 300)).func_78789_a(-2.0f, 24.0f, -7.0f, 16, 24, 16);
        this.lleg1.func_78793_a(10.0f, -24.0f, 0.0f);
        this.lleg1.func_78787_b(256, 512);
        this.lleg1.field_78809_i = true;
        this.setRotation(this.lleg1, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 10, 100)).func_78789_a(-4.0f, -8.0f, -3.0f, 8, 8, 8);
        this.Shape6.func_78793_a(0.0f, -32.0f, 0.0f);
        this.Shape6.func_78787_b(256, 512);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 10, 350)).func_78789_a(0.0f, 0.0f, 0.0f, 26, 8, 12);
        this.Shape7.func_78793_a(-13.0f, -48.0f, -5.0f);
        this.Shape7.func_78787_b(256, 512);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 16, 400)).func_78789_a(0.0f, 0.0f, 0.0f, 44, 18, 14);
        this.Shape8.func_78793_a(-22.0f, -66.0f, -6.0f);
        this.Shape8.func_78787_b(256, 512);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        (this.rarm3 = new ModelRenderer((ModelBase)this, 100, 100)).func_78789_a(-16.0f, -16.0f, -7.0f, 16, 24, 17);
        this.rarm3.func_78793_a(-22.0f, -58.0f, 0.0f);
        this.rarm3.func_78787_b(256, 512);
        this.rarm3.field_78809_i = true;
        this.setRotation(this.rarm3, 0.0f, 0.0f, 0.0f);
        (this.rarm2 = new ModelRenderer((ModelBase)this, 100, 200)).func_78789_a(-14.0f, 8.0f, -5.0f, 12, 24, 12);
        this.rarm2.func_78793_a(-22.0f, -58.0f, 0.0f);
        this.rarm2.func_78787_b(256, 512);
        this.rarm2.field_78809_i = true;
        this.setRotation(this.rarm2, 0.0f, 0.0f, 0.0f);
        (this.rarm1 = new ModelRenderer((ModelBase)this, 100, 300)).func_78789_a(-14.0f, 32.0f, -5.0f, 12, 24, 12);
        this.rarm1.func_78793_a(-22.0f, -58.0f, 0.0f);
        this.rarm1.func_78787_b(256, 512);
        this.rarm1.field_78809_i = true;
        this.setRotation(this.rarm1, 0.0f, 0.0f, 0.0f);
        (this.larm3 = new ModelRenderer((ModelBase)this, 100, 50)).func_78789_a(0.0f, -16.0f, -7.0f, 16, 24, 17);
        this.larm3.func_78793_a(22.0f, -58.0f, 0.0f);
        this.larm3.func_78787_b(256, 512);
        this.larm3.field_78809_i = true;
        this.setRotation(this.larm3, 0.0f, 0.0f, 0.0f);
        (this.larm2 = new ModelRenderer((ModelBase)this, 100, 150)).func_78789_a(2.0f, 8.0f, -5.0f, 12, 24, 12);
        this.larm2.func_78793_a(21.0f, -58.0f, 0.0f);
        this.larm2.func_78787_b(256, 512);
        this.larm2.field_78809_i = true;
        this.setRotation(this.larm2, 0.0f, 0.0f, 0.0f);
        (this.larm1 = new ModelRenderer((ModelBase)this, 100, 250)).func_78789_a(2.0f, 32.0f, -5.0f, 12, 24, 12);
        this.larm1.func_78793_a(21.0f, -58.0f, 0.0f);
        this.larm1.func_78787_b(256, 512);
        this.larm1.field_78809_i = true;
        this.setRotation(this.larm1, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 50, 10)).func_78789_a(-7.0f, -12.0f, -5.0f, 15, 12, 10);
        this.head.func_78793_a(0.0f, -66.0f, 1.0f);
        this.head.func_78787_b(256, 512);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Robot2 e = (Robot2)entity;
        RenderInfo r = null;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.lleg1.field_78795_f = newangle;
        this.lleg2.field_78795_f = newangle;
        this.rleg1.field_78795_f = -newangle;
        this.rleg2.field_78795_f = -newangle;
        this.head.field_78796_g = (float)Math.toRadians(f3);
        newangle = MathHelper.func_76126_a((float)Math.toRadians(f2 * 20.0f * this.wingspeed));
        final float nextangle = MathHelper.func_76126_a((float)Math.toRadians(f2 * 20.0f * this.wingspeed + 1.5f));
        r = e.getRenderInfo();
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = 0;
            }
            else {
                while (r.ri1 == 0) {
                    r.ri1 = e.field_70170_p.field_73012_v.nextInt(4);
                }
            }
        }
        newangle = (float)Math.toRadians(f2 * 20.0f * this.wingspeed);
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.rarm1.field_78795_f = newangle;
            this.rarm2.field_78795_f = newangle;
            this.rarm3.field_78795_f = newangle;
        }
        else {
            this.rarm1.field_78795_f = 0.0f;
            this.rarm2.field_78795_f = 0.0f;
            this.rarm3.field_78795_f = 0.0f;
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.larm1.field_78795_f = newangle;
            this.larm2.field_78795_f = newangle;
            this.larm3.field_78795_f = newangle;
        }
        else {
            this.larm1.field_78795_f = 0.0f;
            this.larm2.field_78795_f = 0.0f;
            this.larm3.field_78795_f = 0.0f;
        }
        e.setRenderInfo(r);
        this.rleg1.func_78785_a(f5);
        this.rleg2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.lleg2.func_78785_a(f5);
        this.lleg1.func_78785_a(f5);
        this.Shape6.func_78785_a(f5);
        this.Shape7.func_78785_a(f5);
        this.Shape8.func_78785_a(f5);
        this.rarm3.func_78785_a(f5);
        this.rarm2.func_78785_a(f5);
        this.rarm1.func_78785_a(f5);
        this.larm3.func_78785_a(f5);
        this.larm2.func_78785_a(f5);
        this.larm1.func_78785_a(f5);
        this.head.func_78785_a(f5);
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
