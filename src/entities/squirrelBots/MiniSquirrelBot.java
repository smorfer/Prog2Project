package entities.squirrelBots;

import botapi.BotController;
import botapi.BotControllerFactory;
import botapi.ControllerContext;
import core.EntityContext;
import core.EntityType;
import botimpls.randomBot.BotControllerFactoryImpl;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

public class MiniSquirrelBot extends MiniSquirrel{

    private final BotControllerFactory botControllerFactory = new BotControllerFactoryImpl();
    private final BotController miniBotController = botControllerFactory.createMiniBotController();
    private ControllerContextImpl controllerContext;

    public MiniSquirrelBot(XY position, MasterSquirrel masterSquirrel) {
        super(position, masterSquirrel);
    }

    public ControllerContext getControllerContext(EntityContext entityContext){
        if(controllerContext == null){
            this.controllerContext = new ControllerContextImpl(entityContext);
        }

        return controllerContext;
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        miniBotController.nextStep(this.getControllerContext(entityContext));
    }



    //Inner Class:
    private class ControllerContextImpl implements ControllerContext{

        EntityContext entityContext;

        ControllerContextImpl(EntityContext entityContext){
            this.entityContext = entityContext;
        }


        @Override
        public XY getViewLowerLeft() {
            return new XY(getPosition().x-10,getPosition().y+10);
        }

        @Override
        public XY getViewUpperRight() {
            return new XY(getPosition().x+10,getPosition().y-10);
        }

        @Override
        public XY locate() {
            return null;
        }

        @Override
        public EntityType getEntityAt(XY xy) {
            return null;
        }

        @Override
        public boolean isMine(XY xy) {
            return false;
        }

        @Override
        public void move(XY direction) {
            entityContext.tryMove(MiniSquirrelBot.this, direction);
        }

        @Override
        public void spawnMiniBot(XY direction, int energy) {

        }

        @Override
        public int getEnergy() {
            return 0;
        }

        @Override
        public XY directionOfMaster() {
            return null;
        }

        @Override
        public long getRemainingSteps() {
            return 0;
        }

        @Override
        public void implode(int impactRadius)
        {
            entityContext.implodus(MiniSquirrelBot.this, impactRadius);
        }
    }

}
