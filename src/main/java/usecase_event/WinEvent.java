package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

public class WinEvent extends Event{

    public WinEvent(OutputBoundary outputBoundary){
        super(outputBoundary);
    }

    @Override
    public void trigger(Player player){
        int currArtifactNum = player.getArtifact().getNum();
        if (currArtifactNum >= 5){
            outputBoundary.update_Text("You Win!", "", "", "");
        } else{
            int artifactNeeded = 5 - currArtifactNum;
            outputBoundary.update_Text(String.format("You need %d more Artifact to leave the Maze", artifactNeeded),
                    "", "", "");
        }
    }

    @Override
    public boolean enter(Player player){
        return true;
    }

}
