public abstract class Entity {
    private final int ID;
    private int energy;
    private int posX;
    private int posY;

    public Entity(int ID, int energy, int posX, int posY) {
        this.ID = ID;
        this.energy = energy;
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void nextStep();

    public abstract void updateEnergy(int deltaEnergy);

    public int getID() {
        return ID;
    }

    public int getEnergy() {
        return energy;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void move(int deltaX, int deltaY)
    {
        posX += deltaX;
        posY += deltaY;
    }
}
