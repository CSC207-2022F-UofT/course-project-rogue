package usecase_essence_use.data_calculator;

import entity.player.Player;

public class CollectibleUseManager {
    private final Player player;
    private int essenceNeed;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the plaeyer
     * @param essenceNeed Essence required for upgrade/heal
     */

    public CollectibleUseManager(Player player, int essenceNeed){
        this.player = player;
        this.essenceNeed = essenceNeed;
    }

    /**
     * Return if we can upgrade
     * @return whether the player can upgrade
     */
    public boolean getAble(){
        return this.player.getEssence().getNum() >= this.essenceNeed;
    }

    public int getEssenceNum(){return this.player.getEssence().getNum();}

    public int getEssenceNeed(){return this.essenceNeed;}

    /**
     * Decrease the player's collection number according to the upgrade/heal need.
     */
    public void spendCollectible(){
        this.player.getEssence().changeNum(-essenceNeed);
    }

    /**
     * Change the Essence the player need
     * @param NumEssence
     */
    public void essenceNeededToUpdate(int NumEssence){
        this.essenceNeed = NumEssence;
    }
}
