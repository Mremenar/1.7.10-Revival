// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.Vec3;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class Brutalfly extends EntityMob
{
    private ChunkCoordinates currentFlightTarget;
    private int lastX;
    private int lastZ;
    private int lastY;
    private int stuck_count;
    private int wing_sound;
    private int health_ticker;
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    
    public Brutalfly(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.lastX = 0;
        this.lastZ = 0;
        this.lastY = 0;
        this.stuck_count = 0;
        this.wing_sound = 0;
        this.health_ticker = 100;
        this.TargetSorter = null;
        this.moveSpeed = 0.35f;
        this.func_70105_a(5.0f, 2.0f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 100;
        this.field_70178_ae = true;
        this.field_70174_ab = 500;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Brutalfly_stats.attack);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Brutalfly_stats.defense;
    }
    
    public int getBrutalflyHealth() {
        return (int)this.func_110143_aJ();
    }
    
    protected float func_70599_aP() {
        return 1.5f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return null;
    }
    
    protected String func_70673_aS() {
        return "random.explode";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Brutalfly_stats.health;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72956_a((Entity)this, "orespawn:MothraWings", 1.0f, 1.0f);
            }
            this.wing_sound = 0;
        }
        --this.health_ticker;
        if (this.health_ticker <= 0) {
            if (this.func_110143_aJ() < this.mygetMaxHealth()) {
                this.func_70691_i(1.0f);
            }
            this.health_ticker = 100;
        }
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 30;
        int shoot = 3;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.lastX == (int)this.field_70165_t && this.lastY == (int)this.field_70163_u && this.lastZ == (int)this.field_70161_v) {
            ++this.stuck_count;
        }
        else {
            this.stuck_count = 0;
            this.lastX = (int)this.field_70165_t;
            this.lastY = (int)this.field_70163_u;
            this.lastZ = (int)this.field_70161_v;
        }
        if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
            shoot = 2;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.stuck_count > 30 || this.field_70170_p.field_73012_v.nextInt(200) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 9.0f) {
            int down = 0;
            int dist = 20;
            for (int i = -5; i <= 5; i += 5) {
                for (int j = -5; j <= 5; j += 5) {
                    int k = 1;
                    while (k < 20) {
                        final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u - k, (int)this.field_70161_v + i);
                        if (bid != Blocks.field_150350_a) {
                            if (k < dist) {
                                dist = k;
                                break;
                            }
                            break;
                        }
                        else {
                            ++k;
                        }
                    }
                }
            }
            if (dist > 10) {
                down = dist - 10 + 1;
            }
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                xdir = 1;
                zdir = 1;
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    xdir = -1;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    zdir = -1;
                }
                int newz = this.field_70146_Z.nextInt(20) + 8;
                newz *= zdir;
                int newx = this.field_70146_Z.nextInt(20) + 8;
                newx *= xdir;
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + newx, (int)this.field_70163_u + this.field_70170_p.field_73012_v.nextInt(7) - 1 - down, (int)this.field_70161_v + newz);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
            this.stuck_count = 0;
        }
        if (this.field_70170_p.field_73012_v.nextInt(6) == 0) {
            EntityPlayer target = null;
            target = (EntityPlayer)this.field_70170_p.func_72857_a((Class)EntityPlayer.class, this.field_70121_D.func_72314_b(30.0, 20.0, 30.0), (Entity)this);
            if (target != null) {
                if (!target.field_71075_bZ.field_75098_d) {
                    if (this.func_70635_at().func_75522_a((Entity)target)) {
                        this.currentFlightTarget.func_71571_b((int)target.field_70165_t, (int)target.field_70163_u + 4, (int)target.field_70161_v);
                        if (this.field_70146_Z.nextInt(shoot) == 0) {
                            this.attackWithSomething((EntityLivingBase)target);
                        }
                    }
                }
                else {
                    target = null;
                }
            }
            if (target == null && this.field_70170_p.field_73012_v.nextInt(3) == 0) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null) {
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u + 5, (int)e.field_70161_v);
                    if (this.func_70068_e((Entity)e) > 25.0) {
                        if (this.field_70170_p.field_73012_v.nextInt(shoot) == 0) {
                            this.attackWithSomething(e);
                        }
                    }
                    else {
                        this.func_70652_k((Entity)e);
                    }
                }
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.5 - this.field_70159_w) * 0.30001;
        this.field_70181_x += (Math.signum(var2) * 0.7 - this.field_70181_x) * 0.20001;
        this.field_70179_y += (Math.signum(var3) * 0.5 - this.field_70179_y) * 0.30001;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 1.0f;
        this.field_70177_z += var5 / 8.0f;
    }
    
    protected boolean func_70041_e_() {
        return false;
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
        if (e != null && e instanceof Brutalfly) {
            return false;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u + 2, (int)e.field_70161_v);
        }
        return ret;
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
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
                        if (s != null && s.equals("Brutalfly")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70163_u < 70.0) {
            return false;
        }
        if (!this.func_70814_o()) {
            return false;
        }
        if (this.field_70170_p.func_72935_r()) {
            return false;
        }
        for (int k = -4; k < 4; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 1; i < 10; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        Brutalfly target = null;
        target = (Brutalfly)this.field_70170_p.func_72857_a((Class)Brutalfly.class, this.field_70121_D.func_72314_b(64.0, 32.0, 64.0), (Entity)this);
        return target == null;
    }
    
    public void initCreature() {
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.field_70146_Z.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + var1, this.field_70163_u + 2.0 + var2, this.field_70161_v + var3, 0.0, 0.0, 0.0);
        }
        for (int var4 = 0; var4 < 53; ++var4) {
            this.dropItemRand(Items.field_151074_bl, 1);
        }
        for (int var4 = 0; var4 < 20; ++var4) {
            spawnCreature(this.field_70170_p, "Butterfly", this.field_70165_t + 0.5, this.field_70163_u + 1.0, this.field_70161_v + 0.5);
        }
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        if (par0World == null) {
            return null;
        }
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    private void attackWithSomething(final EntityLivingBase par1) {
        final double xzoff = 2.25;
        final double yoff = 0.0;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        if (this.field_70170_p.field_73013_u == EnumDifficulty.EASY) {
            final EntitySmallFireball sf = new EntitySmallFireball(this.field_70170_p, (EntityLivingBase)this, par1.field_70165_t - cx, par1.field_70163_u + 0.55 - (this.field_70163_u + yoff), par1.field_70161_v - cz);
            sf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
            sf.func_70107_b(cx, this.field_70163_u + yoff, cz);
            this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)sf);
        }
        else if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
            if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                final EntitySmallFireball sf = new EntitySmallFireball(this.field_70170_p, (EntityLivingBase)this, par1.field_70165_t - cx, par1.field_70163_u + 0.55 - (this.field_70163_u + yoff), par1.field_70161_v - cz);
                sf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
                sf.func_70107_b(cx, this.field_70163_u + yoff, cz);
                this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)sf);
            }
            else {
                final BetterFireball bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, par1.field_70165_t - cx, par1.field_70163_u + 0.55 - (this.field_70163_u + yoff), par1.field_70161_v - cz);
                bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
                bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
                bf.setNotMe();
                this.field_70170_p.func_72956_a((Entity)this, "random.fuse", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)bf);
            }
        }
        else {
            final BetterFireball bf = new BetterFireball(this.field_70170_p, (EntityLivingBase)this, par1.field_70165_t - cx, par1.field_70163_u + 0.55 - (this.field_70163_u + yoff), par1.field_70161_v - cz);
            bf.func_70012_b(cx, this.field_70163_u + yoff, cz, this.field_70177_z, 0.0f);
            bf.func_70107_b(cx, this.field_70163_u + yoff, cz);
            bf.setNotMe();
            this.field_70170_p.func_72956_a((Entity)this, "random.fuse", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)bf);
        }
        if (this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(1.0f);
        }
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
        if (par1EntityLiving instanceof Brutalfly) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(25.0, 20.0, 25.0));
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
