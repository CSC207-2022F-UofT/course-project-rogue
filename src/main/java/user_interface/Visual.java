package user_interface;
import interface_adapters.OutputBoundary;

public class Visual implements OutputBoundary {

    private View_Interface vi;
    public Visual(View_Interface vi){
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
    public void update_Text(String line1, String line2, String line3, String line4) {
        return
    }

    /**
     * @param hp
     */
    @Override
    public void update_Hp(int hp) {

    }

    /**
     * @param cnt
     */
    @Override
    public void update_EssenceCnt(int cnt) {

    }

    /**
     * @param s
     */
    @Override
    public void update_Artifact(String s) {

    }

    /**
     * @param location
     */
    @Override
    public void update_Playerlocation(int[] location) {

    }

    /**
     *
     */
    @Override
    public void update_Win() {

    }

    /**
     *
     */
    @Override
    public void update_Dead() {

    }
}