// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class PoisonSword extends ItemSword
{
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    
    public PoisonSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.field_77777_bU = 1;
        this.func_77656_e(1300);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77338_j, 1);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77338_j.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77338_j, 1);
        }
    }
    
    public String getMaterialName() {
        return "Emerald";
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        int var2 = 5;
        if (par2EntityLiving != null) {
            var2 = 10 + par2EntityLiving.field_70170_p.field_73012_v.nextInt(10);
            par2EntityLiving.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, var2 * 20, 0));
            var2 = 10 + par2EntityLiving.field_70170_p.field_73012_v.nextInt(10);
            par2EntityLiving.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, var2 * 20, 0));
            var2 = 10 + par2EntityLiving.field_70170_p.field_73012_v.nextInt(10);
            par2EntityLiving.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, var2 * 20, 0));
        }
        par1ItemStack.func_77972_a(1, par3EntityLiving);
        return true;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 3000;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
