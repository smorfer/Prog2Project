package botapi;

import botapi.BotController;

public interface BotControllerFactory {
    BotController createMasterBotController();
    BotController createMiniBotController();
}
