package usecase_heal_and_upgrade;

import Interface.Visual_h_u;
import entity.Equipment;
import entity.Player;
import presenter.Presenter_bottom;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;


public class upgrading implements Observer{
    private Player player;
    private final String trigger;

    private int Essence_require;

    private CollectableCalculator EssenceCalculator;
    private StatCalculator StatCount;


    /**
     * The constructor of upgrading_control.
     * @param player the player
     */
    public upgrading(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
        this.EssenceCalculator = new CollectableCalculator();
        this.Essence_require = this.EssenceCalculator.EssenceForUpgrade();
        this.StatCount = new StatCalculator();
    }

    /**
     * Show player the info: how many collectible need, how many do the player have, if the player can heal, and request
     * the player to make choice.
     */
    private void upgrade_info(){
        Visual_h_u speaker = new Presenter_bottom();
        CollectibleUseManage ColHealper= new CollectibleUseManage(this.player, this.Essence_require, "upgrade");
        speaker.show_info(this.player.getEssence().getNum(), this.Essence_require, 0, 0,
                ColHealper.get_able(), "upgrade");
        if(ColHealper.get_able()){
            speaker.keypress_request("1","2");
        }
    }

    /**
     * The basic part of the upgrading, it will return nothing but send messages to presenter.
     */
    private void upgrade(Equipment to_upgrade) {
        CollectibleUseManage ColHelper= new CollectibleUseManage(this.player, this.Essence_require, "upgrade");
        EquipmentManage EquipHelper = new EquipmentManage(to_upgrade);
        EquipHelper.StatsIncrease(this.StatCount.determine_add());
        ColHelper.spendCollectible();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.player.setCanMove(false);
        this.player.setCanHeal(false);
    }
}