// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.Teleporter;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityAnimal;

public class EntityAnt extends EntityAnimal
{
    public double moveSpeed;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    
    public EntityAnt(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.15000000596046448;
        this.func_70105_a(0.1f, 0.1f);
        this.field_70728_aV = 0;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 9, 1.0));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    public ResourceLocation getTexture(final EntityAnt a) {
        if (a instanceof EntityRedAnt) {
            return EntityAnt.texture2;
        }
        if (a instanceof EntityRainbowAnt) {
            return EntityAnt.texture3;
        }
        if (a instanceof EntityUnstableAnt) {
            return EntityAnt.texture4;
        }
        if (a instanceof Termite) {
            return EntityAnt.texture5;
        }
        return EntityAnt.texture1;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
        super.func_70071_h_();
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer == null) {
            return false;
        }
        if (!(par1EntityPlayer instanceof EntityPlayerMP)) {
            return false;
        }
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null) {
            return false;
        }
        if (par1EntityPlayer.field_71093_bK != OreSpawnMain.DimensionID) {
            MinecraftServer.func_71276_C().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID, (Teleporter)new OreSpawnTeleporter(MinecraftServer.func_71276_C().func_71218_a(OreSpawnMain.DimensionID), OreSpawnMain.DimensionID, this.field_70170_p));
        }
        else {
            MinecraftServer.func_71276_C().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, (Teleporter)new OreSpawnTeleporter(MinecraftServer.func_71276_C().func_71218_a(0), 0, this.field_70170_p));
        }
        return true;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 1;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return null;
    }
    
    protected String func_70673_aS() {
        return null;
    }
    
    protected float func_70599_aP() {
        return 0.0f;
    }
    
    protected void playStepSound(final int par1, final int par2, final int par3, final int par4) {
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
    
    public boolean func_70601_bi() {
        return this.field_70163_u >= 50.0 && this.findBuddies() <= 4;
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityAnt.class, this.field_70121_D.func_72314_b(20.0, 10.0, 20.0));
        return var5.size();
    }
    
    public void func_70629_bd() {
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        super.func_70629_bd();
    }
    
    static {
        texture1 = new ResourceLocation("orespawn", "ant.png");
        texture2 = new ResourceLocation("orespawn", "red_ant.png");
        texture3 = new ResourceLocation("orespawn", "rainbow_ant.png");
        texture4 = new ResourceLocation("orespawn", "unstableant.png");
        texture5 = new ResourceLocation("orespawn", "termite.png");
    }
}
