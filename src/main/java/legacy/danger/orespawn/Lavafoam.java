// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class Lavafoam extends Block
{
    public Lavafoam(final int par1) {
        super(Material.field_151576_e);
        this.func_149711_c(5.0f);
        this.func_149752_b(5.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149675_a(true);
        this.field_149765_K = 1.1f;
    }
    
    public int tickRate() {
        return 10;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_73012_v.nextInt(20) == 0) {
            this.sparkle(par1World, par2, par3, par4);
        }
    }
    
    private void sparkle(final World par1World, final int par2, final int par3, final int par4) {
        final Random var5 = par1World.field_73012_v;
        final double var6 = 0.0625;
        for (int var7 = 0; var7 < 6; ++var7) {
            double var8 = par2 + var5.nextFloat();
            double var9 = par3 + var5.nextFloat();
            double var10 = par4 + var5.nextFloat();
            if (var7 == 0 && !par1World.func_147439_a(par2, par3 + 1, par4).func_149662_c()) {
                var9 = par3 + 1 + var6;
            }
            if (var7 == 1 && !par1World.func_147439_a(par2, par3 - 1, par4).func_149662_c()) {
                var9 = par3 + 0 - var6;
            }
            if (var7 == 2 && !par1World.func_147439_a(par2, par3, par4 + 1).func_149662_c()) {
                var10 = par4 + 1 + var6;
            }
            if (var7 == 3 && !par1World.func_147439_a(par2, par3, par4 - 1).func_149662_c()) {
                var10 = par4 + 0 - var6;
            }
            if (var7 == 4 && !par1World.func_147439_a(par2 + 1, par3, par4).func_149662_c()) {
                var8 = par2 + 1 + var6;
            }
            if (var7 == 5 && !par1World.func_147439_a(par2 - 1, par3, par4).func_149662_c()) {
                var8 = par2 + 0 - var6;
            }
            if (var8 < par2 || var8 > par2 + 1 || var9 < 0.0 || var9 > par3 + 1 || var10 < par4 || var10 > par4 + 1) {
                final int which = par1World.field_73012_v.nextInt(10);
                if (which == 1) {
                    par1World.func_72869_a("smoke", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 2) {
                    par1World.func_72869_a("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
                }
            }
        }
    }
    
    public void func_149670_a(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        final double pi = 3.14159;
        final double pi2 = pi / 2.0;
        final double pi3 = pi / 4.0;
        super.func_149670_a(par1World, par2, par3, par4, par5Entity);
        if (par5Entity == null) {
            return;
        }
        if (!(par5Entity instanceof EntityLivingBase)) {
            return;
        }
        double d = Math.atan2(par5Entity.field_70165_t - (par2 + 0.5f), par5Entity.field_70161_v - (par4 + 0.5f));
        if (d < 0.0) {
            d += pi * 2.0;
        }
        if (d > pi2 - pi3 && d < pi2 + pi3) {
            par5Entity.field_70159_w = 0.44999998807907104;
            par5Entity.field_70179_y *= 1.350000023841858;
        }
        else if (d > pi - pi3 && d < pi + pi3) {
            par5Entity.field_70179_y = -0.44999998807907104;
            par5Entity.field_70159_w *= 1.350000023841858;
        }
        else if (d > pi + pi2 - pi3 && d < pi + pi2 + pi3) {
            par5Entity.field_70159_w = -0.44999998807907104;
            par5Entity.field_70179_y *= 1.350000023841858;
        }
        else {
            par5Entity.field_70179_y = 0.44999998807907104;
            par5Entity.field_70159_w *= 1.350000023841858;
        }
        d = Math.sqrt(par5Entity.field_70179_y * par5Entity.field_70179_y + par5Entity.field_70159_w * par5Entity.field_70159_w);
        if (d > 1.0) {
            par5Entity.func_70097_a(DamageSource.field_76379_h, (float)d);
        }
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.field_73012_v.nextInt(5) + par1World.field_73012_v.nextInt(5);
        if (par1World.field_73011_w.field_76574_g == -1) {
            this.func_149657_c(par1World, par2, par3, par4, j1);
        }
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int par2, final int par3, final int par4) {
        final float f = 0.0125f;
        return AxisAlignedBB.func_72330_a((double)(par2 + f), (double)par3, (double)(par4 + f), (double)(par2 + 1 - f), (double)(float)(par3 + 1), (double)(par4 + 1 - f));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}
