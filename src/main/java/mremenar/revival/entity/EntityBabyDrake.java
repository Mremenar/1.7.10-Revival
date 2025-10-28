package mremenar.revival.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import mremenar.revival.RevivalMain;

public class EntityBabyDrake extends Animal {
    private boolean tamed = false;
    private Player owner = null;
    private int growTimer = 0;

    public EntityBabyDrake(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!this.level().isClientSide && !this.isTamed() && stack.is(Items.BEEF)) {
            if (!player.getAbilities().instabuild) stack.shrink(1);
            this.tamed = true;
            this.owner = player;
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.tamed && ++growTimer >= 24000) {
            EntityDrake adult = RevivalMain.DRAKE.get().create((ServerLevel) this.level());
            if (adult != null) {
                adult.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
                adult.tamed = true;     // public
                adult.owner = this.owner; // public
                this.level().addFreshEntity(adult);
                this.discard();
            }
        }
    }

    public boolean isTamed() { return tamed; }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) { return null; }
}