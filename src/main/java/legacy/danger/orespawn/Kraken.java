// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.DamageSource;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.Vec3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.EntityMob;

public class Kraken extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private ChunkCoordinates currentFlightTarget;
    private EntityLivingBase caught;
    private int newtarget;
    private int release;
    private int weather_set;
    private int long_enough;
    private int call_reinforcements;
    private boolean hit_by_player;
    private int straight_down;
    private int hurt_timer;
    
    public Kraken(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.currentFlightTarget = null;
        this.caught = null;
        this.newtarget = 0;
        this.release = 0;
        this.weather_set = 10;
        this.long_enough = 3600;
        this.call_reinforcements = 0;
        this.hit_by_player = false;
        this.straight_down = 1;
        this.hurt_timer = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.func_70105_a(4.0f, 15.0f);
        }
        else {
            this.func_70105_a(1.3333334f, 5.0f);
        }
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 500;
        this.field_70174_ab = 120;
        this.field_70178_ae = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3700000047683716);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Kraken_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)OreSpawnMain.PlayNicely);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }
    
    public int getPlayNicely() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Kraken_stats.health;
    }
    
    public int getKrakenHealth() {
        return (int)this.func_110143_aJ();
    }
    
    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }
    
    public void setRenderInfo(final RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Kraken_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70128_L) {
            return;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)(this.field_70163_u - 10.0), (int)this.field_70161_v);
        }
        else if (this.field_70163_u < this.currentFlightTarget.field_71572_b) {
            this.field_70181_x *= 0.72;
        }
        else {
            this.field_70181_x *= 0.5;
        }
        if (this.weather_set > 0 && OreSpawnMain.PlayNicely == 0) {
            --this.weather_set;
            if (this.weather_set == 0 && !this.field_70170_p.field_72995_K) {
                final WorldInfo worldinfo = this.field_70170_p.func_72912_H();
                if (!this.field_70170_p.func_72896_J()) {
                    worldinfo.func_76080_g(300);
                    worldinfo.func_76090_f(300);
                    worldinfo.func_76084_b(true);
                    worldinfo.func_76069_a(true);
                }
                else {
                    worldinfo.func_76080_g(300);
                    worldinfo.func_76090_f(300);
                }
                this.weather_set = 100;
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("LongEnough", this.long_enough);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.long_enough = par1NBTTagCompound.func_74762_e("LongEnough");
    }
    
    protected String func_70639_aQ() {
        if (this.field_70146_Z.nextInt(5) == 0) {
            return "orespawn:kraken_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return null;
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    protected float func_70599_aP() {
        return 2.0f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151128_bU;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        ItemStack is = null;
        this.dropItemRand(OreSpawnMain.MyKrakenTooth, 1);
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int var5 = 120 + this.field_70170_p.field_73012_v.nextInt(160), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.field_151100_aR, 1);
        }
        for (int i = 5 + this.field_70170_p.field_73012_v.nextInt(10), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.field_70170_p.field_73012_v.nextInt(53);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateSword, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.field_151045_i, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150484_ah), 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Items.field_151048_u, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Items.field_151047_v, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Items.field_151046_w, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Items.field_151056_x, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Items.field_151012_L, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 8: {
                    is = this.dropItemRand((Item)Items.field_151161_ac, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(2));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 9: {
                    is = this.dropItemRand((Item)Items.field_151163_ad, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 10: {
                    is = this.dropItemRand((Item)Items.field_151173_ae, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 11: {
                    is = this.dropItemRand((Item)Items.field_151175_af, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 12: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateBow, 1);
                    break;
                }
                case 13: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
                    break;
                }
                case 14: {
                    is = this.dropItemRand(Items.field_151042_j, 1);
                    break;
                }
                case 15: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
                    break;
                }
                case 16: {
                    is = this.dropItemRand(Items.field_151040_l, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 17: {
                    is = this.dropItemRand(Items.field_151037_a, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 18: {
                    is = this.dropItemRand(Items.field_151035_b, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 19: {
                    is = this.dropItemRand(Items.field_151036_c, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 20: {
                    is = this.dropItemRand(Items.field_151019_K, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 21: {
                    is = this.dropItemRand((Item)Items.field_151028_Y, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 22: {
                    is = this.dropItemRand((Item)Items.field_151030_Z, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 23: {
                    is = this.dropItemRand((Item)Items.field_151165_aa, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 24: {
                    is = this.dropItemRand((Item)Items.field_151167_ab, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 25: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
                    break;
                }
                case 26: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150339_S), 1);
                    break;
                }
                case 27: {
                    is = this.dropItemRand(Items.field_151074_bl, 1);
                    break;
                }
                case 28: {
                    is = this.dropItemRand(Items.field_151043_k, 1);
                    break;
                }
                case 29: {
                    is = this.dropItemRand(Items.field_151150_bK, 1);
                    break;
                }
                case 30: {
                    is = this.dropItemRand(Items.field_151010_B, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 31: {
                    is = this.dropItemRand(Items.field_151011_C, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 32: {
                    is = this.dropItemRand(Items.field_151005_D, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 33: {
                    is = this.dropItemRand(Items.field_151006_E, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 34: {
                    is = this.dropItemRand(Items.field_151013_M, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 35: {
                    is = this.dropItemRand((Item)Items.field_151169_ag, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 36: {
                    is = this.dropItemRand((Item)Items.field_151171_ah, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 37: {
                    is = this.dropItemRand((Item)Items.field_151149_ai, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 38: {
                    is = this.dropItemRand((Item)Items.field_151151_aj, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 39: {
                    this.dropItemRand(Items.field_151153_ao, 1);
                    break;
                }
                case 40: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150340_R), 1);
                    break;
                }
                case 41: {
                    EntityItem var8 = null;
                    is = new ItemStack(Items.field_151153_ao, 1, 1);
                    var8 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
                    if (var8 != null) {
                        this.field_70170_p.func_72838_d((Entity)var8);
                    }
                    break;
                }
                case 42: {
                    is = this.dropItemRand(OreSpawnMain.MyExperienceSword, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 43: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceHelmet, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 44: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBody, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 45: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceLegs, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 46: {
                    is = this.dropItemRand((Item)OreSpawnMain.ExperienceBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 47: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystSword, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 48: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 49: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 50: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 51: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 52: {
                    is = this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyBlockAmethystBlock), 1);
                    break;
                }
            }
        }
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    protected boolean func_70692_ba() {
        if (this.func_104002_bU()) {
            return false;
        }
        if (this.long_enough <= 0) {
            return true;
        }
        if (this.field_70163_u > 150.0 && this.func_110143_aJ() < this.mygetMaxHealth() / 2) {
            return true;
        }
        if (this.field_70163_u > 180.0 && this.long_enough <= 0) {
            this.func_70106_y();
            return true;
        }
        return false;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.long_enough > 0) {
            --this.long_enough;
        }
        this.field_70180_af.func_75692_b(21, (Object)OreSpawnMain.PlayNicely);
        if (this.field_70170_p.field_73012_v.nextInt(400) == 1 && OreSpawnMain.PlayNicely == 0) {
            this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, this.field_70165_t, this.field_70163_u - 16.0, this.field_70161_v));
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.newtarget != 0 || this.field_70146_Z.nextInt(250) == 1 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 9.1f) {
            this.newtarget = 0;
            int ground_dist;
            for (ground_dist = 0; ground_dist < 31; ++ground_dist) {
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - ground_dist, (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a) {
                    this.straight_down = 0;
                    break;
                }
            }
            ground_dist = 20 - ground_dist;
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                zdir = this.field_70170_p.field_73012_v.nextInt(6) + 12;
                xdir = this.field_70170_p.field_73012_v.nextInt(6) + 12;
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                if (this.straight_down != 0) {
                    xdir = (zdir = 0);
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + ground_dist + this.field_70146_Z.nextInt(9) - 6, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
            if (this.long_enough <= 0 || (this.field_70163_u < 200.0 && this.func_110143_aJ() < this.mygetMaxHealth() / 4)) {
                this.currentFlightTarget.func_71571_b(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b + 30, this.currentFlightTarget.field_71573_c);
                if (this.hit_by_player && this.call_reinforcements == 0 && this.func_110143_aJ() < this.mygetMaxHealth() / 8 && this.field_70163_u > 130.0) {
                    this.call_reinforcements = 1;
                    for (int i = 0; i < 10; ++i) {
                        final EntityCreature newent = (EntityCreature)spawnCreature(this.field_70170_p, "The Kraken", this.field_70165_t + this.field_70170_p.field_73012_v.nextInt(10) - this.field_70170_p.field_73012_v.nextInt(10), 170.0, this.field_70161_v + this.field_70170_p.field_73012_v.nextInt(10) - this.field_70170_p.field_73012_v.nextInt(10));
                    }
                }
            }
        }
        else if (this.caught == null && this.field_70170_p.field_73012_v.nextInt(8) == 1 && OreSpawnMain.PlayNicely == 0) {
            EntityPlayer target = null;
            target = (EntityPlayer)this.field_70170_p.func_72857_a((Class)EntityPlayer.class, this.field_70121_D.func_72314_b(25.0, 40.0, 25.0), (Entity)this);
            if (target != null) {
                if (!target.field_71075_bZ.field_75098_d) {
                    if (this.func_70635_at().func_75522_a((Entity)target)) {
                        this.currentFlightTarget.func_71571_b((int)target.field_70165_t, (int)target.field_70163_u + 15, (int)target.field_70161_v);
                        this.attackWithSomething((EntityLivingBase)target);
                    }
                }
                else {
                    target = null;
                }
            }
            if (target == null && this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null) {
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u + 15, (int)e.field_70161_v);
                    this.attackWithSomething(e);
                }
            }
        }
        if (this.caught != null) {
            if (!this.caught.field_70128_L) {
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t, 200, (int)this.field_70161_v);
                if (this.field_70163_u > 190.0) {
                    this.release = 1;
                }
                this.caught.field_70159_w = this.field_70159_w;
                this.caught.field_70179_y = this.field_70179_y;
                this.caught.field_70181_x = this.field_70181_x;
                this.caught.field_70165_t = this.field_70165_t;
                if (this.field_70163_u - this.caught.field_70163_u > 16.0) {
                    final EntityLivingBase caught = this.caught;
                    caught.field_70181_x += 0.25;
                }
                this.caught.field_70163_u = this.field_70163_u - 15.0;
                this.caught.field_70161_v = this.field_70161_v;
                this.caught.field_70177_z = this.field_70177_z;
                if (this.field_70170_p.field_73012_v.nextInt(50) == 1) {
                    this.func_70652_k((Entity)this.caught);
                }
                if (this.release != 0 || this.field_70170_p.field_73012_v.nextInt(250) == 1) {
                    this.caught = null;
                    this.newtarget = 1;
                    this.setAttacking(this.release = 0);
                }
            }
            else {
                this.caught = null;
                this.newtarget = 1;
                this.setAttacking(this.release = 0);
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.3 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.3 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.45 - this.field_70159_w) * 0.15;
        this.field_70181_x += (Math.signum(var2) * 0.70999 - this.field_70181_x) * 0.202;
        this.field_70179_y += (Math.signum(var3) * 0.45 - this.field_70179_y) * 0.15;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.4f;
        if (Math.abs(this.field_70159_w) + Math.abs(this.field_70179_y) < 0.15) {
            var5 = 0.0f;
        }
        this.field_70177_z += var5 / 5.0f;
        double obstruction_factor = 0.0;
        double dx = 0.0;
        double dz = 0.0;
        final int dist = 10;
        for (int k = -20; k < 18; k += 2) {
            for (int i = 1; i < dist; i += 2) {
                dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                final Block bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u + k, (int)(this.field_70161_v + dz));
                if (bid != Blocks.field_150350_a) {
                    obstruction_factor += 0.1;
                }
            }
        }
        this.field_70181_x += obstruction_factor * 0.08;
        this.field_70163_u += obstruction_factor * 0.08;
        if (this.field_70163_u > 256.0 && !this.func_104002_bU()) {
            this.func_70106_y();
        }
    }
    
    private void attackWithSomething(final EntityLivingBase par1) {
        if (this.caught != null) {
            return;
        }
        double dist = (this.field_70165_t - par1.field_70165_t) * (this.field_70165_t - par1.field_70165_t);
        dist += (this.field_70161_v - par1.field_70161_v) * (this.field_70161_v - par1.field_70161_v);
        dist += (this.field_70163_u - par1.field_70163_u - 15.0) * (this.field_70163_u - par1.field_70163_u - 15.0);
        if (dist < 30.0) {
            this.caught = par1;
            this.release = 0;
            this.setAttacking(1);
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d && !p.field_71075_bZ.field_75100_b;
        }
        if (!par1EntityLiving.field_70122_E && !par1EntityLiving.func_70090_H()) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySquid) {
            return false;
        }
        if (par1EntityLiving instanceof AttackSquid) {
            return false;
        }
        if (par1EntityLiving instanceof Kraken) {
            return false;
        }
        if (par1EntityLiving instanceof Spyro) {
            return false;
        }
        if (par1EntityLiving instanceof Dragon) {
            final Dragon c = (Dragon)par1EntityLiving;
            return c.field_70153_n == null;
        }
        if (par1EntityLiving instanceof Cephadrome) {
            final Cephadrome c2 = (Cephadrome)par1EntityLiving;
            return c2.field_70153_n == null;
        }
        if (par1EntityLiving instanceof Leon) {
            final Leon c3 = (Leon)par1EntityLiving;
            return c3.field_70153_n == null;
        }
        if (par1EntityLiving instanceof ThePrinceTeen) {
            final ThePrinceTeen c4 = (ThePrinceTeen)par1EntityLiving;
            return c4.field_70153_n == null;
        }
        if (par1EntityLiving instanceof ThePrinceAdult) {
            final ThePrinceAdult c5 = (ThePrinceAdult)par1EntityLiving;
            return c5.field_70153_n == null;
        }
        return !(par1EntityLiving instanceof EntityChicken) && !(par1EntityLiving instanceof Chipmunk) && !(par1EntityLiving instanceof StinkBug) && !(par1EntityLiving instanceof Mothra);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(20.0, 40.0, 20.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }
    
    public void func_70077_a(final EntityLightningBolt par1EntityLightningBolt) {
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        final Entity e = par1DamageSource.func_76346_g();
        boolean ret = false;
        if (this.currentFlightTarget != null && e != null && e instanceof EntityPlayer && this.func_110143_aJ() > this.mygetMaxHealth() / 4) {
            this.hit_by_player = true;
            this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)e.field_70163_u + 15, (int)e.field_70161_v);
        }
        if (this.hurt_timer > 0) {
            return false;
        }
        this.hurt_timer = 30;
        ret = super.func_70097_a(par1DamageSource, par2);
        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            this.release = 1;
        }
        return ret;
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_70601_bi() {
        if (this.field_70163_u < 50.0) {
            return false;
        }
        for (int k = -1; k < 2; ++k) {
            for (int j = -1; j < 1; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a && bid != Blocks.field_150329_H) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
