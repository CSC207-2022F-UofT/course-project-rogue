package usecase_gamedata;

import entity.Monster.Monster;

public class MonsterFactory {

    /**
     * @param index The index of the Monster in the database.
     * @return A random Monster.
     */
    public Monster create(int index){
        try {
            return new ObjectMapper().readValue(fileReader.findInt("index", index), Monster.class);
        } catch (JsonProcessingException e) {
             throw new RuntimeException(e);
        }
    }
}
