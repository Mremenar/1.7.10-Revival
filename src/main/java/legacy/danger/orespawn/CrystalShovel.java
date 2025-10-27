// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import java.util.Set;
import net.minecraft.item.ItemTool;

public class CrystalShovel extends ItemTool
{
    public static final Set blocksEffectiveAgainst;
    
    public CrystalShovel(final int par1, final Item.ToolMaterial par2) {
        super(1.0f, par2, CrystalShovel.blocksEffectiveAgainst);
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public boolean canHarvestBlock(final Block par1Block) {
        return par1Block == Blocks.field_150433_aE;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
    
    static {
        blocksEffectiveAgainst = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.field_150349_c, Blocks.field_150346_d, (Block)Blocks.field_150354_m, Blocks.field_150351_n, Blocks.field_150433_aE, Blocks.field_150431_aC, Blocks.field_150435_aG, Blocks.field_150458_ak, (Block)Blocks.field_150391_bh, OreSpawnMain.CrystalGrass });
    }
}
