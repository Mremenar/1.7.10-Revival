// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class Whale extends EntityAnimal
{
    private float moveSpeed;
    private int spray;
    private int spray_timer;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Whale(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.35f;
        this.spray = 0;
        this.spray_timer = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(1.5f, 2.5f);
        this.moveSpeed = 0.35f;
        this.field_70174_ab = 100;
        this.field_70728_aV = 40;
        this.func_70661_as().func_75491_a(false);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158, Items.field_151115_aP, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 12.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.spray == 0) {
            if (this.spray_timer > 0) {
                --this.spray_timer;
            }
            if (this.spray_timer == 0) {
                this.spray_timer = 250 + this.field_70170_p.field_73012_v.nextInt(250);
                this.spray = 25 + this.field_70170_p.field_73012_v.nextInt(25);
            }
        }
        if (this.field_70170_p.field_72995_K && this.spray > 0) {
            for (int i = 0; i < 20; ++i) {
                double d = this.field_70170_p.field_73012_v.nextDouble() * 0.75;
                d *= d;
                double dir = this.field_70170_p.field_73012_v.nextDouble() * 2.0 * 3.141592653589793;
                dir -= 3.141592653589793;
                final double dx = Math.cos(dir) * d / 2.0;
                final double dz = Math.sin(dir) * d / 2.0;
                dir += 1.5707963267948966;
                if (i < 10) {
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t + dx, this.field_70163_u + 1.0 + d, this.field_70161_v + dz, Math.cos(dir) * this.field_70170_p.field_73012_v.nextFloat() / 4.0, (double)(this.field_70170_p.field_73012_v.nextFloat() * 2.0f), Math.sin(dir) * this.field_70170_p.field_73012_v.nextFloat() / 4.0);
                }
                else {
                    this.field_70170_p.func_72869_a("splash", this.field_70165_t + dx, this.field_70163_u + 1.0 + d, this.field_70161_v + dz, Math.cos(dir) * this.field_70170_p.field_73012_v.nextFloat() / 4.0, (double)(this.field_70170_p.field_73012_v.nextFloat() * 2.0f), Math.sin(dir) * this.field_70170_p.field_73012_v.nextFloat() / 4.0);
                }
            }
            --this.spray;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70691_i(1.0f);
        }
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 100;
    }
    
    protected String func_70639_aQ() {
        return "splash";
    }
    
    protected String func_70621_aR() {
        return "orespawn:little_splat";
    }
    
    protected String func_70673_aS() {
        return "orespawn:big_splat";
    }
    
    protected float func_70599_aP() {
        return 0.9f;
    }
    
    protected float func_70647_i() {
        return 0.5f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151115_aP;
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        var3 = this.field_70146_Z.nextInt(25);
        var3 += 20;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItemRand(Items.field_151115_aP, 1);
        }
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
    
    protected void func_70629_bd() {
        super.func_70629_bd();
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (!this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(20) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 11; ++i) {
                int j = i;
                if (j > 4) {
                    j = 4;
                }
                if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.func_70661_as().func_75492_a((double)this.tx, (double)(this.ty - 1), (double)this.tz, 1.0);
            }
            else {
                if (this.field_70170_p.field_73012_v.nextInt(25) == 1) {
                    this.func_70691_i(-4.0f);
                }
                if (this.func_110143_aJ() <= 0.0f) {
                    this.func_70106_y();
                    return;
                }
            }
        }
        if (this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(50) == 0) {
            this.func_85030_a("splash", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
            this.func_70691_i(1.0f);
        }
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Whale.class, this.field_70121_D.func_72314_b(32.0, 8.0, 32.0));
        return var5.size();
    }
    
    public boolean func_70601_bi() {
        return this.field_70163_u >= 50.0 && this.field_70170_p.func_72935_r() && this.field_70170_p.field_73012_v.nextInt(50) == 1 && this.findBuddies() <= 0;
    }
    
    protected boolean func_70692_ba() {
        if (this.func_70631_g_()) {
            this.func_110163_bv();
            return false;
        }
        return !this.func_104002_bU();
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public Whale spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Whale(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151115_aP;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}
