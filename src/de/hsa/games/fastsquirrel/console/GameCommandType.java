package de.hsa.games.fastsquirrel.console;

public enum GameCommandType implements CommandTypeInfo {
    HELP("help", "  * list all commands"),
    EXIT("exit", "  * exit program"),
    ALL("all", " * list all entities"),
    LEFT("a", " * go left") ,
    UP("w", " * go up"),
    DOWN("s", " * go down"),
    RIGHT("d", " * do right"),
    MASTER_ENERGY("m", " * display masters energy"),
    SPAWN_MINI("n" ,"<param> * spawn new minnisquirrel with given energy >100",int.class);




    private final String commandType;
    private final String commandExplanation;
    private final Class inputType1;

    GameCommandType(String command, String explanation) {
        this.commandType = command;
        this.commandExplanation = explanation;
        inputType1 = null;
    }

    GameCommandType(String command, String s, Class type1) {
        this.commandType = command;
        this.commandExplanation = s;
        this.inputType1 = type1;
    }





    public String getCommandType() {
        return commandType;
    }

    public String getCommandExplanation() {
        return commandExplanation;
    }

    public Class getInputType1() {
        return inputType1;
    }



    @Override
    public String getName() {
        return getCommandType();
    }

    @Override
    public String getHelpText() {
        return getCommandExplanation();
    }

    @Override
    public Class<?>[] getParamTypes() {
        Class<?>[] type = new Class<?>[1];
        type[0] = getInputType1();
        return type;
    }
}