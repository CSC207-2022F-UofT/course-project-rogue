package usecase_factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.item.Equipment;
import file_reader.GameFileReaderInterface;

public class EquipmentFactory {

    private static GameFileReaderInterface ef = null; // not sure if its problematic to have this as static

    public EquipmentFactory(){

    }

    public static void setFileReader(GameFileReaderInterface fileReader){
        if(EquipmentFactory.ef == null)
            EquipmentFactory.ef = fileReader;
    }

    /**
     * @param index The index of the Equipment in the database.
     * @return A random Monster.
     */

    public static Equipment create(int index){
        try {
            return new ObjectMapper().readValue(ef.findInt("index", index), Equipment.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
