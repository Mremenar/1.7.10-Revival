// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelLeafMonster extends ModelBase
{
    ModelRenderer body;
    ModelRenderer larm;
    ModelRenderer rarm;
    ModelRenderer lleg;
    ModelRenderer rleg;
    
    public ModelLeafMonster() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.body = new ModelRenderer((ModelBase)this, 32, 32)).func_78789_a(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.larm = new ModelRenderer((ModelBase)this, 64, 0)).func_78789_a(0.0f, -16.0f, -8.0f, 16, 16, 16);
        this.larm.func_78793_a(8.0f, -8.0f, 0.0f);
        this.larm.func_78787_b(64, 32);
        this.larm.field_78809_i = true;
        this.setRotation(this.larm, 0.0f, 0.0f, 0.0f);
        (this.rarm = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-16.0f, -16.0f, -8.0f, 16, 16, 16);
        this.rarm.func_78793_a(-8.0f, -8.0f, 0.0f);
        this.rarm.func_78787_b(64, 32);
        this.rarm.field_78809_i = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.0f);
        (this.lleg = new ModelRenderer((ModelBase)this, 64, 64)).func_78789_a(0.0f, 0.0f, -8.0f, 16, 16, 16);
        this.lleg.func_78793_a(8.0f, 8.0f, 0.0f);
        this.lleg.func_78787_b(64, 32);
        this.lleg.field_78809_i = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase)this, 0, 64)).func_78789_a(-16.0f, 0.0f, -8.0f, 16, 16, 16);
        this.rleg.func_78793_a(-8.0f, 8.0f, 0.0f);
        this.rleg.func_78787_b(64, 32);
        this.rleg.field_78809_i = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final LeafMonster lm = (LeafMonster)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        if (lm.getAttacking() == 0) {
            this.body.field_78797_d = 16.0f;
            this.rarm.field_78797_d = 8.0f;
            this.larm.field_78797_d = 8.0f;
            this.rarm.field_78796_g = 0.0f;
            this.larm.field_78796_g = 0.0f;
            this.rarm.field_78795_f = 0.0f;
            this.larm.field_78795_f = 0.0f;
            this.lleg.field_78795_f = 0.0f;
            this.rleg.field_78795_f = 0.0f;
        }
        else {
            this.body.field_78797_d = 0.0f;
            this.rarm.field_78797_d = -8.0f;
            this.larm.field_78797_d = -8.0f;
            float newangle;
            if (f1 > 0.1) {
                newangle = MathHelper.func_76134_b(f2 * 0.95f) * 3.1415927f * 0.25f * f1;
            }
            else {
                newangle = 0.0f;
            }
            this.lleg.field_78795_f = newangle;
            this.rleg.field_78795_f = -newangle;
            newangle = MathHelper.func_76134_b(f2 * 0.7f) * 3.1415927f * 0.55f;
            this.rarm.field_78796_g = -Math.abs(newangle);
            this.larm.field_78796_g = Math.abs(newangle);
            this.rarm.field_78795_f = -Math.abs(newangle);
            this.larm.field_78795_f = -Math.abs(newangle);
        }
        this.body.func_78785_a(f5);
        this.larm.func_78785_a(f5);
        this.rarm.func_78785_a(f5);
        this.lleg.func_78785_a(f5);
        this.rleg.func_78785_a(f5);
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
