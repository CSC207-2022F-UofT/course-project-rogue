package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.player.Player;
import file_reader.GameFileReaderInterface;
import file_reader.deserialization.DeserializeHelper;
import game_data.PlayerInstances;
import interface_adapters.OutputBoundary;
import usecase_playeractions.Map;

import java.util.HashMap;

public class MapFactory {

    private static GameFileReaderInterface mf;

    private static OutputBoundary outputBoundary = null;
    public MapFactory(){
    }

    public static void setOutputBoundary(OutputBoundary outputBoundary){
        if(MapFactory.outputBoundary == null) {
            MapFactory.outputBoundary = outputBoundary;
        }
    }

    public static void setFileReader(GameFileReaderInterface fileReader){
        MapFactory.mf = fileReader;
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
            outputBoundary.updateMap(map.getStringBoard());
            return map;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets player location to the starting location of the latest map created.
     * @param player : The player instance of the game
     */
    public void setSpawnPoint(Player player, int level){
        String jsonString = mf.findInt("index", level);
        try {
            JsonNode mn = new ObjectMapper().readTree(jsonString);
            int[] location = new DeserializeHelper().readIntArr(mn.get("starting"));
            player.setLocation(location[0], location[1]);
            outputBoundary.updatePlayerlocation(location);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
