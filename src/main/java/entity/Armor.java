package entity;

public class Armor extends Equipment {

    public Armor(String name, int dmgReduced){
        super(name,1, "DamageReduction", dmgReduced);
    }

    /**
     * Returns the damage reduced by the entity.Armor.
     * @return the damage reduced by the entity.Armor.
     */
    public int getDmgReduced(){
        return this.getStats();
    }
}
