// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class RubyPickaxe extends ItemPickaxe
{
    private int weaponDamage;
    
    public RubyPickaxe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.weaponDamage = 12;
        this.field_77777_bU = 1;
        this.func_77656_e(1500);
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }
    
    public int getDamageVsEntity() {
        return this.weaponDamage;
    }
    
    public String getMaterialName() {
        return "Ruby";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
