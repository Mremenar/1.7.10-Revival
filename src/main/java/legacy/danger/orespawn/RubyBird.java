// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.world.World;

public class RubyBird extends Cockateil
{
    public RubyBird(final World par1World) {
        super(par1World);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.setBirdType(this.birdtype = 5);
        this.setFlyUp();
    }
    
    @Override
    protected String func_70639_aQ() {
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.func_72896_J()) {
            return "orespawn:rubybird";
        }
        return null;
    }
    
    @Override
    public boolean func_70601_bi() {
        return true;
    }
}
