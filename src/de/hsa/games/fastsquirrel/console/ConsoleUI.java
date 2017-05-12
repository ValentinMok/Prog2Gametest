package de.hsa.games.fastsquirrel.console;

import de.hsa.games.fastsquirrel.UI;
import de.hsa.games.fastsquirrel.core.BoardView;
import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleUI implements UI {
    public static Command command=null;
    public static KeyCode key=null;

    public Command getCommand() throws ScanExceptions{
        PrintStream outputStream = System.out;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        CommandScanner commandScanner = new CommandScanner(GameCommandType.values(), inputReader);
        try {
            return commandScanner.next();
        } catch (ScanExceptions e) {
            return null;
        }
    }

    public static void setKey(KeyCode newkey){
        key=newkey;
    }


    public static KeyCode getLastKey(){
        KeyCode newkey = key;
        key=null;
        return newkey;

    }



    public static Command getLastCommand(){
        Command direction = command;
        command=null;
        return direction;

    }

    public static void giveCommand() throws ScanExceptions{

            PrintStream outputStream = System.out;
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            CommandScanner commandScanner = new CommandScanner(GameCommandType.values(), inputReader);

            try {
                command = commandScanner.next();
            } catch (ScanExceptions e) {
                command = null;
            }


    }


    public void render(BoardView view) {
        for (int i = 0; i <= view.getSize().x - 1; i++) {
        for (int j = 0; j <= view.getSize().y - 1; j++) {
                switch (view.getEntityType(i, j)) {
                    case Wall:
                        System.out.print("W ");
                        break;
                    case GoodBeast:
                        System.out.print("G ");
                        break;
                    case BadBeast:
                        System.out.print("B ");
                        break;
                    case GoodPlant:
                        System.out.print("g ");
                        break;
                    case BadPlant:
                        System.out.print("b ");
                        break;
                    case MasterSquirrel:
                        System.out.print("M ");
                        break;
                    case MinniSquirrel:
                        System.out.print("m ");
                        break;
                    case HandoperatedMasterSquirrel:
                        System.out.print("H ");
                        break;
                    case None:
                        System.out.print("  ");
                        break;
                }
            }
            System.out.println();
        }
    }

}