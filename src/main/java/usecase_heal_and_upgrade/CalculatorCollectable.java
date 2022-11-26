package usecase_heal_and_upgrade;

public class CalculatorCollectable {
    int HealEssenceRate;
    int upgradeEssenceNeed;

    public CalculatorCollectable(){
        HealEssenceRate = 1;
        upgradeEssenceNeed =20;
    }

    /**
     * Determine the Essence required to do the healing. This method will return a non-negative integer.
     * @param HP the HP to be healed
     * @return the Essence for the upgrade need.
     */
    public int EssenceForHeal(int HP){
        int EssenceNum;
        EssenceNum = HP * this.HealEssenceRate;
        return EssenceNum;
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * @return the Essence for the upgrade need.
     */
    public int EssenceForUpgrade(){
        return this.upgradeEssenceNeed;
    }

    /**
     *Determine the max HP that the player can recover
     * @param CollectableNum the collectable that the player have
     * @return The max HP that the player can recover
     */
    public int AffordableHP(int CollectableNum){
        int i;
        i = CollectableNum / this.HealEssenceRate;
        return i;
    }
}
