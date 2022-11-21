package user_interface;
import javax.swing.*;
import interface_adapters.OutputBoundary;

public class Visual implements OutputBoundary{
    view_interface view;
    JFrame game_frame;
    public Visual(){
        this.game_frame = new JFrame();
    }
    public void setView(view_interface view){
         this.view = view;
    }
}