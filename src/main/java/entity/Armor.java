package entity;

public class Armor extends Equipment {

    public Armor(String name, int dmgReduced){
        super(name,1, "DamageReduction", dmgReduced);
    }
}
