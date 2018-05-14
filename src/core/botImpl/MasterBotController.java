package core.botImpl;

import botapi.BotController;
import botapi.ControllerContext;
import geom.XY;

public class MasterBotController implements BotController {

    private int counter = 0;

    // This is the actual Bot!
    //TODO: Do not let Sumael Golger work on this!
    //TODO: This requires intelligence!

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XY.inputToDirection(XY.getRandomNumber()));
        counter++;
        if(counter == 4){
            view.spawnMiniBot(200);
            counter = 0;
        }
    }
}
