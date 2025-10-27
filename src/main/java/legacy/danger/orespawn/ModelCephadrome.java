// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelCephadrome extends ModelBase
{
    private float wingspeed;
    ModelRenderer leftfoot;
    ModelRenderer butt;
    ModelRenderer rightfoot;
    ModelRenderer topfin1;
    ModelRenderer topfin2;
    ModelRenderer topfin3;
    ModelRenderer topfin4;
    ModelRenderer leftshoulder;
    ModelRenderer lefwingfin1;
    ModelRenderer tailfin1;
    ModelRenderer tailmembrane2;
    ModelRenderer tailfin2;
    ModelRenderer tailfin4;
    ModelRenderer tailfin3;
    ModelRenderer tailmembrane1;
    ModelRenderer topmem1;
    ModelRenderer topmem2;
    ModelRenderer topmem3;
    ModelRenderer topmem4;
    ModelRenderer neck1;
    ModelRenderer body;
    ModelRenderer chest1;
    ModelRenderer leftleg1;
    ModelRenderer mouth;
    ModelRenderer neck2;
    ModelRenderer head;
    ModelRenderer hammerhead;
    ModelRenderer chest;
    ModelRenderer neck3;
    ModelRenderer tail1;
    ModelRenderer rightleg1;
    ModelRenderer leftleg2;
    ModelRenderer rightleg2;
    ModelRenderer body2;
    ModelRenderer leftleg3;
    ModelRenderer rightleg3;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tailmembrane3;
    ModelRenderer leftwingfin2;
    ModelRenderer leftwingfin3;
    ModelRenderer leftwingfin4;
    ModelRenderer leftwingmembrane;
    ModelRenderer rightshoulder;
    ModelRenderer rightwingfin1;
    ModelRenderer rightwingfin2;
    ModelRenderer rightwingfin3;
    ModelRenderer rightwingfin4;
    ModelRenderer rightwingmembrane;
    ModelRenderer hammerhead2;
    
    public ModelCephadrome(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        (this.leftfoot = new ModelRenderer((ModelBase)this, 41, 194)).func_78789_a(-2.0f, 34.0f, -12.0f, 9, 4, 10);
        this.leftfoot.func_78793_a(7.0f, -14.0f, 17.0f);
        this.leftfoot.func_78787_b(512, 256);
        this.leftfoot.field_78809_i = true;
        this.setRotation(this.leftfoot, 0.0f, 0.0f, 0.0f);
        (this.butt = new ModelRenderer((ModelBase)this, 367, 235)).func_78789_a(0.0f, 0.0f, -2.0f, 9, 14, 6);
        this.butt.func_78793_a(-4.5f, -8.0f, 29.0f);
        this.butt.func_78787_b(512, 256);
        this.butt.field_78809_i = true;
        this.setRotation(this.butt, -0.8726646f, 0.0f, 0.0f);
        (this.rightfoot = new ModelRenderer((ModelBase)this, 41, 170)).func_78789_a(-7.0f, 34.0f, -12.0f, 9, 4, 10);
        this.rightfoot.func_78793_a(-7.0f, -14.0f, 17.0f);
        this.rightfoot.func_78787_b(512, 256);
        this.rightfoot.field_78809_i = true;
        this.setRotation(this.rightfoot, 0.0f, 0.0f, 0.0f);
        (this.topfin1 = new ModelRenderer((ModelBase)this, 64, 112)).func_78789_a(-3.0f, -2.0f, -30.0f, 6, 3, 30);
        this.topfin1.func_78793_a(0.0f, -15.0f, -7.0f);
        this.topfin1.func_78787_b(512, 256);
        this.topfin1.field_78809_i = true;
        this.setRotation(this.topfin1, -1.850049f, 0.0f, 0.0f);
        (this.topfin2 = new ModelRenderer((ModelBase)this, 69, 81)).func_78789_a(-3.0f, -2.0f, -25.0f, 6, 3, 25);
        this.topfin2.func_78793_a(0.0f, -15.0f, -2.0f);
        this.topfin2.func_78787_b(512, 256);
        this.topfin2.field_78809_i = true;
        this.setRotation(this.topfin2, -2.076942f, 0.0f, 0.0f);
        (this.topfin3 = new ModelRenderer((ModelBase)this, -1, 140)).func_78789_a(-3.0f, -2.0f, -20.0f, 6, 3, 20);
        this.topfin3.func_78793_a(0.0f, -16.0f, 3.0f);
        this.topfin3.func_78787_b(512, 256);
        this.topfin3.field_78809_i = true;
        this.setRotation(this.topfin3, -2.426008f, 0.0f, 0.0f);
        (this.topfin4 = new ModelRenderer((ModelBase)this, 148, 148)).func_78789_a(-3.0f, -2.0f, -10.0f, 6, 3, 10);
        this.topfin4.func_78793_a(0.0f, -17.0f, 13.0f);
        this.topfin4.func_78787_b(512, 256);
        this.topfin4.field_78809_i = true;
        this.setRotation(this.topfin4, -2.635447f, 0.0f, 0.0f);
        (this.leftshoulder = new ModelRenderer((ModelBase)this, 144, 236)).func_78789_a(0.0f, 0.0f, 1.0f, 6, 8, 11);
        this.leftshoulder.func_78793_a(6.0f, -16.0f, -14.0f);
        this.leftshoulder.func_78787_b(512, 256);
        this.leftshoulder.field_78809_i = true;
        this.setRotation(this.leftshoulder, -0.1745329f, 0.0f, 0.0f);
        (this.lefwingfin1 = new ModelRenderer((ModelBase)this, 147, 96)).func_78789_a(0.0f, -2.0f, -2.0f, 70, 5, 3);
        this.lefwingfin1.func_78793_a(9.0f, -12.0f, -11.0f);
        this.lefwingfin1.func_78787_b(512, 256);
        this.lefwingfin1.field_78809_i = true;
        this.setRotation(this.lefwingfin1, -0.2617994f, -0.1745329f, 0.0f);
        (this.tailfin1 = new ModelRenderer((ModelBase)this, 168, 0)).func_78789_a(-6.0f, -1.0f, 0.0f, 12, 3, 30);
        this.tailfin1.func_78793_a(0.0f, -9.0f, 56.0f);
        this.tailfin1.func_78787_b(512, 256);
        this.tailfin1.field_78809_i = true;
        this.setRotation(this.tailfin1, 0.1396263f, 0.0f, 0.0f);
        (this.tailmembrane2 = new ModelRenderer((ModelBase)this, 201, 38)).func_78789_a(0.0f, -8.0f, 3.0f, 0, 10, 19);
        this.tailmembrane2.func_78793_a(0.0f, 0.0f, 56.0f);
        this.tailmembrane2.func_78787_b(512, 256);
        this.tailmembrane2.field_78809_i = true;
        this.setRotation(this.tailmembrane2, -0.296706f, 0.0f, 0.0f);
        (this.tailfin2 = new ModelRenderer((ModelBase)this, 186, 184)).func_78789_a(-4.0f, 0.0f, 0.0f, 8, 2, 27);
        this.tailfin2.func_78793_a(0.0f, -7.0f, 56.0f);
        this.tailfin2.func_78787_b(512, 256);
        this.tailfin2.field_78809_i = true;
        this.setRotation(this.tailfin2, -0.1919862f, 0.0f, 0.0f);
        (this.tailfin4 = new ModelRenderer((ModelBase)this, 186, 137)).func_78789_a(-4.0f, 1.0f, 1.0f, 8, 3, 22);
        this.tailfin4.func_78793_a(0.0f, -3.0f, 56.0f);
        this.tailfin4.func_78787_b(512, 256);
        this.tailfin4.field_78809_i = true;
        this.setRotation(this.tailfin4, -0.837758f, 0.0f, 0.0f);
        (this.tailfin3 = new ModelRenderer((ModelBase)this, 185, 216)).func_78789_a(-4.0f, 0.0f, 1.0f, 8, 2, 23);
        this.tailfin3.func_78793_a(0.0f, -5.0f, 57.0f);
        this.tailfin3.func_78787_b(512, 256);
        this.tailfin3.field_78809_i = true;
        this.setRotation(this.tailfin3, -0.5759587f, 0.0f, 0.0f);
        (this.tailmembrane1 = new ModelRenderer((ModelBase)this, 245, 38)).func_78789_a(0.0f, 0.0f, 4.0f, 0, 11, 21);
        this.tailmembrane1.func_78793_a(0.0f, -9.0f, 56.0f);
        this.tailmembrane1.func_78787_b(512, 256);
        this.tailmembrane1.field_78809_i = true;
        this.setRotation(this.tailmembrane1, 0.1396263f, 0.0f, 0.0f);
        (this.topmem1 = new ModelRenderer((ModelBase)this, 25, 0)).func_78789_a(0.0f, -25.0f, 0.0f, 0, 24, 10);
        this.topmem1.func_78793_a(0.0f, -15.0f, -6.0f);
        this.topmem1.func_78787_b(512, 256);
        this.topmem1.field_78809_i = true;
        this.setRotation(this.topmem1, -0.2617994f, 0.0f, 0.0f);
        (this.topmem2 = new ModelRenderer((ModelBase)this, 135, 0)).func_78789_a(1.0f, -22.0f, 0.0f, 0, 20, 10);
        this.topmem2.func_78793_a(-1.0f, -15.0f, -2.0f);
        this.topmem2.func_78787_b(512, 256);
        this.topmem2.field_78809_i = true;
        this.setRotation(this.topmem2, -0.5235988f, 0.0f, 0.0f);
        (this.topmem3 = new ModelRenderer((ModelBase)this, 258, 0)).func_78789_a(0.0f, -18.0f, 0.0f, 0, 18, 8);
        this.topmem3.func_78793_a(0.0f, -16.0f, 3.0f);
        this.topmem3.func_78787_b(512, 256);
        this.topmem3.field_78809_i = true;
        this.setRotation(this.topmem3, -0.8901179f, 0.0f, 0.0f);
        (this.topmem4 = new ModelRenderer((ModelBase)this, 282, 0)).func_78789_a(0.0f, -9.0f, 0.0f, 0, 9, 10);
        this.topmem4.func_78793_a(0.0f, -17.0f, 13.0f);
        this.topmem4.func_78787_b(512, 256);
        this.topmem4.field_78809_i = true;
        this.setRotation(this.topmem4, -1.117011f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase)this, 404, 235)).func_78789_a(-6.0f, -5.0f, -10.0f, 10, 9, 10);
        this.neck1.func_78793_a(1.0f, -6.0f, -33.0f);
        this.neck1.func_78787_b(512, 256);
        this.neck1.field_78809_i = true;
        this.setRotation(this.neck1, 0.3665191f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 28, 220)).func_78789_a(-6.0f, -11.0f, -10.0f, 12, 15, 19);
        this.body.func_78793_a(0.0f, -7.0f, 3.0f);
        this.body.func_78787_b(512, 256);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.1745329f, 0.0f, 0.0f);
        (this.chest1 = new ModelRenderer((ModelBase)this, 98, 210)).func_78789_a(-3.0f, -4.0f, -2.0f, 10, 11, 5);
        this.chest1.func_78793_a(-2.0f, -6.0f, -13.0f);
        this.chest1.func_78787_b(512, 256);
        this.chest1.field_78809_i = true;
        this.setRotation(this.chest1, 1.029744f, 0.0f, 0.0f);
        (this.leftleg1 = new ModelRenderer((ModelBase)this, 135, 183)).func_78789_a(-1.0f, 0.0f, -4.0f, 7, 18, 10);
        this.leftleg1.func_78793_a(7.0f, -14.0f, 17.0f);
        this.leftleg1.func_78787_b(512, 256);
        this.leftleg1.field_78809_i = true;
        this.setRotation(this.leftleg1, -0.5759587f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase)this, 92, 150)).func_78789_a(-7.0f, 1.0f, 3.0f, 14, 15, 4);
        this.mouth.func_78793_a(0.0f, -6.0f, -43.0f);
        this.mouth.func_78787_b(512, 256);
        this.mouth.field_78809_i = true;
        this.setRotation(this.mouth, -0.8726646f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase)this, 152, 110)).func_78789_a(-6.0f, -5.0f, -17.0f, 11, 10, 17);
        this.neck2.func_78793_a(0.5f, -10.0f, -19.0f);
        this.neck2.func_78787_b(512, 256);
        this.neck2.field_78809_i = true;
        this.setRotation(this.neck2, 0.2617994f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 275, 219)).func_78789_a(-10.0f, -3.0f, -16.0f, 20, 7, 16);
        this.head.func_78793_a(0.0f, -6.0f, -43.0f);
        this.head.func_78787_b(512, 256);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.5061455f, 0.0f, 0.0f);
        (this.hammerhead = new ModelRenderer((ModelBase)this, 258, 134)).func_78789_a(-18.0f, -2.0f, -15.0f, 36, 6, 14);
        this.hammerhead.func_78793_a(0.0f, -6.0f, -43.0f);
        this.hammerhead.func_78787_b(512, 256);
        this.hammerhead.field_78809_i = true;
        this.setRotation(this.hammerhead, 0.4537856f, 0.0f, 0.0f);
        (this.chest = new ModelRenderer((ModelBase)this, 100, 15)).func_78789_a(-3.0f, -3.0f, 0.0f, 9, 29, 7);
        this.chest.func_78793_a(-1.5f, 0.0f, -5.0f);
        this.chest.func_78787_b(512, 256);
        this.chest.field_78809_i = true;
        this.setRotation(this.chest, 1.413717f, 0.0f, 0.0f);
        (this.neck3 = new ModelRenderer((ModelBase)this, 264, 173)).func_78789_a(-6.0f, -5.0f, -16.0f, 12, 11, 16);
        this.neck3.func_78793_a(0.0f, -11.0f, -6.0f);
        this.neck3.func_78787_b(512, 256);
        this.neck3.field_78809_i = true;
        this.setRotation(this.neck3, 0.0872665f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 51, 5)).func_78789_a(-5.0f, -6.0f, 0.0f, 10, 13, 14);
        this.tail1.func_78793_a(0.0f, -10.0f, 22.0f);
        this.tail1.func_78787_b(512, 256);
        this.tail1.field_78809_i = true;
        this.setRotation(this.tail1, -0.1745329f, 0.0f, 0.0f);
        (this.rightleg1 = new ModelRenderer((ModelBase)this, 94, 175)).func_78789_a(-6.0f, 0.0f, -4.0f, 7, 18, 10);
        this.rightleg1.func_78793_a(-7.0f, -14.0f, 17.0f);
        this.rightleg1.func_78787_b(512, 256);
        this.rightleg1.field_78809_i = true;
        this.setRotation(this.rightleg1, -0.5759587f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase)this, 28, 112)).func_78789_a(-1.0f, 6.0f, -17.0f, 7, 12, 7);
        this.leftleg2.func_78793_a(7.0f, -14.0f, 17.0f);
        this.leftleg2.func_78787_b(512, 256);
        this.leftleg2.field_78809_i = true;
        this.setRotation(this.leftleg2, 0.9773844f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase)this, 32, 90)).func_78789_a(-6.0f, 6.0f, -17.0f, 7, 12, 7);
        this.rightleg2.func_78793_a(-7.0f, -14.0f, 17.0f);
        this.rightleg2.func_78787_b(512, 256);
        this.rightleg2.field_78809_i = true;
        this.setRotation(this.rightleg2, 0.9773844f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 400, 179)).func_78789_a(0.0f, 3.0f, 3.0f, 12, 16, 16);
        this.body2.func_78793_a(-6.0f, -23.0f, 6.0f);
        this.body2.func_78787_b(512, 256);
        this.body2.field_78809_i = true;
        this.setRotation(this.body2, -0.1919862f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase)this, 351, 192)).func_78789_a(-1.0f, 17.0f, 10.0f, 7, 17, 6);
        this.leftleg3.func_78793_a(7.0f, -14.0f, 17.0f);
        this.leftleg3.func_78787_b(512, 256);
        this.leftleg3.field_78809_i = true;
        this.setRotation(this.leftleg3, -0.5235988f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase)this, 323, 192)).func_78789_a(-6.0f, 17.0f, 10.0f, 7, 17, 6);
        this.rightleg3.func_78793_a(-7.0f, -14.0f, 17.0f);
        this.rightleg3.func_78787_b(512, 256);
        this.rightleg3.field_78809_i = true;
        this.setRotation(this.rightleg3, -0.5235988f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 51, 55)).func_78789_a(-6.0f, -6.0f, 0.0f, 9, 12, 14);
        this.tail2.func_78793_a(1.5f, -7.0f, 35.0f);
        this.tail2.func_78787_b(512, 256);
        this.tail2.field_78809_i = true;
        this.setRotation(this.tail2, -0.1396263f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 105, 52)).func_78789_a(-5.0f, -6.0f, 0.0f, 8, 11, 14);
        this.tail3.func_78793_a(1.0f, -5.0f, 48.0f);
        this.tail3.func_78787_b(512, 256);
        this.tail3.field_78809_i = true;
        this.setRotation(this.tail3, -0.1396263f, 0.0f, 0.0f);
        (this.tailmembrane3 = new ModelRenderer((ModelBase)this, 155, 38)).func_78789_a(0.0f, -10.0f, 0.0f, 0, 10, 18);
        this.tailmembrane3.func_78793_a(0.0f, 2.0f, 56.0f);
        this.tailmembrane3.func_78787_b(512, 256);
        this.tailmembrane3.field_78809_i = true;
        this.setRotation(this.tailmembrane3, -0.837758f, 0.0f, 0.0f);
        (this.leftwingfin2 = new ModelRenderer((ModelBase)this, 160, 83)).func_78789_a(0.0f, -2.0f, 0.0f, 64, 4, 2);
        this.leftwingfin2.func_78793_a(9.0f, -12.0f, -11.0f);
        this.leftwingfin2.func_78787_b(512, 256);
        this.leftwingfin2.field_78809_i = true;
        this.setRotation(this.leftwingfin2, -0.2617994f, -0.4363323f, 0.0f);
        (this.leftwingfin3 = new ModelRenderer((ModelBase)this, 209, 106)).func_78789_a(0.0f, -2.0f, 0.0f, 48, 4, 2);
        this.leftwingfin3.func_78793_a(9.0f, -11.0f, -10.0f);
        this.leftwingfin3.func_78787_b(512, 256);
        this.leftwingfin3.field_78809_i = true;
        this.setRotation(this.leftwingfin3, -0.2617994f, -0.7853982f, 0.0f);
        (this.leftwingfin4 = new ModelRenderer((ModelBase)this, 233, 120)).func_78789_a(0.0f, 0.0f, 0.0f, 37, 4, 2);
        this.leftwingfin4.func_78793_a(9.0f, -13.0f, -6.0f);
        this.leftwingfin4.func_78787_b(512, 256);
        this.leftwingfin4.field_78809_i = true;
        this.setRotation(this.leftwingfin4, -0.2617994f, -1.186824f, 0.0f);
        (this.leftwingmembrane = new ModelRenderer((ModelBase)this, 300, 27)).func_78789_a(3.0f, 0.0f, 0.0f, 64, 0, 34);
        this.leftwingmembrane.func_78793_a(9.0f, -13.0f, -10.0f);
        this.leftwingmembrane.func_78787_b(512, 256);
        this.leftwingmembrane.field_78809_i = true;
        this.setRotation(this.leftwingmembrane, -0.0872665f, -0.1745329f, 0.0f);
        (this.rightshoulder = new ModelRenderer((ModelBase)this, 0, 193)).func_78789_a(0.0f, 0.0f, 0.0f, 6, 8, 11);
        this.rightshoulder.func_78793_a(-12.0f, -16.0f, -13.0f);
        this.rightshoulder.func_78787_b(512, 256);
        this.rightshoulder.field_78809_i = true;
        this.setRotation(this.rightshoulder, -0.1745329f, 0.0f, 0.0f);
        (this.rightwingfin1 = new ModelRenderer((ModelBase)this, 344, 109)).func_78789_a(-69.0f, -2.0f, 0.0f, 69, 5, 3);
        this.rightwingfin1.func_78793_a(-10.0f, -12.0f, -13.0f);
        this.rightwingfin1.func_78787_b(512, 256);
        this.rightwingfin1.field_78809_i = true;
        this.setRotation(this.rightwingfin1, -0.2617994f, 0.1745329f, 0.0f);
        (this.rightwingfin2 = new ModelRenderer((ModelBase)this, 349, 119)).func_78789_a(-63.0f, -2.0f, 0.0f, 64, 4, 2);
        this.rightwingfin2.func_78793_a(-9.0f, -12.0f, -11.0f);
        this.rightwingfin2.func_78787_b(512, 256);
        this.rightwingfin2.field_78809_i = true;
        this.setRotation(this.rightwingfin2, -0.2617994f, 0.4363323f, 0.0f);
        (this.rightwingfin3 = new ModelRenderer((ModelBase)this, 368, 128)).func_78789_a(-49.0f, 0.0f, 0.0f, 48, 4, 2);
        this.rightwingfin3.func_78793_a(-9.0f, -13.0f, -9.0f);
        this.rightwingfin3.func_78787_b(512, 256);
        this.rightwingfin3.field_78809_i = true;
        this.setRotation(this.rightwingfin3, -0.2617994f, 0.7679449f, 0.0f);
        (this.rightwingfin4 = new ModelRenderer((ModelBase)this, 379, 137)).func_78789_a(-35.0f, 0.0f, 0.0f, 37, 4, 2);
        this.rightwingfin4.func_78793_a(-9.0f, -13.0f, -6.0f);
        this.rightwingfin4.func_78787_b(512, 256);
        this.rightwingfin4.field_78809_i = true;
        this.setRotation(this.rightwingfin4, -0.2617994f, 1.186824f, 0.0f);
        (this.rightwingmembrane = new ModelRenderer((ModelBase)this, 300, 67)).func_78789_a(-67.0f, -1.0f, 0.0f, 64, 0, 34);
        this.rightwingmembrane.func_78793_a(-9.0f, -12.0f, -12.0f);
        this.rightwingmembrane.func_78787_b(512, 256);
        this.rightwingmembrane.field_78809_i = true;
        this.setRotation(this.rightwingmembrane, -0.0872665f, 0.1745329f, 0.0f);
        (this.hammerhead2 = new ModelRenderer((ModelBase)this, 258, 157)).func_78789_a(-25.0f, 0.0f, -14.0f, 50, 4, 7);
        this.hammerhead2.func_78793_a(0.0f, -7.0f, -43.0f);
        this.hammerhead2.func_78787_b(512, 256);
        this.hammerhead2.field_78809_i = true;
        this.setRotation(this.hammerhead2, 0.4537856f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, float f3, final float f4, final float f5) {
        final Cephadrome e = (Cephadrome)entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float lspeed = 0.0f;
        final float pi4 = 0.7853982f;
        float tailspeed = 0.76f;
        float tailamp = 0.1f;
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        if (f1 > 0.001) {
            lspeed = (float)((e.field_70169_q - e.field_70165_t) * (e.field_70169_q - e.field_70165_t) + (e.field_70166_s - e.field_70161_v) * (e.field_70166_s - e.field_70161_v));
            lspeed = (float)Math.sqrt(lspeed);
            newangle = MathHelper.func_76134_b(f2 * 0.75f * this.wingspeed) * 3.1415927f * lspeed * 0.4f;
            if (newangle > 0.5) {
                newangle = 0.75f;
            }
            if (newangle < -0.5) {
                newangle = -0.75f;
            }
        }
        else {
            newangle = 0.0f;
        }
        if (e.getActivity() != 0) {
            newangle = 1.0f;
            this.rightleg1.field_78795_f = -0.58f + newangle;
            this.rightleg2.field_78795_f = 0.98f + newangle;
            this.rightleg3.field_78795_f = -0.52f + newangle;
            this.rightfoot.field_78795_f = newangle;
            this.leftleg1.field_78795_f = -0.58f + newangle;
            this.leftleg2.field_78795_f = 0.98f + newangle;
            this.leftleg3.field_78795_f = -0.52f + newangle;
            this.leftfoot.field_78795_f = newangle;
        }
        else {
            this.rightleg1.field_78795_f = -0.58f + newangle;
            this.rightleg2.field_78795_f = 0.98f + newangle;
            this.rightleg3.field_78795_f = -0.52f + newangle;
            this.rightfoot.field_78795_f = newangle;
            this.leftleg1.field_78795_f = -0.58f - newangle;
            this.leftleg2.field_78795_f = 0.98f - newangle;
            this.leftleg3.field_78795_f = -0.52f - newangle;
            this.leftfoot.field_78795_f = -newangle;
        }
        if (e.getActivity() != 0) {
            newangle = MathHelper.func_76134_b(f2 * 0.55f * this.wingspeed) * 3.1415927f * 0.28f;
        }
        else if (e.getAttacking() == 0) {
            newangle = -0.85f + MathHelper.func_76134_b(f2 * 0.2f * this.wingspeed) * 3.1415927f * 0.028f;
        }
        else {
            newangle = -0.65f + MathHelper.func_76134_b(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.068f;
        }
        this.lefwingfin1.field_78808_h = newangle;
        this.leftwingfin2.field_78808_h = newangle;
        this.leftwingfin3.field_78808_h = newangle;
        this.leftwingfin4.field_78808_h = newangle;
        this.leftwingmembrane.field_78808_h = newangle;
        this.rightwingfin1.field_78808_h = -newangle;
        this.rightwingfin2.field_78808_h = -newangle;
        this.rightwingfin3.field_78808_h = -newangle;
        this.rightwingfin4.field_78808_h = -newangle;
        this.rightwingmembrane.field_78808_h = -newangle;
        newangle = MathHelper.func_76134_b(f2 * 0.15f * this.wingspeed) * 3.1415927f * 0.05f;
        this.topfin1.field_78795_f = -1.85f - Math.abs(newangle);
        this.topmem1.field_78795_f = -0.26f - Math.abs(newangle);
        this.topfin2.field_78795_f = -2.07f - Math.abs(newangle / 2.0f);
        this.topmem2.field_78795_f = -0.52f - Math.abs(newangle / 2.0f);
        this.topfin3.field_78795_f = -2.42f - Math.abs(newangle / 4.0f);
        this.topmem3.field_78795_f = -0.89f - Math.abs(newangle / 4.0f);
        this.topfin4.field_78795_f = -2.63f - Math.abs(newangle / 8.0f);
        this.topmem4.field_78795_f = -1.11f - Math.abs(newangle / 8.0f);
        if (e.getActivity() == 0 && e.getAttacking() == 0) {
            tailspeed = 0.22f;
            tailamp = 0.03f;
        }
        this.tail1.field_78796_g = MathHelper.func_76134_b(f2 * tailspeed * this.wingspeed) * 3.1415927f * 0.04f;
        this.tail2.field_78798_e = this.tail1.field_78798_e + (float)Math.cos(this.tail1.field_78796_g) * 13.0f;
        this.tail2.field_78800_c = this.tail1.field_78800_c + 1.5f + (float)Math.sin(this.tail1.field_78796_g) * 13.0f;
        this.tail2.field_78796_g = MathHelper.func_76134_b(f2 * tailspeed * this.wingspeed - pi4) * 3.1415927f * tailamp;
        this.tail3.field_78798_e = this.tail2.field_78798_e + (float)Math.cos(this.tail2.field_78796_g) * 13.0f;
        this.tail3.field_78800_c = this.tail2.field_78800_c - 0.5f + (float)Math.sin(this.tail2.field_78796_g) * 13.0f;
        this.tail3.field_78796_g = MathHelper.func_76134_b(f2 * tailspeed * this.wingspeed - 2.0f * pi4) * 3.1415927f * tailamp;
        this.tailfin1.field_78798_e = this.tail3.field_78798_e + (float)Math.cos(this.tail3.field_78796_g) * 10.0f;
        this.tailfin1.field_78800_c = this.tail3.field_78800_c - 1.0f + (float)Math.sin(this.tail3.field_78796_g) * 10.0f;
        this.tailfin1.field_78796_g = MathHelper.func_76134_b(f2 * tailspeed * this.wingspeed - 3.0f * pi4) * 3.1415927f * tailamp;
        this.tailfin2.field_78798_e = this.tailfin1.field_78798_e;
        this.tailfin2.field_78800_c = this.tailfin1.field_78800_c;
        this.tailfin2.field_78796_g = this.tailfin1.field_78796_g;
        this.tailfin3.field_78798_e = this.tailfin1.field_78798_e;
        this.tailfin3.field_78800_c = this.tailfin1.field_78800_c;
        this.tailfin3.field_78796_g = this.tailfin1.field_78796_g;
        this.tailfin4.field_78798_e = this.tailfin1.field_78798_e;
        this.tailfin4.field_78800_c = this.tailfin1.field_78800_c;
        this.tailfin4.field_78796_g = this.tailfin1.field_78796_g;
        this.tailmembrane1.field_78798_e = this.tailfin1.field_78798_e;
        this.tailmembrane1.field_78800_c = this.tailfin1.field_78800_c;
        this.tailmembrane1.field_78796_g = this.tailfin1.field_78796_g;
        this.tailmembrane2.field_78798_e = this.tailfin1.field_78798_e;
        this.tailmembrane2.field_78800_c = this.tailfin1.field_78800_c;
        this.tailmembrane2.field_78796_g = this.tailfin1.field_78796_g;
        this.tailmembrane3.field_78798_e = this.tailfin1.field_78798_e;
        this.tailmembrane3.field_78800_c = this.tailfin1.field_78800_c;
        this.tailmembrane3.field_78796_g = this.tailfin1.field_78796_g;
        if (e.getActivity() == 1) {
            f3 = (e.field_70126_B - e.field_70177_z) * 10.0f;
            f3 = -f3;
            final RenderInfo renderInfo = r;
            renderInfo.rf1 += (f3 - r.rf1) / 50.0f;
            if (r.rf1 > 50.0f) {
                r.rf1 = 50.0f;
            }
            if (r.rf1 < -50.0f) {
                r.rf1 = -50.0f;
            }
            f3 = r.rf1;
        }
        else {
            f3 /= 2.0f;
        }
        this.neck3.field_78796_g = (float)Math.toRadians(f3) * 0.125f;
        this.neck2.field_78798_e = this.neck3.field_78798_e - (float)Math.cos(this.neck3.field_78796_g) * 14.0f;
        this.neck2.field_78800_c = this.neck3.field_78800_c + 0.5f - (float)Math.sin(this.neck3.field_78796_g) * 14.0f;
        this.neck2.field_78796_g = (float)Math.toRadians(f3) * 0.25f;
        this.neck1.field_78798_e = this.neck2.field_78798_e - (float)Math.cos(this.neck2.field_78796_g) * 14.0f;
        this.neck1.field_78800_c = this.neck2.field_78800_c + 0.5f - (float)Math.sin(this.neck2.field_78796_g) * 14.0f;
        this.neck1.field_78796_g = (float)Math.toRadians(f3) * 0.5f;
        this.head.field_78798_e = this.neck1.field_78798_e - (float)Math.cos(this.neck1.field_78796_g) * 8.0f;
        this.head.field_78800_c = this.neck1.field_78800_c - (float)Math.sin(this.neck1.field_78796_g) * 8.0f;
        this.head.field_78796_g = (float)Math.toRadians(f3) * 0.75f;
        this.hammerhead.field_78798_e = this.head.field_78798_e;
        this.hammerhead.field_78800_c = this.head.field_78800_c;
        this.hammerhead.field_78796_g = this.head.field_78796_g;
        this.hammerhead2.field_78798_e = this.head.field_78798_e;
        this.hammerhead2.field_78800_c = this.head.field_78800_c;
        this.hammerhead2.field_78796_g = this.head.field_78796_g;
        this.mouth.field_78798_e = this.head.field_78798_e;
        this.mouth.field_78800_c = this.head.field_78800_c;
        this.mouth.field_78796_g = this.head.field_78796_g;
        newangle = MathHelper.func_76134_b(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.14f;
        if (e.getAttacking() != 0) {
            this.mouth.field_78795_f = -0.61f + newangle;
        }
        else {
            this.mouth.field_78795_f = -0.87f;
        }
        e.setRenderInfo(r);
        this.leftfoot.func_78785_a(f5);
        this.butt.func_78785_a(f5);
        this.rightfoot.func_78785_a(f5);
        this.topfin1.func_78785_a(f5);
        this.topfin2.func_78785_a(f5);
        this.topfin3.func_78785_a(f5);
        this.topfin4.func_78785_a(f5);
        this.leftshoulder.func_78785_a(f5);
        this.lefwingfin1.func_78785_a(f5);
        this.tailfin1.func_78785_a(f5);
        this.tailmembrane2.func_78785_a(f5);
        this.tailfin2.func_78785_a(f5);
        this.tailfin4.func_78785_a(f5);
        this.tailfin3.func_78785_a(f5);
        this.tailmembrane1.func_78785_a(f5);
        this.topmem1.func_78785_a(f5);
        this.topmem2.func_78785_a(f5);
        this.topmem3.func_78785_a(f5);
        this.topmem4.func_78785_a(f5);
        this.neck1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.chest1.func_78785_a(f5);
        this.leftleg1.func_78785_a(f5);
        this.mouth.func_78785_a(f5);
        this.neck2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.hammerhead.func_78785_a(f5);
        this.chest.func_78785_a(f5);
        this.neck3.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.rightleg1.func_78785_a(f5);
        this.leftleg2.func_78785_a(f5);
        this.rightleg2.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.leftleg3.func_78785_a(f5);
        this.rightleg3.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        this.tailmembrane3.func_78785_a(f5);
        this.leftwingfin2.func_78785_a(f5);
        this.leftwingfin3.func_78785_a(f5);
        this.leftwingfin4.func_78785_a(f5);
        this.leftwingmembrane.func_78785_a(f5);
        this.rightshoulder.func_78785_a(f5);
        this.rightwingfin1.func_78785_a(f5);
        this.rightwingfin2.func_78785_a(f5);
        this.rightwingfin3.func_78785_a(f5);
        this.rightwingfin4.func_78785_a(f5);
        this.rightwingmembrane.func_78785_a(f5);
        this.hammerhead2.func_78785_a(f5);
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
