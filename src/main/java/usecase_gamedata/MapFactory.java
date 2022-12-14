package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.player.Player;
import file_reader.GameFileReaderInterface;
import file_reader.deserialization.DeserializeHelper;
import interface_adapters.OutputBoundary;
import usecase_playeractions.Map;

public class MapFactory {

    private static GameFileReaderInterface mf = null;

    private static OutputBoundary outputBoundary = null;
    public MapFactory(){
    }

    /**
     * Sets up the output boundary if it hasn't been set for Map Factory
     * @param outputBoundary: the output Boundary for this Map Factory
     */
    public static void setOutputBoundary(OutputBoundary outputBoundary){
        if(MapFactory.outputBoundary == null) {
            MapFactory.outputBoundary = outputBoundary;
        }
    }

    /**
     * Sets the static variable GameFileReaderInterface
     * @param fileReader: The file reader being set
     */
    public static void setFileReader(GameFileReaderInterface fileReader){
        if(MapFactory.mf == null)
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

            outputBoundary.updatePlayerLocation(location);
            outputBoundary.updateHp(player.getCurrHitPoint());
            outputBoundary.updateEssenceCnt(player.getEssence().getNum());
            outputBoundary.updateArtifact(player.getArtifact().getNum());
            outputBoundary.updateText("A voice whispers to you:", "\" You must get 5 Artifact to leave this place \"","" ,"");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
