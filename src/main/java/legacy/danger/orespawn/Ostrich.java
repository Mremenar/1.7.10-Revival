// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import java.util.List;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;

public class Ostrich extends EntityCannonFodder
{
    private float moveSpeed;
    private RenderInfo renderdata;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    float deltasmooth;
    private int didjump;
    
    public Ostrich(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.2f;
        this.renderdata = new RenderInfo();
        this.deltasmooth = 0.0f;
        this.didjump = 0;
        this.func_70105_a(0.85f, 2.1f);
        this.moveSpeed = 0.38f;
        this.field_70174_ab = 100;
        this.func_70661_as().func_75491_a(true);
        this.func_70904_g(false);
        this.field_70728_aV = 10;
        this.renderdata = new RenderInfo();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0f, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0f, 1.0, 1.899999976158142));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158, Items.field_151034_e, false));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 5.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_70904_g(false);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }
    
    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }
    
    public void setRenderInfo(final RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }
    
    @Override
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    @Override
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
    }
    
    @Override
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            super.func_70097_a(par1DamageSource, par2);
        }
        return false;
    }
    
    protected void func_70629_bd() {
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 0) {
            this.func_70691_i(1.0f);
        }
        if (this.field_70153_n != null) {
            return;
        }
        super.func_70629_bd();
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return false;
    }
    
    public int mygetMaxHealth() {
        return 25;
    }
    
    public int getOstrichHealth() {
        return (int)this.func_110143_aJ();
    }
    
    @Override
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (super.func_70085_c(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151034_e && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70909_n()) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.func_70903_f(true);
                        this.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                        this.func_70908_e(true);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                        this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
                    }
                    else {
                        this.func_70908_e(false);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                    }
                }
            }
            else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                    this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
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
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Item.func_150898_a((Block)Blocks.field_150330_I) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70903_f(false);
                this.func_152115_b("");
                this.func_70908_e(false);
                this.field_70170_p.func_72960_a((Entity)this, (byte)6);
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack2 = var2;
                --itemStack2.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (var2 != null && this.func_70909_n() && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.field_70170_p.field_72995_K) {
                if (!this.func_70906_o()) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v);
                    if (bid == Blocks.field_150354_m || bid == Blocks.field_150351_n || bid == Blocks.field_150346_d || bid == Blocks.field_150458_ak || bid == Blocks.field_150349_c) {
                        this.func_70904_g(true);
                    }
                }
                else {
                    this.func_70904_g(false);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.func_94058_c(var2.func_82833_r());
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack3 = var2;
                --itemStack3.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (var2 == null && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.field_70170_p.field_72995_K) {
                par1EntityPlayer.func_70078_a((Entity)this);
                this.func_70904_g(false);
            }
            return true;
        }
        return false;
    }
    
    protected String func_70639_aQ() {
        if (this.func_70906_o()) {
            return null;
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:cryo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:cryo_death";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151008_G;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.func_70909_n()) {
            var3 = this.field_70146_Z.nextInt(5);
            var3 += 2;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.func_145779_a(Item.func_150898_a((Block)Blocks.field_150328_O), 1);
            }
        }
        else {
            super.func_70628_a(par1, par2);
        }
    }
    
    protected float func_70647_i() {
        return this.func_70631_g_() ? ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.5f) : ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.0f);
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
    
    protected void func_70664_aZ() {
        this.field_70181_x += 0.25;
        super.func_70664_aZ();
    }
    
    public double func_70042_X() {
        return 1.4;
    }
    
    public boolean func_70601_bi() {
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70170_p.field_73012_v.nextInt(4) != 1) {
            return false;
        }
        Ostrich target = null;
        target = (Ostrich)this.field_70170_p.func_72857_a((Class)Ostrich.class, this.field_70121_D.func_72314_b(16.0, 6.0, 16.0), (Entity)this);
        return target == null;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        this.boatPosRotationIncrements = 10;
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.boatYawHead = par9;
        this.field_70159_w = this.velocityX;
        this.field_70181_x = this.velocityY;
        this.field_70179_y = this.velocityZ;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        this.field_70159_w = par1;
        this.velocityX = par1;
        this.field_70181_x = par3;
        this.velocityY = par3;
        this.field_70179_y = par5;
        this.velocityZ = par5;
    }
    
    public void func_70636_d() {
        final List list = null;
        final Entity listEntity = null;
        final double d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.75;
        final double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
        if (this.field_70153_n == null && !this.field_70170_p.field_72995_K) {
            super.func_70636_d();
            return;
        }
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70153_n == null) {
            final float var7 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
            final float var8 = MathHelper.func_76142_g(var7 - this.field_70177_z);
            this.field_70177_z += var8 / 5.0f;
        }
        if (this.field_70170_p.field_72995_K) {
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
        }
        else if (this.field_70153_n != null) {
            final EntityPlayer pp = (EntityPlayer)this.field_70153_n;
            if (this.field_70159_w < -2.0) {
                this.field_70159_w = -2.0;
            }
            if (this.field_70159_w > 2.0) {
                this.field_70159_w = 2.0;
            }
            if (this.field_70179_y < -2.0) {
                this.field_70179_y = -2.0;
            }
            if (this.field_70179_y > 2.0) {
                this.field_70179_y = 2.0;
            }
            final double velocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            obstruction_factor = 0.0;
            dist = 1 + (int)(velocity * 10.0);
            for (int k = 0; k < dist; ++k) {
                for (int i = 1; i < dist * 2; ++i) {
                    final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                    final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                    final Block bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - 1 + k, (int)(this.field_70161_v + dz));
                    if (bid != Blocks.field_150350_a) {
                        obstruction_factor += 0.075;
                    }
                }
            }
            this.field_70181_x += obstruction_factor;
            this.field_70163_u += obstruction_factor;
            if (this.field_70181_x > 4.0) {
                this.field_70181_x = 4.0;
            }
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
            this.field_70125_A = 2.0f * (float)velocity;
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            double newvelocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            final double rr = Math.atan2(this.field_70153_n.field_70179_y, this.field_70153_n.field_70159_w);
            final double rhm = Math.atan2(this.field_70179_y, this.field_70159_w);
            final double rhdir = Math.toRadians((this.field_70153_n.field_70177_z + 90.0f) % 360.0f);
            rt = 0.0;
            pi = 3.1415926545;
            deltav = 0.0;
            final float im = pp.field_70701_bs;
            if (OreSpawnMain.flyup_keystate != 0) {
                if (this.didjump == 0) {
                    ++this.field_70181_x;
                    this.field_70181_x += velocity * 6.0;
                    this.didjump = 20;
                }
            }
            else if (this.didjump > 0) {
                --this.didjump;
            }
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
                    deltav = 0.045;
                    if (this.deltasmooth < 0.0f) {
                        this.deltasmooth = 0.0f;
                    }
                    this.deltasmooth += (float)(deltav / 10.0);
                    if (this.deltasmooth > deltav) {
                        this.deltasmooth = (float)deltav;
                    }
                }
                else {
                    max_speed = 0.25;
                    deltav = -0.03;
                    if (this.deltasmooth > 0.0f) {
                        this.deltasmooth = 0.0f;
                    }
                    this.deltasmooth += (float)(deltav / 10.0);
                    if (this.deltasmooth < deltav) {
                        this.deltasmooth = (float)deltav;
                    }
                }
                newvelocity += this.deltasmooth;
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
            this.field_70181_x -= 0.25;
            this.field_70159_w *= 0.95;
            this.field_70181_x *= 0.85;
            this.field_70179_y *= 0.95;
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                this.field_70153_n = null;
            }
        }
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final float f = -0.15f;
            this.field_70153_n.func_70107_b(this.field_70165_t - f * Math.sin(Math.toRadians(this.field_70177_z)), this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + f * Math.cos(Math.toRadians(this.field_70177_z)));
        }
    }
    
    protected void func_70908_e(final boolean par1) {
        String s = "heart";
        if (!par1) {
            s = "smoke";
        }
        for (int i = 0; i < 20; ++i) {
            final double d0 = this.field_70146_Z.nextGaussian() * 0.08;
            final double d2 = this.field_70146_Z.nextGaussian() * 0.08;
            final double d3 = this.field_70146_Z.nextGaussian() * 0.08;
            this.field_70170_p.func_72869_a(s, this.field_70165_t + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 2.5f, this.field_70163_u + 0.5 + this.field_70146_Z.nextFloat() * 1.5, this.field_70161_v + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 2.5f, d0, d2, d3);
        }
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected boolean func_70692_ba() {
        if (this.func_70631_g_()) {
            this.func_110163_bv();
            return false;
        }
        return this.field_70153_n == null && !this.func_104002_bU() && !this.func_70909_n();
    }
    
    @Override
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public Ostrich spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Ostrich(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151034_e;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}
