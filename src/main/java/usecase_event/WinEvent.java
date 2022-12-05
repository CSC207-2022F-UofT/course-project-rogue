package usecase_event;

import entity.player.Player;
import file_writer.GameFileWriterInterface;

public class WinEvent extends Event{
    private static GameFileWriterInterface fileWriter = null;
    public static void setFileWriter(GameFileWriterInterface fileWriter){
        if(WinEvent.fileWriter == null)
            WinEvent.fileWriter = fileWriter;
    }

    /**
     * If player steps on this tile with at least 5 artifact they win the game, else it'll tell the player to find more
     * artifact
     * @param player: The player it'll interact with
     */
    @Override
    public void trigger(Player player){
        int currArtifactNum = player.getArtifact().getNum();
        if (currArtifactNum >= 5){
            fileWriter.writeToFile(player);


            outputBoundary.updateText("You Escaped", "", "", "");
            outputBoundary.updateWin();


        } else{
            int artifactNeeded = 5 - currArtifactNum;
            outputBoundary.updateText(String.format("You need %d more Artifact to leave the Maze", artifactNeeded),
                    "", "", "");
        }
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){
        return true;
    }

    /**
     *  Returns String to show which Event type it is
     * @return "WinEvent"
     */
    @Override
    public String toString() {
        return "WinEvent";
    }

}
