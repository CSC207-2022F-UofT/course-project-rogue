package Usecase_Event;
import Entity.Player;


public class CollectibleEvent implements Triggerable{

    @Override
    public Object trigger(Player player) {
        player.setInventory("Artifacts", 1);
        return null;
    }
}
