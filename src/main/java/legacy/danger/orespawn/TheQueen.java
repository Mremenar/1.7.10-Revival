// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.effect.EntityLightningBolt;
import java.util.Iterator;
import net.minecraft.util.MathHelper;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.DamageSource;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Vec3;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class TheQueen extends EntityMob
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private EntityLivingBase rt;
    private double attdam;
    private int hurt_timer;
    private int homex;
    private int homez;
    private int stream_count;
    private int stream_count_l;
    private int ticker;
    private int player_hit_count;
    private int backoff_timer;
    private int guard_mode;
    private volatile int head_found;
    private int wing_sound;
    private int attack_level;
    private EntityLivingBase ev;
    private float evh;
    private int mood;
    private int always_mad;
    
    public TheQueen(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.rt = null;
        this.attdam = 250.0;
        this.hurt_timer = 0;
        this.homex = 0;
        this.homez = 0;
        this.stream_count = 0;
        this.stream_count_l = 0;
        this.ticker = 0;
        this.player_hit_count = 0;
        this.backoff_timer = 0;
        this.guard_mode = 0;
        this.head_found = 0;
        this.wing_sound = 0;
        this.attack_level = 1;
        this.ev = null;
        this.evh = 0.0f;
        this.mood = 0;
        this.always_mad = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.func_70105_a(22.0f, 24.0f);
        }
        else {
            this.func_70105_a(5.5f, 6.0f);
        }
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 25000;
        this.field_70178_ae = true;
        this.field_70174_ab = 5000;
        this.field_70145_X = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70155_l = 12.0;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6200000047683716);
        this.attdam = OreSpawnMain.TheQueen_stats.attack;
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(this.attdam);
    }
    
    protected void func_70088_a() {
        final int i = 0;
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)i);
        this.field_70180_af.func_75682_a(21, (Object)OreSpawnMain.PlayNicely);
        this.field_70180_af.func_75682_a(22, (Object)this.mood);
        this.field_70180_af.func_75682_a(23, (Object)this.attack_level);
    }
    
    public int getPlayNicely() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    public int getIsHappy() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_70112_a(final double par1) {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderVec3D(final Vec3 par1Vec3) {
        return true;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public int getAttacking() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    public int getPower() {
        return this.field_70180_af.func_75679_c(23);
    }
    
    public void setPower(final int par1) {
        this.field_70180_af.func_75692_b(23, (Object)par1);
    }
    
    protected float func_70599_aP() {
        return 1.35f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:king_living";
    }
    
    protected String func_70621_aR() {
        return "orespawn:king_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:trex_death";
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.TheQueen_stats.health;
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a((Block)Blocks.field_150327_N);
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), this.field_70163_u + 12.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.MyRoyal, 1);
        this.dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
        spawnCreature(this.field_70170_p, "The Princess", this.field_70165_t, this.field_70163_u + 10.0, this.field_70161_v);
        for (int i = 0; i < 56; ++i) {
            this.dropItemRand(OreSpawnMain.MyQueenScale, 1);
            this.dropItemRand(Items.field_151082_bd, 1);
            this.dropItemRand(Items.field_151103_aS, 1);
            this.dropItemRand(Items.field_151078_bh, 1);
        }
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public boolean isHappy() {
        return this.getIsHappy() == 0;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72956_a((Entity)this, "orespawn:MothraWings", 1.75f, 0.75f);
            }
            this.wing_sound = 0;
        }
        this.field_70145_X = true;
        this.field_70181_x *= 0.6;
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() * 3 / 4) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 20;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 2) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 100;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 3) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 500;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 4) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 1000;
        }
        if (this.field_70170_p.field_72995_K && this.getPower() > 800) {
            final float f = 7.0f;
            if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                for (int i = 0; i < 10; ++i) {
                    this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t - f * Math.sin(Math.toRadians(this.field_70177_z)), this.field_70163_u + 14.0, this.field_70161_v + f * Math.cos(Math.toRadians(this.field_70177_z)), (this.field_70170_p.field_73012_v.nextGaussian() - this.field_70170_p.field_73012_v.nextGaussian()) / 5.0 + this.field_70159_w * 3.0, (this.field_70170_p.field_73012_v.nextGaussian() - this.field_70170_p.field_73012_v.nextGaussian()) / 5.0, (this.field_70170_p.field_73012_v.nextGaussian() - this.field_70170_p.field_73012_v.nextGaussian()) / 5.0 + this.field_70179_y * 3.0);
                }
            }
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase && !this.field_70170_p.field_72995_K) {
            final EntityLivingBase e = (EntityLivingBase)par1Entity;
            if (!e.field_70128_L) {
                if (this.ev == e) {
                    if (this.evh < e.func_110143_aJ()) {
                        e.func_70606_j(this.evh);
                    }
                }
                else {
                    this.ev = e;
                }
                if (e.field_70130_N * e.field_70131_O > 30.0f) {
                    e.func_70606_j(e.func_110143_aJ() * 3.0f / 4.0f);
                    e.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (float)this.attdam);
                }
                this.evh = e.func_110143_aJ();
                if (this.evh <= 0.0f) {
                    this.ev.func_70106_y();
                }
            }
            else {
                this.ev = null;
                this.evh = 0.0f;
            }
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.func_94539_a((Explosion)null);
            var21.func_94540_d();
            if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                dr.func_70965_a(dr.field_70986_h, var21, (float)this.attdam);
            }
            else {
                dr.func_70965_a(dr.field_70987_i, var21, (float)this.attdam);
            }
        }
        final boolean var22 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (float)this.attdam);
        if (var22) {
            final double ks = 2.75;
            double inair = 0.2;
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            inair += this.field_70170_p.field_73012_v.nextFloat() * 0.25f;
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 1.5;
            }
            par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var22;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 8.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    private boolean tooFarFromHome() {
        float d1 = (float)(this.field_70165_t - this.homex);
        final float d2 = (float)(this.field_70161_v - this.homez);
        d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
        return d1 > 120.0f;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int attrand = 5;
        final int updown = 0;
        int which = 0;
        EntityLivingBase e = null;
        EntityLivingBase f = null;
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        final double pi = 3.1415926545;
        double var1 = 0.0;
        double var2 = 0.0;
        double var3 = 0.0;
        float var4 = 0.0f;
        float var5 = 0.0f;
        EntityLiving newent = null;
        final double xzoff = 8.0;
        final double yoff = 14.0;
        List kinglist = null;
        Iterator var6 = null;
        TheKing var7 = null;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.ev != null) {
            if (this.func_70068_e((Entity)this.ev) < 2000.0 && !this.ev.field_70128_L) {
                if (this.evh < this.ev.func_110143_aJ()) {
                    this.ev.func_70606_j(this.evh);
                }
                else {
                    this.evh = this.ev.func_110143_aJ();
                }
                if (this.evh <= 0.0f) {
                    this.ev.func_70106_y();
                }
            }
            else {
                this.ev = null;
                this.evh = 0.0f;
            }
        }
        if (this.attack_level > 1000) {
            if (this.mood == 1) {
                int j = 15;
                if (this.player_hit_count < 10) {
                    j = 45;
                }
                for (int i = 0; i < j; ++i) {
                    final Entity ppwr = spawnCreature(this.field_70170_p, "PurplePower", this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z)), this.field_70163_u + yoff, this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z)));
                    if (ppwr != null) {
                        ppwr.field_70159_w = this.field_70159_w * 3.0;
                        ppwr.field_70179_y = this.field_70179_y * 3.0;
                    }
                }
            }
            else {
                if (this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                    for (int m = 0; m < 25; ++m) {
                        final int i = this.field_70170_p.field_73012_v.nextInt(25) - this.field_70170_p.field_73012_v.nextInt(25);
                        final int k = this.field_70170_p.field_73012_v.nextInt(25) - this.field_70170_p.field_73012_v.nextInt(25);
                        int j = -20;
                        while (j < 20) {
                            final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k);
                            if (bid == Blocks.field_150349_c) {
                                if (this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) != Blocks.field_150350_a) {
                                    break;
                                }
                                which = this.field_70170_p.field_73012_v.nextInt(8);
                                if (which == 0) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, (Block)Blocks.field_150328_O);
                                }
                                if (which == 1) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, (Block)Blocks.field_150327_N);
                                }
                                if (which == 2) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.MyFlowerBlueBlock);
                                }
                                if (which == 3) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.MyFlowerPinkBlock);
                                }
                                if (which == 4) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.CrystalFlowerRedBlock);
                                }
                                if (which == 5) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.CrystalFlowerGreenBlock);
                                }
                                if (which == 6) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.CrystalFlowerBlueBlock);
                                }
                                if (which == 7) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, OreSpawnMain.CrystalFlowerYellowBlock);
                                    break;
                                }
                                break;
                            }
                            else {
                                if (bid == Blocks.field_150346_d && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, (Block)Blocks.field_150349_c);
                                    break;
                                }
                                if (bid == Blocks.field_150348_b && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a) {
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, Blocks.field_150346_d);
                                    break;
                                }
                                if (bid == Blocks.field_150354_m && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a) {
                                    if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                                        this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k, Blocks.field_150434_aF);
                                        break;
                                    }
                                    this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, Blocks.field_150346_d);
                                    break;
                                }
                                else {
                                    if (bid == Blocks.field_150353_l && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a) {
                                        this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, Blocks.field_150355_j);
                                        break;
                                    }
                                    if (bid == Blocks.field_150356_k && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a) {
                                        this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, (Block)Blocks.field_150358_i);
                                        break;
                                    }
                                    if (bid == Blocks.field_150350_a && j > 0) {
                                        break;
                                    }
                                    ++j;
                                }
                            }
                        }
                    }
                }
                for (int m = 0; m < 10; ++m) {
                    final int i = this.field_70170_p.field_73012_v.nextInt(15) - this.field_70170_p.field_73012_v.nextInt(15);
                    final int k = this.field_70170_p.field_73012_v.nextInt(15) - this.field_70170_p.field_73012_v.nextInt(15);
                    final int j = this.field_70170_p.field_73012_v.nextInt(20);
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150350_a) {
                        if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                            newent = (EntityLiving)spawnCreature(this.field_70170_p, "Butterfly", this.field_70165_t + i, this.field_70163_u + j, this.field_70161_v + k);
                        }
                        else {
                            newent = (EntityLiving)spawnCreature(this.field_70170_p, "Bird", this.field_70165_t + i, this.field_70163_u + j, this.field_70161_v + k);
                        }
                    }
                }
            }
            this.attack_level = 1;
        }
        if (this.attack_level > 1) {
            --this.attack_level;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if ((this.homex == 0 && this.homez == 0) || this.guard_mode == 0) {
            this.homex = (int)this.field_70165_t;
            this.homez = (int)this.field_70161_v;
        }
        if (this.func_110143_aJ() > this.mygetMaxHealth() - 2 && this.field_70170_p.field_73012_v.nextInt(500) == 1) {
            this.mood = 0;
        }
        if (this.always_mad != 0) {
            this.mood = 1;
        }
        if (this.mood == 0) {
            this.attack_level += 10;
        }
        ++this.ticker;
        if (this.ticker > 30000) {
            this.ticker = 0;
        }
        if (this.ticker % 60 == 0) {
            this.stream_count = 10;
        }
        if (this.ticker % 70 == 0) {
            this.stream_count_l = 6;
        }
        if (this.ticker % 10 == 0) {
            this.field_70180_af.func_75692_b(21, (Object)OreSpawnMain.PlayNicely);
            this.field_70180_af.func_75692_b(22, (Object)this.mood);
            this.setPower(this.attack_level);
        }
        if (this.backoff_timer > 0) {
            --this.backoff_timer;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 2) {
            attrand = 3;
        }
        this.field_70145_X = true;
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.tooFarFromHome() || this.field_70170_p.field_73012_v.nextInt(200) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 9.1f) {
            zdir = this.field_70170_p.field_73012_v.nextInt(120);
            xdir = this.field_70170_p.field_73012_v.nextInt(120);
            if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                zdir = -zdir;
            }
            if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                xdir = -xdir;
            }
            int dist = 0;
            for (int i = -5; i <= 5; i += 5) {
                for (int j = -5; j <= 5; j += 5) {
                    Block bid = this.field_70170_p.func_147439_a(this.homex + j, (int)this.field_70163_u, this.homez + i);
                    if (bid != Blocks.field_150350_a) {
                        for (int k = 1; k < 20; ++k) {
                            bid = this.field_70170_p.func_147439_a(this.homex + j, (int)this.field_70163_u + k, this.homez + i);
                            ++dist;
                            if (bid == Blocks.field_150350_a) {
                                break;
                            }
                        }
                    }
                    else {
                        for (int k = 1; k < 20; ++k) {
                            bid = this.field_70170_p.func_147439_a(this.homex + j, (int)this.field_70163_u - k, this.homez + i);
                            --dist;
                            if (bid != Blocks.field_150350_a) {
                                break;
                            }
                        }
                    }
                }
            }
            dist = dist / 9 + 2;
            if ((int)(this.field_70163_u + dist) > 230) {
                dist = 230 - (int)this.field_70163_u;
            }
            this.currentFlightTarget.func_71571_b(this.homex + xdir, (int)(this.field_70163_u + dist), this.homez + zdir);
            if (this.mood == 0) {
                kinglist = this.field_70170_p.func_72872_a((Class)TheKing.class, this.field_70121_D.func_72314_b(64.0, 32.0, 64.0));
                if (kinglist != null) {
                    Collections.sort((List<Object>)kinglist, this.TargetSorter);
                    var6 = kinglist.iterator();
                    if (var6.hasNext()) {
                        var7 = null;
                        var7 = var6.next();
                        this.guard_mode = 0;
                        zdir = this.field_70170_p.field_73012_v.nextInt(16);
                        xdir = this.field_70170_p.field_73012_v.nextInt(16);
                        if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                            zdir = -zdir;
                        }
                        if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                            xdir = -xdir;
                        }
                        this.currentFlightTarget.func_71571_b((int)var7.field_70165_t + xdir, (int)(var7.field_70163_u + (this.field_70170_p.field_73012_v.nextInt(8) - this.field_70170_p.field_73012_v.nextInt(8))), (int)var7.field_70161_v + zdir);
                    }
                }
            }
        }
        else if (this.field_70170_p.field_73012_v.nextInt(attrand) == 0) {
            e = this.rt;
            if (OreSpawnMain.PlayNicely != 0 || this.isHappy()) {
                e = null;
            }
            if (e != null && (e instanceof TheQueen || e instanceof QueenHead)) {
                this.rt = null;
                e = null;
            }
            if (e != null) {
                float d1 = (float)(e.field_70165_t - this.homex);
                final float d2 = (float)(e.field_70161_v - this.homez);
                d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
                if (e.field_70128_L || this.field_70170_p.field_73012_v.nextInt(450) == 1 || (d1 > 128.0f && this.guard_mode == 1)) {
                    e = null;
                    this.rt = null;
                }
                if (e != null && !this.MyCanSee(e)) {
                    e = null;
                }
            }
            f = this.findSomethingToAttack();
            if (this.head_found == 0 && this.mood == 1) {
                newent = (EntityLiving)spawnCreature(this.field_70170_p, "QueenHead", this.field_70165_t, this.field_70163_u + 20.0, this.field_70161_v);
            }
            if (e == null) {
                e = f;
            }
            if (e != null) {
                final float d1 = e.field_70130_N * e.field_70131_O;
                if (this.attack_level < 1000) {
                    this.attack_level += 15;
                    if (this.func_110143_aJ() < this.mygetMaxHealth() / 2) {
                        this.attack_level += 15;
                    }
                    if (d1 > 50.0f) {
                        this.attack_level += 15;
                    }
                    if (d1 > 100.0f) {
                        this.attack_level += 15;
                    }
                    if (d1 > 200.0f) {
                        this.attack_level += 25;
                    }
                }
                this.setAttacking(1);
                if (this.backoff_timer == 0) {
                    int dist = (int)(e.field_70163_u + e.field_70131_O / 2.0f + 1.0);
                    if (dist > 230) {
                        dist = 230;
                    }
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t, dist, (int)e.field_70161_v);
                    if (this.field_70170_p.field_73012_v.nextInt(50) == 1) {
                        this.backoff_timer = 90 + this.field_70170_p.field_73012_v.nextInt(90);
                    }
                }
                else if (this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 9.1f) {
                    zdir = this.field_70170_p.field_73012_v.nextInt(20) + 30;
                    xdir = this.field_70170_p.field_73012_v.nextInt(20) + 30;
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                        zdir = -zdir;
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                        xdir = -xdir;
                    }
                    int dist = 0;
                    for (int i = -5; i <= 5; i += 5) {
                        for (int j = -5; j <= 5; j += 5) {
                            Block bid = this.field_70170_p.func_147439_a((int)e.field_70165_t + j, (int)this.field_70163_u, (int)e.field_70161_v + i);
                            if (bid != Blocks.field_150350_a) {
                                for (int k = 1; k < 20; ++k) {
                                    bid = this.field_70170_p.func_147439_a((int)e.field_70165_t + j, (int)this.field_70163_u + k, (int)e.field_70161_v + i);
                                    ++dist;
                                    if (bid == Blocks.field_150350_a) {
                                        break;
                                    }
                                }
                            }
                            else {
                                for (int k = 1; k < 20; ++k) {
                                    bid = this.field_70170_p.func_147439_a((int)e.field_70165_t + j, (int)this.field_70163_u - k, (int)e.field_70161_v + i);
                                    --dist;
                                    if (bid != Blocks.field_150350_a) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    dist = dist / 9 + 2;
                    if ((int)(this.field_70163_u + dist) > 230) {
                        dist = 230 - (int)this.field_70163_u;
                    }
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t + xdir, (int)(this.field_70163_u + dist), (int)e.field_70161_v + zdir);
                }
                if (this.func_70068_e((Entity)e) < 900.0) {
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, 15.0, OreSpawnMain.TheQueen_stats.attack / 4, 0);
                    }
                    this.func_70652_k((Entity)e);
                }
                final double dx = this.field_70165_t + 20.0 * Math.sin(Math.toRadians(this.field_70177_z));
                final double dz = this.field_70161_v - 20.0 * Math.cos(Math.toRadians(this.field_70177_z));
                if (this.field_70170_p.field_73012_v.nextInt(3) == 1) {
                    this.doJumpDamage(dx, this.field_70163_u + 10.0, dz, 15.0, OreSpawnMain.TheQueen_stats.attack / 2, 1);
                }
                if (this.getHorizontalDistanceSqToEntity((Entity)e) > 900.0) {
                    which = this.field_70170_p.field_73012_v.nextInt(2);
                    if (which == 0) {
                        if (this.stream_count > 0) {
                            this.setAttacking(1);
                            rr = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
                            rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5) {
                                this.firecanon(e);
                            }
                        }
                    }
                    else if (this.stream_count_l > 0) {
                        this.setAttacking(1);
                        rr = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
                        rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
                        rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        rdd = Math.abs(rdd);
                        if (rdd < 0.5) {
                            this.firecanonl(e);
                        }
                    }
                }
            }
            else {
                this.setAttacking(0);
                this.stream_count = 10;
                this.stream_count_l = 6;
            }
        }
        var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.65 - this.field_70159_w) * 0.35;
        this.field_70181_x += (Math.signum(var2) * 0.69999 - this.field_70181_x) * 0.3;
        this.field_70179_y += (Math.signum(var3) * 0.65 - this.field_70179_y) * 0.35;
        var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.75f;
        this.field_70177_z += var5 / 8.0f;
        if (this.field_70170_p.field_73012_v.nextInt(32) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(5.0f);
            if (this.player_hit_count < 10) {
                this.func_70691_i(50.0f);
            }
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < 2000.0f) {
            this.func_70691_i(2000.0f - this.func_110143_aJ());
        }
    }
    
    private double getHorizontalDistanceSqToEntity(final Entity e) {
        final double d1 = e.field_70161_v - this.field_70161_v;
        final double d2 = e.field_70165_t - this.field_70165_t;
        return d1 * d1 + d2 * d2;
    }
    
    private void firecanon(final EntityLivingBase e) {
        final double yoff = 14.0;
        final double xzoff = 32.0;
        BetterFireball bf = null;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        if (this.stream_count > 0) {
            bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - cx, e.field_70163_u + e.field_70131_O / 2.0f - (this.field_70163_u + yoff), e.field_70161_v - cz);
            bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
            bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
            bf.setReallyBig();
            this.field_70170_p.func_72956_a((Entity)this, "random.fuse", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)bf);
            for (int i = 0; i < 6; ++i) {
                final float r1 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                final float r2 = 3.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                final float r3 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - cx + r1, e.field_70163_u + e.field_70131_O / 2.0f - (this.field_70163_u + yoff) + r2, e.field_70161_v - cz + r3);
                bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
                bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
                bf.setBig();
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    bf.setSmall();
                }
                this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)bf);
            }
            --this.stream_count;
        }
    }
    
    private void firecanonl(final EntityLivingBase e) {
        final double yoff = 14.0;
        final double xzoff = 32.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        if (this.stream_count_l > 0) {
            this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 3; ++i) {
                final ThunderBolt lb = new ThunderBolt(this.field_70170_p, cx, this.field_70163_u + yoff, cz);
                lb.func_70012_b(cx, this.field_70163_u + yoff, cz, 0.0f, 0.0f);
                var3 = e.field_70165_t - lb.field_70165_t;
                var4 = e.field_70163_u + 0.25 - lb.field_70163_u;
                var5 = e.field_70161_v - lb.field_70161_v;
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
            --this.stream_count_l;
        }
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return false;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float dm = par2;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (dm > 750.0f) {
            dm = 750.0f;
        }
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return false;
        }
        this.mood = 1;
        if (par1DamageSource.func_94541_c()) {
            float s = this.func_110143_aJ();
            s += par2 / 2.0f;
            if (s > this.func_110138_aP()) {
                s = this.func_110138_aP();
            }
            this.func_70606_j(s);
            return false;
        }
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityLivingBase) {
            if (e instanceof PurplePower) {
                return false;
            }
            final float s = e.field_70131_O * e.field_70130_N;
            if (e instanceof EntityMob && s < 3.0f) {
                e.func_70106_y();
                return false;
            }
        }
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            this.hurt_timer = 20;
            ret = super.func_70097_a(par1DamageSource, dm);
            if (e != null && e instanceof EntityPlayer) {
                ++this.player_hit_count;
            }
            if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null && !MyUtils.isRoyalty(e)) {
                this.rt = (EntityLivingBase)e;
                int dist = (int)e.field_70163_u;
                if (dist > 230) {
                    dist = 230;
                }
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, dist, (int)e.field_70161_v);
            }
        }
        return ret;
    }
    
    public boolean func_70601_bi() {
        return true;
    }
    
    public int func_70658_aO() {
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() * 2 / 3) {
            return OreSpawnMain.TheQueen_stats.defense + 2;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 2) {
            return OreSpawnMain.TheQueen_stats.defense + 3;
        }
        if (this.player_hit_count < 10 && this.func_110143_aJ() < this.mygetMaxHealth() / 3) {
            return OreSpawnMain.TheQueen_stats.defense + 5;
        }
        return OreSpawnMain.TheQueen_stats.defense;
    }
    
    public void func_70077_a(final EntityLightningBolt par1EntityLightningBolt) {
    }
    
    public void initCreature() {
    }
    
    public boolean MyCanSee(final EntityLivingBase e) {
        final double xzoff = 10.0;
        int nblks = 20;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        float startx = (float)cx;
        float starty = (float)(this.field_70163_u + 14.0);
        float startz = (float)cz;
        float dx = (float)((e.field_70165_t - startx) / 20.0);
        float dy = (float)((e.field_70163_u + e.field_70131_O / 2.0f - starty) / 20.0);
        float dz = (float)((e.field_70161_v - startz) / 20.0);
        if (Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks *= (int)Math.abs(dx);
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if (Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks *= (int)Math.abs(dy);
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if (Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks *= (int)Math.abs(dz);
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            startx += dx;
            starty += dy;
            startz += dz;
            final Block bid = this.field_70170_p.func_147439_a((int)startx, (int)starty, (int)startz);
            if (bid != Blocks.field_150350_a) {
                return false;
            }
        }
        return true;
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
        if (par1EntityLiving instanceof QueenHead) {
            this.head_found = 1;
            return false;
        }
        if (MyUtils.isRoyalty((Entity)par1EntityLiving)) {
            return false;
        }
        float d1 = (float)(par1EntityLiving.field_70165_t - this.homex);
        final float d2 = (float)(par1EntityLiving.field_70161_v - this.homez);
        d1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
        if (d1 > 144.0f) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        if (par1EntityLiving instanceof EntityHorse) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityDragon) {
            return true;
        }
        final MyUtils oreSpawnUtils2 = OreSpawnMain.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0 || this.isHappy()) {
            this.head_found = 1;
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(80.0, 60.0, 80.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        EntityLivingBase ret = null;
        this.head_found = 0;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false) && ret == null) {
                ret = var8;
            }
            if (ret != null && this.head_found != 0) {
                break;
            }
        }
        return ret;
    }
    
    public void setGuardMode(final int i) {
        this.guard_mode = i;
    }
    
    public void setBadMood(final int i) {
        this.always_mad = i;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("KingHomeX", this.homex);
        par1NBTTagCompound.func_74768_a("KingHomeZ", this.homez);
        par1NBTTagCompound.func_74768_a("GuardMode", this.guard_mode);
        par1NBTTagCompound.func_74768_a("PlayerHits", this.player_hit_count);
        par1NBTTagCompound.func_74768_a("MeanMode", this.always_mad);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.homex = par1NBTTagCompound.func_74762_e("KingHomeX");
        this.homez = par1NBTTagCompound.func_74762_e("KingHomeZ");
        this.guard_mode = par1NBTTagCompound.func_74762_e("GuardMode");
        this.player_hit_count = par1NBTTagCompound.func_74762_e("PlayerHits");
        this.always_mad = par1NBTTagCompound.func_74762_e("MeanMode");
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
        }
        return var8;
    }
    
    private EntityLivingBase doJumpDamage(final double X, final double Y, final double Z, final double dist, final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB.func_72330_a(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, bb);
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (var8 == null) {
                continue;
            }
            if (var8 == this) {
                continue;
            }
            if (!var8.func_70089_S()) {
                continue;
            }
            if (MyUtils.isRoyalty((Entity)var8)) {
                continue;
            }
            if (var8 instanceof Ghost) {
                continue;
            }
            if (var8 instanceof GhostSkelly) {
                continue;
            }
            DamageSource var9 = null;
            var9 = DamageSource.func_94539_a((Explosion)null);
            var9.func_94540_d();
            var8.func_70097_a(var9, (float)damage / 2.0f);
            var8.func_70097_a(DamageSource.field_76379_h, (float)damage / 2.0f);
            this.field_70170_p.func_72956_a((Entity)var8, "random.explode", 0.65f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
            if (knock == 0) {
                continue;
            }
            final double ks = 2.75;
            final double inair = 0.65;
            final float f3 = (float)Math.atan2(var8.field_70161_v - this.field_70161_v, var8.field_70165_t - this.field_70165_t);
            var8.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return null;
    }
}
