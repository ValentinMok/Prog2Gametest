package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.*;

public class Board {
    private static BoardConfig BC = new BoardConfig();
    Entity[] board;
    private int ID = 2;


    public Board() {
        this.board = new Entity[BC.getSize().x * BC.getSize().y];
        addSurrounding();

    }

    public void addOtherEntitys() {

        for (int i = 1; i <= BC.getBadBeastCount(); i++) {
            createBadBeast();
        }
        for (int i = 1; i <= BC.getGoodBeastCount(); i++) {
            createGoodBeast();
        }
        for (int i = 1; i <= BC.getBadPlantCount(); i++) {
            createBadPlant();
        }
        for (int i = 1; i <= BC.getGoodPlantCount(); i++) {
            createGoodPlant();
        }

    }

    private void addSurrounding() {
        for (int i = 0; i <= BC.getSize().x - 1; i++) {
            for (int j = 0; j <= BC.getSize().y - 1; j++) {
                if (i == 0 | i == BC.getSize().x - 1 | j == 0 | j == BC.getSize().y - 1) {
                    addEntity(new Wall(ID++, new XY(i, j)));
                }
            }
        }
    }


    private void addEntity(Entity entity) {
        int count = 0;
        while (count <= board.length - 1) {
            if (board[count] == null) {
                board[count] = entity;
                break;
            }
            count++;
        }

    }

    void deleteEntity(int id) {
        for (int i = 0; i <= board.length - 1; i++) {
            if ((board[i] != null) && (board[i].getId() == id)) {
                board[i] = null;
                return;
            }
        }
    }

    Entity[][] flatten() {
        Entity[][] flatBoard = new Entity[BC.getSize().x][BC.getSize().y];
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i] != null) {
                int x = board[i].getXy().x;
                int y = board[i].getXy().y;
                flatBoard[x][y] = board[i];
            }
        }
        return flatBoard;
    }

    private XY randomPos() {
        int x;
        int y;
        do {
            x = (int) (Math.random() * (BC.getSizeX()));
            y = (int) (Math.random() * (BC.getSizeY()));

        } while (!possibleSet(x, y));

        return new XY(x, y);
    }

    XY getSize() {
        return BC.getSize();
    }

    int getSizeX() {
        return BC.getSizeX();
    }

    int getSizeY() {
        return BC.getSizeY();
    }

    public boolean possibleSet(int x, int y) {
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i] != null) {
                if ((board[i].getXy().x == x) && (board[i].getXy().y == y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void doAllMoves(EntityContext context) {

        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i] != null) {
                board[i].nextStep(context);
            }
        }
    }


    void createGoodBeast() {
        addEntity(new GoodBeast(ID++, randomPos()));
    }

    void createBadBeast() {
        addEntity(new BadBeast(ID++, randomPos()));
    }

    void createBadPlant() {
        addEntity(new BadPlant(ID++, randomPos()));
    }

    void createGoodPlant() {
        addEntity(new GoodPlant(ID++, randomPos()));
    }

    public void createHandOperated(HandOperatedMasterSquirrel player) {
        addEntity(player);
    }
    public void createMinni(int pid,int energy,XY xy){
        addEntity(new MinniSquirrel(ID++,energy,xy,pid));
    }

    public String toString() {
        String s = "";
        for (int i = 0; i <= board.length - 1; i++) {
            if ((board[i] != null) && (board[i].getEntityType() != EntityType.Wall)) {
                s = s + board[i].toString() + "\r\n";
            }
        }
        return s;
    }


}
