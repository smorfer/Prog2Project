package entities.beasts;

import core.EntityContext;
import entities.Entity;
import entities.beasts.Beast;
import entities.beasts.BeastSimpleBot;
import geom.XY;

public class BadBeast extends Beast {
    private static final int INIT_ENERGY = -150;
    private static BeastSimpleBot bot = new BeastSimpleBot();
    private int biteCounter;
    public BadBeast(XY position) {
        super(INIT_ENERGY, position);
        // Change energy here!

        biteCounter = 0;
    }

    public void bite(EntityContext context, Entity target){
        if(biteCounter == 7){
            context.kill(this);
            System.out.println("BadBeast " + this.getID() + " bited 7 times!");
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
        entityContext.tryMove(this, bot.getDirection());
    }
}
