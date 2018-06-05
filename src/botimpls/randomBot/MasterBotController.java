package botimpls.randomBot;

import botapi.BotController;
import botapi.ControllerContext;
import geom.XYSupport;

public class MasterBotController implements BotController {

    private int counter = 0;

    @Override
    public void nextStep(ControllerContext view) {
        view.move(XYSupport.inputToDirection(XYSupport.getRandomNumber()));
        counter++;

        if(counter >= 6){
            view.spawnMiniBot(view.locate().plus(XYSupport.inputToDirection(XYSupport.getRandomNumber())), 200);
            counter = 0;
        }
    }
}
