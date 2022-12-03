package file_writer;

import entity.player.Player;
import file_reader.GameFileReaderInterface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import usecase_factories.PlayerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameFileWriter implements GameFileWriterInterface {
    private final String dir;
    private GameFileReaderInterface reader;

    private final ArrayList<PlayerFactory> factories;

    public GameFileWriter(String dir){
        this.dir = dir;
        factories = new ArrayList<>();
    }

    /**
     * @param fileReader : reader to be notified after this writer has written to a file.
     */
    @Override
    public void register(GameFileReaderInterface fileReader) {
        this.reader = fileReader;
    }

    /**
     * @param playerFactory : player factory to notify that the player has won.
     */
    @Override
    public void register(PlayerFactory playerFactory) {
        this.factories.add(playerFactory);
    }

    /**
     *
     */
    @Override
    public void notifyPlayerFactory() {
        for(PlayerFactory pf: factories){
            pf.update();
        }
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
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse(reader.findString("class", "Basic Player"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Serializing CollectibleInventory inventory
        JSONObject essence = new JSONObject();
        JSONObject artifact = new JSONObject();
        essence.put("collectibleType", "Essence");
        essence.put("num", player.getEssence().getNum());
        artifact.put("collectibleType", "Artifact");
        artifact.put("num", 0);
        JSONObject collectibleInventory = new JSONObject();
        collectibleInventory.put("inventoryName", "Inventory");
        collectibleInventory.put("essence", essence);
        collectibleInventory.put("artifact", artifact);

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
            this.notifyReader();
            this.notifyPlayerFactory();
        } catch (IOException e) {
            System.out.println("Did not write player to any file");
            throw new RuntimeException(e);
        }
    }

}
