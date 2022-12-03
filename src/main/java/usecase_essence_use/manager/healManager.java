package usecase_essence_use.manager;

import entity.player.Player;
import usecase_essence_use.data_preset_normal.collectibleNeedSetting;

public class healManager {
    private final CollectibleUseManager collectHelper;
    private final Player player;
    private final collectibleNeedSetting essenceNeed;

    private int requireHP;
    private int hpToHeal;

    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player the player in the game, we only accept one player
     */
    public healManager(Player player, collectibleNeedSetting essenceNeed){
        this.player = player;
        this.requireHP = 0;
        this.hpToHeal = 0;
        this.essenceNeed = essenceNeed;
        this.collectHelper = new CollectibleUseManager(player, this.essenceNeed.essenceForHeal(this.hpToHeal));
    }

    /**
     * Update the require HP of the player
     */
    private void healRequireHPUpdate(){
        this.requireHP = this.player.getMaxHitPoint() - this.player.getCurrHitPoint();
    }

    /**
     * Update the HP can be healed for the player and set the collectible Essence to be spent;
     */
    private void healHPtoHealUpdate(){
        this.collectHelper.essenceNeedUpdate(this.essenceNeed.essenceForHeal(this.requireHP));
        this.hpToHeal = this.requireHP;
        if(!this.collectHelper.getAble()){
            this.hpToHeal = this.essenceNeed.affordableHP(this.collectHelper.getEssenceNum());
            this.collectHelper.essenceNeedUpdate(this.essenceNeed.essenceForHeal(this.hpToHeal));
        }
    }

    /**
     * Update heal infomation. The method must be called before the game print heal summary.
     */
    public void healInfoUpdate(){
        healRequireHPUpdate();
        healHPtoHealUpdate();
    }

    /**
     * get the HP can be healed from the essence we have
     * @return HP that player can heal
     */
    public int getHPToHeal(){
        return this.hpToHeal;
    }

    /**
     * get the HP that the player need to heal. Note that it may be larger than HPToHeal, as player sometimes does not
     * have enough essence.
     * @return HP that the player need to heal
     */
    public int getRequireHP(){
        return this.requireHP;
    }

    /**
     * get the essence need for healing
     * @return the essence need for healing
     */
    public int getEssenceNeed(){
        return this.collectHelper.getEssenceNeed();
    }



    /**
     * The basic part of the Heal, this method will heal player's HP in the calculate way.
     */
    public void heal(){
        this.player.changeCurrHitPoint(this.hpToHeal);
        this.collectHelper.spendCollectible();
        this.player.setCanHeal(false);
        healInfoUpdate();
    }

}
