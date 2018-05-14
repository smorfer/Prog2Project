package botapi;

import botapi.ControllerContext;

public interface BotController {
    void nextStep(ControllerContext view);
}
