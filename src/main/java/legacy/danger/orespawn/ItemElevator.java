// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemElevator extends Item
{
    public ItemElevator(final int par1) {
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78029_e);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.field_72995_K) {
            return true;
        }
        final Elevator elevator = (Elevator)EntityList.func_75620_a("Hoverboard", par3World);
        elevator.func_70012_b((double)(par4 + 0.5f), (double)(par5 + 1.2f), (double)(par6 + 0.5f), par3World.field_73012_v.nextFloat() * 360.0f, 0.0f);
        par3World.func_72838_d((Entity)elevator);
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
