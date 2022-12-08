package user_interface;
import interface_adapters.Controller;
import user_interface.Graphics.GameFrame;
import user_interface.Graphics.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View implements KeyListener, ViewInterface {
    private Controller controller;
    private final JFrame game_play;
    private final GameFrame gameFrame;

    /**
     * Sets up the view with the start button and sets up the controller that it passes information to.
     * @param controller: The controller it is sending the information to
     */
    public View(Controller controller){
        game_play = new JFrame();
        game_play.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //game_play.setLayout(null);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_hight = Toolkit.getDefaultToolkit().getScreenSize().height;
        game_play.setSize(screen_width,screen_hight);
        game_play.setResizable(false);
        //game_play.setUndecorated(true);
        game_play.setTitle("");
        this.controller = controller;
        //Add Menu panel
        gameFrame = new GameFrame(this);
        game_play.add(gameFrame);

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
        this.controller = controller;
    }

    /**
     * This method is called when the start button is clicked. This method is called in GameFrame.
     */
    public void startButtonClicked(){
        gameFrame.addListener(this);
        controller.newGame();
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

    /** Goes back to the menu if this method is called
     *
     */
    @Override
    public void goBackToMenu() {
        gameFrame.removeKeyListener(this);
        gameFrame.goToMenu();
    }

    //This method is intentionally empty
    @Override
    public void keyTyped(KeyEvent e) {}

    //This method is intentionally empty
    @Override
    public void keyPressed(KeyEvent e) {}


    /**
     * Detects the key being released and sends it to the controller
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        controller.keyReleased(e);
    }

    /**
     * @param start : A variable passed from visual to indicate that view can start showing updated view
     *               model.
     */
    @Override
    public void startGameVisual(boolean start){
        gameFrame.setStart(start);
    }

}
