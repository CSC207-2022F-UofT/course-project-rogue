package usecase_heal_and_upgrade;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;


public class Upgrader implements Observer{
    private Player player;

    private UpgradeCalculator Manager;
    private final String trigger;


    /**
     * The constructor of upgrading_control.
     * @param player the player
     */
    public Upgrader(Player player, UpgradeCalculator upgradeManage, String trigger) {
        this.player = player;
        this.Manager = upgradeManage;
        this.trigger = trigger;
    }



    @Override
    public void update(Observable o, Object arg) {
        if (player.getCanUpgrade() && arg.equals(trigger))
        Manager.upgrade();
    }
}