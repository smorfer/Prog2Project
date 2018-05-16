package entities.squirrels.MasterSquirrel;

import core.EntityContext;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import entities.squirrelBots.MiniSquirrelBot;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import entities.squirrels.Squirrel;
import exceptions.NotEnoughEnergyException;
import geom.XY;
import geom.XYSupport;
import ui.MoveCommand;

public abstract class MasterSquirrel extends Squirrel {
    private static final int INIT_ENERGY = 2000;

    public XY previousLocation = this.getPosition();
    public MasterSquirrel(XY position) {
        super(INIT_ENERGY, position);
        //Change energy here!
    }


    public void doNextStep(EntityContext entityContext, MoveCommand moveCommand){

        previousLocation = this.getPosition();
        entityContext.tryMove(this, XYSupport.commandToMove(moveCommand));


    }

    public MiniSquirrel spawnMiniSquirrel(XY pos, int energy) throws NotEnoughEnergyException{

        if(this.getEnergy() < energy)
            throw new NotEnoughEnergyException("Not enough energy to spawn a MiniSquirrel");

        if(this.getEnergy() - energy >= 1) {
            this.updateEnergy(-energy);
            return new MiniSquirrelBot(pos, this);
        }


        return null;
    }

    public void hit(EntityContext entityContext, MiniSquirrel miniSquirrel){
        if(miniSquirrel.getMasterID() == this.getID()){
            this.updateEnergy(miniSquirrel.getEnergy());
        } else{
            this.updateEnergy(+150);
        }

        entityContext.kill(miniSquirrel);
    }

    @Override
    public void updateEnergy(int deltaEnergy) {

        if(this.getEnergy()+deltaEnergy <= 0) {
            super.updateEnergy(-(this.getEnergy()-1));
        }else{
            super.updateEnergy(deltaEnergy);
        }


    }

    public XY getPreviousLocation() {
        return previousLocation;
    }

}
