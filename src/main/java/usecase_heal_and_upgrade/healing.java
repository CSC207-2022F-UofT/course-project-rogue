package usecase_heal_and_upgrade;

import Interface_heal_and_upgrade.Visual_h_u;
import entity.Player;
import StringMaker_heal_and_upgrade.infoDisplay;

import java.util.Observable;
import java.util.Observer;

public class healing implements Observer {
    private Player player;
    private final String trigger;

    private int HPRequire;

    private int EssenceRequire;

    private CollectableCalculator EssenceCalculator;



    /**
     * The constructor of healing_control
     * @param player the player
     */
    public healing(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
        this.HPRequire = 0;
        this.EssenceCalculator = new CollectableCalculator();
        this.EssenceRequire = EssenceCalculator.EssenceForHeal(this.HPRequire);
    }

    /**
     * Check if the player has full HP.
     * @return
     */
    public boolean CheckFullHP(){
        return this.player.getMaxHitPoint() == this.player.getCurrHitPoint();
    }

    /**
     * Show the healing information: if the player are able to heal and how much it will
     */
    public void updateHP(){
        this.HPRequire = this.player.getMaxHitPoint() - this.player.getCurrHitPoint();
        this.EssenceRequire = this.EssenceCalculator.EssenceForHeal(HPRequire);
    }

    /**
     * Show player the info: how many collectible need, how many do the player have, if the player can heal, and request
     * the player to make choice.
     */
    public void healInfo(){
        Visual_h_u speaker = new infoDisplay();
        if (CheckFullHP()) {
            speaker.WarnFullHP();
            return;
        }
        CollectibleUseManage ColHealper= new CollectibleUseManage(this.player, this.EssenceRequire, "heal");
        speaker.showInfo(this.player.getEssence().getNum(), this.EssenceRequire, 0, 0,
                ColHealper.get_able(), "heal");
        if(ColHealper.get_able()){
            speaker.keypressRequest("Y","N");
        }
    }

    /**
     * The basic part of the healing, it will return nothing but send message to presenter.
     */
    public void heal() {
        CollectibleUseManage Colhelper= new CollectibleUseManage(this.player, this.EssenceRequire, "heal");
        this.player.changeCurrHitPoint(this.HPRequire);
        Colhelper.spendCollectible();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.player.setCanMove(false);
        this.player.setCanUpgrade(false);
        updateHP();
        healInfo();
    }
}