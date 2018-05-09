package core.botImpl;

public class BotControllerFactoryImpl implements BotControllerFactory {
    @Override
    public BotController createMasterBotController() {
        return new MasterBotController();
    }

    @Override
    public BotController createMiniBotController() {
        return new MiniBotController();
    }
}
