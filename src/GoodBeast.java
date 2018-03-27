public class GoodBeast extends Entity{

    public GoodBeast(int ID, int posX, int posY) {
        super(ID, 200, posX, posY);
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
