package mremenar.revival.entity;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityDrake extends Monster {  // Keep Monster for flying/health, but override targeting
    private boolean tamed = false;
    private Player owner = null;

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
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));  // Lower priority
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        // NEUTRAL: Only target hostile mobs or if hurt by player
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Enemy.class, true));  // Hostiles only!
        // NO player targeting unless provoked
    }

    // TAMING WITH RAW BEEF
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!this.level().isClientSide && !this.isTamed()) {
            if (stack.is(Items.BEEF)) {  // Raw beef
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                this.tamed = true;
                this.owner = player;
                this.setTarget(null);  // Stop attacking
                return InteractionResult.SUCCESS;
            }
        }
        if (this.isTamed() && this.owner == player) {
            this.setOrderedToSit(!this.isOrderedToSit());  // Sit/stand
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    public boolean isTamed() { return tamed; }
    public Player getOwner() { return owner; }

    // RIDING (mount when tamed)
    @Override
    public boolean isControlledByLocalInstance() {
        return this.isTamed() && super.isControlledByLocalInstance();
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isVehicle() && this.getControllingPassenger() instanceof Player player) {
            // Flying controls: Space=up, Shift=down (basic for now)
            if (player.getDeltaMovement().y() > 0) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, 0.3, 0));
            }
        }
        super.travel(vec);
    }

    @Override
    public boolean causeFallDamage(float f1, float f2, DamageSource src) {
        return false;  // No fall damage
    }

    // PROTECTS OWNER (attacks what hurts owner)
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isTamed() && source.getEntity() instanceof LivingEntity enemy) {
            this.setTarget(enemy);  // Defend self/owner
        }
        return super.hurt(source, amount);
    }
}