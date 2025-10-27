// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTitanium extends Block
{
    public BlockTitanium(final int par1) {
        super(Material.field_151576_e);
        this.func_149711_c(5.0f);
        this.func_149752_b(5.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149715_a(0.5f);
    }
    
    public int tickRate() {
        return 100;
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
                final int which = par1World.field_73012_v.nextInt(3);
                if (which == 0) {
                    par1World.func_72869_a("flame", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 1) {
                    par1World.func_72869_a("smoke", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 2) {
                    par1World.func_72869_a("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}
