package usecase_heal_and_upgrade;

public class CollectableCalculator {
    int HealEssenceRate;
    int upgradeEssenceNeed;

    public CollectableCalculator(){
        HealEssenceRate = 1;
        upgradeEssenceNeed =20;
    }

    public int EssenceForHeal(int HP){
        int EssenceNum;
        EssenceNum = HP * this.HealEssenceRate;
        return EssenceNum;
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * I will set the initial value as 20 here.In the future,
     *
     * @return the Essence for the upgrade need.
     */
    public int EssenceForUpgrade(){
        return this.upgradeEssenceNeed;
    }
}
