public class BadPlant extends Entity{
    private static final int INIT_ENERGY = -100;
    public BadPlant(int ID, int posX, int posY) {
        super(ID, INIT_ENERGY, posX, posY);
        // Change energy here!
    }

    @Override
    public void nextStep() {

    }


}