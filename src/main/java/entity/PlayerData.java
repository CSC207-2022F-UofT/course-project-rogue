package entity;
import entity.player.Player;

public class PlayerData {
    private static Player player;

    /**
     * Sets the static Player which the program will use
     * @param player: player being stored
     */
    public static void setPlayer(Player player){
        PlayerData.player = player;
    }

    /**
     * Gets the Player Stored in GameData
     * @return stored player
     */
    public static Player getPlayer(){
        return PlayerData.player;
    }
}
