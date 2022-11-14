package usecase_playeractions;

import java.util.Observable;

import entity.Player;

/**
 * A class that stores the actions the user may perform.
 * Use {@code Control.addObserver(Observer o)} to add addition actions(e.g. Heal, UpgradeWeapon, etc.).
 */
public class Control extends Observable {

    /**
     * Initialize the basic control class will no Observer
     */
    public Control(){}

    /**
     * Initialize the actions with a Map.
     * The basic WASD actions will be initialized.
     */
    public Control(Player player,Map map){
        this.setDefaultMover(player,map);
    }

    /**
     * Sets up the default Mover observer of WASD
     */
    private void setDefaultMover(Player player,Map map) {
        this.addObserver(new Mover(player,map,"W",0,1));
        this.addObserver(new Mover(player,map,"A",1,0));
        this.addObserver(new Mover(player,map,"S",0,-1));
        this.addObserver(new Mover(player,map,"D",-1,0));
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
