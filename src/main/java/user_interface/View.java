package user_interface;
import interface_adapters.Controller;
import user_interface.Graphics.GameFrame;
import user_interface.Graphics.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class View implements KeyListener, ViewInterface {
    //Controller control;//keyReleased pass in string
    private int progress = 0;

    private Controller controller;

    private JFrame game_play;

    private GameFrame gameFrame;

    public View(){
        game_play = new JFrame();
        game_play.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //game_play.setLayout(null);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        game_play.setSize(screen_width,screen_hight);
        game_play.setResizable(false);
        //game_play.setUndecorated(true);
        game_play.setTitle("");

        //Add Menu panel
        if (progress == 0){
            gameFrame = new GameFrame();
            game_play.add(gameFrame);
        }

        game_play.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                int d = JOptionPane.showConfirmDialog(null,"Do you want to leave?","Quit",JOptionPane.CLOSED_OPTION);
                if (d == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
        game_play.setVisible(true);
    }

    @Override
    public void setVisible(boolean b){
        this.game_play.setVisible(b);
    }

    /**
     * @param model : the model made and passed from visual
     */
    @Override
    public void update(ViewModel model) {
        gameFrame.setViewModel(model);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    /**
     * @param c : Controller to be passed in
     */
    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    public static void main(String[] args) {
        new View();
    }

}
