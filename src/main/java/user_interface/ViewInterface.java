package user_interface;

import interface_adapters.Controller;
import user_interface.Graphics.GameFrame;
import user_interface.Graphics.ViewModel;

import javax.swing.*;

public interface ViewInterface {
    public void setController(Controller c);
    public void setVisible(boolean b);
    public void update(ViewModel model);
}
