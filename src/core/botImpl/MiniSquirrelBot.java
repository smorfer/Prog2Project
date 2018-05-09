package core.botImpl;

import botapi.ControllerContext;
import core.EntityType;
import geom.XY;

public class MiniSquirrelBot {



    //Inner Class:
    private class ControllerContextImpl implements ControllerContext{
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
