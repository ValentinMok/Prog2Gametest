package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.XY;

public class BoardConfig {
    private int height=30;
    private int width=30;
    private XY size=new XY(height,width);
    private int wallCount=60;
    private int goodPlantCount=8;
    private int badPlantCount=8;
    private int goodBeastCount=8;
    private int badBeastCount=1;

    public void setSize(XY xy){
        size =xy;
    }

    public XY getSize(){
        return size;
    }

    int getSizeX(){
        return height;
    }

    int getSizeY(){
        return width;
    }

    void setWallCount(int i){
        wallCount =i;
    }

    int getWallCount(){
        return wallCount;
    }

    int getGoodPlantCount(){
        return goodPlantCount;
    }

    int getBadPlantCount(){
        return badPlantCount;
    }

    int getGoodBeastCount(){
        return goodBeastCount;
    }

    int getBadBeastCount() {
        return badBeastCount;
    }

}