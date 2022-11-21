package usecase_gamedata;

import file_reader.GameFileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Player;

public class PlayerFactory extends factory<Player>{
    @Override
    public Player create() {
        GameFileReader pf = new GameFileReader( "data_base");
        try {
            return new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
