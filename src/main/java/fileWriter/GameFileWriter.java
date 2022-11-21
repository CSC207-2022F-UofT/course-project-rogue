package fileWriter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GameFileWriter implements GameFileWriter_Interface{
    private String dir;

    public GameFileWriter(String dir){
        this.dir = dir;
    }
    /**
     * @param player: the player instance that will replace the player instance in Player.json
     */
    @Override
    public void writeToFile(Player player) {
        JSONObject obj = new JSONObject();

        //Serializing CollectibleInventory inventory
        JSONObject essence = new JSONObject();
        essence.put("collectibleType", "Essence");
        essence.put("num", player.getEssence().getNum());
        JSONObject collectibleInventory = new JSONObject();
        collectibleInventory.put("inventoryName", "Inventory");
        collectibleInventory.put("essence", essence);

        //Serializing Equipmentslots
        JSONObject equipments = new JSONObject();
        JSONObject weapon = new JSONObject();
        JSONObject armor = new JSONObject();
        weapon.put("name", player.getEquipment("Weapon").getName());
        weapon.put("weaponAttackPoint", player.getEquipment("Weapon").getStatValue());
        armor.put("name", player.getEquipment("Armor").getName());
        armor.put("dmgReduced", player.getEquipment("Armor").getStatValue());
        equipments.put("weapon", weapon);
        equipments.put("armor", armor);

        //Serializing Player
        obj.put("maxHitPoint", player.getMaxHitPoint());
        obj.put("attackPoint", player.getAttackPoint());
        obj.put("inventory", collectibleInventory);
        obj.put("equipments", equipments);

        JSONArray arr = new JSONArray();
        arr.add(obj);

        try {
            FileWriter fileWriter = new FileWriter(this.dir);
            String pl = arr.toString();
            fileWriter.write(arr.toJSONString());
            fileWriter.close();
            System.out.println("Wrote this player to " + this.dir + ": " + pl);
        } catch (IOException e) {
            System.out.println("Did not write player to any file");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setDir(String dir){
        this.dir = dir;
    }

    @Override
    public String getDir(){
        return this.dir;
    }
}
