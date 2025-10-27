// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityCow;

public class RedCow extends EntityCow
{
    public RedCow(final World world) {
        super(world);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151034_e, 1);
        }
        super.func_70628_a(par1, par2);
    }
    
    public EntityCow func_90011_a(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }
    
    public RedCow spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new RedCow(this.field_70170_p);
    }
    
    protected void func_70629_bd() {
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        super.func_70629_bd();
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
}
