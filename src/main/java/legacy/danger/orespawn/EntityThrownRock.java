// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityThrownRock extends EntityThrowable
{
    private int rock_type;
    private int myage;
    private float my_rotation;
    
    public EntityThrownRock(final World par1World) {
        super(par1World);
        this.rock_type = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }
    
    public EntityThrownRock(final World par1World, final int par2) {
        super(par1World);
        this.rock_type = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }
    
    public EntityThrownRock(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.rock_type = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }
    
    public EntityThrownRock(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.rock_type = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
        this.rock_type = par3;
    }
    
    public EntityThrownRock(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.rock_type = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    public int getRockType() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setRockType(final int par1) {
        if (this.field_70170_p == null) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        this.rock_type = par1;
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (par1MovingObjectPosition.field_72308_g != null && this.func_85052_h() != null) {
            final Entity e = par1MovingObjectPosition.field_72308_g;
            if (this.rock_type == 1 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 2.0f);
                final double ks = 0.1;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.rock_type == 2 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.rock_type == 3 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                e.func_70015_d(20);
            }
            if (this.rock_type == 4 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 5 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 10.0f);
                final double ks = 0.1;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 6 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 20.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 7 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 40.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.rock_type == 8 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 40.0f);
                final double ks = 0.5;
                double inair = 0.055;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                this.field_70170_p.func_72885_a((Entity)null, e.field_70165_t, e.field_70163_u + 0.25, e.field_70161_v, 2.1f, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
            if (this.rock_type == 9 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                e.func_70015_d(50);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 10 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 200, 0));
                }
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 11 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 200, 0));
                }
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 0));
                }
            }
            if (this.rock_type == 12 && e != this.func_85052_h()) {
                e.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 250.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float)Math.atan2(e.field_70161_v - this.func_85052_h().field_70161_v, e.field_70165_t - this.func_85052_h().field_70165_t);
                if (e.field_70128_L) {
                    inair *= 2.0;
                }
                e.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase)e).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 0));
                }
                this.field_70170_p.func_72885_a((Entity)null, e.field_70165_t, e.field_70163_u + 0.25, e.field_70161_v, 5.1f, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
        }
        else if (this.rock_type != 0) {
            int played = 0;
            final int x = par1MovingObjectPosition.field_72311_b;
            final int y = par1MovingObjectPosition.field_72312_c;
            final int z = par1MovingObjectPosition.field_72309_d;
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        final Block bid = this.field_70170_p.func_147439_a(x + i, y + j, z + k);
                        if (bid == Blocks.field_150359_w || bid == Blocks.field_150410_aZ || bid == Blocks.field_150359_w) {
                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_147449_b(x + i, y + j, z + k, Blocks.field_150350_a);
                            }
                            if (played == 0) {
                                this.field_70170_p.func_72908_a((double)x, (double)y, (double)z, "orespawn:glassdead", 1.0f, 1.0f);
                                ++played;
                            }
                        }
                    }
                }
            }
            if (!this.field_70170_p.field_72995_K) {
                if (this.rock_type == 1) {
                    this.func_145779_a(OreSpawnMain.MySmallRock, 1);
                }
                if (this.rock_type == 2) {
                    this.func_145779_a(OreSpawnMain.MyRock, 1);
                }
                if (this.rock_type == 3) {
                    this.func_145779_a(OreSpawnMain.MyRedRock, 1);
                }
                if (this.rock_type == 4) {
                    this.func_145779_a(OreSpawnMain.MyGreenRock, 1);
                }
                if (this.rock_type == 5) {
                    this.func_145779_a(OreSpawnMain.MyBlueRock, 1);
                }
                if (this.rock_type == 6) {
                    this.func_145779_a(OreSpawnMain.MyPurpleRock, 1);
                }
                if (this.rock_type == 7) {
                    this.func_145779_a(OreSpawnMain.MySpikeyRock, 1);
                }
                if (this.rock_type == 8) {
                    this.func_145779_a(OreSpawnMain.MyTNTRock, 1);
                }
                if (this.rock_type == 9) {
                    this.func_145779_a(OreSpawnMain.MyCrystalRedRock, 1);
                }
                if (this.rock_type == 10) {
                    this.func_145779_a(OreSpawnMain.MyCrystalGreenRock, 1);
                }
                if (this.rock_type == 11) {
                    this.func_145779_a(OreSpawnMain.MyCrystalBlueRock, 1);
                }
                if (this.rock_type == 12) {
                    this.func_145779_a(OreSpawnMain.MyCrystalTNTRock, 1);
                }
            }
        }
        this.func_70106_y();
    }
    
    public void func_70071_h_() {
        final int x = (int)this.field_70165_t;
        final int y = (int)this.field_70163_u;
        final int z = (int)this.field_70161_v;
        super.func_70071_h_();
        this.my_rotation += 30.0f;
        this.my_rotation %= 360.0f;
        final float my_rotation = this.my_rotation;
        this.field_70127_C = my_rotation;
        this.field_70125_A = my_rotation;
        ++this.myage;
        if (this.myage > 1000) {
            this.func_70106_y();
        }
        if (this.field_70170_p.field_72995_K) {
            this.rock_type = this.getRockType();
        }
        else {
            this.setRockType(this.rock_type);
        }
        final Block bid = this.field_70170_p.func_147439_a(x, y, z);
        if (bid == Blocks.field_150355_j && this.field_70181_x < -0.15000000596046448 && this.field_70181_x > -0.550000011920929 && (float)(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) > 0.5f) {
            this.field_70181_x = -(this.field_70181_x * 3.0 / 4.0);
            this.field_70159_w = this.field_70159_w * 3.0 / 4.0;
            this.field_70179_y = this.field_70179_y * 3.0 / 4.0;
        }
    }
}
