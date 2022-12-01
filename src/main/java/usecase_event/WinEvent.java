package usecase_event;

import entity.player.Player;
import file_writer.GameFileWriter;
import file_writer.GameFileWriterInterface;
import interface_adapters.OutputBoundary;

public class WinEvent extends Event{
    GameFileWriterInterface fileWriter;
    public WinEvent(OutputBoundary outputBoundary, GameFileWriterInterface fileWriter){
        super(outputBoundary);
        this.fileWriter = fileWriter;
    }

    @Override
    public void trigger(Player player){
        int currArtifactNum = player.getArtifact().getNum();
        if (currArtifactNum >= 5){
            fileWriter.writeToFile(player);
            fileWriter.notify();

            outputBoundary.update_Text("You Win!", "", "", "");
            outputBoundary.update_Win();


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
