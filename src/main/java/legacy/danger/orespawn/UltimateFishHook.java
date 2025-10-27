// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.ItemFishFood;
import java.util.Arrays;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import java.util.Collection;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.stats.StatList;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.WorldServer;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.entity.projectile.EntityFishHook;

public class UltimateFishHook extends EntityFishHook
{
    private static final List field_146039_d;
    private static final List field_146041_e;
    private static final List field_146036_f;
    private static final List orespawn_lava_fish;
    private static final List orespawn_fish;
    private int field_146037_g;
    private int field_146048_h;
    private int field_146050_i;
    private Block field_146046_j;
    private boolean field_146051_au;
    private int field_146049_av;
    private int field_146047_aw;
    private int fish_on_hook;
    private int fish_wait_time;
    private int ticks_catchable;
    private float fish_direction;
    public Entity field_146043_c;
    private int field_146055_aB;
    private double field_146056_aC;
    private double field_146057_aD;
    private double field_146058_aE;
    private double field_146059_aF;
    private double field_146060_aG;
    @SideOnly(Side.CLIENT)
    private double field_146061_aH;
    @SideOnly(Side.CLIENT)
    private double field_146052_aI;
    @SideOnly(Side.CLIENT)
    private double field_146053_aJ;
    private int fishing_in_lava;
    
    public UltimateFishHook(final World par1World) {
        super(par1World);
        this.fishing_in_lava = 0;
        this.field_146037_g = -1;
        this.field_146048_h = -1;
        this.field_146050_i = -1;
        this.func_70105_a(0.25f, 0.25f);
        this.field_70158_ak = true;
        this.field_70174_ab = 3000;
        this.field_70178_ae = true;
    }
    
    @SideOnly(Side.CLIENT)
    public UltimateFishHook(final World par1World, final double par2, final double par4, final double par6, final EntityPlayer par8EntityPlayer) {
        this(par1World);
        this.func_70107_b(par2, par4, par6);
        this.field_70158_ak = true;
        this.field_146042_b = par8EntityPlayer;
        par8EntityPlayer.field_71104_cf = this;
        this.field_70174_ab = 3000;
        this.field_70178_ae = true;
    }
    
