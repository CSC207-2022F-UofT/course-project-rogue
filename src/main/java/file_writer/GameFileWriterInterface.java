package file_writer;

import entity.player.Player;
import file_reader.GameFileReaderInterface;
import usecase_factories.PlayerFactory;

public interface GameFileWriterInterface {

    void register(GameFileReaderInterface fileReader);
    void register(PlayerFactory playerFactory);
    void notifyPlayerFactory();
    void notifyReader();
    void writeToFile(Player player);
}
