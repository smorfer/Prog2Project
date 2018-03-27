public class BadPlant extends Entity{

    public BadPlant(int ID, int posX, int posY) {
        super(ID, -100, posX, posY);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }

    @Override
    public void updateEnergy(int deltaEnergy) {
        energy += deltaEnergy;
    }
}