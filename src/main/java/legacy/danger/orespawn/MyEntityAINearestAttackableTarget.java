// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.Iterator;
import net.minecraft.entity.EntityLivingBase;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.Entity;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityLiving;

public class MyEntityAINearestAttackableTarget extends MyEntityAITarget
{
    EntityLiving targetEntity;
    Class targetClass;
    int targetChance;
    private final IEntitySelector field_82643_g;
    private MyEntityAINearestAttackableTargetSorter theNearestAttackableTargetSorter;
    
    public MyEntityAINearestAttackableTarget(final EntityLiving par1EntityLiving, final Class par2Class, final float par3, final int par4, final boolean par5) {
        this(par1EntityLiving, par2Class, par3, par4, par5, false);
    }
    
    public MyEntityAINearestAttackableTarget(final EntityLiving par1EntityLiving, final Class par2Class, final float par3, final int par4, final boolean par5, final boolean par6) {
        this(par1EntityLiving, par2Class, par3, par4, par5, par6, null);
    }
    
    public MyEntityAINearestAttackableTarget(final EntityLiving par1, final Class par2, final float par3, final int par4, final boolean par5, final boolean par6, final IEntitySelector par7IEntitySelector) {
        super(par1, par3, par5, par6);
        this.targetClass = par2;
        this.targetDistance = par3;
        this.targetChance = par4;
        this.theNearestAttackableTargetSorter = new MyEntityAINearestAttackableTargetSorter(this, (Entity)par1);
        this.field_82643_g = par7IEntitySelector;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        if (this.taskOwner instanceof EntityTameable && !((EntityTameable)this.taskOwner).func_70909_n()) {
            return false;
        }
        if (this.taskOwner instanceof Girlfriend && !((Girlfriend)this.taskOwner).func_70909_n()) {
            return false;
        }
        if (this.taskOwner instanceof Girlfriend && ((Girlfriend)this.taskOwner).func_70906_o()) {
            return false;
        }
        if (this.targetChance > 0 && this.taskOwner.func_70681_au().nextInt(100) > this.targetChance) {
            return false;
        }
        final List var5 = this.taskOwner.field_70170_p.func_82733_a(this.targetClass, this.taskOwner.field_70121_D.func_72314_b((double)this.targetDistance, 4.0, (double)this.targetDistance), this.field_82643_g);
        Collections.sort((List<Object>)var5, this.theNearestAttackableTargetSorter);
        for (final Entity var7 : var5) {
            final EntityLiving var8 = (EntityLiving)var7;
            if (this.isSuitableTarget((EntityLivingBase)var8, false)) {
                this.targetEntity = var8;
                return true;
            }
        }
        this.targetEntity = null;
        return false;
    }
    
    @Override
    public void func_75249_e() {
        this.taskOwner.func_70624_b((EntityLivingBase)this.targetEntity);
        super.func_75249_e();
    }
}
