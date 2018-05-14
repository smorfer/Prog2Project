package entities.squirrelBots;

import botapi.BotController;
import botapi.BotControllerFactory;
import botapi.ControllerContext;
import core.EntityContext;
import core.EntityType;
import core.botImpl.BotControllerFactoryImpl;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

public class MiniSquirrelBot extends MiniSquirrel{

    private final BotControllerFactory botControllerFactory = new BotControllerFactoryImpl();
    private final BotController miniBotController = botControllerFactory.createMiniBotController();
    private ControllerContextImpl controllerContext;

    public MiniSquirrelBot(XY position, int masterID) {
        super(position, masterID);
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
            entityContext.tryMove(MiniSquirrelBot.this, direction);
        }

        @Override
        public void spawnMiniBot(int energy) {

        }

        @Override
        public int getEnergy() {
            return 0;
        }
    }

}
