package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class GoodBeast extends Character {
    final static int ENERGY = 200;

    GoodBeast(int id, XY xy) {
        super(id, ENERGY, xy);
    }

    public void updateEnergy(int delta) {
    }

    public EntityType getEntityType() {
        return EntityType.GoodBeast;
    }

    public void nextStep(EntityContext context) {
        Entity near = context.nearestPlayerEntity(this.getXy());
        XY moveDirection;
        if (near != null) {
            moveDirection = new XY(newDirectionAway(this.getXy(), near.getXy()));
        } else moveDirection = XY.randomVec();
        context.tryMove(this, moveDirection);

    }
}
