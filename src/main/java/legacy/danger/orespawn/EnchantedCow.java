// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EnchantedCow extends RedCow
{
    public EnchantedCow(final World world) {
        super(world);
    }
    
    private void dropEnchantedGoldenApple() {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, new ItemStack(Items.field_151153_ao, 1, 1));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    @Override
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(4) + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151034_e, 1);
        }
        this.func_145779_a(Items.field_151153_ao, 2);
        this.dropEnchantedGoldenApple();
        super.func_70628_a(par1, par2);
    }
    
    @Override
    public EntityCow func_90011_a(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }
    
    @Override
    public EnchantedCow spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new EnchantedCow(this.field_70170_p);
    }
}
