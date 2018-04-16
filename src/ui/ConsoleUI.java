package ui;

import core.BoardView;
import core.EntityType;
import geom.XY;

import java.util.Scanner;

public class ConsoleUI implements UI {
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
        System.out.print(rets);

    }

    @Override
    public MoveCommand getCommand() {
        Scanner input = new Scanner(System.in);
        switch (input.next())
        {
            case "1":
                return MoveCommand.DOWN_LEFT;
            case "2":
                return MoveCommand.DOWN;
            case "3":
                return MoveCommand.DOWN_RIGHT;
            case "4":
                return MoveCommand.LEFT;
            case "6":
                return MoveCommand.RIGHT;
            case "7":
                return MoveCommand.UP_LEFT;
            case "8":
                return MoveCommand.UP;
            case "9":
                return MoveCommand.UP_RIGHT;
            default:
                return MoveCommand.ORIGIN;

        }
    }
}
