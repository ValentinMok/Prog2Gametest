package de.hsa.games.fastsquirrel.core;


import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class HandOperatedMasterSquirrel extends MasterSquirrel {
    public static XY xy = new XY(1,1);

    public HandOperatedMasterSquirrel(int id) {
        super(id, xy);
    }

    public void nextStep(EntityContext context, XY move) {
        context.tryMove(this,move);
    }
    public void nextStep(EntityContext context) {

    }

    public EntityType getEntityType(){
        return EntityType.HandoperatedMasterSquirrel;
    }



}