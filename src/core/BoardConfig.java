package core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardConfig {

    BoardConfig(){
        if(Files.exists(Paths.get("config.properties"))){
            loadFromFile();
        }else{
            loadDefaultValues();
        }
        saveToFile();
    }

    private List<String> botNames;

    private int SIZE;
    private int maxSteps;
    private int BADBEAST_QUANTITY;
    private int GOODBEAST_QUANTITY;
    private int BADPLANT_QUANTITY;
    private int GOODPLANT_QUANTITY;
    private int BORDER;
    private int WALL_QUANTITY;

    private int FPS;
    private int REFRESH_RATE;

    private boolean fxMode;
    private boolean botMode;


    public int getFPS() {
        return FPS;
    }

    public int getRefreshRate() {
        return REFRESH_RATE;
    }

    public int getSize(){
        return SIZE;
    }

    private void loadFromFile(){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and set it

            try {
                this.SIZE = Integer.parseInt(prop.getProperty("SIZE"));
                this.maxSteps = Integer.parseInt(prop.getProperty("maxSteps"));
                this.BADBEAST_QUANTITY = Integer.parseInt(prop.getProperty("BADBEAST_QUANTITY"));
                this.GOODBEAST_QUANTITY = Integer.parseInt(prop.getProperty("GOODBEAST_QUANTITY"));
                this.BADPLANT_QUANTITY = Integer.parseInt(prop.getProperty("BADPLANT_QUANTITY"));
                this.GOODPLANT_QUANTITY = Integer.parseInt(prop.getProperty("GOODPLANT_QUANTITY"));
                this.BORDER = Integer.parseInt(prop.getProperty("BORDER"));
                this.WALL_QUANTITY = Integer.parseInt(prop.getProperty("WALL_QUANTITY"));

                this.FPS = Integer.parseInt(prop.getProperty("FPS"));
                this.REFRESH_RATE = Integer.parseInt(prop.getProperty("REFRESH_RATE"));

                this.botMode = (Integer.parseInt(prop.getProperty("botMode")) != 0);
                this.fxMode = (Integer.parseInt(prop.getProperty("fxMode")) != 0);
                this.botNames = Arrays.asList(prop.getProperty("botNames").split(","));
            } catch (NumberFormatException | NullPointerException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Value/s in config file missing, using default values!");
                loadDefaultValues();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Loading config failed!");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    };

    private void saveToFile(){
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("config.properties");

            prop.setProperty("SIZE", String.valueOf(SIZE));
            prop.setProperty("maxSteps", String.valueOf(maxSteps));
            prop.setProperty("BADBEAST_QUANTITY", String.valueOf(BADBEAST_QUANTITY));
            prop.setProperty("GOODBEAST_QUANTITY", String.valueOf(GOODBEAST_QUANTITY));
            prop.setProperty("BADPLANT_QUANTITY", String.valueOf(BADPLANT_QUANTITY));
            prop.setProperty("GOODPLANT_QUANTITY", String.valueOf(GOODPLANT_QUANTITY));
            prop.setProperty("BORDER", String.valueOf(BORDER));
            prop.setProperty("WALL_QUANTITY", String.valueOf(WALL_QUANTITY));
            prop.setProperty("FPS", String.valueOf(FPS));
            prop.setProperty("REFRESH_RATE", String.valueOf(REFRESH_RATE));
            prop.setProperty("botMode", String.valueOf(botMode ? 1 : 0));
            prop.setProperty("fxMode", String.valueOf(fxMode ? 1 : 0));
            prop.setProperty("botNames", String.join(",", botNames));


            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void loadDefaultValues(){
        SIZE = 30;
        maxSteps = 50;
        BADBEAST_QUANTITY = 5;
        GOODBEAST_QUANTITY = 5;
        BADPLANT_QUANTITY = 10;
        GOODPLANT_QUANTITY = 10;
        BORDER = SIZE*4 - 4;
        WALL_QUANTITY = 15;

        FPS = 50;
        REFRESH_RATE = 8;

        fxMode = true;
        botMode = false;
        botNames = Arrays.asList("nextBot", "randomBot");
    }

    public List<String> getBotNames(){
        return botNames;
    }

    int getMaxSteps() {
        return maxSteps;
    }

    int getBADBEAST_QUANTITY() {
        return BADBEAST_QUANTITY;
    }

    int getGOODBEAST_QUANTITY() {
        return GOODBEAST_QUANTITY;
    }

    int getBADPLANT_QUANTITY() {
        return BADPLANT_QUANTITY;
    }

    int getGOODPLANT_QUANTITY() {
        return GOODPLANT_QUANTITY;
    }

    public int getBORDER() {
        return BORDER;
    }

    int getWALL_QUANTITY() {
        return WALL_QUANTITY;
    }

    boolean isFxMode() {
        return fxMode;
    }

    boolean isBotMode() {
        return botMode;
    }
}
