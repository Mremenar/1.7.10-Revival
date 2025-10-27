// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelGoldFish extends ModelBase
{
    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Dorsalfin;
    ModelRenderer Mouth;
    ModelRenderer Jaw;
    ModelRenderer Pectoralfin1;
    ModelRenderer Pectoralfin2;
    ModelRenderer Pectoralfin3;
    ModelRenderer Pectoralfin4;
    ModelRenderer Bottomfin;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Caudalfin1;
    ModelRenderer Caudalfin2;
    ModelRenderer Bottomfin1;
    ModelRenderer Bottomfin2;
    
    public ModelGoldFish(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.Body = new ModelRenderer((ModelBase)this, 0, 15)).func_78789_a(-2.0f, -2.0f, 0.0f, 4, 4, 10);
        this.Body.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Body.func_78787_b(64, 64);
        this.Body.field_78809_i = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(-1.5f, -2.0f, -3.0f, 3, 4, 3);
        this.Head.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Head.func_78787_b(64, 64);
        this.Head.field_78809_i = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Dorsalfin = new ModelRenderer((ModelBase)this, 29, 0)).func_78789_a(0.0f, -6.0f, 0.0f, 0, 4, 10);
        this.Dorsalfin.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Dorsalfin.func_78787_b(64, 64);
        this.Dorsalfin.field_78809_i = true;
        this.setRotation(this.Dorsalfin, 0.0f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase)this, 0, 38)).func_78789_a(-1.5f, 0.6f, -3.5f, 3, 3, 3);
        this.Mouth.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Mouth.func_78787_b(64, 64);
        this.Mouth.field_78809_i = true;
        this.setRotation(this.Mouth, -0.7853982f, 0.0f, 0.0f);
        (this.Jaw = new ModelRenderer((ModelBase)this, 13, 30)).func_78789_a(-1.0f, 0.0f, -3.0f, 3, 1, 3);
        this.Jaw.func_78793_a(-0.5f, 15.6f, -7.4f);
        this.Jaw.func_78787_b(64, 64);
        this.Jaw.field_78809_i = true;
        this.setRotation(this.Jaw, -0.2284419f, 0.0f, 0.0f);
        (this.Pectoralfin1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin1.func_78793_a(-2.0f, 14.0f, -3.0f);
        this.Pectoralfin1.func_78787_b(64, 64);
        this.Pectoralfin1.field_78809_i = true;
        this.setRotation(this.Pectoralfin1, -0.2974289f, -0.3346075f, 0.0f);
        (this.Pectoralfin2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin2.func_78793_a(2.0f, 14.0f, -3.0f);
        this.Pectoralfin2.func_78787_b(64, 64);
        this.Pectoralfin2.field_78809_i = true;
        this.setRotation(this.Pectoralfin2, -0.2974216f, 0.3346145f, 0.0f);
        (this.Pectoralfin3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin3.func_78793_a(-2.0f, 14.0f, 1.0f);
        this.Pectoralfin3.func_78787_b(64, 64);
        this.Pectoralfin3.field_78809_i = true;
        this.setRotation(this.Pectoralfin3, -0.2974289f, -0.3346075f, 0.0f);
        (this.Pectoralfin4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin4.func_78793_a(2.0f, 14.0f, 1.0f);
        this.Pectoralfin4.func_78787_b(64, 64);
        this.Pectoralfin4.field_78809_i = true;
        this.setRotation(this.Pectoralfin4, -0.2974289f, 0.3346145f, 0.0f);
        (this.Bottomfin = new ModelRenderer((ModelBase)this, 20, 8)).func_78789_a(0.0f, 2.0f, 6.0f, 0, 3, 4);
        this.Bottomfin.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Bottomfin.func_78787_b(64, 64);
        this.Bottomfin.field_78809_i = true;
        this.setRotation(this.Bottomfin, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 29, 15)).func_78789_a(-1.5f, -2.0f, 0.0f, 3, 4, 6);
        this.Tail1.func_78793_a(0.0f, 14.0f, 5.0f);
        this.Tail1.func_78787_b(64, 64);
        this.Tail1.field_78809_i = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(-1.0f, -1.5f, 6.0f, 2, 3, 4);
        this.Tail2.func_78793_a(0.0f, 14.0f, 5.0f);
        this.Tail2.func_78787_b(64, 64);
        this.Tail2.field_78809_i = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Caudalfin1 = new ModelRenderer((ModelBase)this, 13, 35)).func_78789_a(-0.5f, 5.5f, 6.0f, 1, 3, 4);
        this.Caudalfin1.func_78793_a(0.0f, 14.0f, 5.0f);
        this.Caudalfin1.func_78787_b(64, 64);
        this.Caudalfin1.field_78809_i = true;
        this.setRotation(this.Caudalfin1, 0.8179294f, 0.0f, 0.0f);
        (this.Caudalfin2 = new ModelRenderer((ModelBase)this, 15, 35)).func_78789_a(-0.5f, 5.5f, 6.0f, 1, 4, 3);
        this.Caudalfin2.func_78793_a(0.0f, 14.0f, 5.0f);
        this.Caudalfin2.func_78787_b(64, 64);
        this.Caudalfin2.field_78809_i = true;
        this.setRotation(this.Caudalfin2, 0.8179294f, 0.0f, 0.0f);
        (this.Bottomfin1 = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(-1.0f, 2.0f, 1.0f, 0, 5, 2);
        this.Bottomfin1.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Bottomfin1.func_78787_b(64, 64);
        this.Bottomfin1.field_78809_i = true;
        this.setRotation(this.Bottomfin1, 0.2974289f, 0.0f, 0.3346145f);
        (this.Bottomfin2 = new ModelRenderer((ModelBase)this, 20, 0)).func_78789_a(1.0f, 2.0f, 1.0f, 0, 5, 2);
        this.Bottomfin2.func_78793_a(0.0f, 14.0f, -5.0f);
        this.Bottomfin2.func_78787_b(64, 64);
        this.Bottomfin2.field_78809_i = true;
        this.setRotation(this.Bottomfin2, 0.2974289f, 0.0f, -0.3346075f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        float newangle = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.func_76134_b(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin1.field_78796_g = 0.4f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin2.field_78796_g = -0.4f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin3.field_78796_g = 0.4f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin4.field_78796_g = -0.4f + newangle;
        newangle = MathHelper.func_76134_b(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.25f;
        this.Bottomfin1.field_78796_g = newangle;
        this.Bottomfin2.field_78796_g = -newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.1f;
        this.Jaw.field_78795_f = -0.25f + newangle;
        this.Body.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.Dorsalfin.func_78785_a(f5);
        this.Mouth.func_78785_a(f5);
        this.Jaw.func_78785_a(f5);
        this.Pectoralfin1.func_78785_a(f5);
        this.Pectoralfin2.func_78785_a(f5);
        this.Pectoralfin3.func_78785_a(f5);
        this.Pectoralfin4.func_78785_a(f5);
        this.Bottomfin.func_78785_a(f5);
        this.Tail1.func_78785_a(f5);
        this.Tail2.func_78785_a(f5);
        this.Caudalfin1.func_78785_a(f5);
        this.Caudalfin2.func_78785_a(f5);
        this.Bottomfin1.func_78785_a(f5);
        this.Bottomfin2.func_78785_a(f5);
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
