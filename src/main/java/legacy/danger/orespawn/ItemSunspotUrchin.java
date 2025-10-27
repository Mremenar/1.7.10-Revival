// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSunspotUrchin extends Item
{
    public ItemSunspotUrchin(final int i) {
        this.field_77777_bU = 64;
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        par2World.func_72956_a((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (ItemSunspotUrchin.field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!par2World.field_72995_K) {
            par2World.func_72838_d((Entity)new SunspotUrchin(par2World, (EntityLivingBase)par3EntityPlayer));
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
