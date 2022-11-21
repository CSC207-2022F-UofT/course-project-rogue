package usecase_gamedata;

import entity.Equipment;

public class EquipmentFactory {
    /**
     * @param index The index of the Equipment in the database.
     * @return A random Monster.
     */

    public static Equipment create(int index){
        try {
            return new ObjectMapper().readValue(fileReader.findInt("index", index), Equipment.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
