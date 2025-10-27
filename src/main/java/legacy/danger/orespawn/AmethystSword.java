// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class AmethystSword extends ItemSword
{
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    
    public AmethystSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 18;
        this.field_77777_bU = 1;
        this.func_77656_e(2000);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }
    
    public String getMaterialName() {
        return "Amethyst";
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving, final EntityLiving par3EntityLiving) {
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityLiving);
        return true;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 3500;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
