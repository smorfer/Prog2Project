package entities.plants;

import core.EntityContext;
import geom.XY;

public class GoodPlant extends Plant {
    private static final int INIT_ENERGY = 100;
    public GoodPlant(XY position)
    {
        super(INIT_ENERGY, position);
    }

    @Override
    public void nextStep(EntityContext entityContext) {

    }
}
