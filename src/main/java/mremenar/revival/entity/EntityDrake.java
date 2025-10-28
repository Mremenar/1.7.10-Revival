package mremenar.revival.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityDrake extends Monster {
    public boolean tamed = false;
    public Player owner = null;

    public EntityDrake(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 100;
        this.setMaxUpStep(3.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 500.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 25.0D)
                .add(Attributes.FLYING_SPEED, 0.6D)
                .add(Attributes.FOLLOW_RANGE, 128.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
    ItemStack stack = player.getItemInHand(hand);
    if (!this.level().isClientSide && !this.tamed && stack.is(Items.BEEF)) {
        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }
        this.tamed = true;
        this.owner = player;
        this.setTarget(null);
        // Hearts effect
        this.level().broadcastEntityEvent(this, (byte) 7);
        return InteractionResult.SUCCESS;
    }
    if (this.tamed && this.owner == player) {
        player.startRiding(this);  // MOUNT
        return InteractionResult.SUCCESS;
    }
    return super.mobInteract(player, hand);
}	

    @Override
    public boolean isControlledByLocalInstance() {
        return this.tamed && super.isControlledByLocalInstance();
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player player) {
            this.setYRot(player.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(player.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());

            float forward = player.zza;
            float strafe = player.xxa * 0.5F;

            // Fly up/down using player vertical motion
            double dy = player.getDeltaMovement().y;
            if (dy > 0.1) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, 0.5, 0));
            } else if (dy < -0.1) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, -0.5, 0));
            }

            this.setSpeed(0.6F);
            super.travel(new Vec3(strafe, 0, forward));
        } else {
            super.travel(vec);
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return false;
    }
}