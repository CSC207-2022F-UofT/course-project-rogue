package usecase_heal_and_upgrade;

public class CalculatorCollectable {
    int healEssenceRate;
    int upgradeEssenceNeed;

    public CalculatorCollectable(){
        healEssenceRate = 1;
        upgradeEssenceNeed =20;
    }

    /**
     * Determine the Essence required to do the healing. This method will return a non-negative integer.
     * @param HP the HP to be healed
     * @return the Essence for the upgrade need.
     */
    public int essenceForHeal(int HP){
        int EssenceNum;
        EssenceNum = HP * this.healEssenceRate;
        return EssenceNum;
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * @return the Essence for the upgrade need.
     */
    public int essenceForUpgrade(){
        return this.upgradeEssenceNeed;
    }

    /**
     *Determine the max HP that the player can recover
     * @param CollectableNum the collectable that the player have
     * @return The max HP that the player can recover
     */
    public int affordableHP(int CollectableNum){
        int i;
        i = CollectableNum / this.healEssenceRate;
        return i;
    }
}
