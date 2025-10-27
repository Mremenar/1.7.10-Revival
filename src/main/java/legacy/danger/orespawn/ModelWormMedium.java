// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelWormMedium extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer tooth1;
    ModelRenderer tooth2;
    ModelRenderer tooth3;
    ModelRenderer tooth4;
    ModelRenderer head2;
    
    public ModelWormMedium() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.head.func_78793_a(0.0f, 1.0f, 0.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 37, 0)).func_78789_a(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.body.func_78793_a(0.0f, 13.0f, 0.0f);
        this.body.func_78787_b(64, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase)this, 50, 0)).func_78789_a(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.tail.func_78793_a(0.0f, 25.0f, 0.0f);
        this.tail.func_78787_b(64, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        (this.tooth1 = new ModelRenderer((ModelBase)this, 15, 0)).func_78789_a(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth1.func_78793_a(1.0f, -11.0f, 0.0f);
        this.tooth1.func_78787_b(64, 32);
        this.tooth1.field_78809_i = true;
        this.setRotation(this.tooth1, 0.0f, 0.0f, 0.0f);
        (this.tooth2 = new ModelRenderer((ModelBase)this, 5, 0)).func_78789_a(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth2.func_78793_a(-1.0f, -11.0f, 0.0f);
        this.tooth2.func_78787_b(64, 32);
        this.tooth2.field_78809_i = true;
        this.setRotation(this.tooth2, 0.0f, 0.0f, 0.0f);
        (this.tooth3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth3.func_78793_a(0.0f, -11.0f, 1.0f);
        this.tooth3.func_78787_b(64, 32);
        this.tooth3.field_78809_i = true;
        this.setRotation(this.tooth3, 0.0f, 0.0f, 0.0f);
        (this.tooth4 = new ModelRenderer((ModelBase)this, 10, 0)).func_78789_a(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth4.func_78793_a(0.0f, -11.0f, -1.0f);
        this.tooth4.func_78787_b(64, 32);
        this.tooth4.field_78809_i = true;
        this.setRotation(this.tooth4, 0.0f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer((ModelBase)this, 0, 6)).func_78789_a(-2.0f, -8.0f, -2.0f, 4, 8, 4);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78787_b(64, 32);
        this.head2.field_78809_i = true;
        this.setRotation(this.head2, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.func_76134_b(f2 * 0.45f) * 3.1415927f * 0.1f;
        this.tail.field_78795_f = newangle;
        float d1 = (float)(Math.sin(newangle) * 12.0);
        float d2 = (float)(Math.cos(newangle) * 12.0);
        this.body.field_78798_e = this.tail.field_78798_e - d1;
        newangle = MathHelper.func_76134_b(f2 * 0.25f) * 3.1415927f * 0.08f;
        this.tail.field_78808_h = newangle;
        float d3 = (float)(Math.cos(newangle) * d2);
        float d4 = (float)(Math.sin(newangle) * d2);
        this.body.field_78800_c = this.tail.field_78800_c + d4;
        this.body.field_78797_d = (float)(this.tail.field_78797_d - 12.0 + (12.0 - d3));
        newangle = MathHelper.func_76134_b(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.body.field_78795_f = newangle;
        d1 = (float)(Math.sin(newangle) * 12.0);
        d2 = (float)(Math.cos(newangle) * 12.0);
        final ModelRenderer head2 = this.head2;
        final ModelRenderer head3 = this.head;
        final float n = this.body.field_78798_e - d1;
        head3.field_78798_e = n;
        head2.field_78798_e = n;
        newangle = MathHelper.func_76134_b(f2 * 0.15f) * 3.1415927f * 0.07f;
        this.body.field_78808_h = newangle;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        final ModelRenderer head4 = this.head2;
        final ModelRenderer head5 = this.head;
        final float n2 = this.body.field_78800_c + d4;
        head5.field_78800_c = n2;
        head4.field_78800_c = n2;
        final ModelRenderer head6 = this.head2;
        final ModelRenderer head7 = this.head;
        final float n3 = (float)(this.body.field_78797_d - 12.0 + (12.0 - d3));
        head7.field_78797_d = n3;
        head6.field_78797_d = n3;
        final ModelRenderer head8 = this.head2;
        final ModelRenderer head9 = this.head;
        final float n4 = 0.62f + MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        head9.field_78795_f = n4;
        head8.field_78795_f = n4;
        final ModelRenderer head10 = this.head2;
        final ModelRenderer head11 = this.head;
        final float n5 = MathHelper.func_76134_b(f2 * 0.25f) * 3.1415927f * 0.05f;
        head11.field_78808_h = n5;
        head10.field_78808_h = n5;
        newangle = this.head.field_78795_f;
        final ModelRenderer tooth1 = this.tooth1;
        final ModelRenderer tooth2 = this.tooth2;
        final ModelRenderer tooth3 = this.tooth3;
        final ModelRenderer tooth4 = this.tooth4;
        final float n6 = newangle;
        tooth4.field_78795_f = n6;
        tooth3.field_78795_f = n6;
        tooth2.field_78795_f = n6;
        tooth1.field_78795_f = n6;
        d1 = (float)(Math.sin(newangle) * 12.0);
        d2 = (float)(Math.cos(newangle) * 12.0);
        final ModelRenderer tooth5 = this.tooth1;
        final ModelRenderer tooth6 = this.tooth2;
        final ModelRenderer tooth7 = this.tooth3;
        final ModelRenderer tooth8 = this.tooth4;
        final float n7 = this.head.field_78798_e - d1;
        tooth8.field_78798_e = n7;
        tooth7.field_78798_e = n7;
        tooth6.field_78798_e = n7;
        tooth5.field_78798_e = n7;
        newangle = this.head.field_78808_h;
        final ModelRenderer tooth9 = this.tooth1;
        final ModelRenderer tooth10 = this.tooth2;
        final ModelRenderer tooth11 = this.tooth3;
        final ModelRenderer tooth12 = this.tooth4;
        final float n8 = newangle;
        tooth12.field_78808_h = n8;
        tooth11.field_78808_h = n8;
        tooth10.field_78808_h = n8;
        tooth9.field_78808_h = n8;
        d3 = (float)(Math.cos(newangle) * d2);
        d4 = (float)(Math.sin(newangle) * d2);
        final ModelRenderer tooth13 = this.tooth1;
        final ModelRenderer tooth14 = this.tooth2;
        final ModelRenderer tooth15 = this.tooth3;
        final ModelRenderer tooth16 = this.tooth4;
        final float n9 = this.head.field_78800_c + d4;
        tooth16.field_78800_c = n9;
        tooth15.field_78800_c = n9;
        tooth14.field_78800_c = n9;
        tooth13.field_78800_c = n9;
        final ModelRenderer tooth17 = this.tooth1;
        final ModelRenderer tooth18 = this.tooth2;
        final ModelRenderer tooth19 = this.tooth3;
        final ModelRenderer tooth20 = this.tooth4;
        final float n10 = (float)(this.head.field_78797_d - 12.0 + (12.0 - d3));
        tooth20.field_78797_d = n10;
        tooth19.field_78797_d = n10;
        tooth18.field_78797_d = n10;
        tooth17.field_78797_d = n10;
        final ModelRenderer tooth21 = this.tooth1;
        ++tooth21.field_78798_e;
        final ModelRenderer tooth22 = this.tooth2;
        --tooth22.field_78798_e;
        this.tooth1.field_78795_f = this.tooth1.field_78795_f - 0.4f - MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tooth2.field_78795_f = this.tooth2.field_78795_f + 0.4f + MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        final ModelRenderer tooth23 = this.tooth3;
        ++tooth23.field_78800_c;
        final ModelRenderer tooth24 = this.tooth4;
        --tooth24.field_78800_c;
        this.tooth3.field_78808_h = this.tooth3.field_78808_h + 0.4f + MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tooth4.field_78808_h = this.tooth4.field_78808_h - 0.4f - MathHelper.func_76134_b(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.tail.func_78785_a(f5);
        this.tooth1.func_78785_a(f5);
        this.tooth2.func_78785_a(f5);
        this.tooth3.func_78785_a(f5);
        this.tooth4.func_78785_a(f5);
        this.head2.func_78785_a(f5);
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
