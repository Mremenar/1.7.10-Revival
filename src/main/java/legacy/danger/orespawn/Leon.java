// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Vec3;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.boss.EntityDragon;
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

public class Leon extends EntityTameable
{
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
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int hurt_timer;
    private int wing_sound;
    private ChunkCoordinates currentFlightTarget;
    private boolean target_in_sight;
    private int owner_flying;
    private int flyaway;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private int unstick_timer;
    private float moveSpeed;
    private float deltasmooth;
    
    public Leon(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.hurt_timer = 0;
        this.wing_sound = 0;
        this.currentFlightTarget = null;
        this.target_in_sight = false;
        this.owner_flying = 0;
        this.flyaway = 0;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.unstick_timer = 0;
        this.moveSpeed = 0.25f;
        this.deltasmooth = 0.0f;
        this.func_70105_a(3.5f, 8.25f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 300;
        this.field_70174_ab = 10;
        this.func_70904_g(this.field_70178_ae = false);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.1f, 16.0f, 2.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151082_bd, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 9.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityLiving.class, 0, true, false, IMob.field_82192_a));
        }
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70153_n = null;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }
    
    public Leon(final World par1World, final double par2, final double par4, final double par6) {
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
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(55.0);
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
        this.field_70180_af.func_75682_a(22, (Object)0);
        this.setActivity(0);
        this.setAttacking(0);
        this.setBeingRidden(0);
        this.func_70903_f(false);
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
        return 250;
    }
    
    public int getLeonHealth() {
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
        return 16;
    }
    
    protected void func_70664_aZ() {
        super.func_70664_aZ();
        this.field_70181_x += 0.25;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return false;
    }
    
    public String func_70639_aQ() {
        if (this.func_70906_o()) {
            return null;
        }
        if (this.getActivity() == 1 && this.field_70153_n == null) {
            return "orespawn:leon_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:leon_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:leon_death";
    }
    
    protected float func_70599_aP() {
        return 1.75f;
    }
    
    public float func_70647_i() {
        return 0.85f;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public double func_70042_X() {
        return 3.75;
    }
    
    protected Item func_146068_u() {
        return Items.field_151082_bd;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.field_70163_u + 2.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 4 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.field_151076_bf, 1);
        }
        for (int i = 16 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.field_151008_G, 1);
        }
        for (int i = 2 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Item.func_150898_a(OreSpawnMain.KrakenRepellent), 1);
        }
        if (this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            this.dropItemRand(OreSpawnMain.MyBattleAxe, 1);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final double ks = 1.25;
        double inair = 0.15;
        float iskraken = 1.0f;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.func_94539_a((Explosion)null);
            var21.func_94540_d();
            if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                dr.func_70965_a(dr.field_70986_h, var21, 55.0f);
            }
            else {
                dr.func_70965_a(dr.field_70987_i, var21, 55.0f);
            }
        }
        else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof Kraken) {
                iskraken = 4.0f;
            }
            par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), iskraken * 55.0f);
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
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return ret;
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70904_g(false);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.setActivity(1);
        }
        e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof Leon) {
            return false;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        this.hurt_timer = 15;
        if (e != null && e instanceof EntityLivingBase && !this.field_70170_p.field_72995_K) {
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
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70624_b((EntityLivingBase)null);
        }
    }
    
    public void fly_with_rider() {
        EntityLivingBase e = null;
        final int freq = 7;
        if (this.field_70128_L) {
            return;
        }
        if (this.func_70906_o()) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(freq) == 1 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.setAttacking(1);
                if (this.func_70068_e((Entity)e) < (9.0f + e.field_70130_N / 2.0f) * (9.0f + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                }
                return;
            }
            this.setAttacking(0);
        }
    }
    
    protected void func_70629_bd() {
        if (this.field_70153_n != null) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        super.func_70629_bd();
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (OreSpawnMain.PlayNicely != 0) {
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Leon) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d && !this.func_70909_n();
        }
        if (!this.func_70909_n()) {
            final MyUtils oreSpawnUtils2 = OreSpawnMain.OreSpawnUtils;
            if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
                return true;
            }
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(20.0, 20.0, 20.0));
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
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Leonopteryx")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(16) != 0) {
            return false;
        }
        Leon target = null;
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        target = (Leon)this.field_70170_p.func_72857_a((Class)Leon.class, this.field_70121_D.func_72314_b(48.0, 16.0, 48.0), (Entity)this);
        return target == null && this.field_70163_u >= 50.0;
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
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 20) {
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
            if (e != null && this.func_70068_e((Entity)e) > 144.0) {
                this.setActivity(1);
            }
        }
    }
    
    private void fly_without_rider() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
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
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.func_70906_o()) {
            return;
        }
        if (this.field_70153_n != null) {
            return;
        }
        if (this.unstick_timer > 0) {
            --this.unstick_timer;
        }
        if (this.lastX == (int)this.field_70165_t && this.lastZ == (int)this.field_70161_v) {
            ++this.stuck_count;
            if (this.stuck_count > 50) {
                this.stuck_count = 0;
                this.unstick_timer = 100;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.setActivity(1);
                do_new = 1;
            }
        }
        else {
            this.stuck_count = 0;
            this.lastX = (int)this.field_70165_t;
            this.lastZ = (int)this.field_70161_v;
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
        if (this.func_70909_n() && this.func_70902_q() != null) {
            e = this.func_70902_q();
            has_owner = 1;
            ox = e.field_70165_t;
            oy = e.field_70163_u;
            oz = e.field_70161_v;
            if (this.func_70068_e((Entity)e) > 144.0) {
                toofar = 1;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.flyaway = 0;
                do_new = 1;
            }
        }
        if (this.flyaway > 0) {
            --this.flyaway;
        }
        if (toofar == 0 && this.unstick_timer == 0 && this.flyaway == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(8) == 1) {
            e = this.findSomethingToAttack();
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
                    if (this.func_70068_e((Entity)e) < (7.0f + e.field_70130_N / 2.0f) * (7.0f + e.field_70130_N / 2.0f)) {
                        this.func_70652_k((Entity)e);
                    }
                }
            }
            else {
                this.target_in_sight = false;
                this.setAttacking(this.flyaway = 0);
            }
        }
        if (this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.1f) {
            do_new = 1;
        }
        if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                int gox = (int)this.field_70165_t;
                int goy = (int)this.field_70163_u;
                int goz = (int)this.field_70161_v;
                if (has_owner == 1 && this.unstick_timer == 0) {
                    gox = (int)ox;
                    goy = (int)oy;
                    goz = (int)oz;
                    if (this.owner_flying == 0) {
                        zdir = this.field_70170_p.field_73012_v.nextInt(12) + 6;
                        xdir = this.field_70170_p.field_73012_v.nextInt(12) + 6;
                    }
                    else {
                        zdir = this.field_70170_p.field_73012_v.nextInt(8);
                        xdir = this.field_70170_p.field_73012_v.nextInt(8);
                    }
                }
                else {
                    zdir = this.field_70170_p.field_73012_v.nextInt(20) + 6;
                    xdir = this.field_70170_p.field_73012_v.nextInt(20) + 6;
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
                if (this.func_70068_e((Entity)e) > 49.0) {
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
        this.field_70177_z += var5 / 5.0f;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
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
        this.always_do();
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
            if (this.field_70153_n != null) {
                this.setBeingRidden(1);
            }
            else {
                this.setBeingRidden(0);
            }
            if (this.getActivity() != 0) {
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
                    if (this.field_70153_n != null) {
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
                    }
                    this.field_70125_A = 2.0f * (float)velocity;
                    this.func_70101_b(this.field_70177_z, this.field_70125_A);
                    this.field_70759_as = this.field_70177_z;
                    double newvelocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                    final double rr = Math.atan2(this.field_70153_n.field_70179_y, this.field_70153_n.field_70159_w);
                    final double rhm = Math.atan2(this.field_70179_y, this.field_70159_w);
                    final double rhdir = Math.toRadians((this.field_70153_n.field_70177_z + 90.0f) % 360.0f);
                    rt = 0.0;
                    pi = 3.1415926545;
                    deltav = 0.0;
                    final float im = pp.field_70701_bs;
                    if (OreSpawnMain.flyup_keystate != 0) {
                        this.field_70181_x += 0.035;
                        this.field_70181_x += velocity * 0.038;
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
                            deltav = 0.028;
                            if (max_speed > 1.0) {
                                deltav += 0.06;
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
                    this.fly_with_rider();
                    if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                        this.field_70153_n = null;
                    }
                }
                else {
                    this.fly_without_rider();
                }
            }
        }
    }
    
    public void always_do() {
        EntityLivingBase e = null;
        EntityPlayer pl = null;
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (!this.func_70906_o() && this.getActivity() == 0 && this.field_70153_n == null && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setActivity(1);
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(2.0f);
        }
        if (this.func_70906_o()) {
            return;
        }
        this.owner_flying = 0;
        if (this.func_70909_n() && this.func_70902_q() != null && this.field_70153_n == null && !this.func_70906_o()) {
            pl = (EntityPlayer)this.func_70902_q();
            if (pl.field_71075_bZ.field_75100_b) {
                this.setActivity(this.owner_flying = 1);
            }
        }
        if (this.func_70909_n() && this.func_70902_q() != null && !this.func_70906_o()) {
            pl = (EntityPlayer)this.func_70902_q();
            if (this.func_70068_e((Entity)pl) > 400.0) {
                this.setActivity(1);
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
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final float f = 0.65f;
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
        if (var2 != null && var2.func_77973_b() == Item.func_150898_a(Blocks.field_150484_ah) && par1EntityPlayer.func_70068_e((Entity)this) < 49.0) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70903_f(true);
                this.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
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
        if (!this.func_70909_n()) {
            if (var2 != null && var2.func_77973_b() == Items.field_151082_bd && par1EntityPlayer.func_70068_e((Entity)this) < 49.0) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70170_p.field_73012_v.nextInt(3) == 1) {
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
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack2 = var2;
                    --itemStack2.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
        }
        else {
            if (!this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                return false;
            }
            if (var2 == null && par1EntityPlayer.func_70068_e((Entity)this) < 49.0) {
                if (!this.field_70170_p.field_72995_K) {
                    par1EntityPlayer.func_70078_a((Entity)this);
                    this.setActivity(1);
                    this.func_70904_g(false);
                }
                return true;
            }
            if (var2 != null && var2.func_77973_b() == Items.field_151082_bd && par1EntityPlayer.func_70068_e((Entity)this) < 49.0) {
                if (this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                    this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
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
            if (var2 != null && var2.func_77973_b() == Item.func_150898_a((Block)Blocks.field_150330_I) && par1EntityPlayer.func_70068_e((Entity)this) < 49.0) {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70903_f(false);
                    this.func_152115_b("");
                    this.func_70908_e(false);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)6);
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
            if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 49.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                this.func_94058_c(var2.func_82833_r());
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack5 = var2;
                    --itemStack5.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
                return true;
            }
            if (var2 != null && par1EntityPlayer.func_70068_e((Entity)this) < 49.0 && this.field_70153_n == null) {
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
    
    public int getBeingRidden() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    public void setBeingRidden(final int par1) {
        if (this.field_70170_p != null && this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(22, (Object)par1);
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return null;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.field_70153_n == null && !this.func_70909_n();
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("LeonAttacking", this.getAttacking());
        par1NBTTagCompound.func_74768_a("LeonActivity", this.getActivity());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setAttacking(par1NBTTagCompound.func_74762_e("LeonAttacking"));
        this.setActivity(par1NBTTagCompound.func_74762_e("LeonActivity"));
    }
}
