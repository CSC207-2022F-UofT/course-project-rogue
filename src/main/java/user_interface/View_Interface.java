package user_interface;

import interface_adapters.Controller;
import user_interface.Graphics.GameFrame;
import user_interface.Graphics.ViewModel;

import javax.swing.*;

public interface View_Interface {
    public void setVisible(boolean b);
    public void update(ViewModel model);
    public void goBackToMenu();
    public void startGameVisual(boolean s);
}
