// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.EntityCreature;

public class Cephadrome extends EntityCreature
{
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private int damage_counter;
    private int updateit;
    private int color;
    private int playing;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int hurt_timer;
    private int wasfed;
    private int shouldattack;
    private int wing_sound;
    private int hit_by_player;
    private int badmood;
    private float moveSpeed;
    
    public Cephadrome(final World par1World) {
        super(par1World);
        this.damage_counter = 100;
        this.updateit = 1;
        this.color = 1;
        this.playing = 0;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.hurt_timer = 0;
        this.shouldattack = 0;
        this.wing_sound = 0;
        this.hit_by_player = 0;
        this.badmood = 0;
        this.moveSpeed = 0.25f;
        this.func_70105_a(2.5f, 2.25f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 200;
        this.field_70174_ab = 100;
        this.field_70178_ae = false;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot(this, 16, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 9.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70153_n = null;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }
    
    public Cephadrome(final World par1World, final double par2, final double par4, final double par6) {
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
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(70.0);
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
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)0);
        this.setActivity(0);
        this.setAttacking(0);
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
    
    public int mygetMaxHealth() {
        return 300;
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
    
    public int func_70658_aO() {
        return 16;
    }
    
    protected void func_70664_aZ() {
        super.func_70664_aZ();
        this.field_70181_x += 0.1;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public String func_70639_aQ() {
        if (this.getActivity() != 1 && this.field_70146_Z.nextInt(6) == 1) {
            return "orespawn:MothraWings";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:alo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    protected float func_70599_aP() {
        return 1.5f;
    }
    
    public float func_70647_i() {
        return 1.0f;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public double func_70042_X() {
        return 2.5;
    }
    
    protected Item func_146068_u() {
        return Items.field_151082_bd;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 4 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        for (int i = 4 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
        for (int i = 1 + this.field_70170_p.field_73012_v.nextInt(5), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.field_70170_p.field_73012_v.nextInt(20);
            switch (var5) {
                case 0: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    break;
                }
                case 1: {
                    final ItemStack is = this.dropItemRand(Items.field_151045_i, 1);
                    break;
                }
                case 2: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyThunderStaff, 1);
                    break;
                }
                case 3: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 4: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubyShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 5: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 6: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubyAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 7: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRubyHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 8: {
                    final ItemStack is = this.dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(2));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 9: {
                    final ItemStack is = this.dropItemRand((Item)OreSpawnMain.RubyBody, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 10: {
                    final ItemStack is = this.dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 11: {
                    final ItemStack is = this.dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17: {
                    final ItemStack is = this.dropItemRand(OreSpawnMain.MyRuby, 1);
                    break;
                }
            }
        }
    }
    
    public int getCephadromeHealth() {
        return (int)this.func_110143_aJ();
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final double ks = 2.5;
        double inair = 0.35;
        float iskraken = 1.0f;
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.func_94539_a((Explosion)null);
            var21.func_94540_d();
            if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                dr.func_70965_a(dr.field_70986_h, var21, 70.0f);
            }
            else {
                dr.func_70965_a(dr.field_70987_i, var21, 70.0f);
            }
            ret = true;
        }
        else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof Kraken) {
                iskraken = 1.5f;
            }
            ret = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), iskraken * 70.0f);
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return ret;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, par2);
            this.hurt_timer = 25;
            final Entity e = par1DamageSource.func_76346_g();
            if (e != null && e instanceof EntityLivingBase) {
                this.func_70624_b((EntityLivingBase)e);
                this.func_70784_b(e);
                this.func_70661_as().func_75497_a((Entity)e, 1.2);
                ret = true;
            }
            if (e != null && e instanceof EntityPlayer && this.func_110143_aJ() < this.func_110138_aP() * 9.0f / 10.0f) {
                this.hit_by_player = 1;
            }
        }
        return ret;
    }
    
    public double getHorizontalDistanceSqToEntity(final Entity par1Entity) {
        final double d0 = this.field_70165_t - par1Entity.field_70165_t;
        final double d2 = this.field_70161_v - par1Entity.field_70161_v;
        return d0 * d0 + d2 * d2;
    }
    
    public void func_70619_bc() {
        EntityLivingBase e = null;
        double maxdist = 10.0;
        if (this.field_70128_L) {
            return;
        }
        if (this.updateit > 0) {
            --this.updateit;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.updateit <= 0 && !this.field_70170_p.field_72995_K) {
            this.updateit = 30;
            if (this.field_70153_n != null) {
                this.setActivity(1);
            }
            else {
                this.setActivity(0);
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(2.0f);
        }
        if (this.getActivity() == 0) {
            super.func_70619_bc();
        }
        if (this.field_70170_p.field_73012_v.nextInt(7) == 1 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                if (this.getActivity() == 0) {
                    this.func_70661_as().func_75497_a((Entity)e, 1.7);
                    maxdist = 6.0;
                }
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                this.setAttacking(1);
                if (this.func_70068_e((Entity)e) < (maxdist + e.field_70130_N / 2.0f) * (maxdist + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                }
                else if (e instanceof Kraken && this.getHorizontalDistanceSqToEntity((Entity)e) < (maxdist + e.field_70130_N / 2.0f) * (maxdist + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                }
            }
            else if (this.getAttacking() != 0) {
                this.setAttacking(0);
            }
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Cephadrome) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Leon) {
            final EntityTameable et = (EntityTameable)par1EntityLiving;
            return !et.func_70909_n();
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            final EntityTameable et = (EntityTameable)par1EntityLiving;
            return !et.func_70909_n();
        }
        if (par1EntityLiving instanceof WaterDragon) {
            final EntityTameable et = (EntityTameable)par1EntityLiving;
            return !et.func_70909_n();
        }
        if (par1EntityLiving instanceof EntityDragon) {
            return true;
        }
        if (!(par1EntityLiving instanceof EntityPlayer)) {
            return false;
        }
        final EntityPlayer p = (EntityPlayer)par1EntityLiving;
        if (p.field_71075_bZ.field_75098_d) {
            return false;
        }
        if (this.hit_by_player != 0) {
            return true;
        }
        if (this.badmood != 0) {
            return true;
        }
        if (this.shouldattack > 0) {
            this.shouldattack = 0;
            return true;
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(16.0, 20.0, 16.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }
    
    public boolean func_70601_bi() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Cephadrome")) {
                            this.badmood = 1;
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 1; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        Cephadrome target = null;
        target = (Cephadrome)this.field_70170_p.func_72857_a((Class)Cephadrome.class, this.field_70121_D.func_72314_b(16.0, 6.0, 16.0), (Entity)this);
        return target == null;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        super.func_70056_a(par1, par3, par5, par7, par8, par9);
        this.boatPosRotationIncrements = par9;
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.boatYawHead = par7;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        super.func_70016_h(par1, par3, par5);
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 22) {
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72956_a((Entity)this, "orespawn:MothraWings", 0.5f, 1.0f);
                }
                this.wing_sound = 0;
            }
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.wasfed = 1;
        }
    }
    
