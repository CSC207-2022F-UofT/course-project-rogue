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
            outputBoundary.updateText("You Win!", "", "", "");
            outputBoundary.updateWin();
        } else{
            int artifactNeeded = 5 - currArtifactNum;
            outputBoundary.updateText(String.format("You need %d more Artifact to leave the Maze", artifactNeeded),
                    "", "", "");
        }
    }

    @Override
    public boolean enter(Player player){
        return true;
    }

}
