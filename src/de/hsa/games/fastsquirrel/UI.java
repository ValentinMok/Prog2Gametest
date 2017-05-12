package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.Command;
import de.hsa.games.fastsquirrel.console.ScanExceptions;
import de.hsa.games.fastsquirrel.core.BoardView;
import javafx.scene.input.KeyCode;

public interface UI {
    Command getCommand() throws ScanExceptions;


    void render(BoardView view);
}
