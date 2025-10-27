// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;

@SideOnly(Side.CLIENT)
public class RenderElevator extends Render
{
    protected ModelBase modelElevator;
    
    public RenderElevator() {
        this.field_76989_e = 0.25f;
        this.modelElevator = new ModelElevator();
    }
    
    public void renderElevator(final Elevator par1EntityElevator, final double par2, final double par4, final double par6, final float par8, final float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0f - par8, 0.0f, 1.0f, 0.0f);
        final float f2 = par1EntityElevator.getTimeSinceHit() - par9;
        float f3 = par1EntityElevator.getDamageTaken() - par9;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f2 > 0.0f) {
            GL11.glRotatef(MathHelper.func_76126_a(f2) * f2 * f3 / 10.0f * par1EntityElevator.getForwardDirection(), 1.0f, 0.0f, 0.0f);
        }
        final float f4 = 0.75f;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0f / f4, 1.0f / f4, 1.0f / f4);
        this.func_110776_a(par1EntityElevator.getTexture());
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.modelElevator.func_78088_a((Entity)par1EntityElevator, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderElevator((Elevator)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        final Elevator a = (Elevator)entity;
        return a.getTexture();
    }
}
