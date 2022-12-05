package usecase_essence_use.upgrade;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;


public class Upgrader implements Observer{
    private final Player player;
    private final UpgradeCalculator Manager;
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



    /**
     * Recieves the notification of which key is pressed, if it is the key it needs to perform the action it
     * runs this section of the use case, if not it'll not do anything.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (player.getCanUpgrade() && arg.equals(trigger)) {
            Manager.upgrade();
        }
    }
}