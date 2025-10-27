// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAppleSeed extends Item
{
    public ItemAppleSeed(final int i) {
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78031_c);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        if (!world.field_72995_K) {
            final Block bid = world.func_147439_a(x, y, z);
            if (bid != Blocks.field_150349_c && bid != Blocks.field_150346_d && bid != Blocks.field_150458_ak) {
                return false;
            }
            if (this == OreSpawnMain.MyAppleSeed) {
                this.makeTree(world, x, y, z, OreSpawnMain.MyAppleLeaves, null);
            }
            else if (this == OreSpawnMain.MyCherrySeed) {
                this.makeTree(world, x, y, z, OreSpawnMain.MyCherryLeaves, null);
            }
            else {
                this.makeTree(world, x, y, z, OreSpawnMain.MyPeachLeaves, null);
            }
        }
        if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        return true;
    }
    
    public void makeTree(final World world, final int x, final int y, final int z, final Block blkid, final Chunk chunk) {
        Block bid = world.func_147439_a(x, y, z);
        if (bid != Blocks.field_150349_c && bid != Blocks.field_150346_d && bid != Blocks.field_150458_ak) {
            return;
        }
        int h1 = 12;
        int h2 = 6;
        int h3 = 9;
        int h4 = 6;
        int h5 = 14;
        int w1 = 5;
        int w2 = 3;
        if (blkid == OreSpawnMain.MyPeachLeaves) {
            h1 = 10;
            h2 = 5;
            h3 = 7;
            h4 = 5;
            h5 = 12;
            w1 = 4;
            w2 = 2;
        }
        if (blkid == OreSpawnMain.MyCherryLeaves) {
            h1 = 8;
            h2 = 3;
            h3 = 5;
            h4 = 3;
            h5 = 10;
            w1 = 3;
            w2 = 1;
        }
        for (int j = 1; j < h1; ++j) {
            world.func_147465_d(x, y + j, z, Blocks.field_150364_r, 0, 2);
        }
        for (int j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x + j, y + h2, z, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x - j, y + h2, z, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x, y + h2, z + j, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x, y + h2, z - j, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x + j, y + h3, z, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x - j, y + h3, z, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x, y + h3, z + j, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            OreSpawnMain.setBlockSuperFast(world, x, y + h3, z - j, Blocks.field_150364_r, 0, 2, chunk);
        }
        for (int i = h4; i < h5; ++i) {
            int width = 6;
            if (i > 8) {
                width = 5;
            }
            if (i > 10) {
                width = 4;
            }
            if (blkid != OreSpawnMain.MyAppleLeaves) {
                --width;
            }
            for (int j = -width; j <= width; ++j) {
                for (int k = -width; k <= width; ++k) {
                    bid = world.func_147439_a(x + k, y + i, z + j);
                    if (bid == Blocks.field_150350_a) {
                        OreSpawnMain.setBlockSuperFast(world, x + k, y + i, z + j, blkid, 0, 2, chunk);
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
