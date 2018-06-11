package entities.squirrelBots;

import botapi.BotController;
import botapi.BotControllerFactory;
import botapi.ControllerContext;
import core.EntityContext;
import core.EntityType;
import core.logging.ProxyLoggerFactory;
import entities.Entity;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import exceptions.CreatingBotByNameException;
import exceptions.NotEnoughEnergyException;
import exceptions.WrongMethodUsageException;
import geom.XY;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterSquirrelBot extends MasterSquirrel {


    private ControllerContext controllerContext;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final BotController masterBotController;
    private String botName;

    public MasterSquirrelBot(XY position, String name) {
        super(position);
        botName = name;
        Object factory;

        try {
            Class<?> factoryClass = Class.forName("botimpls." + name + ".BotControllerFactoryImpl");
            factory = factoryClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            logger.log(Level.SEVERE, "MasterSquirrelBot could not create FactoryImpl!");
            throw new CreatingBotByNameException("MasterSquirrelBot could not create FactoryImpl!");
        }

        final BotControllerFactory botControllerFactory = (BotControllerFactory)factory;
        masterBotController = botControllerFactory.createMasterBotController();
    }

    public ControllerContext getControllerContext(EntityContext entityContext){
        if(controllerContext == null){
            ControllerContext controllerContext = new ControllerContextImpl(entityContext);
            this.controllerContext = (ControllerContext)ProxyLoggerFactory.getProxy(controllerContext, this.getClass().getSimpleName());
        }

        return controllerContext;
    }

    @Override
    public void nextStep(EntityContext entityContext) {
        if (!isFrozen()){
            this.masterBotController.nextStep(this.getControllerContext(entityContext));
        }
    }

    public String getBotName() {
        return botName;
    }


    //Inner Class:
    private class ControllerContextImpl implements ControllerContext {

        EntityContext entityContext;

        ControllerContextImpl(EntityContext entityContext){
            this.entityContext = entityContext;
        }

        @Override
        public XY getViewLowerLeft() {
            return new XY(getPosition().x-15,getPosition().y+15);
        }

        @Override
        public XY getViewUpperRight() {
            return new XY(getPosition().x+15,getPosition().y-15);
        }

        @Override
        public XY locate() {
            return MasterSquirrelBot.this.getPosition();
        }

        @Override
        public EntityType getEntityAt(XY xy) {
            Entity entity = this.entityContext.getEntityAt(xy.x, xy.y);
            return this.entityContext.getEntityType(entity);
        }

        @Override
        public boolean isMine(XY xy) {
            return false;
        }

        @Override
        public void move(XY direction) {
            MasterSquirrelBot.this.previousLocation = MasterSquirrelBot.this.getPosition();
            entityContext.tryMove(MasterSquirrelBot.this, direction);

        }

        @Override
        public void spawnMiniBot(XY location, int energy) {

            if(entityContext.getEntityAt(location.x, location.y) != null){
                return;
            }

            try {
                MiniSquirrel ms = spawnMiniSquirrel(location, energy);
                MasterSquirrelBot.this.updateEnergy(-energy);
                entityContext.addEntity(ms);
            } catch (NotEnoughEnergyException e) {
                logger.log(Level.WARNING, "Tried to spawn MiniSquirrel, NotEnoughEnergyException thrown!");
            }
        }

        @Override
        public int getEnergy() {
            return MasterSquirrelBot.this.getEnergy();
        }

        @Override
        public XY directionOfMaster() {
            return null;
        }

        @Override
        public long getRemainingSteps() {
            return 0;
        }

        @Override
        public void implode(int impactRadius) {
            throw new WrongMethodUsageException("Method implode called in MasterSquirrel");
        }






    }
}
