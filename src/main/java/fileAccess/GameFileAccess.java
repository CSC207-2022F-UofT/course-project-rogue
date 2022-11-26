package fileAccess;

import entity.Player;
import file_reader.GameFileReader;
import file_reader.GameFileReaderInterface;


//The purpose of this class is to prevent the original Player.json file to be changed after saving.
//Since the starting file needs to be preserved there will be a second file that the Writer class writes the player
//data to.
public class GameFileAccess implements GameFileAccessInterface<Player>{

    private GameFileReaderInterface fileReader;
    private GameFileWriter_Interfce fileWriter;

    private String OriginalDir;

    public GameFileAccess(GameFileReaderInterface gameFileReaderInterface,
                          GameFileWriter_Interface gameFileWriter_interface){
        fileReader = gameFileReaderInterface;
        fileWriter = gameFileWriter_interface;
        OriginalDir = fileReader.getDir();
    }

    /**
     * @param player : the player to be saved.
     */
    @Override
    public void save(Player player) {
        fileWriter.writeToFile(player);
        fileReader.setDir(fileWriter.getDir());
    }

    /**
     * Setting the file reader to read the original file for player.
     */
    @Override
    public void entityDies(){
        fileReader.setDir(this.OriginalDir);
    }

    /**
     * The purpose of this method is to allow access to fileReader.
     */
    @Override
    public GameFileReaderInterface getFileReader(){
        return this.fileReader;
    }

    /**
     * The purpose of this method is to allow access to fileWriter.
     */
    @Override
    public GameFileWriter_Interfce getFileWriter() {
        return this.fileWriter;
    }
}
