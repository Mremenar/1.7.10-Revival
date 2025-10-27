// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.block.BlockReed;

public class BlockCorn extends BlockReed
{
    private int myMaxHeight;
    
    protected BlockCorn(final int par1) {
        this.myMaxHeight = 0;
        final float var3 = 0.375f;
        this.func_149676_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.func_149675_a(true);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        final Block bid = par1World.func_147439_a(par2, par3 - 1, par4);
        return bid != Blocks.field_150350_a && (bid == OreSpawnMain.MyCornPlant1 || bid == OreSpawnMain.MyCornPlant2 || bid == OreSpawnMain.MyCornPlant3 || bid == OreSpawnMain.MyCornPlant4 || bid == Blocks.field_150349_c || bid == Blocks.field_150346_d || bid == Blocks.field_150458_ak);
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        int Height = 1;
        int dontGrow = 0;
        if (par1World.field_72995_K) {
            return;
        }
        if (this != OreSpawnMain.MyCornPlant1 && this != OreSpawnMain.MyCornPlant2) {
            return;
        }
        int var7 = par1World.func_72805_g(par2, par3, par4);
        this.myMaxHeight = var7 >> 8;
        var7 &= 0xFF;
        if (this.myMaxHeight == 0) {
            this.myMaxHeight = 4 + OreSpawnMain.OreSpawnRand.nextInt(4);
        }
        Block bid = par1World.func_147439_a(par2, par3 + 1, par4);
        if (bid == Blocks.field_150350_a) {
            for (int var8 = 1; var8 < 10; ++var8) {
                bid = par1World.func_147439_a(par2, par3 - var8, par4);
                if (bid != OreSpawnMain.MyCornPlant1 && bid != OreSpawnMain.MyCornPlant2 && bid != OreSpawnMain.MyCornPlant3 && bid != OreSpawnMain.MyCornPlant4) {
                    break;
                }
                ++Height;
                if (bid == OreSpawnMain.MyCornPlant3 || bid == OreSpawnMain.MyCornPlant4) {
                    dontGrow = 1;
                }
            }
            if (dontGrow != 0) {
                this.myMaxHeight = Height;
            }
            if (var7 >= 6 - this.myMaxHeight / 3) {
                if (Height < this.myMaxHeight) {
                    par1World.func_147465_d(par2, par3 + 1, par4, OreSpawnMain.MyCornPlant1, this.myMaxHeight << 8, 2);
                    par1World.func_147465_d(par2, par3, par4, OreSpawnMain.MyCornPlant2, this.myMaxHeight << 8, 2);
                }
                else {
                    for (int i = 1; i < this.myMaxHeight - 1; ++i) {
                        bid = par1World.func_147439_a(par2, par3 - i, par4);
                        if (bid == OreSpawnMain.MyCornPlant2) {
                            par1World.func_147465_d(par2, par3 - i, par4, OreSpawnMain.MyCornPlant3, this.myMaxHeight << 8, 2);
                        }
                        else if (bid == OreSpawnMain.MyCornPlant3) {
                            par1World.func_147465_d(par2, par3 - i, par4, OreSpawnMain.MyCornPlant4, this.myMaxHeight << 8, 2);
                        }
                    }
                    bid = par1World.func_147439_a(par2, par3, par4);
                    par1World.func_147465_d(par2, par3, par4, bid, this.myMaxHeight << 8, 2);
                }
            }
            else {
                bid = par1World.func_147439_a(par2, par3, par4);
                par1World.func_147465_d(par2, par3, par4, bid, this.myMaxHeight << 8 | var7 + 1, 2);
            }
        }
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return OreSpawnMain.MyCornCob;
    }
    
    public Item getItem(final int par1, final Random par2Random, final int par3) {
        return OreSpawnMain.MyCornCob;
    }
    
    public int func_149745_a(final Random par1Random) {
        if (this == OreSpawnMain.MyCornPlant4) {
            return 1 + par1Random.nextInt(2);
        }
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}
