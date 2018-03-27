public class Wall extends Entity {

    public Wall(int ID, int posX, int posY) {
        super(ID, -10, posX, posY);
    }

    @Override
    public void nextStep() {
    }

    @Override
    public void updateEnergy(int deltaEnergy){}




}
