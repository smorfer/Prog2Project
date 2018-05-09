package core.botImpl;

import botapi.ControllerContext;
import core.EntityContext;
import core.EntityType;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;

public class MasterSquirrelBot extends MasterSquirrel {

    private final BotControllerFactory botControllerFactory = new BotControllerFactoryImpl();
    private final BotController masterBotController = botControllerFactory.createMasterBotController();
    


    public MasterSquirrelBot(XY position) {
        super(position);
    }

    @Override
    public void nextStep(EntityContext entityContext) {

    }

    //Inner Class:
    private class ControllerContextImpl implements ControllerContext {
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
    }
}
