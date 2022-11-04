package usecase_event;
import entity.Player;


public class ArtifactEvent extends Event{

    @Override
    public Object trigger(Player player) {
        /**Triggering this Event adds 1 to the Artifact that the player holds
         *
         * @param: player: the player triggering the Event
         *
         * @returns Adds 1 to Artifact in player inventory
         */
        player.setInventory("Artifacts", 1);
        return null;
    }
    @Override
    public boolean enter(){
        /** Tells Map whether this tile could be stepped on by Player
         *
         * @returns True if player can step on it, false if it can's
         */
        return true;
    }
}
