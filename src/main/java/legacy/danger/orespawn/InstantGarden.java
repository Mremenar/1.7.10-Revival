// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class InstantGarden extends Item
{
    public InstantGarden(final int i) {
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78028_d);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer Player, final World world, final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9, final float par10) {
        int deltax = 0;
        int deltaz = 0;
        final int bid = 0;
        int dirx = 0;
        int dirz = 0;
        final int height = 10;
        final int width = 7;
        final int length = 18;
        if (cposx < 0) {
            dirx = -1;
        }
        if (cposz < 0) {
            dirz = -1;
        }
        final int pposx = (int)(Player.field_70165_t + 0.99 * dirx);
        final int pposy = (int)Player.field_70163_u;
        final int pposz = (int)(Player.field_70161_v + 0.99 * dirz);
        if (cposx - pposx != 0 && cposz - pposz != 0) {
            return false;
        }
        final int x = cposx;
        final int y = pposy;
        final int z = cposz;
        if (x - pposx < 0) {
            deltax = -1;
        }
        if (x - pposx > 0) {
            deltax = 1;
        }
        if (z - pposz < 0) {
            deltaz = -1;
        }
        if (z - pposz > 0) {
            deltaz = 1;
        }
        if (deltax == 0 && deltaz == 0) {
            return false;
        }
        if (deltax != 0 && deltaz != 0) {
            return false;
        }
        Player.field_70170_p.func_72956_a((Entity)Player, "random.explode", 1.0f, 1.5f);
        if (world.field_72995_K) {
            return true;
        }
        for (int i = 0; i < height; ++i) {
            for (int k = 0; k < length; ++k) {
                for (int j = -width; j <= width; ++j) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax, Blocks.field_150350_a, 0, 2);
                    if (i == 0) {
                        world.func_147465_d(x + k * deltax + j * deltaz, y + i - 1, z + k * deltaz + j * deltax, (Block)Blocks.field_150349_c, 0, 2);
                    }
                }
            }
        }
        for (int k = 1; k < length - 1; ++k) {
            int i = 0;
            for (int j = -width; j <= width; ++j) {
                if (i == 1) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyRadishPlant, 0, 2);
                }
                if (i == 2) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyLettucePlant1, 0, 2);
                }
                if (i == 3) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.field_150459_bM, 0, 2);
                }
                if (i == 4) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150355_j, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.field_150347_e, 0, 2);
                }
                if (i == 5) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.field_150469_bN, 0, 2);
                }
                if (i == 6) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.field_150464_aj, 0, 2);
                }
                if (i == 7) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyTomatoPlant1, 0, 2);
                }
                if (i == 8) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150355_j, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.field_150347_e, 0, 2);
                }
                if (i == 9) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyCornPlant1, 0, 2);
                }
                if (i == 10) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, OreSpawnMain.MyStrawberryPlant, 0, 2);
                }
                if (i == 11) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.field_150347_e, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, (Block)Blocks.field_150354_m, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.field_150436_aH, 0, 2);
                }
                if (i == 12) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150355_j, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 2, z + k * deltaz + j * deltax, Blocks.field_150347_e, 0, 2);
                }
                if (i == 13) {
                    world.func_147465_d(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.field_150458_ak, 0, 2);
                    world.func_147465_d(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.field_150394_bc, 0, 2);
                }
                ++i;
            }
        }
        if (!Player.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
