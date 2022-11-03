public class Armor extends Equipment{
    private int dmgReduced; // how much damage the Armor reduces

    public Armor(String name, int num, int dmgReduced){
        super(name, num, "DamageReduction", dmgReduced);
    }

    /**
     * Returns the damage reduced by the Armor.
     * @return the damage reduced by the Armor.
     */
    public int getDmgReduced(){
        return this.dmgReduced;
    }
}
