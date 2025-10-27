// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;

final class DispenserBehaviorOreSpawnEgg extends BehaviorDefaultDispenseItem
{
    public ItemStack func_82487_b(final IBlockSource par1IBlockSource, final ItemStack par2ItemStack) {
        final EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.func_82620_h());
        final double d0 = par1IBlockSource.func_82615_a() + enumfacing.func_82601_c() * 2.0;
        final double d2 = par1IBlockSource.func_82622_e() + 0.2f;
        final double d3 = par1IBlockSource.func_82616_c() + enumfacing.func_82599_e() * 2.0;
        final Item it = par2ItemStack.func_77973_b();
        if (it instanceof ItemSpawnEgg) {
            final ItemSpawnEgg ise = (ItemSpawnEgg)it;
            final Entity entity = ItemSpawnEgg.spawn_something(ise.my_id, par1IBlockSource.func_82618_k(), (int)d0, (int)d2, (int)d3);
            if (entity instanceof EntityLivingBase && par2ItemStack.func_82837_s()) {
                ((EntityLiving)entity).func_94058_c(par2ItemStack.func_82833_r());
            }
        }
        par2ItemStack.func_77979_a(1);
        return par2ItemStack;
    }
}
