package Entities.squirrels;

public class MiniSquirrel extends Squirrel{

    private int masterID;

    public MiniSquirrel(int ID, int energy, int posX, int posY, int masterID) {
        super(ID, energy, posX, posY);
        this.masterID = masterID;
        //Change energy here!
    }

    @Override
    public void nextStep() {

    }

}
