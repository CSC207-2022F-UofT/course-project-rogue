package usecase_playeractions;

import java.util.Observable;

import entity.Player;

/**
 * A class that stores the actions the user may perform.
 * Use {@code Control.addObserver(Observer o)} to add addition actions(e.g. Heal, UpgradeWeapon, etc.).
 */
public class Control extends Observable {

    /**
     * Initialize the basic control class with no Observer
     */
    public Control(){}

    public final String[] DEFAULT = new String[]{"W","A","S","D"};

    /**
     * Initialize the actions with a Map.
     * The basic WASD actions will be initialized.
     * @param player The player.
     * @param map The map that this player move on.
     */
    public Control(Player player,Map map){
        this.setDefaultMover(player,map);
    }


    /**
     * Initialize the actions with a Map.
     * The actions are controlled by keys.
     * @param player The player.
     * @param map The map that this player move on.
     * @param keys The triggers of movement.
     */
    public Control(Player player,Map map,String[] keys){
        this.setMovers(player,map,keys);
    }

    /**
     * Sets up the default Mover observer of WASD
     * @param player The player.
     * @param map The map that this player move on.
     */
    private void setDefaultMover(Player player,Map map) {
        setMovers(player,map,DEFAULT);
    }

    /**
     * Sets up the default Mover using keys.
     * @param player The player.
     * @param map The map that this player move on.
     * @param keys The keys that will be used instead of WASD.
     */
    private void setMovers(Player player,Map map,String[] keys) {
        this.addObserver(new Mover(player,map,keys[0],0,1));
        this.addObserver(new Mover(player,map,keys[1],1,0));
        this.addObserver(new Mover(player,map,keys[2],0,-1));
        this.addObserver(new Mover(player,map,keys[3],-1,0));
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
