package core;

import ui.UI;

public class Game {

    private State state;
    private UI ui;

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

    public void render(){
        ui.render(state.flattenedBoard());
    }

    public void processInput(){
        ui.getCommand(); // Hier muss der command weitergegeben werden an MasterSquirrel
    }

    public void update(){

    }
}




