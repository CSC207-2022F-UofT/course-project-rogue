package usecase_heal_and_upgrade;

import entity.Player;

import java.util.Observable;

public class healingUpgradingControl extends Observable {
    /**
     * Initialize the basic control class with no Observer
     */
    public healingUpgradingControl(){}

    /**
     * Initialize the actions choice of the player.
     * The basic Upgrade and Heal actions will be initialized.
     */
    public healingUpgradingControl(Player player){
        this.setDefaultUP(player);
    }

    /**
     * Sets up the default  observer of HU
     */
    private void setDefaultUP(Player player) {
        this.addObserver(new healing(player, "H"));
        this.addObserver(new upgrading(player,"U"));
    }

    /**
     * Notify observers with the command given.
     * @param s the command given
     */
    public void keyPressed(String s){
        this.setChanged();
        this.notifyObservers(s.toUpperCase());
    }


}
