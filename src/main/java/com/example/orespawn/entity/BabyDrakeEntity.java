package com.yourname.orespawn.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class BabyDrakeEntity extends Mob {
    public BabyDrakeEntity(EntityType<? extends BabyDrakeEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 50.0D)  // Weaker baby
            .add(Attributes.ATTACK_DAMAGE, 5.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }
}