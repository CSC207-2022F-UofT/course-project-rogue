package usecase_event;

import entity.player.Player;
import file_writer.GameFileWriter;
import file_writer.GameFileWriterInterface;
import interface_adapters.OutputBoundary;

public class WinEvent extends Event{
    GameFileWriterInterface fileWriter;
    public WinEvent(GameFileWriterInterface fileWriter){
        this.fileWriter = fileWriter;
    }

    @Override
    public void trigger(Player player){
        int currArtifactNum = player.getArtifact().getNum();
        if (currArtifactNum >= 5){
            fileWriter.writeToFile(player);
            fileWriter.notify();

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
