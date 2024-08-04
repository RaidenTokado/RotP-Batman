package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<StandStats>, StandEntityType<BatmanEntity>>
            BATMAN_STAND = new EntityStandSupplier<>(InitStands.STAND_BATMAN);
}