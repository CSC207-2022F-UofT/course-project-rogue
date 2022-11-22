package usecase_heal_and_upgrade;

import Interface.Visual_h_u;
import entity.Player;
import presenter.Presenter_bottom;

import java.util.Observable;
import java.util.Observer;

public class healing implements Observer {
    private Player player;
    private final String trigger;

    private int HP_require;

    private int Essence_require;

    private CollectableCalculator EssenceCalculator;



    /**
     * The constructor of healing_control
     * @param player the player
     */
    public healing(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
        this.HP_require = 0;
        this.EssenceCalculator = new CollectableCalculator();
        this.Essence_require = EssenceCalculator.EssenceForHeal(this.HP_require);
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
    public void update_HP(){
        this.HP_require = this.player.getMaxHitPoint() - this.player.getCurrHitPoint();
        this.Essence_require = this.EssenceCalculator.EssenceForHeal(HP_require);
    }

    /**
     * Show player the info: how many collectible need, how many do the player have, if the player can heal, and request
     * the player to make choice.
     */
    public void heal_info(){
        Visual_h_u speaker = new Presenter_bottom();
        if (CheckFullHP()) {
            speaker.Warn_FullHP();
            return;
        }
        CollectibleUseManage ColHealper= new CollectibleUseManage(this.player, this.Essence_require, "heal");
        speaker.show_info(this.player.getEssence().getNum(), this.Essence_require, 0, 0,
                ColHealper.get_able(), "heal");
        if(ColHealper.get_able()){
            speaker.keypress_request("Y","N");
        }
    }

    /**
     * The basic part of the healing, it will return nothing but send message to presenter.
     */
    public void heal() {
        CollectibleUseManage Colhelper= new CollectibleUseManage(this.player, this.Essence_require, "heal");
        this.player.changeCurrHitPoint(this.HP_require);
        Colhelper.spendCollectible();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.player.setCanMove(false);
        this.player.setCanUpgrade(false);
        update_HP();
        heal_info();
    }
}