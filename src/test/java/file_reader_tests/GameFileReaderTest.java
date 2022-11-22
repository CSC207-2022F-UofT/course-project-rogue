package file_reader_tests;

import FileReader.GameFileReader;
import FileReader.GameFileReader_interface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameFileReaderTest {
    GameFileReader_interface playerFileReader =
            new GameFileReader("playerFileTest.json");

    GameFileReader_interface monsterFileReader =
            new GameFileReader("monsterFileTest.json");

    @Test
    void testBasicPlayerCreation(){
        try {
            Player player = new ObjectMapper().
                    readValue(playerFileReader.findString("class", "Basic Player"), Player.class);
            Assertions.assertEquals(100, player.getMaxHitPoint());
            Assertions.assertEquals(1, player.getAttackPoint());
            Assertions.assertEquals(12323, player.getE)
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}
