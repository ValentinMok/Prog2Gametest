package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Board;
import de.hsa.games.fastsquirrel.core.Game;
import de.hsa.games.fastsquirrel.core.HandOperatedMasterSquirrel;
import de.hsa.games.fastsquirrel.core.MasterSquirrelBot;


public class ConsoleBotGame extends Game {
    private MasterSquirrelBot player = new MasterSquirrelBot(1);
    private XY squirrelMove = new XY(0, 0);

    State state;
    Board board;
    MasterSquirrelBot masterbot;


    public ConsoleBotGame() throws InterruptedException {
        super(new State(new Board()));
        this.state = getState();
        this.board = state.getBoard();
        //masterbot.createMasterBotController();
        board.createMasterBot(player);
        board.addOtherEntitys();
        update();

    }
}
