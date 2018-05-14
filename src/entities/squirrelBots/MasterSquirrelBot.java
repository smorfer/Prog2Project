package entities.squirrelBots;

import ID.IDManager;
import botapi.BotController;
import botapi.BotControllerFactory;
import botapi.ControllerContext;
import core.EntityContext;
import core.EntityType;
import core.botImpl.BotControllerFactoryImpl;
import entities.Entity;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import geom.XY;

import java.net.IDN;

public class MasterSquirrelBot extends MasterSquirrel {

    private final BotControllerFactory botControllerFactory = new BotControllerFactoryImpl();
    private final BotController masterBotController = botControllerFactory.createMasterBotController();
    private ControllerContextImpl controllerContext;



    public MasterSquirrelBot(XY position) {
        super(position);
    }

    public ControllerContext getControllerContext(EntityContext entityContext){
        if(controllerContext == null){
            this.controllerContext = new ControllerContextImpl(entityContext);
        }

        return controllerContext;
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        if (!isFrozen()){
            masterBotController.nextStep(this.getControllerContext(entityContext));
        }
    }


    //Inner Class:
    private class ControllerContextImpl implements ControllerContext {

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
            Entity entity = this.entityContext.getEntityAt(xy.getX(), xy.getY());
            return this.entityContext.getEntityType(entity);
        }

        @Override
        public void move(XY direction) {
            MasterSquirrelBot.this.previousLocation = MasterSquirrelBot.this.getPosition();
            entityContext.tryMove(MasterSquirrelBot.this, direction);

        }

        @Override
        public void spawnMiniBot(int energy) {
            MasterSquirrelBot.this.spawnMiniSquirrel(entityContext, energy);
        }

        @Override
        public int getEnergy() {
            return MasterSquirrelBot.this.getEnergy();
        }
    }
}
