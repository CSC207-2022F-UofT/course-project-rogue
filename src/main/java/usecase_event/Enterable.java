package usecase_event;

import entity.player.Player;

public interface Enterable {
    /**
     * Return whether player can enter this Event Tile
     * .
     * .
     * Note: Player interface is there to increase flexibility because there may be a Room that needs a key from Player
     */
    boolean enter(Player player);
}
