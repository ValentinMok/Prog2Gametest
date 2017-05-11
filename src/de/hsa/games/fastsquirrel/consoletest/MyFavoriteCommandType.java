package de.hsa.games.fastsquirrel.util.ui.consoletest;

public enum MyFavoriteCommandType implements CommandTypeInfo {
    HELP("help", "  * list all commands"),
    EXIT("exit", "  * exit program"),
    ADDI("addi", "<param1>  <param2>   * simple integer add ", int.class, int.class),
    ADDF("addf", "<param1>  <param2>   * simple float add ", float.class, float.class),
    ECHO("echo", "<param1>  <param2>   * echos param1 string param2 times ", String.class, int.class);


    private final String commandType;
    private final String commandExplanation;
    private final Class inputType1;
    private final Class inputType2;

    MyFavoriteCommandType(String command, String explanation) {

        this.commandType = command;
        this.commandExplanation = explanation;
        this.inputType1 = null;
        this.inputType2 = null;
    }

    MyFavoriteCommandType(String command, String s, Class type1, Class type2) {

        this.commandType = command;
        this.commandExplanation = s;
        this.inputType1 = type1;
        this.inputType2 = type2;
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

    public Class getInputType2() {
        return inputType2;
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
        Class<?>[] type = new Class<?>[2];
        type[0] = getInputType1();
        type[1] = getInputType2();
        return type;
    }
}