    public void func_70636_d() {
        List list = null;
        Entity listEntity = null;
        final double d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 1.15;
        double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
        if (this.getActivity() == 0) {
            super.func_70636_d();
        }
        else if (this.field_70128_L) {
            super.func_70636_d();
            return;
        }
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.boatPosRotationIncrements > 0 && this.getActivity() != 0) {
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
        else if (this.getActivity() != 0) {
            if (this.field_70153_n != null) {
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
                gh = 1.55;
                Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a) {
                    this.field_70181_x += 0.07;
                    this.field_70163_u += 0.1;
                }
                else {
                    this.field_70181_x -= 0.018;
                }
                obstruction_factor = 0.0;
                dist = 2;
                dist += (int)(velocity * 6.0);
                for (int k = 1; k < dist; ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                        final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                        bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - k, (int)(this.field_70161_v + dz));
                        if (bid != Blocks.field_150350_a) {
                            obstruction_factor += 0.04;
                        }
                    }
                }
                this.field_70181_x += obstruction_factor * 0.09;
                this.field_70163_u += obstruction_factor * 0.09;
                if (this.field_70181_x > 2.0) {
                    this.field_70181_x = 2.0;
                }
                double d8;
                for (d8 = this.field_70153_n.field_70177_z, d8 %= 360.0; d8 < 0.0; d8 += 360.0) {}
                double d9;
                for (d9 = this.field_70177_z, d9 %= 360.0; d9 < 0.0; d9 += 360.0) {}
                for (relative_g = (d8 - d9) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                if (relative_g > 90.0) {
                    relative_g -= 180.0;
                }
                if (velocity > 0.1) {
                    d8 = 1.5 - velocity;
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
                if (this.field_70181_x > 0.0) {
                    this.field_70125_A = 360.0f - 2.0f * (float)velocity;
                }
                else {
                    this.field_70125_A = 2.0f * (float)velocity;
                }
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
                double newvelocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                final double rr = Math.atan2(this.field_70153_n.field_70179_y, this.field_70153_n.field_70159_w);
                final double rhm = Math.atan2(this.field_70179_y, this.field_70159_w);
                final double rhdir = Math.toRadians((this.field_70153_n.field_70177_z + 90.0f) % 360.0f);
                rt = 0.0;
                pi = 3.1415926545;
                deltav = 0.0;
                final double im = pp.field_70701_bs;
                if (OreSpawnMain.flyup_keystate != 0) {
                    this.field_70181_x += 0.04;
                    this.field_70181_x += velocity * 0.05;
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
                if (Math.abs(im) > 0.0010000000474974513) {
                    if (im > 0.0) {
                        deltav = 0.03;
                        if (max_speed > 0.85) {
                            deltav += 0.05;
                        }
                    }
                    else {
                        max_speed = 0.35;
                        deltav = -0.03;
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
            }
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.985;
            this.field_70181_x *= 0.94;
            this.field_70179_y *= 0.985;
            if (!this.field_70170_p.field_72995_K) {
                list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(2.25, 2.0, 2.25));
                if (list != null && !list.isEmpty()) {
                    for (int l = 0; l < list.size(); ++l) {
                        listEntity = list.get(l);
                        if (listEntity != this.field_70153_n && !listEntity.field_70128_L && listEntity.func_70104_M()) {
                            listEntity.func_70108_f((Entity)this);
                        }
                    }
                }
            }
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                this.field_70153_n = null;
            }
        }
        if (this.getActivity() == 1) {
            this.func_70619_bc();
        }
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final float f = 0.75f;
            this.field_70153_n.func_70107_b(this.field_70165_t - f * Math.sin(Math.toRadians(this.field_70177_z)), this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + f * Math.cos(Math.toRadians(this.field_70177_z)));
        }
    }
    
    protected void playTameEffect(final boolean par1) {
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
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && (var2.func_77973_b() == Items.field_151082_bd || var2.func_77973_b() == Items.field_151076_bf || var2.func_77973_b() == Items.field_151147_al) && par1EntityPlayer.func_70068_e((Entity)this) < 25.0) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
            }
            this.wasfed = 1;
            this.shouldattack = 0;
            this.playTameEffect(true);
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = var2;
                --itemStack.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    var2 = null;
                }
            }
            return false;
        }
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer) {
            return true;
        }
        if (var2 == null && par1EntityPlayer.func_70068_e((Entity)this) < 25.0 && !this.field_70170_p.field_72995_K) {
            if (this.wasfed == 0) {
                this.func_70661_as().func_75497_a((Entity)par1EntityPlayer, 1.2);
                this.shouldattack = 1;
                return false;
            }
            par1EntityPlayer.func_70078_a((Entity)this);
            this.wasfed = 0;
        }
        return true;
    }
    
    public int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public void setAttacking(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    public int getActivity() {
        return this.field_70180_af.func_75683_a(21);
    }
    
    public void setActivity(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(21, (Object)(byte)par1);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.field_70153_n == null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("CephaWasFed", this.wasfed);
        par1NBTTagCompound.func_74768_a("CephaAttacking", this.getAttacking());
        par1NBTTagCompound.func_74768_a("CephaActivity", this.getActivity());
        par1NBTTagCompound.func_74768_a("CephaHitByPlayer", this.hit_by_player);
        par1NBTTagCompound.func_74768_a("CephaBadMood", this.badmood);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.wasfed = par1NBTTagCompound.func_74762_e("CephaWasFed");
        this.hit_by_player = par1NBTTagCompound.func_74762_e("CephaHitByPlayer");
        this.badmood = par1NBTTagCompound.func_74762_e("CephaBadMood");
        this.setAttacking(par1NBTTagCompound.func_74762_e("CephaAttacking"));
        this.setActivity(par1NBTTagCompound.func_74762_e("CephaActivity"));
    }
}
