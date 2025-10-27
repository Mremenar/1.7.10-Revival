package com.yourname.orespawn.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class DrakeEntity extends Mob {  // Renamed from EntityDragon
    public DrakeEntity(EntityType<? extends DrakeEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 200.0D)  // Orespawn dragons are tanks
            .add(Attributes.ATTACK_DAMAGE, 15.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.FLYING_SPEED, 0.6D);  // For future flying
    }
}