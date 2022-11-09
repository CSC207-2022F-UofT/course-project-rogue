package usecase_gamedata;

import entity.*;
import netscape.javascript.JSObject;

public class BuildBasicPlayer implements PlayerBuilder{
    int maxHitPoint;
    int attackPoint;
    int[] location;
    BasicEquipmentSlots equipments;
    CollectibleInventory inventory;

    @Override
    public void buildMaxHp(int maxHP) {
        this.maxHitPoint = maxHP;
    }

    @Override
    public void buildAtkPt(int atkPt) {
        this.attackPoint = atkPt;
    }

    @Override
    public void buildLocation(int[] location) {
        this.location = location;
    }

    @Override
    public void buildEquipmentSlot(JSObject jsObject) {
        Weapon weapon = entityData.get(jsObject.getString("Weapon"));
        Armor armor = entityData.get(jsObject.getString("Armor"));
        BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
        this.equipments = equipmentSlots;
    }

    @Override
    public void buildInventory(GameData gameData) {
        Collectible essence = gameData.entityData.get("Essence");
        Collectible artifact = gameData.entityData.get("Artifact");
        inventory = new CollectibleInventory("Inventory", essence, artifact);
    }

    public Player buildPlayer(){
        return new Player(maxHitPoint, attackPoint, inventory, equipments, location);
    }
}
