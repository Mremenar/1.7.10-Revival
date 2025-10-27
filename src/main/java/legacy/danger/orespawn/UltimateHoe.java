// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class UltimateHoe extends ItemHoe
{
    public UltimateHoe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.field_77777_bU = 1;
        this.func_77656_e(3000);
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77349_p, 2);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77349_p.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77349_p, 2);
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (!par2EntityPlayer.func_82247_a(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        Block i1 = par3World.func_147439_a(par4, par5, par6);
        boolean air = par3World.func_147437_c(par4, par5 + 1, par6);
        if (par7 == 0 || !air || (i1 != Blocks.field_150349_c && i1 != Blocks.field_150346_d)) {
            return false;
        }
        final Block block = Blocks.field_150458_ak;
        par3World.func_72908_a((double)(par4 + 0.5f), (double)(par5 + 0.5f), (double)(par6 + 0.5f), block.field_149762_H.func_150495_a(), (block.field_149762_H.func_150497_c() + 1.0f) / 2.0f, block.field_149762_H.func_150494_d() * 0.8f);
        if (par3World.field_72995_K) {
            return true;
        }
        for (int j = -1; j <= 1; ++j) {
            for (int k = -1; k <= 1; ++k) {
                for (int l = -1; l <= 1; ++l) {
                    i1 = par3World.func_147439_a(par4 + j, par5 + l, par6 + k);
                    air = par3World.func_147437_c(par4 + j, par5 + l + 1, par6 + k);
                    if (air && (i1 == Blocks.field_150349_c || i1 == Blocks.field_150346_d)) {
                        par3World.func_147465_d(par4 + j, par5 + l, par6 + k, block, 7, 2);
                    }
                }
            }
        }
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par2EntityPlayer);
        return true;
    }
    
    public String getMaterialName() {
        return "Uranium/Titanium";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
