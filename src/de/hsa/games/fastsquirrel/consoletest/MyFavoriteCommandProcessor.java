package de.hsa.games.fastsquirrel.util.ui.consoletest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavoriteCommandProcessor {


    private void process() throws ScanExceptions {
        PrintStream outputStream = System.out;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        CommandScanner commandScanner = new CommandScanner(MyFavoriteCommandType.values(), inputReader);

        while (true) { // the loop over all commands with one input line for every command
            Command command;
            Object[] params;
            MyFavoriteCommandType commandType;
            try {
                command = commandScanner.next();
                params = command.getParams();
                commandType = (MyFavoriteCommandType) command.getCommandType();
                switch (commandType) {
                    case EXIT:
                        System.exit(0);
                    case HELP:
                        help();
                        break;
                    case ADDI:
                        addi(params);
                        break;
                    case ADDF:
                        addf(params);
                        break;
                    case ECHO:
                        echo(params);
                        break;
                }
            }catch (ScanExceptions e){
            }
        }
    }

    private void echo(Object[] params) {
        String toEcho = (String) params[0];
        int times = (int) params[1];
        for (int i = 1; i <= times; i++) {
            System.out.print(toEcho + " ");
        }
        System.out.println();
    }

    private void addf(Object[] params) {
        float one = (float) params[0];
        float two = (float) params[1];
        System.out.println(one + " + " + two + " = " + (one + two));
    }

    private void addi(Object[] params) {
        int one = (int) params[0];
        int two = (int) params[1];
        System.out.println(one + " + " + two + " = " + (one + two));
    }

    private static void help() {
        CommandTypeInfo[] commandTypeInfos = MyFavoriteCommandType.values();
        System.out.println("These are the usable commands:");
        for (int i = 0; i <= commandTypeInfos.length - 1; i++) {
            System.out.println(commandTypeInfos[i].getName() + " " + commandTypeInfos[i].getHelpText());
        }
    }

    public static void main(String[] args) throws ScanExceptions {
        MyFavoriteCommandProcessor process = new MyFavoriteCommandProcessor();
        process.process();
    }
}
