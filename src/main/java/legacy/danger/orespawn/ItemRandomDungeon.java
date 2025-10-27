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
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Random;
import net.minecraft.item.Item;

public class ItemRandomDungeon extends Item
{
    Random rand;
    
    public ItemRandomDungeon(final int i) {
        this.rand = OreSpawnMain.OreSpawnRand;
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78028_d);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77346_s, 2);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77346_s.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77346_s, 2);
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world, final int clickedX, final int clickedY, final int clickedZ, final int par7, final float par8, final float par9, final float par10) {
        final Block var1 = world.func_147439_a(clickedX, clickedY, clickedZ);
        if (var1 != Blocks.field_150348_b && var1 != Blocks.field_150347_e && var1 != Blocks.field_150349_c && var1 != Blocks.field_150346_d) {
            return false;
        }
        if (clickedY < 40) {
            return false;
        }
        if (!world.field_72995_K) {
            world.func_147465_d(clickedX, clickedY + 1, clickedZ, OreSpawnMain.MyDungeonSpawnerBlock, 0, 2);
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
