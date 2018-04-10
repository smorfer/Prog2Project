package core;

import geom.XY;

import java.util.Scanner;

import static geom.XY.inputToDirection;

public class Game {


    Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            render();
            processInput();
            update();
        }
    }

    public void render(){}

    public XY processInput(){
        int direction = sc.nextInt();
        return inputToDirection(direction);
    }

    public void update(){

    }
}




