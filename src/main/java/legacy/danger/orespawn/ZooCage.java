// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ZooCage extends Item
{
    private int cage_size;
    
    public ZooCage(final int i, final int j) {
        this.cage_size = 2;
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78031_c);
        this.cage_size = j;
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer Player, final World world, final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9, final float par10) {
        final int bid = 0;
        int dirx = 0;
        int dirz = 0;
        final int length;
        final int height;
        final int width = height = (length = this.cage_size / 2 + 1);
        if (cposx < 0) {
            dirx = -1;
        }
        if (cposz < 0) {
            dirz = -1;
        }
        final int x = (int)(Player.field_70165_t + 0.99 * dirx);
        final int y = (int)Player.field_70163_u - 1;
        final int z = (int)(Player.field_70161_v + 0.99 * dirz);
        Player.field_70170_p.func_72956_a((Entity)Player, "random.explode", 1.0f, 1.5f);
        if (world.field_72995_K) {
            return true;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k <= height + 1; ++k) {
                    if (k == height + 1) {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150371_ca);
                    }
                    else if (k == 0) {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150371_ca);
                    }
                    else if (i == width || j == length || i == -width || j == -length) {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150359_w);
                    }
                    else {
                        world.func_147449_b(x + i, y + k, z + j, Blocks.field_150350_a);
                    }
                }
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
