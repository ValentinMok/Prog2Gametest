package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.ConsoleSinglePlayer;
import de.hsa.games.fastsquirrel.console.ConsoleUI;
import de.hsa.games.fastsquirrel.console.ScanExceptions;
import de.hsa.games.fastsquirrel.core.BoardConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;



public class Main  {
    public static void main(String[] args) throws InterruptedException, ScanExceptions {


        ConsoleSinglePlayer game = new ConsoleSinglePlayer();



        //game.run();

        game.startGame();
        while (true) {
            ConsoleUI.giveCommand();
        }


        //if // in javafx mode

       // Application.launch(args);


    }

  /*  @Override
    public void start(Stage primaryStage) throws InterruptedException, ScanExceptions {
        BoardConfig boardConfig =new BoardConfig();
       final ConsoleSinglePlayer game = new ConsoleSinglePlayer();



        FxUI fxUI = FxUI.createInstance(boardConfig.getSize());


        primaryStage.setScene(fxUI);

        primaryStage.setTitle("Diligent Squirrel");
        fxUI.getWindow().setOnCloseRequest(new EventHandler() {
           // @Override
            public void handle(WindowEvent evt) {
                System.exit(-1);
            }
        });
        primaryStage.show();

        game.startGame();
        while (true) {
            ConsoleUI.giveCommand();
        }
    }*/



}