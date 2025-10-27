// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.IProjectile;
import net.minecraft.util.EnumFacing;
import net.minecraft.dispenser.IPosition;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.BehaviorProjectileDispense;

final class MyDispenserBehaviorRock extends BehaviorProjectileDispense
{
    public ItemStack func_82487_b(final IBlockSource par1IBlockSource, final ItemStack par2ItemStack) {
        final World world = par1IBlockSource.func_82618_k();
        final IPosition iposition = BlockDispenser.func_149939_a(par1IBlockSource);
        final EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.func_82620_h());
        final IProjectile iprojectile = this.func_82499_a(world, iposition);
        iprojectile.func_70186_c((double)enumfacing.func_82601_c(), (double)(enumfacing.func_96559_d() + 0.1f), (double)enumfacing.func_82599_e(), this.func_82500_b(), this.func_82498_a());
        final EntityThrownRock r = (EntityThrownRock)iprojectile;
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MySmallRock) {
            r.setRockType(1);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyRock) {
            r.setRockType(2);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyRedRock) {
            r.setRockType(3);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyGreenRock) {
            r.setRockType(4);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyBlueRock) {
            r.setRockType(5);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyPurpleRock) {
            r.setRockType(6);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MySpikeyRock) {
            r.setRockType(7);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyTNTRock) {
            r.setRockType(8);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyCrystalRedRock) {
            r.setRockType(9);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyCrystalGreenRock) {
            r.setRockType(10);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyCrystalBlueRock) {
            r.setRockType(11);
        }
        if (par2ItemStack.func_77973_b() == OreSpawnMain.MyCrystalTNTRock) {
            r.setRockType(12);
        }
        world.func_72838_d((Entity)iprojectile);
        par2ItemStack.func_77979_a(1);
        return par2ItemStack;
    }
    
    protected IProjectile func_82499_a(final World par1World, final IPosition par2IPosition) {
        final EntityThrownRock entityarrow = new EntityThrownRock(par1World, par2IPosition.func_82615_a(), par2IPosition.func_82617_b(), par2IPosition.func_82616_c());
        return (IProjectile)entityarrow;
    }
}
