// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;

@SideOnly(Side.CLIENT)
public class CrystalWorkbenchGUI extends GuiContainer
{
    private static final ResourceLocation craftingTableGuiTextures;
    
    public CrystalWorkbenchGUI(final InventoryPlayer par1InventoryPlayer, final World par2World, final int par3, final int par4, final int par5) {
        super((Container)new ContainerCrystalWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
    }
    
    protected void func_146979_b(final int par1, final int par2) {
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.crafting", new Object[0]), 28, 6, 4210752);
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
    }
    
    protected void func_146976_a(final float par1, final int par2, final int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(CrystalWorkbenchGUI.craftingTableGuiTextures);
        final int k = (this.field_146294_l - this.field_146999_f) / 2;
        final int l = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
    }
    
    static {
        craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
    }
}
