package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class MasterSquirrel extends PlayerEntity {

    MasterSquirrel(int id, XY xy) {
        super(id, 1000, xy);
    }

    public void nextStep(EntityContext context){
        context.tryMove(this, XY.randomVec());
    }
    public EntityType getEntityType(){
        return EntityType.MasterSquirrel;
    }

}
