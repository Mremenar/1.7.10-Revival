// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelQueenBattleAxe extends ModelBase
{
    ModelRenderer Handle1;
    ModelRenderer Head1;
    ModelRenderer Grip;
    ModelRenderer Pin;
    ModelRenderer Blade1;
    ModelRenderer Blade2;
    ModelRenderer Blade3;
    ModelRenderer Blade4;
    ModelRenderer Top;
    
    public ModelQueenBattleAxe() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.Handle1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-7.0f, -0.5f, 0.0f, 31, 1, 1);
        this.Handle1.func_78793_a(-0.5f, -12.0f, 0.0f);
        this.Handle1.func_78787_b(128, 64);
        this.Handle1.field_78809_i = true;
        this.setRotation(this.Handle1, 0.0f, 0.0f, 1.570796f);
        (this.Head1 = new ModelRenderer((ModelBase)this, 29, 18)).func_78789_a(-2.0f, -4.5f, -0.5f, 3, 4, 2);
        this.Head1.func_78793_a(0.0f, -12.0f, 0.0f);
        this.Head1.func_78787_b(128, 64);
        this.Head1.field_78809_i = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Grip = new ModelRenderer((ModelBase)this, 0, 7)).func_78789_a(-1.92f, 13.0f, -0.5f, 2, 11, 2);
        this.Grip.func_78793_a(0.5f, -12.0f, 0.0f);
        this.Grip.func_78787_b(128, 64);
        this.Grip.field_78809_i = true;
        this.setRotation(this.Grip, 0.0f, 0.0f, 0.0f);
        (this.Pin = new ModelRenderer((ModelBase)this, 38, 11)).func_78789_a(-1.0f, -3.0f, -1.0f, 1, 1, 3);
        this.Pin.func_78793_a(0.0f, -12.0f, 0.0f);
        this.Pin.func_78787_b(128, 64);
        this.Pin.field_78809_i = true;
        this.setRotation(this.Pin, 0.0f, 0.0f, 0.0f);
        (this.Blade1 = new ModelRenderer((ModelBase)this, 70, 0)).func_78789_a(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade1.func_78793_a(-0.5f, -14.5f, 0.0f);
        this.Blade1.func_78787_b(128, 64);
        this.Blade1.field_78809_i = true;
        this.setRotation(this.Blade1, 0.0f, 0.0f, -0.5934119f);
        (this.Blade2 = new ModelRenderer((ModelBase)this, 70, 0)).func_78789_a(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade2.func_78793_a(-0.5f, -14.5f, 0.0f);
        this.Blade2.func_78787_b(128, 64);
        this.Blade2.field_78809_i = true;
        this.setRotation(this.Blade2, 0.0f, 0.0f, -0.1919862f);
        (this.Blade3 = new ModelRenderer((ModelBase)this, 70, 0)).func_78789_a(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade3.func_78793_a(-0.5f, -14.5f, 0.0f);
        this.Blade3.func_78787_b(128, 64);
        this.Blade3.field_78809_i = true;
        this.setRotation(this.Blade3, 0.0f, 0.0f, 0.2094395f);
        (this.Blade4 = new ModelRenderer((ModelBase)this, 70, 0)).func_78789_a(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade4.func_78793_a(-0.5f, -14.5f, 0.0f);
        this.Blade4.func_78787_b(128, 64);
        this.Blade4.field_78809_i = true;
        this.setRotation(this.Blade4, 0.0f, 0.0f, 0.5934119f);
        (this.Top = new ModelRenderer((ModelBase)this, 13, 4)).func_78789_a(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Top.func_78793_a(-1.5f, -21.0f, -0.5f);
        this.Top.func_78787_b(128, 64);
        this.Top.field_78809_i = true;
        this.setRotation(this.Top, 0.0f, 0.0f, 0.0f);
    }
    
    public void render() {
        final float f5 = 1.0f;
        this.Handle1.func_78785_a(f5);
        this.Head1.func_78785_a(f5);
        this.Grip.func_78785_a(f5);
        this.Pin.func_78785_a(f5);
        this.Blade1.func_78785_a(f5);
        this.Blade2.func_78785_a(f5);
        this.Blade3.func_78785_a(f5);
        this.Blade4.func_78785_a(f5);
        this.Top.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
}
