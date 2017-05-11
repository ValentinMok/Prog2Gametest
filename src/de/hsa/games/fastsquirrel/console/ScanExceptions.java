package de.hsa.games.fastsquirrel.console;

public class ScanExceptions extends Exception{
    ScanExceptions(String string) {
        System.out.println(string);
        System.out.println("type 'help' for a list of commands");
    }
}
