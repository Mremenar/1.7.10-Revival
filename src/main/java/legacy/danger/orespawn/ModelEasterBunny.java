// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelEasterBunny extends ModelBase
{
    private float wingspeed;
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer lfoot;
    ModelRenderer lleg;
    ModelRenderer upperbody;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer lear;
    ModelRenderer lpaw;
    ModelRenderer rleg;
    ModelRenderer rfoot;
    ModelRenderer rear;
    ModelRenderer rpaw;
    
    public ModelEasterBunny(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 128;
        (this.body = new ModelRenderer((ModelBase)this, 0, 44)).func_78789_a(-3.0f, 0.0f, -3.0f, 6, 6, 7);
        this.body.func_78793_a(0.0f, 17.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase)this, 0, 58)).func_78789_a(-2.0f, 0.0f, -2.0f, 4, 4, 4);
        this.tail.func_78793_a(0.0f, 19.0f, 6.0f);
        this.tail.func_78787_b(64, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        (this.lfoot = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(-1.0f, 2.0f, -5.0f, 3, 1, 7);
        this.lfoot.func_78793_a(3.0f, 21.0f, 1.0f);
        this.lfoot.func_78787_b(64, 32);
        this.lfoot.field_78809_i = true;
        this.setRotation(this.lfoot, 0.0f, 0.0f, 0.0f);
        (this.lleg = new ModelRenderer((ModelBase)this, 0, 20)).func_78789_a(0.0f, -2.0f, -2.0f, 1, 4, 5);
        this.lleg.func_78793_a(3.0f, 21.0f, 1.0f);
        this.lleg.func_78787_b(64, 32);
        this.lleg.field_78809_i = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        (this.upperbody = new ModelRenderer((ModelBase)this, 42, 27)).func_78789_a(-2.0f, 0.0f, -2.0f, 4, 1, 5);
        this.upperbody.func_78793_a(0.0f, 16.0f, -1.0f);
        this.upperbody.func_78787_b(64, 32);
        this.upperbody.field_78809_i = true;
        this.setRotation(this.upperbody, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 40, 17)).func_78789_a(-2.5f, 0.0f, -2.0f, 5, 4, 5);
        this.head.func_78793_a(0.0f, 12.0f, -2.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase)this, 44, 9)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 1);
        this.nose.func_78793_a(0.0f, 15.0f, -5.0f);
        this.nose.func_78787_b(64, 32);
        this.nose.field_78809_i = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        (this.lear = new ModelRenderer((ModelBase)this, 54, 0)).func_78789_a(0.0f, -10.0f, -1.0f, 1, 10, 3);
        this.lear.func_78793_a(2.0f, 13.0f, -1.0f);
        this.lear.func_78787_b(64, 32);
        this.lear.field_78809_i = true;
        this.setRotation(this.lear, -0.2268928f, 0.0f, 0.0f);
        (this.lpaw = new ModelRenderer((ModelBase)this, 6, 7)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lpaw.func_78793_a(0.5f, 19.0f, -4.0f);
        this.lpaw.func_78787_b(64, 32);
        this.lpaw.field_78809_i = true;
        this.setRotation(this.lpaw, 0.0f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase)this, 21, 20)).func_78789_a(0.0f, -2.0f, -2.0f, 1, 4, 5);
        this.rleg.func_78793_a(-4.0f, 21.0f, 1.0f);
        this.rleg.func_78787_b(64, 32);
        this.rleg.field_78809_i = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
        (this.rfoot = new ModelRenderer((ModelBase)this, 21, 30)).func_78789_a(-1.0f, 2.0f, -5.0f, 3, 1, 7);
        this.rfoot.func_78793_a(-4.0f, 21.0f, 1.0f);
        this.rfoot.func_78787_b(64, 32);
        this.rfoot.field_78809_i = true;
        this.setRotation(this.rfoot, 0.0f, 0.0f, 0.0f);
        (this.rear = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(0.0f, -10.0f, -1.0f, 1, 10, 3);
        this.rear.func_78793_a(-3.0f, 13.0f, -1.0f);
        this.rear.func_78787_b(64, 32);
        this.rear.field_78809_i = true;
        this.setRotation(this.rear, -0.418879f, 0.0f, 0.0f);
        (this.rpaw = new ModelRenderer((ModelBase)this, 0, 7)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.rpaw.func_78793_a(-1.5f, 19.0f, -4.0f);
        this.rpaw.func_78787_b(64, 32);
        this.rpaw.field_78809_i = true;
        this.setRotation(this.rpaw, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final EasterBunny e = (EasterBunny)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 2.6f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle2 = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        }
        else {
            newangle = 0.0f;
            newangle2 = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.01f;
        }
        final ModelRenderer lleg = this.lleg;
        final ModelRenderer lfoot = this.lfoot;
        final float n = newangle;
        lfoot.field_78795_f = n;
        lleg.field_78795_f = n;
        final ModelRenderer rleg = this.rleg;
        final ModelRenderer rfoot = this.rfoot;
        final float n2 = -newangle;
        rfoot.field_78795_f = n2;
        rleg.field_78795_f = n2;
        this.lear.field_78795_f = -0.226f + newangle2;
        this.rear.field_78795_f = -0.418f - newangle2;
        this.body.func_78785_a(f5);
        this.tail.func_78785_a(f5);
        this.lfoot.func_78785_a(f5);
        this.lleg.func_78785_a(f5);
        this.upperbody.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.nose.func_78785_a(f5);
        this.lear.func_78785_a(f5);
        this.lpaw.func_78785_a(f5);
        this.rleg.func_78785_a(f5);
        this.rfoot.func_78785_a(f5);
        this.rear.func_78785_a(f5);
        this.rpaw.func_78785_a(f5);
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
