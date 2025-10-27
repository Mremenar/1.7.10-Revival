// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;

public class BetterFireball extends EntityFireball
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private boolean inGround;
    public EntityLivingBase field_70235_a;
    private int ticksAlive;
    private int ticksInAir;
    public double field_70232_b;
    public double field_70233_c;
    public double field_70230_d;
    public int field_92012_e;
    private int notme;
    private boolean small;
    
    public BetterFireball(final World par1World) {
        super(par1World);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.ticksInAir = 0;
        this.field_92012_e = 1;
        this.notme = 0;
        this.small = false;
        this.func_70105_a(1.0f, 1.0f);
    }
    
    protected void func_70088_a() {
    }
    
    public BetterFireball(final World par1World, final EntityLivingBase par2EntityLiving, final double par3, final double par5, final double par7) {
        super(par1World);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.ticksInAir = 0;
        this.field_92012_e = 1;
        this.notme = 0;
        this.small = false;
        this.field_70235_a = par2EntityLiving;
        this.func_70105_a(1.0f, 1.0f);
        this.func_70012_b(par2EntityLiving.field_70165_t, par2EntityLiving.field_70163_u, par2EntityLiving.field_70161_v, par2EntityLiving.field_70177_z, par2EntityLiving.field_70125_A);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        final double field_70159_w = 0.0;
        this.field_70179_y = field_70159_w;
        this.field_70181_x = field_70159_w;
        this.field_70159_w = field_70159_w;
        final double var9 = MathHelper.func_76133_a(par3 * par3 + par5 * par5 + par7 * par7);
        this.field_70232_b = par3 / var9 * 0.1;
        this.field_70233_c = par5 / var9 * 0.1;
        this.field_70230_d = par7 / var9 * 0.1;
    }
    
    public void setNotMe() {
        this.notme = 1;
    }
    
    public void setBig() {
        this.field_92012_e = 2;
    }
    
    public void setReallyBig() {
        this.field_92012_e = 4;
    }
    
    public void setSmall() {
        this.small = true;
        this.func_70105_a(0.3125f, 0.3125f);
    }
    
    public void func_70071_h_() {
        Vec3 var15 = null;
        Vec3 var16 = null;
        MovingObjectPosition var17 = null;
        Entity var18 = null;
        List var19 = null;
        double var20 = 0.0;
        Entity var21 = null;
        final float var22 = 0.3f;
        double var23 = 0.0;
        float var24 = 0.0f;
        float var25 = 0.0f;
        float var26 = 0.0f;
        if (this.ticksAlive >= 600 || this.ticksInAir >= 600) {
            this.func_70106_y();
            return;
        }
        if (!this.field_70170_p.field_72995_K && ((this.field_70235_a != null && this.field_70235_a.field_70128_L) || !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
            this.func_70106_y();
        }
        else {
            super.func_70071_h_();
            this.func_70015_d(1);
            if (this.inGround) {
                final Block var27 = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
                if (var27 != Blocks.field_150350_a) {
                    ++this.ticksAlive;
                }
                this.inGround = false;
                this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2f;
                this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2f;
            }
            else {
                ++this.ticksInAir;
            }
            var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            var16 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            var17 = this.field_70170_p.func_72901_a(var15, var16, false);
            var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            var16 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (var17 != null) {
                var16 = Vec3.func_72443_a(var17.field_72307_f.field_72450_a, var17.field_72307_f.field_72448_b, var17.field_72307_f.field_72449_c);
            }
            var18 = null;
            var19 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
            var20 = 0.0;
            for (int var28 = 0; var28 < var19.size(); ++var28) {
                var21 = var19.get(var28);
                if (this.field_70235_a == var21) {
                    var17 = null;
                    break;
                }
                if (var21 instanceof BetterFireball) {
                    var17 = null;
                    break;
                }
                if (var21 instanceof GodzillaHead) {
                    var17 = null;
                    break;
                }
                if (MyUtils.isRoyalty(var21)) {
                    var17 = null;
                    break;
                }
                if (this.notme != 0 && (var21 instanceof EntityPlayer || var21 instanceof Dragon || var21 instanceof Mothra)) {
                    var17 = null;
                    break;
                }
                if (var21.func_70067_L() && (!var21.func_70028_i((Entity)this.field_70235_a) || this.ticksInAir >= 25)) {
                    final AxisAlignedBB var29 = var21.field_70121_D.func_72314_b((double)var22, (double)var22, (double)var22);
                    final MovingObjectPosition var30 = var29.func_72327_a(var15, var16);
                    if (var30 != null) {
                        var23 = var15.func_72438_d(var30.field_72307_f);
                        if (var23 < var20 || var20 == 0.0) {
                            var18 = var21;
                            var20 = var23;
                        }
                    }
                }
            }
            if (var18 != null) {
                var17 = new MovingObjectPosition(var18);
            }
            if (var17 != null) {
                this.func_70227_a(var17);
            }
            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            var24 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) + 90.0f;
            this.field_70125_A = (float)(Math.atan2(var24, this.field_70181_x) * 180.0 / 3.141592653589793) - 90.0f;
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
            var25 = this.func_82341_c();
            if (this.func_70090_H()) {
                for (int var31 = 0; var31 < 4; ++var31) {
                    var26 = 0.25f;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var26, this.field_70163_u - this.field_70181_x * var26, this.field_70161_v - this.field_70179_y * var26, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
                var25 = 0.8f;
            }
            this.field_70159_w += this.field_70232_b;
            this.field_70181_x += this.field_70233_c;
            this.field_70179_y += this.field_70230_d;
            this.field_70159_w *= var25;
            this.field_70181_x *= var25;
            this.field_70179_y *= var25;
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v, 0.0, 0.0, 0.0);
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
    }
    
    protected void func_70227_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (!this.field_70170_p.field_72995_K) {
            if (par1MovingObjectPosition.field_72308_g != null) {
                if (par1MovingObjectPosition.field_72308_g instanceof BetterFireball) {
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof Mothra) {
                    return;
                }
                if (this.notme != 0 && (par1MovingObjectPosition.field_72308_g instanceof Dragon || par1MovingObjectPosition.field_72308_g instanceof EntityPlayer)) {
                    this.func_70106_y();
                    return;
                }
                final Entity e = par1MovingObjectPosition.field_72308_g;
                if (e instanceof EntityLiving) {
                    final EntityLiving el = (EntityLiving)e;
                    if (el.field_70130_N * el.field_70131_O > 30.0f && !MyUtils.isRoyalty((Entity)el) && !(el instanceof Godzilla) && !(el instanceof GodzillaHead) && !(el instanceof PitchBlack) && !(el instanceof Kraken)) {
                        el.func_70606_j(el.func_110143_aJ() / 2.0f);
                    }
                }
                if (!this.small) {
                    par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76362_a((EntityFireball)this, (Entity)this.field_70235_a), 10.0f);
                    par1MovingObjectPosition.field_72308_g.func_70015_d(5);
                }
                else {
                    par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76362_a((EntityFireball)this, (Entity)this.field_70235_a), 5.0f);
                    par1MovingObjectPosition.field_72308_g.func_70015_d(5);
                }
            }
            else {
                int i = par1MovingObjectPosition.field_72311_b;
                int j = par1MovingObjectPosition.field_72312_c;
                int k = par1MovingObjectPosition.field_72309_d;
                switch (par1MovingObjectPosition.field_72310_e) {
                    case 0: {
                        --j;
                        break;
                    }
                    case 1: {
                        ++j;
                        break;
                    }
                    case 2: {
                        --k;
                        break;
                    }
                    case 3: {
                        ++k;
                        break;
                    }
                    case 4: {
                        --i;
                        break;
                    }
                    case 5: {
                        ++i;
                        break;
                    }
                }
                if (this.field_70170_p.func_147437_c(i, j, k)) {
                    this.field_70170_p.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
                }
            }
            if (!this.small) {
                this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_92012_e, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
            this.func_70106_y();
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("ExplosionPower", this.field_92012_e);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        if (par1NBTTagCompound.func_74764_b("ExplosionPower")) {
            this.field_92012_e = par1NBTTagCompound.func_74762_e("ExplosionPower");
        }
    }
}
