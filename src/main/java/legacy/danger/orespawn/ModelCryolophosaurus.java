// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCryolophosaurus extends ModelBase
{
    private float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer jaw;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer rightleg;
    ModelRenderer Shape11;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer rightleg4;
    ModelRenderer leftleg;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer leftleg4;
    
    public ModelCryolophosaurus(final float f1) {
        this.wingspeed = 1.0f;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.wingspeed = f1;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 8, 9, 18);
        this.Shape1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Shape1.func_78787_b(128, 128);
        this.Shape1.field_78809_i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 53, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 4, 11);
        this.Shape2.func_78793_a(1.0f, -2.0f, -7.0f);
        this.Shape2.func_78787_b(128, 128);
        this.Shape2.field_78809_i = true;
        this.setRotation(this.Shape2, -0.2268928f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 41)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 4, 10);
        this.Shape3.func_78793_a(1.0f, -2.0f, -15.0f);
        this.Shape3.func_78787_b(128, 128);
        this.Shape3.field_78809_i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 9, 1);
        this.jaw.func_78793_a(2.0f, 1.0f, -8.0f);
        this.jaw.func_78787_b(128, 128);
        this.jaw.field_78809_i = true;
        this.setRotation(this.jaw, -1.256637f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 91, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 6, 7);
        this.Shape5.func_78793_a(1.0f, 0.0f, 18.0f);
        this.Shape5.func_78787_b(128, 128);
        this.Shape5.field_78809_i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 36, 31)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 4, 14);
        this.Shape6.func_78793_a(2.0f, 0.0f, 25.0f);
        this.Shape6.func_78787_b(128, 128);
        this.Shape6.field_78809_i = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 43, 8)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 4, 2);
        this.Shape7.func_78793_a(-1.0f, 8.0f, 0.0f);
        this.Shape7.func_78787_b(128, 128);
        this.Shape7.field_78809_i = true;
        this.setRotation(this.Shape7, 0.1919862f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 9, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Shape8.func_78793_a(-1.0f, 11.0f, 1.0f);
        this.Shape8.func_78787_b(128, 128);
        this.Shape8.field_78809_i = true;
        this.setRotation(this.Shape8, -0.2617994f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 4, 1);
        this.Shape9.func_78793_a(3.0f, -4.0f, -9.0f);
        this.Shape9.func_78787_b(128, 128);
        this.Shape9.field_78809_i = true;
        this.setRotation(this.Shape9, -0.9424778f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 58)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 10, 6);
        this.rightleg.func_78793_a(-1.0f, 2.0f, 12.0f);
        this.rightleg.func_78787_b(128, 128);
        this.rightleg.field_78809_i = true;
        this.setRotation(this.rightleg, -0.2792527f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 39, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.Shape11.func_78793_a(2.0f, -1.0f, -18.0f);
        this.Shape11.func_78787_b(128, 128);
        this.Shape11.field_78809_i = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase)this, 0, 77)).func_78789_a(0.0f, 7.0f, -5.0f, 2, 10, 3);
        this.rightleg2.func_78793_a(-1.0f, 2.0f, 12.0f);
        this.rightleg2.func_78787_b(128, 128);
        this.rightleg2.field_78809_i = true;
        this.setRotation(this.rightleg2, 0.3839724f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase)this, 35, 31)).func_78789_a(0.0f, 10.0f, 12.0f, 2, 7, 2);
        this.rightleg3.func_78793_a(-1.0f, 2.0f, 12.0f);
        this.rightleg3.func_78787_b(128, 128);
        this.rightleg3.field_78809_i = true;
        this.setRotation(this.rightleg3, -0.6806784f, 0.0f, 0.0f);
        (this.rightleg4 = new ModelRenderer((ModelBase)this, 68, 55)).func_78789_a(0.0f, 20.0f, -5.0f, 2, 2, 6);
        this.rightleg4.func_78793_a(-1.0f, 2.0f, 12.0f);
        this.rightleg4.func_78787_b(128, 128);
        this.rightleg4.field_78809_i = true;
        this.setRotation(this.rightleg4, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 22, 58)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 10, 6);
        this.leftleg.func_78793_a(7.0f, 2.0f, 12.0f);
        this.leftleg.func_78787_b(128, 128);
        this.leftleg.field_78809_i = true;
        this.setRotation(this.leftleg, -0.2792527f, 0.0f, 0.0f);
        (this.Shape16 = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 4, 2);
        this.Shape16.func_78793_a(8.0f, 8.0f, 0.0f);
        this.Shape16.func_78787_b(128, 128);
        this.Shape16.field_78809_i = true;
        this.setRotation(this.Shape16, 0.1919862f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase)this, 9, 9)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Shape17.func_78793_a(8.0f, 11.0f, 1.0f);
        this.Shape17.func_78787_b(128, 128);
        this.Shape17.field_78809_i = true;
        this.setRotation(this.Shape17, -0.2617994f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase)this, 16, 77)).func_78789_a(0.0f, 7.0f, -5.0f, 2, 10, 3);
        this.leftleg2.func_78793_a(7.0f, 2.0f, 12.0f);
        this.leftleg2.func_78787_b(128, 128);
        this.leftleg2.field_78809_i = true;
        this.setRotation(this.leftleg2, 0.3839724f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase)this, 67, 31)).func_78789_a(0.0f, 10.0f, 12.0f, 2, 7, 2);
        this.leftleg3.func_78793_a(7.0f, 2.0f, 12.0f);
        this.leftleg3.func_78787_b(128, 128);
        this.leftleg3.field_78809_i = true;
        this.setRotation(this.leftleg3, -0.6806784f, 0.0f, 0.0f);
        (this.leftleg4 = new ModelRenderer((ModelBase)this, 47, 56)).func_78789_a(0.0f, 20.0f, -5.0f, 2, 2, 6);
        this.leftleg4.func_78793_a(7.0f, 2.0f, 12.0f);
        this.leftleg4.func_78787_b(128, 128);
        this.leftleg4.field_78809_i = true;
        this.setRotation(this.leftleg4, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.rightleg.field_78795_f = -0.2792527f + newangle;
        this.rightleg2.field_78795_f = 0.384f + newangle;
        this.rightleg3.field_78795_f = -0.68f + newangle;
        this.rightleg4.field_78795_f = newangle;
        this.leftleg.field_78795_f = -0.2792527f - newangle;
        this.leftleg2.field_78795_f = 0.384f - newangle;
        this.leftleg3.field_78795_f = -0.68f - newangle;
        this.leftleg4.field_78795_f = -newangle;
        this.jaw.field_78795_f = -1.15f + MathHelper.func_76134_b(f2 * 0.28f) * 3.1415927f * 0.1f;
        this.Shape1.func_78785_a(f5);
        this.Shape2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.jaw.func_78785_a(f5);
        this.Shape5.func_78785_a(f5);
        this.Shape6.func_78785_a(f5);
        this.Shape7.func_78785_a(f5);
        this.Shape8.func_78785_a(f5);
        this.Shape9.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.Shape11.func_78785_a(f5);
        this.rightleg2.func_78785_a(f5);
        this.rightleg3.func_78785_a(f5);
        this.rightleg4.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
        this.Shape16.func_78785_a(f5);
        this.Shape17.func_78785_a(f5);
        this.leftleg2.func_78785_a(f5);
        this.leftleg3.func_78785_a(f5);
        this.leftleg4.func_78785_a(f5);
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
