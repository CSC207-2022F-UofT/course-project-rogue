package usecase_heal_and_upgrade;

import entity.item.Collectible;
import entity.player.Player;

public class CollectibleUseManager {
    private final Collectible Essence;
    private int essenceNeed;
    private boolean able;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the plaeyer
     * @param essenceNeed Essence required for upgrade/heal
     */

    public CollectibleUseManager(Player player, int essenceNeed){
        this.Essence = player.getEssence();
        this.essenceNeed = essenceNeed;
        this.able = this.Essence.getNum() >= essenceNeed;
    }

    /**
     * Return if we can upgrade
     * @return whether the player can upgrade
     */
    public boolean getAble(){
        return this.able;
    }

    public int getEssenceNum(){return this.Essence.getNum();}

    public int getEssenceNeed(){return this.essenceNeed;}

    /**
     * Decrease the player's collection number according to the upgrade/heal need.
     */
    public void spendCollectible(){
        this.Essence.changeNum(-essenceNeed);
    }

    /**
     * Change the Essence the player need
     * @param NumEssence
     */
    public void essenceNeededToUpdate(int NumEssence){
        this.essenceNeed = NumEssence;
        this.able = this.Essence.getNum() >= this.essenceNeed;
    }
}
