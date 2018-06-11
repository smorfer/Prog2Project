package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class BoardConfig {

    public BoardConfig(){
        loadFromFile();
    }

    private List<String> botNames = Arrays.asList("nextBot", "randomBot");
    private Path defaultPath = Paths.get("config.properties");

    private final int SIZE = 50;
    private int maxSteps = 50;
    int BADBEAST_QUANTITY = 5;
    int GOODBEAST_QUANTITY = 5;
    int BADPLANT_QUANTITY = 10;
    int GOODPLANT_QUANTITY = 10;
    int BORDER = SIZE*4 - 4;
    int WALL_QUANTITY = 15;
    int MASTERSQUIRREL_QUANTITY = 1;
    int MINISQUIRREL_QUANTITY = 8;
    int ENTITY_QUANTITY = BADBEAST_QUANTITY +
            GOODBEAST_QUANTITY +
            BADPLANT_QUANTITY +
            GOODPLANT_QUANTITY +
            BORDER +
            WALL_QUANTITY +
            MASTERSQUIRREL_QUANTITY +
            MINISQUIRREL_QUANTITY;

    private int FPS = 50;
    private int REFRESH_RATE = 50;


    public int getFPS() {
        return FPS;
    }

    public int getRefreshRate() {
        return REFRESH_RATE;
    }

    public int getSize(){
        return SIZE;
    }

    public void loadFromFile(){



        if(!Files.exists(defaultPath)){
            try {
                Files.createFile(defaultPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Properties config = new Properties();
    };

    public List<String> getBotNames(){
        return botNames;
    }

    public int getMaxSteps() {
        return maxSteps;
    }
}
