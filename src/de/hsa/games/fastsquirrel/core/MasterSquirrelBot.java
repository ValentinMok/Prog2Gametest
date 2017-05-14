package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.botapi.BotController;
import de.hsa.games.fastsquirrel.botapi.BotControllerFactory;
import de.hsa.games.fastsquirrel.botapi.ControllerContext;


public class MasterSquirrelBot extends MasterSquirrel{
    public BotControllerFactory botControllerFactor;

    public BotController masterBotController;

    abstract class ControllerContextImpl implements ControllerContext {

    }

    public static XY xy = new XY(1,1);

    public MasterSquirrelBot(int id) {
        super(id, xy);
    }


    public void nextStep(EntityContext context) {

    }

    public EntityType getEntityType(){
        return EntityType.HandoperatedMasterSquirrel;
    }

}