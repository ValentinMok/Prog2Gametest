package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.core.Board;
import de.hsa.games.fastsquirrel.core.Game;
import de.hsa.games.fastsquirrel.core.HandOperatedMasterSquirrel;
import de.hsa.games.fastsquirrel.core.MasterSquirrel;
import javafx.scene.input.KeyCode;

import static de.hsa.games.fastsquirrel.console.ConsoleUI.command;

public class ConsoleSinglePlayer extends Game {
    private HandOperatedMasterSquirrel player = new HandOperatedMasterSquirrel(1);
    private XY squirrelMove = new XY(0, 0);

    State state;
    Board board;


    public ConsoleSinglePlayer() throws InterruptedException {
        super(new State(new Board()));
        this.state = getState();
        this.board = state.getBoard();
        board.createHandOperated(player);
        board.addOtherEntitys();
        update();

    }

    protected void processInput() {
        Command command;
        Object[] params;
        GameCommandType commandType;
        try {
            command = ui.getCommand();

        } catch (ScanExceptions e) {
            command = null;
        }
        if (command != null) {
            params = command.getParams();
            commandType = (GameCommandType) command.getCommandType();
            switch (commandType) {
                case UP:
                    this.squirrelMove = new XY(-1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case RIGHT:
                    this.squirrelMove = new XY(0, 1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case DOWN:
                    this.squirrelMove = new XY(1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case LEFT:
                    this.squirrelMove = new XY(0, -1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case HELP:
                    help();
                    break;
                case ALL:
                    all();
                    break;
                case EXIT:
                    System.exit(0);
                case MASTER_ENERGY:
                    masterEnergy();
                    break;
                case SPAWN_MINI:
                    spawnMini(params);
                    break;
            }
        }


    }

    public void processInputFps() {
        Command command;
        Object[] params;
        GameCommandType commandType;

            command = ConsoleUI.getLastCommand();

        if (command != null) {
            params = command.getParams();
            commandType = (GameCommandType) command.getCommandType();
            switch (commandType) {
                case UP:
                    this.squirrelMove = new XY(-1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case RIGHT:
                    this.squirrelMove = new XY(0, 1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case DOWN:
                    this.squirrelMove = new XY(1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case LEFT:
                    this.squirrelMove = new XY(0, -1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case HELP:
                    help();
                    break;
                case ALL:
                    all();
                    break;
                case EXIT:
                    System.exit(0);
                case MASTER_ENERGY:
                    masterEnergy();
                    break;
                case SPAWN_MINI:
                    spawnMini(params);
                    break;
            }
        }


    }

    public void processInputFps2() {
        KeyCode command;

        command = ConsoleUI.getLastKey();

        if (command != null) {


            switch (command) {
                case W:
                    this.squirrelMove = new XY(-1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case D:
                    this.squirrelMove = new XY(0, 1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case S:
                    this.squirrelMove = new XY(1, 0);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case A:
                    this.squirrelMove = new XY(0, -1);
                    player.nextStep(getState().getContext(), squirrelMove);
                    updateAfterMaster();
                    break;
                case H:
                    help();
                    break;
                case O:
                    all();
                    break;
                case M:
                    masterEnergy();
                    break;
                case N:
                    if(player.getEnergy()>=200) {
                        spawnMini(100);
                    }
                    break;
                case ESCAPE:
                    System.exit(-1);
            }
        }


    }

    private void spawnMini(int params) {
        int energy = params;
        player.updateEnergy(-energy);
        XY xy;

        do {
            xy = new XY(XY.addXy(player.getXy(), XY.randomVec()));
        } while (!board.possibleSet(xy.x, xy.y));
        board.createMinni(player.getId(), energy, xy);
    }

    private void spawnMini(Object[] params) {
        int energy = (int) params[0];
        player.updateEnergy(-energy);
        XY xy;

        do {
            xy = new XY(XY.addXy(player.getXy(), XY.randomVec()));
        } while (!board.possibleSet(xy.x, xy.y));
        board.createMinni(player.getId(), energy, xy);
    }

    private void masterEnergy() {
        System.out.println("Your Energy: " + player.getEnergy());
    }



    private void all() {
        System.out.println(getState().getBoard().toString());
    }

    private static void help() {
        CommandTypeInfo[] commandTypeInfos = GameCommandType.values();
        System.out.println("These are the usable commands:");
        for (int i = 0; i <= commandTypeInfos.length - 1; i++) {
            System.out.println(commandTypeInfos[i].getName() + " " + commandTypeInfos[i].getHelpText());
        }
    }

}
