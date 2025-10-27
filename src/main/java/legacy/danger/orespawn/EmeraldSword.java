// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class EmeraldSword extends ItemSword
{
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    
    public EmeraldSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.field_77777_bU = 1;
        this.func_77656_e(1300);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }
    
    public String getMaterialName() {
        return "Emerald";
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving, final EntityLiving par3EntityLiving) {
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityLiving);
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
