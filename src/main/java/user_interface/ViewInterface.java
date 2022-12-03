package user_interface;

import user_interface.Graphics.ViewModel;

public interface ViewInterface {
    public void setVisible(boolean b);
    public void update(ViewModel model);
    public void goBackToMenu();
    public void startGameVisual(boolean s);
}
