// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SkateBow extends Item
{
    public SkateBow(final int par1) {
        this.field_77777_bU = 1;
        this.func_77656_e(300);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
    }
    
    public void func_77615_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        final int var6 = this.func_77626_a(par1ItemStack) - par4;
        final boolean flag = par3EntityPlayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, par1ItemStack) > 0;
        if (flag || par3EntityPlayer.field_71071_by.func_146028_b(OreSpawnMain.MyIrukandjiArrow)) {
            float f = var6 / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.75f) {
                f = 1.75f;
            }
            final IrukandjiArrow var7 = new IrukandjiArrow(par2World, par3EntityPlayer, f);
            if (par2World.field_73012_v.nextInt(20) == 1) {
                var7.func_70243_d(true);
            }
            final int var8 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, par1ItemStack);
            if (var8 > 0) {
                var7.func_70240_a(var8);
            }
            if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, par1ItemStack) > 0) {
                var7.func_70015_d(100);
            }
            par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
            par2World.func_72956_a((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (SkateBow.field_77697_d.nextFloat() * 0.4f + 1.2f) + 0.5f);
            if (!flag) {
                par3EntityPlayer.field_71071_by.func_146026_a(OreSpawnMain.MyIrukandjiArrow);
            }
            if (!par2World.field_72995_K) {
                par2World.func_72838_d((Entity)var7);
            }
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
