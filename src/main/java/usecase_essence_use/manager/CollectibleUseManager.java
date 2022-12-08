package usecase_essence_use.manager;

import entity.player.Player;

public class CollectibleUseManager {
    private final Player player;
    private int essenceNeed;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the player
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

    /**
     * Return the essence number that player have.
     * @return number of essence in the form of an integer
     */
    public int getEssenceNum(){return this.player.getEssence().getNum();}

    /**
     * Return the number of essence taht we need for upgrade
     * @return the number of essence of player
     */
    public int getEssenceNeed(){return this.essenceNeed;}

    /**
     * Decrease the player's collection number according to the upgrade/heal need.
     */
    public void spendCollectible(){
        this.player.getEssence().changeNum(-essenceNeed);
    }

    /**
     * Update the Essence need for the player in healing/upgrading
     * @param NumEssence the number of essence is required for heal/upgrade
     */
    public void essenceNeedUpdate(int NumEssence){
        this.essenceNeed = NumEssence;
    }
}
