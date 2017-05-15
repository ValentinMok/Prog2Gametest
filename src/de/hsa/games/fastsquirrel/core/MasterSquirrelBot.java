package de.hsa.games.fastsquirrel.core;

import de.hsa.games.fastsquirrel.EntityType;
import de.hsa.games.fastsquirrel.XY;
import de.hsa.games.fastsquirrel.botapi.BotController;
import de.hsa.games.fastsquirrel.botapi.BotControllerFactory;
import de.hsa.games.fastsquirrel.botapi.ControllerContext;


public class MasterSquirrelBot extends MasterSquirrel{
    public BotControllerFactory botControllerFactor;
    public ControllerContext view;
    public BotController masterBotController;
    public Board board=new Board();

    public static XY xy = new XY(1,1);

    public MasterSquirrelBot(int id) {
        super(id, xy);
    }
    public ControllerContext control=new ControllerContext() {
        @Override
        public XY getViewLowerLeft() {
            return null;
        }

        @Override
        public XY getViewUpperRight() {
            return null;
        }

        @Override
        public EntityType getEntityAt(XY xy) {
            return null;
        }

        @Override
        public void move(XY direction) {

        }

        @Override
        public void spawnMiniBot(XY direction, int energy) {

        }

        @Override
        public int getEnergy() {
            return 0;
        }

        @Override
        public XY randomVec() {
            int i = (int) (Math.random() * 3) - 1;
            int j = (int) (Math.random() * 3) - 1;
            return new XY(i, j);
        }

        @Override
        public XY getXy() {
            return MasterSquirrelBot.xy;
        }

        @Override
        public XY addXy(XY xy1, XY xy2) {
            int newx = xy1.x + xy2.x;
            int newy = xy1.y + xy2.y;
            return new XY(newx, newy);
        }

        @Override
        public void setXy(XY xy) {
            MasterSquirrelBot.xy=xy;
        }

        @Override
        public void tryMove(XY moveDirection, EntityContext context) {
            //  if (this.getMove() <= 0) {
            XY newPos = new XY(addXy(getXy(), moveDirection));
            Entity newPosEnt = context.getFlatBoard()[newPos.x][newPos.y];
            if (newPosEnt == null) {
                setXy(newPos);
                return;
            }
            EntityType type = getEntityType(newPos,context);
            switch (type) {
                case Wall:
                    updateEnergy(Wall.ENERGY);
                    setMove(3);
                    return;
                   /* case MinniSquirrel:
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
                        killAndReplace(newPosEnt);*/

            }
            setXy(newPos);
            //  } else {
            //     masterSquirrel.addMove(-1);
        }
        // }

        public EntityType getEntityType(XY xy,EntityContext context) {

            return getEntityType(xy.x, xy.y,context);
        }

        public EntityType getEntityType(int x, int y,EntityContext context) {

            if (context.getFlatBoard()[x][y]==null){
                return EntityType.None;
            }
            return context.getFlatBoard()[x][y].getEntityType();
        }

    };





    public void nextStep(EntityContext context) {


        this.getXy();
        //control.randomVec();
      control.tryMove(control.randomVec(), context);

        //masterBotController.nextStep(view);
        //control.move(control.randomVec());
       // Entity near=context.nearestPlayerEntity(this.getXy());
       // XY moveDirection;
       // if (near !=null) {
           // moveDirection = new XY(newDirectionTowards(this.getXy(),near.getXy()));
       // }else
        //control.addXy(control.getXy(),control.randomVec());

    }

    public EntityType getEntityType(){
        return EntityType.MasterSquirrelBot;
    }

}