// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.block.Block;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class PitchBlack extends EntityMob
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private float MyMoveSpeed;
    private int damage_ticker;
    private int wing_sound;
    
    public PitchBlack(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.MyMoveSpeed = 0.2f;
        this.damage_ticker = 0;
        this.wing_sound = 0;
        this.func_70105_a(2.0f, 3.0f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 200;
        this.field_70178_ae = false;
        this.field_70174_ab = 25;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.MyMoveSpeed = 0.2f;
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)(this.MyMoveSpeed + 0.1f * this.getPitchBlackScale()));
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)(this.getPitchBlackScale() * OreSpawnMain.PitchBlack_stats.attack));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)0);
        this.field_70180_af.func_75682_a(22, (Object)0);
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
        float t = 0.5f;
        if (this.field_70170_p != null) {
            if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                t = 1.0f;
            }
            if (this.field_70170_p.field_73012_v.nextInt(8) == 2) {
                t = 2.0f;
            }
            if (this.field_70170_p.field_73012_v.nextInt(32) == 3) {
                t = 3.0f;
            }
            if (this.field_70170_p.field_73012_v.nextInt(64) == 4) {
                t = 4.0f;
            }
        }
        else {
            if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) {
                t = 1.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) {
                t = 2.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(32) == 3) {
                t = 3.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(64) == 4) {
                t = 4.0f;
            }
        }
        if (OreSpawnMain.NightmareSize == 1) {
            t = 0.5f;
        }
        if (OreSpawnMain.NightmareSize == 2) {
            t = 1.0f;
        }
        if (OreSpawnMain.NightmareSize == 3) {
            t = 2.0f;
        }
        if (OreSpawnMain.NightmareSize == 4) {
            t = 3.0f;
        }
        if (OreSpawnMain.NightmareSize == 5) {
            t = 4.0f;
        }
        this.setPitchBlackScale(t);
        this.field_70728_aV = (int)(100.0f * t);
        this.field_70174_ab = (int)(25.0f * t);
        this.func_70105_a(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setPitchBlackScale(par1NBTTagCompound.func_74760_g("Fscale"));
        this.func_70105_a(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
        this.field_70728_aV = (int)(100.0f * this.getPitchBlackScale());
        this.field_70174_ab = (int)(25.0f * this.getPitchBlackScale());
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74776_a("Fscale", this.getPitchBlackScale());
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    public final int getActivity() {
        return this.field_70180_af.func_75683_a(21);
    }
    
    public final void setActivity(final int par1) {
        this.field_70180_af.func_75692_b(21, (Object)(byte)par1);
    }
    
    public float getPitchBlackScale() {
        final int i = this.field_70180_af.func_75679_c(22);
        final float f = (float)i;
        return f / 10.0f;
    }
    
    public void setPitchBlackScale(final float par1) {
        final float f = par1 * 10.0001f;
        final int i = (int)f;
        this.field_70180_af.func_75692_b(22, (Object)i);
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.PitchBlack_stats.defense + (int)(2.0f * this.getPitchBlackScale());
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
        return !this.func_104002_bU() && this.field_70170_p.func_72935_r();
    }
    
    protected float func_70599_aP() {
        return 0.75f;
    }
    
    protected float func_70647_i() {
        return 1.0f - 0.7f * (4.0f / this.getPitchBlackScale());
    }
    
    protected String func_70639_aQ() {
        if (this.field_70170_p.field_73012_v.nextInt(5) != 2) {
            return null;
        }
        return "orespawn:pitchblack_living";
    }
    
    protected String func_70621_aR() {
        return "orespawn:pitchblack_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:pitchblack_dead";
    }
    
    public int mygetMaxHealth() {
        return (int)(OreSpawnMain.PitchBlack_stats.health * this.getPitchBlackScale());
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        this.MyMoveSpeed = 0.2f;
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)(this.MyMoveSpeed + 0.1f * this.getPitchBlackScale()));
        super.func_70071_h_();
        this.func_70105_a(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
        ++this.wing_sound;
        if (this.wing_sound > 20) {
            if (!this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72956_a((Entity)this, "orespawn:MothraWings", 1.0f, 1.0f);
            }
            this.wing_sound = 0;
        }
        this.field_70181_x *= 0.6;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(250) == 1) {
            this.func_70691_i(1.0f + this.getPitchBlackScale());
            if (this.field_70170_p.field_73012_v.nextInt(5) == 0) {
                Block bid = Blocks.field_150350_a;
                if (this.field_70163_u > 10.0) {
                    for (int i = 0; i < 10; ++i) {
                        bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - i, (int)this.field_70161_v);
                        if (bid != Blocks.field_150350_a) {
                            break;
                        }
                    }
                }
                else {
                    bid = Blocks.field_150348_b;
                }
                if (bid != Blocks.field_150350_a) {
                    Entity e = null;
                    e = this.findSomethingToAttack();
                    if (e == null) {
                        this.setActivity(0);
                    }
                }
            }
            else {
                this.setActivity(1);
                this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
            }
        }
        if (this.getActivity() == 0 && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            Entity e2 = null;
            e2 = this.findSomethingToAttack();
            if (e2 != null) {
                this.setActivity(1);
                this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
            }
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon)par1Entity;
            DamageSource var5 = null;
            var5 = DamageSource.func_94539_a((Explosion)null);
            var5.func_94540_d();
            if (this.field_70170_p.field_73012_v.nextInt(8) == 1) {
                dr.func_70965_a(dr.field_70986_h, var5, OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            }
            else {
                dr.func_70965_a(dr.field_70987_i, var5, OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            }
            var4 = true;
        }
        else {
            var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 1.15 * this.getPitchBlackScale();
                double inair = 0.08 * this.getPitchBlackScale();
                final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
                if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return var4;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.damage_ticker > 0) {
            --this.damage_ticker;
        }
        if (this.getActivity() == 0) {
            super.func_70619_bc();
            return;
        }
        if (this.field_70128_L) {
            return;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.getActivity() == 0) {
            return;
        }
        if (this.field_70146_Z.nextInt(150) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying > 0; --keep_trying) {
                zdir = this.field_70146_Z.nextInt(20) + 5 * (int)this.getPitchBlackScale();
                xdir = this.field_70146_Z.nextInt(20) + 5 * (int)this.getPitchBlackScale();
                if (this.field_70146_Z.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70146_Z.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70146_Z.nextInt(11) - 5, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        else if (this.field_70146_Z.nextInt(8) == 0) {
            Entity e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                double d1 = 5.0 + e.field_70130_N / 2.0f;
                d1 += this.getPitchBlackScale();
                d1 *= d1;
                this.setAttacking(1);
                if (e instanceof EntityDragon && d1 < 100.0) {
                    d1 = 100.0;
                }
                if (e instanceof Godzilla && d1 < 100.0) {
                    d1 = 100.0;
                }
                if (e instanceof GodzillaHead && d1 < 100.0) {
                    d1 = 100.0;
                }
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 2.0), (int)e.field_70161_v);
                if (this.func_70068_e(e) < d1) {
                    this.func_70652_k(e);
                }
            }
            else {
                this.setAttacking(0);
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.4 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.4 - this.field_70161_v;
        final double myspeed = 0.5f + this.getPitchBlackScale() / 10.0f;
        this.field_70159_w += (Math.signum(var1) * myspeed - this.field_70159_w) * 0.33;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * 0.20000000149011612;
        this.field_70179_y += (Math.signum(var3) * myspeed - this.field_70179_y) * 0.33;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.1f + (float)myspeed;
        this.field_70177_z += var5 / 5.0f;
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
        if (this.damage_ticker > 0) {
            return ret;
        }
        this.damage_ticker = 20;
        ret = super.func_70097_a(par1DamageSource, par2);
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 2.0), (int)e.field_70161_v);
        }
        this.setActivity(1);
        this.func_70661_as().func_75484_a((PathEntity)null, 0.0);
        return ret;
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
                        if (s != null && s.equals("Nightmare")) {
                            Float t = this.getPitchBlackScale();
                            if (t > 1.0f) {
                                t = 1.0f;
                            }
                            this.setPitchBlackScale(t);
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.func_70814_o()) {
            return false;
        }
        if (this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID6) {
            PitchBlack target = null;
            target = (PitchBlack)this.field_70170_p.func_72857_a((Class)PitchBlack.class, this.field_70121_D.func_72314_b(16.0, 16.0, 16.0), (Entity)this);
            if (target != null) {
                return false;
            }
        }
        if (this.getPitchBlackScale() < 1.1f) {
            return true;
        }
        int ix = 1;
        if (this.getPitchBlackScale() > 3.1f) {
            ix = 2;
        }
        final int iy = ix * 3;
        for (int k = -ix; k <= ix; ++k) {
            for (int j = -ix; j <= ix; ++j) {
                for (int i = 1; i <= iy; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
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
        if (!(par1EntityLiving instanceof EntityLivingBase)) {
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
        if (par1EntityLiving instanceof PitchBlack) {
            return false;
        }
        if (par1EntityLiving instanceof EnderReaper) {
            return false;
        }
        if (par1EntityLiving instanceof LeafMonster) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof CreepingHorror) {
            return false;
        }
        if (par1EntityLiving instanceof Island) {
            return false;
        }
        if (par1EntityLiving instanceof IslandToo) {
            return false;
        }
        if (par1EntityLiving instanceof Triffid) {
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
    
    private Entity findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final double d1 = 16.0 + this.getPitchBlackScale() * 6.0f;
        final double d2 = 10.0 + this.getPitchBlackScale() * 4.0f;
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(d1, d2, d1));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        EntityLivingBase var7 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            if (this.isSuitableTarget(var7, false)) {
                return (Entity)var7;
            }
        }
        return null;
    }
    
    protected Item func_146068_u() {
        return OreSpawnMain.MyNightmareScale;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale() - OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale(), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale() - OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale(), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 3 + this.field_70170_p.field_73012_v.nextInt(2 + (int)(5.0f * this.getPitchBlackScale())), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.field_151078_bh, 1);
            final int j = this.field_70170_p.field_73012_v.nextInt(10);
            if (j == 0) {
                this.dropItemRand(Items.field_151008_G, 1);
            }
            if (j == 1) {
                this.dropItemRand(Items.field_151007_F, 1);
            }
            if (j == 2) {
                this.dropItemRand(Items.field_151145_ak, 1);
            }
            if (j == 3) {
                this.dropItemRand(Items.field_151082_bd, 1);
            }
        }
        this.dropItemRand(OreSpawnMain.MyNightmareScale, 1);
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int i = 2 + (int)this.getPitchBlackScale() + this.field_70170_p.field_73012_v.nextInt(2 + (int)(5.0f * this.getPitchBlackScale())), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.ZooKeeper, 1);
        }
    }
}
