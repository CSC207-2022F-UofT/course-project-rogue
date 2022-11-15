package usecase_heal_and_upgrade;

import Interface.Visual_h_u;
import entity.Collectible;
import entity.Player;
import presenter.Presenter_bottom;

public class CollectibleUseManage {
    Collectible Essence;
    Collectible Artifact;
    int Essence_need;
    int Artifact_need;
    boolean Upgrade_able;
    String verb;

    /**
     * Counstruct the class CollectibleUseManage. This class is in charge of the spend of the collectible items.
     * @param player the play data
     * @param Essence_need
     * @param Artifact_need
     * @param verb
     */

    public CollectibleUseManage(Player player, int Essence_need, int Artifact_need, String verb){
        this.Essence = player.getCollectible("Essence");
        this.Artifact = player.getCollectible("Artifact");
        this.Artifact_need = Artifact_need;
        this.Essence_need = Essence_need;
        this.Upgrade_able = this.Essence.getNum() >= Essence_need && this.Artifact.getNum() >= Artifact_need;
        this.verb = verb;
    }

    /**
     * Return if we can upgrade
     * @return whether the player can upgrade
     */
    public boolean getUpgrade_able(){
        return this.Upgrade_able;
    }

    /**
     * Decrease the player's collection number according to the upgrade/heal need.
     */
    public void spendCollectible(){
        this.Essence.changeNum(-Essence_need);
        this.Artifact.changeNum(-Artifact_need);
    }

    public void ItemBroadcast(){
        Visual_h_u speaker = new Presenter_bottom();
        speaker.show_info(this.Essence.getNum(), this.Essence_need, this.Artifact.getNum(), this.Artifact_need,
                this.Upgrade_able, this.verb);
    }
}
