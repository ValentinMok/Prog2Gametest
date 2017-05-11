package de.hsa.games.fastsquirrel.util.ui.consoletest;

public interface CommandTypeInfo {
    String getName();
    String getHelpText();
    Class<?>[] getParamTypes();
}
