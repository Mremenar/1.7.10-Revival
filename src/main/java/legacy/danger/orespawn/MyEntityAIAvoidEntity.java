// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.List;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class MyEntityAIAvoidEntity extends EntityAIBase
{
    private EntityCreature theEntity;
    private double farSpeed;
    private double nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;
    
    public MyEntityAIAvoidEntity(final EntityCreature par1EntityCreature, final Class par2Class, final float par3, final double par4, final double par6) {
        this.theEntity = par1EntityCreature;
        this.targetEntityClass = par2Class;
        this.distanceFromEntity = par3;
        this.farSpeed = par4;
        this.nearSpeed = par6;
        this.entityPathNavigate = par1EntityCreature.func_70661_as();
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        if (this.theEntity != null && this.theEntity instanceof EntityCannonFodder) {
            final EntityCannonFodder cf = (EntityCannonFodder)this.theEntity;
            if (cf.get_is_activated() != 0) {
                return false;
            }
        }
        if (this.targetEntityClass == EntityPlayer.class) {
            if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).func_70909_n()) {
                return false;
            }
            this.closestLivingEntity = (Entity)this.theEntity.field_70170_p.func_72890_a((Entity)this.theEntity, (double)this.distanceFromEntity);
            if (this.closestLivingEntity == null) {
                return false;
            }
        }
        else {
            final List list = this.theEntity.field_70170_p.func_82733_a(this.targetEntityClass, this.theEntity.field_70121_D.func_72314_b((double)this.distanceFromEntity, 3.0, (double)this.distanceFromEntity), IMob.field_82192_a);
            if (list.isEmpty()) {
                return false;
            }
            this.closestLivingEntity = list.get(0);
        }
        final Vec3 vec3 = RandomPositionGenerator.func_75461_b(this.theEntity, 16, 7, Vec3.func_72443_a(this.closestLivingEntity.field_70165_t, this.closestLivingEntity.field_70163_u, this.closestLivingEntity.field_70161_v));
        if (vec3 == null) {
            return false;
        }
        if (this.closestLivingEntity.func_70092_e(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c) < this.closestLivingEntity.func_70068_e((Entity)this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate.func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
        return this.entityPathEntity != null && this.entityPathEntity.func_75880_b(vec3);
    }
    
    public boolean func_75253_b() {
        return !this.entityPathNavigate.func_75500_f();
    }
    
    public void func_75249_e() {
        this.entityPathNavigate.func_75484_a(this.entityPathEntity, this.farSpeed);
    }
    
    public void func_75251_c() {
        this.closestLivingEntity = null;
    }
    
    public void func_75246_d() {
        if (this.theEntity.func_70068_e(this.closestLivingEntity) < 49.0) {
            this.theEntity.func_70661_as().func_75489_a(this.nearSpeed);
        }
        else {
            this.theEntity.func_70661_as().func_75489_a(this.farSpeed);
        }
    }
    
    static EntityCreature func_98217_a(final MyEntityAIAvoidEntity par0EntityAIAvoidEntity) {
        return par0EntityAIAvoidEntity.theEntity;
    }
}
