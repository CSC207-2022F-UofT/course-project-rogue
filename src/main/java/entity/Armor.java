package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Armor extends Equipment {


    public Armor(@JsonProperty("name")String name, @JsonProperty("dmgReduced")int dmgReduced){
        super(name,1, "DamageReduction", dmgReduced);
    }
}
