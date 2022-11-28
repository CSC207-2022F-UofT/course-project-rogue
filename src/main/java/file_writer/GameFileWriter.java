package file_writer;

import entity.player.Player;
import file_reader.GameFileReaderInterface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GameFileWriter implements GameFileWriterInterface {
    private String dir;
    private GameFileReaderInterface reader;

    public GameFileWriter(String dir){
        this.dir = dir;
    }

    /**
     * @param fileReader : reader to be notified after this writer has written to a file.
     */
    @Override
    public void register(GameFileReaderInterface fileReader) {
        this.reader = fileReader;
    }

    /**
     * Notifying the reader to switch to a new file to read.
     */
    @Override
    public void notifyReader() {
        this.reader.update(this.dir);
    }

    /**
     * @param player: the player instances that will be saved to the original Json file.
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
        weapon.put("name", player.getWeapon().getName());
        weapon.put("weaponAttackPoint", player.getWeapon().getStatValue());
        armor.put("name", player.getArmor().getName());
        armor.put("dmgReduced", player.getArmor().getStatValue());
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
            this.notifyReader();
        } catch (IOException e) {
            System.out.println("Did not write player to any file");
            throw new RuntimeException(e);
        }
    }

}