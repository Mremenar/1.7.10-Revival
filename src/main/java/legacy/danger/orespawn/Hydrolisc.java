// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityTameable;

public class Hydrolisc extends EntityTameable
{
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Hydrolisc(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.25f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(0.5f, 0.5f);
        this.field_70174_ab = 100;
        this.func_70661_as().func_75491_a(false);
        this.func_70904_g(false);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMob.class, 8.0f, 1.0, 1.399999976158142));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.2f, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151115_aP, false));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.field_70728_aV = 5;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_70904_g(false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
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
    
    protected void func_70069_a(final float par1) {
        float i = (float)MathHelper.func_76123_f(par1 - 3.0f);
        if (i > 0.0f) {
            if (i > 3.0f) {
                this.func_85030_a("damage.fallbig", 1.0f, 1.0f);
            }
            else {
                this.func_85030_a("damage.fallsmall", 1.0f, 1.0f);
            }
            if (i > 2.0f) {
                i = 2.0f;
            }
            this.func_70097_a(DamageSource.field_76379_h, i);
        }
    }
    
    public int func_70658_aO() {
        return 10;
    }
    
    protected void func_70629_bd() {
        super.func_70629_bd();
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (!this.func_70906_o() && ((this.field_70170_p.field_73012_v.nextInt(20) == 0 && this.getHydroHealth() < this.func_110138_aP()) || this.field_70170_p.field_73012_v.nextInt(100) == 0)) {
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
                if (this.func_70090_H()) {
                    this.func_70691_i(1.0f);
                    this.func_85030_a("splash", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(10) == 0 && this.func_70909_n()) {
            final EntityLivingBase e = this.func_70902_q();
            if (e != null && e.func_110143_aJ() < e.func_110138_aP() && this.getHydroHealth() > 20) {
                e.func_70691_i(1.0f);
                this.func_70691_i(-1.0f);
            }
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
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.func_70090_H()) {
            this.field_70181_x += 0.04;
        }
    }
    
    public int getHydroHealth() {
        return (int)this.func_110143_aJ();
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (super.func_70085_c(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151115_aP && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70909_n()) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.func_70903_f(true);
                        this.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                        this.func_70908_e(true);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                        this.func_70691_i(this.func_110138_aP() - this.func_110143_aJ());
                    }
                    else {
                        this.func_70908_e(false);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                    }
                }
            }
            else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (this.func_110138_aP() > this.func_110143_aJ()) {
                    this.func_70691_i(this.func_110138_aP() - this.func_110143_aJ());
                }
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = var2;
                --itemStack.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Item.func_150898_a((Block)Blocks.field_150330_I) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70903_f(false);
                this.func_152115_b("");
                this.func_70908_e(false);
                this.field_70170_p.func_72960_a((Entity)this, (byte)6);
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack2 = var2;
                --itemStack2.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.func_94058_c(var2.func_82833_r());
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack3 = var2;
                --itemStack3.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.func_70906_o()) {
                this.func_70904_g(true);
            }
            else {
                this.func_70904_g(false);
            }
            return true;
        }
        return false;
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151115_aP;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:cryo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:cryo_death";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151115_aP;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.func_70909_n()) {
            var3 = this.field_70146_Z.nextInt(5);
            var3 += 2;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.func_145779_a(Items.field_151115_aP, 1);
            }
        }
    }
    
    protected float func_70647_i() {
        return this.func_70631_g_() ? ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.5f) : ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.0f);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float p2 = par2;
        if (p2 > 10.0f) {
            p2 = 10.0f;
        }
        ret = super.func_70097_a(par1DamageSource, p2);
        return ret;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public Hydrolisc spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Hydrolisc(this.field_70170_p);
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}
