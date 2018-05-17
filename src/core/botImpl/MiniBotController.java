package core.botImpl;

import botapi.BotController;
import botapi.ControllerContext;
import geom.XY;
import geom.XYSupport;

import java.util.Random;


public class MiniBotController implements BotController {

    private int counter = 0;

    @Override
    public void nextStep(ControllerContext view) {

        view.move(XYSupport.inputToDirection(XYSupport.getRandomNumber())); //Code belongs to Samuel Glogger and Luis Schweigard
        counter++;

        if(counter >= 20){
            Random ran = new Random();
            int ranInt = 2+ran.nextInt(8);
            view.implode(ranInt);
        }
    }
}
