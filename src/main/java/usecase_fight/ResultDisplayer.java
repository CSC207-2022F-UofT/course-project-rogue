package usecase_fight;

import entity.item.Equipment;
import interface_adapters.OutputBoundary;

/** A Displayer that formats fight results into a string. */
public class ResultDisplayer {
    /** Output Boundary interface. */
    OutputBoundary outputBoundary;

    /** Creates a new ResultDisplayer with the given OutputBoundary. */
    public ResultDisplayer(OutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    };

    /**
     * Display the win results of the fight to the user.
     *
     * @param powerResult Result of Monster using its Power.
     * @param essence The number of essence received
     * @param exchange Whether Equipment drop was exchanged with current.
     * @param equipment Equipment to be dropped.
     */
    public void displayResults(String powerResult, int essence, boolean exchange, Equipment equipment){
        String received;
        if (exchange) { // if exchanged equipment, show equipment gained
            received = String.format("%d essence, %s", essence, equipment);
        } else { // if not, equipment not gained
            received = String.format("%d essence", essence);
        }

        String line1 = "You won!" + powerResult;
        String line2 = "Damage Taken: 0";
        String line3 = "Items Received: " + received;
        String line4 = "Press [SpaceBar] to continue."; // not sure if space bar or a different key
        outputBoundary.updateText(line1, line2, line3, line4);
    }

    /**
     * Display the losing results to user.
     *
     * @param powerResult The result of Monster using its Power
     * @param dmg The damage taken by Player
     */
    public void displayResults(String powerResult, int dmg){
        String line1 = "You lost." + powerResult;
        String line2 = String.format("Damage Taken: %d", dmg);
        String line3 = "Items Received: None";
        String line4 = "Press [SpaceBar] to continue.";
        outputBoundary.updateText(line1, line2, line3, line4);
    }

    /**
     * Display stalemate results to PLayer.
     */
    public void displayResults(){
        String line1 = "A Draw!";
        String line2 = "Damage Taken: 0";
        String line3 = "Items Received: None";
        String line4 = "Press [SpaceBar] to continue.";
        outputBoundary.updateText(line1, line2, line3, line4);
    }

    /**
     * Display game over results to Player.
     */
    public void displayGameOver(){
        outputBoundary.updateText("GameOver.", "", "", "Press [SpaceBar] to go back to menu.");
        // again not sure if [SpaceBar] or different key
    }


}
