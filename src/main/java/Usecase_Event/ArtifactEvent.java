package Usecase_Event;
import Entity.Player;


public class ArtifactEvent extends Event implements Triggerable{

    @Override
    public Object trigger(Player player) {
        player.setInventory("Artifacts", 1);
        return null;
    }
}