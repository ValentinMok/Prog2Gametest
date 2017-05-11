package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.core.Board;
import de.hsa.games.fastsquirrel.core.EntityContext;
import de.hsa.games.fastsquirrel.core.FlattenedBoard;

public class State {
    private Board boardState;


    public State(Board board) {
        this.boardState = board;
    }

    public void update() {
        boardState.doAllMoves(flattenedBoard());
    }


    public FlattenedBoard flattenedBoard() {
        return new FlattenedBoard(boardState);
    }
    public Board getBoard(){
        return boardState;
    }

    public EntityContext getContext(){
        return flattenedBoard();
    }
}
