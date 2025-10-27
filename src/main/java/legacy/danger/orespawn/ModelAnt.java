// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelAnt extends ModelBase
{
    ModelRenderer thorax;
    ModelRenderer thorax1;
    ModelRenderer thorax3;
    ModelRenderer abdomen;
    ModelRenderer abdomen1;
    ModelRenderer head;
    ModelRenderer jawsr;
    ModelRenderer jawsl;
    ModelRenderer llegtop1;
    ModelRenderer llegbot1;
    ModelRenderer llegtop2;
    ModelRenderer llegbot2;
    ModelRenderer llegtop3;
    ModelRenderer llegbot3;
    ModelRenderer rlegtop1;
    ModelRenderer rlegbot1;
    ModelRenderer rlegtop2;
    ModelRenderer rlegbot2;
    ModelRenderer rlegtop3;
    ModelRenderer rlegbot3;
    
    public ModelAnt() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.thorax = new ModelRenderer((ModelBase)this, 22, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.thorax.func_78793_a(0.0f, 17.0f, 0.0f);
        this.thorax.func_78787_b(64, 32);
        this.thorax.field_78809_i = true;
        this.setRotation(this.thorax, 0.0f, 0.0f, 0.0f);
        (this.thorax1 = new ModelRenderer((ModelBase)this, 18, 0)).func_78789_a(1.0f, 1.0f, -1.0f, 1, 1, 1);
        this.thorax1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.thorax1.func_78787_b(64, 32);
        this.thorax1.field_78809_i = true;
        this.setRotation(this.thorax1, 0.0f, 0.0f, 0.0f);
        (this.thorax3 = new ModelRenderer((ModelBase)this, 34, 0)).func_78789_a(1.0f, 1.0f, 3.0f, 1, 1, 1);
        this.thorax3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.thorax3.func_78787_b(64, 32);
        this.thorax3.field_78809_i = true;
        this.setRotation(this.thorax3, 0.0f, 0.0f, 0.0f);
        (this.abdomen = new ModelRenderer((ModelBase)this, 38, 0)).func_78789_a(0.0f, 0.0f, 4.0f, 3, 3, 5);
        this.abdomen.func_78793_a(0.0f, 17.0f, 0.0f);
        this.abdomen.func_78787_b(64, 32);
        this.abdomen.field_78809_i = true;
        this.setRotation(this.abdomen, 0.0f, 0.0f, 0.0f);
        (this.abdomen1 = new ModelRenderer((ModelBase)this, 54, 0)).func_78789_a(1.0f, 1.0f, 9.0f, 1, 1, 1);
        this.abdomen1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.abdomen1.func_78787_b(64, 32);
        this.abdomen1.field_78809_i = true;
        this.setRotation(this.abdomen1, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 6, 0)).func_78789_a(0.0f, -1.0f, -4.0f, 3, 3, 3);
        this.head.func_78793_a(0.0f, 17.0f, 0.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.jawsr = new ModelRenderer((ModelBase)this, 0, 9)).func_78789_a(-1.0f, 0.0f, -6.0f, 1, 1, 3);
        this.jawsr.func_78793_a(0.0f, 17.0f, 0.0f);
        this.jawsr.func_78787_b(64, 32);
        this.jawsr.field_78809_i = true;
        this.setRotation(this.jawsr, 0.0f, 0.0f, 0.0f);
        (this.jawsl = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(3.0f, 0.0f, -6.0f, 1, 1, 3);
        this.jawsl.func_78793_a(0.0f, 17.0f, 0.0f);
        this.jawsl.func_78787_b(64, 32);
        this.jawsl.field_78809_i = true;
        this.setRotation(this.jawsl, 0.0f, 0.0f, 0.0f);
        (this.llegtop1 = new ModelRenderer((ModelBase)this, 15, 10)).func_78789_a(3.0f, 1.0f, 1.0f, 3, 1, 1);
        this.llegtop1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegtop1.func_78787_b(64, 32);
        this.llegtop1.field_78809_i = true;
        this.setRotation(this.llegtop1, 0.0f, 0.0f, 0.3839724f);
        (this.llegbot1 = new ModelRenderer((ModelBase)this, 15, 19)).func_78789_a(5.0f, -3.0f, 1.0f, 3, 1, 1);
        this.llegbot1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegbot1.func_78787_b(64, 32);
        this.llegbot1.field_78809_i = true;
        this.setRotation(this.llegbot1, 0.0f, 0.0f, 1.064651f);
        (this.llegtop2 = new ModelRenderer((ModelBase)this, 15, 13)).func_78789_a(3.0f, 1.0f, 2.0f, 3, 1, 1);
        this.llegtop2.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegtop2.func_78787_b(64, 32);
        this.llegtop2.field_78809_i = true;
        this.setRotation(this.llegtop2, 0.0f, -0.2094395f, 0.3839724f);
        (this.llegbot2 = new ModelRenderer((ModelBase)this, 15, 22)).func_78789_a(5.0f, -3.0f, 2.0f, 3, 1, 1);
        this.llegbot2.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegbot2.func_78787_b(64, 32);
        this.llegbot2.field_78809_i = true;
        this.setRotation(this.llegbot2, 0.0f, -0.2268928f, 1.064651f);
        (this.llegtop3 = new ModelRenderer((ModelBase)this, 15, 16)).func_78789_a(3.0f, 1.0f, 0.0f, 3, 1, 1);
        this.llegtop3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegtop3.func_78787_b(64, 32);
        this.llegtop3.field_78809_i = true;
        this.setRotation(this.llegtop3, 0.0f, 0.3490659f, 0.3839724f);
        (this.llegbot3 = new ModelRenderer((ModelBase)this, 15, 25)).func_78789_a(5.0f, -3.0f, 0.0f, 3, 1, 1);
        this.llegbot3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.llegbot3.func_78787_b(64, 32);
        this.llegbot3.field_78809_i = true;
        this.setRotation(this.llegbot3, 0.0f, 0.3490659f, 1.064651f);
        (this.rlegtop1 = new ModelRenderer((ModelBase)this, 25, 10)).func_78789_a(-4.0f, 2.0f, 1.0f, 3, 1, 1);
        this.rlegtop1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegtop1.func_78787_b(64, 32);
        this.rlegtop1.field_78809_i = true;
        this.setRotation(this.rlegtop1, 0.0f, 0.0f, -0.4712389f);
        (this.rlegbot1 = new ModelRenderer((ModelBase)this, 25, 19)).func_78789_a(-7.0f, 0.0f, 1.0f, 3, 1, 1);
        this.rlegbot1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegbot1.func_78787_b(64, 32);
        this.rlegbot1.field_78809_i = true;
        this.setRotation(this.rlegbot1, 0.0f, 0.0f, -0.9773844f);
        (this.rlegtop2 = new ModelRenderer((ModelBase)this, 25, 13)).func_78789_a(-4.0f, 2.0f, 0.0f, 3, 1, 1);
        this.rlegtop2.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegtop2.func_78787_b(64, 32);
        this.rlegtop2.field_78809_i = true;
        this.setRotation(this.rlegtop2, 0.0f, -0.5934119f, -0.4712389f);
        (this.rlegbot2 = new ModelRenderer((ModelBase)this, 25, 22)).func_78789_a(-7.0f, 0.0f, 0.0f, 3, 1, 1);
        this.rlegbot2.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegbot2.func_78787_b(64, 32);
        this.rlegbot2.field_78809_i = true;
        this.setRotation(this.rlegbot2, 0.0f, -0.5934119f, -0.9773844f);
        (this.rlegtop3 = new ModelRenderer((ModelBase)this, 25, 16)).func_78789_a(-4.0f, 2.0f, 2.0f, 3, 1, 1);
        this.rlegtop3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegtop3.func_78787_b(64, 32);
        this.rlegtop3.field_78809_i = true;
        this.setRotation(this.rlegtop3, 0.0f, 0.418879f, -0.4712389f);
        (this.rlegbot3 = new ModelRenderer((ModelBase)this, 25, 25)).func_78789_a(-7.0f, 0.0f, 2.0f, 3, 1, 1);
        this.rlegbot3.func_78793_a(0.0f, 17.0f, 0.0f);
        this.rlegbot3.func_78787_b(64, 32);
        this.rlegbot3.field_78809_i = true;
        this.setRotation(this.rlegbot3, 0.0f, 0.418879f, -0.9773844f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.llegtop1.field_78795_f = MathHelper.func_76134_b(f2 * 2.7f) * 3.1415927f * 0.45f * f1;
        this.llegbot1.field_78795_f = this.llegtop1.field_78795_f;
        this.rlegtop2.field_78795_f = this.llegtop1.field_78795_f;
        this.rlegbot2.field_78795_f = this.llegtop1.field_78795_f;
        this.rlegtop3.field_78795_f = this.llegtop1.field_78795_f;
        this.rlegbot3.field_78795_f = this.llegtop1.field_78795_f;
        this.rlegtop1.field_78795_f = -this.llegtop1.field_78795_f;
        this.rlegbot1.field_78795_f = -this.llegtop1.field_78795_f;
        this.llegtop2.field_78795_f = -this.llegtop1.field_78795_f;
        this.llegbot2.field_78795_f = -this.llegtop1.field_78795_f;
        this.llegtop3.field_78795_f = -this.llegtop1.field_78795_f;
        this.llegbot3.field_78795_f = -this.llegtop1.field_78795_f;
        this.jawsl.field_78796_g = MathHelper.func_76134_b(f2 * 0.4f) * 3.1415927f * 0.05f;
        this.jawsr.field_78796_g = -this.jawsl.field_78796_g;
        this.thorax.func_78785_a(f5);
        this.thorax1.func_78785_a(f5);
        this.thorax3.func_78785_a(f5);
        this.abdomen.func_78785_a(f5);
        this.abdomen1.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.jawsr.func_78785_a(f5);
        this.jawsl.func_78785_a(f5);
        this.llegtop1.func_78785_a(f5);
        this.llegbot1.func_78785_a(f5);
        this.llegtop2.func_78785_a(f5);
        this.llegbot2.func_78785_a(f5);
        this.llegtop3.func_78785_a(f5);
        this.llegbot3.func_78785_a(f5);
        this.rlegtop1.func_78785_a(f5);
        this.rlegbot1.func_78785_a(f5);
        this.rlegtop2.func_78785_a(f5);
        this.rlegbot2.func_78785_a(f5);
        this.rlegtop3.func_78785_a(f5);
        this.rlegbot3.func_78785_a(f5);
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
