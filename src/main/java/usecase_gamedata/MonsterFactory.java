package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Monster.Monster;
import file_reader.GameFileReader;

public class MonsterFactory{

    /**
     * @param index The index of the Monster in the database.
     * @return A random Monster.
     */

    public static Monster createRandom(int index){
        GameFileReader mf = new GameFileReader("data_base");
        try {
            return new ObjectMapper().readValue(mf.findInt("index", index), Monster.class);
        } catch (JsonProcessingException e) {
             throw new RuntimeException(e);
        }
    }
}
