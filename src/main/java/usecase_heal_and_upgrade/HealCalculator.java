package usecase_heal_and_upgrade;

import interface_heal_and_upgrade.VisualHealUpgrade;
import stringmaker_heal_and_upgrade.InfoDisplay;
import entity.player.Player;

public class HealCalculator {
    private CollectibleUseManage CollectHelper;
    private Player player;
    private CalculatorCollectable Essenceneed;

    private int RequireHP;
    private int HPtoHeal;

    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player
     */
    public HealCalculator(Player player){
        this.player = player;
        this.RequireHP = 0;
        this.HPtoHeal = 0;
        this.Essenceneed = new CalculatorCollectable();
        this.CollectHelper = new CollectibleUseManage(player, this.Essenceneed.EssenceForHeal(this.HPtoHeal));
    }

    /**
     * Update the require HP of the player
     */
    private void HealRequireHPUpdate(){
        this.RequireHP = this.player.getMaxHitPoint() - this.player.getCurrHitPoint();
    }

    /**
     * Update the HP can be healed for the player and set the collectible Essence to be spent;
     */
    private void HealHPtoHealUpdate(){
        this.CollectHelper.EssenceNeedUpdate(this.Essenceneed.EssenceForHeal(this.RequireHP));
        this.HPtoHeal = this.RequireHP;
        if(!this.CollectHelper.getAble()){
            this.HPtoHeal = Essenceneed.AffordableHP(this.Essenceneed.AffordableHP(this.CollectHelper.getEssenceNum()));
            this.CollectHelper.EssenceNeedUpdate(this.Essenceneed.EssenceForHeal(this.HPtoHeal));
        }
    }

    /**
     * Update the heal infomation. The method must be called before the game print the heal summary.
     */
    public void HealInfoUpdate(){
        HealRequireHPUpdate();
        HealHPtoHealUpdate();
    }

    /**
     * let the presenter print the information of heal
     */
    public void HealInfoPrint(){
        VisualHealUpgrade speaker = new InfoDisplay();
        if (this.RequireHP==0){
            speaker.WarnFullHP();
            return;
        }
        if (this.HPtoHeal==0){
            speaker.showInfo(CollectHelper.getEssenceNum(),CollectHelper.getEssenceNeed(),
                    false, "heal");
            return;
        }
        if(this.HPtoHeal < this.RequireHP){
            speaker.showInfo(CollectHelper.getEssenceNum(),CollectHelper.getEssenceNeed(),
                    true, "heal a part");
            return;
        }
        speaker.showInfo(CollectHelper.getEssenceNum(),CollectHelper.getEssenceNeed(),
                true, "heal");
    }

    public void heal(){
        this.player.changeCurrHitPoint(this.HPtoHeal);

        HealInfoUpdate();
    }

}
