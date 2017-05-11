package de.hsa.games.fastsquirrel.console;


public class Command {

    private CommandTypeInfo commandType;
    private Object[] params;

    Command(CommandTypeInfo commandType, Object[] params) {
        this.commandType = commandType;
        this.params = params;
    }


    Object[] getParams() {
        return params;
    }

    CommandTypeInfo getCommandType(){
        return commandType;
    }
}
