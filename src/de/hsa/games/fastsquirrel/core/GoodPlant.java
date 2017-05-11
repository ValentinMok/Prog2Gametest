package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class GoodPlant extends Entity {
	private final static int ENERGY = 100;

	GoodPlant(int id, XY xy) {
		super(id, ENERGY, xy);
	}


	public EntityType getEntityType(){
		return EntityType.GoodPlant;
	}
	public void nextStep(EntityContext context){
	}

}
