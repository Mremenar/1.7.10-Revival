// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class EntityMosquito extends EntityAmbientCreature
{
    private ChunkCoordinates currentFlightTarget;
    
    public EntityMosquito(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.func_70105_a(0.2f, 0.2f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 5;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.10000000149011612);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected float func_70647_i() {
        return 1.5f;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:mosquito";
    }
    
    protected String func_70621_aR() {
        return null;
    }
    
    protected String func_70673_aS() {
        return null;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
    
    public int mygetMaxHealth() {
        return 2;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6000000238418579;
    }
    
    protected void func_70619_bc() {
        int keep_trying = 50;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70146_Z.nextInt(20) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 3.0f) {
            EntityPlayer target = null;
            if (OreSpawnMain.OreSpawnRand.nextInt(4) == 0) {
                target = (EntityPlayer)this.field_70170_p.func_72857_a((Class)EntityPlayer.class, this.field_70121_D.func_72314_b(10.0, 6.0, 10.0), (Entity)this);
                if (target != null) {
                    this.currentFlightTarget.func_71571_b((int)target.field_70165_t, (int)target.field_70163_u + 2, (int)target.field_70161_v);
                }
                else {
                    for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c), --keep_trying) {
                        this.currentFlightTarget.func_71571_b((int)this.field_70165_t + this.field_70146_Z.nextInt(6) - this.field_70146_Z.nextInt(6), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(6) - this.field_70146_Z.nextInt(6));
                    }
                }
            }
            else {
                for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c), --keep_trying) {
                    this.currentFlightTarget.func_71571_b((int)this.field_70165_t + this.field_70146_Z.nextInt(6) - this.field_70146_Z.nextInt(6), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(6) - this.field_70146_Z.nextInt(6));
                }
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.5 - this.field_70159_w) * 0.10000000149011612;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * 0.10000000149011612;
        this.field_70179_y += (Math.signum(var3) * 0.5 - this.field_70179_y) * 0.10000000149011612;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.3f;
        this.field_70177_z += var5;
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70601_bi() {
        return true;
    }
    
    public void initCreature() {
    }
}
