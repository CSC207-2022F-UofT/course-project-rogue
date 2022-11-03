public class Armor extends Equipment{

    public Armor(String name, int num, int dmgReduced){
        super(name, num, "DamageReduction", dmgReduced);
    }

    /**
     * Returns the damage reduced by the Armor.
     * @return the damage reduced by the Armor.
     */
    public int getDmgReduced(){
        return this.getStatValue();
    }
}
