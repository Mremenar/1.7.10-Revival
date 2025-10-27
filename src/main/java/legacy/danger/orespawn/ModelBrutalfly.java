// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelBrutalfly extends ModelBase
{
    ModelRenderer body;
    ModelRenderer leftwing;
    ModelRenderer rightwing;
    ModelRenderer leftwing2;
    ModelRenderer rightwing2;
    ModelRenderer leftwing3;
    ModelRenderer rightwing3;
    ModelRenderer head;
    ModelRenderer leftwing4;
    ModelRenderer rightwing4;
    ModelRenderer leftwing5;
    ModelRenderer leftwing6;
    ModelRenderer rightwing5;
    ModelRenderer rightwing6;
    private float wingspeed;
    
    public ModelBrutalfly(final float f1) {
        this.wingspeed = 1.0f;
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.wingspeed = f1;
        (this.body = new ModelRenderer((ModelBase)this, 21, 19)).func_78789_a(0.0f, 0.0f, -4.0f, 1, 1, 8);
        this.body.func_78793_a(0.0f, 17.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leftwing = new ModelRenderer((ModelBase)this, 43, 24)).func_78789_a(0.0f, 0.0f, -4.0f, 1, 1, 5);
        this.leftwing.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing.func_78787_b(64, 32);
        this.leftwing.field_78809_i = true;
        this.setRotation(this.leftwing, 0.0f, 0.0f, 0.0f);
        (this.rightwing = new ModelRenderer((ModelBase)this, 43, 17)).func_78789_a(-1.0f, 0.0f, -4.0f, 1, 1, 5);
        this.rightwing.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing.func_78787_b(64, 32);
        this.rightwing.field_78809_i = true;
        this.setRotation(this.rightwing, 0.0f, 0.0f, 0.0f);
        (this.leftwing2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(1.0f, 0.0f, -6.0f, 6, 1, 7);
        this.leftwing2.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing2.func_78787_b(64, 32);
        this.leftwing2.field_78809_i = true;
        this.setRotation(this.leftwing2, 0.0f, 0.0f, 0.0f);
        (this.rightwing2 = new ModelRenderer((ModelBase)this, 29, 0)).func_78789_a(-7.0f, 0.0f, -6.0f, 6, 1, 7);
        this.rightwing2.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing2.func_78787_b(64, 32);
        this.rightwing2.field_78809_i = true;
        this.setRotation(this.rightwing2, 0.0f, 0.0f, 0.0f);
        (this.leftwing3 = new ModelRenderer((ModelBase)this, 0, 9)).func_78789_a(0.0f, 0.0f, 1.0f, 5, 1, 5);
        this.leftwing3.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing3.func_78787_b(64, 32);
        this.leftwing3.field_78809_i = true;
        this.setRotation(this.leftwing3, 0.0f, 0.0f, 0.0f);
        (this.rightwing3 = new ModelRenderer((ModelBase)this, 27, 9)).func_78789_a(-5.0f, 0.0f, 1.0f, 5, 1, 5);
        this.rightwing3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing3.func_78787_b(64, 32);
        this.rightwing3.field_78809_i = true;
        this.setRotation(this.rightwing3, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 21, 11)).func_78789_a(0.0f, 0.0f, -6.0f, 1, 1, 1);
        this.head.func_78793_a(0.0f, 17.0f, 1.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.leftwing4 = new ModelRenderer((ModelBase)this, 2, 24)).func_78789_a(0.0f, 0.0f, 6.0f, 2, 1, 7);
        this.leftwing4.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing4.func_78787_b(64, 32);
        this.leftwing4.field_78809_i = true;
        this.setRotation(this.leftwing4, 0.0f, 0.0f, 0.0f);
        (this.rightwing4 = new ModelRenderer((ModelBase)this, 2, 16)).func_78789_a(-2.0f, 0.0f, 6.0f, 2, 1, 7);
        this.rightwing4.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing4.func_78787_b(64, 32);
        this.rightwing4.field_78809_i = true;
        this.setRotation(this.rightwing4, 0.0f, 0.0f, 0.0f);
        (this.leftwing5 = new ModelRenderer((ModelBase)this, 21, 16)).func_78789_a(1.0f, 0.0f, -7.0f, 1, 1, 1);
        this.leftwing5.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing5.func_78787_b(64, 32);
        this.leftwing5.field_78809_i = true;
        this.setRotation(this.leftwing5, 0.0f, 0.0f, 0.0f);
        (this.leftwing6 = new ModelRenderer((ModelBase)this, 50, 10)).func_78789_a(7.0f, 0.0f, -6.0f, 2, 1, 1);
        this.leftwing6.func_78793_a(1.0f, 17.0f, 0.0f);
        this.leftwing6.func_78787_b(64, 32);
        this.leftwing6.field_78809_i = true;
        this.setRotation(this.leftwing6, 0.0f, 0.0f, 0.0f);
        (this.rightwing5 = new ModelRenderer((ModelBase)this, 27, 16)).func_78789_a(-2.0f, 0.0f, -7.0f, 1, 1, 1);
        this.rightwing5.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing5.func_78787_b(64, 32);
        this.rightwing5.field_78809_i = true;
        this.setRotation(this.rightwing5, 0.0f, 0.0f, 0.0f);
        (this.rightwing6 = new ModelRenderer((ModelBase)this, 50, 13)).func_78789_a(-9.0f, 0.0f, -6.0f, 2, 1, 1);
        this.rightwing6.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rightwing6.func_78787_b(64, 32);
        this.rightwing6.field_78809_i = true;
        this.setRotation(this.rightwing6, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.rightwing.field_78808_h = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f;
        this.rightwing2.field_78808_h = this.rightwing.field_78808_h;
        this.rightwing3.field_78808_h = this.rightwing.field_78808_h;
        this.rightwing4.field_78808_h = this.rightwing.field_78808_h;
        this.rightwing5.field_78808_h = this.rightwing.field_78808_h;
        this.rightwing6.field_78808_h = this.rightwing.field_78808_h;
        this.leftwing.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing2.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing3.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing4.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing5.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing6.field_78808_h = -this.rightwing.field_78808_h;
        this.leftwing.func_78785_a(f5);
        this.rightwing.func_78785_a(f5);
        this.leftwing2.func_78785_a(f5);
        this.rightwing2.func_78785_a(f5);
        this.leftwing3.func_78785_a(f5);
        this.rightwing3.func_78785_a(f5);
        this.leftwing4.func_78785_a(f5);
        this.rightwing4.func_78785_a(f5);
        this.leftwing5.func_78785_a(f5);
        this.rightwing5.func_78785_a(f5);
        this.leftwing6.func_78785_a(f5);
        this.rightwing6.func_78785_a(f5);
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
