// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class Cassowary extends EntityAnimal
{
    private float moveSpeed;
    
    public Cassowary(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.25f;
        this.func_70105_a(0.5f, 1.2f);
        this.moveSpeed = 0.25f;
        this.field_70174_ab = 100;
        this.field_70728_aV = 5;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMob.class, 8.0f, 1.0, 1.399999976158142));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 8.0f, 1.0, 1.399999976158142));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 12.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return false;
    }
    
    public int mygetMaxHealth() {
        return 10;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:duck_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:duck_hurt";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151076_bf;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        var3 = this.field_70146_Z.nextInt(3);
        var3 += 2;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151076_bf, 1);
        }
    }
    
    protected void func_70629_bd() {
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        super.func_70629_bd();
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72935_r();
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
    
    public Cassowary spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Cassowary(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151034_e;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}
