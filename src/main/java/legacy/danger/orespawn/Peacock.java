// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Items;
import net.minecraft.entity.EntityAgeable;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.player.EntityPlayer;
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

public class Peacock extends EntityAnimal
{
    private float moveSpeed;
    int my_blink;
    int blinkcount;
    int blinker;
    private GenericTargetSorter TargetSorter;
    
    public Peacock(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.38f;
        this.my_blink = 0;
        this.blinkcount = 0;
        this.blinker = 0;
        this.TargetSorter = null;
        this.func_70105_a(0.65f, 1.2f);
        this.field_70174_ab = 100;
        this.field_70728_aV = 8;
        this.my_blink = 20 + this.field_70146_Z.nextInt(50);
        this.blinkcount = 0;
        this.blinker = 0;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMob.class, 8.0f, 1.0, 1.399999976158142));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 12.0f, 1.2000000476837158, 1.600000023841858));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)Termite.class, 6, true));
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public int getBlink() {
        return this.blinker;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        ++this.blinkcount;
        if (this.blinkcount > this.my_blink) {
            this.blinkcount = 0;
            if (this.blinker > 0) {
                this.blinker = 0;
                this.my_blink = 50 + this.field_70170_p.field_73012_v.nextInt(300);
            }
            else {
                this.blinker = 1;
                this.my_blink = 25 + this.field_70170_p.field_73012_v.nextInt(100);
            }
        }
    }
    
    public boolean func_70601_bi() {
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j < 1; ++j) {
                for (int i = 1; i < 3; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a) {
                        return false;
                    }
                }
            }
        }
        long t = this.field_70170_p.func_72820_D();
        t %= 24000L;
        return t <= 12000L && this.field_70163_u >= 50.0 && this.field_70163_u <= 100.0 && this.findBuddies() <= 2;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return false;
    }
    
    public int mygetMaxHealth() {
        return 15;
    }
    
    protected String func_70639_aQ() {
        if (this.field_70170_p.field_73012_v.nextInt(8) != 1) {
            return null;
        }
        return "orespawn:peacocklive";
    }
    
    protected String func_70621_aR() {
        return "orespawn:peacockhit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:peacockdead";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return OreSpawnMain.MyRawPeacock;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.func_145779_a(OreSpawnMain.MyRawPeacock, 1);
        if (this.field_70170_p.field_73012_v.nextInt(3) == 1) {
            this.func_145779_a(OreSpawnMain.MyRawPeacock, 1);
        }
        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            this.func_145779_a(OreSpawnMain.MyPeacockFeather, 1);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 6.0f);
        return var4;
    }
    
    private ItemStack LayAnEgg(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70619_bc() {
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.func_70068_e((Entity)e) < 4.0) {
                    this.func_70652_k((Entity)e);
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.2);
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(5000) == 1) {
            this.LayAnEgg(OreSpawnMain.PeacockEgg, 1 + this.field_70170_p.field_73012_v.nextInt(3));
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && par1EntityLiving instanceof Termite;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0, 2.0, 10.0));
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
    
    public Peacock spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Peacock(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151034_e;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Peacock.class, this.field_70121_D.func_72314_b(16.0, 10.0, 16.0));
        return var5.size();
    }
}
