// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityAnimal;

public class Dragonfly extends EntityAnimal
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    
    public Dragonfly(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.func_70105_a(1.5f, 0.5f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 5;
        this.field_70178_ae = false;
        this.field_70174_ab = 5;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.33000001311302185);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    protected float func_70599_aP() {
        return 0.25f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:dragonfly_living";
    }
    
    protected String func_70621_aR() {
        return "orespawn:dragonfly_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:dragonfly_death";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    public int mygetMaxHealth() {
        return 10;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 2.0f);
        return var4;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70146_Z.nextInt(300) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                zdir = this.field_70146_Z.nextInt(5) + 5;
                xdir = this.field_70146_Z.nextInt(5) + 5;
                if (this.field_70146_Z.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70146_Z.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70146_Z.nextInt(5) - 2, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        else if (this.field_70146_Z.nextInt(12) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 1.0), (int)e.field_70161_v);
                if (this.func_70068_e((Entity)e) < 6.0) {
                    this.func_70652_k((Entity)e);
                }
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
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u, (int)e.field_70161_v);
        }
        return ret;
    }
    
    public boolean func_70601_bi() {
        return this.field_70163_u >= 50.0 && this.field_70170_p.func_72935_r();
    }
    
    public void initCreature() {
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && (par1EntityLiving instanceof EntityAnt || par1EntityLiving instanceof EntityButterfly || par1EntityLiving instanceof Cockateil || par1EntityLiving instanceof EntityMosquito || par1EntityLiving instanceof Firefly || (par1EntityLiving instanceof EntityHorse && OreSpawnMain.DragonflyHorseFriendly == 0));
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0, 6.0, 10.0));
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
        final int i = this.field_70170_p.field_73012_v.nextInt(6);
        if (i == 0) {
            return Items.field_151074_bl;
        }
        if (i == 1) {
            return OreSpawnMain.UraniumNugget;
        }
        if (i == 2) {
            return OreSpawnMain.TitaniumNugget;
        }
        return null;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
}
