package usecase_event;

import entity.player.Player;

public class WinEvent extends Event{

    @Override
    public void trigger(Player player){
        if (player.getArtifact().getNum() >= 5){
            // Player Wins
        } else{
            // Notify Player needs 5 artifact
        }
    }

    @Override
    public boolean enter(Player player){
        return true;
    }

}
