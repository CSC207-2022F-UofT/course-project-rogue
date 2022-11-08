package usecase_gamedata;

import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;

public class BasicPlayerFactory{
    public Player create(int maxHP, int atkPT, CollectibleInventory inventory, BasicEquipmentSlots equipments,
                            int[] location){
        return new Player(maxHP, atkPT, inventory, equipments, location);
    }
}
