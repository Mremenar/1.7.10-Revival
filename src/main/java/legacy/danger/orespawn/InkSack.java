// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class InkSack extends EntityThrowable
{
    private float my_rotation;
    private int my_index;
    
    public InkSack(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }
    
    public InkSack(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }
    
    public InkSack(final World par1World, final EntityLiving par2EntityLiving) {
        super(par1World, (EntityLivingBase)par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }
    
    public InkSack(final World par1World, final EntityLiving par2EntityLiving, final int par3) {
        super(par1World, (EntityLivingBase)par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }
    
    public InkSack(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }
    
    public int getInkSackIndex() {
        return this.my_index;
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null) {
            float var2 = 1.0f;
            if (par1MovingObjectPosition.field_72308_g instanceof EntityCreeper) {
                var2 = 4.0f;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof WaterDragon) {
                return;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof AttackSquid) {
                return;
            }
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), var2);
            if (par1MovingObjectPosition.field_72308_g instanceof EntityLivingBase && this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                ((EntityLivingBase)par1MovingObjectPosition.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 100 + 50 * this.field_70170_p.field_73012_v.nextInt(8), 0));
            }
        }
        for (int var3 = 0; var3 < 4; ++var3) {
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70161_v + this.field_70146_Z.nextFloat(), 0.0, 0.0, 0.0);
        }
        this.func_85030_a("random.splash", 0.5f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f);
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.my_rotation += 30.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.field_70127_C = my_rotation;
        this.field_70125_A = my_rotation;
    }
}
