// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UltimateBow extends Item
{
    public UltimateBow(final int par1) {
        this.field_77777_bU = 1;
        this.func_77656_e(1000);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77345_t, 5);
        par1ItemStack.func_77966_a(Enchantment.field_77343_v, 3);
        par1ItemStack.func_77966_a(Enchantment.field_77344_u, 2);
        par1ItemStack.func_77966_a(Enchantment.field_77342_w, 1);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77345_t, 5);
            stack.func_77966_a(Enchantment.field_77343_v, 3);
            stack.func_77966_a(Enchantment.field_77344_u, 2);
            stack.func_77966_a(Enchantment.field_77342_w, 1);
        }
    }
    
    public void func_77615_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        final EntityArrow var8 = new UltimateArrow(par2World, par3EntityPlayer, 3.0f);
        if (par2World.field_73012_v.nextInt(4) == 1) {
            var8.func_70243_d(true);
        }
        final int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, par1ItemStack);
        if (var9 > 0) {
            var8.func_70240_a(var9);
        }
        if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, par1ItemStack) > 0) {
            var8.func_70015_d(100);
        }
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
        par2World.func_72956_a((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (UltimateBow.field_77697_d.nextFloat() * 0.4f + 1.2f) + 0.5f);
        var8.field_70251_a = 2;
        if (!par2World.field_72995_K) {
            par2World.func_72838_d((Entity)var8);
        }
    }
    
    public ItemStack onFoodEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 9000;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        return par1ItemStack;
    }
    
    public int func_77619_b() {
        return 50;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
