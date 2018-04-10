package core;

public class Game {

    private State state;

    public Game(State state)
    {
        this.state = state;
    }

    public void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

    public void render(){}

    public void processInput(){}

    public void update(){

    }
}




