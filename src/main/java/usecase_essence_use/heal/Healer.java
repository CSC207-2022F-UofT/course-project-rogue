package usecase_essence_use.heal;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

public class Healer implements Observer {
    private final Player player;
    private final HealCalculator Manager;
    private final String trigger;


    /**
     * The constructor of healing. This class is to be triggered by the HealingUpgradingControl. And It will recover the
     * certain amount of HP that is determined by the HealInfo
     * @param player the player
     */
    public Healer(Player player, HealCalculator Manager, String trigger) {
        this.player = player;
        this.Manager = Manager;
        this.trigger = trigger;
    }

    /**
     * Recieves the notification of which key is pressed, if it is the key it needs to perform the action it
     * runs this section of the use case, if not it'll not do anything.
     */
    @Override
    public void update(Observable o, Object arg) {
        if(player.getCanHeal() && arg.equals(this.trigger)) {
            Manager.heal();
        }
    }
}