package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.player.Player;
import file_reader.GameFileReaderInterface;
import file_reader.deserialization.DeserializeHelper;
import game_data.PlayerInstances;
import usecase_playeractions.Map;

import java.util.HashMap;

public class MapFactory {

    private GameFileReaderInterface mf;

    private HashMap<Integer, int[]> startingLocations;
    private int level;
    public MapFactory(GameFileReaderInterface mf){
        startingLocations = new HashMap<>();
        this.mf = mf;
    }

    /**
     * This method creates a map and records the starting location of this map.
     * @param level : The index of the map recorded in Map.json
     * @return A Map instance with the corresponding level value.
     */
    public Map create(int level){
        String jsonString = mf.findInt("index", level);
        try {
            Map map = new ObjectMapper().readValue(jsonString, Map.class);
            JsonNode mn = new ObjectMapper().readTree(jsonString);
            int[] location = new DeserializeHelper().readIntArr(mn.get("starting"));
            startingLocations.put(level, location);
            return map;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets player location to the starting location of the latest map created.
     * @param player : The player instance of the game
     */
    public void setPlayerLocation(Player player){
        player.setLocation(startingLocations.get(level)[0], startingLocations.get(level)[1]);
    }
}
