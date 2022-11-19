package usecase_gamedata;

import entity.Armor;
import entity.BasicEquipmentSlots;
import entity.Weapon;
import org.json.simple.JSONObject;

public interface PlayerBuilder {
    public void buildMaxHp(int maxHP);
    public void buildAtkPt(int atkPt);
    public void buildLocation(int[] location);

    public void buildEquipmentSlot(JSONObject jsonObject);

//    public void buildInventory(GameData gameData);
}
