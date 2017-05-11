package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class PlayerEntity extends Character {

	PlayerEntity(int id, int energy, XY xy) {
		super(id, energy, xy);
	}

	public EntityType getEntityType(){
		return EntityType.PlayerEntity;
	}

}
