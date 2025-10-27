// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.util.Vec3;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class MyEntityAIWanderALot extends EntityAIBase
{
    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private int xzRange;
    private int busy;
    
    public MyEntityAIWanderALot(final EntityCreature par1EntityCreature, final int par1, final double par2) {
        this.xzRange = 10;
        this.busy = 0;
        this.entity = par1EntityCreature;
        this.xzRange = par1;
        this.speed = par2;
        this.func_75248_a(1);
    }
    
    public void setBusy(final int i) {
        this.busy = i;
    }
    
    public boolean func_75250_a() {
        if (this.busy != 0) {
            return false;
        }
        if (this.entity.field_70170_p.field_73012_v.nextInt(30) != 0) {
            return false;
        }
        if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).func_70906_o()) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.func_75463_a(this.entity, this.xzRange, 7);
        if (var1 == null) {
            return false;
        }
        this.xPosition = var1.field_72450_a;
        this.yPosition = var1.field_72448_b;
        this.zPosition = var1.field_72449_c;
        return true;
    }
    
    public boolean func_75253_b() {
        return !this.entity.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        this.entity.func_70661_as().func_75492_a(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
}
