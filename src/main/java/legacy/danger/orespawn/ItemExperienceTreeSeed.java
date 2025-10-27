// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemExperienceTreeSeed extends Item
{
    public ItemExperienceTreeSeed(final int i) {
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78031_c);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        if (!world.field_72995_K) {
            final Block bid = world.func_147439_a(x, y, z);
            if (bid != Blocks.field_150349_c && bid != Blocks.field_150346_d && bid != Blocks.field_150458_ak) {
                return false;
            }
            world.func_147465_d(x, y + 1, z, OreSpawnMain.MyExperiencePlant, 0, 2);
        }
        else {
            for (int j1 = 0; j1 < 10; ++j1) {
                world.func_72869_a("happyVillager", (double)(x + world.field_73012_v.nextFloat()), y + 1.0 + world.field_73012_v.nextFloat(), (double)(z + world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
            }
        }
        if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
