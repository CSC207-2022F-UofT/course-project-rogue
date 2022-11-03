package user_interface;
import javax.swing.*;
import java.awt.event.*;

public class View implements KeyListener {
    //Controller control;//keyReleased pass in string

    public View(){
        JFrame game_play = new JFrame();
        game_play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_play.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }
    public static void main(String[] args) {
        new View();
    }
}
