package user_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class View implements KeyListener {
    //Controller control;//keyReleased pass in string

    public View(){
        JFrame game_play = new JFrame();
        game_play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        game_play.setBounds((screen_width-800)/2,(screen_hight-600)/2,800,600);
        game_play.setTitle("");

        Menu m = new Menu();   //Add Menu panel
        game_play.add(m);
        game_play.setVisible(true);

        game_play.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                int d = JOptionPane.showConfirmDialog(null,"Do you want to leave?","Quit",JOptionPane.CLOSED_OPTION);
                if (d == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

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
