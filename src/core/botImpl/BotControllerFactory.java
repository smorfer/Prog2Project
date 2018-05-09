package core.botImpl;

public interface BotControllerFactory {
    BotController createMasterBotController();
    BotController createMiniBotController();
}
