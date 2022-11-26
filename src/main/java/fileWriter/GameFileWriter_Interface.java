package fileWriter;

import entity.Player;
import file_reader.GameFileReaderInterface;

public interface GameFileWriter_Interface {

    public void register(GameFileReaderInterface fileReader);
    public void notifyReader();

    public void writeToFile(Player player);
}
