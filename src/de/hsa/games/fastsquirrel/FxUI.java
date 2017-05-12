package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.*;
import de.hsa.games.fastsquirrel.core.BoardView;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class FxUI extends Scene implements UI {
    public static int CELL_SIZE = 50;
    Canvas boardCanvas;
   static Label msgLabel;


    public FxUI(Parent parent, Canvas boardCanvas, Label msgLabel) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.msgLabel = msgLabel;
    }

    public static FxUI createInstance(XY boardSize) {

        Canvas boardCanvas = new Canvas(CELL_SIZE * boardSize.x, boardSize.y * CELL_SIZE);
        Label statusLabel = new Label();
        VBox top = new VBox();
        top.getChildren().add(boardCanvas);
        top.getChildren().add(statusLabel);
        statusLabel.setText(String.valueOf(msgLabel));
        final FxUI fxUI = new FxUI(top, boardCanvas, statusLabel);

        fxUI.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        KeyCode key=keyEvent.getCode();
                        ConsoleUI.setKey(key);

                    }
                }
        );

        return fxUI;
    }


    @Override
    public Command getCommand() throws ScanExceptions {
        return null;
    }


    @Override
    public void render(final BoardView view) {
        Platform.runLater(() -> repaintBoardCanvas(view));
    }

    private void repaintBoardCanvas(BoardView view) {
        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        XY viewSize = view.getSize();


        for (int i = 0; i <= viewSize.x - 1; i++) {
            for (int j = 0; j <= viewSize.y - 1; j++) {
                switch (view.getEntityType(j, i)) {
                    case Wall:
                        gc.setFill(Color.BLACK);
                        gc.fillRect(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case GoodBeast:
                        gc.setFill(Color.DARKGOLDENROD);
                        gc.fillOval(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case BadBeast:
                        gc.setFill(Color.DARKCYAN);
                        gc.fillOval(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case GoodPlant:
                        gc.setFill(Color.GREEN);
                        gc.fillOval(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case BadPlant:
                        gc.setFill(Color.YELLOWGREEN);
                        gc.fillOval(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case MasterSquirrel:
                        gc.setFill(Color.RED);
                        gc.fillRect(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case MinniSquirrel:
                        gc.setFill(Color.GOLD);
                        gc.fillRect(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case HandoperatedMasterSquirrel:
                        gc.setFill(Color.GOLD);
                        gc.fillRect(i * CELL_SIZE, j * CELL_SIZE, 50, 50);
                        break;
                    case None:

                        break;
                }
            }


             gc.fillText("Where are the beasts?", 100, 100);


        }
    }


    // @Override
    public void message(final String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                msgLabel.setText(msg);
            }
        });
    }


}
