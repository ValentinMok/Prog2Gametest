package de.hsa.games.fastsquirrel.botapi;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

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
}
