// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityItem;

public class EntityLavaLovingItem extends EntityItem
{
    public EntityLavaLovingItem(final World par1World, final double par2, final double par4, final double par6, final ItemStack par8ItemStack) {
        super(par1World, par2, par4, par6, par8ItemStack);
        this.field_70174_ab = 300;
        this.field_70178_ae = true;
        this.field_70172_ad = 300;
    }
    
    public void noFire() {
        this.field_70174_ab = 300;
        this.field_70178_ae = true;
        this.field_70172_ad = 300;
    }
    
    public void yesFire() {
        this.field_70174_ab = 0;
        this.field_70178_ae = false;
        this.field_70172_ad = 0;
    }
    
    protected void dealFireDamage(final float par1) {
        if (!this.field_70178_ae) {
            this.func_70097_a(DamageSource.field_76372_a, par1);
        }
    }
}
