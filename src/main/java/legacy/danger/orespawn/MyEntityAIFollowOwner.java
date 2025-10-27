// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.ai.EntityAIBase;

public class MyEntityAIFollowOwner extends EntityAIBase
{
    private EntityTameable thePet;
    private EntityLivingBase theOwner;
    World theWorld;
    private float field_75336_f;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;
    
    public MyEntityAIFollowOwner(final EntityTameable par1EntityTameable, final float par2, final float par3, final float par4) {
        this.thePet = par1EntityTameable;
        this.theWorld = par1EntityTameable.field_70170_p;
        this.field_75336_f = par2;
        this.petPathfinder = par1EntityTameable.func_70661_as();
        this.minDist = par4;
        this.maxDist = par3;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase var1 = this.thePet.func_70902_q();
        if (var1 == null) {
            return false;
        }
        this.theOwner = var1;
        return !this.thePet.func_70906_o() && (!(this.thePet instanceof Girlfriend) || OreSpawnMain.valentines_day == 0) && ((this.thePet != null && (this.thePet.field_70163_u < 60.0 || !this.thePet.field_70170_p.func_72935_r()) && this.thePet.func_70068_e((Entity)var1) > this.maxDist / 2.0f * (this.maxDist / 2.0f)) || this.thePet.func_70068_e((Entity)var1) >= this.maxDist * this.maxDist);
    }
    
    public boolean func_75253_b() {
        if (this.thePet.func_70906_o()) {
            return false;
        }
        if (this.petPathfinder.func_75500_f()) {
            return false;
        }
        if (this.thePet != null && this.thePet instanceof EntityTameable) {
            final EntityTameable gf = this.thePet;
            final EntityLivingBase var1 = gf.func_70902_q();
            if (var1 != null && (int)gf.field_70161_v == (int)var1.field_70161_v && (int)gf.field_70165_t == (int)var1.field_70165_t && (int)gf.field_70163_u < (int)var1.field_70163_u + 2 && (int)gf.field_70163_u > (int)var1.field_70163_u - 2) {
                return false;
            }
        }
        return this.thePet.func_70068_e((Entity)this.theOwner) > this.minDist * this.minDist;
    }
    
    public void func_75249_e() {
        this.field_75343_h = 0;
        this.field_75344_i = this.thePet.func_70661_as().func_75486_a();
        this.thePet.func_70661_as().func_75491_a(false);
    }
    
    public void func_75251_c() {
        this.theOwner = null;
        this.petPathfinder.func_75499_g();
        this.thePet.func_70661_as().func_75491_a(this.field_75344_i);
    }
    
    public void func_75246_d() {
        this.thePet.func_70671_ap().func_75651_a((Entity)this.theOwner, 10.0f, (float)this.thePet.func_70646_bf());
        if (!this.thePet.func_70906_o() && --this.field_75343_h <= 0) {
            this.field_75343_h = 10;
            if (!this.petPathfinder.func_75497_a((Entity)this.theOwner, (double)this.field_75336_f) && this.thePet.func_70068_e((Entity)this.theOwner) >= 144.0) {
                final int var1 = MathHelper.func_76128_c(this.theOwner.field_70165_t) - 2;
                final int var2 = MathHelper.func_76128_c(this.theOwner.field_70161_v) - 2;
                final int var3 = MathHelper.func_76128_c(this.theOwner.field_70121_D.field_72338_b);
                for (int var4 = 0; var4 <= 4; ++var4) {
                    for (int var5 = 0; var5 <= 4; ++var5) {
                        if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && World.func_147466_a((IBlockAccess)this.theWorld, var1 + var4, var3 - 1, var2 + var5) && !this.theWorld.func_147439_a(var1 + var4, var3, var2 + var5).func_149721_r() && !this.theWorld.func_147439_a(var1 + var4, var3 + 1, var2 + var5).func_149721_r()) {
                            this.thePet.func_70012_b((double)(var1 + var4 + 0.5f), (double)var3, (double)(var2 + var5 + 0.5f), this.thePet.field_70177_z, this.thePet.field_70125_A);
                            this.petPathfinder.func_75499_g();
                            return;
                        }
                    }
                }
            }
        }
    }
}
