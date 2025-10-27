// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class IceBall extends LaserBall
{
    private int my_index;
    private int icemaker;
    
    public IceBall(final World par1World) {
        super(par1World);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }
    
    public IceBall(final World par1World, final int par2) {
        super(par1World);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }
    
    public IceBall(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }
    
    public IceBall(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }
    
    public IceBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }
    
    public int getIceBallIndex() {
        return this.my_index;
    }
    
    public void setIceMaker(final int i) {
        this.icemaker = i;
    }
    
    @Override
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null && MyUtils.isRoyalty(par1MovingObjectPosition.field_72308_g)) {
            this.func_70106_y();
            return;
        }
        super.func_70184_a(par1MovingObjectPosition);
        if (this.icemaker != 0) {
            for (int i = 0; i < 5; ++i) {
                int x = this.field_70170_p.field_73012_v.nextInt(4);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    x = -x;
                }
                int y = this.field_70170_p.field_73012_v.nextInt(4);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    y = -y;
                }
                int z = this.field_70170_p.field_73012_v.nextInt(4);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    z = -z;
                }
                x += (int)par1MovingObjectPosition.field_72307_f.field_72450_a;
                y += (int)par1MovingObjectPosition.field_72307_f.field_72448_b;
                z += (int)par1MovingObjectPosition.field_72307_f.field_72449_c;
                this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150432_aD);
            }
        }
        this.func_70106_y();
    }
}
