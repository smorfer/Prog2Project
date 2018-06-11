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

    public BoardConfig(){
        if(Files.exists(Paths.get("config.properties"))){
            loadFromFile();
        }
        saveToFile();
    }

    private List<String> botNames = Arrays.asList("nextBot", "randomBot");

    private int SIZE = 50;
    private int maxSteps = 50;
    private int BADBEAST_QUANTITY = 5;
    private int GOODBEAST_QUANTITY = 5;
    private int BADPLANT_QUANTITY = 10;
    private int GOODPLANT_QUANTITY = 10;
    private int BORDER = SIZE*4 - 4;
    private int WALL_QUANTITY = 15;

    private int FPS = 50;
    private int REFRESH_RATE = 50;

    private boolean fxMode = true;
    private boolean botMode = false;


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
            } catch (NumberFormatException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Value/s in config file missing, using default values!");
            }


        } catch (IOException ex) {
            ex.printStackTrace();
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

    public List<String> getBotNames(){
        return botNames;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public int getBADBEAST_QUANTITY() {
        return BADBEAST_QUANTITY;
    }

    public int getGOODBEAST_QUANTITY() {
        return GOODBEAST_QUANTITY;
    }

    public int getBADPLANT_QUANTITY() {
        return BADPLANT_QUANTITY;
    }

    public int getGOODPLANT_QUANTITY() {
        return GOODPLANT_QUANTITY;
    }

    public int getBORDER() {
        return BORDER;
    }

    public int getWALL_QUANTITY() {
        return WALL_QUANTITY;
    }

    public boolean isFxMode() {
        return fxMode;
    }

    public boolean isBotMode() {
        return botMode;
    }
}
