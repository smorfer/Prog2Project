package entities.beasts;

import core.EntityContext;
import entities.Entity;
import entities.beasts.Beast;
import entities.beasts.BeastSimpleBot;
import geom.XY;

//TODO: BadBeast has to seek Squirrels

public class BadBeast extends Beast {
    private static final int INIT_ENERGY = -150;
    private static BeastSimpleBot bot;
    private int biteCounter;
    public BadBeast(XY position) {
        super(INIT_ENERGY, position);
        //Change energy here!
        biteCounter = 0;
        bot = new BeastSimpleBot();
    }

    public void bite(EntityContext context, Entity target){
        if(biteCounter == 7){
            context.killAndReplace(this);
            biteCounter = 0;
        }

        target.updateEnergy(this.getEnergy());
        biteCounter++;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "ID=" + getID() +
                ", energy=" + getEnergy() +
                ", position=" + getPosition().toString() +
                ", Bite Counter: " + biteCounter + " }";
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        entityContext.tryMove(this, bot.getDirection(entityContext, this.getPosition()));
    }
}
