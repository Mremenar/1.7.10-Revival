// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.EntityMob;

public class BandP extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int whatset;
    private int whatami;
    public ItemStack[] MymainInventory;
    int got_stuff;
    
    public BandP(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.32f;
        this.whatset = 0;
        this.whatami = 0;
        this.MymainInventory = new ItemStack[100];
        this.got_stuff = 0;
        this.func_70105_a(0.75f, 1.75f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 1000;
        this.field_70174_ab = 2;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.5, false));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 0.5));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.BandP_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.got_stuff == 0;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.whatset == 0) {
            this.whatset = 1;
            this.setWhat(this.whatami = this.field_70170_p.field_73012_v.nextInt(2));
        }
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.BandP_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.BandP_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    protected String func_70639_aQ() {
        return "mob.villager.idle";
    }
    
    protected String func_70621_aR() {
        return "mob.villager.hit";
    }
    
    protected String func_70673_aS() {
        return "mob.villager.death";
    }
    
    protected float func_70599_aP() {
        return 1.5f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151166_bC;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        if (index == null) {
            return null;
        }
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var4 = 10 + this.field_70170_p.field_73012_v.nextInt(5), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.field_151166_bC, 1);
        }
        if (this.getWhat() == 0) {
            for (int var4 = 2 + this.field_70170_p.field_73012_v.nextInt(3), i = 0; i < var4; ++i) {
                this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
                this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
            }
        }
        for (int i = 0; i < this.MymainInventory.length; ++i) {
            if (this.MymainInventory[i] != null && this.MymainInventory[i].field_77994_a != 0) {
                final ItemStack is = this.dropItemRand(this.MymainInventory[i].func_77973_b(), this.MymainInventory[i].field_77994_a);
                if (this.MymainInventory[i].field_77994_a == 1) {
                    is.func_77964_b(this.MymainInventory[i].func_77960_j());
                }
            }
        }
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        return super.func_70652_k(par1Entity);
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(12) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (this.func_70068_e((Entity)e) < 9.0) {
                    this.func_70652_k((Entity)e);
                    if (e instanceof EntityPlayer) {
                        final EntityPlayer p = (EntityPlayer)e;
                        int k = -1;
                        int kp = -1;
                        for (int i = 0; i < this.MymainInventory.length; ++i) {
                            if (this.MymainInventory[i] == null) {
                                k = i;
                                break;
                            }
                        }
                        if (k >= 0) {
                            for (int i = p.field_71071_by.field_70460_b.length - 1; i >= 0; --i) {
                                if (p.field_71071_by.field_70460_b[i] != null) {
                                    kp = i;
                                    break;
                                }
                            }
                            if (kp >= 0) {
                                this.MymainInventory[k] = p.field_71071_by.field_70460_b[kp];
                                p.field_71071_by.field_70460_b[kp] = null;
                                ++this.got_stuff;
                            }
                            if (kp < 0) {
                                for (int i = p.field_71071_by.field_70462_a.length - 1; i >= 0; --i) {
                                    if (p.field_71071_by.field_70462_a[i] != null) {
                                        kp = i;
                                        break;
                                    }
                                }
                                if (kp >= 0) {
                                    this.MymainInventory[k] = p.field_71071_by.field_70462_a[kp];
                                    p.field_71071_by.field_70462_a[kp] = null;
                                    ++this.got_stuff;
                                }
                            }
                        }
                    }
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.25);
                }
            }
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
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        return par1EntityLiving instanceof EntityVillager || par1EntityLiving instanceof Girlfriend || par1EntityLiving instanceof Boyfriend;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(20.0, 6.0, 20.0));
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
    
    public int getWhat() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public void setWhat(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
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
                        if (s != null && s.equals("Criminal")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (this.field_70163_u < 100.0) {
            return false;
        }
        BandP target = null;
        target = (BandP)this.field_70170_p.func_72857_a((Class)BandP.class, this.field_70121_D.func_72314_b(32.0, 12.0, 32.0), (Entity)this);
        if (target != null) {
            return false;
        }
        EntityVillager target2 = null;
        target2 = (EntityVillager)this.field_70170_p.func_72857_a((Class)EntityVillager.class, this.field_70121_D.func_72314_b(36.0, 12.0, 36.0), (Entity)this);
        return target2 != null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        if (this.got_stuff != 0) {
            par1NBTTagCompound.func_74782_a("Inventory", (NBTBase)this.writeToNBT(new NBTTagList()));
        }
        par1NBTTagCompound.func_74768_a("GotStuff", this.got_stuff);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.got_stuff = par1NBTTagCompound.func_74762_e("GotStuff");
        if (this.got_stuff != 0) {
            final NBTTagList nbttaglist = par1NBTTagCompound.func_150295_c("Inventory", 10);
            this.readFromNBT(nbttaglist);
        }
    }
    
    public NBTTagList writeToNBT(final NBTTagList par1NBTTagList) {
        for (int i = 0; i < this.MymainInventory.length; ++i) {
            if (this.MymainInventory[i] != null) {
                final NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                this.MymainInventory[i].func_77955_b(nbttagcompound);
                par1NBTTagList.func_74742_a((NBTBase)nbttagcompound);
            }
        }
        return par1NBTTagList;
    }
    
    public void readFromNBT(final NBTTagList par1NBTTagList) {
        this.MymainInventory = new ItemStack[100];
        for (int i = 0; i < par1NBTTagList.func_74745_c(); ++i) {
            final NBTTagCompound nbttagcompound = par1NBTTagList.func_150305_b(i);
            final int j = nbttagcompound.func_74771_c("Slot") & 0xFF;
            final ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound);
            if (itemstack != null && j >= 0 && j < this.MymainInventory.length) {
                this.MymainInventory[j] = itemstack;
            }
        }
    }
}
