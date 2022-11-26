package user_interface;
import interface_adapters.OutputBoundary;
import user_interface.Graphics.ViewModel;

public class Visual implements OutputBoundary {

    private View_Interface vi;
    private ViewModel model = new ViewModel();
    public Visual(View_Interface vi){
        this.vi = vi;
    }


    /**
     *
     * @return a duplicated view model of this presenter. (This method is used to pass the new view model to view.)
     */
    public ViewModel sendModel(){
        ViewModel newModel = new ViewModel();
        newModel.duplicate(this.model);
        return newModel;
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
        this.model.setText1(line1);
        this.model.setText2(line2);
        this.model.setText3(line3);
        this.model.setText4(line4);
        vi.update(this.sendModel());
    }

    /**
     * @param hp : the hp value of player given from use case.
     */
    @Override
    public void update_Hp(int hp) {
        this.model.setHp(hp);
        vi.update(this.sendModel());
    }

    /**
     * @param cnt : the count of essence that player has given by use case.
     */
    @Override
    public void update_EssenceCnt(int cnt) {
        this.model.setEs(cnt);
        vi.update(this.sendModel());
    }

    /**
     * @param cnt : the count of Artifacts the player has given by use case.
     */
    @Override
    public void update_Artifact(int cnt) {
        this.model.setAf(cnt);
        vi.update(this.sendModel());
    }

    /**
     * @param location : the location of the player on the map given by use case.
     */
    @Override
    public void update_Playerlocation(int[] location) {
        //implement today
    }

    /**
     * This method is called to inform the UI that the player has won the game.
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