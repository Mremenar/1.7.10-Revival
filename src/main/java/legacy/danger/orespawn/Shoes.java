// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class Shoes extends EntityThrowable
{
    public int ShoeId;
    private float my_rotation;
    
    public Shoes(final World par1World) {
        super(par1World);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.field_70146_Z.nextInt(4) + 2;
        this.field_70180_af.func_75682_a(20, (Object)this.ShoeId);
    }
    
    public Shoes(final World par1World, final int par2) {
        super(par1World);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = par2;
        this.field_70180_af.func_75682_a(20, (Object)this.ShoeId);
    }
    
    public Shoes(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.field_70146_Z.nextInt(4) + 2;
        this.field_70180_af.func_75682_a(20, (Object)this.ShoeId);
    }
    
    public Shoes(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = par3;
        this.field_70180_af.func_75682_a(20, (Object)this.ShoeId);
    }
    
    public Shoes(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.field_70146_Z.nextInt(4) + 2;
        this.field_70180_af.func_75682_a(20, (Object)this.ShoeId);
    }
    
    public int getShoeId() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null) {
            float var2 = 2.0f;
            if (this.getShoeId() == 6) {
                var2 = 6.0f;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof EntityCreeper) {
                var2 += 4.0f;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof Girlfriend) {
                var2 = 1.0f;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof Boyfriend) {
                var2 = 1.0f;
            }
            if (par1MovingObjectPosition.field_72308_g instanceof EntityPlayer) {
                var2 = 0.0f;
            }
            if (OreSpawnMain.valentines_day != 0) {
                var2 = 10.0f;
            }
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), var2);
        }
        for (int var3 = 0; var3 < 4; ++var3) {
            this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("reddust", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.my_rotation += 20.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.field_70127_C = my_rotation;
        this.field_70125_A = my_rotation;
    }
}
