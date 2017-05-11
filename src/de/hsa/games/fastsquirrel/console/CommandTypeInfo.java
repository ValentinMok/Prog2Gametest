package de.hsa.games.fastsquirrel.console;

public interface CommandTypeInfo {
    String getName();
    String getHelpText();
    Class<?>[] getParamTypes();
}
