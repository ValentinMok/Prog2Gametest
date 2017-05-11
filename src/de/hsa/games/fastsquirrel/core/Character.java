package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.XY;

class Character extends Entity {
    private int move = 0;

    Character(int id, int energy, XY xy) {
        super(id, energy, xy);
    }

    int getMove() {
        return move;
    }

    void addMove(int delta) {
        this.move += delta;
    }
    void setMove(int i){
        this.move=i;
    }

}
