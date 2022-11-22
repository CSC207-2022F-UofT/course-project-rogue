package usecase_heal_and_upgrade;

import entity.Collectible;
import entity.Player;

public class CollectibleUseManage {
    Collectible Essence;
    int Essence_need;
    boolean able;
    String verb;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the plaeyer
     * @param Essence_need Essence required for upgrade/heal
     * @param verb
     */

    public CollectibleUseManage(Player player, int Essence_need, String verb){
        this.Essence = player.getEssence();
        this.Essence_need = Essence_need;
        this.able = this.Essence.getNum() >= Essence_need;
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
        this.Essence.changeNum(-Essence_need);
    }

    public int EssenceLeft(){
        return this.Essence.getNum();
    }

}
