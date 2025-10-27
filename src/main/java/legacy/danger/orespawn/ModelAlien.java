// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelAlien extends ModelBase
{
    private float wingspeed;
    ModelRenderer torso;
    ModelRenderer stomach;
    ModelRenderer rThigh;
    ModelRenderer lThigh;
    ModelRenderer lShin;
    ModelRenderer rShin;
    ModelRenderer lShin1;
    ModelRenderer rShin1;
    ModelRenderer lFoot;
    ModelRenderer rFoot;
    ModelRenderer neck;
    ModelRenderer fan;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer tail1;
    ModelRenderer fanl1;
    ModelRenderer fanr1;
    ModelRenderer fanl2;
    ModelRenderer fanr2;
    ModelRenderer fanl3;
    ModelRenderer fanr3;
    ModelRenderer fanl4;
    ModelRenderer fanr4;
    ModelRenderer fanl5;
    ModelRenderer fanr5;
    ModelRenderer fanl6;
    ModelRenderer fanr6;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer spike3;
    ModelRenderer fanl7;
    ModelRenderer fanr7;
    ModelRenderer head;
    ModelRenderer head1;
    ModelRenderer jaw1;
    ModelRenderer head2;
    ModelRenderer jaw2;
    ModelRenderer fang1;
    ModelRenderer fang2;
    ModelRenderer fang3;
    ModelRenderer fang4;
    ModelRenderer spike2;
    ModelRenderer spike1;
    ModelRenderer arml1;
    ModelRenderer armr1;
    ModelRenderer arml2;
    ModelRenderer armr2;
    ModelRenderer clawr1;
    ModelRenderer clawr2;
    ModelRenderer clawr3;
    ModelRenderer clawl2;
    ModelRenderer clawl3;
    ModelRenderer clawl1;
    
    public ModelAlien(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 256;
        this.field_78089_u = 128;
        (this.torso = new ModelRenderer((ModelBase)this, 0, 46)).func_78789_a(-4.5f, -2.0f, 0.0f, 9, 8, 10);
        this.torso.func_78793_a(0.0f, -2.5f, -8.0f);
        this.torso.func_78787_b(64, 32);
        this.torso.field_78809_i = true;
        this.setRotation(this.torso, -0.1919862f, 0.0f, 0.0f);
        (this.stomach = new ModelRenderer((ModelBase)this, 0, 27)).func_78789_a(-3.5f, -5.0f, 8.0f, 7, 6, 12);
        this.stomach.func_78793_a(0.0f, -2.5f, -8.0f);
        this.stomach.func_78787_b(64, 32);
        this.stomach.field_78809_i = true;
        this.setRotation(this.stomach, -0.5585054f, 0.0f, 0.0f);
        (this.rThigh = new ModelRenderer((ModelBase)this, 59, 45)).func_78789_a(-1.5f, -4.0f, -2.5f, 4, 14, 5);
        this.rThigh.func_78793_a(-4.5f, 7.0f, 8.0f);
        this.rThigh.func_78787_b(64, 32);
        this.rThigh.field_78809_i = true;
        this.setRotation(this.rThigh, -0.8028515f, 0.2443461f, 0.418879f);
        (this.lThigh = new ModelRenderer((ModelBase)this, 40, 45)).func_78789_a(-2.5f, -4.0f, -2.5f, 4, 14, 5);
        this.lThigh.func_78793_a(4.5f, 7.0f, 8.0f);
        this.lThigh.func_78787_b(64, 32);
        this.lThigh.field_78809_i = true;
        this.setRotation(this.lThigh, -0.8028515f, -0.2443461f, -0.418879f);
        (this.lShin = new ModelRenderer((ModelBase)this, 79, 49)).func_78789_a(-2.0f, 8.0f, -5.5f, 3, 3, 12);
        this.lShin.func_78793_a(4.5f, 7.0f, 8.0f);
        this.lShin.func_78787_b(64, 32);
        this.lShin.field_78809_i = true;
        this.setRotation(this.lShin, -0.4014257f, -0.2443461f, -0.418879f);
        (this.rShin = new ModelRenderer((ModelBase)this, 79, 33)).func_78789_a(-1.0f, 8.0f, -5.5f, 3, 3, 12);
        this.rShin.func_78793_a(-4.5f, 7.0f, 8.0f);
        this.rShin.func_78787_b(64, 32);
        this.rShin.field_78809_i = true;
        this.setRotation(this.rShin, -0.4014257f, 0.2443461f, 0.418879f);
        (this.lShin1 = new ModelRenderer((ModelBase)this, 113, 40)).func_78789_a(-1.5f, 5.5f, 9.0f, 2, 9, 2);
        this.lShin1.func_78793_a(4.5f, 7.0f, 8.0f);
        this.lShin1.func_78787_b(64, 32);
        this.lShin1.field_78809_i = true;
        this.setRotation(this.lShin1, -0.8028515f, -0.2443461f, -0.418879f);
        (this.rShin1 = new ModelRenderer((ModelBase)this, 113, 53)).func_78789_a(-0.5f, 5.5f, 9.0f, 2, 9, 2);
        this.rShin1.func_78793_a(-4.5f, 7.0f, 8.0f);
        this.rShin1.func_78787_b(64, 32);
        this.rShin1.field_78809_i = true;
        this.setRotation(this.rShin1, -0.8028515f, 0.2443461f, 0.418879f);
        (this.lFoot = new ModelRenderer((ModelBase)this, 110, 24)).func_78789_a(5.0f, 15.0f, -8.0f, 2, 2, 6);
        this.lFoot.func_78793_a(4.5f, 7.0f, 8.0f);
        this.lFoot.func_78787_b(64, 32);
        this.lFoot.field_78809_i = true;
        this.setRotation(this.lFoot, 0.0f, -0.2443461f, 0.0f);
        (this.rFoot = new ModelRenderer((ModelBase)this, 95, 24)).func_78789_a(-7.0f, 15.0f, -8.0f, 2, 2, 6);
        this.rFoot.func_78793_a(-4.5f, 7.0f, 8.0f);
        this.rFoot.func_78787_b(64, 32);
        this.rFoot.field_78809_i = true;
        this.setRotation(this.rFoot, 0.0f, 0.2443461f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 23, 86)).func_78789_a(-2.0f, -2.0f, -4.0f, 4, 6, 5);
        this.neck.func_78793_a(0.0f, -2.5f, -8.0f);
        this.neck.func_78787_b(64, 32);
        this.neck.field_78809_i = true;
        this.setRotation(this.neck, -0.1919862f, 0.0f, 0.0f);
        (this.fan = new ModelRenderer((ModelBase)this, 149, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fan.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fan.func_78787_b(64, 32);
        this.fan.field_78809_i = true;
        this.setRotation(this.fan, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 85, 66)).func_78789_a(-2.0f, -1.5f, 0.0f, 4, 4, 11);
        this.tail2.func_78793_a(0.0f, 9.5f, 20.5f);
        this.tail2.func_78787_b(64, 32);
        this.tail2.field_78809_i = true;
        this.setRotation(this.tail2, -0.3141593f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 118, 66)).func_78789_a(-1.5f, -1.5f, 0.0f, 3, 3, 11);
        this.tail3.func_78793_a(0.0f, 13.5f, 30.5f);
        this.tail3.func_78787_b(64, 32);
        this.tail3.field_78809_i = true;
        this.setRotation(this.tail3, -0.2094395f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, 149, 66)).func_78789_a(-1.0f, -1.0f, 0.0f, 2, 2, 11);
        this.tail4.func_78793_a(0.0f, 15.5f, 40.5f);
        this.tail4.func_78787_b(64, 32);
        this.tail4.field_78809_i = true;
        this.setRotation(this.tail4, -0.1396263f, 0.0f, 0.0f);
        (this.tail5 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 11);
        this.tail5.func_78793_a(0.0f, 17.5f, 50.5f);
        this.tail5.func_78787_b(64, 32);
        this.tail5.field_78809_i = true;
        this.setRotation(this.tail5, -0.0523599f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 50, 66)).func_78789_a(-2.0f, -2.5f, 0.0f, 4, 4, 11);
        this.tail1.func_78793_a(0.0f, 6.5f, 10.5f);
        this.tail1.func_78787_b(64, 32);
        this.tail1.field_78809_i = true;
        this.setRotation(this.tail1, -0.4014257f, 0.0f, 0.0f);
        (this.fanl1 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl1.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl1.func_78787_b(64, 32);
        this.fanl1.field_78809_i = true;
        this.setRotation(this.fanl1, 0.0f, 0.0f, 0.2617994f);
        (this.fanr1 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr1.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr1.func_78787_b(64, 32);
        this.fanr1.field_78809_i = true;
        this.setRotation(this.fanr1, 0.0f, 0.0f, -0.2617994f);
        (this.fanl2 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl2.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl2.func_78787_b(64, 32);
        this.fanl2.field_78809_i = true;
        this.setRotation(this.fanl2, 0.0f, 0.0f, 0.5235988f);
        (this.fanr2 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr2.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr2.func_78787_b(64, 32);
        this.fanr2.field_78809_i = true;
        this.setRotation(this.fanr2, 0.0f, 0.0f, -0.5235988f);
        (this.fanl3 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl3.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl3.func_78787_b(64, 32);
        this.fanl3.field_78809_i = true;
        this.setRotation(this.fanl3, 0.0f, 0.0f, 0.7853982f);
        (this.fanr3 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr3.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr3.func_78787_b(64, 32);
        this.fanr3.field_78809_i = true;
        this.setRotation(this.fanr3, 0.0f, 0.0f, -0.7853982f);
        (this.fanl4 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl4.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl4.func_78787_b(64, 32);
        this.fanl4.field_78809_i = true;
        this.setRotation(this.fanl4, 0.0f, 0.0f, 1.047198f);
        (this.fanr4 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr4.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr4.func_78787_b(64, 32);
        this.fanr4.field_78809_i = true;
        this.setRotation(this.fanr4, 0.0f, 0.0f, -1.047198f);
        (this.fanl5 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl5.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl5.func_78787_b(64, 32);
        this.fanl5.field_78809_i = true;
        this.setRotation(this.fanl5, 0.0f, 0.0f, 1.308997f);
        (this.fanr5 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr5.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr5.func_78787_b(64, 32);
        this.fanr5.field_78809_i = true;
        this.setRotation(this.fanr5, 0.0f, 0.0f, -1.308997f);
        (this.fanl6 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl6.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl6.func_78787_b(64, 32);
        this.fanl6.field_78809_i = true;
        this.setRotation(this.fanl6, 0.0f, 0.0f, 1.570796f);
        (this.fanr6 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr6.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr6.func_78787_b(64, 32);
        this.fanr6.field_78809_i = true;
        this.setRotation(this.fanr6, 0.0f, 0.0f, -1.570796f);
        (this.spike4 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 11);
        this.spike4.func_78793_a(0.0f, 16.0f, 41.0f);
        this.spike4.func_78787_b(64, 32);
        this.spike4.field_78809_i = true;
        this.setRotation(this.spike4, -0.0523599f, 0.5235988f, 0.0f);
        (this.spike5 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 11);
        this.spike5.func_78793_a(0.0f, 16.0f, 41.0f);
        this.spike5.func_78787_b(64, 32);
        this.spike5.field_78809_i = true;
        this.setRotation(this.spike5, -0.0523599f, -0.5759587f, 0.0f);
        (this.spike3 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 11);
        this.spike3.func_78793_a(0.0f, 13.5f, 30.5f);
        this.spike3.func_78787_b(64, 32);
        this.spike3.field_78809_i = true;
        this.setRotation(this.spike3, 0.3141593f, 0.0f, 0.0f);
        (this.fanl7 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanl7.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanl7.func_78787_b(64, 32);
        this.fanl7.field_78809_i = true;
        this.setRotation(this.fanl7, 0.0f, 0.0f, 1.832596f);
        (this.fanr7 = new ModelRenderer((ModelBase)this, 130, 10)).func_78789_a(-3.0f, -24.0f, 0.0f, 6, 24, 1);
        this.fanr7.func_78793_a(0.0f, -7.0f, -10.0f);
        this.fanr7.func_78787_b(64, 32);
        this.fanr7.field_78809_i = true;
        this.setRotation(this.fanr7, 0.0f, 0.0f, -1.832596f);
        (this.head = new ModelRenderer((ModelBase)this, 200, 0)).func_78789_a(-3.0f, -4.0f, -7.0f, 6, 7, 8);
        this.head.func_78793_a(0.0f, -3.0f, -11.0f);
        this.head.func_78787_b(64, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.head1 = new ModelRenderer((ModelBase)this, 200, 18)).func_78789_a(-2.5f, -2.0f, -15.0f, 5, 2, 8);
        this.head1.func_78793_a(0.0f, -3.0f, -11.0f);
        this.head1.func_78787_b(64, 32);
        this.head1.field_78809_i = true;
        this.setRotation(this.head1, 0.0f, 0.0f, 0.0f);
        (this.jaw1 = new ModelRenderer((ModelBase)this, 200, 43)).func_78789_a(-2.0f, -1.0f, -7.0f, 4, 2, 8);
        this.jaw1.func_78793_a(0.0f, -2.0f, -19.0f);
        this.jaw1.func_78787_b(64, 32);
        this.jaw1.field_78809_i = true;
        this.setRotation(this.jaw1, 0.0f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer((ModelBase)this, 200, 31)).func_78789_a(-2.0f, -2.0f, -22.0f, 4, 2, 7);
        this.head2.func_78793_a(0.0f, -3.0f, -11.0f);
        this.head2.func_78787_b(64, 32);
        this.head2.field_78809_i = true;
        this.setRotation(this.head2, 0.0f, 0.0f, 0.0f);
        (this.jaw2 = new ModelRenderer((ModelBase)this, 200, 56)).func_78789_a(-1.5f, -1.0f, -13.0f, 3, 2, 6);
        this.jaw2.func_78793_a(0.0f, -2.0f, -19.0f);
        this.jaw2.func_78787_b(64, 32);
        this.jaw2.field_78809_i = true;
        this.setRotation(this.jaw2, 0.0f, 0.0f, 0.0f);
        (this.fang1 = new ModelRenderer((ModelBase)this, 42, 0)).func_78789_a(1.0f, 0.0f, -20.0f, 1, 5, 1);
        this.fang1.func_78793_a(0.0f, -3.0f, -11.0f);
        this.fang1.func_78787_b(64, 32);
        this.fang1.field_78809_i = true;
        this.setRotation(this.fang1, 0.0f, 0.0f, 0.0f);
        (this.fang2 = new ModelRenderer((ModelBase)this, 50, 0)).func_78789_a(-2.0f, 0.0f, -20.0f, 1, 5, 1);
        this.fang2.func_78793_a(0.0f, -3.0f, -11.0f);
        this.fang2.func_78787_b(64, 32);
        this.fang2.field_78809_i = true;
        this.setRotation(this.fang2, 0.0f, 0.0f, 0.0f);
        (this.fang3 = new ModelRenderer((ModelBase)this, 60, 0)).func_78789_a(1.0f, 0.0f, -14.0f, 1, 3, 1);
        this.fang3.func_78793_a(0.0f, -3.0f, -11.0f);
        this.fang3.func_78787_b(64, 32);
        this.fang3.field_78809_i = true;
        this.setRotation(this.fang3, 0.0f, 0.0f, 0.0f);
        (this.fang4 = new ModelRenderer((ModelBase)this, 69, 0)).func_78789_a(-2.0f, 0.0f, -14.0f, 1, 3, 1);
        this.fang4.func_78793_a(0.0f, -3.0f, -11.0f);
        this.fang4.func_78787_b(64, 32);
        this.fang4.field_78809_i = true;
        this.setRotation(this.fang4, 0.0f, 0.0f, 0.0f);
        (this.spike2 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -0.5f, 0.0f, 1, 1, 11);
        this.spike2.func_78793_a(0.0f, 9.5f, 20.5f);
        this.spike2.func_78787_b(64, 32);
        this.spike2.field_78809_i = true;
        this.setRotation(this.spike2, 0.3141593f, 0.0f, 0.0f);
        (this.spike1 = new ModelRenderer((ModelBase)this, 178, 66)).func_78789_a(-0.5f, -1.5f, 0.0f, 1, 1, 11);
        this.spike1.func_78793_a(0.0f, 6.5f, 10.5f);
        this.spike1.func_78787_b(64, 32);
        this.spike1.field_78809_i = true;
        this.setRotation(this.spike1, 0.3141593f, 0.0f, 0.0f);
        (this.arml1 = new ModelRenderer((ModelBase)this, 50, 98)).func_78789_a(0.0f, 0.0f, -2.0f, 11, 3, 4);
        this.arml1.func_78793_a(2.0f, -1.0f, -6.0f);
        this.arml1.func_78787_b(64, 32);
        this.arml1.field_78809_i = true;
        this.setRotation(this.arml1, 0.0f, -0.5235988f, 0.1745329f);
        (this.armr1 = new ModelRenderer((ModelBase)this, 49, 88)).func_78789_a(0.0f, 0.0f, -2.0f, 11, 3, 4);
        this.armr1.func_78793_a(-3.0f, -1.0f, -6.0f);
        this.armr1.func_78787_b(64, 32);
        this.armr1.field_78809_i = true;
        this.setRotation(this.armr1, 0.0f, -2.617994f, -0.1745329f);
        (this.arml2 = new ModelRenderer((ModelBase)this, 41, 107)).func_78789_a(0.0f, -1.0f, -1.0f, 15, 3, 3);
        this.arml2.func_78793_a(11.0f, 2.0f, -1.0f);
        this.arml2.func_78787_b(64, 32);
        this.arml2.field_78809_i = true;
        this.setRotation(this.arml2, 0.0f, 0.8552113f, 0.0f);
        (this.armr2 = new ModelRenderer((ModelBase)this, 42, 115)).func_78789_a(0.0f, -1.0f, -2.0f, 15, 3, 3);
        this.armr2.func_78793_a(-11.0f, 2.0f, -1.0f);
        this.armr2.func_78787_b(64, 32);
        this.armr2.field_78809_i = true;
        this.setRotation(this.armr2, 0.0f, 2.268928f, 0.0f);
        (this.clawr1 = new ModelRenderer((ModelBase)this, 100, 85)).func_78789_a(-0.5f, -1.0f, -6.0f, 1, 1, 6);
        this.clawr1.func_78793_a(-21.0f, 2.0f, -12.0f);
        this.clawr1.func_78787_b(64, 32);
        this.clawr1.field_78809_i = true;
        this.setRotation(this.clawr1, -0.1745329f, 0.4363323f, 0.0f);
        (this.clawr2 = new ModelRenderer((ModelBase)this, 100, 94)).func_78789_a(0.0f, 0.0f, -10.0f, 1, 1, 10);
        this.clawr2.func_78793_a(-21.0f, 2.0f, -12.0f);
        this.clawr2.func_78787_b(64, 32);
        this.clawr2.field_78809_i = true;
        this.setRotation(this.clawr2, 0.0f, 0.8726646f, 0.0f);
        (this.clawr3 = new ModelRenderer((ModelBase)this, 100, 107)).func_78789_a(0.0f, 1.0f, -6.0f, 1, 1, 6);
        this.clawr3.func_78793_a(-21.0f, 2.0f, -12.0f);
        this.clawr3.func_78787_b(64, 32);
        this.clawr3.field_78809_i = true;
        this.setRotation(this.clawr3, 0.1745329f, 0.4363323f, 0.0f);
        (this.clawl2 = new ModelRenderer((ModelBase)this, 130, 94)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.clawl2.func_78793_a(21.0f, 2.0f, -12.0f);
        this.clawl2.func_78787_b(64, 32);
        this.clawl2.field_78809_i = true;
        this.setRotation(this.clawl2, 0.0f, 2.268928f, 0.0f);
        (this.clawl3 = new ModelRenderer((ModelBase)this, 130, 109)).func_78789_a(0.0f, 1.0f, 0.0f, 1, 1, 6);
        this.clawl3.func_78793_a(21.0f, 2.0f, -12.0f);
        this.clawl3.func_78787_b(64, 32);
        this.clawl3.field_78809_i = true;
        this.setRotation(this.clawl3, -0.1745329f, 2.70526f, 0.0f);
        (this.clawl1 = new ModelRenderer((ModelBase)this, 130, 83)).func_78789_a(0.0f, -1.0f, 0.0f, 1, 1, 6);
        this.clawl1.func_78793_a(21.0f, 2.0f, -12.0f);
        this.clawl1.func_78787_b(64, 32);
        this.clawl1.field_78809_i = true;
        this.setRotation(this.clawl1, 0.1745329f, 2.70526f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final Alien e = (Alien)entity;
        RenderInfo r = null;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float nextangle = 0.0f;
        newangle = MathHelper.func_76134_b(f2 * 4.0f * this.wingspeed) * 3.1415927f * 0.5f * f1;
        this.doLeftLeg(newangle);
        this.doRightLeg(-newangle);
        if (e.getAttacking() == 0) {
            this.fan.field_78808_h = 0.0f;
            this.fanl1.field_78808_h = 0.0f;
            this.fanl2.field_78808_h = 0.0f;
            this.fanl3.field_78808_h = 0.0f;
            this.fanl4.field_78808_h = 0.0f;
            this.fanl5.field_78808_h = 0.0f;
            this.fanl6.field_78808_h = 0.0f;
            this.fanl7.field_78808_h = 0.0f;
            this.fanr1.field_78808_h = 0.0f;
            this.fanr2.field_78808_h = 0.0f;
            this.fanr3.field_78808_h = 0.0f;
            this.fanr4.field_78808_h = 0.0f;
            this.fanr5.field_78808_h = 0.0f;
            this.fanr6.field_78808_h = 0.0f;
            this.fanr7.field_78808_h = 0.0f;
            this.fan.field_78795_f = -1.85f;
            this.fanl1.field_78795_f = -1.85f;
            this.fanl2.field_78795_f = -1.85f;
            this.fanl3.field_78795_f = -1.85f;
            this.fanl4.field_78795_f = -1.85f;
            this.fanl5.field_78795_f = -1.85f;
            this.fanl6.field_78795_f = -1.85f;
            this.fanl7.field_78795_f = -1.85f;
            this.fanr1.field_78795_f = -1.85f;
            this.fanr2.field_78795_f = -1.85f;
            this.fanr3.field_78795_f = -1.85f;
            this.fanr4.field_78795_f = -1.85f;
            this.fanr5.field_78795_f = -1.85f;
            this.fanr6.field_78795_f = -1.85f;
            this.fanr7.field_78795_f = -1.85f;
        }
        else {
            final float pi6 = 0.5235988f;
            final float fanspeed = 1.22f;
            final float fanamp = 0.1f;
            this.fan.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed) * 3.1415927f * fanamp;
            this.fanl1.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 1.0f * pi6) * 3.1415927f * fanamp;
            this.fanl2.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 2.0f * pi6) * 3.1415927f * fanamp;
            this.fanl3.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 3.0f * pi6) * 3.1415927f * fanamp;
            this.fanl4.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 4.0f * pi6) * 3.1415927f * fanamp;
            this.fanl5.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 5.0f * pi6) * 3.1415927f * fanamp;
            this.fanl6.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 6.0f * pi6) * 3.1415927f * fanamp;
            this.fanl7.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 7.0f * pi6) * 3.1415927f * fanamp;
            this.fanr1.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 1.0f * pi6) * 3.1415927f * fanamp;
            this.fanr2.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 2.0f * pi6) * 3.1415927f * fanamp;
            this.fanr3.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 3.0f * pi6) * 3.1415927f * fanamp;
            this.fanr4.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 4.0f * pi6) * 3.1415927f * fanamp;
            this.fanr5.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 5.0f * pi6) * 3.1415927f * fanamp;
            this.fanr6.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 6.0f * pi6) * 3.1415927f * fanamp;
            this.fanr7.field_78795_f = MathHelper.func_76134_b(f2 * fanspeed * this.wingspeed - 7.0f * pi6) * 3.1415927f * fanamp;
            this.fan.field_78808_h = 0.0f;
            this.fanl1.field_78808_h = 0.261f;
            this.fanl2.field_78808_h = 0.523f;
            this.fanl3.field_78808_h = 0.785f;
            this.fanl4.field_78808_h = 1.047f;
            this.fanl5.field_78808_h = 1.309f;
            this.fanl6.field_78808_h = 1.571f;
            this.fanl7.field_78808_h = 1.832f;
            this.fanr1.field_78808_h = -0.261f;
            this.fanr2.field_78808_h = -0.523f;
            this.fanr3.field_78808_h = -0.785f;
            this.fanr4.field_78808_h = -1.047f;
            this.fanr5.field_78808_h = -1.309f;
            this.fanr6.field_78808_h = -1.571f;
            this.fanr7.field_78808_h = -1.832f;
        }
        this.neck.field_78796_g = (float)Math.toRadians(f3) * 0.35f;
        this.head.field_78796_g = (float)Math.toRadians(f3) * 0.75f;
        this.head.field_78798_e = this.neck.field_78798_e - (float)Math.cos(this.neck.field_78796_g) * 3.0f;
        this.head.field_78800_c = this.neck.field_78800_c + (float)Math.sin(this.neck.field_78796_g) * 3.0f;
        this.head1.field_78796_g = this.head.field_78796_g;
        this.head1.field_78798_e = this.head.field_78798_e;
        this.head1.field_78800_c = this.head.field_78800_c;
        this.head2.field_78796_g = this.head.field_78796_g;
        this.head2.field_78798_e = this.head.field_78798_e;
        this.head2.field_78800_c = this.head.field_78800_c;
        this.fang1.field_78796_g = this.head.field_78796_g;
        this.fang1.field_78798_e = this.head.field_78798_e;
        this.fang1.field_78800_c = this.head.field_78800_c;
        this.fang2.field_78796_g = this.head.field_78796_g;
        this.fang2.field_78798_e = this.head.field_78798_e;
        this.fang2.field_78800_c = this.head.field_78800_c;
        this.fang3.field_78796_g = this.head.field_78796_g;
        this.fang3.field_78798_e = this.head.field_78798_e;
        this.fang3.field_78800_c = this.head.field_78800_c;
        this.fang4.field_78796_g = this.head.field_78796_g;
        this.fang4.field_78798_e = this.head.field_78798_e;
        this.fang4.field_78800_c = this.head.field_78800_c;
        this.jaw1.field_78796_g = this.head.field_78796_g;
        this.jaw1.field_78798_e = this.head.field_78798_e - (float)Math.cos(this.head.field_78796_g) * 8.0f;
        this.jaw1.field_78800_c = this.head.field_78800_c - (float)Math.sin(this.head.field_78796_g) * 8.0f;
        this.jaw2.field_78796_g = this.jaw1.field_78796_g;
        this.jaw2.field_78798_e = this.jaw1.field_78798_e;
        this.jaw2.field_78800_c = this.jaw1.field_78800_c;
        r = e.getRenderInfo();
        newangle = MathHelper.func_76134_b(f2 * 3.5f * this.wingspeed) * 3.1415927f * 0.5f;
        nextangle = MathHelper.func_76134_b((f2 + 0.2f) * 3.5f * this.wingspeed) * 3.1415927f * 0.5f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            if (e.getAttacking() == 0) {
                r.ri1 = e.field_70170_p.field_73012_v.nextInt(15);
                r.ri2 = e.field_70170_p.field_73012_v.nextInt(15);
                r.ri3 = e.field_70170_p.field_73012_v.nextInt(15);
            }
            else {
                r.ri1 = e.field_70170_p.field_73012_v.nextInt(4);
                r.ri2 = e.field_70170_p.field_73012_v.nextInt(2);
                r.ri3 = 1;
            }
        }
        if (r.ri2 == 1) {
            this.doTail(newangle);
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.05f;
            this.doTail(newangle);
        }
        if (r.ri3 == 1) {
            newangle = MathHelper.func_76134_b(f2 * 3.5f * this.wingspeed) * 3.1415927f * 0.35f;
            this.doJaw(newangle);
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.02f;
            this.doJaw(newangle);
        }
        newangle = MathHelper.func_76134_b(f2 * this.wingspeed * 3.5f) * 3.1415927f * 0.2f;
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.doLeftClaw(newangle);
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.03f;
            this.doLeftClaw(newangle);
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.doRightClaw(-newangle);
        }
        else {
            newangle = MathHelper.func_76134_b(f2 * this.wingspeed) * 3.1415927f * 0.03f;
            this.doRightClaw(-newangle);
        }
        e.setRenderInfo(r);
        this.torso.func_78785_a(f5);
        this.stomach.func_78785_a(f5);
        this.rThigh.func_78785_a(f5);
        this.lThigh.func_78785_a(f5);
        this.lShin.func_78785_a(f5);
        this.rShin.func_78785_a(f5);
        this.lShin1.func_78785_a(f5);
        this.rShin1.func_78785_a(f5);
        this.lFoot.func_78785_a(f5);
        this.rFoot.func_78785_a(f5);
        this.neck.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        this.tail4.func_78785_a(f5);
        this.tail5.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.spike4.func_78785_a(f5);
        this.spike5.func_78785_a(f5);
        this.spike3.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.jaw1.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.jaw2.func_78785_a(f5);
        this.fang1.func_78785_a(f5);
        this.fang2.func_78785_a(f5);
        this.fang3.func_78785_a(f5);
        this.fang4.func_78785_a(f5);
        this.spike2.func_78785_a(f5);
        this.spike1.func_78785_a(f5);
        this.arml1.func_78785_a(f5);
        this.armr1.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.clawr1.func_78785_a(f5);
        this.clawr2.func_78785_a(f5);
        this.clawr3.func_78785_a(f5);
        this.clawl2.func_78785_a(f5);
        this.clawl3.func_78785_a(f5);
        this.clawl1.func_78785_a(f5);
        this.fan.func_78785_a(f5);
        this.fanl1.func_78785_a(f5);
        this.fanr1.func_78785_a(f5);
        this.fanl2.func_78785_a(f5);
        this.fanr2.func_78785_a(f5);
        this.fanl3.func_78785_a(f5);
        this.fanr3.func_78785_a(f5);
        this.fanl4.func_78785_a(f5);
        this.fanr4.func_78785_a(f5);
        this.fanl5.func_78785_a(f5);
        this.fanr5.func_78785_a(f5);
        this.fanl6.func_78785_a(f5);
        this.fanr6.func_78785_a(f5);
        this.fanl7.func_78785_a(f5);
        this.fanr7.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
    }
    
    private void doLeftLeg(final float angle) {
        this.lFoot.field_78795_f = angle;
        this.lShin.field_78795_f = angle - 0.4f;
        this.lShin1.field_78795_f = angle - 0.8f;
        this.lThigh.field_78795_f = angle - 0.8f;
    }
    
    private void doRightLeg(final float angle) {
        this.rFoot.field_78795_f = angle;
        this.rShin.field_78795_f = angle - 0.4f;
        this.rShin1.field_78795_f = angle - 0.8f;
        this.rThigh.field_78795_f = angle - 0.8f;
    }
    
    private void doJaw(final float angle) {
        this.jaw1.field_78795_f = Math.abs(angle);
        this.jaw2.field_78795_f = this.jaw1.field_78795_f;
    }
    
    private void doTail(final float angle) {
        this.tail1.field_78796_g = angle * 0.25f;
        this.spike1.field_78796_g = this.tail1.field_78796_g;
        this.tail2.field_78796_g = angle * 0.5f;
        this.tail2.field_78798_e = this.tail1.field_78798_e + (float)Math.cos(this.tail1.field_78796_g) * 10.0f;
        this.tail2.field_78800_c = this.tail1.field_78800_c + (float)Math.sin(this.tail1.field_78796_g) * 10.0f;
        this.spike2.field_78796_g = this.tail2.field_78796_g;
        this.spike2.field_78798_e = this.tail2.field_78798_e;
        this.spike2.field_78800_c = this.tail2.field_78800_c;
        this.tail3.field_78796_g = angle * 0.8f;
        this.tail3.field_78798_e = this.tail2.field_78798_e + (float)Math.cos(this.tail2.field_78796_g) * 10.0f;
        this.tail3.field_78800_c = this.tail2.field_78800_c + (float)Math.sin(this.tail2.field_78796_g) * 10.0f;
        this.spike3.field_78796_g = this.tail3.field_78796_g;
        this.spike3.field_78798_e = this.tail3.field_78798_e;
        this.spike3.field_78800_c = this.tail3.field_78800_c;
        this.tail4.field_78796_g = angle * 1.25f;
        this.tail4.field_78798_e = this.tail3.field_78798_e + (float)Math.cos(this.tail3.field_78796_g) * 10.0f;
        this.tail4.field_78800_c = this.tail3.field_78800_c + (float)Math.sin(this.tail3.field_78796_g) * 10.0f;
        this.spike4.field_78796_g = this.tail4.field_78796_g + 0.52f;
        this.spike4.field_78798_e = this.tail4.field_78798_e;
        this.spike4.field_78800_c = this.tail4.field_78800_c;
        this.spike5.field_78796_g = this.tail4.field_78796_g - 0.52f;
        this.spike5.field_78798_e = this.tail4.field_78798_e;
        this.spike5.field_78800_c = this.tail4.field_78800_c;
        this.tail5.field_78796_g = angle * 1.5f;
        this.tail5.field_78798_e = this.tail4.field_78798_e + (float)Math.cos(this.tail4.field_78796_g) * 10.0f;
        this.tail5.field_78800_c = this.tail4.field_78800_c + (float)Math.sin(this.tail4.field_78796_g) * 10.0f;
    }
    
    private void doLeftClaw(final float angle) {
        this.arml1.field_78796_g = -0.52f + Math.abs(angle * 2.0f);
        this.arml2.field_78798_e = this.arml1.field_78798_e - (float)Math.sin(this.arml1.field_78796_g) * 9.0f;
        this.arml2.field_78800_c = this.arml1.field_78800_c + (float)Math.cos(this.arml1.field_78796_g) * 9.0f;
        this.arml2.field_78796_g = 0.855f + Math.abs(angle);
        this.clawl1.field_78798_e = this.arml2.field_78798_e - (float)Math.sin(this.arml2.field_78796_g) * 14.0f;
        this.clawl1.field_78800_c = this.arml2.field_78800_c + (float)Math.cos(this.arml2.field_78796_g) * 14.0f;
        this.clawl1.field_78796_g = 2.7f + Math.abs(angle * 4.0f);
        this.clawl2.field_78798_e = this.clawl1.field_78798_e;
        this.clawl2.field_78800_c = this.clawl1.field_78800_c;
        this.clawl2.field_78796_g = 2.27f + Math.abs(angle * 4.0f);
        this.clawl3.field_78798_e = this.clawl1.field_78798_e;
        this.clawl3.field_78800_c = this.clawl1.field_78800_c;
        this.clawl3.field_78796_g = 2.7f + Math.abs(angle * 4.0f);
    }
    
    private void doRightClaw(final float angle) {
        this.armr1.field_78796_g = -2.61f - Math.abs(angle * 2.0f);
        this.armr2.field_78798_e = this.armr1.field_78798_e - (float)Math.sin(this.armr1.field_78796_g) * 9.0f;
        this.armr2.field_78800_c = this.armr1.field_78800_c + (float)Math.cos(this.armr1.field_78796_g) * 9.0f;
        this.armr2.field_78796_g = 2.27f - Math.abs(angle);
        this.clawr1.field_78798_e = this.armr2.field_78798_e - (float)Math.sin(this.armr2.field_78796_g) * 14.0f;
        this.clawr1.field_78800_c = this.armr2.field_78800_c + (float)Math.cos(this.armr2.field_78796_g) * 14.0f;
        this.clawr1.field_78796_g = 0.436f - Math.abs(angle * 4.0f);
        this.clawr2.field_78798_e = this.clawr1.field_78798_e;
        this.clawr2.field_78800_c = this.clawr1.field_78800_c;
        this.clawr2.field_78796_g = 0.87f - Math.abs(angle * 4.0f);
        this.clawr3.field_78798_e = this.clawr1.field_78798_e;
        this.clawr3.field_78800_c = this.clawr1.field_78800_c;
        this.clawr3.field_78796_g = 0.436f - Math.abs(angle * 4.0f);
    }
}
