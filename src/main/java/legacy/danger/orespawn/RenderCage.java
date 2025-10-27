// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;

public class RenderCage extends RenderSpinner
{
    @Override
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.spinItemIconIndex = 160;
        if (par1Entity instanceof EntityCage) {
            final EntityCage var2 = (EntityCage)par1Entity;
            this.spinItemIconIndex = var2.getCageIndex();
        }
        super.func_76986_a(par1Entity, par2, par4, par6, par8, par9);
    }
}
