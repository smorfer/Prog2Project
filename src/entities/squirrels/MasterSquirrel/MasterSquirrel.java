package entities.squirrels.MasterSquirrel;

import core.EntityContext;
import entities.beasts.GoodBeast;
import entities.plants.Plant;
import entities.squirrelBots.MiniSquirrelBot;
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

    public void spawnMiniSquirrel(EntityContext entityContext, int energy){

        if(this.getEnergy() == 1) return;

        if(this.getEnergy() - energy >= 1){
            this.updateEnergy(entityContext.spawnMiniSquirrel(energy, new MiniSquirrelBot(this.getPreviousLocation(), this.getID())));
        } else {
            this.updateEnergy(entityContext.spawnMiniSquirrel(this.getEnergy() - 1 , new MiniSquirrelBot(this.getPreviousLocation(), this.getID())));
        }

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
