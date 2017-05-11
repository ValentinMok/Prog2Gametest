package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class BadBeast extends Character {
	final static int ENERGY = -150;
	private int bites=0;

	BadBeast(int id, XY xy) {
		super(id, ENERGY, xy);

	}

	public void updateEnergy(int delta) {
	}
	public EntityType getEntityType(){
		return EntityType.BadBeast;
	}
	public void nextStep(EntityContext context){
		Entity near=context.nearestPlayerEntity(this.getXy());
		XY moveDirection;
		if (near !=null) {
			moveDirection = new XY(newDirectionTowards(this.getXy(),near.getXy()));
		}else moveDirection=XY.randomVec();
		context.tryMove(this, moveDirection);
	}



	int getBites(){
	    return bites;
    }
    void addABite(){
	    bites++;
    }

}
