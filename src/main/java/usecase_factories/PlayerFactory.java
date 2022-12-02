package usecase_factories;

import entity.player.Player;
import file_reader.GameFileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlayerFactory{

    private final Player player;

    public PlayerFactory(){
        player = null;
    }


    public Player create() {

        if(player != null){
            return player;
        }
        GameFileReader pf = new GameFileReader( "data_base/Player.json");
        try {
            return new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
