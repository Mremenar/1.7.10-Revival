// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class RatSword extends ItemSword
{
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    
    public RatSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.field_77777_bU = 1;
        this.func_77656_e(1300);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public String getMaterialName() {
        return "Rat";
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        final int var2 = 5;
        if (par2EntityLiving != null && !par2EntityLiving.field_70170_p.field_72995_K) {
            for (int num = 1 + par2EntityLiving.field_70170_p.field_73012_v.nextInt(6), i = 0; i < num; ++i) {
                Rat r = null;
                r = (Rat)spawnCreature(par2EntityLiving.field_70170_p, 0, "Rat", par2EntityLiving.field_70165_t + (par2EntityLiving.field_70170_p.field_73012_v.nextFloat() - par2EntityLiving.field_70170_p.field_73012_v.nextFloat()) * 0.5, par2EntityLiving.field_70163_u + par2EntityLiving.field_70170_p.field_73012_v.nextFloat() + 0.01, par2EntityLiving.field_70161_v + (par2EntityLiving.field_70170_p.field_73012_v.nextFloat() - par2EntityLiving.field_70170_p.field_73012_v.nextFloat()) * 0.5);
                if (r != null) {
                    r.setOwner(par3EntityLiving);
                }
            }
        }
        par1ItemStack.func_77972_a(1, par3EntityLiving);
        return true;
    }
    
    public static Entity spawnCreature(final World par0World, final int par1, final String name, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        if (name == null) {
            var8 = EntityList.func_75616_a(par1, par0World);
        }
        else {
            var8 = EntityList.func_75620_a(name, par0World);
        }
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 3000;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
