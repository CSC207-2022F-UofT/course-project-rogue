package file_reader.deserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.Armor;
import entity.BasicEquipmentSlots;
import entity.Weapon;

import java.io.IOException;

public class BasicEquipmentSlotsDeserialization extends StdDeserializer<BasicEquipmentSlots> {
    public BasicEquipmentSlotsDeserialization() {
        this(null);
    }

    public BasicEquipmentSlotsDeserialization(Class<?> vc){
        super(vc);
    }

    @Override
    public BasicEquipmentSlots deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        Weapon w = om.treeToValue(node.get("weapon"), Weapon.class);
        Armor a = om.treeToValue(node.get("armor"), Armor.class);
        return new BasicEquipmentSlots(w, a);
    }
}
