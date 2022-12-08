package user_interface;

import user_interface.graphics.ViewModel;

public interface ViewInterface {
    void setVisible(boolean b);
   void update(ViewModel model);
    void goBackToMenu();
    void startGameVisual(boolean s);
}
