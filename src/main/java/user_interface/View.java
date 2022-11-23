package user_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class View implements KeyListener {
    //Controller control;//keyReleased pass in string
    private int progress = 0;

    public View(){
        JFrame game_play = new JFrame();
        game_play.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //game_play.setLayout(null);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        game_play.setSize(screen_width,screen_hight);
        //game_play.setUndecorated(true);
        game_play.setTitle("");

        //Add Menu panel
        if (progress == 0){
            Menu m = new Menu();
            game_play.add(m);
        }
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