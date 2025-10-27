// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelGhostSkelly extends ModelBase
{
    ModelRenderer body;
    ModelRenderer shirt;
    ModelRenderer head;
    ModelRenderer stem;
    ModelRenderer rarm;
    ModelRenderer larm;
    ModelRenderer rsleeve;
    ModelRenderer lsleeve;
    ModelRenderer lchains;
    ModelRenderer rchains;
    
    public ModelGhostSkelly() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 21, 1);
        this.body.func_78793_a(0.0f, -1.0f, 0.0f);
        this.body.func_78787_b(128, 64);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.shirt = new ModelRenderer((ModelBase)this, 42, 43)).func_78789_a(-2.0f, 0.0f, -2.0f, 5, 12, 5);
        this.shirt.func_78793_a(0.0f, 0.0f, 0.0f);
        this.shirt.func_78787_b(128, 64);
        this.shirt.field_78809_i = true;
        this.setRotation(this.shirt, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 40, 29)).func_78789_a(-3.0f, 0.0f, -3.0f, 7, 5, 7);
        this.head.func_78793_a(0.0f, -6.0f, 0.0f);
        this.head.func_78787_b(128, 64);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.stem = new ModelRenderer((ModelBase)this, 49, 23)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.stem.func_78793_a(0.0f, -8.0f, 0.0f);
        this.stem.func_78787_b(128, 64);
        this.stem.field_78809_i = true;
        this.setRotation(this.stem, 0.1745329f, 0.0f, 0.1745329f);
        (this.rarm = new ModelRenderer((ModelBase)this, 26, 0)).func_78789_a(-14.0f, 0.0f, 0.0f, 15, 1, 1);
        this.rarm.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rarm.func_78787_b(128, 64);
        this.rarm.field_78809_i = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.0f);
        (this.larm = new ModelRenderer((ModelBase)this, 63, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 15, 1, 1);
        this.larm.func_78793_a(0.0f, 0.0f, 0.0f);
        this.larm.func_78787_b(128, 64);
        this.larm.field_78809_i = true;
        this.setRotation(this.larm, 0.0f, 0.0f, 0.0f);
        (this.rsleeve = new ModelRenderer((ModelBase)this, 31, 7)).func_78789_a(-11.0f, 0.0f, -1.0f, 9, 8, 3);
        this.rsleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rsleeve.func_78787_b(128, 64);
        this.rsleeve.field_78809_i = true;
        this.setRotation(this.rsleeve, 0.0f, 0.0f, 0.0f);
        (this.lsleeve = new ModelRenderer((ModelBase)this, 71, 7)).func_78789_a(3.0f, 0.0f, -1.0f, 9, 8, 3);
        this.lsleeve.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lsleeve.func_78787_b(128, 64);
        this.lsleeve.field_78809_i = true;
        this.setRotation(this.lsleeve, 0.0f, 0.0f, 0.0f);
        (this.lchains = new ModelRenderer((ModelBase)this, 98, 0)).func_78789_a(11.0f, -1.0f, 0.0f, 3, 16, 1);
        this.lchains.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lchains.func_78787_b(128, 64);
        this.lchains.field_78809_i = true;
        this.setRotation(this.lchains, 0.0f, 0.0f, 0.0f);
        (this.rchains = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-13.0f, -1.0f, 0.0f, 3, 10, 1);
        this.rchains.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rchains.func_78787_b(128, 64);
        this.rchains.field_78809_i = true;
        this.setRotation(this.rchains, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final GhostSkelly e = (GhostSkelly)entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float newrf1 = 0.0f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        final ModelRenderer larm = this.larm;
        final ModelRenderer lsleeve = this.lsleeve;
        final ModelRenderer lchains = this.lchains;
        final float field_78808_h = MathHelper.func_76134_b(f2 * 0.2f) * 3.1415927f * 0.05f;
        lchains.field_78808_h = field_78808_h;
        lsleeve.field_78808_h = field_78808_h;
        larm.field_78808_h = field_78808_h;
        final ModelRenderer rarm = this.rarm;
        final ModelRenderer rsleeve = this.rsleeve;
        final ModelRenderer rchains = this.rchains;
        final float field_78808_h2 = MathHelper.func_76134_b(f2 * 0.22f) * 3.1415927f * 0.05f;
        rchains.field_78808_h = field_78808_h2;
        rsleeve.field_78808_h = field_78808_h2;
        rarm.field_78808_h = field_78808_h2;
        final ModelRenderer larm2 = this.larm;
        final ModelRenderer lsleeve2 = this.lsleeve;
        final ModelRenderer lchains2 = this.lchains;
        final float field_78796_g = MathHelper.func_76134_b(f2 * 0.24f) * 3.1415927f * 0.05f;
        lchains2.field_78796_g = field_78796_g;
        lsleeve2.field_78796_g = field_78796_g;
        larm2.field_78796_g = field_78796_g;
        final ModelRenderer rarm2 = this.rarm;
        final ModelRenderer rsleeve2 = this.rsleeve;
        final ModelRenderer rchains2 = this.rchains;
        final float field_78796_g2 = MathHelper.func_76134_b(f2 * 0.26f) * 3.1415927f * 0.05f;
        rchains2.field_78796_g = field_78796_g2;
        rsleeve2.field_78796_g = field_78796_g2;
        rarm2.field_78796_g = field_78796_g2;
        newangle = MathHelper.func_76134_b(f2 * 0.05f) * 3.1415927f * 2.0f;
        newrf1 = f2 * 0.05f % 6.2831855f;
        newrf1 = Math.abs(newrf1);
        if (newrf1 < r.rf2) {
            r.ri2 = 0;
            if (e.field_70170_p.field_73012_v.nextInt(3) == 1) {
                final RenderInfo renderInfo = r;
                renderInfo.ri2 |= 0x1;
            }
        }
        r.rf2 = newrf1;
        if ((r.ri2 & 0x1) == 0x0) {
            newangle = 0.0f;
        }
        this.head.field_78796_g = newangle;
        e.setRenderInfo(r);
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.75f, 0.75f, 0.75f, 0.25f);
        this.body.func_78785_a(f5);
        this.shirt.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.stem.func_78785_a(f5);
        this.rarm.func_78785_a(f5);
        this.larm.func_78785_a(f5);
        this.rsleeve.func_78785_a(f5);
        this.lsleeve.func_78785_a(f5);
        this.lchains.func_78785_a(f5);
        this.rchains.func_78785_a(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
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
