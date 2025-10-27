// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderSpiderDriver extends RenderSpider
{
    private static final ResourceLocation texture;
    
    public RenderSpiderDriver(final ModelSpider modelSpider, final float par2) {
    }
    
    public void renderSpiderDriver(final SpiderDriver par1EntitySpiderDriver, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.func_76986_a((EntityLiving)par1EntitySpiderDriver, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderSpiderDriver((SpiderDriver)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderSpiderDriver((SpiderDriver)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderSpiderDriver.texture;
    }
    
    protected ResourceLocation getSpiderTextures(final EntitySpider par1EntitySpider) {
        return RenderSpiderDriver.texture;
    }
    
    static {
        texture = new ResourceLocation("orespawn", "spiderdriver.png");
    }
}
