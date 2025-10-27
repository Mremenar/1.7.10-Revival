// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class InstantShelter extends Item
{
    public InstantShelter(final int i) {
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78028_d);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer Player, final World world, final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9, final float par10) {
        int deltax = 0;
        int deltaz = 0;
        final int bid = 0;
        int dirx = 0;
        int dirz = 0;
        int stuffdir = 0;
        final int width;
        final int length = width = 3;
        final int height = 3;
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
        int x = cposx;
        final int y = pposy - 1;
        int z = cposz;
        if (x - pposx < 0) {
            deltax = -1;
            stuffdir = 3;
        }
        if (x - pposx > 0) {
            deltax = 1;
            stuffdir = 2;
        }
        if (z - pposz < 0) {
            deltaz = -1;
            stuffdir = 5;
        }
        if (z - pposz > 0) {
            deltaz = 1;
            stuffdir = 4;
        }
        if (deltax == 0 && deltaz == 0) {
            return false;
        }
        if (deltax != 0 && deltaz != 0) {
            return false;
        }
        x = pposx;
        z = pposz;
        Player.field_70170_p.func_72956_a((Entity)Player, "random.explode", 1.0f, 1.5f);
        if (world.field_72995_K) {
            return true;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k <= height + 1; ++k) {
                    if (k == height + 1) {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150344_f);
                    }
                    else if (k == 0) {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150347_e);
                    }
                    else if (i == width || j == length || i == -width || j == -length) {
                        if (k == height) {
                            world.func_147449_b(x + i, y + k, z + j, Blocks.field_150359_w);
                        }
                        else if ((k == 1 || k == 2) && i == deltax * width && j == deltaz * length) {
                            world.func_147449_b(x + i, y + k, z + j, Blocks.field_150350_a);
                        }
                        else {
                            world.func_147449_b(x + i, y + k, z + j, Blocks.field_150344_f);
                        }
                    }
                    else {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150350_a);
                    }
                }
            }
        }
        int i = 2;
        int k = 1;
        int j = length - 1;
        world.func_147449_b(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.field_150460_al);
        world.func_72921_c(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        i = 1;
        world.func_147449_b(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.field_150462_ai);
        i = 0;
        world.func_147449_b(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)Blocks.field_150486_ae);
        world.func_72921_c(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        final TileEntityChest chest = (TileEntityChest)world.func_147438_o(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
        if (chest != null) {
            chest.func_70299_a(0, new ItemStack(Items.field_151111_aL));
            chest.func_70299_a(1, new ItemStack((Item)Items.field_151148_bJ));
            chest.func_70299_a(2, new ItemStack(Items.field_151147_al, 8));
            chest.func_70299_a(3, new ItemStack(Blocks.field_150478_aa, 32));
            chest.func_70299_a(4, new ItemStack(Items.field_151044_h, 16));
            chest.func_70299_a(5, new ItemStack(Items.field_151104_aV));
            chest.func_70299_a(6, new ItemStack(Items.field_151104_aV));
            chest.func_70299_a(7, new ItemStack(Items.field_151135_aq));
            chest.func_70299_a(8, new ItemStack(Items.field_151035_b));
            chest.func_70299_a(9, new ItemStack(Items.field_151040_l));
            chest.func_70299_a(10, new ItemStack(Items.field_151036_c));
            chest.func_70299_a(11, new ItemStack(Items.field_151133_ar));
            chest.func_70299_a(12, new ItemStack(OreSpawnMain.MyOreSaltBlock, 4));
            chest.func_70299_a(13, new ItemStack((Block)Blocks.field_150486_ae));
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
