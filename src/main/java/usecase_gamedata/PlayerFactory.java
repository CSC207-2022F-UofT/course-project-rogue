package usecase_gamedata;

import FileReader.playerFileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;

public class PlayerFactory extends factory<Player>{
    public Player getPlayer(int maxHP, int atkPT, CollectibleInventory inventory, BasicEquipmentSlots equipments,
                            int[] location){
        // I want to leave out Sword and entity.Armor because if we were to have a class system we would be more
        // flexible on that. For example, have a new input of String class and for every class the factory
        // gets the starter equipment and items for that specific class and build the player.



        //This or get from GameData, so Player needs to be created after the items
        return new Player(maxHP, atkPT, inventory, equipments, location);
    }

    @Override
    public Player create() {
        playerFileReader pf = new playerFileReader();
        try {
            return new ObjectMapper().readValue(pf.findString("class", "Basic Player"), Player.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
