// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelRobot5 extends ModelBase
{
    private float wingspeed;
    ModelRenderer lwheel1;
    ModelRenderer lwheel2;
    ModelRenderer rwheel1;
    ModelRenderer rwheel2;
    ModelRenderer axle;
    ModelRenderer drivebox;
    ModelRenderer stand;
    ModelRenderer swivel;
    ModelRenderer barrel1;
    ModelRenderer barrel2;
    ModelRenderer ammobox;
    
    public ModelRobot5(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.lwheel1 = new ModelRenderer((ModelBase)this, 0, 23)).func_78789_a(0.0f, -4.0f, -4.0f, 2, 8, 8);
        this.lwheel1.func_78793_a(6.0f, 19.0f, 0.0f);
        this.lwheel1.func_78787_b(128, 128);
        this.lwheel1.field_78809_i = true;
        this.setRotation(this.lwheel1, 0.0f, 0.0f, 0.0f);
        (this.lwheel2 = new ModelRenderer((ModelBase)this, 0, 43)).func_78789_a(0.0f, -4.0f, -4.0f, 2, 8, 8);
        this.lwheel2.func_78793_a(6.0f, 19.0f, 0.0f);
        this.lwheel2.func_78787_b(128, 128);
        this.lwheel2.field_78809_i = true;
        this.setRotation(this.lwheel2, 0.7853982f, 0.0f, 0.0f);
        (this.rwheel1 = new ModelRenderer((ModelBase)this, 0, 23)).func_78789_a(0.0f, -4.0f, -4.0f, 2, 8, 8);
        this.rwheel1.func_78793_a(-8.0f, 19.0f, 0.0f);
        this.rwheel1.func_78787_b(128, 128);
        this.rwheel1.field_78809_i = true;
        this.setRotation(this.rwheel1, 0.0f, 0.0f, 0.0f);
        (this.rwheel2 = new ModelRenderer((ModelBase)this, 0, 43)).func_78789_a(0.0f, -4.0f, -4.0f, 2, 8, 8);
        this.rwheel2.func_78793_a(-8.0f, 19.0f, 0.0f);
        this.rwheel2.func_78787_b(128, 128);
        this.rwheel2.field_78809_i = true;
        this.setRotation(this.rwheel2, 0.7853982f, 0.0f, 0.0f);
        (this.axle = new ModelRenderer((ModelBase)this, 42, 0)).func_78789_a(-6.0f, -0.5f, -0.5f, 12, 1, 1);
        this.axle.func_78793_a(0.0f, 19.0f, 0.0f);
        this.axle.func_78787_b(128, 128);
        this.axle.field_78809_i = true;
        this.setRotation(this.axle, 0.0f, 0.0f, 0.0f);
        (this.drivebox = new ModelRenderer((ModelBase)this, 47, 4)).func_78789_a(-2.0f, -1.5f, -1.5f, 4, 3, 3);
        this.drivebox.func_78793_a(0.0f, 19.0f, 0.0f);
        this.drivebox.func_78787_b(128, 128);
        this.drivebox.field_78809_i = true;
        this.setRotation(this.drivebox, 0.0f, 0.0f, 0.0f);
        (this.stand = new ModelRenderer((ModelBase)this, 35, 0)).func_78789_a(-0.5f, 0.0f, -0.5f, 1, 18, 1);
        this.stand.func_78793_a(0.0f, 0.0f, 0.0f);
        this.stand.func_78787_b(128, 128);
        this.stand.field_78809_i = true;
        this.setRotation(this.stand, 0.0f, 0.0f, 0.0f);
        (this.swivel = new ModelRenderer((ModelBase)this, 22, 0)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.swivel.func_78793_a(0.0f, 0.0f, 0.0f);
        this.swivel.func_78787_b(128, 128);
        this.swivel.field_78809_i = true;
        this.setRotation(this.swivel, 0.0f, 0.0f, 0.0f);
        (this.barrel1 = new ModelRenderer((ModelBase)this, 24, 25)).func_78789_a(-1.0f, -2.0f, -10.0f, 2, 2, 13);
        this.barrel1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.barrel1.func_78787_b(128, 128);
        this.barrel1.field_78809_i = true;
        this.setRotation(this.barrel1, 0.0f, 0.0f, 0.0f);
        (this.barrel2 = new ModelRenderer((ModelBase)this, 27, 43)).func_78789_a(-0.5f, -1.5f, -19.0f, 1, 1, 9);
        this.barrel2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.barrel2.func_78787_b(128, 128);
        this.barrel2.field_78809_i = true;
        this.setRotation(this.barrel2, 0.0f, 0.0f, 0.0f);
        (this.ammobox = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.0f, -2.0f, 3.0f, 4, 3, 5);
        this.ammobox.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ammobox.func_78787_b(128, 128);
        this.ammobox.field_78809_i = true;
        this.setRotation(this.ammobox, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Robot5 e = (Robot5)entity;
        float newangle = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = f2 * 0.15f % 6.2831855f;
            newangle = Math.abs(newangle);
        }
        else {
            newangle = 0.0f;
        }
        this.lwheel1.field_78795_f = newangle;
        this.lwheel2.field_78795_f = (float)(newangle + 0.7853981633974483);
        this.rwheel1.field_78795_f = newangle;
        this.rwheel2.field_78795_f = (float)(newangle + 0.7853981633974483);
        final ModelRenderer barrel1 = this.barrel1;
        final ModelRenderer barrel2 = this.barrel2;
        final ModelRenderer ammobox = this.ammobox;
        final float field_78796_g = (float)Math.toRadians(f3 / 2.0);
        ammobox.field_78796_g = field_78796_g;
        barrel2.field_78796_g = field_78796_g;
        barrel1.field_78796_g = field_78796_g;
        this.lwheel1.func_78785_a(f5);
        this.lwheel2.func_78785_a(f5);
        this.rwheel1.func_78785_a(f5);
        this.rwheel2.func_78785_a(f5);
        this.axle.func_78785_a(f5);
        this.drivebox.func_78785_a(f5);
        this.stand.func_78785_a(f5);
        this.swivel.func_78785_a(f5);
        this.barrel1.func_78785_a(f5);
        this.barrel2.func_78785_a(f5);
        this.ammobox.func_78785_a(f5);
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
