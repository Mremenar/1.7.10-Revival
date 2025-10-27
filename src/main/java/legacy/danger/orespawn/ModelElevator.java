// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelElevator extends ModelBase
{
    private float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    
    public ModelElevator() {
        this.wingspeed = 1.0f;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 18)).func_78789_a(-3.0f, 0.0f, -9.0f, 6, 1, 1);
        this.Shape2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape2.func_78787_b(64, 64);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 21)).func_78789_a(-1.0f, 0.0f, -10.0f, 2, 1, 1);
        this.Shape3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape3.func_78787_b(64, 64);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 17, 18)).func_78789_a(-3.0f, 0.0f, 8.0f, 6, 1, 1);
        this.Shape4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape4.func_78787_b(64, 64);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 17, 21)).func_78789_a(-1.0f, 0.0f, 9.0f, 2, 1, 1);
        this.Shape5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape5.func_78787_b(64, 64);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, 0.0f, -8.0f, 8, 1, 16);
        this.Shape1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape1.func_78787_b(64, 64);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.func_78785_a(f5);
        this.Shape2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.Shape4.func_78785_a(f5);
        this.Shape5.func_78785_a(f5);
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
