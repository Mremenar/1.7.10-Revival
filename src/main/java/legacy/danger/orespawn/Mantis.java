// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class Mantis extends EntityMob
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private Entity rt;
    
    public Mantis(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.rt = null;
        this.func_70105_a(2.5f, 3.25f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 100;
        this.field_70178_ae = false;
        this.field_70174_ab = 5;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3199999928474426);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Mantis_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    protected float func_70599_aP() {
        return 0.35f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:Beebuzz";
    }
    
    protected String func_70621_aR() {
        return "orespawn:dragonfly_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Mantis_stats.health;
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a((Block)Blocks.field_150327_N);
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.MyMantisClaw, 1);
        this.dropItemRand(OreSpawnMain.MyMantisClaw, 1);
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int var4 = 2 + this.field_70170_p.field_73012_v.nextInt(10), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.field_151074_bl, 1);
        }
        for (int var4 = 1 + this.field_70170_p.field_73012_v.nextInt(3), i = 0; i < var4; ++i) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        for (int var4 = 1 + this.field_70170_p.field_73012_v.nextInt(3), i = 0; i < var4; ++i) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
        for (int var4 = 2 + this.field_70170_p.field_73012_v.nextInt(3), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.field_151045_i, 1);
        }
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
        if (this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(20) == 1) {
            this.func_70652_k((Entity)this);
        }
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.lastX == (int)this.field_70165_t && this.lastZ == (int)this.field_70161_v) {
            ++this.stuck_count;
        }
        else {
            this.stuck_count = 0;
            this.lastX = (int)this.field_70165_t;
            this.lastZ = (int)this.field_70161_v;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.stuck_count > 50 || this.field_70146_Z.nextInt(300) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f) {
            Block bid = Blocks.field_150348_b;
            this.stuck_count = 0;
            while (bid != Blocks.field_150350_a && keep_trying != 0) {
                zdir = this.field_70146_Z.nextInt(9) + 4;
                xdir = this.field_70146_Z.nextInt(9) + 4;
                if (this.field_70146_Z.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70146_Z.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 3, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
                --keep_trying;
            }
        }
        else if (this.field_70146_Z.nextInt(8) == 0) {
            EntityLivingBase e = null;
            e = (EntityLivingBase)this.rt;
            if (e != null && e.field_70128_L) {
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.setAttacking(1);
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u + 1, (int)e.field_70161_v);
                if (this.func_70068_e((Entity)e) < (5.0f + e.field_70130_N / 2.0f) * (5.0f + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                }
            }
            else {
                this.setAttacking(0);
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.5 - this.field_70159_w) * 0.30000000149011613;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * 0.20000000149011612;
        this.field_70179_y += (Math.signum(var3) * 0.5 - this.field_70179_y) * 0.30000000149011613;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 1.0f;
        this.field_70177_z += var5 / 4.0f;
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
            this.func_70691_i(1.0f);
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
        final boolean ret = super.func_70097_a(par1DamageSource, par2);
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null) {
            this.rt = e;
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u, (int)e.field_70161_v);
        }
        return ret;
    }
    
    public boolean func_70601_bi() {
        for (int k = -2; k <= 2; ++k) {
            for (int j = -2; j <= 2; ++j) {
                for (int i = 1; i < 4; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Mantis")) {
                            return true;
                        }
                    }
                }
            }
        }
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID6 && this.field_70170_p.field_73012_v.nextInt(6) != 0) {
            return false;
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        Mantis target = null;
        target = (Mantis)this.field_70170_p.func_72857_a((Class)Mantis.class, this.field_70121_D.func_72314_b(32.0, 16.0, 32.0), (Entity)this);
        return target == null;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Mantis_stats.defense;
    }
    
    public void initCreature() {
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
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving.func_70090_H()) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        if (par1EntityLiving instanceof Mantis) {
            return false;
        }
        if (par1EntityLiving instanceof Irukandji) {
            return false;
        }
        if (par1EntityLiving instanceof Skate) {
            return false;
        }
        if (par1EntityLiving instanceof Flounder) {
            return false;
        }
        if (par1EntityLiving instanceof Whale) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySquid) {
            return false;
        }
        if (par1EntityLiving instanceof WaterDragon) {
            return false;
        }
        if (par1EntityLiving instanceof AttackSquid) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof CloudShark) {
            return false;
        }
        if (par1EntityLiving instanceof Rotator) {
            return false;
        }
        if (par1EntityLiving instanceof Bee) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof Cockateil) {
            return true;
        }
        if (par1EntityLiving instanceof Fairy) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (!p.field_71075_bZ.field_75098_d) {
                return true;
            }
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(16.0, 8.0, 16.0));
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
}
