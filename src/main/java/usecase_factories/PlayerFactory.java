package usecase_factories;

import entity.player.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import file_reader.GameFileReaderInterface;

public class PlayerFactory {

    private Player player;
    private static GameFileReaderInterface pf = null;

    public PlayerFactory() {
        player = null;
    }

    public static void setFileReader(GameFileReaderInterface pf) {
        if(PlayerFactory.pf == null) {
            PlayerFactory.pf = pf;
        }
    }

    public Player create() {
        if (player != null) {
            return player;
        } else {
            try {
                Player createdPlayer =  new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
                this.player = createdPlayer;
                return createdPlayer;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        player = null;
    }

}
