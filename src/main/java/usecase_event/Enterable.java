package usecase_event;

import entity.Player;

public interface Enterable {
    /**
     * Return whether player can enter this Event Tile
     */
    boolean enter();
}
