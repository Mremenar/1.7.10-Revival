// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFlounder extends ModelBase
{
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer rfin;
    ModelRenderer lfin;
    
    public ModelFlounder() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-4.0f, 0.0f, -5.0f, 8, 1, 12);
        this.body.func_78793_a(0.0f, 22.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 5)).func_78789_a(-2.0f, 0.0f, 0.0f, 4, 1, 2);
        this.head.func_78793_a(0.0f, 22.0f, -7.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 30, 0)).func_78789_a(-2.0f, 0.0f, 0.0f, 4, 1, 2);
        this.tail1.func_78793_a(0.0f, 22.0f, 7.0f);
        this.tail1.func_78787_b(64, 32);
        this.tail1.field_78809_i = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 30, 4)).func_78789_a(-3.0f, 0.0f, 2.0f, 6, 1, 3);
        this.tail2.func_78793_a(0.0f, 22.0f, 7.0f);
        this.tail2.func_78787_b(64, 32);
        this.tail2.field_78809_i = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.rfin = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-3.0f, 0.0f, 0.0f, 3, 1, 2);
        this.rfin.func_78793_a(-4.0f, 22.0f, -2.0f);
        this.rfin.func_78787_b(64, 32);
        this.rfin.field_78809_i = true;
        this.setRotation(this.rfin, 0.0f, 0.0f, 0.0f);
        (this.lfin = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.lfin.func_78793_a(4.0f, 22.0f, -2.0f);
        this.lfin.func_78787_b(64, 32);
        this.lfin.field_78809_i = true;
        this.setRotation(this.lfin, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle;
        float newangle2;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f) * 3.1415927f * 0.25f * f1;
            newangle2 = MathHelper.func_76134_b(f2 * 1.7f) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = 0.0f;
            newangle2 = 0.0f;
        }
        this.lfin.field_78808_h = newangle;
        this.rfin.field_78808_h = newangle2;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.2f) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * 0.7f) * 3.1415927f * 0.05f;
        }
        final ModelRenderer tail1 = this.tail1;
        final ModelRenderer tail2 = this.tail2;
        final float n = newangle;
        tail2.field_78795_f = n;
        tail1.field_78795_f = n;
        this.body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.rfin.func_78785_a(f5);
        this.lfin.func_78785_a(f5);
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
