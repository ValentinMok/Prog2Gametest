package de.hsa.games.fastsquirrel.botapi;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.MasterSquirrel;
import de.hsa.games.fastsquirrel.*;
import de.hsa.games.fastsquirrel.core.*;


/**
 * Created by valen on 14.05.2017.
 */
public interface ControllerContext {
    XY getViewLowerLeft();
    XY getViewUpperRight();
    EntityType getEntityAt(XY xy);
    void move(XY direction);
    void spawnMiniBot(XY direction,int energy);
    int getEnergy();
    XY randomVec();
    XY getXy();
    XY addXy(XY xy, XY randomVec);
    EntityType getEntityType(XY xy,EntityContext context);
    void tryMove( XY moveDirection,EntityContext context);
    EntityType getEntityType(int x, int y,EntityContext context);
    void setXy(XY xy);

}
