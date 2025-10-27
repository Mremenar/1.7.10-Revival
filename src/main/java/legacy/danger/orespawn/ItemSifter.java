// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSifter extends Item
{
    public ItemSifter(final int i) {
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78031_c);
        this.func_77656_e(600);
    }
    
    private void dropItemRand(final Item index, final int par1, final World world, final int x, final int y, final int z) {
        final EntityItem var3 = new EntityItem(world, x + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2) + 0.5, y + 1.1, z + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2) + 0.5, new ItemStack(index, par1, 0));
        world.func_72838_d((Entity)var3);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.field_72995_K) {
            return true;
        }
        Block bid = par3World.func_147439_a(par4, par5, par6);
        final Block bid2 = par3World.func_147439_a(par4, par5 + 1, par6);
        if (bid2 == Blocks.field_150358_i) {
            bid = Blocks.field_150355_j;
        }
        if (bid2 == Blocks.field_150355_j) {
            bid = Blocks.field_150355_j;
        }
        if (bid == Blocks.field_150355_j) {
            final int i = par3World.field_73012_v.nextInt(160);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.field_151115_aP, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MyGreenFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(OreSpawnMain.MyBlueFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(OreSpawnMain.MyPinkFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(OreSpawnMain.MyRockFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(OreSpawnMain.MyWoodFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(OreSpawnMain.MyGreyFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.field_151042_j, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.field_151074_bl, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
                    break;
                }
                case 14: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 15: {
                    this.dropItemRand(Items.field_151103_aS, 1, par3World, par4, par5, par6);
                    break;
                }
                case 16: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150348_b), 1, par3World, par4, par5, par6);
                    break;
                }
                case 17: {
                    this.dropItemRand(Items.field_151133_ar, 1, par3World, par4, par5, par6);
                    break;
                }
                case 18: {
                    this.dropItemRand(Items.field_151131_as, 1, par3World, par4, par5, par6);
                    break;
                }
                case 19: {
                    if (par3World.field_73012_v.nextInt(3) == 1) {
                        this.dropItemRand(Items.field_151166_bC, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 20: {
                    if (par3World.field_73012_v.nextInt(3) == 1) {
                        this.dropItemRand(OreSpawnMain.MyRuby, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 21: {
                    if (par3World.field_73012_v.nextInt(3) == 1) {
                        this.dropItemRand(OreSpawnMain.MyAmethyst, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 22: {
                    this.dropItemRand(OreSpawnMain.MyMothScale, 1, par3World, par4, par5, par6);
                    break;
                }
                case 23: {
                    this.dropItemRand(OreSpawnMain.UraniumNugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 24: {
                    this.dropItemRand(OreSpawnMain.TitaniumNugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 25: {
                    if (par3World.field_73012_v.nextInt(2) == 1) {
                        this.dropItemRand(Items.field_151045_i, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 26: {
                    this.dropItemRand(Items.field_151042_j, 1, par3World, par4, par5, par6);
                    break;
                }
                case 27: {
                    this.dropItemRand(Items.field_151074_bl, 1, par3World, par4, par5, par6);
                    break;
                }
                case 28: {
                    this.dropItemRand(Items.field_151137_ax, 1, par3World, par4, par5, par6);
                    break;
                }
                case 29: {
                    this.dropItemRand(Items.field_151044_h, 1, par3World, par4, par5, par6);
                    break;
                }
                case 30: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
                    break;
                }
                case 31: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
                    break;
                }
                case 32: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
                    break;
                }
                case 33: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
                    break;
                }
                case 34: {
                    this.dropItemRand(Items.field_151115_aP, 1, par3World, par4, par5, par6);
                    break;
                }
                case 35: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 36: {
                    this.dropItemRand(Items.field_151103_aS, 1, par3World, par4, par5, par6);
                    break;
                }
                case 37: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150348_b), 1, par3World, par4, par5, par6);
                    break;
                }
                case 38: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150430_aB), 1, par3World, par4, par5, par6);
                    break;
                }
                case 39: {
                    this.dropItemRand(Items.field_151133_ar, 1, par3World, par4, par5, par6);
                    break;
                }
                case 40: {
                    this.dropItemRand(Items.field_151131_as, 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.field_150354_m) {
            final int i = par3World.field_73012_v.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.field_151138_bX, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand((Item)Items.field_151097_aZ, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Items.field_151146_bM, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.field_151170_bI, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.field_151160_bD, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.field_151103_aS, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.field_151111_aL, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.field_151141_av, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand((Item)Items.field_151028_Y, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand((Item)Items.field_151030_Z, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand((Item)Items.field_151165_aa, 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand((Item)Items.field_151167_ab, 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150354_m), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.field_150351_n) {
            final int i = par3World.field_73012_v.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.field_151145_ak, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Items.field_151033_d, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.field_151070_bp, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.field_151160_bD, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.field_151008_G, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.field_151007_F, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.field_151058_ca, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.field_151057_cb, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150354_m), 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.field_150346_d) {
            final int i = par3World.field_73012_v.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.field_151007_F, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand((Item)Items.field_151097_aZ, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.field_151055_y, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.field_151054_z, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.field_151162_bE, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.field_151155_ap, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.field_151118_aC, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.field_151121_aF, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.field_151103_aS, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Items.field_151069_bo, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150354_m), 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150346_d), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.field_150349_c) {
            final int i = par3World.field_73012_v.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150327_N), 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150328_O), 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyFlowerPinkBlock), 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyFlowerBlueBlock), 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyFlowerBlackBlock), 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Item.func_150898_a(OreSpawnMain.MyFlowerScaryBlock), 1, par3World, par4, par5, par6);
                }
                case 6: {
                    this.dropItemRand(Items.field_151015_O, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.field_151080_bb, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.field_151081_bc, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.field_151172_bF, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Items.field_151174_bG, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150330_I), 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150351_n), 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.func_150898_a(Blocks.field_150346_d), 1, par3World, par4, par5, par6);
                    break;
                }
                case 14: {
                    this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150349_c), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par2EntityPlayer);
        return true;
    }
    
    public String getMaterialName() {
        return "Unknown";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}
