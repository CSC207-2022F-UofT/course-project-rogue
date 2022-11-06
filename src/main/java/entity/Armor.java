package entity;

public class Armor extends Equipment {

    public Armor(String name, int dmgReduced){
        super(name,1, "DamageReduction", dmgReduced);
    }

    /**
     * Returns the damage reduced by the Armor.
     * @return the damage reduced by the Armor.
     */
    public int getDmgReduced(){
        return this.getStats();
    }
}
