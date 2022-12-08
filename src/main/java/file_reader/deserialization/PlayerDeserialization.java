package file_reader.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.player.Player;

import java.io.IOException;

public class PlayerDeserialization extends StdDeserializer<Player> {

    public PlayerDeserialization(){
        this(null);
    }
    public PlayerDeserialization(Class<?> vc){
        super(vc);
    }

    /**
     *
     * @param p Parsed used for reading JSON content(apart from Jackson, not our design)
     * @param ctxt Context that can be used to access information about
     *   this deserialization activity.(apart from Jackson, not our design)
     * @return Player read from file
     */
    @Override
    public Player deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        DeserializeHelper h = new DeserializeHelper();
        int mHP = h.readInt(node.get("maxHitPoint"));
        int aTP = h.readInt(node.get("attackPoint"));
        CollectibleInventory inventory = om.treeToValue(node.get("inventory"), CollectibleInventory.class);
        BasicEquipmentSlots ep = om.treeToValue(node.get("equipments"), BasicEquipmentSlots.class);
        return new Player(mHP, aTP, inventory, ep);
    }
}
