// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelWormSmall extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tail;
    
    public ModelWormSmall() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.head.func_78793_a(0.0f, 14.0f, 0.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 6, 0)).func_78789_a(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.body.func_78793_a(0.0f, 19.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.tail.func_78793_a(0.0f, 24.0f, 0.0f);
        this.tail.func_78787_b(64, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tail.field_78795_f = newangle;
        float d1 = (float)(Math.sin(newangle) * 5.0);
        float d2 = (float)(Math.cos(newangle) * 5.0);
        this.body.field_78798_e = this.tail.field_78798_e - d1;
        newangle = MathHelper.func_76134_b(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.tail.field_78808_h = newangle;
        float d3 = (float)(Math.cos(newangle) * d2);
        float d4 = (float)(Math.sin(newangle) * d2);
        this.body.field_78800_c = this.tail.field_78800_c + d4;
        this.body.field_78797_d = (float)(this.tail.field_78797_d - 5.0 + (5.0 - d3));
        newangle = MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.15f;
        this.body.field_78795_f = newangle;
        d1 = (float)(Math.sin(newangle) * 5.0);
        d2 = (float)(Math.cos(newangle) * 5.0);
        this.head.field_78798_e = this.body.field_78798_e - d1;
        newangle = MathHelper.func_76134_b(f2 * 0.25f) * 3.1415927f * 0.1f;
        this.body.field_78808_h = newangle;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        this.head.field_78800_c = this.body.field_78800_c + d4;
        this.head.field_78797_d = (float)(this.body.field_78797_d - 5.0 + (5.0 - d3));
        this.head.field_78795_f = 0.62f + MathHelper.func_76134_b(f2 * 0.65f) * 3.1415927f * 0.15f;
        this.head.field_78808_h = MathHelper.func_76134_b(f2 * 0.3f) * 3.1415927f * 0.05f;
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.tail.func_78785_a(f5);
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
