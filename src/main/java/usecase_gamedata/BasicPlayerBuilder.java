//package usecase_gamedata;
//
//import entity.*;
//import org.json.simple.JSONObject;
//
//public class BuildBasicPlayer implements PlayerBuilder {
//    int maxHitPoint;
//    int attackPoint;
//    int[] location;
//    BasicEquipmentSlots equipments;
//    CollectibleInventory inventory;
//
//    @Override
//    public void buildMaxHp(int maxHP) {
//        this.maxHitPoint = maxHP;
//    }
//
//    @Override
//    public void buildAtkPt(int atkPt) {
//        this.attackPoint = atkPt;
//    }
//
//    @Override
//    public void buildLocation(int[] location) {
//        this.location = location;
//    }
//
//    @Override
//    public void buildEquipmentSlot(JSONObject jsonObject) {
//        Weapon weapon = entityData.get(jsonObject.get("Weapon"));
//        Armor armor = entityData.get(jsonObject.get("Armor"));
//        BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
//        this.equipments = equipmentSlots;
//    }
//
//    @Override
//    public void buildInventory(GameData gameData) {
//        Collectible essence = gameData.entityData.get("Essence");
//        Collectible artifact = gameData.entityData.get("Artifact");
//        inventory = new CollectibleInventory("Inventory", essence, artifact);
//    }
//
//    public Player buildPlayer() {
//        return new Player(maxHitPoint, attackPoint, inventory, equipments, location);
//    }
//}