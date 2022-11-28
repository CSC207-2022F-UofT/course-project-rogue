package usecase_playeractions;

import java.util.Observable;

import entity.Player;

/**
 * A class that stores the actions the user may perform.
 * Use {@code ActionManager.addObserver(Observer o)} to add addition actions(e.g. Heal, UpgradeWeapon, etc.).
 */
public class ActionManager extends Observable {

    private Player player;

    /**
     * Initialize the basic control class with no Observer
     */
    public ActionManager(){}

    /**
     * Initialize the actions with a Map.
     * The basic WASD actions will be initialized.
     */
    public ActionManager(Player player, Map map){
        this.player = player;
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
