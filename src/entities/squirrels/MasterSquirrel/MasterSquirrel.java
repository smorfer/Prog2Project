package entities.squirrels.MasterSquirrel;

import Exceptions.NotEnoughEnergyException;
import core.EntityContext;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import geom.XY;
import ui.MoveCommand;

public abstract class MasterSquirrel extends Squirrel {
    private static final int INIT_ENERGY = 1000;

    public XY previousLocation = this.getPosition();
    public MasterSquirrel(XY position) {
        super(INIT_ENERGY, position);
        //Change energy here!
    }


    public void doNextStep(EntityContext entityContext, MoveCommand moveCommand){
        if(moveCommand == MoveCommand.SPAWN_MINI){
            this.spawnMiniSquirrel(entityContext, 200);
        }

        previousLocation = new XY(this.getPosition());
        entityContext.tryMove(this, XY.commandToMove(moveCommand));
        System.out.println(this.toString());


    }

    public void spawnMiniSquirrel(EntityContext entityContext, int energy) throws NotEnoughEnergyException{
        if(this.getEnergy() <= energy){
            throw new NotEnoughEnergyException();
        }

        this.updateEnergy(entityContext.spawnMiniSquirrel(energy, this.getPreviousLocation(), this.getID()));
    }

    public void hit(EntityContext entityContext, MiniSquirrel miniSquirrel){
        if(miniSquirrel.getMasterID() == this.getID()){
            this.updateEnergy(miniSquirrel.getEnergy());
        } else{
            this.updateEnergy(+150);
        }

        entityContext.kill(miniSquirrel);
    }



    public XY getPreviousLocation() {
        return previousLocation;
    }

}
