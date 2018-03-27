public class Wall extends Entity {
    private static final int INIT_ENERGY = -10;
    public Wall(int ID, int posX, int posY) {
        super(ID, INIT_ENERGY, posX, posY);
    }

    @Override
    public void nextStep() {
    }

    @Override
    public void updateEnergy(int deltaEnergy){}
}
