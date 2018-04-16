package entities.beasts;

import core.EntityContext;
import geom.XY;

public class GoodBeast extends Beast {
    private static final int INIT_ENERGY = 200;
    BeastSimpleBot bot;


    public GoodBeast(XY position) {
        super(INIT_ENERGY, position);
        bot = new BeastSimpleBot();
        // Change energy here!
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        entityContext.tryMove(this, XY.invertVector(bot.getDirection(entityContext, this.getPosition())));
    }


}
