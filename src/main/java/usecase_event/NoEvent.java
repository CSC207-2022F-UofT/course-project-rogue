package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

import java.util.Observable;

public class NoEvent extends Event{

    /**
     * Triggering this Event will not result in anything, it is meant to be a resting ground for the player.
     *
     * @param player the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
        outputBoundary.updateHp(player.getCurrHitPoint());
        outputBoundary.updateArtifact(player.getArtifact().getNum());
        outputBoundary.updateEssenceCnt(player.getEssence().getNum());
        outputBoundary.updateText("Nothing interesting to see here,", "the journey is long so", "you have to keep pushing", "");

    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){

        return true;
    }
    @Override
    public String toString() {
        return "NoEvent";
    }
}