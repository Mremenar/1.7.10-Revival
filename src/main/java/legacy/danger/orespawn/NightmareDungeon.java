// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;

public class NightmareDungeon
{
    private final WeightedRandomChestContent[] chestContentsList;
    
    public NightmareDungeon() {
        this.chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyExperienceSword, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateShovel, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateHoe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateAxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyBertha, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MySlice, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5) };
    }
    
    private void setThisBlock(final World world, final int cposx, final int cposy, final int cposz) {
        if (world.field_73012_v.nextInt(2) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.field_150357_h);
        }
        else {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.field_150343_Z);
        }
    }
    
    public void makeDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 25;
        final int height = 12;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.field_150350_a);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, OreSpawnMain.MyRTPBlock);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height - 1;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.field_150357_h);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int k = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                k = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 0; j < height; ++j) {
                int i = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                i = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        world.func_147465_d(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.field_150474_ac, 0, 2);
        final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.func_147438_o(cposx + width / 2, cposy + 1, cposz + width / 2);
        if (tileentitymobspawner != null) {
            if (world.field_73012_v.nextInt(2) == 1) {
                tileentitymobspawner.func_145881_a().func_98272_a("Emperor Scorpion");
            }
            else {
                tileentitymobspawner.func_145881_a().func_98272_a("Nightmare");
            }
        }
        TileEntityChest chest = null;
        world.func_147465_d(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, (Block)Blocks.field_150486_ae, 0, 2);
        chest = (TileEntityChest)world.func_147438_o(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1);
        if (chest != null) {
            WeightedRandomChestContent.func_76293_a(world.field_73012_v, this.chestContentsList, (IInventory)chest, 4 + world.field_73012_v.nextInt(7));
        }
        world.func_147465_d(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, (Block)Blocks.field_150486_ae, 0, 2);
        chest = (TileEntityChest)world.func_147438_o(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1);
        if (chest != null) {
            WeightedRandomChestContent.func_76293_a(world.field_73012_v, this.chestContentsList, (IInventory)chest, 4 + world.field_73012_v.nextInt(7));
        }
    }
    
    public void FastSetBlock(final World world, final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 3);
    }
}
