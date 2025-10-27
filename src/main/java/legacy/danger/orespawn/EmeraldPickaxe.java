// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class EmeraldPickaxe extends ItemPickaxe
{
    private int weaponDamage;
    
    public EmeraldPickaxe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.weaponDamage = 10;
        this.field_77777_bU = 1;
        this.func_77656_e(1300);
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77348_q.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77348_q, 1);
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }
    
    public int getDamageVsEntity() {
        return this.weaponDamage;
    }
    
    public String getMaterialName() {
        return "Emerald";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