    public UltimateFishHook(final World par1World, final EntityPlayer par2EntityPlayer) {
        super(par1World);
        this.fishing_in_lava = 0;
        this.field_146037_g = -1;
        this.field_146048_h = -1;
        this.field_146050_i = -1;
        this.field_70158_ak = true;
        this.field_146042_b = par2EntityPlayer;
        ((UltimateFishHook)(this.field_146042_b.field_71104_cf = this)).func_70105_a(0.25f, 0.25f);
        this.func_70012_b(par2EntityPlayer.field_70165_t, par2EntityPlayer.field_70163_u + 1.62 - par2EntityPlayer.field_70129_M, par2EntityPlayer.field_70161_v, par2EntityPlayer.field_70177_z, par2EntityPlayer.field_70125_A);
        this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0f * 3.1415927f) * 0.16f;
        this.field_70163_u -= 0.10000000149011612;
        this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0f * 3.1415927f) * 0.16f;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        final float f = 0.4f;
        this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0f * 3.1415927f) * MathHelper.func_76134_b(this.field_70125_A / 180.0f * 3.1415927f) * f;
        this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0f * 3.1415927f) * MathHelper.func_76134_b(this.field_70125_A / 180.0f * 3.1415927f) * f;
        this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0f * 3.1415927f) * f;
        this.func_146035_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5f, 1.0f);
        this.field_70174_ab = 3000;
        this.field_70178_ae = true;
    }
    
    protected void func_70088_a() {
        this.field_70174_ab = 3000;
        this.field_70178_ae = true;
    }
    
    public void func_146035_c(double p_146035_1_, double p_146035_3_, double p_146035_5_, final float p_146035_7_, final float p_146035_8_) {
        final float f2 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_3_ * p_146035_3_ + p_146035_5_ * p_146035_5_);
        p_146035_1_ /= f2;
        p_146035_3_ /= f2;
        p_146035_5_ /= f2;
        p_146035_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_1_ *= p_146035_7_;
        p_146035_3_ *= p_146035_7_;
        p_146035_5_ *= p_146035_7_;
        this.field_70159_w = p_146035_1_;
        this.field_70181_x = p_146035_3_;
        this.field_70179_y = p_146035_5_;
        final float f3 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_5_ * p_146035_5_);
        final float n = (float)(Math.atan2(p_146035_1_, p_146035_5_) * 180.0 / 3.141592653589793);
        this.field_70177_z = n;
        this.field_70126_B = n;
        final float n2 = (float)(Math.atan2(p_146035_3_, f3) * 180.0 / 3.141592653589793);
        this.field_70125_A = n2;
        this.field_70127_C = n2;
        this.field_146049_av = 0;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_70112_a(final double par1) {
        double d1 = this.field_70121_D.func_72320_b() * 4.0;
        d1 *= 64.0;
        return par1 < d1 * d1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        this.field_146056_aC = par1;
        this.field_146057_aD = par3;
        this.field_146058_aE = par5;
        this.field_146059_aF = par7;
        this.field_146060_aG = par8;
        this.field_146055_aB = par9;
        this.field_70159_w = this.field_146061_aH;
        this.field_70181_x = this.field_146052_aI;
        this.field_70179_y = this.field_146053_aJ;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        this.field_70159_w = par1;
        this.field_146061_aH = par1;
        this.field_70181_x = par3;
        this.field_146052_aI = par3;
        this.field_70179_y = par5;
        this.field_146053_aJ = par5;
    }
    
    public void func_70071_h_() {
        if (this.field_146055_aB > 0) {
            final double d7 = this.field_70165_t + (this.field_146056_aC - this.field_70165_t) / this.field_146055_aB;
            final double d8 = this.field_70163_u + (this.field_146057_aD - this.field_70163_u) / this.field_146055_aB;
            final double d9 = this.field_70161_v + (this.field_146058_aE - this.field_70161_v) / this.field_146055_aB;
            final double d10 = MathHelper.func_76138_g(this.field_146059_aF - this.field_70177_z);
            this.field_70177_z += (float)(d10 / this.field_146055_aB);
            this.field_70125_A += (float)((this.field_146060_aG - this.field_70125_A) / this.field_146055_aB);
            --this.field_146055_aB;
            this.func_70107_b(d7, d8, d9);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        else {
            if (!this.field_70170_p.field_72995_K) {
                final ItemStack itemstack = this.field_146042_b.func_71045_bC();
                if (this.field_146042_b.field_70128_L || !this.field_146042_b.func_70089_S() || itemstack == null || itemstack.func_77973_b() != OreSpawnMain.MyUltimateFishingRod || this.func_70068_e((Entity)this.field_146042_b) > 1024.0) {
                    this.func_70106_y();
                    this.field_146042_b.field_71104_cf = null;
                    return;
                }
                if (this.field_146043_c != null) {
                    if (!this.field_146043_c.field_70128_L) {
                        this.field_70165_t = this.field_146043_c.field_70165_t;
                        this.field_70163_u = this.field_146043_c.field_70121_D.field_72338_b + this.field_146043_c.field_70131_O * 0.8;
                        this.field_70161_v = this.field_146043_c.field_70161_v;
                        return;
                    }
                    this.field_146043_c = null;
                }
            }
            if (this.field_146044_a > 0) {
                --this.field_146044_a;
            }
            if (this.field_146051_au) {
                if (this.field_70170_p.func_147439_a(this.field_146037_g, this.field_146048_h, this.field_146050_i) == this.field_146046_j) {
                    ++this.field_146049_av;
                    if (this.field_146049_av == 1200) {
                        this.func_70106_y();
                    }
                    return;
                }
                this.field_146051_au = false;
                this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_146049_av = 0;
                this.field_146047_aw = 0;
            }
            else {
                ++this.field_146047_aw;
            }
            Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec31, vec32);
            vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            vec32 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (movingobjectposition != null) {
                vec32 = Vec3.func_72443_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
            }
            Entity entity = null;
            final List list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
            double d11 = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity2 = list.get(i);
                if (entity2.func_70067_L() && (entity2 != this.field_146042_b || this.field_146047_aw >= 5)) {
                    final float f = 0.3f;
                    final AxisAlignedBB axisalignedbb = entity2.field_70121_D.func_72314_b((double)f, (double)f, (double)f);
                    final MovingObjectPosition movingobjectposition2 = axisalignedbb.func_72327_a(vec31, vec32);
                    if (movingobjectposition2 != null) {
                        final double d12 = vec31.func_72438_d(movingobjectposition2.field_72307_f);
                        if (d12 < d11 || d11 == 0.0) {
                            entity = entity2;
                            d11 = d12;
                        }
                    }
                }
            }
            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.field_72308_g != null) {
                    if (movingobjectposition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.field_146042_b), 0.0f)) {
                        this.field_146043_c = movingobjectposition.field_72308_g;
                    }
                }
                else {
                    this.field_146051_au = true;
                }
            }
            if (!this.field_146051_au) {
                this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                final float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.141592653589793);
                this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f2) * 180.0 / 3.141592653589793);
                while (this.field_70125_A - this.field_70127_C < -180.0f) {
                    this.field_70127_C -= 360.0f;
                }
                while (this.field_70125_A - this.field_70127_C >= 180.0f) {
                    this.field_70127_C += 360.0f;
                }
                while (this.field_70177_z - this.field_70126_B < -180.0f) {
                    this.field_70126_B -= 360.0f;
                }
                while (this.field_70177_z - this.field_70126_B >= 180.0f) {
                    this.field_70126_B += 360.0f;
                }
                this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2f;
                this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
                float f3 = 0.92f;
                if (this.field_70122_E || this.field_70123_F) {
                    f3 = 0.5f;
                }
                final byte b0 = 5;
                double d13 = 0.0;
                for (int j = 0; j < b0; ++j) {
                    final double d14 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (j + 0) / b0 - 0.125 + 0.125;
                    final double d15 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (j + 1) / b0 - 0.125 + 0.125;
                    final AxisAlignedBB axisalignedbb2 = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d14, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d15, this.field_70121_D.field_72334_f);
                    if (this.field_70170_p.func_72830_b(axisalignedbb2, Material.field_151586_h)) {
                        d13 += 1.0 / b0;
                    }
                    if (this.field_70170_p.func_72830_b(axisalignedbb2, Material.field_151587_i)) {
                        d13 += 1.0 / b0;
                    }
                }
                if (!this.field_70170_p.field_72995_K && d13 > 0.0) {
                    final WorldServer worldserver = (WorldServer)this.field_70170_p;
                    int k = 1;
                    if (this.field_70146_Z.nextFloat() < 0.25f && this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) + 1, MathHelper.func_76128_c(this.field_70161_v))) {
                        k = 2;
                    }
                    if (this.field_70146_Z.nextFloat() < 0.5f && !this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) + 1, MathHelper.func_76128_c(this.field_70161_v))) {
                        --k;
                    }
                    if (this.fish_on_hook > 0) {
                        --this.fish_on_hook;
                        if (this.fish_on_hook <= 0) {
                            this.fish_wait_time = 0;
                            this.ticks_catchable = 0;
                        }
                    }
                    else if (this.ticks_catchable > 0) {
                        this.ticks_catchable -= k;
                        if (this.ticks_catchable <= 0) {
                            this.field_70181_x -= 0.20000000298023224;
                            this.func_85030_a("random.splash", 0.25f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                            final float f4 = (float)MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
                            worldserver.func_147487_a("bubble", this.field_70165_t, (double)(f4 + 1.0f), this.field_70161_v, (int)(1.0f + this.field_70130_N * 20.0f), (double)this.field_70130_N, 0.0, (double)this.field_70130_N, 0.20000000298023224);
                            worldserver.func_147487_a("wake", this.field_70165_t, (double)(f4 + 1.0f), this.field_70161_v, (int)(1.0f + this.field_70130_N * 20.0f), (double)this.field_70130_N, 0.0, (double)this.field_70130_N, 0.20000000298023224);
                            this.fish_on_hook = MathHelper.func_76136_a(this.field_70146_Z, 10, 30);
                        }
                        else {
                            this.fish_direction += (float)(this.field_70146_Z.nextGaussian() * 4.0);
                            final float f4 = this.fish_direction * 0.017453292f;
                            final float f5 = MathHelper.func_76126_a(f4);
                            final float f6 = MathHelper.func_76134_b(f4);
                            final double d16 = this.field_70165_t + f5 * this.ticks_catchable * 0.1f;
                            final double d17 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b) + 1.0f;
                            final double d18 = this.field_70161_v + f6 * this.ticks_catchable * 0.1f;
                            if (this.field_70146_Z.nextFloat() < 0.15f) {
                                worldserver.func_147487_a("bubble", d16, d17 - 0.10000000149011612, d18, 1, (double)f5, 0.1, (double)f6, 0.0);
                            }
                            final float f7 = f5 * 0.04f;
                            final float f8 = f6 * 0.04f;
                            worldserver.func_147487_a("wake", d16, d17, d18, 0, (double)f8, 0.01, (double)(-f7), 1.0);
                            worldserver.func_147487_a("wake", d16, d17, d18, 0, (double)(-f8), 0.01, (double)f7, 1.0);
                        }
                    }
                    else if (this.fish_wait_time > 0) {
                        this.fish_wait_time -= k;
                        float f4 = 0.15f;
                        if (this.fish_wait_time < 20) {
                            f4 += (float)((20 - this.fish_wait_time) * 0.05);
                        }
                        else if (this.fish_wait_time < 40) {
                            f4 += (float)((40 - this.fish_wait_time) * 0.02);
                        }
                        else if (this.fish_wait_time < 60) {
                            f4 += (float)((60 - this.fish_wait_time) * 0.01);
                        }
                        if (this.field_70146_Z.nextFloat() < f4) {
                            final float f5 = MathHelper.func_151240_a(this.field_70146_Z, 0.0f, 360.0f) * 0.017453292f;
                            final float f6 = MathHelper.func_151240_a(this.field_70146_Z, 25.0f, 60.0f);
                            final double d16 = this.field_70165_t + MathHelper.func_76126_a(f5) * f6 * 0.1f;
                            final double d17 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b) + 1.0f;
                            final double d18 = this.field_70161_v + MathHelper.func_76134_b(f5) * f6 * 0.1f;
                            worldserver.func_147487_a("splash", d16, d17, d18, 2 + this.field_70146_Z.nextInt(2), 0.10000000149011612, 0.0, 0.10000000149011612, 0.0);
                        }
                        if (this.fish_wait_time <= 0) {
                            this.fish_direction = MathHelper.func_151240_a(this.field_70146_Z, 0.0f, 360.0f);
                            this.ticks_catchable = MathHelper.func_76136_a(this.field_70146_Z, 100, 200);
                        }
                    }
                    else {
                        this.fish_wait_time = MathHelper.func_76136_a(this.field_70146_Z, 50, 300);
                        this.fish_wait_time -= EnchantmentHelper.func_151387_h((EntityLivingBase)this.field_146042_b) * 20 * 5;
                    }
                    if (this.fish_on_hook > 0) {
                        this.field_70181_x -= this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * 0.2;
                    }
                }
                final double d12 = d13 * 2.0 - 1.0;
                this.field_70181_x += 0.03999999910593033 * d12;
                if (d13 > 0.0) {
                    f3 *= (float)0.9;
                    this.field_70181_x *= 0.8;
                }
                this.field_70159_w *= f3;
                this.field_70181_x *= f3;
                this.field_70179_y *= f3;
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.func_74777_a("xTile", (short)this.field_146037_g);
        par1NBTTagCompound.func_74777_a("yTile", (short)this.field_146048_h);
        par1NBTTagCompound.func_74777_a("zTile", (short)this.field_146050_i);
        par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.field_146046_j));
        par1NBTTagCompound.func_74774_a("shake", (byte)this.field_146044_a);
        par1NBTTagCompound.func_74774_a("inGround", (byte)(byte)(this.field_146051_au ? 1 : 0));
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        this.field_146037_g = par1NBTTagCompound.func_74765_d("xTile");
        this.field_146048_h = par1NBTTagCompound.func_74765_d("yTile");
        this.field_146050_i = par1NBTTagCompound.func_74765_d("zTile");
        this.field_146046_j = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
        this.field_146044_a = (par1NBTTagCompound.func_74771_c("shake") & 0xFF);
        this.field_146051_au = (par1NBTTagCompound.func_74771_c("inGround") == 1);
    }
    
    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return 0.0f;
    }
    
    public int func_146034_e() {
        if (this.field_70170_p.field_72995_K) {
            return 0;
        }
        byte b0 = 0;
        if (this.field_146043_c != null) {
            final double d0 = this.field_146042_b.field_70165_t - this.field_70165_t;
            final double d2 = this.field_146042_b.field_70163_u - this.field_70163_u;
            final double d3 = this.field_146042_b.field_70161_v - this.field_70161_v;
            final double d4 = MathHelper.func_76133_a(d0 * d0 + d2 * d2 + d3 * d3);
            final double d5 = 0.1;
            final Entity field_146043_c = this.field_146043_c;
            field_146043_c.field_70159_w += d0 * d5;
            final Entity field_146043_c2 = this.field_146043_c;
            field_146043_c2.field_70181_x += d2 * d5 + MathHelper.func_76133_a(d4) * 0.08;
            final Entity field_146043_c3 = this.field_146043_c;
            field_146043_c3.field_70179_y += d3 * d5;
            b0 = 3;
        }
        else if (this.fish_on_hook > 0) {
            final EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + 1.25, this.field_70161_v, this.func_146033_f());
            final double d6 = this.field_146042_b.field_70165_t - this.field_70165_t;
            final double d7 = this.field_146042_b.field_70163_u - this.field_70163_u;
            final double d8 = this.field_146042_b.field_70161_v - this.field_70161_v;
            final double d9 = MathHelper.func_76133_a(d6 * d6 + d7 * d7 + d8 * d8);
            final double d10 = 0.1;
            entityitem.field_70159_w = d6 * d10;
            entityitem.field_70181_x = d7 * d10 + MathHelper.func_76133_a(d9) * 0.08;
            entityitem.field_70179_y = d8 * d10;
            entityitem.field_70174_ab = 3000;
            this.field_70170_p.func_72838_d((Entity)entityitem);
            this.field_146042_b.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_146042_b.field_70170_p, this.field_146042_b.field_70165_t, this.field_146042_b.field_70163_u + 0.5, this.field_146042_b.field_70161_v + 0.5, this.field_70146_Z.nextInt(6) + 1));
            b0 = 1;
        }
        if (this.field_146051_au) {
            b0 = 2;
        }
        this.func_70106_y();
        this.field_146042_b.field_71104_cf = null;
        return b0;
    }
    
    private ItemStack func_146033_f() {
        float f = this.field_70170_p.field_73012_v.nextFloat();
        final int i = EnchantmentHelper.func_151386_g((EntityLivingBase)this.field_146042_b);
        final int j = EnchantmentHelper.func_151387_h((EntityLivingBase)this.field_146042_b);
        float f2 = 0.1f - i * 0.025f - j * 0.01f;
        float f3 = 0.05f + i * 0.01f - j * 0.01f;
        f2 = MathHelper.func_76131_a(f2, 0.0f, 1.0f);
        f3 = MathHelper.func_76131_a(f3, 0.0f, 1.0f);
        final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        if (this.func_70058_J() || bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
            this.field_146042_b.func_71064_a(StatList.field_75933_B, 1);
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, (Collection)UltimateFishHook.orespawn_lava_fish)).func_150708_a(this.field_70146_Z);
        }
        if (f < f2) {
            this.field_146042_b.func_71064_a(StatList.field_151183_A, 1);
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, (Collection)UltimateFishHook.field_146039_d)).func_150708_a(this.field_70146_Z);
        }
        f -= f2;
        if (f < f3) {
            this.field_146042_b.func_71064_a(StatList.field_151184_B, 1);
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, (Collection)UltimateFishHook.field_146041_e)).func_150708_a(this.field_70146_Z);
        }
        final float f4 = this.field_70170_p.field_73012_v.nextFloat();
        this.field_146042_b.func_71064_a(StatList.field_75933_B, 1);
        if (f4 < 0.5f) {
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, (Collection)UltimateFishHook.field_146036_f)).func_150708_a(this.field_70146_Z);
        }
        return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, (Collection)UltimateFishHook.orespawn_fish)).func_150708_a(this.field_70146_Z);
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        if (this.field_146042_b != null) {
            this.field_146042_b.field_71104_cf = null;
        }
    }
    
    static {
        field_146039_d = Arrays.asList(new WeightedRandomFishable(new ItemStack((Item)Items.field_151021_T), 10).func_150709_a(0.9f), new WeightedRandomFishable(new ItemStack(Items.field_151116_aA), 10), new WeightedRandomFishable(new ItemStack(Items.field_151103_aS), 10), new WeightedRandomFishable(new ItemStack((Item)Items.field_151068_bn), 10), new WeightedRandomFishable(new ItemStack(Items.field_151007_F), 5), new WeightedRandomFishable(new ItemStack((Item)Items.field_151112_aM), 2).func_150709_a(0.9f), new WeightedRandomFishable(new ItemStack(Items.field_151054_z), 10), new WeightedRandomFishable(new ItemStack(Items.field_151055_y), 5), new WeightedRandomFishable(new ItemStack(Items.field_151100_aR, 10, 0), 1), new WeightedRandomFishable(new ItemStack((Block)Blocks.field_150479_bC), 10), new WeightedRandomFishable(new ItemStack(Items.field_151078_bh), 10));
        field_146041_e = Arrays.asList(new WeightedRandomFishable(new ItemStack(Blocks.field_150392_bi), 1), new WeightedRandomFishable(new ItemStack(Items.field_151057_cb), 1), new WeightedRandomFishable(new ItemStack(Items.field_151141_av), 1), new WeightedRandomFishable(new ItemStack((Item)Items.field_151031_f), 1).func_150709_a(0.25f).func_150707_a(), new WeightedRandomFishable(new ItemStack((Item)Items.field_151112_aM), 1).func_150709_a(0.25f).func_150707_a(), new WeightedRandomFishable(new ItemStack(Items.field_151122_aG), 1).func_150707_a());
        field_146036_f = Arrays.asList(new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.COD.func_150976_a()), 60), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.SALMON.func_150976_a()), 25), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.CLOWNFISH.func_150976_a()), 2), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.PUFFERFISH.func_150976_a()), 13));
        orespawn_lava_fish = Arrays.asList(new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunspotUrchin), 25), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyLavaEel), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunFish), 15), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySparkFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyFireFish), 15));
        orespawn_fish = Arrays.asList(new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyBlueFish), 25), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyPinkFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyRockFish), 15), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyWoodFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyGreyFish), 15));
    }
}
