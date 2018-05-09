package core.botImpl;

import botapi.ControllerContext;
import geom.XY;

public class MasterBotController implements BotController{

    // This is the actual Bot!
    //TODO: Do not let Sumael Golger work on this!
    //TODO: This requires intelligence!

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XY.inputToDirection(XY.getRandomNumber()));
    }
}
