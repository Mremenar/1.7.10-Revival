// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.item.ItemFood;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Vec3;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityTameable;

public class ThePrinceAdult extends EntityTameable
{
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private int updateit;
    private int playing;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int hurt_timer;
    private int wing_sound;
    private ChunkCoordinates currentFlightTarget;
    private boolean target_in_sight;
    private int owner_flying;
    private int flyaway;
    private float moveSpeed;
    private float deltasmooth;
    private int which_attack;
    private int fireballticker;
    private int head1ext;
    private int head2ext;
    private int head3ext;
    private int head1dir;
    private int head2dir;
    private int head3dir;
    private int growcounter;
    
    public ThePrinceAdult(final World par1World) {
        super(par1World);
        this.updateit = 1;
        this.playing = 0;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.hurt_timer = 0;
        this.wing_sound = 0;
        this.currentFlightTarget = null;
        this.target_in_sight = false;
        this.owner_flying = 0;
        this.flyaway = 0;
        this.moveSpeed = 0.36f;
        this.deltasmooth = 0.0f;
        this.which_attack = 0;
        this.fireballticker = 0;
        this.head1ext = 0;
        this.head2ext = 0;
        this.head3ext = 0;
        this.head1dir = 1;
        this.head2dir = 1;
        this.head3dir = 1;
        this.growcounter = 0;
        this.func_70105_a(6.25f, 10.25f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 3000;
        this.field_70174_ab = 1000;
        this.field_70178_ae = true;
        this.func_70904_g(false);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.1f, 12.0f, 2.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151082_bd, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 20.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityLiving.class, 0, true, false, IMob.field_82192_a));
        }
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70153_n = null;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }
    
    public ThePrinceAdult(final World par1World, final double par2, final double par4, final double par6) {
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
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(100.0);
    }
    
    public boolean shouldRiderSit() {
        return true;
    }
    
    public int getTrackingRange() {
        return 64;
    }
    
    public int getUpdateFrequency() {
        return 10;
    }
    
    public boolean sendsVelocityUpdates() {
        return true;
    }
    
    public int getHead1Ext() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    public int getHead2Ext() {
        return this.field_70180_af.func_75679_c(23);
    }
    
    public int getHead3Ext() {
        return this.field_70180_af.func_75679_c(25);
    }
    
    public void setHead1Ext(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(22, (Object)par1);
    }
    
    public void setHead2Ext(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(23, (Object)par1);
    }
    
    public void setHead3Ext(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(25, (Object)par1);
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
        this.field_70180_af.func_75682_a(24, (Object)1);
        this.field_70180_af.func_75682_a(22, (Object)0);
        this.field_70180_af.func_75682_a(23, (Object)0);
        this.field_70180_af.func_75682_a(25, (Object)0);
        this.setActivity(0);
        this.setAttacking(0);
        this.func_70903_f(false);
        this.setThePrinceAdultFire(1);
        this.field_70145_X = false;
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
        return 3000;
    }
    
    public int getThePrinceAdultHealth() {
        return (int)this.func_110143_aJ();
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
        return 20;
    }
    
    protected void func_70664_aZ() {
        super.func_70664_aZ();
        this.field_70181_x += 0.35;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    public String func_70639_aQ() {
        if (this.func_70906_o()) {
            return null;
        }
        if (this.getActivity() == 1 && this.field_70153_n == null) {
            return "orespawn:king_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:king_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:trex_death";
    }
    
    protected float func_70599_aP() {
        return 0.85f;
    }
    
    public float func_70647_i() {
        return 1.1f;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public double func_70042_X() {
        return 9.25;
    }
    
    protected Item func_146068_u() {
        return OreSpawnMain.ThePrinceEgg;
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
        this.dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final double ks = 2.0;
        double inair = 0.2;
        float iskraken = 1.0f;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof Kraken) {
                iskraken = 2.0f;
            }
            par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), iskraken * 100.0f);
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return true;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        Entity e = null;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("cactus")) {
            return ret;
        }
        if (par1DamageSource.func_76355_l().equals("inFire")) {
            return ret;
        }
        if (par1DamageSource.func_76355_l().equals("onFire")) {
            return ret;
        }
        if (par1DamageSource.func_76355_l().equals("lava")) {
            return ret;
        }
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            this.func_70904_g(false);
            this.setActivity(1);
            return ret;
        }
        this.func_70904_g(false);
        this.setActivity(1);
        e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof BetterFireball) {
            e.func_70106_y();
            return ret;
        }
        if (e != null && e instanceof EntitySmallFireball) {
            e.func_70106_y();
            return ret;
        }
        if (e != null && e instanceof ThePrinceAdult) {
            return false;
        }
        if (e != null && e instanceof Spyro) {
            return false;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        this.hurt_timer = 20;
        if (e != null && e instanceof EntityLivingBase) {
            if (this.func_70909_n() && e instanceof EntityPlayer) {
                return false;
            }
            this.func_70624_b((EntityLivingBase)e);
            this.func_70784_b(e);
            this.func_70661_as().func_75497_a((Entity)e, 1.2);
            ret = true;
        }
        return ret;
    }
    
    public void func_70619_bc() {
        EntityLivingBase e = null;
        super.func_70619_bc();
        if (!this.func_70906_o() && this.getActivity() == 0 && this.field_70153_n == null && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setActivity(1);
            }
            else {
                this.setAttacking(0);
            }
        }
        if (this.getActivity() == 0 && this.field_70153_n == null && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.func_70909_n() && OreSpawnMain.FullPowerKingEnable != 0) {
            ++this.growcounter;
            if (this.growcounter > 288000) {
                Entity ent = null;
                TheKing d = null;
                ent = spawnCreature(this.field_70170_p, "The King", this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if (ent != null) {
                    d = (TheKing)ent;
                    d.setFree();
                    this.func_70106_y();
                }
            }
        }
    }
    
    public void always_do() {
        EntityPlayer p = null;
        if (this.field_70170_p.field_73012_v.nextInt(250) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(5.0f);
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 0) {
            this.func_70624_b((EntityLivingBase)null);
        }
        if (this.func_70906_o()) {
            return;
        }
        this.owner_flying = 0;
        if (this.func_70909_n() && this.func_70902_q() != null && this.field_70153_n == null && !this.func_70906_o()) {
            p = (EntityPlayer)this.func_70902_q();
            if (p.field_71075_bZ.field_75100_b) {
                this.setActivity(this.owner_flying = 1);
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(50) == 1 && !this.func_70906_o() && !this.target_in_sight && this.field_70153_n == null) {
            if (this.field_70170_p.field_73012_v.nextInt(15) == 1) {
                this.setActivity(1);
            }
            else {
                this.setActivity(0);
            }
        }
    }
    
    public void fly_with_rider() {
        EntityLivingBase e = null;
        if (this.field_70128_L) {
            return;
        }
        if (this.func_70906_o()) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(5) == 1 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setAttacking(1);
                if (this.func_70068_e((Entity)e) < (10.0f + e.field_70130_N / 2.0f) * (10.0f + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                }
                else if (this.func_70068_e((Entity)e) < 625.0 && !this.func_70090_H() && this.getThePrinceAdultFire() != 0) {
                    this.shoot_something(e.field_70165_t, e.field_70163_u, e.field_70161_v);
                }
            }
            else {
                this.setAttacking(0);
            }
        }
    }
    
    protected void func_70629_bd() {
        if (this.field_70153_n != null) {
            return;
        }
        super.func_70629_bd();
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
        if (MyUtils.isRoyalty((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Kraken) {
            return true;
        }
        if (par1EntityLiving instanceof Leon) {
            final Leon l = (Leon)par1EntityLiving;
            return !l.func_70909_n();
        }
        if (par1EntityLiving instanceof WaterDragon) {
            final WaterDragon i = (WaterDragon)par1EntityLiving;
            return !i.func_70909_n();
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            final GammaMetroid j = (GammaMetroid)par1EntityLiving;
            return !j.func_70909_n();
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(32.0, 20.0, 32.0));
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
    
    public boolean func_145773_az() {
        return false;
    }
    
    public boolean func_70601_bi() {
        return false;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
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
        EntityLivingBase e = null;
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.getActivity() != 0) {
            this.field_70145_X = true;
        }
        else {
            this.field_70145_X = false;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                final int i = this.field_70170_p.field_73012_v.nextInt(3);
                if (i == 0) {
                    this.head1dir = 2;
                }
                if (i == 1) {
                    this.head1dir = -2;
                }
                if (i == 2) {
                    this.head1dir = 0;
                }
            }
            if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                final int i = this.field_70170_p.field_73012_v.nextInt(3);
                if (i == 0) {
                    this.head2dir = 2;
                }
                if (i == 1) {
                    this.head2dir = -2;
                }
                if (i == 2) {
                    this.head2dir = 0;
                }
            }
            if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                final int i = this.field_70170_p.field_73012_v.nextInt(3);
                if (i == 0) {
                    this.head3dir = 2;
                }
                if (i == 1) {
                    this.head3dir = -2;
                }
                if (i == 2) {
                    this.head3dir = 0;
                }
            }
            this.head1ext += this.head1dir;
            if (this.head1ext < 0) {
                this.head1ext = 0;
            }
            if (this.head1ext > 60) {
                this.head1ext = 60;
            }
            this.head2ext += this.head2dir;
            if (this.head2ext < 0) {
                this.head2ext = 0;
            }
            if (this.head2ext > 60) {
                this.head2ext = 60;
            }
            this.head3ext += this.head3dir;
            if (this.head3ext < 0) {
                this.head3ext = 0;
            }
            if (this.head3ext > 60) {
                this.head3ext = 60;
            }
            this.setHead1Ext(this.head1ext);
            this.setHead2Ext(this.head2ext);
            this.setHead3Ext(this.head3ext);
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 30) {
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72956_a((Entity)this, "orespawn:MothraWings", 0.5f, 1.0f);
                }
                this.wing_sound = 0;
            }
        }
        if (this.func_70090_H()) {
            this.field_70181_x += 0.07;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.getActivity() == 0 && this.func_70909_n() && this.func_70902_q() != null && !this.func_70906_o()) {
            e = this.func_70902_q();
            if (this.func_70068_e((Entity)e) > 900.0) {
                this.setActivity(1);
            }
        }
    }
    
    private void fly_without_rider() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 10;
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        int has_owner = 0;
        EntityLivingBase e = null;
        double speed_factor = 0.5;
        double var1 = 0.0;
        double var2 = 0.0;
        double var3 = 0.0;
        final double gh = 1.25;
        double obstruction_factor = 0.0;
        final double velocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        int toofar = 0;
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70153_n != null) {
            return;
        }
        if (this.func_70909_n() && this.func_70902_q() != null) {
            e = this.func_70902_q();
            has_owner = 1;
            ox = e.field_70165_t;
            oy = e.field_70163_u;
            oz = e.field_70161_v;
            if (this.func_70068_e((Entity)e) > 400.0) {
                toofar = 1;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.func_70904_g(false);
                this.flyaway = 0;
                do_new = 1;
            }
        }
        if (this.func_70906_o()) {
            return;
        }
        if (this.field_70163_u < this.currentFlightTarget.field_71572_b + 2.0) {
            this.field_70181_x *= 0.7;
        }
        else if (this.field_70163_u > this.currentFlightTarget.field_71572_b - 2.0) {
            this.field_70181_x *= 0.5;
        }
        else {
            this.field_70181_x *= 0.61;
        }
        if (this.field_70170_p.field_73012_v.nextInt(300) == 1) {
            do_new = 1;
        }
        if (this.flyaway > 0) {
            --this.flyaway;
        }
        if (toofar == 0 && this.flyaway == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(6) == 1) {
            e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                if (this.func_70909_n() && this.func_110143_aJ() / this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(1);
                    this.setAttacking(0);
                    this.target_in_sight = false;
                    do_new = 0;
                    this.currentFlightTarget.func_71571_b((int)(this.field_70165_t + (this.field_70165_t - e.field_70165_t)), (int)(this.field_70163_u + 1.0), (int)(this.field_70161_v + (this.field_70161_v - e.field_70161_v)));
                }
                else {
                    this.setActivity(1);
                    this.setAttacking(1);
                    this.target_in_sight = true;
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 1.0), (int)e.field_70161_v);
                    do_new = 0;
                    if (this.func_70068_e((Entity)e) < (10.0f + e.field_70130_N / 2.0f) * (10.0f + e.field_70130_N / 2.0f)) {
                        this.func_70652_k((Entity)e);
                        this.flyaway = 5 + this.field_70170_p.field_73012_v.nextInt(15);
                        do_new = 1;
                    }
                    else if (this.func_70068_e((Entity)e) < 600.0 && !this.func_70090_H() && this.getThePrinceAdultFire() != 0 && this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        this.shoot_something(e.field_70165_t, e.field_70163_u, e.field_70161_v);
                    }
                }
            }
            else {
                this.target_in_sight = false;
                this.setAttacking(this.flyaway = 0);
            }
        }
        if (this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f) {
            do_new = 1;
        }
        if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                int gox = (int)this.field_70165_t;
                int goy = (int)this.field_70163_u;
                int goz = (int)this.field_70161_v;
                if (has_owner == 1) {
                    gox = (int)ox;
                    goy = (int)oy;
                    goz = (int)oz;
                    if (this.owner_flying == 0) {
                        zdir = this.field_70170_p.field_73012_v.nextInt(16) + 8;
                        xdir = this.field_70170_p.field_73012_v.nextInt(16) + 8;
                    }
                    else {
                        zdir = this.field_70170_p.field_73012_v.nextInt(12);
                        xdir = this.field_70170_p.field_73012_v.nextInt(12);
                    }
                }
                else {
                    zdir = this.field_70170_p.field_73012_v.nextInt(15) + 20;
                    xdir = this.field_70170_p.field_73012_v.nextInt(15) + 20;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    zdir = -zdir;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b(gox + xdir, goy + this.field_70170_p.field_73012_v.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        obstruction_factor = 0.0;
        int dist = 2;
        dist += (int)(velocity * 4.0);
        for (int k = 1; k < dist; ++k) {
            for (int i = 1; i < dist * 2; ++i) {
                final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                final Block bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - k, (int)(this.field_70161_v + dz));
                if (bid != Blocks.field_150350_a) {
                    obstruction_factor += 0.05;
                }
            }
        }
        this.field_70181_x += obstruction_factor * 0.05;
        this.field_70163_u += obstruction_factor * 0.05;
        speed_factor = 0.5;
        var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.func_70909_n() && this.func_70902_q() != null) {
                e = this.func_70902_q();
                if (this.func_70068_e((Entity)e) > 64.0) {
                    speed_factor = 3.5;
                }
            }
        }
        this.field_70159_w += (Math.signum(var1) - this.field_70159_w) * 0.15 * speed_factor;
        this.field_70181_x += (Math.signum(var2) - this.field_70181_x) * 0.21 * speed_factor;
        this.field_70179_y += (Math.signum(var3) - this.field_70179_y) * 0.15 * speed_factor;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = (float)(0.75 * speed_factor);
        this.field_70177_z += var5 / 4.0f;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }
    
    public void func_70636_d() {
        List list = null;
        Entity listEntity = null;
        final double d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 1.05;
        double gh = 1.25;
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
                this.field_70759_as = this.field_70177_z;
                --this.boatPosRotationIncrements;
            }
        }
        else {
            if (this.getActivity() != 0) {
                if (this.fireballticker > 0) {
                    --this.fireballticker;
                }
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
                    gh = 1.25;
                    Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                    if (bid != Blocks.field_150350_a) {
                        this.field_70181_x += 0.03;
                        this.field_70163_u += 0.1;
                    }
                    else {
                        this.field_70181_x -= 0.018;
                    }
                    obstruction_factor = 0.0;
                    dist = 3;
                    dist += (int)(velocity * 7.0);
                    for (int k = 1; k < dist; ++k) {
                        for (int i = 1; i < dist * 2; ++i) {
                            final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                            final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                            bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - k, (int)(this.field_70161_v + dz));
                            if (bid != Blocks.field_150350_a) {
                                obstruction_factor += 0.05;
                            }
                        }
                    }
                    this.field_70181_x += obstruction_factor * 0.07;
                    this.field_70163_u += obstruction_factor * 0.07;
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
                        this.field_70181_x += 0.045;
                        this.field_70181_x += velocity * 0.066;
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
                            deltav = 0.035;
                            if (max_speed > 1.0) {
                                deltav += 0.07;
                            }
                            if (this.deltasmooth < 0.0f) {
                                this.deltasmooth = 0.0f;
                            }
                            this.deltasmooth += (float)(deltav / 10.0);
                            if (this.deltasmooth > deltav) {
                                this.deltasmooth = (float)deltav;
                            }
                        }
                        else {
                            max_speed = 0.35;
                            deltav = -0.02;
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
                    if (this.fireballticker == 0 && (pp.field_70702_br < -0.001f || pp.field_70702_br > 0.001f)) {
                        double yoff = 9.5;
                        final double xzoff = 14.5;
                        ++this.which_attack;
                        if (this.which_attack > 2) {
                            this.which_attack = 0;
                        }
                        if (this.which_attack == 0) {
                            yoff -= this.getHead1Ext() * 0.08f;
                            double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z - 10.0f));
                            double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z - 10.0f));
                            final BetterFireball bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, 0.0, 0.0, 0.0);
                            bf.setBig();
                            bf.setNotMe();
                            bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
                            cx = Math.cos(Math.toRadians(pp.field_70759_as + 90.0f));
                            cz = Math.sin(Math.toRadians(pp.field_70759_as + 90.0f));
                            final double cy = -Math.sin(Math.toRadians(pp.field_70125_A));
                            final double d12 = MathHelper.func_76133_a(cx * cx + cy * cy + cz * cz);
                            bf.field_70232_b = cx / d12 * 0.1;
                            bf.field_70233_c = cy / d12 * 0.1;
                            bf.field_70230_d = cz / d12 * 0.1;
                            bf.field_70159_w = this.field_70159_w;
                            bf.field_70181_x = this.field_70181_x;
                            bf.field_70179_y = this.field_70179_y;
                            final BetterFireball betterFireball = bf;
                            betterFireball.field_70165_t -= this.field_70159_w * 3.0;
                            final BetterFireball betterFireball2 = bf;
                            betterFireball2.field_70163_u -= this.field_70181_x * 3.0;
                            final BetterFireball betterFireball3 = bf;
                            betterFireball3.field_70161_v -= this.field_70179_y * 3.0;
                            this.field_70170_p.func_72956_a((Entity)this, "random.fuse", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                            this.field_70170_p.func_72838_d((Entity)bf);
                        }
                        if (this.which_attack == 1) {
                            yoff -= this.getHead3Ext() * 0.08f;
                            final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z + 10.0f));
                            final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z + 10.0f));
                            final IceBall var2 = new IceBall(this.field_70170_p, cx, this.field_70163_u + yoff, cz);
                            var2.func_70012_b(cx, this.field_70163_u + yoff, cz, pp.field_70177_z + 90.0f, pp.field_70125_A);
                            var2.setIceMaker(1);
                            final double var3 = Math.cos(Math.toRadians(pp.field_70177_z + 90.0f));
                            final double var4 = -Math.sin(Math.toRadians(pp.field_70125_A));
                            final double var5 = Math.sin(Math.toRadians(pp.field_70177_z + 90.0f));
                            final float var6 = MathHelper.func_76133_a(var3 * var3 + var5 * var5) * 0.2f;
                            var2.func_70186_c(var3, var4 + var6, var5, 1.4f, 5.0f);
                            final IceBall iceBall = var2;
                            iceBall.field_70165_t -= this.field_70159_w * 3.0;
                            final IceBall iceBall2 = var2;
                            iceBall2.field_70163_u -= this.field_70181_x * 3.0;
                            final IceBall iceBall3 = var2;
                            iceBall3.field_70161_v -= this.field_70179_y * 3.0;
                            final IceBall iceBall4 = var2;
                            iceBall4.field_70159_w *= 2.0;
                            final IceBall iceBall5 = var2;
                            iceBall5.field_70181_x *= 2.0;
                            final IceBall iceBall6 = var2;
                            iceBall6.field_70179_y *= 2.0;
                            this.field_70170_p.func_72956_a((Entity)this, "fireworks.launch", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                            this.field_70170_p.func_72838_d((Entity)var2);
                        }
                        if (this.which_attack == 2) {
                            yoff -= this.getHead2Ext() * 0.08f;
                            final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
                            final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
                            final ThunderBolt lb = new ThunderBolt(this.field_70170_p, (EntityLivingBase)pp);
                            lb.func_70012_b(cx, this.field_70163_u + yoff, cz, pp.field_70177_z + 90.0f, pp.field_70125_A);
                            final ThunderBolt thunderBolt = lb;
                            thunderBolt.field_70159_w *= 3.0;
                            final ThunderBolt thunderBolt2 = lb;
                            thunderBolt2.field_70181_x *= 3.0;
                            final ThunderBolt thunderBolt3 = lb;
                            thunderBolt3.field_70179_y *= 3.0;
                            this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                            this.field_70170_p.func_72838_d((Entity)lb);
                        }
                        this.fireballticker = 8;
                    }
                    this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    this.field_70159_w *= 0.985;
                    this.field_70181_x *= 0.94;
                    this.field_70179_y *= 0.985;
                    if (!this.field_70170_p.field_72995_K) {
                        list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(6.25, 10.0, 6.25));
                        if (list != null && !list.isEmpty()) {
                            for (int l = 0; l < list.size(); ++l) {
                                listEntity = list.get(l);
                                if (listEntity != this.field_70153_n && !listEntity.field_70128_L && listEntity.func_70104_M()) {
                                    listEntity.func_70108_f((Entity)this);
                                }
                            }
                        }
                    }
                    this.fly_with_rider();
                    if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                        this.field_70153_n = null;
                    }
                }
                else {
                    this.fly_without_rider();
                }
            }
            this.always_do();
        }
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final float f = 4.65f;
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
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.func_77973_b() == Item.func_150898_a(Blocks.field_150484_ah) && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
                this.growcounter = 288000;
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
        if (this.func_70909_n()) {
            if (!this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                return false;
            }
            if (var2 == null && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
                if (!this.field_70170_p.field_72995_K) {
                    par1EntityPlayer.func_70078_a((Entity)this);
                    this.setActivity(1);
                    this.func_70904_g(false);
                }
                return true;
            }
            if (var2 != null && var2.func_77973_b() == Items.field_151082_bd && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
                if (this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                    this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
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
            if (var2 != null && par1EntityPlayer.func_70068_e((Entity)this) < 36.0 && var2.func_77973_b() instanceof ItemFood) {
                if (!this.field_70170_p.field_72995_K) {
                    final ItemFood var3 = (ItemFood)var2.func_77973_b();
                    if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                        this.func_70691_i((float)(var3.func_150905_g(var2) * 10));
                    }
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack3 = var2;
                    --itemStack3.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.func_77973_b() == Item.func_150898_a(Blocks.field_150432_aD) && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                    this.setThePrinceAdultFire(0);
                    String healthMessage = new String();
                    healthMessage = String.format("Fireballs extinguished.", new Object[0]);
                    par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText(healthMessage));
                }
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack4 = var2;
                    --itemStack4.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.func_77973_b() == Items.field_151033_d && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                    this.setThePrinceAdultFire(1);
                    String healthMessage = new String();
                    healthMessage = String.format("Fireballs lit!", new Object[0]);
                    par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText(healthMessage));
                }
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack5 = var2;
                    --itemStack5.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.func_77973_b() == Items.field_151045_i && par1EntityPlayer.func_70068_e((Entity)this) < 36.0 && !this.field_70170_p.field_72995_K) {
                Entity ent = null;
                ThePrinceTeen d = null;
                ent = spawnCreature(this.field_70170_p, "The Young Prince", this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if (ent != null) {
                    d = (ThePrinceTeen)ent;
                    if (this.func_70909_n()) {
                        d.func_70903_f(true);
                        d.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                    }
                    this.func_70106_y();
                }
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack6 = var2;
                    --itemStack6.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 36.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                this.func_94058_c(var2.func_82833_r());
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack7 = var2;
                    --itemStack7.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (var2 != null && par1EntityPlayer.func_70068_e((Entity)this) < 36.0) {
                if (!this.func_70906_o()) {
                    this.func_70904_g(true);
                    this.setActivity(0);
                }
                else {
                    this.func_70904_g(false);
                    this.setActivity(0);
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151082_bd;
    }
    
    public int getAttacking() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setAttacking(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    public int getActivity() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    public void setActivity(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(21, (Object)par1);
    }
    
    public int getThePrinceAdultFire() {
        return this.field_70180_af.func_75679_c(24);
    }
    
    public void setThePrinceAdultFire(final int par1) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(24, (Object)par1);
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return null;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.field_70153_n == null && !this.func_70909_n();
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("ThePrinceAdultAttacking", this.getAttacking());
        par1NBTTagCompound.func_74768_a("ThePrinceAdultActivity", this.getActivity());
        par1NBTTagCompound.func_74768_a("ThePrinceAdultFire", this.getThePrinceAdultFire());
        par1NBTTagCompound.func_74768_a("ThePrinceAdultGrow", this.growcounter);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setAttacking(par1NBTTagCompound.func_74762_e("ThePrinceAdultAttacking"));
        this.setActivity(par1NBTTagCompound.func_74762_e("ThePrinceAdultActivity"));
        this.setThePrinceAdultFire(par1NBTTagCompound.func_74762_e("ThePrinceAdultFire"));
        this.growcounter = par1NBTTagCompound.func_74762_e("ThePrinceAdultGrow");
    }
    
    private void shoot_something(final double x, final double y, final double z) {
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        final double pi = 3.1415926545;
        final int which = this.field_70170_p.field_73012_v.nextInt(3);
        if (which == 0) {
            rr = Math.atan2(z - this.field_70161_v, x - this.field_70165_t);
            rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanon(x, y, z);
            }
        }
        else if (which == 1) {
            rr = Math.atan2(z - this.field_70161_v, x - this.field_70165_t);
            rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanonl(x, y, z);
            }
        }
        else {
            rr = Math.atan2(z - this.field_70161_v, x - this.field_70165_t);
            rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanoni(x, y, z);
            }
        }
    }
    
    private void firecanon(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        BetterFireball bf = null;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        final float r1 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r2 = 3.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r3 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, x - cx + r1, y + 0.25 - (this.field_70163_u + yoff) + r2, z - cz + r3);
        bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
        bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
        bf.setBig();
        this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d((Entity)bf);
    }
    
    private void firecanonl(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        final float r1 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r2 = 3.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r3 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final ThunderBolt lb = new ThunderBolt(this.field_70170_p, cx, this.field_70163_u + yoff, cz);
        lb.func_70012_b(cx, this.field_70163_u + yoff, cz, 0.0f, 0.0f);
        var3 = x - lb.field_70165_t;
        var4 = y + 0.25 - lb.field_70163_u;
        var5 = z - lb.field_70161_v;
        var6 = MathHelper.func_76133_a(var3 * var3 + var5 * var5) * 0.2f;
        lb.func_70186_c(var3, var4 + var6, var5, 1.4f, 4.0f);
        final ThunderBolt thunderBolt = lb;
        thunderBolt.field_70159_w *= 3.0;
        final ThunderBolt thunderBolt2 = lb;
        thunderBolt2.field_70181_x *= 3.0;
        final ThunderBolt thunderBolt3 = lb;
        thunderBolt3.field_70179_y *= 3.0;
        this.field_70170_p.func_72838_d((Entity)lb);
    }
    
    private void firecanoni(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        final float r1 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r2 = 3.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final float r3 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
        final IceBall lb = new IceBall(this.field_70170_p, cx, this.field_70163_u + yoff, cz);
        lb.setIceMaker(1);
        lb.func_70012_b(cx, this.field_70163_u + yoff, cz, 0.0f, 0.0f);
        var3 = x - lb.field_70165_t;
        var4 = y + 0.25 - lb.field_70163_u;
        var5 = z - lb.field_70161_v;
        var6 = MathHelper.func_76133_a(var3 * var3 + var5 * var5) * 0.2f;
        lb.func_70186_c(var3, var4 + var6, var5, 1.4f, 4.0f);
        final IceBall iceBall = lb;
        iceBall.field_70159_w *= 3.0;
        final IceBall iceBall2 = lb;
        iceBall2.field_70181_x *= 3.0;
        final IceBall iceBall3 = lb;
        iceBall3.field_70179_y *= 3.0;
        this.field_70170_p.func_72838_d((Entity)lb);
    }
}
