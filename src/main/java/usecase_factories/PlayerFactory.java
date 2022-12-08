package usecase_factories;

import entity.PlayerData;
import entity.player.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import file_reader.GameFileReaderInterface;

public class PlayerFactory {

    private static GameFileReaderInterface pf = null;

    public PlayerFactory() {
        PlayerData.setPlayer(null);
    }

    /**
     * Sets the static variable GameFileReaderInterface
     * @param pf: The file reader being set
     */
    public static void setFileReader(GameFileReaderInterface pf) {
        if(PlayerFactory.pf == null) {
            PlayerFactory.pf = pf;
        }
    }

    /**
     * Creates a player from data_base if it hasn't been created, else it gets the player being stored within the
     * player variable
     * @return Player
     */
    public Player create() {
        if (PlayerData.getPlayer() != null) {
            return PlayerData.getPlayer();
        } else {
            try {
                Player createdPlayer =  new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
                PlayerData.setPlayer(createdPlayer);
                return createdPlayer;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        PlayerData.setPlayer(null);
    }

}
