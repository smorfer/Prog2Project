package ui;

import core.BoardView;
import core.EntityType;
import geom.XY;
import ui.CommandHandler.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleUI implements UI {
    private CommandScanner commandScanner = new CommandScanner(GameCommandTypes.values(), new BufferedReader(new InputStreamReader(System.in)));
    private GameCommandProcessor gameCommandProcessor = new GameCommandProcessor();
    @Override
    public void render(BoardView view) {
        String rets = "\n";
        for (int height = 0; height < view.getSize().getY(); height++)
        {
            for(int width = 0; width < view.getSize().getX(); width++)
            {
                EntityType entityType = view.getEntityType(width,height);
                switch (entityType)
                {
                    case WALL:
                        rets+= "W\t";
                        break;
                    case BAD_BEAST:
                        rets += "K\t";
                        break;
                    case GOOD_BEAST:
                        rets += "B\t";
                        break;
                    case BAD_PLANT:
                        rets += "V\t";
                        break;
                    case GOOD_PLANT:
                        rets += "P\t";
                        break;
                    case MASTER_SQUIRREL:
                        rets += "S\t";
                        break;
                    case MINI_SQUIRREL:
                        rets += "M\t";
                        break;
                    default:
                        rets += ".\t";
                        break;
                }

            }
            rets += "\n";
        }
        System.out.println(rets);



    }

    @Override
    public MoveCommand getCommand() {
        Command command;
        try {
            command = commandScanner.next();
            MoveCommand moveCommand = gameCommandProcessor.process(command);

            if(moveCommand != null){
                return moveCommand;
            } else {
                return MoveCommand.ORIGIN;
            }

        } catch (ScanException e) {
            System.out.println("Unknown Command!");
            return MoveCommand.ORIGIN;
        }

    }
}
