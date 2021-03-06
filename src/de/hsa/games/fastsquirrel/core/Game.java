package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.State;
import de.hsa.games.fastsquirrel.UI;

import de.hsa.games.fastsquirrel.console.ConsoleUI;
import de.hsa.games.fastsquirrel.console.ScanExceptions;
import java.util.TimerTask;
import java.util.Timer;


public class Game {
    private State gameState;
    private BoardView view;
    private FlattenedBoard flattenedBoard;
    public int FramesPerSecond = 10;

    protected UI ui = new ConsoleUI();

    public Game(State state) throws InterruptedException {
    this.gameState=state;
    this.flattenedBoard=gameState.flattenedBoard();
    this.view=flattenedBoard;
    }
    public void run(){
        while(true) {
            render();
            processInput();
            update();
        }
    }

    public void startGame() throws ScanExceptions {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


        Timer timer = new Timer();


        timer.schedule(new TimerTask() {

            public void run() {

                render();
                processInputFps();
                update();

            }
        },1,1000/FramesPerSecond );

    }




    private void render(){
        ui.render(view);
    }



    public BoardView getView(){
        return view;
    }


    public void processInputFps(){

    }
    public void processInputFps2(){

    }

    protected void processInput(){

    }
    public void update(){
        gameState.update();
        flattenedBoard=gameState.flattenedBoard();
        view=flattenedBoard;

    }

    protected void updateAfterMaster(){
        flattenedBoard=gameState.flattenedBoard();
        view=flattenedBoard;

    }
    protected State getState(){
        return gameState;
    }



}
