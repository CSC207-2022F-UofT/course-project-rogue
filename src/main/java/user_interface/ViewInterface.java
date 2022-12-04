package user_interface;

import user_interface.Graphics.ViewModel;

public interface ViewInterface {
    void setVisible(boolean b);
   void update(ViewModel model);
    void goBackToMenu();
    void startGameVisual(boolean s);
}
