package usecase_fight;

import entity.item.Equipment;
import entity.monster.Monster;

/** A Formatter that formats fight results into a string. */
public class ResultFormatter {

    /** Creates a new ResultFormatter. */
    public ResultFormatter(){}


    /**
     * Format the win results of the fight.
     *
     * @param powerResult Result of Monster using its Power.
     * @param essence The number of essence received
     * @param exchange Whether Equipment drop was exchanged with current.
     * @param equipment Equipment to be dropped.
     */
    public String[] formatWin(String powerResult, int essence, boolean exchange, Equipment equipment){
        String received;
        if (exchange) { // if exchanged equipment, show equipment gained
            received = String.format("%d essence, %s", essence, equipment);
        } else { // if not, equipment not gained
            received = String.format("%d essence", essence);
        }

        String line1 = "You won! " + powerResult;
        String line2 = "Damage Taken: 0";
        String line3 = "Items Received: " + received;
        String line4 = "Press [C] to continue.";
        return new String[]{line1, line2, line3, line4};
    }

    /**
     * Format the losing results.
     *
     * @param powerResult The result of Monster using its Power
     * @param dmg The damage taken by Player
     */
    public String[] formatLoss(String powerResult, int dmg){
        String line1 = "You lost. " + powerResult;
        String line2 = String.format("Damage Taken: %d", dmg);
        String line3 = "Items Received: None";
        String line4 = "Press [C] to continue.";
        return new String[]{line1, line2, line3, line4};
    }

    /**
     * Format flee results.
     *
     * @param monster The monster the player is fleeing from
     */
    public String[] formatRun(Monster monster){
        String line1 = String.format("Successfully ran away from the %s", monster);
        String line2 = "You may now continue your journey!";
        String line4 = "Press [W][A][S][D] to move";
        return new String[]{line1, line2, "", line4};
    }

    /**
     * Format stalemate results.
     */
    public String[] formatTie(){
        String line1 = "A Draw!";
        String line2 = "Damage Taken: 0";
        String line3 = "Items Received: None";
        String line4 = "Press [C] to continue.";
        return new String[]{line1, line2, line3, line4};
    }

    /**
     * Format game over results.
     */
    public String[] formatGameOver(){
        return new String[]{"GameOver.", "", "", "Press [C] to return to main menu."};
    }


}
