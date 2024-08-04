package com.raidentokado.rotp_bat.entity.stand.stands;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class BatmanEntity extends StandEntity {

    public BatmanEntity(StandEntityType<BatmanEntity> type, World world) {
        super(type, world);
        unsummonOffset = getDefaultOffsetFromUser().copy();
    }

    private final StandRelativeOffset offsetDefault = StandRelativeOffset.withYOffset(0, 0, 0);

    @Override
    public boolean isPickable() {
        return false;
    }

    public StandRelativeOffset getDefaultOffsetFromUser() {
        return offsetDefault;
    }

    @Override
    public float getLeapStrength() {
        return 0;
    }


    private BlockPos prevUserPos;
    private Vector3d prevUserPos1 = new Vector3d(0, 0, 0);
}