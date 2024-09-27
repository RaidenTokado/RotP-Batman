package com.raidentokado.rotp_bat.init;

import com.github.standobyte.jojo.power.impl.stand.stats.TimeStopperStandStats;
import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<TimeStopperStandStats>, StandEntityType<BatmanEntity>>
            BATMAN_STAND = new EntityStandSupplier<>(InitStands.STAND_BATMAN);
}