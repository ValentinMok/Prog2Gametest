package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.*;

import static de.hsa.games.fastsquirrel.EntityType.HandoperatedMasterSquirrel;

public class FlattenedBoard implements EntityContext, BoardView {
    private Board board;
    private Entity[][] flatBoard;

    public FlattenedBoard(Board board1) {
        this.board = board1;
        this.flatBoard = board1.flatten();

    }


    public XY getSize() {
        return board.getSize();
    }

    public int getEnergy(){
        for (int i=0;i<=board.board.length;i++){
           if( board.board[i].getEntityType()== HandoperatedMasterSquirrel | board.board[i].getEntityType()== EntityType.MasterSquirrelBot){
            return  board.board[i].getEnergy();
           }

        }
        return 0;
    }

    public void tryMove(MinniSquirrel minniSquirrel, XY moveDirection) {
        if (minniSquirrel.getMove() <= 0) {
            XY newPos = new XY(XY.addXy(minniSquirrel.getXy(), moveDirection));
            minniSquirrel.updateEnergy(-1);
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                minniSquirrel.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);

            switch (type) {

                case GoodBeast:
                    minniSquirrel.updateEnergy(newPosEnt.getEnergy());
                    killAndReplace(newPosEnt);
                    minniSquirrel.setXy(newPos);
                    return;
                case BadBeast:
                    minniSquirrel.updateEnergy(newPosEnt.getEnergy());
                    killAndReplace(newPosEnt);
                    minniSquirrel.setXy(newPos);
                    return;
                case GoodPlant:
                    minniSquirrel.updateEnergy(newPosEnt.getEnergy());
                    killAndReplace(newPosEnt);
                    minniSquirrel.setXy(newPos);
                    return;
                case BadPlant:
                    minniSquirrel.updateEnergy(newPosEnt.getEnergy());
                    killAndReplace(newPosEnt);
                    minniSquirrel.setXy(newPos);
                    return;
                case Wall:
                    minniSquirrel.updateEnergy(Wall.ENERGY);
                    minniSquirrel.setMove(3);
                    return;
                case MinniSquirrel:
                    MinniSquirrel minniOther = (MinniSquirrel) newPosEnt;
                    if (minniSquirrel.getPid() == minniOther.getPid()) {
                        return;
                    } else {
                        kill(minniSquirrel);
                        kill(minniOther);
                    }
                    return;
                case MasterSquirrel:
                    if (minniSquirrel.getPid() == newPosEnt.getId()) {
                        newPosEnt.updateEnergy(minniSquirrel.getEnergy());
                    }
                    kill(minniSquirrel);
                    return;
                case HandoperatedMasterSquirrel:
                    if (minniSquirrel.getPid() == newPosEnt.getId()) {
                        newPosEnt.updateEnergy(minniSquirrel.getEnergy());
                    }
                    kill(minniSquirrel);
                    return;
                default:

            }

        } else {
            minniSquirrel.addMove(-1);
        }


    }

    public void tryMove(GoodBeast goodBeast, XY moveDirection) {
        goodBeast.addMove(1);
        if (goodBeast.getMove() % 4 == 0) {
            XY newPos = new XY(XY.addXy(goodBeast.getXy(), moveDirection));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                goodBeast.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case MinniSquirrel:
                    newPosEnt.updateEnergy(GoodBeast.ENERGY);
                    killAndReplace(goodBeast);
                    return;
                case MasterSquirrel:
                    newPosEnt.updateEnergy(GoodBeast.ENERGY);
                    killAndReplace(goodBeast);
                    return;
                default:

            }
        }
    }

    public void tryMove(BadBeast badBeast, XY moveDirection) {
        badBeast.addMove(1);
        if (badBeast.getMove() % 4 == 0) {
            XY newPos = new XY(XY.addXy(badBeast.getXy(), moveDirection));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                badBeast.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case MinniSquirrel:
                    newPosEnt.updateEnergy(BadBeast.ENERGY);
                    badBeast.addABite();
                    if (badBeast.getBites() == 7) {
                        killAndReplace(badBeast);
                    }
                case HandoperatedMasterSquirrel:
                case MasterSquirrel:
                    newPosEnt.updateEnergy(BadBeast.ENERGY);
                    badBeast.addABite();
                    if (badBeast.getBites() == 7) {
                        killAndReplace(badBeast);
                    }
                    return;
                default:

            }
        }
    }

    public void tryMove(MasterSquirrel masterSquirrel, XY moveDirection) {

        if (masterSquirrel.getMove() <= 0) {
            XY newPos = new XY(XY.addXy(masterSquirrel.getXy(), moveDirection));
            Entity newPosEnt = flatBoard[newPos.x][newPos.y];
            if (newPosEnt == null) {
                masterSquirrel.setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos);
            switch (type) {
                case Wall:
                    masterSquirrel.updateEnergy(Wall.ENERGY);
                    masterSquirrel.setMove(3);
                    return;
                case MinniSquirrel:
                    MinniSquirrel minniSquirrel = (MinniSquirrel) newPosEnt;
                    if (masterSquirrel.getId() == minniSquirrel.getPid()) {
                        masterSquirrel.updateEnergy(minniSquirrel.getEnergy());
                        kill(minniSquirrel);
                    } else {
                        masterSquirrel.updateEnergy(150);
                        kill(minniSquirrel);
                    }
                    break;
                case MasterSquirrel:
                    return;

                default:
                    masterSquirrel.updateEnergy(newPosEnt.getEnergy());
                    killAndReplace(newPosEnt);

            }
            masterSquirrel.setXy(newPos);
        } else {
            masterSquirrel.addMove(-1);
        }
    }

    public PlayerEntity nearestPlayerEntity(XY xy) {
        int distance = 7;
        int m = -1;
        for (int i = 0; i <= board.board.length - 1; i++) {
            if (board.board[i] != null) {
                if (board.board[i].getEntityType() == HandoperatedMasterSquirrel) {
                    int disx = xy.x - board.board[i].getXy().x;
                    int disy = xy.y - board.board[i].getXy().y;
                    int dis = Math.abs(disx) + Math.abs(disy);
                    if (dis < distance) {
                        distance = dis;
                        m = i;
                    }
                }
            }
        }
        if (m >= 0) {
            return (PlayerEntity) board.board[m];
        }
        return null;
    }

    public PlayerEntity nearestEnemy(XY xy){
        int distance = 7;
        int m = -1;
        for (int i = 0; i <= board.board.length - 1; i++) {
            if (board.board[i] != null) {
                if (board.board[i].getEntityType() == EntityType.GoodBeast | board.board[i].getEntityType() == EntityType.GoodPlant) {
                    int disx = xy.x - board.board[i].getXy().x;
                    int disy = xy.y - board.board[i].getXy().y;
                    int dis = Math.abs(disx) + Math.abs(disy);
                    if (dis < distance) {
                        distance = dis;
                        m = i;
                    }
                }
            }
        }
        if (m >= 0) {
           // return (PlayerEntity) board.board[m];
        }
        return null;
    }

    public Entity[][]getFlatBoard(){
        return this.flatBoard;
    }


    public void kill(Entity entity) {
        board.deleteEntity(entity.getId());
    }

    public void killAndReplace(Entity entity) {
        board.deleteEntity(entity.getId());
        switch (entity.getEntityType()) {
            case BadPlant:
                board.createBadPlant();
                break;
            case BadBeast:
                board.createBadBeast();
                break;
            case GoodBeast:
                board.createGoodBeast();
                break;
            case GoodPlant:
                board.createGoodPlant();
                break;
        }


    }

    public EntityType getEntityType(XY xy) {
        return getEntityType(xy.x, xy.y);
    }

    public EntityType getEntityType(int x, int y) {
        if (flatBoard[x][y]==null){
            return EntityType.None;
        }
        return flatBoard[x][y].getEntityType();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i <= board.getSizeX() - 1; i++) {
            for (int j = 0; j <= board.getSizeY() - 1; j++) {
                if (flatBoard[i][j] == null) {
                    s = s + "  ";
                } else {
                    s = s + resolveMarkers(flatBoard[i][j]);
                }
            }
            s = s + "\r\n";
        }
        return s;
    }

    private String resolveMarkers(Entity entity) {
        switch (entity.getEntityType()) {
            case Wall:
                return "W ";
            case GoodBeast:
                return "G ";
            case BadBeast:
                return "B ";
            case GoodPlant:
                return "g ";
            case BadPlant:
                return "b ";
            case MasterSquirrel:
                return "M ";
            case MinniSquirrel:
                return "m ";
            case HandoperatedMasterSquirrel:
                return "H ";
            default:
                return "O ";
        }

    }
    public boolean isEmptyField(XY xy){
        return flatBoard[xy.x][xy.y] == null;
    }

}
