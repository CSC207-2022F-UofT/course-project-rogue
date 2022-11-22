package usecase_gamedata;

import entity.monster.Monster;
import entity.monster.Power;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Monster.Monster;
import file_reader.GameFileReaderInterface;

public class MonsterFactory{

    private static GameFileReaderInterface mf; // not sure if its problematic to have this as static

    public MonsterFactory(GameFileReaderInterface mf){
        MonsterFactory.mf = mf;
    }

    /**
     * @param index The index of the Monster in the database.
     * @return A random Monster.
     */

    public static Monster createRandom(int index){
        try {
            return new ObjectMapper().readValue(mf.findInt("index", index), Monster.class);
        } catch (JsonProcessingException e) {
             throw new RuntimeException(e);
        }
    }
}
