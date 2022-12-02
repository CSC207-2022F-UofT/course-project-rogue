package usecase_factories;

import entity.player.Player;
import file_reader.GameFileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import file_reader.GameFileReaderInterface;

public class PlayerFactory{

    private final Player player;
    private static GameFileReaderInterface pf;

    public PlayerFactory(){
        player = null;
    }
    public static void setFileReader(GameFileReaderInterface pf){
        PlayerFactory.pf = pf;
    }
    public Player create() {
        if(player != null){
            return player;
        }
        try {
            return new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
