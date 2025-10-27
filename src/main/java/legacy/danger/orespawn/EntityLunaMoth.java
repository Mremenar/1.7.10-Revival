// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;

public class EntityLunaMoth extends EntityButterfly
{
    private ChunkCoordinates currentFlightTarget;
    public int moth_type;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public EntityLunaMoth(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.moth_type = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moth_type = OreSpawnMain.OreSpawnRand.nextInt(4);
        this.func_70105_a(0.5f, 0.5f);
        this.func_70661_as().func_75491_a(true);
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.10000000149011612);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    @Override
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    @Override
    protected boolean func_70650_aV() {
        return true;
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6;
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x - dx, y + i, z + j);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x - dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + i, y + dy, z + j);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x + i, y - dy, z + j);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y - dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dy; j <= dy; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + i, y + j, z + dz);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z + dz;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x + i, y + j, z - dz);
                if (bid == Blocks.field_150478_aa || bid == OreSpawnMain.ExtremeTorch) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z - dz;
                        ++found;
                    }
                }
            }
        }
        return found != 0;
    }
    
    @Override
    protected void func_70619_bc() {
        int keep_trying = 25;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70146_Z.nextInt(100) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.0f) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c), --keep_trying) {
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + this.field_70146_Z.nextInt(10) - this.field_70146_Z.nextInt(10), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(10) - this.field_70146_Z.nextInt(10));
            }
        }
        else if (!this.field_70170_p.func_72935_r() && this.field_70146_Z.nextInt(10) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 2; i < 15 && !this.scan_it((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, i, i, i); ++i) {
                if (i >= 6) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.currentFlightTarget.func_71571_b(this.tx, this.ty + 1, this.tz);
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.5 - this.field_70159_w) * 0.10000000149011612;
        this.field_70181_x += (Math.signum(var2) * 0.68 - this.field_70181_x) * 0.10000000149011612;
        this.field_70179_y += (Math.signum(var3) * 0.5 - this.field_70179_y) * 0.10000000149011612;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.75f;
        this.field_70177_z += var5;
    }
    
    @Override
    protected void func_70069_a(final float par1) {
    }
    
    @Override
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    @Override
    public boolean func_145773_az() {
        return true;
    }
    
    @Override
    public boolean func_70601_bi() {
        final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        return bid == Blocks.field_150350_a && !this.field_70170_p.func_72935_r() && (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID4 || this.field_70163_u >= 50.0);
    }
    
    @Override
    public void initCreature() {
    }
}
