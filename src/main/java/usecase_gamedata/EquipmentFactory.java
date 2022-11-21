package usecase_gamedata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Equipment;
import file_reader.GameFileReader;

public class EquipmentFactory {
    /**
     * @param index The index of the Equipment in the database.
     * @return A random Monster.
     */

    public static Equipment create(int index){
        GameFileReader ef = new GameFileReader("data_base");
        try {
            return new ObjectMapper().readValue(ef.findInt("index", index), Equipment.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
