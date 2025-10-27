// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;

public class GodzillaHead extends EntityLiving
{
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    
    public GodzillaHead(final World par1World) {
        super(par1World);
        this.func_70105_a(9.9f, 10.0f);
        this.field_70145_X = true;
        this.field_70174_ab = 10000;
        this.field_70178_ae = true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)OreSpawnMain.Godzilla_stats.health);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.3300000429153442);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return false;
        }
        Entity e = par1DamageSource.func_76346_g();
        if (e != null && (e instanceof Godzilla || e instanceof GodzillaHead)) {
            return false;
        }
        e = par1DamageSource.func_76364_f();
        if (e != null && (e instanceof Godzilla || e instanceof GodzillaHead)) {
            return false;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)Godzilla.class, this.field_70121_D.func_72314_b(32.0, 32.0, 32.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        Godzilla var8 = null;
        if (var6.hasNext()) {
            var7 = var6.next();
            var8 = (Godzilla)var7;
            ret = var8.func_70097_a(par1DamageSource, par2);
        }
        return ret;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        if (this.field_70153_n != null) {
            this.boatPosRotationIncrements = par9 + 8;
        }
        else {
            this.boatPosRotationIncrements = 6;
        }
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.field_70159_w = this.velocityX;
        this.field_70181_x = this.velocityY;
        this.field_70179_y = this.velocityZ;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        this.field_70159_w = par1;
        this.velocityX = par1;
        this.field_70181_x = par3;
        this.velocityY = par3;
        this.field_70179_y = par5;
        this.velocityZ = par5;
    }
    
    public void func_70071_h_() {
        if (this.field_70128_L) {
            return;
        }
        this.field_70160_al = true;
        this.func_70015_d(0);
        if (this.field_70170_p.field_72995_K) {
            if (this.boatPosRotationIncrements > 0) {
                final double d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
                final double d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
                final double d6 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
                this.func_70107_b(d4, d5, d6);
                this.field_70125_A += (float)((this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
                double d7 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
                if (this.field_70153_n != null) {
                    d7 = MathHelper.func_76138_g(this.field_70153_n.field_70177_z - (double)this.field_70177_z);
                }
                this.func_70101_b(this.field_70177_z += (float)(d7 / this.boatPosRotationIncrements), this.field_70125_A);
                --this.boatPosRotationIncrements;
            }
        }
        else {
            final List var5 = this.field_70170_p.func_72872_a((Class)Godzilla.class, this.field_70121_D.func_72314_b(32.0, 32.0, 32.0));
            final Iterator var6 = var5.iterator();
            Entity var7 = null;
            Godzilla var8 = null;
            if (var6.hasNext()) {
                var7 = var6.next();
                var8 = (Godzilla)var7;
                this.field_70163_u = var8.field_70163_u + 16.0;
                this.field_70165_t = var8.field_70165_t - 17.0 * Math.sin(Math.toRadians(var8.field_70759_as));
                this.field_70161_v = var8.field_70161_v + 17.0 * Math.cos(Math.toRadians(var8.field_70759_as));
                this.field_70177_z = var8.field_70177_z;
                this.field_70759_as = var8.field_70759_as;
                this.field_70159_w = var8.field_70159_w;
                this.field_70181_x = var8.field_70181_x;
                this.field_70179_y = var8.field_70179_y;
                this.func_70606_j(var8.func_110143_aJ());
            }
            else {
                this.func_70106_y();
            }
        }
    }
}
