package usecase_playeractions;

import entity.player.Player;

/**
 * An ActionManager that cares about the map.
 */
public class MoveManager extends ActionManager{

    /**
     * Sets up the default Mover observer of WASD
     */
    private void setDefaultMover(Player player, Map map) {
        this.addObserver(new Mover(player,map,"W",-1,0));
        this.addObserver(new Mover(player,map,"A",0,-1));
        this.addObserver(new Mover(player,map,"S",1,0));
        this.addObserver(new Mover(player,map,"D",0,1));
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
