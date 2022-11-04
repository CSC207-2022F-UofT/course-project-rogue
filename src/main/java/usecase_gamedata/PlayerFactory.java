package usecase_gamedata;

import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;

public class PlayerFactory {
    public Player getPlayer(int maxHP, int atkPT, CollectibleInventory inventory, BasicEquipmentSlots equipments,
                            Integer[] location){
        // I want to leave out Sword and Armor because if we were to have a class system we would be more
        // flexible on that. For example, have a new input of String class and for every class the factory
        // gets the starter equipment and items for that specific class and build the player.



        //This or get from GameData, so Player needs to be created after the items
        return new Player(maxHP, atkPT, inventory, equipments, location);
    }

}
