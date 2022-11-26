package file_writer;

import entity.player.Player;
import file_reader.GameFileReaderInterface;

public interface GameFileWriterInterface {

    public void register(GameFileReaderInterface fileReader);
    public void notifyReader();

    public void writeToFile(Player player);
}
