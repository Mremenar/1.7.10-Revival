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

public class StepUp extends Item
{
    public StepUp(final int i) {
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer Player, final World world, final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9, final float par10) {
        int deltax = 0;
        int deltaz = 0;
        final int length = 33;
        final int x = cposx;
        final int y = cposy + 1;
        final int z = cposz;
        float f = Player.field_70759_as;
        f += 22.5f;
        f %= 360.0f;
        f /= 45.0f;
        switch ((int)f) {
            case 0: {
                deltax = 0;
                deltaz = 1;
                break;
            }
            case 1: {
                deltax = -1;
                deltaz = 1;
                break;
            }
            case 2: {
                deltax = -1;
                deltaz = 0;
                break;
            }
            case 3: {
                deltax = -1;
                deltaz = -1;
                break;
            }
            case 4: {
                deltax = 0;
                deltaz = -1;
                break;
            }
            case 5: {
                deltax = 1;
                deltaz = -1;
                break;
            }
            case 6: {
                deltax = 1;
                deltaz = 0;
                break;
            }
            case 7: {
                deltax = 1;
                deltaz = 1;
                break;
            }
        }
        if (deltax == 0 && deltaz == 0) {
            return false;
        }
        Player.field_70170_p.func_72956_a((Entity)Player, "random.explode", 1.0f, 1.5f);
        if (world.field_72995_K) {
            for (int var3 = 0; var3 < 6; ++var3) {
                world.func_72869_a("largesmoke", (double)(x + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(y + world.field_73012_v.nextFloat() + 1.0f), (double)(z + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                world.func_72869_a("largeexplode", (double)(x + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(y + world.field_73012_v.nextFloat() + 1.0f), (double)(z + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                world.func_72869_a("reddust", (double)(x + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(y + world.field_73012_v.nextFloat() + 1.0f), (double)(z + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
            }
            return true;
        }
        for (int k = 1; k < length; ++k) {
            Block bid = world.func_147439_a(x + k * deltax, y + k - 1, z + k * deltaz);
            if (bid != Blocks.field_150350_a) {
                break;
            }
            world.func_147465_d(x + k * deltax, y + k - 1, z + k * deltaz, Blocks.field_150347_e, 0, 2);
            if ((k - 1) % 8 == 0) {
                bid = world.func_147439_a(x + k * deltax, y + k, z + k * deltaz);
                if (bid == Blocks.field_150350_a) {
                    world.func_147465_d(x + k * deltax, y + k, z + k * deltaz, OreSpawnMain.ExtremeTorch, 0, 2);
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
