// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class LaserBall extends EntityThrowable
{
    private float my_rotation;
    private int my_index;
    private int is_special;
    private int is_iceball;
    private int is_acid;
    private int is_irukandji;
    private int ticksalive;
    
    public LaserBall(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }
    
    public LaserBall(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }
    
    public LaserBall(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }
    
    public LaserBall(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }
    
    public LaserBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }
    
    public int getLaserBallIndex() {
        return this.my_index;
    }
    
    public void setSpecial() {
        this.is_special = 1;
    }
    
    public void setIceBall() {
        this.is_iceball = 1;
    }
    
    public void setAcid() {
        this.is_acid = 1;
    }
    
    public void setIrukandji() {
        this.is_irukandji = 1;
        this.is_acid = 1;
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null) {
            final float var2 = 16.0f;
            if (this.is_irukandji != 0) {
                par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 100.0f);
                this.func_70106_y();
                return;
            }
            if (this.is_acid != 0) {
                if (par1MovingObjectPosition.field_72308_g instanceof TrooperBug) {
                    this.func_70106_y();
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof SpitBug) {
                    this.func_70106_y();
                    return;
                }
            }
            if (this.is_iceball == 0 && this.is_acid == 0) {
                if (par1MovingObjectPosition.field_72308_g instanceof Robot2) {
                    this.func_70106_y();
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof Robot3) {
                    this.func_70106_y();
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof Robot4) {
                    this.func_70106_y();
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof Robot5) {
                    this.func_70106_y();
                    return;
                }
                if (par1MovingObjectPosition.field_72308_g instanceof GiantRobot) {
                    this.func_70106_y();
                    return;
                }
            }
            if (par1MovingObjectPosition.field_72308_g instanceof Dragon && this.is_acid == 0) {
                final Dragon d = (Dragon)par1MovingObjectPosition.field_72308_g;
                if (d.field_70153_n != null) {
                    this.func_70106_y();
                    return;
                }
                if (d.getDragonType() != 0 && this.is_iceball != 0) {
                    this.func_70106_y();
                    return;
                }
            }
            if (par1MovingObjectPosition.field_72308_g instanceof EntityPlayer && this.is_acid == 0) {
                final EntityPlayer d2 = (EntityPlayer)par1MovingObjectPosition.field_72308_g;
                if (d2.field_70154_o != null) {
                    this.func_70106_y();
                    return;
                }
            }
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), var2);
            if (this.is_iceball == 0) {
                par1MovingObjectPosition.field_72308_g.func_70015_d(1);
            }
        }
        else if (this.is_irukandji != 0 && !this.field_70170_p.field_72995_K) {
            this.func_145779_a(OreSpawnMain.MyIrukandji, 1);
        }
        if (this.is_acid == 0) {
            int mx = 10;
            if (this.is_special != 0) {
                mx = 20;
            }
            for (int var3 = 0; var3 < mx; ++var3) {
                this.field_70170_p.func_72869_a("smoke", this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70161_v + this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
                this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70161_v + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
                this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian());
            }
            this.func_85030_a("random.explode", 0.5f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
            if (!this.field_70170_p.field_72995_K && (this.is_special != 0 || this.is_iceball != 0)) {
                this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0f, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
        }
        this.func_70106_y();
    }
    
    public void func_70071_h_() {
        ++this.ticksalive;
        if (this.ticksalive > 200) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
        this.my_rotation += 50.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.field_70127_C = my_rotation;
        this.field_70125_A = my_rotation;
        if (this.is_acid != 0) {
            return;
        }
        int mx = 4;
        if (this.is_special != 0) {
            mx = 10;
        }
        if (this.is_iceball != 0 && this.is_special == 0) {
            mx = 2;
        }
        for (int i = 0; i < mx; ++i) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian() / 2.0, this.field_70170_p.field_73012_v.nextGaussian() / 2.0, this.field_70170_p.field_73012_v.nextGaussian() / 2.0);
            if (this.is_iceball == 0) {
                this.field_70170_p.func_72869_a("reddust", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian() / 10.0, this.field_70170_p.field_73012_v.nextGaussian() / 10.0, this.field_70170_p.field_73012_v.nextGaussian() / 10.0);
            }
        }
    }
}
