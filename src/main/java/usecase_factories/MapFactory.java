package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.player.Player;
import file_reader.GameFileReaderInterface;
import file_reader.deserialization.DeserializeHelper;
import game_data.PlayerInstances;
import usecase_playeractions.Map;

public class MapFactory {

    private GameFileReaderInterface mf;

    public MapFactory(GameFileReaderInterface mf){
        this.mf = mf;
    }

    public Map create(Player player, int level){
        String jsonString = mf.findInt("index", level);
        try {
            Map map = new ObjectMapper().readValue(jsonString, Map.class);
            JsonNode mn = new ObjectMapper().readTree(jsonString);
            int[] location = new DeserializeHelper().readIntArr(mn.get("starting"));
            player.setLocation(location[0], location[1]);
            return map;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
