package usecase_gamedata;

import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;

import java.util.HashMap;

public class BasicPlayerFactory {
    public Player create(HashMap<String, Object> entityInstance, String basicPlayer, CollectibleInventory inventory,
                         BasicEquipmentSlots equipmentSlots) {
        HashMap<String, Object> playerInstances = (HashMap<String, Object>) entityInstance.get(basicPlayer);
        int maxHP = (int) playerInstances.get("Max Hit Point");
        int attackPt = (int) playerInstances.get("Attack Point");
        int[] location = (int[]) playerInstances.get("Location");


        return new Player(maxHP, attackPt, inventory, equipmentSlots, location);
    }
}
