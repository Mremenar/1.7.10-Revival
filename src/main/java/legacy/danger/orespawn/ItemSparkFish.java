// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;

public class ItemSparkFish extends ItemFood
{
    public ItemSparkFish(final int par1, final int par2, final float par3, final boolean par4) {
        super(par2, par3, par4);
        this.func_77848_i();
    }
    
    public void func_77849_c(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.func_77849_c(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.field_72995_K) {
            par3EntityPlayer.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 100, 0));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
