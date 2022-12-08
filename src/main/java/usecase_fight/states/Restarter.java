package usecase_fight.states;

import entity.PlayerData;
import file_reader.GameFileReaderInterface;
import file_writer.GameFileWriterInterface;

/** A path in which the user loses the game. */
public class Restarter extends FightPath implements FightState {

     public static GameFileWriterInterface fileWriter;
     public static GameFileReaderInterface fileReader;

     public static void setFileWriter(GameFileWriterInterface fileWriter){
         if(Restarter.fileWriter == null){
             Restarter.fileWriter = fileWriter;
         }
     }

     public static void setFileReader(GameFileReaderInterface fileReader){
         if(Restarter.fileReader == null){
             Restarter.fileReader = fileReader;
         }
     }

    /**
     * Causes the game to go back to the main menu if the Player is in a game over state.
     */
    public void takePath() {
        outputBoundary.updateDead();
        PlayerData.setPlayer(null);
        fileReader.update();
        fileWriter.restartFile();
    }
}
