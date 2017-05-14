package de.hsa.games.fastsquirrel.core;


import de.hsa.games.fastsquirrel.botapi.BotController;
import de.hsa.games.fastsquirrel.botapi.BotControllerFactory;
import de.hsa.games.fastsquirrel.botapi.ControllerContext;

public class MiniSquirrelBot {
    public BotControllerFactory botControllerFactor;

    public BotController minniBotController;

    abstract class ControllerContextImpl implements ControllerContext{

    }
}
