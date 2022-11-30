package file_writer;

import entity.player.Player;
import file_reader.GameFileReaderInterface;

public interface GameFileWriterInterface {

    void register(GameFileReaderInterface fileReader);
    void notifyReader();

    void writeToFile(Player player);
}
