package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;

public class MinniSquirrel extends PlayerEntity {
	private int parentId;

	MinniSquirrel(int id, int energy, XY xy, int pid) {
		super(id, energy, xy);
		parentId = pid;
		addMove(1);
	}

	public String toString() {
		return this.getClass() + " mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten " + getXy()
				+ " ParentID: " + parentId;
	}

	int getPid() {
		return parentId;
	}

	public EntityType getEntityType(){
		return EntityType.MinniSquirrel;
	}
	public void nextStep(EntityContext context){
		Entity near=context.nearestEnemy(this.getXy());
		XY moveDirection;
		if (near !=null) {
			moveDirection = new XY(newDirectionTowards(this.getXy(),near.getXy()));
		}else moveDirection=XY.randomVec();
		context.tryMove(this, moveDirection);

	}


}
