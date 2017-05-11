package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.XY;

public class BoardConfig {
    private int height=15;
    private int width=15;
    private XY size=new XY(height,width);
    private int wallCount=0;
    private int goodPlantCount=3;
    private int badPlantCount=3;
    private int goodBeastCount=3;
    private int badBeastCount=3;

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