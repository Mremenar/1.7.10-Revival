// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class WormLarge extends EntityMob
{
    private int wormsSpawned;
    
    public WormLarge(final World par1World) {
        super(par1World);
        this.wormsSpawned = 0;
        this.func_70105_a(1.55f, 2.5f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 2050;
        this.field_70145_X = true;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.WormLarge_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected float func_70599_aP() {
        return 0.5f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:big_splat";
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.WormLarge_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.WormLarge_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void pointAtEntity(final EntityLivingBase e) {
        final double d1 = e.field_70165_t - this.field_70165_t;
        final double d2 = e.field_70161_v - this.field_70161_v;
        final float d3 = (float)Math.atan2(d2, d1);
        final float n;
        final float f2 = n = (float)(d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.field_70759_as = n;
        this.field_70177_z = n;
    }
    
    public void func_70636_d() {
        EntityPlayer target = null;
        WormMedium worms = null;
        EntityCreature newent = null;
        super.func_70636_d();
        worms = (WormMedium)this.field_70170_p.func_72857_a((Class)WormMedium.class, this.field_70121_D.func_72314_b(8.0, 8.0, 8.0), (Entity)this);
        if (worms == null) {
            target = (EntityPlayer)this.field_70170_p.func_72857_a((Class)EntityPlayer.class, this.field_70121_D.func_72314_b(8.0, 8.0, 8.0), (Entity)this);
        }
        if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
            if (target != null) {
                this.pointAtEntity((EntityLivingBase)target);
            }
            Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
            if (bid == Blocks.field_150329_H) {
                bid = Blocks.field_150350_a;
            }
            if (bid != Blocks.field_150350_a) {
                this.field_70181_x += 0.25;
                this.field_70163_u += 0.10000000149011612;
            }
            else {
                this.field_70145_X = false;
            }
        }
        else {
            this.field_70145_X = true;
            Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)(this.field_70163_u + 3.5), (int)this.field_70161_v);
            if (bid == Blocks.field_150329_H) {
                bid = Blocks.field_150350_a;
            }
            if (bid != Blocks.field_150350_a) {
                this.field_70181_x += 0.10000000149011612;
                this.field_70163_u += 0.05000000074505806;
                if (bid != Blocks.field_150349_c && bid != Blocks.field_150346_d && bid != Blocks.field_150348_b) {
                    this.func_70106_y();
                }
            }
        }
        if (this.field_70145_X) {
            this.field_70181_x -= 0.01;
            this.field_70159_w = 0.0;
            this.field_70179_y = 0.0;
            this.field_70701_bs = 0.0f;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.wormsSpawned != 0) {
            return;
        }
        this.wormsSpawned = 1;
        for (int i = 0; i < 20; ++i) {
            newent = (EntityCreature)spawnCreature(this.field_70170_p, "Small Worm", this.field_70165_t + this.field_70170_p.field_73012_v.nextInt(6) - this.field_70170_p.field_73012_v.nextInt(6), this.field_70163_u, this.field_70161_v + this.field_70170_p.field_73012_v.nextInt(6) - this.field_70170_p.field_73012_v.nextInt(6));
            newent = (EntityCreature)spawnCreature(this.field_70170_p, "Medium Worm", this.field_70165_t + this.field_70170_p.field_73012_v.nextInt(5) - this.field_70170_p.field_73012_v.nextInt(5), this.field_70163_u, this.field_70161_v + this.field_70170_p.field_73012_v.nextInt(5) - this.field_70170_p.field_73012_v.nextInt(5));
        }
    }
    
    public void func_70071_h_() {
        if (this.func_104002_bU()) {
            this.field_70145_X = false;
        }
        super.func_70071_h_();
        this.field_70181_x *= 0.85;
    }
    
    protected void func_70619_bc() {
        int bid = 0;
        EntityPlayer target = null;
        WormMedium worms = null;
        if (this.field_70128_L) {
            return;
        }
        if (!this.field_70145_X) {
            super.func_70619_bc();
        }
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        worms = (WormMedium)this.field_70170_p.func_72857_a((Class)WormMedium.class, this.field_70121_D.func_72314_b(8.0, 8.0, 8.0), (Entity)this);
        if (worms != null) {
            return;
        }
        target = (EntityPlayer)this.field_70170_p.func_72857_a((Class)EntityPlayer.class, this.field_70121_D.func_72314_b(8.0, 6.0, 8.0), (Entity)this);
        if (target != null && target.field_71075_bZ.field_75098_d) {
            target = null;
        }
        if (target != null) {
            this.pointAtEntity((EntityLivingBase)target);
            this.func_70661_as().func_75492_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
            if (this.field_70170_p.field_73012_v.nextInt(10) == 1 && this.func_70032_d((Entity)target) < 3.0) {
                super.func_70652_k((Entity)target);
                if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                    ItemStack boots = target.func_71124_b(4);
                    if (boots != null) {
                        target.func_70062_b(4, (ItemStack)null);
                        bid = boots.func_77958_k() - boots.func_77960_j();
                        if (bid > 10) {
                            bid /= 10;
                        }
                        else {
                            bid = 1;
                        }
                        boots.func_77972_a(bid, (EntityLivingBase)this);
                        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 3.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                        this.field_70170_p.func_72838_d((Entity)var3);
                    }
                    else {
                        boots = target.func_71124_b(3);
                        if (boots != null) {
                            target.func_70062_b(3, (ItemStack)null);
                            bid = boots.func_77958_k() - boots.func_77960_j();
                            if (bid > 10) {
                                bid /= 10;
                            }
                            else {
                                bid = 1;
                            }
                            boots.func_77972_a(bid, (EntityLivingBase)this);
                            final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 3.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                            this.field_70170_p.func_72838_d((Entity)var3);
                        }
                    }
                }
                if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                    final ItemStack boots = target.func_71124_b(0);
                    if (boots != null) {
                        target.func_70062_b(0, (ItemStack)null);
                        bid = boots.func_77958_k() - boots.func_77960_j();
                        if (bid > 10) {
                            bid /= 10;
                        }
                        else {
                            bid = 1;
                        }
                        boots.func_77972_a(bid, (EntityLivingBase)this);
                        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 3.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
                        this.field_70170_p.func_72838_d((Entity)var3);
                    }
                }
            }
        }
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70069_a(final float par1) {
        if (!this.field_70145_X) {
            super.func_70069_a(par1);
        }
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
        if (!this.field_70145_X) {
            super.func_70064_a(par1, par3);
        }
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70601_bi() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Large Worm")) {
                            this.wormsSpawned = 1;
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        WormLarge target = null;
        target = (WormLarge)this.field_70170_p.func_72857_a((Class)WormLarge.class, this.field_70121_D.func_72314_b(32.0, 8.0, 32.0), (Entity)this);
        if (target != null) {
            return false;
        }
        for (int i = -6; i <= 6; ++i) {
            for (int j = -6; j <= 6; ++j) {
                for (int k = -2; k >= -8; --k) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j);
                    if (bid == Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        for (int i = -6; i <= 6; ++i) {
            for (int j = -6; j <= 6; ++j) {
                for (int k = 2; k <= 8; ++k) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + k, (int)this.field_70161_v + j);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void initCreature() {
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return ret;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        return ret;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("wormsSpawned", this.wormsSpawned);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.wormsSpawned = par1NBTTagCompound.func_74762_e("wormsSpawned");
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
        }
        return var8;
    }
    
    protected Item func_146068_u() {
        return Items.field_151078_bh;
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.field_70163_u + 2.5 + this.field_70170_p.field_73012_v.nextInt(4), this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.WormTooth, 1);
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.field_151078_bh, 1);
        }
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.field_151116_aA, 1);
        }
        for (int var4 = 0; var4 < 8; ++var4) {
            this.dropItemRand(Item.func_150898_a(Blocks.field_150346_d), 1);
        }
        for (int var4 = 0; var4 < 16; ++var4) {
            this.dropItemRand(Items.field_151074_bl, 1);
        }
        for (int var4 = 0; var4 < 5; ++var4) {
            this.dropItemRand(Items.field_151045_i, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
    }
}
