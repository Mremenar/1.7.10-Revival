// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemDuctTape extends Item
{
    private Block field_150935_a;
    
    public ItemDuctTape(final int par1, final Block par2Block) {
        this.field_150935_a = par2Block;
    }
    
    public boolean func_77648_a(final ItemStack p_77648_1_, final EntityPlayer p_77648_2_, final World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, final float p_77648_8_, final float p_77648_9_, final float p_77648_10_) {
        final Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
        if (block == Blocks.field_150431_aC && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 0x7) < 1) {
            p_77648_7_ = 1;
        }
        else if (block != Blocks.field_150395_bd && block != Blocks.field_150329_H && block != Blocks.field_150330_I) {
            if (p_77648_7_ == 0) {
                --p_77648_5_;
            }
            if (p_77648_7_ == 1) {
                ++p_77648_5_;
            }
            if (p_77648_7_ == 2) {
                --p_77648_6_;
            }
            if (p_77648_7_ == 3) {
                ++p_77648_6_;
            }
            if (p_77648_7_ == 4) {
                --p_77648_4_;
            }
            if (p_77648_7_ == 5) {
                ++p_77648_4_;
            }
        }
        if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
        }
        if (p_77648_1_.field_77994_a == 0) {
            return false;
        }
        if (p_77648_3_.func_147472_a(this.field_150935_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_)) {
            final int i1 = this.field_150935_a.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
            if (p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150935_a, i1, 3)) {
                if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150935_a) {
                    this.field_150935_a.func_149689_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (EntityLivingBase)p_77648_2_, p_77648_1_);
                    this.field_150935_a.func_149714_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
                }
                p_77648_3_.func_72908_a((double)(p_77648_4_ + 0.5f), (double)(p_77648_5_ + 0.5f), (double)(p_77648_6_ + 0.5f), this.field_150935_a.field_149762_H.func_150496_b(), (this.field_150935_a.field_149762_H.func_150497_c() + 1.0f) / 2.0f, this.field_150935_a.field_149762_H.func_150494_d() * 0.8f);
                --p_77648_1_.field_77994_a;
            }
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
