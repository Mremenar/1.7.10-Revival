// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCassowary extends ModelBase
{
    private float wingspeed;
    ModelRenderer tail;
    ModelRenderer body;
    ModelRenderer neck1;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer beak;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer crest;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer gobbler;
    
    public ModelCassowary(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.tail = new ModelRenderer((ModelBase)this, 38, 16)).func_78789_a(-3.0f, 0.0f, 0.0f, 6, 9, 7);
        this.tail.func_78793_a(0.0f, 8.0f, 1.0f);
        this.tail.func_78787_b(64, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.8922867f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 13)).func_78789_a(-4.0f, 0.0f, 0.0f, 8, 10, 9);
        this.body.func_78793_a(0.0f, 5.0f, -3.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.3346075f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-2.0f, 0.0f, 0.0f, 4, 5, 4);
        this.neck1.func_78793_a(0.0f, 4.0f, -1.0f);
        this.neck1.func_78787_b(64, 32);
        this.neck1.field_78809_i = true;
        this.setRotation(this.neck1, -1.189716f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 38, 0)).func_78789_a(-1.0f, 0.0f, 0.0f, 2, 7, 2);
        this.neck.func_78793_a(0.0f, 8.0f, -3.0f);
        this.neck.func_78787_b(64, 32);
        this.neck.field_78809_i = true;
        this.setRotation(this.neck, -2.806985f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-1.0f, -2.0f, -3.0f, 2, 2, 4);
        this.head.func_78793_a(0.0f, 2.0f, -6.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0371786f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase)this, 28, 7)).func_78789_a(-0.5f, 0.0f, 3.0f, 1, 1, 3);
        this.beak.func_78793_a(0.0f, 2.0f, -6.0f);
        this.beak.func_78787_b(64, 32);
        this.beak.field_78809_i = true;
        this.setRotation(this.beak, -3.104414f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-0.5f, 0.0f, -1.0f, 1, 11, 2);
        this.leg1.func_78793_a(3.0f, 12.0f, 3.0f);
        this.leg1.func_78787_b(64, 32);
        this.leg1.field_78809_i = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-0.5f, 0.0f, -1.0f, 1, 11, 2);
        this.leg2.func_78793_a(-3.0f, 12.0f, 3.0f);
        this.leg2.func_78787_b(64, 32);
        this.leg2.field_78809_i = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.crest = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-0.5f, -4.0f, 1.0f, 1, 4, 5);
        this.crest.func_78793_a(0.0f, 2.0f, -6.0f);
        this.crest.func_78787_b(64, 32);
        this.crest.field_78809_i = true;
        this.setRotation(this.crest, 1.710216f, 0.0f, 0.0f);
        (this.foot1 = new ModelRenderer((ModelBase)this, 47, 10)).func_78789_a(-1.033333f, 11.0f, -2.0f, 2, 1, 3);
        this.foot1.func_78793_a(-3.0f, 12.0f, 3.0f);
        this.foot1.func_78787_b(64, 32);
        this.foot1.field_78809_i = true;
        this.setRotation(this.foot1, 0.0f, 0.0f, 0.0f);
        (this.foot2 = new ModelRenderer((ModelBase)this, 47, 10)).func_78789_a(-1.0f, 11.0f, -2.0f, 2, 1, 3);
        this.foot2.func_78793_a(3.0f, 12.0f, 3.0f);
        this.foot2.func_78787_b(64, 32);
        this.foot2.field_78809_i = true;
        this.setRotation(this.foot2, 0.0f, 0.0f, 0.0f);
        (this.gobbler = new ModelRenderer((ModelBase)this, 38, 10)).func_78789_a(-0.5f, -1.0f, -2.5f, 1, 5, 1);
        this.gobbler.func_78793_a(0.0f, 8.0f, -3.0f);
        this.gobbler.func_78787_b(64, 32);
        this.gobbler.field_78809_i = true;
        this.setRotation(this.gobbler, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Cassowary e = (Cassowary)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle2 = MathHelper.func_76134_b(f2 * 2.6f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        }
        else {
            newangle2 = (newangle = 0.0f);
        }
        final ModelRenderer leg1 = this.leg1;
        final ModelRenderer foot2 = this.foot2;
        final float n = newangle;
        foot2.field_78795_f = n;
        leg1.field_78795_f = n;
        final ModelRenderer leg2 = this.leg2;
        final ModelRenderer foot3 = this.foot1;
        final float n2 = -newangle;
        foot3.field_78795_f = n2;
        leg2.field_78795_f = n2;
        this.neck.field_78795_f = -2.827f + newangle2;
        this.gobbler.field_78795_f = newangle2;
        final ModelRenderer head = this.head;
        final ModelRenderer crest = this.crest;
        final ModelRenderer beak = this.beak;
        final float field_78798_e = this.neck.field_78798_e + MathHelper.func_76126_a(this.neck.field_78795_f) * 7.0f;
        beak.field_78798_e = field_78798_e;
        crest.field_78798_e = field_78798_e;
        head.field_78798_e = field_78798_e;
        final ModelRenderer head2 = this.head;
        final ModelRenderer crest2 = this.crest;
        final ModelRenderer beak2 = this.beak;
        final float field_78797_d = this.neck.field_78797_d + MathHelper.func_76134_b(this.neck.field_78795_f) * 7.0f;
        beak2.field_78797_d = field_78797_d;
        crest2.field_78797_d = field_78797_d;
        head2.field_78797_d = field_78797_d;
        this.tail.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.neck1.func_78785_a(f5);
        this.neck.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.beak.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.crest.func_78785_a(f5);
        this.foot1.func_78785_a(f5);
        this.foot2.func_78785_a(f5);
        this.gobbler.func_78785_a(f5);
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
