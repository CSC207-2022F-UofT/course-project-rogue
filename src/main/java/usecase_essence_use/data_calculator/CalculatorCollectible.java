package usecase_essence_use.data_calculator;

public class CalculatorCollectible {

    public CalculatorCollectible(){}

    public final int HP_ESSENCE_EXCHANGE_RATE = 1;
    public final int ESSENCE_FOR_UPGRADE = 20;

    /**
     * Determine the Essence required to do the healing. This method will return a non-negative integer.
     * @param HP the HP to be healed
     * @return the Essence for the upgrade need.
     */
    public int essenceForHeal(int HP){
        int EssenceNum;
        EssenceNum = HP * this.HP_ESSENCE_EXCHANGE_RATE;
        return EssenceNum;
    }

    /**
     * Determine the Essence required to do the upgrading. This method will return a non-negative integer.
     * @return the Essence for the upgrade need.
     */
    public int essenceForUpgrade(){
        return this.ESSENCE_FOR_UPGRADE;
    }

    /**
     *Determine the max HP that the player can recover
     * @param CollectibleNum the collectable that the player have
     * @return The max HP that the player can recover
     */
    public int affordableHP(int CollectibleNum){
        int i;
        i = CollectibleNum / this.HP_ESSENCE_EXCHANGE_RATE;
        return i;
    }
}
