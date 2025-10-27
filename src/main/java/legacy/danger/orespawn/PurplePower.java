// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.EntityLiving;

public class PurplePower extends EntityLiving
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private int purple_type;
    
    public PurplePower(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.purple_type = 0;
        this.func_70105_a(0.75f, 0.75f);
        this.field_70728_aV = 35;
        this.field_70178_ae = true;
        this.field_70174_ab = 25;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70145_X = true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(500.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    public void setPurpleType(final int par1) {
        if (this.field_70170_p == null) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        this.purple_type = par1;
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    public int getPurpleType() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected float func_70599_aP() {
        return 0.75f;
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
        return null;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    public int mygetMaxHealth() {
        return 1000;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        final EntityLivingBase e = null;
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
        if (this.getPurpleType() == 0) {
            if (this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u + 1.25, this.field_70161_v, (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 2.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 2.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 2.0f));
            }
        }
        else if (this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(6) == 1) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u + 0.6499999761581421, this.field_70161_v, (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 5.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 5.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 5.0f));
        }
        if (this.field_70170_p.field_72995_K) {
            this.purple_type = this.getPurpleType();
        }
        else {
            this.setPurpleType(this.purple_type);
        }
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(2500) == 1) {
            if (this.getPurpleType() == 10) {
                this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v, 9.1f, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
            this.func_70106_y();
        }
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.55, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
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
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70146_Z.nextInt(20) - 10, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        else if (this.field_70146_Z.nextInt(7) == 2 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + e.field_70131_O / 2.0f), (int)e.field_70161_v);
                if (this.func_70068_e((Entity)e) < (4.0f + e.field_70130_N / 2.0f) * (4.0f + e.field_70130_N / 2.0f)) {
                    this.func_70652_k((Entity)e);
                    this.func_70106_y();
                }
            }
        }
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
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
        float dm = par2;
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        if (dm > 10.0f) {
            dm = 10.0f;
        }
        ret = super.func_70097_a(par1DamageSource, dm);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + e.field_70131_O / 2.0f), (int)e.field_70161_v);
        }
        return ret;
    }
    
    public boolean func_70601_bi() {
        return true;
    }
    
    public int func_70658_aO() {
        return 25;
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d && (this.getPurpleType() <= 0 || this.getPurpleType() == 10);
        }
        if (this.getPurpleType() != 0 && this.getPurpleType() != 10 && par1EntityLiving instanceof EntityTameable) {
            final EntityTameable e = (EntityTameable)par1EntityLiving;
            if (e.func_70909_n()) {
                return false;
            }
        }
        return !MyUtils.isRoyalty((Entity)par1EntityLiving);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(32.0, 24.0, 32.0));
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
    
    public boolean func_70652_k(final Entity par1Entity) {
        boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final EntityLivingBase e = (EntityLivingBase)par1Entity;
            if (this.getPurpleType() == 0 || this.getPurpleType() == 10) {
                e.func_70606_j(e.func_110143_aJ() / 4.0f - 1.0f);
                var4 = e.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), e.func_110138_aP() / 8.0f);
                if (this.getPurpleType() == 10) {
                    this.field_70170_p.func_72885_a((Entity)null, e.field_70165_t, e.field_70163_u - 0.25, e.field_70161_v, 9.1f, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                }
            }
            else {
                e.func_70606_j(e.func_110143_aJ() * 15.0f / 16.0f);
                var4 = e.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 5.0f);
                if (this.getPurpleType() == 1) {
                    e.func_70015_d(10);
                }
                if (this.getPurpleType() == 2) {
                    e.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 50, 0));
                }
                if (this.getPurpleType() == 3) {
                    e.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 50, 0));
                }
            }
        }
        return var4;
    }
    
    protected Item func_146068_u() {
        return null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("PurpleType", this.purple_type);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.purple_type = par1NBTTagCompound.func_74762_e("PurpleType");
    }
}
