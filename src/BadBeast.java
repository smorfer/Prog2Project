public class BadBeast extends Entity{

    public BadBeast(int ID, int posX, int posY) {
        super(ID, -250, posX, posY);
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
