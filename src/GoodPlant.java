public class GoodPlant extends Entity {
    public GoodPlant(int ID, int energy, int posX, int posY) {
        super(ID, 100, posX, posY);
    }

    @Override
    public void nextStep() {

    }

    @Override
    public void updateEnergy(int deltaEnergy) {
        energy += deltaEnergy;
    }
}
