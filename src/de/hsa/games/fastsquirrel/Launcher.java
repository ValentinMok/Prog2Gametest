package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.ConsoleBotGame;
import de.hsa.games.fastsquirrel.console.ConsoleSinglePlayer;
import de.hsa.games.fastsquirrel.console.ConsoleUI;
import de.hsa.games.fastsquirrel.console.ScanExceptions;
import de.hsa.games.fastsquirrel.core.BoardConfig;
import de.hsa.games.fastsquirrel.core.Game;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
//import java.beans.EventHandler;



public class Launcher extends Application{
    public static void main(String[] args) throws InterruptedException, ScanExceptions {

       // ConsoleSinglePlayer game = new ConsoleSinglePlayer();

        //game.run();

        /*game.startGame();
        while (true) {
            ConsoleUI.giveCommand();
        }*/




            Application.launch(args);


    }


    public void start(Stage primaryStage) throws InterruptedException, ScanExceptions {
        BoardConfig boardConfig =new BoardConfig();
        //final ConsoleSinglePlayer game = new ConsoleSinglePlayer();
        final ConsoleBotGame game = new ConsoleBotGame();
        FxUI fxUI = FxUI.createInstance(boardConfig.getSize());

        primaryStage.setScene(fxUI);
        primaryStage.setTitle("Diligent Squirrel");
        fxUI.render(game.getView());



          fxUI.render(game.getView());




       /* fxUI.getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
           // @Override
            public void handle(WindowEvent evt) {
                System.exit(-1);
            }
        });*/
        primaryStage.show();
        startGame(game,fxUI);

         // fxUI.message("bla");



    }

    public void startGame(Game game, FxUI fxUI){
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


        Timer timer = new Timer();


        timer.schedule(new TimerTask() {

            public void run() {

                fxUI.render(game.getView());
                game.processInputFps2();
                game.update();

            }
        },1,1000/game.FramesPerSecond );
    }



}