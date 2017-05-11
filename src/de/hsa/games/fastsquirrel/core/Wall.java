package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class Wall extends Entity {
	final static int ENERGY = -10;

	Wall(int id, XY xy) {
		super(id, ENERGY, xy);
	}

	public EntityType getEntityType(){
		return EntityType.Wall;
	}

}
