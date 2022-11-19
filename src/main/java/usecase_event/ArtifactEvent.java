package usecase_event;
import entity.Player;


public class ArtifactEvent extends Event{

    /**
     * Triggering this Event adds 1 to the Artifact that the player holds
     *
     * @param: player: the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
        player.changeArtifactAmount(1);
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(){

        return true;
    }
}
