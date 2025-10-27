// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelFirefly extends ModelBase
{
    private float wingspeed;
    ModelRenderer body;
    ModelRenderer wing_left;
    ModelRenderer wing_right;
    ModelRenderer head;
    ModelRenderer mouth;
    ModelRenderer eye_left;
    ModelRenderer eye_right;
    ModelRenderer front_leg_left_;
    ModelRenderer front_leg_right;
    ModelRenderer back_leg_left;
    ModelRenderer back_leg_right;
    ModelRenderer TailLight;
    
    public ModelFirefly(final float f1) {
        this.wingspeed = 1.0f;
        this.field_78090_t = 64;
        this.field_78089_u = 128;
        this.wingspeed = f1;
        (this.body = new ModelRenderer((ModelBase)this, 38, 12)).func_78789_a(-3.0f, -3.0f, -3.0f, 5, 5, 5);
        this.body.func_78793_a(-1.0f, 9.0f, -1.0f);
        this.body.func_78787_b(64, 128);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.wing_left = new ModelRenderer((ModelBase)this, 46, 0)).func_78789_a(0.0f, -6.0f, 0.0f, 0, 6, 2);
        this.wing_left.func_78793_a(1.0f, 6.0f, -2.0f);
        this.wing_left.func_78787_b(64, 128);
        this.wing_left.field_78809_i = true;
        this.setRotation(this.wing_left, 0.0f, 0.0174533f, 0.6981317f);
        (this.wing_right = new ModelRenderer((ModelBase)this, 53, 0)).func_78789_a(0.0f, -6.0f, 0.0f, 0, 6, 2);
        this.wing_right.func_78793_a(-4.0f, 6.0f, -2.0f);
        this.wing_right.func_78787_b(64, 128);
        this.wing_right.field_78809_i = true;
        this.setRotation(this.wing_right, 0.0f, 0.0f, -0.6981317f);
        (this.head = new ModelRenderer((ModelBase)this, 3, 14)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.head.func_78793_a(-3.0f, 7.0f, -7.0f);
        this.head.func_78787_b(64, 128);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.2230717f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase)this, 26, 15)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.mouth.func_78793_a(-2.0f, 9.0f, -8.0f);
        this.mouth.func_78787_b(64, 128);
        this.mouth.field_78809_i = true;
        this.setRotation(this.mouth, 0.2117115f, 0.0f, 0.0f);
        (this.eye_left = new ModelRenderer((ModelBase)this, 18, 12)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 2, 2);
        this.eye_left.func_78793_a(-1.0f, 6.5f, -6.0f);
        this.eye_left.func_78787_b(64, 128);
        this.eye_left.field_78809_i = true;
        this.setRotation(this.eye_left, 0.0174533f, 0.2602503f, -0.2230717f);
        (this.eye_right = new ModelRenderer((ModelBase)this, 18, 18)).func_78789_a(1.0f, -0.6f, -0.6f, 1, 2, 2);
        this.eye_right.func_78793_a(-4.0f, 6.5f, -6.0f);
        this.eye_right.func_78787_b(64, 128);
        this.eye_right.field_78809_i = true;
        this.setRotation(this.eye_right, 0.0f, -0.2602503f, 0.2230717f);
        (this.front_leg_left_ = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.front_leg_left_.func_78793_a(-1.0f, 10.0f, -3.0f);
        this.front_leg_left_.func_78787_b(64, 128);
        this.front_leg_left_.field_78809_i = true;
        this.setRotation(this.front_leg_left_, -0.2792527f, 0.0f, -0.2792527f);
        (this.front_leg_right = new ModelRenderer((ModelBase)this, 22, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.front_leg_right.func_78793_a(-3.0f, 10.0f, -3.0f);
        this.front_leg_right.func_78787_b(64, 128);
        this.front_leg_right.field_78809_i = true;
        this.setRotation(this.front_leg_right, -0.2792527f, 0.0f, 0.2792527f);
        (this.back_leg_left = new ModelRenderer((ModelBase)this, 11, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.back_leg_left.func_78793_a(-1.0f, 10.0f, -1.0f);
        this.back_leg_left.func_78787_b(64, 128);
        this.back_leg_left.field_78809_i = true;
        this.setRotation(this.back_leg_left, 0.2792527f, 0.0f, -0.2792527f);
        (this.back_leg_right = new ModelRenderer((ModelBase)this, 2, 0)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.back_leg_right.func_78793_a(-3.0f, 10.0f, -1.0f);
        this.back_leg_right.func_78787_b(64, 128);
        this.back_leg_right.field_78809_i = true;
        this.setRotation(this.back_leg_right, 0.2792527f, 0.0f, 0.2792527f);
        (this.TailLight = new ModelRenderer((ModelBase)this, 10, 27)).func_78789_a(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.TailLight.func_78793_a(-3.0f, 6.0f, 1.0f);
        this.TailLight.func_78787_b(64, 128);
        this.TailLight.field_78809_i = true;
        this.setRotation(this.TailLight, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Firefly fly = (Firefly)entity;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float onoff = 0.0f;
        this.wing_left.field_78808_h = 1.11f + MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.35f;
        this.wing_right.field_78808_h = -1.11f - MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.35f;
        this.body.func_78785_a(f5);
        this.wing_left.func_78785_a(f5);
        this.wing_right.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.mouth.func_78785_a(f5);
        this.eye_left.func_78785_a(f5);
        this.eye_right.func_78785_a(f5);
        this.front_leg_left_.func_78785_a(f5);
        this.front_leg_right.func_78785_a(f5);
        this.back_leg_left.func_78785_a(f5);
        this.back_leg_right.func_78785_a(f5);
        onoff = fly.getBlink();
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, onoff, 240.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.TailLight.func_78785_a(f5);
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
