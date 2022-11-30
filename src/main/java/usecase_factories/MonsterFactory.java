package usecase_factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.monster.Monster;
import file_reader.GameFileReaderInterface;

public class MonsterFactory{

    private final GameFileReaderInterface mf;

    public MonsterFactory(GameFileReaderInterface reader){
        this.mf = reader;
    }

    /**
     * @param index The index of the Monster in the database.
     * @return A random Monster.
     */

    public Monster create(int index){
        try {
            return new ObjectMapper().readValue(mf.findInt("index", index), Monster.class);
        } catch (JsonProcessingException e) {
             throw new RuntimeException(e);
        }
    }
}
