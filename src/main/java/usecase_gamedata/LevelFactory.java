package usecase_gamedata;

import entity.Player;
import usecase_playeractions.Map;

/**
 * Generate the level.
 * Creates a map and set the spawn point of the Player based on the level.
 */
public class LevelFactory {

    public LevelFactory(){}

    /**
     * Create a Map based on the level.
     * @param level The level number.
     * @return The Map of that level.
     */
    public Map create(int level){
        //TODO:implement this
        return null;
    }

    /**
     * Set SpawnPoint of the Player according to level.
     * @param player The Player.
     * @param level The level ID.
     */
    public void setSpawnPoint(Player player,int level){
        //TODO:implement this
    }


}
