package usecase_heal_and_upgrade;

import Interface_heal_and_upgrade.Visual_h_u;
import entity.Equipment;
import entity.Player;
import StringMaker_heal_and_upgrade.infoDisplay;

import java.util.Observable;
import java.util.Observer;


public class upgrading implements Observer{
    private Player player;
    private final String trigger;

    private int essenceRequire;

    private CollectableCalculator essenceCalculator;
    private StatCalculator statCount;


    /**
     * The constructor of upgrading_control.
     * @param player the player
     */
    public upgrading(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
        this.essenceCalculator = new CollectableCalculator();
        this.essenceRequire = this.essenceCalculator.EssenceForUpgrade();
        this.statCount = new StatCalculator();
    }

    /**
     * Show player the info: how many collectible need, how many do the player have, if the player can heal, and request
     * the player to make choice.
     */
    private void upgrade_info(){
        Visual_h_u speaker = new infoDisplay();
        CollectibleUseManage ColHealper= new CollectibleUseManage(this.player, this.essenceRequire, "upgrade");
        speaker.show_info(this.player.getEssence().getNum(), this.essenceRequire, 0, 0,
                ColHealper.get_able(), "upgrade");
        if(ColHealper.get_able()){
            speaker.keypress_request("1","2");
        }
    }

    /**
     * The basic part of the upgrading, it will return nothing but send messages to presenter.
     */
    private void upgrade(Equipment to_upgrade) {
        CollectibleUseManage ColHelper= new CollectibleUseManage(this.player, this.essenceRequire, "upgrade");
        EquipmentManage EquipHelper = new EquipmentManage(to_upgrade);
        EquipHelper.StatsIncrease(this.statCount.determine_add());
        ColHelper.spendCollectible();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.player.setCanMove(false);
        this.player.setCanHeal(false);
    }
}