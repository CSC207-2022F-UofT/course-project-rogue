package usecase_event;
import entity.Player;


public class ArtifactEvent extends Event{

    @Override
    public Object trigger(Player player) {
        player.setInventory("Artifacts", 1);
        return null;
    }
}
