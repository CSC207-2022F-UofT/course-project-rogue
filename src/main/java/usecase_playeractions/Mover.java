package usecase_playeractions;

import entity.Player;

import java.util.Observable;
import java.util.Observer;

/**
 * The Observer used to make the player move on the map
 */
public class Mover implements Observer {

    private Player player;
    private Map map;
    /**
     * The command that triggers this movement
     */
    private String trigger;
    /**
     * Change in x coordinate when moved
     */
    private int x;
    /**
     * Change in y coordinate when moved
     */
    private int y;

    public Mover(Player player, Map map, String trigger, int x, int y){
        this.player = player;
        this.map = map;
        this.trigger = trigger;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(trigger.equals(arg)){
            map.move(player, x, y);
        }
    }
}
