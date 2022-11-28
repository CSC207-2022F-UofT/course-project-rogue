package usecase_essence_use.heal;

import entity.player.Player;
import usecase_essence_use.data_calculator.CollectibleUseManager;
import usecase_essence_use.EssenceUseInfoDisplay;
import usecase_essence_use.VisualHealUpgrade;
import usecase_essence_use.data_calculator.CalculatorCollectible;

public class HealCalculator {
    private final CollectibleUseManager collectHelper;
    private final Player player;
    private final CalculatorCollectible essenceNeed;

    private int requireHP;
    private int hpToHeal;

    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player the player in the game, we only accept one player
     */
    public HealCalculator(Player player){
        this.player = player;
        this.requireHP = 0;
        this.hpToHeal = 0;
        this.essenceNeed = new CalculatorCollectible();
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
        this.collectHelper.essenceNeededToUpdate(this.essenceNeed.essenceForHeal(this.requireHP));
        this.hpToHeal = this.requireHP;
        if(!this.collectHelper.getAble()){
            this.hpToHeal = this.essenceNeed.affordableHP(this.collectHelper.getEssenceNum());
            this.collectHelper.essenceNeededToUpdate(this.essenceNeed.essenceForHeal(this.hpToHeal));
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
     * let the presenter print the information of heal
     */
    public void healInfoPrint(){
        VisualHealUpgrade speaker = new EssenceUseInfoDisplay();
        if (this.requireHP ==0){
            speaker.warnFullHP();
            return;
        }
        if (this.hpToHeal ==0){
            speaker.showInfo(collectHelper.getEssenceNum(), collectHelper.getEssenceNeed(),
                    false, "heal");
            return;
        }
        if(this.hpToHeal < this.requireHP){
            speaker.showInfo(collectHelper.getEssenceNum(), collectHelper.getEssenceNeed(),
                    true, "heal a part");
            return;
        }
        speaker.showInfo(collectHelper.getEssenceNum(), collectHelper.getEssenceNeed(),
                true, "heal");
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
