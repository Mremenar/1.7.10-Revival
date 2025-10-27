// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityTameable;

public class MyEntityAIJealousy extends MyEntityAINearestAttackableTarget
{
    private EntityTameable theTameable;
    
    public MyEntityAIJealousy(final EntityTameable par1EntityTameable, final Class par2Class, final float par3, final int par4, final boolean par5) {
        super((EntityLiving)par1EntityTameable, par2Class, par3, par4, par5);
        this.theTameable = par1EntityTameable;
    }
    
    @Override
    public boolean func_75250_a() {
        final EntityTameable te = (EntityTameable)this.taskOwner;
        Girlfriend gf = null;
        Boyfriend bf = null;
        EntityLivingBase ep = null;
        if (te == null) {
            return false;
        }
        if (!te.func_70909_n()) {
            return false;
        }
        if (te.func_70906_o()) {
            return false;
        }
        if (!super.func_75250_a()) {
            return false;
        }
        final Entity victim = (Entity)this.targetEntity;
        if (victim == null) {
            return false;
        }
        if (te instanceof Girlfriend) {
            if (victim instanceof Girlfriend) {
                gf = (Girlfriend)victim;
                if (gf.func_70909_n()) {
                    return false;
                }
            }
        }
        else if (victim instanceof Boyfriend) {
            bf = (Boyfriend)victim;
            if (bf.func_70909_n()) {
                return false;
            }
        }
        ep = te.func_70902_q();
        return ep != null;
    }
}
