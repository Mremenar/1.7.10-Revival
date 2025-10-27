// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockSkyTreeLog extends Block
{
    protected BlockSkyTreeLog(final int par1, final int par2) {
        super(Material.field_151575_d);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.func_150898_a((Block)this), 1, 0));
    }
    
    protected ItemStack func_149644_j(final int par1) {
        return new ItemStack(Item.func_150898_a((Block)this), 1, 0);
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a(OreSpawnMain.MySkyTreeLog);
    }
    
    public void breakRecursor(final World world, final int x, final int y, final int z, final int xf, final int yf, final int zf, final int recursion) {
        final int var7 = 1;
        if (recursion > 1000) {
            return;
        }
        for (int var8 = -var7; var8 <= var7; ++var8) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    if (var8 != 0 || var9 != 0 || var10 != 0) {
                        if (x + var8 != xf || y + var9 != yf || z + var10 != zf) {
                            if (recursion <= 0 || x + var8 < xf - var7 || x + var8 > xf + var7 || y + var9 < yf - var7 || y + var9 > yf + var7 || z + var10 < zf - var7 || z + var10 > zf + var7) {
                                final Block var11 = world.func_147439_a(x + var8, y + var9, z + var10);
                                if (var11 == this) {
                                    world.func_147465_d(x + var8, y + var9, z + var10, Blocks.field_150350_a, 0, 2);
                                    this.func_149697_b(world, x + var8, y + var9, z + var10, 0, 0);
                                    this.breakRecursor(world, x + var8, y + var9, z + var10, x, y, z, recursion + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void func_149664_b(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
        this.breakRecursor(par1World, par2, par3, par4, par2, par3, par4, 0);
        this.func_149697_b(par1World, par2, par3, par4, 0, 0);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}
