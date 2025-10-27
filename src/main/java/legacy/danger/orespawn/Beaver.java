// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class Beaver extends EntityAnimal
{
    private float moveSpeed;
    private GenericTargetSorter TargetSorter;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Beaver(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.15f;
        this.TargetSorter = null;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(0.6f, 0.8f);
        this.moveSpeed = 0.2f;
        this.field_70174_ab = 100;
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 5;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMob.class, 8.0f, 1.0, 1.5));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 8.0f, 1.0, 1.5));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public boolean isWood(final Block bid) {
        return bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == OreSpawnMain.MySkyTreeLog || (bid == Blocks.field_150422_aJ || bid == Blocks.field_150396_be || bid == Blocks.field_150472_an);
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.field_70163_u + 4.0 + this.field_70170_p.field_73012_v.nextInt(4), this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    public void breakRecursor(final World world, final int x, final int y, final int z, final int xf, final int yf, final int zf, final int recursion) {
        final int var7 = 1;
        if (recursion > 200) {
            return;
        }
        for (int var8 = -var7; var8 <= var7; ++var8) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    if (var8 != 0 || var9 != 0 || var10 != 0) {
                        if (x + var8 != xf || y + var9 != yf || z + var10 != zf) {
                            if (recursion <= 0 || x + var8 < xf - var7 || x + var8 > xf + var7 || y + var9 < yf - var7 || y + var9 > yf + var7 || z + var10 < zf - var7 || z + var10 > zf + var7) {
                                final Block var11 = world.func_147439_a(x + var8, y + var9, z + var10);
                                if (this.isWood(var11)) {
                                    world.func_147465_d(x + var8, y + var9, z + var10, Blocks.field_150350_a, 0, 2);
                                    this.dropItemRand(Item.func_150898_a(var11), 1);
                                    this.breakRecursor(world, x + var8, y + var9, z + var10, x, y, z, recursion + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void func_70629_bd() {
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (((this.field_70170_p.field_73012_v.nextInt(30) == 0 && this.getBeaverHealth() < this.mygetMaxHealth()) || this.field_70170_p.field_73012_v.nextInt(350) == 1) && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 11; ++i) {
                int j = i;
                if (j > 2) {
                    j = 2;
                }
                if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v, i, j, i)) {
                    break;
                }
                if (i >= 6) {
                    ++i;
                }
            }
            int i = 0;
            if (this.closest < 99999) {
                this.func_70661_as().func_75492_a((double)this.tx, (double)this.ty, (double)this.tz, 1.0);
                if (this.closest < 12) {
                    if (this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                        this.field_70170_p.func_147465_d(this.tx, this.ty, this.tz, Blocks.field_150350_a, 0, 2);
                        this.breakRecursor(this.field_70170_p, this.tx, this.ty, this.tz, this.tx, this.ty, this.tz, i);
                    }
                    this.func_70691_i(1.0f);
                    this.func_85030_a("orespawn:chainsaw", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            final Beaver buddy = this.findBuddy();
            if (buddy != null) {
                this.func_70661_as().func_75492_a(buddy.field_70165_t, buddy.field_70163_u, buddy.field_70161_v, 0.5);
            }
        }
        super.func_70629_bd();
    }
    
    private Beaver findBuddy() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Beaver.class, this.field_70121_D.func_72314_b(16.0, 6.0, 16.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        Beaver var8 = null;
        if (var6.hasNext()) {
            var7 = var6.next();
            var8 = (Beaver)var7;
            return var8;
        }
        return null;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 15;
    }
    
    public int getBeaverHealth() {
        return (int)this.func_110143_aJ();
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:scorpion_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:cryo_death";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151147_al;
    }
    
    protected float func_70647_i() {
        return this.func_70631_g_() ? ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.5f) : ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1f + 1.0f);
    }
    
    public boolean func_70601_bi() {
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (this.field_70163_u > 100.0) {
            return false;
        }
        final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v);
        return bid == Blocks.field_150346_d || bid == Blocks.field_150349_c || bid == Blocks.field_150329_H || bid == Blocks.field_150362_t;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public Beaver spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Beaver(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151034_e;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}
