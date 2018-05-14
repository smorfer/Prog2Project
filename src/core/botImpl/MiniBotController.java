package core.botImpl;

import botapi.BotController;
import botapi.ControllerContext;
import geom.XY;


public class MiniBotController implements BotController {

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XY.inputToDirection(XY.getRandomNumber()));
    }
}
