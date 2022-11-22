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
     * The basic part of the upgrading, it will return nothing but send messages to presenter.
     */
    private void upgrade(Equipment to_upgrade) {

    }


    @Override
    public void update(Observable o, Object arg) {
        this.player.setCanMove(false);
        this.player.setCanHeal(false);
    }
}