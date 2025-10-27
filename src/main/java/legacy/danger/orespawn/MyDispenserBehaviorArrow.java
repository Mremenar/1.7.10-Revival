// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.IProjectile;
import net.minecraft.dispenser.IPosition;
import net.minecraft.world.World;
import net.minecraft.dispenser.BehaviorProjectileDispense;

final class MyDispenserBehaviorArrow extends BehaviorProjectileDispense
{
    protected IProjectile func_82499_a(final World par1World, final IPosition par2IPosition) {
        final IrukandjiArrow entityarrow = new IrukandjiArrow(par1World, par2IPosition.func_82615_a(), par2IPosition.func_82617_b(), par2IPosition.func_82616_c());
        entityarrow.field_70251_a = 1;
        return (IProjectile)entityarrow;
    }
}
