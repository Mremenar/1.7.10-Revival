// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class ThunderBolt extends EntityThrowable
{
    public ThunderBolt(final World par1World) {
        super(par1World);
    }
    
    public ThunderBolt(final World par1World, final EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }
    
    public ThunderBolt(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
    }
    
    public ThunderBolt(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null) {
            final float var2 = 40.0f;
            if (MyUtils.isRoyalty(par1MovingObjectPosition.field_72308_g)) {
                this.func_70106_y();
                return;
            }
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), var2 / 2.0f);
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.func_85052_h()), var2 / 2.0f);
            par1MovingObjectPosition.field_72308_g.func_70015_d(1);
        }
        for (int mx = 20, var3 = 0; var3 < mx; ++var3) {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70161_v + this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70161_v + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian(), this.field_70170_p.field_73012_v.nextGaussian());
        }
        this.func_85030_a("random.explode", 0.5f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0f, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        }
        this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v));
        this.func_70106_y();
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        for (int mx = 4, i = 0; i < mx; ++i) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian() / 10.0, this.field_70170_p.field_73012_v.nextGaussian() / 10.0, this.field_70170_p.field_73012_v.nextGaussian() / 10.0);
        }
    }
}
