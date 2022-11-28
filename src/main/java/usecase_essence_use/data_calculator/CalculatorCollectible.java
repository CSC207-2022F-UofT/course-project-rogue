package usecase_essence_use.data_calculator;

public class CalculatorCollectible {
    public int essenceHPExchangeRate;
    public int essenceForUpgrade;
    public CalculatorCollectible(){
        essenceHPExchangeRate = 1;
        essenceForUpgrade = 20;
    }



    /**
     * Determine the Essence required to do the healing. This method will return a non-negative integer.
     * @param HP the HP to be healed
     * @return the Essence for the upgrade need.
     */
    public int essenceForHeal(int HP){
        int EssenceNum;
        EssenceNum = HP * this.essenceHPExchangeRate;
        return EssenceNum;
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * @return the Essence for the upgrade need.
     */
    public int essenceForUpgrade(){
        return this.essenceForUpgrade;
    }

    /**
     *Determine the max HP that the player can recover
     * @param CollectibleNum the collectable that the player have
     * @return The max HP that the player can recover
     */
    public int affordableHP(int CollectibleNum){
        int i;
        i = CollectibleNum / this.essenceHPExchangeRate;
        return i;
    }
}
