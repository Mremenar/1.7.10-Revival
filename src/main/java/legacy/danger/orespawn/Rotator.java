// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class Rotator extends EntityMob
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int busy_fighting;
    private int was_spawnered;
    
    public Rotator(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.busy_fighting = 0;
        this.was_spawnered = 0;
        this.func_70105_a(1.0f, 2.0f);
        this.field_70728_aV = 35;
        this.field_70178_ae = true;
        this.field_70174_ab = 25;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Rotator_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
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
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.busy_fighting == 0 && this.was_spawnered == 0;
    }
    
    protected float func_70599_aP() {
        return 0.75f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return "vortexlive";
    }
    
    protected String func_70621_aR() {
        return "orespawn:glasshit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:glassdead";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Rotator_stats.health;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        EntityLivingBase e = null;
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
        if (this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u + 1.399999976158142, this.field_70161_v, (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 4.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 4.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 4.0f));
        }
        this.busy_fighting = 0;
        e = this.findSomethingToAttack();
        if (e != null) {
            final double a = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u + 1.399999976158142, this.field_70161_v, Math.cos(a), (e.field_70163_u - this.field_70163_u) / 10.0, Math.sin(a));
            this.busy_fighting = 1;
        }
        if (this.func_104002_bU()) {
            return;
        }
        if (this.busy_fighting != 0) {
            return;
        }
        if (this.was_spawnered != 0) {
            return;
        }
        long t = this.field_70170_p.func_72820_D();
        t %= 24000L;
        if (t < 12000L && this.field_70170_p.field_73012_v.nextInt(400) == 1) {
            this.func_70106_y();
        }
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        EntityLivingBase e = null;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70146_Z.nextInt(300) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                zdir = this.field_70146_Z.nextInt(10) + 8;
                xdir = this.field_70146_Z.nextInt(10) + 8;
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
            }
        }
        else if (this.field_70146_Z.nextInt(9) == 2) {
            e = this.findSomethingToAttack();
            if (e != null) {
                double a = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
                a += 1.5707963267948966;
                this.currentFlightTarget.func_71571_b((int)(e.field_70165_t + 2.5 * Math.cos(a)), (int)e.field_70163_u, (int)(e.field_70161_v + 2.5 * Math.sin(a)));
                if (this.func_70068_e((Entity)e) < 9.0) {
                    this.func_70652_k((Entity)e);
                }
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.4 - this.field_70159_w) * 0.2;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * 0.20000000149011612;
        this.field_70179_y += (Math.signum(var3) * 0.4 - this.field_70179_y) * 0.2;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.75f;
        this.field_70177_z += var5 / 4.0f;
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
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
                        if (s != null && s.equals("Rotator")) {
                            this.was_spawnered = 1;
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.func_70814_o()) {
            return false;
        }
        for (int k = -1; k <= 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 3; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        long t = this.field_70170_p.func_72820_D();
        t %= 24000L;
        return t >= 12000L;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Rotator_stats.defense;
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.field_71075_bZ.field_75098_d) {
                return false;
            }
        }
        return !(par1EntityLiving instanceof Termite) && !(par1EntityLiving instanceof Vortex) && !(par1EntityLiving instanceof Rotator) && !(par1EntityLiving instanceof DungeonBeast) && !(par1EntityLiving instanceof Peacock) && !(par1EntityLiving instanceof CrystalCow) && !(par1EntityLiving instanceof Irukandji) && !(par1EntityLiving instanceof Skate) && !(par1EntityLiving instanceof Whale) && !(par1EntityLiving instanceof Flounder) && !(par1EntityLiving instanceof Urchin) && !(par1EntityLiving instanceof TerribleTerror) && !(par1EntityLiving instanceof LurkingTerror) && !(par1EntityLiving instanceof CloudShark) && !(par1EntityLiving instanceof Mothra) && !(par1EntityLiving instanceof Bee) && !(par1EntityLiving instanceof Mantis);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(12.0, 10.0, 12.0));
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
    
    protected Item func_146068_u() {
        final int i = this.field_70170_p.field_73012_v.nextInt(4);
        if (i == 0) {
            return OreSpawnMain.MyCrystalPinkIngot;
        }
        if (i == 1) {
            return OreSpawnMain.MyTigersEyeIngot;
        }
        if (i == 2) {
            return Item.func_150898_a(OreSpawnMain.CrystalCoal);
        }
        if (i == 3) {
            return Items.field_151042_j;
        }
        return null;
    }
}
