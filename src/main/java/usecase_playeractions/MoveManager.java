package usecase_playeractions;

import entity.Player;

/**
 * An ActionManager that cares about the map.
 */
public class MoveManager extends ActionManager{

    /**
     * Initialize the basic control class with no Observer
     */
    public MoveManager(){}

    /**
     * Sets up the default Mover observer of WASD
     */
    private void setDefaultMover(Player player, Map map) {
        this.addObserver(new Mover(player,map,"W",0,1));
        this.addObserver(new Mover(player,map,"A",1,0));
        this.addObserver(new Mover(player,map,"S",0,-1));
        this.addObserver(new Mover(player,map,"D",-1,0));
    }

    /**
     * Re-Initialize this ActionManager so it only contain the default movers.
     * Used to change Map or Player in a MoveManager.
     * @param player The new Player
     * @param map The new Map
     */
    public void changeMap(Player player, Map map){
        this.deleteObservers();
        this.setDefaultMover(player,map);
    }

}
