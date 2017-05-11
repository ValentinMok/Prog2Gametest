package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.*;

public interface EntityContext {
    XY getSize();

    void tryMove(MinniSquirrel minniSquirrel, XY moveDirection);

    void tryMove(GoodBeast goodBeast, XY moveDirection);

    void tryMove(BadBeast badBeast, XY moveDirection);

    void tryMove(MasterSquirrel mastersquirrel, XY moveDirection);

    PlayerEntity nearestPlayerEntity(XY xy);


    void kill(Entity entity);

    void killAndReplace(Entity entity);

    EntityType getEntityType(XY xy);

}
