package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.Command;
import de.hsa.games.fastsquirrel.console.ScanExceptions;
import de.hsa.games.fastsquirrel.core.BoardView;

public interface UI {
    Command getCommand() throws ScanExceptions;

    Command getLastCommand();

    void render(BoardView view);
}
