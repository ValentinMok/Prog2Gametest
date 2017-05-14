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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class FxUI extends Scene implements UI {
    public static int CELL_SIZE = 30;
    Canvas boardCanvas;
   static Label msgLabel;
   ImageFiles image= new ImageFiles();



    public FxUI(Parent parent, Canvas boardCanvas, Label msgLabel) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.msgLabel = msgLabel;
    }

    public static FxUI createInstance(XY boardSize) {

        Canvas boardCanvas = new Canvas(CELL_SIZE * boardSize.x, boardSize.y * CELL_SIZE);
        Label statusLabel = new Label();
        VBox top = new VBox();
        /*
        top.setPadding(new Insets(15, 12, 15, 12));
        top.setSpacing(10);
        top.setStyle("-fx-background-color: #336699;");
        */
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
                        gc.drawImage(image.getImage(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case GoodBeast:

                        gc.drawImage(image.getImage1(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case BadBeast:

                        gc.drawImage(image.getImage2(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case GoodPlant:

                        gc.drawImage(image.getImage3(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case BadPlant:

                        gc.drawImage(image.getImage4(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case MasterSquirrel:
                        gc.drawImage(image.getImage6(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                        break;
                    case MinniSquirrel:
                        gc.drawImage(image.getImage5(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        break;
                    case HandoperatedMasterSquirrel:
                        gc.drawImage(image.getImage6(),i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        String s="Energy : "+view.getEnergy();
                        message(s);
                        break;
                    case None:

                        break;
                }
            }





        }
    }

    public void message(final String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                msgLabel.setText(msg);
            }
        });
    }


}
