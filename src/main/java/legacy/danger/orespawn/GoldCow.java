// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class GoldCow extends RedCow
{
    public GoldCow(final World world) {
        super(world);
    }
    
    @Override
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151034_e, 1);
        }
        this.func_145779_a(Items.field_151153_ao, 1);
        super.func_70628_a(par1, par2);
    }
    
    @Override
    public EntityCow func_90011_a(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }
    
    @Override
    public GoldCow spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new GoldCow(this.field_70170_p);
    }
}
