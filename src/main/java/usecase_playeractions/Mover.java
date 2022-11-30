package usecase_playeractions;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/**
 * The Observer used to make the player move on the map
 */
public class Mover implements Observer {

    private final Player player;
    private final Map map;
    /**
     * The command that triggers this movement
     */
    private final String trigger;
    /**
     * Change in x coordinate when moved
     */
    private final int x;
    /**
     * Change in y coordinate when moved
     */
    private final int y;

    /**
     * Initialize Mover for player on map.
     * @param player the player
     * @param map map to move on.
     * @param trigger The command that triggers this movement
     * @param x Change in x coordinate when moved
     * @param y Change in y coordinate when moved
     */
    public Mover(Player player, Map map, String trigger, int x, int y){
        this.player = player;
        this.map = map;
        this.trigger = trigger;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(player.getCanMove() && trigger.equals(arg)){
            map.move(player, x, y);
        }
    }
}
