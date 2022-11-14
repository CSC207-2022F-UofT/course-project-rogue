package usecase_gamedata;

import entity.BasicEquipmentSlots;
import entity.CollectibleInventory;
import entity.Player;
import javax.json;



public class PlayerFactory {
    private PlayerBuilder builder;
    private JSONObject object = Json.createObject

    public Player create(JSONObject jsonObject, GameData gameData) {
        Player player;
        if ("Basic Player".equals(jsonObject.get("Class")){
            builder = new BuildBasicPlayer();
            builder.buildMaxHp();
            builder.buildAtkPt(jsonObject.get(""));
            builder.buildLocation((int[]) jsonObject.getString());
            builder.buildEquipmentSlot(jsonObject);
            builder.buildInventory(gameData);
        }
    }
}