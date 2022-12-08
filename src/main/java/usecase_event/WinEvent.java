package usecase_event;

import entity.player.Player;
import file_writer.GameFileWriterInterface;

public class WinEvent extends Event{
    private static GameFileWriterInterface fileWriter;
    public static void setFileWriter(GameFileWriterInterface fileWriter){
        WinEvent.fileWriter = fileWriter;
    }

    @Override
    public void trigger(Player player){
        int currArtifactNum = player.getArtifact().getNum();
        if (currArtifactNum >= 5){
            fileWriter.writeToFile(player);

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

    @Override
    public String toString() {
        return "WinEvent";
    }

}
