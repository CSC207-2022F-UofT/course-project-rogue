package driver;

import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import user_interface.View;
import user_interface.View_Interface;
import user_interface.Visual;

public class Game {

    public static void main(String[] args) {
        View_Interface vi = new View();
        OutputBoundary outBound = new Visual(vi);

        GameFileReaderInterface playerReader = new GameFileReader("data_base/Player.json");
        GameFileReaderInterface monsterReader = new GameFileReader("data_base/Monster.json");
        GameFileReaderInterface mapReader = new GameFileReader("data_base/Map.json");
        GameFileReaderInterface equipmentReader = new GameFileReader("data_base/Equipment.json");
        GameFileReaderInterface collectibleReader = new GameFileReader("data_base/Collectible.json");
        GameFileWriter_Interface playerWriter = new GameFileWriter("data_base/Player_save.json");
        playerWriter.register(playerReader);

        //Use cases inject outputBoundary, fileReader, fileWriter


        //Controller inject inputBoundaries


        //replace c with initialized controller
        vi.setController(c);
        vi.setVisible(true);
    }

}
