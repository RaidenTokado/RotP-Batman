package com.raidentokado.rotp_bat.action;

import javax.annotation.Nullable;

import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.raidentokado.rotp_bat.entity.damaging.projectile.BMBatarangEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.entity.stand.StandStatFormulas;
import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.GeneralUtil;

import net.minecraft.world.World;

public class BMBatarang extends StandEntityAction {

    public BMBatarang(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            boolean shift = isShiftVariation();
            double fireRate = StandStatFormulas.projectileFireRateScaling(standEntity, userPower);
            if (shift) fireRate *= 2.5;
            GeneralUtil.doFractionTimes(() -> {
                BMBatarangEntity batarang = new BMBatarangEntity(standEntity, world, userPower);
                batarang.setBreakBlocks(shift);
                batarang.setLowerKnockback(!shift);
                standEntity.shootProjectile(batarang, shift ? 3.0F : 2.0F, shift ? 1.0F : 8.0F);
            }, fireRate);

            BatmanEntity batman = (BatmanEntity) standEntity;
        }
    }

    @Override
    public void onMaxTraining(IStandPower power) {
        power.unlockAction((StandAction) getShiftVariationIfPresent());
    }

    @Override
    public int getStandWindupTicks(IStandPower standPower, StandEntity standEntity) {
        return noPhases(standPower, standEntity) || (standEntity.getCurrentTaskAction() != null
                && standEntity.getCurrentTaskAction().getShiftVariationIfPresent() == this.getShiftVariationIfPresent()) ?
                0 : StandStatFormulas.getHeavyAttackWindup(standEntity.getAttackSpeed(), 0);
    }

    @Override
    public int getStandRecoveryTicks(IStandPower standPower, StandEntity standEntity) {
        return noPhases(standPower, standEntity) ?
                0 : super.getStandRecoveryTicks(standPower, standEntity) * 2;
    }

    private boolean noPhases(IStandPower standPower, StandEntity standEntity) {
        return standPower.getResolveLevel() > 2
                || standPower.getUser() != null && standPower.getUser().hasEffect(ModStatusEffects.RESOLVE.get());
    }

    @Override
    protected boolean isChainable(IStandPower standPower, StandEntity standEntity) {
        return true;
    }

    @Override
    public boolean isFreeRecovery(IStandPower standPower, StandEntity standEntity) {
        return true;
    }

    @Override
    protected boolean isCancelable(IStandPower standPower, StandEntity standEntity, @Nullable StandEntityAction newAction, Phase phase) {
        return phase == Phase.RECOVERY || super.isCancelable(standPower, standEntity, newAction, phase);
    }

    @Override
    public StandRelativeOffset getOffsetFromUser(IStandPower standPower, StandEntity standEntity, StandEntityTask task) {
        return !standEntity.isArmsOnlyMode() && task.getPhase() != Phase.PERFORM ? null : super.getOffsetFromUser(standPower, standEntity, task);
    }

}