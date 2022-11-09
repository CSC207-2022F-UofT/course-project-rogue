package usecase_gamedata;

import entity.BasicEquipmentSlots;
import entity.BasicInventory;
import netscape.javascript.JSObject;

public interface PlayerBuilder {
    void buildMaxHp(int maxHP);
    void buildAtkPt(int atkPt);
    void buildLocation(int[] location);
    void buildEquipmentSlot(JSObject jsObject);
    void buildInventory(GameData gameData);
}
