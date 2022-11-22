package usecase_heal_and_upgrade;

import entity.Collectible;
import entity.Player;

public class CollectibleUseManage {
    Collectible Essence;
    int essenceNeed;
    boolean able;
    String verb;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the plaeyer
     * @param essenceNeed Essence required for upgrade/heal
     * @param verb
     */

    public CollectibleUseManage(Player player, int essenceNeed, String verb){
        this.Essence = player.getEssence();
        this.essenceNeed = essenceNeed;
        this.able = this.Essence.getNum() >= essenceNeed;
        this.verb = verb;
    }

    /**
     * Return if we can upgrade
     * @return whether the player can upgrade
     */
    public boolean get_able(){
        return this.able;
    }

    /**
     * Decrease the player's collection number according to the upgrade/heal need.
     */
    public void spendCollectible(){
        this.Essence.changeNum(-essenceNeed);
    }

    public int EssenceLeft(){
        return this.Essence.getNum();
    }

}
