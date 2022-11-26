package driver;

import entity.Player;
import fileAccess.GameFileAccess;
import fileAccess.GameFileAccessInterface;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;
import interface_adapters.OutputBoundary;
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
        GameFileAccessInterface<Player> playerAccess = new GameFileAccess(playerReader, playerWriter);

        //Use cases inject outputBoundary and fileReader(Note - use playerAccess for player fileReader or saving),


        //Controller inject inputBoundaries


        //replace c with initialized controller
        vi.setController(c);
        vi.setVisible(true);
    }

}
