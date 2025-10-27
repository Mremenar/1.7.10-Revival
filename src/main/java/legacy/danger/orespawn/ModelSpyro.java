// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelSpyro extends ModelBase
{
    private float wingspeed;
    ModelRenderer RightFrontPaw;
    ModelRenderer WingLeft;
    ModelRenderer LegRightFrontTop;
    ModelRenderer LegRightFrontBottom;
    ModelRenderer LegRightBackTop;
    ModelRenderer LegRightBackBottom;
    ModelRenderer RightBackPaw;
    ModelRenderer LegLeftFrontTop;
    ModelRenderer SnoutRight;
    ModelRenderer LeftFrontPaw;
    ModelRenderer LegLeftBackTop;
    ModelRenderer LegLeftBackBottom;
    ModelRenderer LeftBackPaw;
    ModelRenderer LegLeftFrontBottom;
    ModelRenderer TailPieceSmall;
    ModelRenderer JawPiece;
    ModelRenderer HeadPieceBottom;
    ModelRenderer HeadPieceTop;
    ModelRenderer HornRightBottom;
    ModelRenderer HornLeftBottom;
    ModelRenderer HornRightTop;
    ModelRenderer HornLeftTop;
    ModelRenderer Torso;
    ModelRenderer SnoutLeft;
    ModelRenderer WingPieceLeft;
    ModelRenderer WingRight;
    ModelRenderer WingPieceRight;
    ModelRenderer Neck;
    ModelRenderer TailBack;
    ModelRenderer TailFront;
    ModelRenderer ScaleBackHead;
    ModelRenderer TailPieceLarge;
    ModelRenderer ScaleTailPiece;
    ModelRenderer ScaleHead;
    ModelRenderer ScaleTop1;
    ModelRenderer ScaleBackPiece1;
    ModelRenderer ScaleBackPiece2;
    
    public ModelSpyro(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.RightFrontPaw = new ModelRenderer((ModelBase)this, 12, 31)).func_78789_a(0.0f, 5.0f, -4.0f, 2, 1, 4);
        this.RightFrontPaw.func_78793_a(3.0f, 18.0f, -2.0f);
        this.RightFrontPaw.func_78787_b(64, 64);
        this.RightFrontPaw.field_78809_i = true;
        this.setRotation(this.RightFrontPaw, 0.0f, 0.0f, 0.0f);
        (this.WingLeft = new ModelRenderer((ModelBase)this, 2, 51)).func_78789_a(-10.0f, -1.0f, -2.0f, 10, 0, 4);
        this.WingLeft.func_78793_a(-1.0f, 16.0f, 0.0f);
        this.WingLeft.func_78787_b(64, 64);
        this.WingLeft.field_78809_i = true;
        this.setRotation(this.WingLeft, 0.1745329f, 0.0f, -0.1745329f);
        (this.LegRightFrontTop = new ModelRenderer((ModelBase)this, 20, 19)).func_78789_a(0.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegRightFrontTop.func_78793_a(3.0f, 18.0f, -2.0f);
        this.LegRightFrontTop.func_78787_b(64, 64);
        this.LegRightFrontTop.field_78809_i = true;
        this.setRotation(this.LegRightFrontTop, -0.0872665f, 0.0f, 0.0f);
        (this.LegRightFrontBottom = new ModelRenderer((ModelBase)this, 0, 25)).func_78789_a(0.0f, 2.0f, -1.5f, 2, 4, 2);
        this.LegRightFrontBottom.func_78793_a(3.0f, 18.0f, -2.0f);
        this.LegRightFrontBottom.func_78787_b(64, 64);
        this.LegRightFrontBottom.field_78809_i = true;
        this.setRotation(this.LegRightFrontBottom, -0.1745329f, 0.0f, 0.0f);
        (this.LegRightBackTop = new ModelRenderer((ModelBase)this, 30, 19)).func_78789_a(0.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegRightBackTop.func_78793_a(3.0f, 18.0f, 3.0f);
        this.LegRightBackTop.func_78787_b(64, 64);
        this.LegRightBackTop.field_78809_i = true;
        this.setRotation(this.LegRightBackTop, 0.1396263f, 0.0f, 0.0f);
        (this.LegRightBackBottom = new ModelRenderer((ModelBase)this, 16, 25)).func_78789_a(0.0f, 2.0f, -1.0f, 2, 4, 2);
        this.LegRightBackBottom.func_78793_a(3.0f, 18.0f, 3.0f);
        this.LegRightBackBottom.func_78787_b(64, 64);
        this.LegRightBackBottom.field_78809_i = true;
        this.setRotation(this.LegRightBackBottom, -0.1745329f, 0.0f, 0.0f);
        (this.RightBackPaw = new ModelRenderer((ModelBase)this, 36, 31)).func_78789_a(0.0f, 5.0f, -3.0f, 2, 1, 4);
        this.RightBackPaw.func_78793_a(3.0f, 18.0f, 3.0f);
        this.RightBackPaw.func_78787_b(64, 64);
        this.RightBackPaw.field_78809_i = true;
        this.setRotation(this.RightBackPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftFrontTop = new ModelRenderer((ModelBase)this, 0, 19)).func_78789_a(-2.0f, 0.0f, -1.0f, 2, 3, 3);
        this.LegLeftFrontTop.func_78793_a(-2.0f, 18.0f, -3.0f);
        this.LegLeftFrontTop.func_78787_b(64, 64);
        this.LegLeftFrontTop.field_78809_i = true;
        this.setRotation(this.LegLeftFrontTop, -0.0872665f, 0.0f, 0.0f);
        (this.SnoutRight = new ModelRenderer((ModelBase)this, 48, 2)).func_78789_a(1.0f, -3.0f, -5.0f, 1, 1, 1);
        this.SnoutRight.func_78793_a(1.0f, 16.0f, -3.0f);
        this.SnoutRight.func_78787_b(64, 64);
        this.SnoutRight.field_78809_i = true;
        this.setRotation(this.SnoutRight, 0.0f, 0.0f, 0.0f);
        (this.LeftFrontPaw = new ModelRenderer((ModelBase)this, 0, 31)).func_78789_a(-2.0f, 5.0f, -3.0f, 2, 1, 4);
        this.LeftFrontPaw.func_78793_a(-2.0f, 18.0f, -3.0f);
        this.LeftFrontPaw.func_78787_b(64, 64);
        this.LeftFrontPaw.field_78809_i = true;
        this.setRotation(this.LeftFrontPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftBackTop = new ModelRenderer((ModelBase)this, 10, 19)).func_78789_a(-2.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegLeftBackTop.func_78793_a(-2.0f, 18.0f, 3.0f);
        this.LegLeftBackTop.func_78787_b(64, 64);
        this.LegLeftBackTop.field_78809_i = true;
        this.setRotation(this.LegLeftBackTop, 0.1396263f, 0.0f, 0.0f);
        (this.LegLeftBackBottom = new ModelRenderer((ModelBase)this, 24, 25)).func_78789_a(-2.0f, 2.0f, -1.0f, 2, 4, 2);
        this.LegLeftBackBottom.func_78793_a(-2.0f, 18.0f, 3.0f);
        this.LegLeftBackBottom.func_78787_b(64, 64);
        this.LegLeftBackBottom.field_78809_i = true;
        this.setRotation(this.LegLeftBackBottom, -0.1745329f, 0.0f, 0.0f);
        (this.LeftBackPaw = new ModelRenderer((ModelBase)this, 24, 31)).func_78789_a(-2.0f, 5.0f, -3.0f, 2, 1, 4);
        this.LeftBackPaw.func_78793_a(-2.0f, 18.0f, 3.0f);
        this.LeftBackPaw.func_78787_b(64, 64);
        this.LeftBackPaw.field_78809_i = true;
        this.setRotation(this.LeftBackPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftFrontBottom = new ModelRenderer((ModelBase)this, 8, 25)).func_78789_a(-2.0f, 2.0f, -0.5f, 2, 4, 2);
        this.LegLeftFrontBottom.func_78793_a(-2.0f, 18.0f, -3.0f);
        this.LegLeftFrontBottom.func_78787_b(64, 64);
        this.LegLeftFrontBottom.field_78809_i = true;
        this.setRotation(this.LegLeftFrontBottom, -0.1745329f, 0.0f, 0.0f);
        (this.TailPieceSmall = new ModelRenderer((ModelBase)this, 28, 36)).func_78789_a(0.0f, -0.5f, 4.0f, 1, 1, 1);
        this.TailPieceSmall.func_78793_a(0.0f, 16.0f, 7.0f);
        this.TailPieceSmall.func_78787_b(64, 64);
        this.TailPieceSmall.field_78809_i = true;
        this.setRotation(this.TailPieceSmall, 0.1745329f, 0.0f, 0.0f);
        (this.JawPiece = new ModelRenderer((ModelBase)this, 52, 0)).func_78789_a(-2.0f, -1.0f, -4.0f, 3, 1, 3);
        this.JawPiece.func_78793_a(1.0f, 16.0f, -3.0f);
        this.JawPiece.func_78787_b(64, 64);
        this.JawPiece.field_78809_i = true;
        this.setRotation(this.JawPiece, 0.1745329f, 0.0f, 0.0f);
        (this.HeadPieceBottom = new ModelRenderer((ModelBase)this, 30, 7)).func_78789_a(-3.0f, -2.0f, -5.0f, 5, 2, 6);
        this.HeadPieceBottom.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HeadPieceBottom.func_78787_b(64, 64);
        this.HeadPieceBottom.field_78809_i = true;
        this.setRotation(this.HeadPieceBottom, 0.0f, 0.0f, 0.0f);
        (this.HeadPieceTop = new ModelRenderer((ModelBase)this, 30, 0)).func_78789_a(-3.0f, -5.0f, -3.0f, 5, 3, 4);
        this.HeadPieceTop.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HeadPieceTop.func_78787_b(64, 64);
        this.HeadPieceTop.field_78809_i = true;
        this.setRotation(this.HeadPieceTop, 0.0f, 0.0f, 0.0f);
        (this.HornRightBottom = new ModelRenderer((ModelBase)this, 8, 14)).func_78789_a(0.0f, -6.0f, -3.5f, 2, 3, 2);
        this.HornRightBottom.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HornRightBottom.func_78787_b(64, 64);
        this.HornRightBottom.field_78809_i = true;
        this.setRotation(this.HornRightBottom, -0.7853982f, 0.7853982f, 0.0f);
        (this.HornLeftBottom = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(-2.75f, -6.5f, -3.0f, 2, 3, 2);
        this.HornLeftBottom.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HornLeftBottom.func_78787_b(64, 64);
        this.HornLeftBottom.field_78809_i = true;
        this.setRotation(this.HornLeftBottom, -0.7853982f, -0.7853982f, 0.0f);
        (this.HornRightTop = new ModelRenderer((ModelBase)this, 20, 14)).func_78789_a(0.5f, -9.0f, -3.0f, 1, 3, 1);
        this.HornRightTop.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HornRightTop.func_78787_b(64, 64);
        this.HornRightTop.field_78809_i = true;
        this.setRotation(this.HornRightTop, -0.7853982f, 0.7853982f, 0.0f);
        (this.HornLeftTop = new ModelRenderer((ModelBase)this, 16, 14)).func_78789_a(-2.2f, -9.5f, -2.5f, 1, 3, 1);
        this.HornLeftTop.func_78793_a(1.0f, 16.0f, -3.0f);
        this.HornLeftTop.func_78787_b(64, 64);
        this.HornLeftTop.field_78809_i = true;
        this.setRotation(this.HornLeftTop, -0.7853982f, -0.7853982f, 0.0f);
        (this.Torso = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-2.0f, -2.0f, -5.0f, 5, 4, 10);
        this.Torso.func_78793_a(0.0f, 19.0f, 0.0f);
        this.Torso.func_78787_b(64, 64);
        this.Torso.field_78809_i = true;
        this.setRotation(this.Torso, 0.0f, 0.0f, 0.0f);
        (this.SnoutLeft = new ModelRenderer((ModelBase)this, 48, 0)).func_78789_a(-3.0f, -3.0f, -5.0f, 1, 1, 1);
        this.SnoutLeft.func_78793_a(1.0f, 16.0f, -3.0f);
        this.SnoutLeft.func_78787_b(64, 64);
        this.SnoutLeft.field_78809_i = true;
        this.setRotation(this.SnoutLeft, 0.0f, 0.0f, 0.0f);
        (this.WingPieceLeft = new ModelRenderer((ModelBase)this, 4, 42)).func_78789_a(-1.0f, -2.0f, -1.0f, 1, 2, 1);
        this.WingPieceLeft.func_78793_a(0.0f, 17.2f, 0.0f);
        this.WingPieceLeft.func_78787_b(64, 64);
        this.WingPieceLeft.field_78809_i = true;
        this.setRotation(this.WingPieceLeft, 0.1745329f, 0.0f, -0.1745329f);
        (this.WingRight = new ModelRenderer((ModelBase)this, 2, 45)).func_78789_a(0.0f, -1.0f, -2.0f, 10, 0, 4);
        this.WingRight.func_78793_a(2.0f, 16.0f, 0.0f);
        this.WingRight.func_78787_b(64, 64);
        this.WingRight.field_78809_i = true;
        this.setRotation(this.WingRight, 0.1745329f, 0.0f, 0.1745329f);
        (this.WingPieceRight = new ModelRenderer((ModelBase)this, 0, 42)).func_78789_a(-1.0f, -2.0f, 0.0f, 1, 2, 1);
        this.WingPieceRight.func_78793_a(2.0f, 17.5f, -1.0f);
        this.WingPieceRight.func_78787_b(64, 64);
        this.WingPieceRight.field_78809_i = true;
        this.setRotation(this.WingPieceRight, 0.1745329f, 0.0f, 0.1745329f);
        (this.Neck = new ModelRenderer((ModelBase)this, 52, 7)).func_78789_a(-1.0f, -2.0f, -1.0f, 3, 3, 3);
        this.Neck.func_78793_a(0.0f, 17.0f, -4.0f);
        this.Neck.func_78787_b(64, 64);
        this.Neck.field_78809_i = true;
        this.setRotation(this.Neck, 0.4537856f, 0.0f, 0.0f);
        (this.TailBack = new ModelRenderer((ModelBase)this, 0, 36)).func_78789_a(-1.0f, -1.0f, -1.0f, 2, 2, 4);
        this.TailBack.func_78793_a(0.5f, 17.5f, 5.0f);
        this.TailBack.func_78787_b(64, 64);
        this.TailBack.field_78809_i = true;
        this.setRotation(this.TailBack, 0.4537856f, 0.0f, 0.0f);
        (this.TailFront = new ModelRenderer((ModelBase)this, 12, 36)).func_78789_a(0.0f, 0.0f, -1.0f, 1, 1, 4);
        this.TailFront.func_78793_a(0.0f, 16.0f, 7.0f);
        this.TailFront.func_78787_b(64, 64);
        this.TailFront.field_78809_i = true;
        this.setRotation(this.TailFront, 0.2617994f, 0.0f, 0.0f);
        (this.ScaleBackHead = new ModelRenderer((ModelBase)this, 38, 36)).func_78789_a(-1.0f, -3.0f, 2.0f, 1, 2, 1);
        this.ScaleBackHead.func_78793_a(1.0f, 16.0f, -4.0f);
        this.ScaleBackHead.func_78787_b(64, 64);
        this.ScaleBackHead.field_78809_i = true;
        this.setRotation(this.ScaleBackHead, 0.0f, 0.0f, 0.0f);
        (this.TailPieceLarge = new ModelRenderer((ModelBase)this, 22, 36)).func_78789_a(0.0f, -1.0f, 2.0f, 1, 2, 2);
        this.TailPieceLarge.func_78793_a(0.0f, 16.0f, 7.0f);
        this.TailPieceLarge.func_78787_b(64, 64);
        this.TailPieceLarge.field_78809_i = true;
        this.setRotation(this.TailPieceLarge, 0.1745329f, 0.0f, 0.0f);
        (this.ScaleTailPiece = new ModelRenderer((ModelBase)this, 48, 36)).func_78789_a(-0.5f, -2.0f, 0.2f, 1, 1, 2);
        this.ScaleTailPiece.func_78793_a(0.5f, 17.5f, 5.0f);
        this.ScaleTailPiece.func_78787_b(64, 64);
        this.ScaleTailPiece.field_78809_i = true;
        this.setRotation(this.ScaleTailPiece, 0.4537856f, 0.0f, 0.0f);
        (this.ScaleHead = new ModelRenderer((ModelBase)this, 42, 36)).func_78789_a(-1.0f, -6.0f, 0.0f, 1, 2, 2);
        this.ScaleHead.func_78793_a(1.0f, 16.0f, -3.0f);
        this.ScaleHead.func_78787_b(64, 64);
        this.ScaleHead.field_78809_i = true;
        this.setRotation(this.ScaleHead, 0.0f, 0.0f, 0.0f);
        (this.ScaleTop1 = new ModelRenderer((ModelBase)this, 48, 36)).func_78789_a(-1.0f, -6.0f, -4.0f, 1, 1, 2);
        this.ScaleTop1.func_78793_a(1.0f, 16.0f, -2.0f);
        this.ScaleTop1.func_78787_b(64, 64);
        this.ScaleTop1.field_78809_i = true;
        this.setRotation(this.ScaleTop1, 0.0f, 0.0f, 0.0f);
        (this.ScaleBackPiece1 = new ModelRenderer((ModelBase)this, 48, 36)).func_78789_a(0.0f, -1.0f, -1.0f, 1, 1, 2);
        this.ScaleBackPiece1.func_78793_a(0.0f, 17.0f, 0.0f);
        this.ScaleBackPiece1.func_78787_b(64, 64);
        this.ScaleBackPiece1.field_78809_i = true;
        this.setRotation(this.ScaleBackPiece1, 0.0f, 0.0f, 0.0f);
        (this.ScaleBackPiece2 = new ModelRenderer((ModelBase)this, 48, 36)).func_78789_a(0.0f, -1.0f, -1.0f, 1, 1, 2);
        this.ScaleBackPiece2.func_78793_a(0.0f, 17.0f, 3.0f);
        this.ScaleBackPiece2.func_78787_b(64, 64);
        this.ScaleBackPiece2.field_78809_i = true;
        this.setRotation(this.ScaleBackPiece2, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Spyro c = (Spyro)entity;
        final float hf = 0.0f;
        float newangle = 0.0f;
        final int current_activity = c.getActivity();
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.4f * f1;
        }
        else {
            newangle = 0.0f;
        }
        if (current_activity == 3) {
            newangle *= 0.5f;
        }
        this.WingLeft.field_78808_h = newangle;
        this.WingRight.field_78808_h = -newangle;
        if (f1 > 0.1) {
            newangle = MathHelper.func_76134_b(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        }
        else {
            newangle = 0.0f;
        }
        if (current_activity == 3) {
            newangle = 0.0f;
        }
        if (current_activity != 2) {
            this.LegRightFrontTop.field_78795_f = newangle - 0.087f;
            this.LegRightFrontBottom.field_78795_f = newangle - 0.17f;
            this.RightFrontPaw.field_78795_f = newangle;
            this.LegLeftFrontTop.field_78795_f = -newangle - 0.087f;
            this.LegLeftFrontBottom.field_78795_f = -newangle - 0.17f;
            this.LeftFrontPaw.field_78795_f = -newangle;
            this.LegRightBackBottom.field_78795_f = -newangle + 0.139f;
            this.LegRightBackTop.field_78795_f = -newangle - 0.174f;
            this.RightBackPaw.field_78795_f = -newangle;
            this.LegLeftBackBottom.field_78795_f = newangle + 0.139f;
            this.LegLeftBackTop.field_78795_f = newangle - 0.174f;
            this.LeftBackPaw.field_78795_f = newangle;
        }
        else {
            newangle = -1.0f;
            this.LegRightFrontTop.field_78795_f = newangle - 0.087f;
            this.LegRightFrontBottom.field_78795_f = newangle - 0.17f;
            this.RightFrontPaw.field_78795_f = newangle;
            this.LegLeftFrontTop.field_78795_f = newangle - 0.087f;
            this.LegLeftFrontBottom.field_78795_f = newangle - 0.17f;
            this.LeftFrontPaw.field_78795_f = newangle;
            newangle = 1.0f;
            this.LegRightBackBottom.field_78795_f = newangle + 0.139f;
            this.LegRightBackTop.field_78795_f = newangle - 0.174f;
            this.RightBackPaw.field_78795_f = newangle;
            this.LegLeftBackBottom.field_78795_f = newangle + 0.139f;
            this.LegLeftBackTop.field_78795_f = newangle - 0.174f;
            this.LeftBackPaw.field_78795_f = newangle;
        }
        newangle = MathHelper.func_76134_b(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.25f;
        if (c.func_70906_o() || current_activity == 3) {
            newangle = 0.0f;
        }
        this.TailBack.field_78796_g = newangle;
        this.ScaleTailPiece.field_78796_g = newangle;
        this.TailFront.field_78798_e = this.TailBack.field_78798_e + (float)Math.cos(this.TailBack.field_78796_g) * 3.0f;
        this.TailFront.field_78800_c = this.TailBack.field_78800_c + (float)Math.sin(this.TailBack.field_78796_g) * 3.0f - 0.5f;
        this.TailFront.field_78796_g = newangle * 1.6f;
        this.TailPieceLarge.field_78798_e = this.TailFront.field_78798_e;
        this.TailPieceLarge.field_78800_c = this.TailFront.field_78800_c;
        this.TailPieceLarge.field_78796_g = this.TailFront.field_78796_g;
        this.TailPieceSmall.field_78798_e = this.TailFront.field_78798_e;
        this.TailPieceSmall.field_78800_c = this.TailFront.field_78800_c;
        this.TailPieceSmall.field_78796_g = this.TailFront.field_78796_g;
        this.HeadPieceTop.field_78796_g = (float)Math.toRadians(f3);
        this.HeadPieceBottom.field_78796_g = (float)Math.toRadians(f3);
        this.JawPiece.field_78796_g = (float)Math.toRadians(f3);
        this.SnoutRight.field_78796_g = (float)Math.toRadians(f3);
        this.SnoutLeft.field_78796_g = (float)Math.toRadians(f3);
        this.ScaleTop1.field_78796_g = (float)Math.toRadians(f3);
        this.ScaleHead.field_78796_g = (float)Math.toRadians(f3);
        this.ScaleBackHead.field_78796_g = (float)Math.toRadians(f3);
        this.HornRightBottom.field_78796_g = (float)Math.toRadians(f3) + 0.785f;
        this.HornRightTop.field_78796_g = (float)Math.toRadians(f3) + 0.785f;
        this.HornLeftBottom.field_78796_g = (float)Math.toRadians(f3) - 0.785f;
        this.HornLeftTop.field_78796_g = (float)Math.toRadians(f3) - 0.785f;
        this.HeadPieceTop.field_78795_f = (float)Math.toRadians(f4);
        this.HeadPieceBottom.field_78795_f = (float)Math.toRadians(f4);
        this.JawPiece.field_78795_f = (float)Math.toRadians(f4);
        this.SnoutRight.field_78795_f = (float)Math.toRadians(f4);
        this.SnoutLeft.field_78795_f = (float)Math.toRadians(f4);
        this.ScaleTop1.field_78795_f = (float)Math.toRadians(f4);
        this.ScaleHead.field_78795_f = (float)Math.toRadians(f4);
        this.ScaleBackHead.field_78795_f = (float)Math.toRadians(f4);
        this.HornRightBottom.field_78795_f = (float)Math.toRadians(f4) - 0.785f;
        this.HornRightTop.field_78795_f = (float)Math.toRadians(f4) - 0.785f;
        this.HornLeftBottom.field_78795_f = (float)Math.toRadians(f4) - 0.785f;
        this.HornLeftTop.field_78795_f = (float)Math.toRadians(f4) - 0.785f;
        this.RightFrontPaw.func_78785_a(f5);
        this.WingLeft.func_78785_a(f5);
        this.LegRightFrontTop.func_78785_a(f5);
        this.LegRightFrontBottom.func_78785_a(f5);
        this.LegRightBackTop.func_78785_a(f5);
        this.LegRightBackBottom.func_78785_a(f5);
        this.RightBackPaw.func_78785_a(f5);
        this.LegLeftFrontTop.func_78785_a(f5);
        this.SnoutRight.func_78785_a(f5);
        this.LeftFrontPaw.func_78785_a(f5);
        this.LegLeftBackTop.func_78785_a(f5);
        this.LegLeftBackBottom.func_78785_a(f5);
        this.LeftBackPaw.func_78785_a(f5);
        this.LegLeftFrontBottom.func_78785_a(f5);
        this.TailPieceSmall.func_78785_a(f5);
        this.JawPiece.func_78785_a(f5);
        this.HeadPieceBottom.func_78785_a(f5);
        this.HeadPieceTop.func_78785_a(f5);
        this.HornRightBottom.func_78785_a(f5);
        this.HornLeftBottom.func_78785_a(f5);
        this.HornRightTop.func_78785_a(f5);
        this.HornLeftTop.func_78785_a(f5);
        this.Torso.func_78785_a(f5);
        this.SnoutLeft.func_78785_a(f5);
        this.WingPieceLeft.func_78785_a(f5);
        this.WingRight.func_78785_a(f5);
        this.WingPieceRight.func_78785_a(f5);
        this.Neck.func_78785_a(f5);
        this.TailBack.func_78785_a(f5);
        this.TailFront.func_78785_a(f5);
        this.ScaleBackHead.func_78785_a(f5);
        this.TailPieceLarge.func_78785_a(f5);
        this.ScaleTailPiece.func_78785_a(f5);
        this.ScaleHead.func_78785_a(f5);
        this.ScaleTop1.func_78785_a(f5);
        this.ScaleBackPiece1.func_78785_a(f5);
        this.ScaleBackPiece2.func_78785_a(f5);
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
