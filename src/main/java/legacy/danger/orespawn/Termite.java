// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityList;
import java.util.List;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.Teleporter;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.world.World;

public class Termite extends EntityAnt
{
    int attack_delay;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Termite(final World par1World) {
        super(par1World);
        this.attack_delay = 20;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(0.2f, 0.2f);
        this.moveSpeed = 0.20000000298023224;
        this.field_70728_aV = 1;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 8, 1.0));
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 6, true));
        }
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0);
    }
    
    @Override
    public int mygetMaxHealth() {
        return 5;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0) {
            return false;
        }
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return false;
        }
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 1.0f);
        return var4;
    }
    
    @Override
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
            par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText("Empty your hand!"));
            return false;
        }
        if (par1EntityPlayer.field_71093_bK != OreSpawnMain.DimensionID5) {
            for (int i = 0; i < par1EntityPlayer.field_71071_by.field_70462_a.length; ++i) {
                if (par1EntityPlayer.field_71071_by.field_70462_a[i] != null) {
                    par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText("Empty your inventory!"));
                    return false;
                }
            }
            for (int i = 0; i < par1EntityPlayer.field_71071_by.field_70460_b.length; ++i) {
                if (par1EntityPlayer.field_71071_by.field_70460_b[i] != null) {
                    par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText("Take off your armor!"));
                    return false;
                }
            }
            MinecraftServer.func_71276_C().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID5, (Teleporter)new OreSpawnTeleporter(MinecraftServer.func_71276_C().func_71218_a(OreSpawnMain.DimensionID5), OreSpawnMain.DimensionID5, this.field_70170_p));
        }
        else {
            MinecraftServer.func_71276_C().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, (Teleporter)new OreSpawnTeleporter(MinecraftServer.func_71276_C().func_71218_a(0), 0, this.field_70170_p));
        }
        return true;
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70128_L) {
            return;
        }
        if (this.attack_delay > 0) {
            --this.attack_delay;
        }
        if (this.attack_delay > 0) {
            return;
        }
        this.attack_delay = 20;
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return;
        }
        final EntityLivingBase e = (EntityLivingBase)this.field_70170_p.func_72856_b((Entity)this, 1.5);
        if (e != null) {
            this.func_70652_k((Entity)e);
        }
    }
    
    public boolean isWood(final Block bid) {
        return bid == Blocks.field_150422_aJ || bid == Blocks.field_150396_be || bid == Blocks.field_150344_f || bid == Blocks.field_150376_bx || (bid == Blocks.field_150373_bw || bid == Blocks.field_150324_C || bid == Blocks.field_150462_ai) || (bid == Blocks.field_150472_an || bid == Blocks.field_150342_X || bid == Blocks.field_150466_ao || bid == Blocks.field_150452_aw) || (bid == Blocks.field_150487_bG || bid == Blocks.field_150476_ad || bid == Blocks.field_150481_bH || bid == Blocks.field_150485_bF) || bid == OreSpawnMain.CrystalPlanksBlock;
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
    
    @Override
    public void func_70629_bd() {
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1 && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 8; ++i) {
                int j = i;
                if (j > 4) {
                    j = 4;
                }
                if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            int i = 0;
            if (this.closest < 99999) {
                this.func_70661_as().func_75492_a((double)this.tx, (double)this.ty, (double)this.tz, 1.0);
                if (this.closest < 6) {
                    if (this.field_70170_p.field_73012_v.nextInt(3) != 0) {
                        if (this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147465_d(this.tx, this.ty, this.tz, Blocks.field_150346_d, 0, 2);
                        }
                        if (this.findBuddies() < 10) {
                            spawnCreature(this.field_70170_p, "Termite", this.field_70165_t + 0.10000000149011612, this.field_70163_u + 0.10000000149011612, this.field_70161_v + 0.10000000149011612);
                        }
                    }
                    else {
                        if (this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            this.field_70170_p.func_147465_d(this.tx, this.ty, this.tz, Blocks.field_150350_a, 0, 2);
                        }
                        if (this.findBuddies() < 10) {
                            spawnCreature(this.field_70170_p, "Termite", this.tx + 0.1f, this.ty + 0.1f, this.tz + 0.1f);
                        }
                    }
                    this.func_70691_i(1.0f);
                }
            }
        }
        super.func_70629_bd();
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Termite.class, this.field_70121_D.func_72314_b(3.0, 3.0, 3.0));
        return var5.size();
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
}
