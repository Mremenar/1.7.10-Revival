// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import java.util.Iterator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;

public class AntRobot extends EntityLiving
{
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private int playing;
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private RenderSpiderRobotInfo renderdata;
    private int didonce;
    private int rideTicker;
    private int owned;
    
    public AntRobot(final World par1World) {
        super(par1World);
        this.playing = 0;
        this.TargetSorter = null;
        this.moveSpeed = 0.3f;
        this.renderdata = new RenderSpiderRobotInfo();
        this.didonce = 0;
        this.rideTicker = 0;
        this.owned = 0;
        this.func_70105_a(2.75f, 1.25f);
        this.field_70153_n = null;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 12.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70178_ae = true;
        this.field_70728_aV = OreSpawnMain.AntRobot_stats.health / 2;
    }
    
    public AntRobot(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.func_70107_b(par2, par4 + this.field_70129_M, par6);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = par2;
        this.field_70167_r = par4;
        this.field_70166_s = par6;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)OreSpawnMain.AntRobot_stats.health);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.AntRobot_stats.attack);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public void setOwned() {
        this.owned = 1;
    }
    
    public int getOwned() {
        return this.owned;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.AntRobot_stats.defense;
    }
    
    protected void func_70619_bc() {
        EntityLivingBase e = null;
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70153_n != null) {
            return;
        }
        super.func_70619_bc();
        if (this.owned == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            if (this.field_70170_p.field_73012_v.nextInt(20) == 0) {
                this.feetFindSomethingToHit();
            }
            if (this.field_70170_p.field_73012_v.nextInt(150) == 0) {
                this.func_70624_b((EntityLivingBase)null);
            }
            e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack(2.0f, false);
            }
            if (e != null) {
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (this.func_70068_e((Entity)e) > 16.0) {
                    final double d1 = e.field_70161_v - this.field_70161_v;
                    final double d2 = e.field_70165_t - this.field_70165_t;
                    final double dd = Math.atan2(d1, d2);
                    this.goThisWay(0.2 * Math.cos(dd), 0.2 * Math.sin(dd));
                }
            }
            else {
                this.setAttacking(0);
            }
            if (e != null && this.field_70170_p.field_73012_v.nextInt(15) == 0) {
                e = this.func_70638_az();
                if (e == null) {
                    e = this.findSomethingToAttack(2.0f, true);
                }
                if (e != null) {
                    if (this.func_70068_e((Entity)e) < (6.0f + e.field_70130_N / 2.0f) * (6.0f + e.field_70130_N / 2.0f)) {
                        this.setAttacking(1);
                        this.func_70652_k((Entity)e);
                    }
                    else {
                        this.setAttacking(0);
                    }
                }
                else {
                    this.setAttacking(0);
                }
            }
        }
    }
    
    protected void func_70629_bd() {
        if (this.field_70153_n != null) {
            return;
        }
        super.func_70629_bd();
    }
    
    private void initLegData() {
        if (this.renderdata == null) {
            this.renderdata = new RenderSpiderRobotInfo();
        }
        for (int i = 0; i < 6; ++i) {
            this.renderdata.ycurrentangle[i] = 0.0f;
            this.renderdata.ywantedangle[i] = 0.0f;
            this.renderdata.ydisplayangle[i] = 0.0f;
            this.renderdata.yvelocity[i] = 0.0f;
            this.renderdata.ymid[i] = 0.0f;
            this.renderdata.yoff[i] = 0.0f;
            this.renderdata.yrange[i] = 0.0f;
            this.renderdata.udcurrentangle[i] = 0.0f;
            this.renderdata.udwantedangle[i] = 0.0f;
            this.renderdata.uddisplayangle[i] = 0.0f;
            this.renderdata.udvelocity[i] = 0.0f;
            this.renderdata.p1xangle[i] = 0.7853981633974483;
            this.renderdata.p2xangle[i] = 0.0;
            this.renderdata.p3xangle[i] = -0.7853981633974483;
            this.renderdata.pxvelocity[i] = 0.0f;
            this.renderdata.foot_xpos[i] = (float)this.field_70165_t;
            this.renderdata.foot_ypos[i] = (float)this.field_70163_u;
            this.renderdata.foot_zpos[i] = (float)this.field_70161_v;
            this.renderdata.realposx[i] = 0.0f;
            this.renderdata.realposy[i] = 0.0f;
            this.renderdata.realposz[i] = 0.0f;
            this.renderdata.legoff[i] = 0.0f;
            this.renderdata.footup[i] = 1;
            this.renderdata.uppoint[i] = 0.0f;
            this.renderdata.footingticker[i] = 0;
            this.renderdata.gpcounter = 0;
            if (i == 0) {
                this.renderdata.legoff[i] = 0.75f;
                this.renderdata.ymid[i] = 0.0f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 1;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 1) {
                this.renderdata.legoff[i] = 0.75f;
                this.renderdata.ymid[i] = 3.1415927f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 0;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 2) {
                this.renderdata.legoff[i] = 1.0f;
                this.renderdata.ymid[i] = -0.7853982f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 3;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 3) {
                this.renderdata.legoff[i] = 1.0f;
                this.renderdata.ymid[i] = 3.9269907f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 2;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 4) {
                this.renderdata.legoff[i] = 1.15f;
                this.renderdata.ymid[i] = 0.7853982f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 5;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 5) {
                this.renderdata.legoff[i] = 1.15f;
                this.renderdata.ymid[i] = 2.3561945f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 4;
                this.renderdata.yoff[i] = -0.75f;
            }
        }
    }
    
    private float getNewVelocity(final float v, final float diff, float curval) {
        float tv = v;
        tv *= 18.0f;
        if (tv < 2.0f) {
            tv = 2.0f;
        }
        if (tv > 8.0f) {
            tv = 8.0f;
        }
        if (diff > 0.0f) {
            if (diff < 0.008726646259971648 * tv) {
                curval = 0.0f;
            }
            else {
                curval += (float)(0.004363323129985824 * tv);
                if (diff < 0.06981317007977318 * tv) {
                    curval = (float)(0.017453292519943295 * tv);
                }
                if (diff < 0.03490658503988659 * tv) {
                    curval = (float)(0.008726646259971648 * tv);
                }
                if (curval > 0.06981317007977318 * tv) {
                    curval = (float)(0.06981317007977318 * tv);
                }
            }
        }
        else if (diff > -0.008726646259971648 * tv) {
            curval = 0.0f;
        }
        else {
            curval -= (float)(0.004363323129985824 * tv);
            if (diff > -0.06981317007977318 * tv) {
                curval = -(float)(0.017453292519943295 * tv);
            }
            if (diff > -0.03490658503988659 * tv) {
                curval = -(float)(0.008726646259971648 * tv);
            }
            if (curval < -0.06981317007977318 * tv) {
                curval = -(float)(0.06981317007977318 * tv);
            }
        }
        return curval;
    }
    
    public void updateLegs() {
        if (!this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70177_z %= 360.0f;
        while (this.field_70177_z < 0.0f) {
            this.field_70177_z += 360.0f;
        }
        final RenderSpiderRobotInfo renderdata = this.renderdata;
        ++renderdata.gpcounter;
        if (this.didonce == 0) {
            this.didonce = 1;
            this.initLegData();
        }
        float d1 = (float)(this.field_70169_q - this.field_70165_t);
        float d2 = (float)(this.field_70167_r - this.field_70163_u);
        float d3 = (float)(this.field_70166_s - this.field_70161_v);
        final float realv = (float)Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
        int i;
        int fcount;
        int[] footingticker;
        int n;
        int it;
        float dd;
        float da;
        float c1;
        float c2;
        float c3;
        float cc;
        float diff;
        double[] p1xangle;
        int n2;
        float[] udwantedangle;
        int n3;
        float[] udwantedangle2;
        int n4;
        double rhm;
        double rhdir;
        double rdv;
        float[] udcurrentangle;
        int n5;
        float n6;
        float[] ywantedangle;
        int n7;
        float n8;
        float[] ycurrentangle;
        int n9;
        float[] ycurrentangle2;
        int n10;
        float[] ycurrentangle3;
        int n11;
        for (i = 0, i = 0; i < 6; ++i) {
            fcount = 0;
            footingticker = this.renderdata.footingticker;
            n = i;
            ++footingticker[n];
            this.renderdata.realposx[i] = (float)(this.field_70165_t - this.renderdata.legoff[i] * Math.sin(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i]));
            this.renderdata.realposz[i] = (float)(this.field_70161_v + this.renderdata.legoff[i] * Math.cos(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i]));
            this.renderdata.realposy[i] = (float)this.field_70163_u + this.renderdata.yoff[i];
            it = this.renderdata.footingticker[i] + this.renderdata.footingticker[this.renderdata.pairedwith[i]];
            if (it > 50 && this.renderdata.footingticker[i] > this.renderdata.footingticker[this.renderdata.pairedwith[i]]) {
                this.renderdata.footingticker[i] = 0;
            }
            d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
            d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
            d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
            dd = (float)Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            dd *= 16.0f;
            da = (float)(Math.abs(this.renderdata.ycurrentangle[i] - (Math.toRadians(MathHelper.func_76138_g((double)this.field_70177_z)) + this.renderdata.ymid[i])) % 6.283185307179586);
            if (da > 3.141592653589793) {
                da -= (float)6.283185307179586;
            }
            if (da < -3.141592653589793) {
                da += (float)6.283185307179586;
            }
            da = Math.abs(da);
            if (dd > 144.0f || dd < 22.0f || da > Math.abs(this.renderdata.yrange[i]) * 8.0f / 6.0f || Math.abs(this.renderdata.udcurrentangle[i]) > 1.25 || this.renderdata.footingticker[i] == 0) {
                this.findNewFooting(i);
                d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
                d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
                d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
                dd = (float)Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
                dd *= 16.0f;
            }
            c1 = (float)(49.0 * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p1xangle[i]));
            c2 = 49.0f;
            c3 = (float)(49.0 * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p3xangle[i]));
            cc = c1 + c2 + c3;
            diff = cc - dd;
            this.renderdata.pxvelocity[i] = this.getNewVelocity(realv, (float)(diff * 3.141592653589793 / 360.0), this.renderdata.pxvelocity[i]);
            if (this.renderdata.pxvelocity[i] == 0.0f || Math.abs(diff) < 8.0f) {
                ++fcount;
            }
            p1xangle = this.renderdata.p1xangle;
            n2 = i;
            p1xangle[n2] += this.renderdata.pxvelocity[i];
            this.renderdata.p2xangle[i] = 0.0;
            this.renderdata.p3xangle[i] = -this.renderdata.p1xangle[i];
            if (this.renderdata.uppoint[i] != 0.0f) {
                dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.uppoint[i]) * 16.0);
            }
            else {
                dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.foot_ypos[i]) * 16.0);
            }
            this.renderdata.udwantedangle[i] = (float)(dd - 1.5707963267948966);
            while (this.renderdata.udwantedangle[i] > 3.141592653589793) {
                udwantedangle = this.renderdata.udwantedangle;
                n3 = i;
                udwantedangle[n3] -= (float)6.283185307179586;
            }
            while (this.renderdata.udwantedangle[i] < -3.141592653589793) {
                udwantedangle2 = this.renderdata.udwantedangle;
                n4 = i;
                udwantedangle2[n4] += (float)6.283185307179586;
            }
            rhm = this.renderdata.udwantedangle[i];
            rhdir = this.renderdata.udcurrentangle[i];
            for (rdv = (rhm - rhdir) % 6.283185307179586; rdv > 3.141592653589793; rdv -= 6.283185307179586) {}
            while (rdv < -3.141592653589793) {
                rdv += 6.283185307179586;
            }
            diff = (float)rdv;
            this.renderdata.udvelocity[i] = this.getNewVelocity(realv * 2.0f, diff, this.renderdata.udvelocity[i]);
            if (this.renderdata.udvelocity[i] == 0.0f || Math.abs(diff) < 0.03490658503988659) {
                this.renderdata.uppoint[i] = 0.0f;
                ++fcount;
            }
            for (rhdir += this.renderdata.udvelocity[i]; rhdir > 3.141592653589793; rhdir -= 6.283185307179586) {}
            while (rhdir < -3.141592653589793) {
                rhdir += 6.283185307179586;
            }
            udcurrentangle = this.renderdata.udcurrentangle;
            n5 = i;
            n6 = (float)rhdir;
            udcurrentangle[n5] = n6;
            dd = n6;
            this.renderdata.uddisplayangle[i] = dd;
            d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
            d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
            dd = (float)Math.atan2(d3, d1);
            ywantedangle = this.renderdata.ywantedangle;
            n7 = i;
            n8 = dd;
            ywantedangle[n7] = n8;
            rhm = n8;
            rhdir = this.renderdata.ycurrentangle[i];
            rdv = (rhm - rhdir) % 6.283185307179586;
            if (rdv > 3.141592653589793) {
                rdv -= 6.283185307179586;
            }
            if (rdv < -3.141592653589793) {
                rdv += 6.283185307179586;
            }
            diff = (float)rdv;
            this.renderdata.yvelocity[i] = this.getNewVelocity(realv, diff, this.renderdata.yvelocity[i]);
            if (this.renderdata.yvelocity[i] == 0.0f || Math.abs(diff) < 0.03490658503988659) {
                ++fcount;
            }
            ycurrentangle = this.renderdata.ycurrentangle;
            n9 = i;
            ycurrentangle[n9] += this.renderdata.yvelocity[i];
            while (this.renderdata.ycurrentangle[i] > 3.141592653589793) {
                ycurrentangle2 = this.renderdata.ycurrentangle;
                n10 = i;
                ycurrentangle2[n10] -= (float)6.283185307179586;
            }
            while (this.renderdata.ycurrentangle[i] < -3.141592653589793) {
                ycurrentangle3 = this.renderdata.ycurrentangle;
                n11 = i;
                ycurrentangle3[n11] += (float)6.283185307179586;
            }
            for (dd = (float)(this.renderdata.ycurrentangle[i] - Math.toRadians(MathHelper.func_76138_g((double)this.field_70177_z)) - 1.5707963267948966); dd > 3.141592653589793; dd -= (float)6.283185307179586) {}
            while (dd < -3.141592653589793) {
                dd += (float)6.283185307179586;
            }
            this.renderdata.ydisplayangle[i] = dd;
            if (fcount == 3) {
                this.renderdata.footup[i] = 0;
            }
        }
    }
    
    private void findNewFooting(final int i) {
        float f = 9.0f;
        int found = 0;
        float range = 0.0f;
        final double rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
        final double pi = 3.1415926545;
        this.renderdata.footingticker[i] = 0;
        float d1 = (float)(this.field_70165_t - this.field_70169_q);
        float d2 = (float)(this.field_70161_v - this.field_70166_s);
        final double rhm = Math.atan2(d2, d1);
        final double velocity = Math.sqrt(d1 * d1 + d2 * d2);
        double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
        if (rdv > pi) {
            rdv -= pi * 2.0;
        }
        rdv = Math.abs(rdv);
        if (Math.abs(velocity) < 0.01) {
            rdv = 0.0;
        }
        range = this.renderdata.yrange[i];
        range *= 0.8f;
        if (Math.abs((this.field_70126_B - this.field_70177_z) % 360.0f) > 0.75f) {
            range = 0.0f;
        }
        if (i >= 4) {
            f = 4.0f;
        }
        if (rdv > 1.5) {
            range = -range;
            f = 4.0f;
            if (i >= 4) {
                f = 9.0f;
            }
        }
        if (i == 0 || i == 1) {
            f = 6.0f;
        }
        final float deffx;
        float fx = deffx = (float)(this.renderdata.realposx[i] - f / 2.0f * Math.sin(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i]));
        final float deffz;
        float fz = deffz = (float)(this.renderdata.realposz[i] + f / 2.0f * Math.cos(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i]));
        final float deffy;
        float fy = deffy = this.renderdata.realposy[i] - 1.0f;
        final float oldf = f;
        int span = 1;
        while (found == 0 && f > 2.5f) {
            fx = (float)(this.renderdata.realposx[i] - f * Math.sin(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i] - range));
            fz = (float)(this.renderdata.realposz[i] + f * Math.cos(Math.toRadians(MathHelper.func_76138_g((double)(this.field_70177_z + 90.0f))) + this.renderdata.ymid[i] - range));
            fy = this.renderdata.realposy[i];
            for (int j = 8; found == 0 && j > -9; --j) {
                for (int m = -span; found == 0 && m <= span; ++m) {
                    for (int n = -span; found == 0 && n <= span; ++n) {
                        final Block blk = this.field_70170_p.func_147439_a((int)fx + m, (int)fy + j, (int)fz + n);
                        if (blk != Blocks.field_150350_a && this.field_70170_p.func_147439_a((int)fx + m, (int)fy + j, (int)fz + n).func_149688_o().func_76220_a()) {
                            d1 = this.renderdata.realposx[i] - (fx + m);
                            final float d3 = this.renderdata.realposy[i] - (fy + j + 1.0f);
                            d2 = this.renderdata.realposz[i] - (fz + n);
                            float dd = (float)Math.sqrt(d1 * d1 + d3 * d3 + d2 * d2);
                            dd *= 16.0f;
                            if (dd <= 144.0f) {
                                fy += j + 1;
                                fx += m;
                                fz += n;
                                found = 1;
                                break;
                            }
                        }
                    }
                }
            }
            --f;
            if (f < 2.5f && range != 0.0f) {
                range = 0.0f;
                span = 3;
                f = oldf;
            }
        }
        if (found == 0) {
            fx = deffx;
            fy = deffy;
            fz = deffz;
        }
        final float sfx = this.renderdata.foot_xpos[i];
        final float sfy = this.renderdata.foot_ypos[i];
        final float sfz = this.renderdata.foot_zpos[i];
        this.renderdata.foot_xpos[i] = fx;
        this.renderdata.foot_ypos[i] = fy;
        this.renderdata.foot_zpos[i] = fz;
        if (this.renderdata.footup[i] == 0) {
            this.renderdata.footup[i] = 1;
            d1 = sfx - fx;
            final float d3 = sfy - fy;
            d2 = sfz - fz;
            float dd = (float)Math.sqrt(d1 * d1 + d3 * d3 + d2 * d2);
            dd *= 16.0f;
            d1 = (sfy + fy) / 2.0f;
            if (dd > 3.0f) {
                d1 += 0.3f;
            }
            if (dd > 24.0f) {
                d1 += 0.6f;
            }
            if (dd > 50.0f) {
                d1 += 0.6f;
            }
            this.renderdata.uppoint[i] = d1;
        }
    }
    
    public boolean shouldRiderSit() {
        return true;
    }
    
    public int getTrackingRange() {
        return 128;
    }
    
    public int getUpdateFrequency() {
        return 10;
    }
    
    public boolean sendsVelocityUpdates() {
        return true;
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_110163_bv();
        this.initLegData();
        final int i = 0;
        this.field_70180_af.func_75682_a(20, (Object)i);
    }
    
    public RenderSpiderRobotInfo getRenderSpiderRobotInfo() {
        return this.renderdata;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public double func_70042_X() {
        return 0.55 + Math.cos(this.rideTicker * 0.19f) * 0.02;
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            float f = -1.25f;
            f += (float)(Math.cos(this.rideTicker * 0.33f) * 0.05);
            this.field_70153_n.func_70107_b(this.field_70165_t - f * Math.sin(Math.toRadians(this.field_70177_z)), this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + f * Math.cos(Math.toRadians(this.field_70177_z)));
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("cactus")) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("inFire")) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("onFire")) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("magic")) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("starve")) {
            return false;
        }
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityLiving) {
            this.func_70624_b((EntityLivingBase)e);
            this.func_70625_a(e, 20.0f, 20.0f);
        }
        return super.func_70097_a(par1DamageSource, par2);
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        if (this.field_70153_n != null) {
            this.boatPosRotationIncrements = par9 + 8;
        }
        else {
            this.boatPosRotationIncrements = par9 + 6;
        }
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        if (this.field_70153_n == null) {
            super.func_70016_h(par1, par3, par5);
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.func_70015_d(0);
        if (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && !this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70170_p.field_73012_v.nextInt(50) == 0) {
            this.feetFindSomethingToHit();
        }
        if (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && !this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70170_p.field_73012_v.nextInt(9) == 0) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack(1.0f, true);
            if (e != null) {
                if (this.func_70068_e((Entity)e) < (6.0f + e.field_70130_N / 2.0f) * (6.0f + e.field_70130_N / 2.0f)) {
                    this.setAttacking(1);
                    this.func_70652_k((Entity)e);
                }
            }
            else {
                this.setAttacking(0);
            }
        }
        final float f = 4.0f;
        float dx = (float)(f * Math.cos(Math.toRadians(this.field_70177_z - 80.0f)));
        float dz = (float)(f * Math.sin(Math.toRadians(this.field_70177_z - 80.0f)));
        final float dx2 = (float)(f * Math.cos(Math.toRadians(this.field_70177_z - 90.0f)));
        final float dz2 = (float)(f * Math.sin(Math.toRadians(this.field_70177_z - 90.0f)));
        if (this.field_70170_p.field_73012_v.nextInt(18) == 0) {
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 10.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
        if (this.field_70170_p.field_73012_v.nextInt(7) == 0) {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 10.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
        if (this.field_70170_p.field_73012_v.nextInt(16) == 0) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 5.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
        dx = (float)(f * Math.cos(Math.toRadians(this.field_70177_z - 100.0f)));
        dz = (float)(f * Math.sin(Math.toRadians(this.field_70177_z - 100.0f)));
        if (this.field_70170_p.field_73012_v.nextInt(18) == 0) {
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 10.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
        if (this.field_70170_p.field_73012_v.nextInt(7) == 0) {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 10.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
        if (this.field_70170_p.field_73012_v.nextInt(16) == 0) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t + dx, this.field_70163_u + 0.5, this.field_70161_v + dz, (double)(dx2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 5.0f), (double)(dz2 / f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 20.0f));
        }
    }
    
    public void func_70636_d() {
        final List list = null;
        final double velocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        final double d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.3;
        double gh = 1.75;
        int dist = 2;
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70153_n == null) {
            super.func_70636_d();
        }
        if (this.field_70181_x > 0.8500000238418579) {
            this.field_70181_x = 0.8500000238418579;
        }
        if (this.field_70181_x < -0.8500000238418579) {
            this.field_70181_x = -0.8500000238418579;
        }
        if (this.field_70159_w < -1.25) {
            this.field_70159_w = -1.25;
        }
        if (this.field_70159_w > 1.25) {
            this.field_70159_w = 1.25;
        }
        if (this.field_70179_y < -1.25) {
            this.field_70179_y = -1.25;
        }
        if (this.field_70179_y > 1.25) {
            this.field_70179_y = 1.25;
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.rideTicker += this.field_70170_p.field_73012_v.nextInt(3);
        if (this.playing > 0) {
            --this.playing;
        }
        if (this.field_70153_n != null && this.playing == 0 && this.field_70170_p.field_73012_v.nextInt(80) == 1) {
            this.field_70170_p.func_72956_a((Entity)this, "orespawn:robotspider", 0.35f, 1.0f);
            this.playing = 125;
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.field_70153_n == null) {
                Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh + 1.0f), (int)this.field_70161_v);
                if (bid == Blocks.field_150350_a) {
                    bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                }
                if (bid != Blocks.field_150350_a && bid != Blocks.field_150355_j && bid != Blocks.field_150358_i && bid != Blocks.field_150353_l && bid != Blocks.field_150356_k) {
                    this.field_70181_x += 0.12;
                    this.field_70163_u += 0.12;
                    this.boatY += 0.12;
                }
                else {
                    this.field_70181_x -= 0.002;
                }
            }
            if (this.boatPosRotationIncrements > 0) {
                final double d8 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
                final double d9 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
                final double d10 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
                this.func_70107_b(d8, d9, d10);
                this.field_70125_A += (float)((this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
                double d11 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
                if (this.field_70153_n != null) {
                    d11 = MathHelper.func_76138_g(this.field_70153_n.field_70177_z - (double)this.field_70177_z);
                }
                this.func_70101_b(this.field_70177_z += (float)(d11 / this.boatPosRotationIncrements), this.field_70125_A);
                --this.boatPosRotationIncrements;
            }
            else {
                final double d8 = this.field_70165_t + this.field_70159_w;
                final double d9 = this.field_70163_u + this.field_70181_x;
                final double d10 = this.field_70161_v + this.field_70179_y;
                this.func_70107_b(d8, d9, d10);
                this.field_70159_w *= 0.99;
                this.field_70181_x *= 0.95;
                this.field_70179_y *= 0.99;
            }
            this.updateLegs();
        }
        else {
            if (this.field_70153_n != null) {
                gh = 2.25;
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a && bid != Blocks.field_150355_j && bid != Blocks.field_150358_i && bid != Blocks.field_150353_l && bid != Blocks.field_150356_k) {
                    this.field_70181_x += 0.06;
                    this.field_70163_u += 0.03;
                }
                else {
                    this.field_70181_x -= 0.02;
                }
            }
            else {
                Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh + 1.0f), (int)this.field_70161_v);
                if (bid == Blocks.field_150350_a) {
                    bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                }
                if (bid != Blocks.field_150350_a && bid != Blocks.field_150355_j && bid != Blocks.field_150358_i && bid != Blocks.field_150353_l && bid != Blocks.field_150356_k) {
                    this.field_70181_x += 0.15;
                    this.field_70163_u += 0.15;
                    this.boatY += 0.15;
                }
                else {
                    this.field_70181_x -= 0.002;
                }
            }
            if (this.field_70153_n != null) {
                final EntityPlayer pp = (EntityPlayer)this.field_70153_n;
                obstruction_factor = 0.0;
                dist = 3;
                dist += (int)(velocity * 6.0);
                for (int k = 1; k < dist; ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        for (int j = -90; j <= 90; j += 30) {
                            final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f + j));
                            final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f + j));
                            final Block bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - k, (int)(this.field_70161_v + dz));
                            if (bid != Blocks.field_150350_a && bid != Blocks.field_150355_j && bid != Blocks.field_150358_i && bid != Blocks.field_150353_l && bid != Blocks.field_150356_k) {
                                obstruction_factor += 0.02;
                            }
                        }
                    }
                }
                this.field_70181_x += obstruction_factor * 0.05;
                this.field_70163_u += obstruction_factor * 0.05;
                double d8;
                for (d8 = this.field_70153_n.field_70177_z, d8 %= 360.0; d8 < 0.0; d8 += 360.0) {}
                double d9;
                for (d9 = this.field_70177_z, d9 %= 360.0; d9 < 0.0; d9 += 360.0) {}
                for (relative_g = (d8 - d9) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                if (relative_g > 90.0) {
                    relative_g -= 180.0;
                }
                if (velocity > 0.01) {
                    d8 = 1.85 - velocity;
                    d8 = Math.abs(d8);
                    if (d8 < 0.01) {
                        d8 = 0.01;
                    }
                    if (d8 > 0.9) {
                        d8 = 0.9;
                    }
                    this.field_70177_z = this.field_70153_n.field_70177_z + (float)(relative_g * d8);
                }
                else {
                    this.field_70177_z = this.field_70153_n.field_70177_z;
                }
                relative_g = Math.abs(relative_g) * velocity;
                if (relative_g > 50.0) {
                    relative_g = 0.0;
                }
                this.field_70125_A = 0.0f;
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
                double newvelocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                final double rr = Math.atan2(this.field_70153_n.field_70179_y, this.field_70153_n.field_70159_w);
                final double rhm = Math.atan2(this.field_70179_y, this.field_70159_w);
                final double rhdir = Math.toRadians((this.field_70153_n.field_70177_z + 90.0f) % 360.0f);
                final double rt = 0.0;
                final double pi = 3.1415926545;
                double deltav = 0.0;
                final float im = pp.field_70701_bs;
                double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
                if (rdv > pi) {
                    rdv -= pi * 2.0;
                }
                rdv = Math.abs(rdv);
                if (Math.abs(newvelocity) < 0.01) {
                    rdv = 0.0;
                }
                if (rdv > 1.5) {
                    newvelocity = -newvelocity;
                }
                if (Math.abs(im) > 0.001f) {
                    if (im > 0.0f) {
                        deltav = 0.05;
                    }
                    else {
                        max_speed = 0.25;
                        deltav = -0.05;
                    }
                    newvelocity += deltav;
                    if (newvelocity >= 0.0) {
                        if (newvelocity > max_speed) {
                            newvelocity = max_speed;
                        }
                        this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                        this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                    }
                    else {
                        if (newvelocity < -max_speed) {
                            newvelocity = -max_speed;
                        }
                        newvelocity = -newvelocity;
                        this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 270.0f)) * newvelocity;
                        this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 270.0f)) * newvelocity;
                    }
                }
                else if (newvelocity >= 0.0) {
                    this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                    this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                }
                else {
                    this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 270.0f)) * (newvelocity * -1.0);
                    this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 270.0f)) * (newvelocity * -1.0);
                }
                this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                this.field_70159_w *= 0.98;
                this.field_70181_x *= 0.98;
                this.field_70179_y *= 0.98;
            }
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.8;
            this.field_70181_x *= 0.98;
            this.field_70179_y *= 0.8;
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                this.field_70153_n = null;
            }
        }
    }
    
    public void goThisWay(final double mx, final double mz) {
        this.field_70159_w = mx;
        this.field_70179_y = mz;
    }
    
    public boolean func_70650_aV() {
        return this.field_70153_n == null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("AntRobotOwned", this.owned);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.owned = par1NBTTagCompound.func_74762_e("AntRobotOwned");
    }
    
    public float func_70053_R() {
        return 0.95f;
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (this.owned == 0) {
            return true;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151042_j && par1EntityPlayer.func_70068_e((Entity)this) < 25.0) {
            if (!this.field_70170_p.field_72995_K) {
                float f = this.func_110138_aP() - this.func_110143_aJ();
                if (f > 100.0f) {
                    f = 100.0f;
                }
                if (f > 0.0f) {
                    this.func_70691_i(f);
                }
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = var2;
                --itemStack.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K && this.field_70153_n == null && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            par1EntityPlayer.func_70078_a((Entity)this);
            this.field_70170_p.func_72956_a((Entity)this, "orespawn:robotspidermount", 0.45f, 1.0f);
        }
        return true;
    }
    
    private void feetFindSomethingToHit() {
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0, 8.0, 10.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.feetisSuitableTarget(var8, false)) {
                this.feetattackEntityAsMob((Entity)var8);
            }
        }
    }
    
    private boolean feetisSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        if (par1EntityLiving instanceof AntRobot) {
            return false;
        }
        if (par1EntityLiving == this.field_70153_n) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        final float d1 = (float)(par1EntityLiving.field_70165_t - this.field_70165_t);
        final float d2 = (float)(par1EntityLiving.field_70163_u - this.field_70163_u);
        final float d3 = (float)(par1EntityLiving.field_70161_v - this.field_70161_v);
        final float dd = (float)Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
        if (dd > 9.0f) {
            return false;
        }
        if (dd < 6.0f) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        return true;
    }
    
    public boolean feetattackEntityAsMob(final Entity par1Entity) {
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 0.6;
            double inair = 0.1;
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            ret = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), OreSpawnMain.AntRobot_stats.attack / 10.0f);
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            if (ret) {
                par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return ret;
    }
    
    private EntityLivingBase findSomethingToAttack(final float distmul, final boolean dircheck) {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(12.0 * distmul, 12.0, 12.0 * distmul));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, dircheck)) {
                return var8;
            }
        }
        return null;
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        if (par1EntityLiving instanceof AntRobot) {
            return false;
        }
        if (par1EntityLiving == this.field_70153_n) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par2) {
            final double rr = Math.atan2(par1EntityLiving.field_70161_v - this.field_70161_v, par1EntityLiving.field_70165_t - this.field_70165_t);
            final double rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
            final double pi = 3.1415926545;
            double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (this.func_70068_e((Entity)par1EntityLiving) < 36.0) {
                return true;
            }
            if (rdd > 0.75) {
                return false;
            }
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        return true;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 0.7;
            double inair = 0.1;
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            ret = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (float)OreSpawnMain.AntRobot_stats.attack);
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            if (ret) {
                par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return ret;
    }
    
    public int getAttacking() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    protected Item func_146068_u() {
        return null;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        ItemStack is = null;
        for (int i = 7 + this.field_70170_p.field_73012_v.nextInt(7), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.field_70170_p.field_73012_v.nextInt(12);
            switch (var5) {
                case 0: {
                    is = this.dropItemRand(Items.field_151137_ax, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.field_151107_aW, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Items.field_151132_bS, 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150451_bX), 1);
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150367_z), 1);
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150320_F), 1);
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150331_J), 1);
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150442_at), 1);
                    break;
                }
                case 8: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150451_bX), 1);
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150445_bS), 1);
                    break;
                }
                case 10: {
                    is = this.dropItemRand(Items.field_151042_j, 1);
                    break;
                }
            }
        }
    }
}
