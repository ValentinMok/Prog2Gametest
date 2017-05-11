package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public interface BoardView {
    EntityType getEntityType(int x, int y);
    XY getSize();
}
