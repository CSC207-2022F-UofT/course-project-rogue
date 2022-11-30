package user_interface;
import interface_adapters.OutputBoundary;

public class Visual implements OutputBoundary {

    private final ViewInterface vi;
    public Visual(ViewInterface vi){
        this.vi = vi;
    }

    /**
     * Precondition : Each sentence should be at most 60 characters per line.
     *
     * @param line1 : words to print in first line of Text box in the game.
     * @param line2 : words to print in second line of Text box in the game.
     * @param line3 : words to print in third line of Text box in the game.
     * @param line4 : words to print in fourth line of Text box in the game.
     */
    @Override
    public void updateText(String line1, String line2, String line3, String line4) {
        
    }

    /**
     * @param hp The new HP to be displayed.
     */
    @Override
    public void updateHp(int hp) {

    }

    /**
     * @param cnt The new essence count to be displayed.
     */
    @Override
    public void updateEssenceCnt(int cnt) {

    }

    /**
     * @param cnt The new artifact count to be displayed.
     */
    @Override
    public void updateArtifact(int cnt) {

    }

    /**
     * @param location The new location of the player to be displayed.
     */
    @Override
    public void updatePlayerLocation(int[] location) {

    }

    /**
     *
     */
    @Override
    public void updateWin() {

    }

    /**
     *
     */
    @Override
    public void updateDead() {

    }
}