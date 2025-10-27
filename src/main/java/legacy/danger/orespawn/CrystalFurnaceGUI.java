// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;

@SideOnly(Side.CLIENT)
public class CrystalFurnaceGUI extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures;
    private TileEntityCrystalFurnace furnaceInventory;
    
    public CrystalFurnaceGUI(final InventoryPlayer par1InventoryPlayer, final TileEntityCrystalFurnace par2TileEntityCrystalFurnace) {
        super((Container)new ContainerCrystalFurnace(par1InventoryPlayer, par2TileEntityCrystalFurnace));
        this.furnaceInventory = par2TileEntityCrystalFurnace;
    }
    
    protected void func_146979_b(final int par1, final int par2) {
        final String s = this.furnaceInventory.func_145818_k_() ? this.furnaceInventory.func_145825_b() : I18n.func_135052_a(this.furnaceInventory.func_145825_b(), new Object[0]);
        this.field_146289_q.func_78276_b(s, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(s) / 2, 6, 4210752);
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
    }
    
    protected void func_146976_a(final float par1, final int par2, final int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(CrystalFurnaceGUI.furnaceGuiTextures);
        final int k = (this.field_146294_l - this.field_146999_f) / 2;
        final int l = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
        if (this.furnaceInventory.isBurning()) {
            final int i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.func_73729_b(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }
        final int i1 = this.furnaceInventory.getCookProgressScaled(24);
        this.func_73729_b(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
    
    static {
        furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
    }
}
