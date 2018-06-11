package core.gameTypes;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import core.Board;
import core.State;
import entities.squirrelBots.MasterSquirrelBot;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import ui.CommandHandler.GameCommandProcessor;
import ui.MoveCommand;
import ui.UI;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiPlayerBotGame extends Game{
    private MasterSquirrel bot1, bot2, bot3, bot4;

    private Map<String, ArrayList<Integer>> scores = new HashMap<>();

    private int runs = 0;

    public MultiPlayerBotGame(State state, UI ui, Board board) {
        super(state, ui, board);
        resetBots(board);
        masters.addAll(Arrays.asList(bot1, bot2, bot3, bot4));
        board.getEntitySet().addAll(masters);
        board.setMasters(masters);
    }

    private void resetBots(Board board) {
        bot1 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(0));
        bot2 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(0));
        bot3 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(1));
        bot4 = new MasterSquirrelBot(board.getFreePosition(), board.getConfig().getBotNames().get(1));
    }


    @Override
    protected void processInput() {
        GameCommandProcessor processor = new GameCommandProcessor(board);
        try {
            processor.process(ui.getCommand());
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "No command!");
        }
    }

    @Override
    protected void render() {
        ui.render(state.flattenedBoard());
    }

    @Override
    public void resetGame() {

        this.board = new Board();
        this.state = new State(board);
        board.fillBoard();
        board.setCurrentStepAmount(0);


        resetBots(board);

        List<MasterSquirrel> newMasters = Arrays.asList(bot1, bot2, bot3, bot4);
        board.getEntitySet().addAll(newMasters);
        board.setMasters(newMasters);
        this.masters = newMasters;
    }

    @Override
    public void run() {
        MoveCommand command;
        Timer timer = new Timer();
        Timer timer1 = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                render();
            }
        }, 0, 1000/getFPS());

        timer1.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {

                        if(runs >= 10){
                            saveBotScores();
                            System.exit(-1);
                        }

                        if(board.getRemainingSteps() == 0){

                            masters.forEach(e -> {
                                ArrayList<Integer> list = scores.computeIfAbsent(((MasterSquirrelBot)e).getBotName(), k -> new ArrayList<>());
                                list.add(e.getEnergy());
                            });

                            resetGame();
                            runs++;

                        }
                        processInput();
                    }
                }, 0, 1000/getREFRESH_RATE());
    }

    @Override
    public void saveBotScores() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File("scores.json"), scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
