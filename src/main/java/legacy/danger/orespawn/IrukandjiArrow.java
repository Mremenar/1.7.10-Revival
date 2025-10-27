// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.List;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.Block;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityArrow;

public class IrukandjiArrow extends EntityArrow
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int inData;
    private boolean inGround;
    private int ticksInGround;
    private int ticksInAir;
    private int knockbackStrength;
    
    public IrukandjiArrow(final World par1World) {
        super(par1World);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }
    
    public IrukandjiArrow(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }
    
    public IrukandjiArrow(final World par1World, final EntityLiving par2EntityLiving, final EntityLivingBase par3EntityLiving, final float par4, final float par5) {
        super(par1World, (EntityLivingBase)par2EntityLiving, par3EntityLiving, par4, par5);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }
    
    public IrukandjiArrow(final World par1World, final EntityPlayer par3EntityPlayer, final float par3) {
        super(par1World, (EntityLivingBase)par3EntityPlayer, par3);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(16, (Object)0);
    }
    
    public void func_70186_c(double par1, double par3, double par5, final float par7, final float par8) {
        final float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= var9;
        par3 /= var9;
        par5 /= var9;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        this.field_70159_w = par1;
        this.field_70181_x = par3;
        this.field_70179_y = par5;
        final float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
        final float n = (float)(Math.atan2(par1, par5) * 180.0 / 3.141592653589793);
        this.field_70177_z = n;
        this.field_70126_B = n;
        final float n2 = (float)(Math.atan2(par3, var10) * 180.0 / 3.141592653589793);
        this.field_70125_A = n2;
        this.field_70127_C = n2;
        this.ticksInGround = 0;
    }
    
    public void func_70071_h_() {
        super.func_70030_z();
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            final float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            final float n = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.141592653589793);
            this.field_70177_z = n;
            this.field_70126_B = n;
            final float n2 = (float)(Math.atan2(this.field_70181_x, var1) * 180.0 / 3.141592653589793);
            this.field_70125_A = n2;
            this.field_70127_C = n2;
        }
        final Block var2 = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
        if (var2 != Blocks.field_150350_a) {
            var2.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
            final AxisAlignedBB var3 = var2.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            if (var3 != null && var3.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
                this.inGround = true;
            }
        }
        if (this.field_70249_b > 0) {
            --this.field_70249_b;
        }
        if (this.inGround) {
            final Block var4 = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
            final int var5 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
            if (var4 != Blocks.field_150350_a && var5 == this.inData) {
                ++this.ticksInGround;
                if (this.ticksInGround == 50 && !this.field_70170_p.field_72995_K) {
                    this.func_145779_a(OreSpawnMain.MyIrukandjiArrow, 1);
                    this.func_70106_y();
                }
            }
            else {
                this.inGround = false;
                this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else {
            ++this.ticksInAir;
            Vec3 var6 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 var7 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            MovingObjectPosition var8 = this.field_70170_p.func_72901_a(var6, var7, true);
            var6 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            var7 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (var8 != null) {
                var7 = Vec3.func_72443_a(var8.field_72307_f.field_72450_a, var8.field_72307_f.field_72448_b, var8.field_72307_f.field_72449_c);
            }
            Entity var9 = null;
            final List var10 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
            double var11 = 0.0;
            for (int var12 = 0; var12 < var10.size(); ++var12) {
                final Entity var13 = var10.get(var12);
                if (var13.func_70067_L() && (var13 != this.field_70250_c || this.ticksInAir >= 5) && !(var13 instanceof Elevator)) {
                    if (var13 instanceof Cephadrome) {
                        final Cephadrome c = (Cephadrome)var13;
                        if (c.field_70153_n != null) {
                            continue;
                        }
                    }
                    if (var13 instanceof Dragon) {
                        final Dragon c2 = (Dragon)var13;
                        if (c2.field_70153_n != null) {
                            continue;
                        }
                    }
                    if (var13 instanceof EntityHorse) {
                        final EntityHorse c3 = (EntityHorse)var13;
                        if (c3.field_70153_n != null) {
                            continue;
                        }
                    }
                    final float var14 = 0.3f;
                    final AxisAlignedBB var15 = var13.field_70121_D.func_72314_b((double)var14, (double)var14, (double)var14);
                    final MovingObjectPosition var16 = var15.func_72327_a(var6, var7);
                    if (var16 != null) {
                        final double var17 = var6.func_72438_d(var16.field_72307_f);
                        if (var17 < var11 || var11 == 0.0) {
                            var9 = var13;
                            var11 = var17;
                        }
                    }
                }
            }
            if (var9 != null) {
                var8 = new MovingObjectPosition(var9);
            }
            if (var8 != null) {
                if (var8.field_72308_g != null) {
                    float var18 = 100.0f;
                    if (OreSpawnMain.ultimate_sword_pvp == 0) {
                        if (var8.field_72308_g instanceof EntityPlayer || var8.field_72308_g instanceof Girlfriend || var8.field_72308_g instanceof Boyfriend) {
                            final EntityLivingBase e = (EntityLivingBase)var8.field_72308_g;
                            this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                            this.func_70106_y();
                            return;
                        }
                        if (var8.field_72308_g instanceof EntityTameable) {
                            final EntityTameable t = (EntityTameable)var8.field_72308_g;
                            if (t.func_70909_n()) {
                                this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                                this.func_70106_y();
                                return;
                            }
                        }
                    }
                    if (this.func_70241_g()) {
                        var18 += this.field_70146_Z.nextInt((int)var18 / 2 + 2);
                    }
                    DamageSource var19 = null;
                    if (this.field_70250_c == null) {
                        var19 = DamageSource.func_76353_a((EntityArrow)this, (Entity)this);
                    }
                    else {
                        var19 = DamageSource.func_76353_a((EntityArrow)this, this.field_70250_c);
                    }
                    if (this.func_70027_ad()) {
                        var8.field_72308_g.func_70015_d(5);
                    }
                    if (var8.field_72308_g.func_70097_a(var19, var18)) {
                        if (var8.field_72308_g instanceof EntityLiving) {
                            final EntityLiving var20 = (EntityLiving)var8.field_72308_g;
                            if (!this.field_70170_p.field_72995_K) {
                                var20.func_85034_r(var20.func_85035_bI() + 1);
                            }
                            if (this.knockbackStrength > 0) {
                                final float var21 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                                if (var21 > 0.0f) {
                                    var8.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579 / var21, 0.1, this.field_70179_y * this.knockbackStrength * 0.6000000238418579 / var21);
                                }
                            }
                            if (this.field_70250_c != null && var8.field_72308_g != this.field_70250_c && var8.field_72308_g instanceof EntityPlayer && this.field_70250_c instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(6, 0.0f));
                            }
                        }
                        this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                        this.func_70106_y();
                    }
                    else {
                        this.field_70159_w *= -0.10000000149;
                        this.field_70181_x *= -0.10000000149;
                        this.field_70179_y *= -0.10000000149;
                        this.field_70177_z += 180.0f;
                        this.field_70126_B += 180.0f;
                        this.ticksInAir = 0;
                    }
                }
                else {
                    this.xTile = var8.field_72311_b;
                    this.yTile = var8.field_72312_c;
                    this.zTile = var8.field_72309_d;
                    this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
                    this.field_70159_w = (float)(var8.field_72307_f.field_72450_a - this.field_70165_t);
                    this.field_70181_x = (float)(var8.field_72307_f.field_72448_b - this.field_70163_u);
                    this.field_70179_y = (float)(var8.field_72307_f.field_72449_c - this.field_70161_v);
                    final float var22 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                    this.field_70165_t -= this.field_70159_w / var22 * 0.05;
                    this.field_70163_u -= this.field_70181_x / var22 * 0.05;
                    this.field_70161_v -= this.field_70179_y / var22 * 0.05;
                    this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.field_70249_b = 7;
                    this.func_70243_d(false);
                }
            }
            if (this.func_70241_g()) {
                for (int var12 = 0; var12 < 4; ++var12) {
                    this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * var12 / 4.0, this.field_70163_u + this.field_70181_x * var12 / 4.0, this.field_70161_v + this.field_70179_y * var12 / 4.0, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y);
                }
            }
            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            final float var22 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.141592653589793);
            this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var22) * 180.0 / 3.141592653589793);
            while (this.field_70125_A - this.field_70127_C < -180.0f) {
                this.field_70127_C -= 360.0f;
            }
            while (this.field_70125_A - this.field_70127_C >= 180.0f) {
                this.field_70127_C += 360.0f;
            }
            while (this.field_70177_z - this.field_70126_B < -180.0f) {
                this.field_70126_B -= 360.0f;
            }
            while (this.field_70177_z - this.field_70126_B >= 180.0f) {
                this.field_70126_B += 360.0f;
            }
            this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2f;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
            float var23 = 0.99f;
            final float var14 = 0.05f;
            if (this.func_70090_H()) {
                for (int var24 = 0; var24 < 4; ++var24) {
                    final float var21 = 0.25f;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var21, this.field_70163_u - this.field_70181_x * var21, this.field_70161_v - this.field_70179_y * var21, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
                var23 = 0.8f;
            }
            this.field_70159_w *= var23;
            this.field_70181_x *= var23;
            this.field_70179_y *= var23;
            this.field_70181_x -= var14;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_145775_I();
        }
    }
    
    public void func_70240_a(final int par1) {
        this.knockbackStrength = par1;
    }
    
    public void func_70239_b(final double par1) {
    }
    
    public double func_70242_d() {
        return 100.0;
    }
}
