// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelAlosaurus extends ModelBase
{
    private float wingspeed;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer jaw;
    ModelRenderer leftleg;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer Shape11;
    ModelRenderer rightleg;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer leftleg4;
    ModelRenderer rightleg4;
    ModelRenderer Shape17;
    
    public ModelAlosaurus(final float f1) {
        this.wingspeed = 1.0f;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.wingspeed = f1;
        (this.Shape18 = new ModelRenderer((ModelBase)this, 91, 114)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape18.func_78793_a(3.3f, -25.0f, -27.0f);
        this.Shape18.func_78787_b(128, 128);
        this.Shape18.field_78809_i = true;
        this.setRotation(this.Shape18, 0.5759587f, 0.0f, 0.5585054f);
        (this.Shape19 = new ModelRenderer((ModelBase)this, 71, 114)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape19.func_78793_a(-4.0f, -24.0f, -28.0f);
        this.Shape19.func_78787_b(128, 128);
        this.Shape19.field_78809_i = true;
        this.setRotation(this.Shape19, 0.5759587f, 0.0f, -0.5585054f);
        (this.Shape20 = new ModelRenderer((ModelBase)this, 91, 30)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape20.func_78793_a(5.0f, -8.0f, -6.0f);
        this.Shape20.func_78787_b(128, 128);
        this.Shape20.field_78809_i = true;
        this.setRotation(this.Shape20, 0.3839724f, 0.0f, 0.0f);
        (this.Shape21 = new ModelRenderer((ModelBase)this, 93, 46)).func_78789_a(-2.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape21.func_78793_a(-4.0f, -8.0f, -6.0f);
        this.Shape21.func_78787_b(128, 128);
        this.Shape21.field_78809_i = true;
        this.setRotation(this.Shape21, 0.3839724f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-7.0f, 0.0f, 0.0f, 10, 18, 31);
        this.Shape1.func_78793_a(2.5f, -19.0f, -8.0f);
        this.Shape1.func_78787_b(128, 128);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 62, 0)).func_78789_a(-5.0f, 0.0f, 0.0f, 10, 11, 11);
        this.Shape2.func_78793_a(0.5f, -19.0f, 23.0f);
        this.Shape2.func_78787_b(128, 128);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 10, 54)).func_78789_a(-3.0f, 0.0f, 0.0f, 7, 7, 25);
        this.Shape3.func_78793_a(0.0f, -19.0f, 34.0f);
        this.Shape3.func_78787_b(128, 128);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 68, 88)).func_78789_a(-5.0f, 0.0f, 0.0f, 8, 9, 16);
        this.Shape4.func_78793_a(1.5f, -25.0f, -16.0f);
        this.Shape4.func_78787_b(128, 128);
        this.Shape4.field_78809_i = true;
        this.setRotation(this.Shape4, -0.4014257f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 75, 65)).func_78789_a(0.0f, 0.0f, 0.0f, 9, 9, 12);
        this.Shape5.func_78793_a(-4.0f, -25.0f, -27.0f);
        this.Shape5.func_78787_b(128, 128);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 0, 50)).func_78789_a(0.0f, 0.0f, 0.0f, 7, 9, 9);
        this.Shape6.func_78793_a(-3.0f, -25.0f, -36.0f);
        this.Shape6.func_78787_b(128, 128);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase)this, 0, 86)).func_78789_a(-5.0f, 0.0f, -10.0f, 7, 1, 13);
        this.jaw.func_78793_a(2.0f, -15.0f, -24.0f);
        this.jaw.func_78787_b(128, 128);
        this.jaw.field_78809_i = true;
        this.setRotation(this.jaw, 0.5201081f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.0f, 0.0f, 0.0f, 3, 16, 10);
        this.leftleg.func_78793_a(6.0f, -10.0f, 11.0f);
        this.leftleg.func_78787_b(128, 128);
        this.leftleg.field_78809_i = true;
        this.setRotation(this.leftleg, -0.1745329f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase)this, 0, 106)).func_78789_a(-1.0f, 12.0f, -8.0f, 3, 15, 5);
        this.leftleg2.func_78793_a(6.0f, -10.0f, 11.0f);
        this.leftleg2.func_78787_b(128, 128);
        this.leftleg2.field_78809_i = true;
        this.setRotation(this.leftleg2, 0.5061455f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase)this, 112, 89)).func_78789_a(-1.0f, 19.0f, 16.0f, 3, 9, 3);
        this.leftleg3.func_78793_a(6.0f, -10.0f, 11.0f);
        this.leftleg3.func_78787_b(128, 128);
        this.leftleg3.field_78809_i = true;
        this.setRotation(this.leftleg3, -0.4014257f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 0, 72)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape11.func_78793_a(5.0f, -5.0f, -3.0f);
        this.Shape11.func_78787_b(128, 128);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, -0.5235988f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 54, 51)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 16, 10);
        this.rightleg.func_78793_a(-7.0f, -10.0f, 11.0f);
        this.rightleg.func_78787_b(128, 128);
        this.rightleg.field_78809_i = true;
        this.setRotation(this.rightleg, -0.1745329f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase)this, 23, 106)).func_78789_a(0.0f, 12.0f, -8.0f, 3, 15, 5);
        this.rightleg2.func_78793_a(-7.0f, -10.0f, 11.0f);
        this.rightleg2.func_78787_b(128, 128);
        this.rightleg2.field_78809_i = true;
        this.setRotation(this.rightleg2, 0.5061455f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase)this, 70, 90)).func_78789_a(0.0f, 19.0f, 16.0f, 3, 9, 3);
        this.rightleg3.func_78793_a(-7.0f, -10.0f, 11.0f);
        this.rightleg3.func_78787_b(128, 128);
        this.rightleg3.field_78809_i = true;
        this.setRotation(this.rightleg3, -0.4014257f, 0.0f, 0.0f);
        (this.leftleg4 = new ModelRenderer((ModelBase)this, 42, 113)).func_78789_a(-1.0f, 31.0f, -1.0f, 3, 3, 8);
        this.leftleg4.func_78793_a(6.0f, -10.0f, 11.0f);
        this.leftleg4.func_78787_b(128, 128);
        this.leftleg4.field_78809_i = true;
        this.setRotation(this.leftleg4, 0.0f, 0.0f, 0.0f);
        (this.rightleg4 = new ModelRenderer((ModelBase)this, 44, 93)).func_78789_a(0.0f, 31.0f, -1.0f, 3, 3, 8);
        this.rightleg4.func_78793_a(-7.0f, -10.0f, 11.0f);
        this.rightleg4.func_78787_b(128, 128);
        this.rightleg4.field_78809_i = true;
        this.setRotation(this.rightleg4, 0.0f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase)this, 112, 60)).func_78789_a(-2.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape17.func_78793_a(-4.0f, -3.533333f, -3.0f);
        this.Shape17.func_78787_b(128, 128);
        this.Shape17.field_78809_i = true;
        this.setRotation(this.Shape17, -0.5235988f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Alosaurus e = (Alosaurus)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.rightleg.field_78795_f = -0.174f + newangle;
        this.rightleg2.field_78795_f = 0.506f + newangle;
        this.rightleg3.field_78795_f = -0.401f + newangle;
        this.rightleg4.field_78795_f = newangle;
        this.leftleg.field_78795_f = -0.174f - newangle;
        this.leftleg2.field_78795_f = 0.506f - newangle;
        this.leftleg3.field_78795_f = -0.401f - newangle;
        this.leftleg4.field_78795_f = -newangle;
        if (e.getAttacking() != 0) {
            this.jaw.field_78795_f = 0.52f + MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.18f;
        }
        else {
            this.jaw.field_78795_f = 0.1f;
        }
        this.Shape17.field_78795_f = -0.523f + MathHelper.func_76134_b(f2 * 0.1f) * 3.1415927f * 0.05f;
        this.Shape11.field_78795_f = -0.523f + MathHelper.func_76134_b(f2 * 0.1f) * 3.1415927f * 0.05f;
        this.Shape18.func_78785_a(f5);
        this.Shape19.func_78785_a(f5);
        this.Shape20.func_78785_a(f5);
        this.Shape21.func_78785_a(f5);
        this.Shape1.func_78785_a(f5);
        this.Shape2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.Shape4.func_78785_a(f5);
        this.Shape5.func_78785_a(f5);
        this.Shape6.func_78785_a(f5);
        this.jaw.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
        this.leftleg2.func_78785_a(f5);
        this.leftleg3.func_78785_a(f5);
        this.Shape11.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.rightleg2.func_78785_a(f5);
        this.rightleg3.func_78785_a(f5);
        this.leftleg4.func_78785_a(f5);
        this.rightleg4.func_78785_a(f5);
        this.Shape17.func_78785_a(f5);
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
