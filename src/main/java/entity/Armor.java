package entity;

public class Armor extends Equipment {

    public Armor(String name, int num, int dmgReduced){
        super(name, num, "DamageReduction", dmgReduced);
    }

    /**
     * Returns the damage reduced by the entity.Armor.
     * @return the damage reduced by the entity.Armor.
     */
    public int getDmgReduced(){
        return this.getStats();
    }
}
