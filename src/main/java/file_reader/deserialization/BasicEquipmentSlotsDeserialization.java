package file_reader.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.item.Armor;
import entity.equipment_slots.BasicEquipmentSlots;
import entity.item.Weapon;

import java.io.IOException;

public class BasicEquipmentSlotsDeserialization extends StdDeserializer<BasicEquipmentSlots> {
    public BasicEquipmentSlotsDeserialization() {
        this(null);
    }

    public BasicEquipmentSlotsDeserialization(Class<?> vc){
        super(vc);
    }

    /**
     * @param p Parsed used for reading JSON content(a part of Jackson, not our design)
     * @param ctxt Context that can be used to access information about
     *   this deserialization activity.(a part of Jackson, not our design)
     *
     * @return BasicEquipmentSlots read in together with Player
     */
    @Override
    public BasicEquipmentSlots deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        Weapon w = om.treeToValue(node.get("weapon"), Weapon.class);
        Armor a = om.treeToValue(node.get("armor"), Armor.class);
        return new BasicEquipmentSlots(w, a);
    }
}
