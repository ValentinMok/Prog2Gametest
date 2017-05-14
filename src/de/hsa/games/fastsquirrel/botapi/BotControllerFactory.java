package de.hsa.games.fastsquirrel.botapi;

/**
 * Created by valen on 14.05.2017.
 */
public interface BotControllerFactory {
    BotController createMasterBotController();

    BotController createMiniBotController();
}
