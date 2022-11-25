package usecase_heal_and_upgrade;

import entity.Player;

import java.util.Observable;
import java.util.Observer;

public class LeaveRestPoint implements Observer {
    private Player player;

    private final String trigger;

    public LeaveRestPoint(Player player, String trigger) {
        this.player = player;
        this.trigger = trigger;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(trigger)){
            player.setCanHeal(false);
            player.setCanUpgrade(false);
            player.setCanMove(true);
        }
    }
}