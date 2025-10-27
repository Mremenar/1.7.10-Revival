// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCamarasaurus extends ModelBase
{
    private float wingspeed;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Tail0;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Head1;
    ModelRenderer Head2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer BLegupleft;
    ModelRenderer FLegupleft;
    ModelRenderer BLegupright;
    ModelRenderer FLegupright;
    ModelRenderer BLegdownright;
    ModelRenderer FLegdownleft;
    ModelRenderer FLegdownright;
    ModelRenderer BLegdownleft;
    
    public ModelCamarasaurus(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        (this.Body1 = new ModelRenderer((ModelBase)this, 0, 135)).func_78789_a(-6.0f, 0.0f, 0.0f, 12, 12, 12);
        this.Body1.func_78793_a(0.0f, -1.0f, 0.0f);
        this.Body1.func_78787_b(256, 256);
        this.Body1.field_78809_i = true;
        this.setRotation(this.Body1, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase)this, 0, 160)).func_78789_a(-5.0f, 0.0f, 0.0f, 10, 10, 6);
        this.Body2.func_78793_a(0.0f, -2.0f, -4.0f);
        this.Body2.func_78787_b(256, 256);
        this.Body2.field_78809_i = true;
        this.setRotation(this.Body2, -0.1858931f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase)this, 0, 177)).func_78789_a(-4.0f, 0.0f, 0.0f, 8, 8, 4);
        this.Body3.func_78793_a(0.0f, -3.0f, -6.0f);
        this.Body3.func_78787_b(256, 256);
        this.Body3.field_78809_i = true;
        this.setRotation(this.Body3, -0.3346075f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase)this, 0, 120)).func_78789_a(-5.0f, 0.0f, 0.0f, 10, 10, 4);
        this.Body4.func_78793_a(0.0f, 0.0f, 11.0f);
        this.Body4.func_78787_b(256, 256);
        this.Body4.field_78809_i = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Tail0 = new ModelRenderer((ModelBase)this, 0, 107)).func_78789_a(-3.0f, -2.0f, 0.0f, 6, 6, 6);
        this.Tail0.func_78793_a(0.0f, 3.0f, 14.0f);
        this.Tail0.func_78787_b(256, 256);
        this.Tail0.field_78809_i = true;
        this.setRotation(this.Tail0, -0.0743572f, 0.0f, 0.0f);
        (this.Neck1 = new ModelRenderer((ModelBase)this, 0, 190)).func_78789_a(-3.0f, 0.0f, 0.0f, 6, 6, 5);
        this.Neck1.func_78793_a(0.0f, -4.0f, -9.0f);
        this.Neck1.func_78787_b(256, 256);
        this.Neck1.field_78809_i = true;
        this.setRotation(this.Neck1, -0.4089647f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase)this, 0, 202)).func_78789_a(-2.0f, 0.0f, -6.0f, 4, 4, 7);
        this.Neck2.func_78793_a(0.0f, -3.0f, -9.0f);
        this.Neck2.func_78787_b(256, 256);
        this.Neck2.field_78809_i = true;
        this.setRotation(this.Neck2, -0.5948578f, 0.0f, 0.0f);
        (this.Neck3 = new ModelRenderer((ModelBase)this, 0, 214)).func_78789_a(-2.0f, -2.0f, -12.0f, 4, 4, 13);
        this.Neck3.func_78793_a(0.0f, -5.0f, -15.0f);
        this.Neck3.func_78787_b(256, 256);
        this.Neck3.field_78809_i = true;
        this.setRotation(this.Neck3, -0.8179294f, 0.0f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase)this, 0, 232)).func_78789_a(-4.0f, -3.0f, -6.0f, 8, 6, 6);
        this.Head1.func_78793_a(0.0f, -13.0f, -22.0f);
        this.Head1.func_78787_b(256, 256);
        this.Head1.field_78809_i = true;
        this.setRotation(this.Head1, -0.1115358f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase)this, 0, 245)).func_78789_a(-3.0f, -2.0f, -4.0f, 6, 4, 4);
        this.Head2.func_78793_a(0.0f, -13.0f, -27.0f);
        this.Head2.func_78787_b(256, 256);
        this.Head2.field_78809_i = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 0, 93)).func_78789_a(-2.0f, -3.0f, 0.0f, 4, 4, 9);
        this.Tail1.func_78793_a(0.0f, 5.0f, 19.0f);
        this.Tail1.func_78787_b(256, 256);
        this.Tail1.field_78809_i = true;
        this.setRotation(this.Tail1, -0.1115358f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 0, 82)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 8);
        this.Tail2.func_78793_a(0.0f, 4.0f, 26.0f);
        this.Tail2.func_78787_b(256, 256);
        this.Tail2.field_78809_i = true;
        this.setRotation(this.Tail2, -0.0743572f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase)this, 0, 73)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 7);
        this.Tail3.func_78793_a(0.0f, 4.5f, 34.0f);
        this.Tail3.func_78787_b(256, 256);
        this.Tail3.field_78809_i = true;
        this.setRotation(this.Tail3, -0.0371786f, 0.0f, 0.0f);
        (this.BLegupleft = new ModelRenderer((ModelBase)this, 49, 157)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.BLegupleft.func_78793_a(2.0f, 9.0f, 7.0f);
        this.BLegupleft.func_78787_b(256, 256);
        this.BLegupleft.field_78809_i = true;
        this.setRotation(this.BLegupleft, -0.1487195f, 0.0f, 0.0f);
        (this.FLegupleft = new ModelRenderer((ModelBase)this, 49, 141)).func_78789_a(0.0f, 0.0f, -6.0f, 6, 9, 6);
        this.FLegupleft.func_78793_a(2.0f, 8.0f, 2.0f);
        this.FLegupleft.func_78787_b(256, 256);
        this.FLegupleft.field_78809_i = true;
        this.setRotation(this.FLegupleft, 0.0f, 0.0f, 0.0f);
        (this.BLegupright = new ModelRenderer((ModelBase)this, 49, 126)).func_78789_a(-6.0f, 0.0f, 0.0f, 6, 8, 6);
        this.BLegupright.func_78793_a(-2.0f, 9.0f, 7.0f);
        this.BLegupright.func_78787_b(256, 256);
        this.BLegupright.field_78809_i = true;
        this.setRotation(this.BLegupright, -0.1487144f, 0.0f, 0.0f);
        (this.FLegupright = new ModelRenderer((ModelBase)this, 49, 110)).func_78789_a(-6.0f, 0.0f, -6.0f, 6, 9, 6);
        this.FLegupright.func_78793_a(-2.0f, 8.0f, 2.0f);
        this.FLegupright.func_78787_b(256, 256);
        this.FLegupright.field_78809_i = true;
        this.setRotation(this.FLegupright, 0.0f, 0.0f, 0.0f);
        (this.BLegdownright = new ModelRenderer((ModelBase)this, 115, 157)).func_78789_a(-5.0f, 7.0f, -1.0f, 5, 8, 5);
        this.BLegdownright.func_78793_a(-2.0f, 9.0f, 7.0f);
        this.BLegdownright.func_78787_b(256, 256);
        this.BLegdownright.field_78809_i = true;
        this.setRotation(this.BLegdownright, 0.0f, 0.0f, 0.0f);
        (this.FLegdownleft = new ModelRenderer((ModelBase)this, 94, 143)).func_78789_a(0.0f, 8.0f, -6.0f, 5, 8, 5);
        this.FLegdownleft.func_78793_a(2.0f, 8.0f, 2.0f);
        this.FLegdownleft.func_78787_b(256, 256);
        this.FLegdownleft.field_78809_i = true;
        this.setRotation(this.FLegdownleft, 0.0f, 0.0f, 0.0f);
        (this.FLegdownright = new ModelRenderer((ModelBase)this, 94, 157)).func_78789_a(-5.0f, 8.0f, -6.0f, 5, 8, 5);
        this.FLegdownright.func_78793_a(-2.0f, 8.0f, 2.0f);
        this.FLegdownright.func_78787_b(256, 256);
        this.FLegdownright.field_78809_i = true;
        this.setRotation(this.FLegdownright, 0.0f, 0.0f, 0.0f);
        (this.BLegdownleft = new ModelRenderer((ModelBase)this, 115, 143)).func_78789_a(0.0f, 7.0f, -1.0f, 5, 8, 5);
        this.BLegdownleft.func_78793_a(2.0f, 9.0f, 7.0f);
        this.BLegdownleft.func_78787_b(256, 256);
        this.BLegdownleft.field_78809_i = true;
        this.setRotation(this.BLegdownleft, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Camarasaurus c = (Camarasaurus)entity;
        float hf = 0.0f;
        float newangle = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = 0.0f;
        }
        this.FLegupleft.field_78795_f = newangle;
        this.FLegdownleft.field_78795_f = newangle;
        this.FLegupright.field_78795_f = -newangle;
        this.FLegdownright.field_78795_f = -newangle;
        this.BLegupleft.field_78795_f = -0.15f - newangle;
        this.BLegdownleft.field_78795_f = -newangle;
        this.BLegupright.field_78795_f = -0.15f + newangle;
        this.BLegdownright.field_78795_f = newangle;
        hf = c.getCamarasaurusHealth() / c.func_110138_aP();
        newangle = MathHelper.func_76134_b(f2 * 1.5f * this.wingspeed * hf) * 3.1415927f * 0.25f * hf;
        if (c.func_70906_o()) {
            newangle = 0.0f;
        }
        this.Tail0.field_78796_g = newangle * 0.25f;
        this.Tail1.field_78798_e = this.Tail0.field_78798_e + (float)Math.cos(this.Tail0.field_78796_g) * 5.0f;
        this.Tail1.field_78800_c = this.Tail0.field_78800_c + (float)Math.sin(this.Tail0.field_78796_g) * 5.0f;
        this.Tail1.field_78796_g = newangle * 0.5f;
        this.Tail2.field_78798_e = this.Tail1.field_78798_e + (float)Math.cos(this.Tail1.field_78796_g) * 8.0f;
        this.Tail2.field_78800_c = this.Tail1.field_78800_c + (float)Math.sin(this.Tail1.field_78796_g) * 8.0f;
        this.Tail2.field_78796_g = newangle * 0.75f;
        this.Tail3.field_78798_e = this.Tail2.field_78798_e + (float)Math.cos(this.Tail2.field_78796_g) * 7.0f;
        this.Tail3.field_78800_c = this.Tail2.field_78800_c + (float)Math.sin(this.Tail2.field_78796_g) * 7.0f;
        this.Tail3.field_78796_g = newangle * 1.0f;
        this.Neck1.field_78796_g = (float)Math.toRadians(f3) * 0.125f;
        this.Neck2.field_78798_e = this.Neck1.field_78798_e;
        this.Neck2.field_78800_c = this.Neck1.field_78800_c;
        this.Neck2.field_78796_g = (float)Math.toRadians(f3) * 0.25f;
        this.Neck3.field_78798_e = this.Neck2.field_78798_e - (float)Math.cos(this.Neck2.field_78796_g) * 6.0f;
        this.Neck3.field_78800_c = this.Neck2.field_78800_c - (float)Math.sin(this.Neck2.field_78796_g) * 6.0f;
        this.Neck3.field_78796_g = (float)Math.toRadians(f3) * 0.38f;
        this.Head1.field_78798_e = this.Neck3.field_78798_e - (float)Math.cos(this.Neck3.field_78796_g) * 7.0f;
        this.Head1.field_78800_c = this.Neck3.field_78800_c - (float)Math.sin(this.Neck3.field_78796_g) * 7.0f;
        this.Head1.field_78796_g = (float)Math.toRadians(f3);
        this.Head2.field_78798_e = this.Head1.field_78798_e - (float)Math.cos(this.Head1.field_78796_g) * 5.0f;
        this.Head2.field_78800_c = this.Head1.field_78800_c - (float)Math.sin(this.Head1.field_78796_g) * 5.0f;
        this.Head2.field_78796_g = (float)Math.toRadians(f3);
        this.Body1.func_78785_a(f5);
        this.Body2.func_78785_a(f5);
        this.Body3.func_78785_a(f5);
        this.Body4.func_78785_a(f5);
        this.Tail0.func_78785_a(f5);
        this.Neck1.func_78785_a(f5);
        this.Neck2.func_78785_a(f5);
        this.Neck3.func_78785_a(f5);
        this.Head1.func_78785_a(f5);
        this.Head2.func_78785_a(f5);
        this.Tail1.func_78785_a(f5);
        this.Tail2.func_78785_a(f5);
        this.Tail3.func_78785_a(f5);
        this.FLegupleft.func_78785_a(f5);
        this.FLegdownleft.func_78785_a(f5);
        this.FLegupright.func_78785_a(f5);
        this.FLegdownright.func_78785_a(f5);
        this.BLegupleft.func_78785_a(f5);
        this.BLegdownright.func_78785_a(f5);
        this.BLegupright.func_78785_a(f5);
        this.BLegdownleft.func_78785_a(f5);
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
