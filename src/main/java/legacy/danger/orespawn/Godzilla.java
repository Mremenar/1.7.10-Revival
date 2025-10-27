// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import java.util.Iterator;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.EntityList;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class Godzilla extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int hurt_timer;
    private int jumped;
    private int jump_timer;
    private int ticker;
    private RenderInfo renderdata;
    private int stream_count;
    private MyEntityAIWanderALot wander;
    private int head_found;
    private int large_unknown_detected;
    
    public Godzilla(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.75f;
        this.hurt_timer = 0;
        this.jumped = 0;
        this.jump_timer = 0;
        this.ticker = 0;
        this.renderdata = new RenderInfo();
        this.stream_count = 8;
        this.wander = null;
        this.head_found = 0;
        this.large_unknown_detected = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.func_70105_a(9.9f, 25.0f);
        }
        else {
            this.func_70105_a(2.475f, 6.25f);
        }
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 10000;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.wander = new MyEntityAIWanderALot((EntityCreature)this, 15, 1.0);
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.wander);
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 50.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70174_ab = 10000;
        this.field_70178_ae = true;
        this.field_70155_l = 12.0;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Godzilla_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)OreSpawnMain.PlayNicely);
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
    
    public int getPlayNicely() {
        return this.field_70180_af.func_75679_c(21);
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
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && OreSpawnMain.PlayNicely != 0;
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Godzilla_stats.health;
    }
    
    public int func_70658_aO() {
        if (this.large_unknown_detected != 0) {
            return 25;
        }
        return OreSpawnMain.Godzilla_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        final double xzoff = 0.0;
        final double myoff = 20.0;
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.field_70160_al) {
            this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
        }
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected String func_70639_aQ() {
        if (this.field_70170_p.field_73012_v.nextInt(5) == 0) {
            return "orespawn:godzilla_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:alo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:godzilla_death";
    }
    
    protected float func_70599_aP() {
        return 1.65f;
    }
    
    protected float func_70647_i() {
        return 1.1f;
    }
    
    protected Item func_146068_u() {
        return null;
    }
    
    protected void func_70664_aZ() {
        while (this.field_70177_z < 0.0f) {
            this.field_70177_z += 360.0f;
        }
        while (this.field_70759_as < 0.0f) {
            this.field_70759_as += 360.0f;
        }
        while (this.field_70177_z > 360.0f) {
            this.field_70177_z -= 360.0f;
        }
        while (this.field_70759_as > 360.0f) {
            this.field_70759_as -= 360.0f;
        }
        this.field_70181_x += 0.44999998807907104;
        this.field_70163_u += 0.5;
        final float f = 0.2f + Math.abs(this.field_70170_p.field_73012_v.nextFloat() * 0.45f);
        this.field_70159_w += f * Math.cos(Math.toRadians(this.field_70759_as + 90.0f));
        this.field_70179_y += f * Math.sin(Math.toRadians(this.field_70759_as + 90.0f));
        this.field_70160_al = true;
        this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
    }
    
    protected void jumpAtEntity(final EntityLivingBase e) {
        this.field_70181_x += 1.25;
        this.field_70163_u += 1.5499999523162842;
        double d1 = e.field_70165_t - this.field_70165_t;
        final double d2 = e.field_70161_v - this.field_70161_v;
        final float d3 = (float)Math.atan2(d2, d1);
        final float f2 = (float)(d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.field_70177_z = f2;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.field_70159_w += d1 * 0.05 * Math.cos(d3);
        this.field_70179_y += d1 * 0.05 * Math.sin(d3);
        this.field_70160_al = true;
        this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
    }
    
    private double getHorizontalDistanceSqToEntity(final Entity e) {
        final double d1 = e.field_70161_v - this.field_70161_v;
        final double d2 = e.field_70165_t - this.field_70165_t;
        return d1 * d1 + d2 * d2;
    }
    
    public double MygetDistanceSqToEntity(final Entity par1Entity) {
        final double d0 = this.field_70165_t - par1Entity.field_70165_t;
        double d2 = par1Entity.field_70163_u - this.field_70163_u;
        final double d3 = this.field_70161_v - par1Entity.field_70161_v;
        if (d2 > 0.0 && d2 < 20.0) {
            d2 = 0.0;
        }
        if (d2 > 20.0) {
            d2 -= 10.0;
        }
        return d0 * d0 + d2 * d2 + d3 * d3;
    }
    
    protected void func_70619_bc() {
        EntityLivingBase e = null;
        int xzrange = 9;
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        this.field_70180_af.func_75692_b(21, (Object)OreSpawnMain.PlayNicely);
        super.func_70619_bc();
        ++this.ticker;
        if (this.ticker > 30000) {
            this.ticker = 0;
        }
        if (this.ticker % 100 == 0) {
            this.stream_count = 8;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.jump_timer > 0) {
            --this.jump_timer;
        }
        OreSpawnMain.godzilla_has_spawned = 1;
        if (this.field_70170_p.field_73012_v.nextInt(200) == 0) {
            this.func_70624_b((EntityLivingBase)null);
        }
        if (OreSpawnMain.PlayNicely == 0) {
            if (this.field_70181_x < -0.95) {
                this.jumped = 1;
            }
            if (this.field_70181_x < -1.5) {
                this.jumped = 2;
            }
            if (this.jumped != 0 && this.field_70181_x > -0.1) {
                double df = 1.0;
                if (this.jumped == 2) {
                    df = 1.5;
                }
                this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0, OreSpawnMain.Godzilla_stats.attack * df, 0);
                this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, 15.0, OreSpawnMain.Godzilla_stats.attack / 2 * df, 0);
                this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, 25.0, OreSpawnMain.Godzilla_stats.attack / 4 * df, 0);
                this.jumped = 0;
            }
        }
        xzrange = 12;
        if (this.getAttacking() != 0) {
            xzrange = 16;
        }
        int k = -3 + this.ticker % 30;
        if (OreSpawnMain.PlayNicely == 0) {
            for (int i = -xzrange; i <= xzrange; ++i) {
                for (int j = -xzrange; j <= xzrange; ++j) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j);
                    if (this.isCrushable(bid)) {
                        this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j, Blocks.field_150350_a);
                        if (this.field_70170_p.field_73012_v.nextInt(15) == 1) {
                            this.dropItemRand(Item.func_150898_a(bid), 1);
                        }
                    }
                    else {
                        if (bid == Blocks.field_150349_c && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j, Blocks.field_150346_d);
                        }
                        if (bid == Blocks.field_150458_ak && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j, Blocks.field_150346_d);
                        }
                    }
                }
            }
        }
        final double dx = this.field_70165_t + 16.0 * Math.sin(Math.toRadians(this.field_70759_as));
        final double dz = this.field_70161_v - 16.0 * Math.cos(Math.toRadians(this.field_70759_as));
        k = -3 + this.ticker % 12;
        if (OreSpawnMain.PlayNicely == 0) {
            for (int i = -xzrange; i <= xzrange; ++i) {
                for (int j = -xzrange; j <= xzrange; ++j) {
                    final Block bid = this.field_70170_p.func_147439_a((int)dx + i, (int)this.field_70163_u + k, (int)dz + j);
                    if (this.isCrushable(bid)) {
                        this.field_70170_p.func_147449_b((int)dx + i, (int)this.field_70163_u + k, (int)dz + j, Blocks.field_150350_a);
                        if (this.field_70170_p.field_73012_v.nextInt(15) == 1) {
                            this.dropItemRandAt(Item.func_150898_a(bid), 1, dx, dz);
                        }
                    }
                    else {
                        if (bid == Blocks.field_150349_c && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147449_b((int)dx + i, (int)this.field_70163_u + k, (int)dz + j, Blocks.field_150346_d);
                        }
                        if (bid == Blocks.field_150458_ak && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147449_b((int)dx + i, (int)this.field_70163_u + k, (int)dz + j, Blocks.field_150346_d);
                        }
                    }
                }
            }
        }
        if (OreSpawnMain.PlayNicely == 0 && k == 0) {
            this.doJumpDamage(dx, this.field_70163_u, dz, 15.0, OreSpawnMain.Godzilla_stats.attack / 2, 1);
        }
        if (this.field_70170_p.field_73012_v.nextInt(5 - this.large_unknown_detected) == 1) {
            e = this.func_70638_az();
            if (OreSpawnMain.PlayNicely != 0) {
                e = null;
            }
            if (e != null) {
                if (!e.func_70089_S()) {
                    this.func_70624_b((EntityLivingBase)null);
                    e = null;
                }
                else if (e instanceof Godzilla || e instanceof GodzillaHead) {
                    this.func_70624_b((EntityLivingBase)null);
                    e = null;
                }
            }
            if (e == null) {
                e = this.findSomethingToAttack();
                if (this.head_found == 0) {
                    final EntityLiving newent = (EntityLiving)spawnCreature(this.field_70170_p, "MobzillaHead", this.field_70165_t, this.field_70163_u + 20.0, this.field_70161_v);
                }
            }
            if (e != null) {
                this.wander.setBusy(1);
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (this.field_70170_p.field_73012_v.nextInt(65) == 1 && this.MygetDistanceSqToEntity((Entity)e) > 300.0) {
                    this.doLightningAttack(e);
                }
                else if (this.field_70170_p.field_73012_v.nextInt(20 - this.large_unknown_detected * 5) == 1 && this.jump_timer == 0) {
                    this.jumpAtEntity(e);
                    this.jump_timer = 30;
                }
                else if (this.MygetDistanceSqToEntity((Entity)e) < 300.0f + e.field_70130_N / 2.0f * (e.field_70130_N / 2.0f)) {
                    this.setAttacking(1);
                    this.func_70661_as().func_75497_a((Entity)e, 1.0);
                    if (this.field_70170_p.field_73012_v.nextInt(4 - this.large_unknown_detected) == 0 || this.field_70170_p.field_73012_v.nextInt(3 - this.large_unknown_detected) == 1) {
                        this.func_70652_k((Entity)e);
                    }
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.0);
                    if (this.getHorizontalDistanceSqToEntity((Entity)e) > 625.0) {
                        if (this.stream_count > 0) {
                            this.setAttacking(1);
                            final double rr = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
                            final double rhdir = Math.toRadians((this.field_70759_as + 90.0f) % 360.0f);
                            final double pi = 3.1415926545;
                            double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5) {
                                this.firecanon(e);
                            }
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
            else {
                this.setAttacking(0);
                this.wander.setBusy(0);
                this.stream_count = 8;
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(35) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(5.0f);
        }
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Godzilla) {
            return false;
        }
        if (par1EntityLiving instanceof GodzillaHead) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySkeleton) {
            return false;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.field_71075_bZ.field_75098_d) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isVillagerTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && par1EntityLiving instanceof EntityVillager;
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
            if (var8 instanceof Godzilla) {
                continue;
            }
            if (var8 instanceof GodzillaHead) {
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
            this.field_70170_p.func_72956_a((Entity)var8, "random.explode", 0.85f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
            if (knock == 0) {
                continue;
            }
            final double ks = 3.5;
            final double inair = 0.75;
            final float f3 = (float)Math.atan2(var8.field_70161_v - this.field_70161_v, var8.field_70165_t - this.field_70165_t);
            var8.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return null;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            this.head_found = 1;
            return null;
        }
        List var5 = null;
        Iterator var6 = null;
        Entity var7 = null;
        EntityLivingBase var8 = null;
        EntityLivingBase ret = null;
        int vf = 0;
        var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(64.0, 40.0, 64.0));
        if (var5 == null) {
            return null;
        }
        Collections.sort((List<Object>)var5, this.TargetSorter);
        var6 = var5.iterator();
        this.head_found = 0;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (var8 instanceof GodzillaHead) {
                this.head_found = 1;
            }
            if (vf == 0 && this.isVillagerTarget(var8, false)) {
                ret = var8;
                vf = 1;
            }
            if (ret == null && vf == 0 && this.isSuitableTarget(var8, false)) {
                ret = var8;
            }
        }
        return ret;
    }
    
    public boolean func_70601_bi() {
        if (!this.func_70814_o()) {
            return false;
        }
        if (this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (OreSpawnMain.godzilla_has_spawned != 0) {
            return false;
        }
        if (this.field_70170_p.field_73012_v.nextInt(40) != 1) {
            return false;
        }
        for (int k = -8; k <= 8; ++k) {
            for (int j = -8; j <= 8; ++j) {
                for (int i = 5; i < 15; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        Godzilla target = null;
        target = (Godzilla)this.field_70170_p.func_72857_a((Class)Godzilla.class, this.field_70121_D.func_72314_b(64.0, 16.0, 64.0), (Entity)this);
        if (target != null) {
            return false;
        }
        if (!this.field_70170_p.field_72995_K) {
            OreSpawnMain.godzilla_has_spawned = 1;
        }
        return true;
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), this.field_70163_u + 4.0 + this.field_70170_p.field_73012_v.nextInt(10), this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    private ItemStack dropItemRandAt(final Item index, final int par1, final double dx, final double dz) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, dx + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), this.field_70163_u + 4.0 + this.field_70170_p.field_73012_v.nextInt(6), dz + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    private boolean isCrushable(final Block bid) {
        return bid != null && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing") && bid != Blocks.field_150349_c && bid != Blocks.field_150346_d && bid != Blocks.field_150348_b && bid != Blocks.field_150458_ak && bid != Blocks.field_150355_j && bid != Blocks.field_150358_i && bid != Blocks.field_150353_l && bid != Blocks.field_150356_k && bid != Blocks.field_150357_h && bid != Blocks.field_150343_Z && bid != Blocks.field_150354_m && bid != Blocks.field_150351_n && bid != Blocks.field_150339_S && bid != Blocks.field_150484_ah && bid != Blocks.field_150475_bE && bid != Blocks.field_150340_R && bid != Blocks.field_150424_aL && bid != Blocks.field_150377_bs && bid != OreSpawnMain.MyBlockAmethystBlock && bid != OreSpawnMain.MyBlockRubyBlock && bid != OreSpawnMain.MyBlockUraniumBlock && bid != OreSpawnMain.MyBlockTitaniumBlock && bid != OreSpawnMain.CrystalStone && bid != OreSpawnMain.CrystalGrass;
    }
    
    private void firecanon(final EntityLivingBase e) {
        final double yoff = 19.0;
        final double xzoff = 22.0;
        BetterFireball bf = null;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        if (this.stream_count > 0) {
            bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - cx, e.field_70163_u + e.field_70131_O / 2.0f - (this.field_70163_u + yoff), e.field_70161_v - cz);
            bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
            bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
            bf.setBig();
            this.field_70170_p.func_72956_a((Entity)this, "random.fuse", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)bf);
            for (int i = 0; i < 5; ++i) {
                final float r1 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                final float r2 = 3.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                final float r3 = 5.0f * (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - cx + r1, e.field_70163_u + e.field_70131_O / 2.0f - (this.field_70163_u + yoff) + r2, e.field_70161_v - cz + r3);
                bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
                bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    bf.setSmall();
                }
                this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)bf);
            }
            --this.stream_count;
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.field_70131_O * par1Entity.field_70130_N;
            if (s > 30.0f && !MyUtils.isRoyalty(par1Entity) && !(par1Entity instanceof Godzilla) && !(par1Entity instanceof GodzillaHead) && !(par1Entity instanceof PitchBlack) && !(par1Entity instanceof Kraken)) {
                final EntityLivingBase e = (EntityLivingBase)par1Entity;
                e.func_70606_j(e.func_110143_aJ() / 2.0f);
                e.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), OreSpawnMain.Godzilla_stats.attack * 10.0f);
                this.large_unknown_detected = 1;
            }
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.func_94539_a((Explosion)null);
            var21.func_94540_d();
            if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                dr.func_70965_a(dr.field_70986_h, var21, OreSpawnMain.Godzilla_stats.attack / 2.0f);
            }
            else {
                dr.func_70965_a(dr.field_70987_i, var21, OreSpawnMain.Godzilla_stats.attack / 2.0f);
            }
        }
        if (super.func_70652_k(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 3.2;
                double inair = 0.3;
                final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
                if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float dm = par2;
        float s = 0.0f;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (dm > 750.0f) {
            dm = 750.0f;
        }
        Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityLivingBase) {
            final EntityLivingBase enl = (EntityLivingBase)e;
            s = enl.field_70131_O * enl.field_70130_N;
            if (s > 30.0f && !MyUtils.isRoyalty((Entity)enl) && !(enl instanceof Godzilla) && !(enl instanceof GodzillaHead) && !(enl instanceof PitchBlack) && !(enl instanceof Kraken)) {
                dm /= 10.0f;
                this.hurt_timer = 50;
                this.large_unknown_detected = 1;
            }
        }
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, dm);
            this.hurt_timer = 20;
            e = par1DamageSource.func_76346_g();
            if (e != null && e instanceof EntityLivingBase && !(e instanceof GodzillaHead) && !(e instanceof Godzilla)) {
                this.func_70624_b((EntityLivingBase)e);
                this.func_70784_b(e);
                this.func_70661_as().func_75497_a((Entity)e, 1.2);
            }
        }
        return ret;
    }
    
    public void func_70077_a(final EntityLightningBolt par1EntityLightningBolt) {
    }
    
    private void doLightningAttack(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 100.0f;
        e.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), var2);
        e.func_70015_d(5);
        for (int var3 = 0; var3 < 20; ++var3) {
            this.field_70170_p.func_72869_a("smoke", e.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), e.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), e.field_70161_v + this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("largesmoke", e.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), e.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), e.field_70161_v + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("fireworksSpark", e.field_70165_t, e.field_70163_u, e.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian());
        }
        this.field_70170_p.func_72956_a((Entity)e, "random.explode", 0.5f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a((Entity)this, e.field_70165_t, e.field_70163_u, e.field_70161_v, 3.0f, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        }
        this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, e.field_70165_t, e.field_70163_u + 1.0, e.field_70161_v));
        this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, this.field_70165_t, this.field_70163_u + 15.0, this.field_70161_v));
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        ItemStack is = null;
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int var5 = 50 + this.field_70170_p.field_73012_v.nextInt(30), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(OreSpawnMain.MyGodzillaScale, 1);
        }
        for (int var5 = 100 + this.field_70170_p.field_73012_v.nextInt(160), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.field_151082_bd, 1);
        }
        for (int var5 = 50 + this.field_70170_p.field_73012_v.nextInt(60), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.field_151103_aS, 1);
        }
        for (int i = 25 + this.field_70170_p.field_73012_v.nextInt(15), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.field_70170_p.field_73012_v.nextInt(80);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateSword, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.field_151045_i, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150484_ah), 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Items.field_151048_u, 1);
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
                    is = this.dropItemRand(Items.field_151047_v, 1);
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
                    is = this.dropItemRand(Items.field_151046_w, 1);
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
                    is = this.dropItemRand(Items.field_151056_x, 1);
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
                    is = this.dropItemRand(Items.field_151012_L, 1);
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
                    is = this.dropItemRand((Item)Items.field_151161_ac, 1);
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
                    is = this.dropItemRand((Item)Items.field_151163_ad, 1);
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
                    is = this.dropItemRand((Item)Items.field_151173_ae, 1);
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
                    is = this.dropItemRand((Item)Items.field_151175_af, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 12: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateBow, 1);
                    break;
                }
                case 13: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
                    break;
                }
                case 14: {
                    is = this.dropItemRand(Items.field_151042_j, 1);
                    break;
                }
                case 15: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
                    break;
                }
                case 16: {
                    is = this.dropItemRand(Items.field_151040_l, 1);
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
                case 17: {
                    is = this.dropItemRand(Items.field_151037_a, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 18: {
                    is = this.dropItemRand(Items.field_151035_b, 1);
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
                case 19: {
                    is = this.dropItemRand(Items.field_151036_c, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 20: {
                    is = this.dropItemRand(Items.field_151019_K, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 21: {
                    is = this.dropItemRand((Item)Items.field_151028_Y, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 22: {
                    is = this.dropItemRand((Item)Items.field_151030_Z, 1);
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
                case 23: {
                    is = this.dropItemRand((Item)Items.field_151165_aa, 1);
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
                case 24: {
                    is = this.dropItemRand((Item)Items.field_151167_ab, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 25: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
                    break;
                }
                case 26: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150339_S), 1);
                    break;
                }
                case 27: {
                    is = this.dropItemRand(Items.field_151074_bl, 1);
                    break;
                }
                case 28: {
                    is = this.dropItemRand(Items.field_151043_k, 1);
                    break;
                }
                case 29: {
                    is = this.dropItemRand(Items.field_151150_bK, 1);
                    break;
                }
                case 30: {
                    is = this.dropItemRand(Items.field_151010_B, 1);
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
                case 31: {
                    is = this.dropItemRand(Items.field_151011_C, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 32: {
                    is = this.dropItemRand(Items.field_151005_D, 1);
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
                case 33: {
                    is = this.dropItemRand(Items.field_151006_E, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 34: {
                    is = this.dropItemRand(Items.field_151013_M, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 35: {
                    is = this.dropItemRand((Item)Items.field_151169_ag, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 36: {
                    is = this.dropItemRand((Item)Items.field_151171_ah, 1);
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
                case 37: {
                    is = this.dropItemRand((Item)Items.field_151149_ai, 1);
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
                case 38: {
                    is = this.dropItemRand((Item)Items.field_151151_aj, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 39: {
                    this.dropItemRand(Items.field_151153_ao, 1);
                    break;
                }
                case 40: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150340_R), 1);
                    break;
                }
                case 41: {
                    EntityItem var8 = null;
                    is = new ItemStack(Items.field_151153_ao, 1, 1);
                    var8 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
                    if (var8 != null) {
                        this.field_70170_p.func_72838_d((Entity)var8);
                    }
                    break;
                }
                case 42: {
                    is = this.dropItemRand(OreSpawnMain.MyExperienceSword, 1);
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
                case 43: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceHelmet, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 44: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBody, 1);
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
                case 45: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceLegs, 1);
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
                case 46: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 47: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystSword, 1);
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
                case 48: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 49: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
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
                case 50: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 51: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 52: {
                    is = this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyBlockAmethystBlock), 1);
                    break;
                }
                case 53: {
                    is = this.dropItemRand((Item)OreSpawnMain.AmethystHelmet, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 54: {
                    is = this.dropItemRand((Item)OreSpawnMain.AmethystBody, 1);
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
                case 55: {
                    is = this.dropItemRand((Item)OreSpawnMain.AmethystLegs, 1);
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
                case 56: {
                    is = this.dropItemRand((Item)OreSpawnMain.AmethystBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 57: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 58: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBody, 1);
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
                case 59: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
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
                case 60: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 61: {
                    is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
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
                case 62: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 63: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
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
                case 64: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 65: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 66: {
                    is = this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyBlockRubyBlock), 1);
                    break;
                }
                case 67: {
                    is = this.dropItemRand((Item)OreSpawnMain.UltimateHelmet, 1);
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
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 68: {
                    is = this.dropItemRand((Item)OreSpawnMain.UltimateBody, 1);
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
                case 69: {
                    is = this.dropItemRand((Item)OreSpawnMain.UltimateLegs, 1);
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
                case 70: {
                    is = this.dropItemRand((Item)OreSpawnMain.UltimateBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 71: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 73: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
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
                case 74: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 75: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
            }
        }
    }
}
