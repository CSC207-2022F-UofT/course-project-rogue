package usecase_heal_and_upgrade;

import entity.player.Player;

public class HealCalculator {
    private CollectibleUseManager collectHelper;
    private Player player;
    private CalculatorCollectible essenceNeed;

    private int requireHP;
    private int hpToHeal;

    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player
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
            this.hpToHeal = essenceNeed.affordableHP(this.essenceNeed.affordableHP(this.collectHelper.getEssenceNum()));
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
        VisualHealUpgrade speaker = new HealAndUpgradeInfoDisplay();
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

    public void heal(){
        this.player.changeCurrHitPoint(this.hpToHeal);

        healInfoUpdate();
    }

}