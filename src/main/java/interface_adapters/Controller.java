package interface_adapters;

import usecase_gamedata.ActionManagerFactory;
import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

import java.awt.event.KeyEvent;

/**
 * The Controller used to control player.
 */
public class Controller {

    /**
     * Contain actions that depend on a Map.
     * Don't have to be a Mover.
     */
    private MoveManager moveManager;

    /**
     * Contain actions that depend on a Player only.
     */
    private ActionManager actionManager;
    private ActionManagerFactory actionManagerFactory;

    /**
     * Initialize a Controller that have the basic actions controlled by default keys.
     * Including Heal, Upgrade, Fight, and Flee.
     */
    public Controller(){
        actionManagerFactory = new ActionManagerFactory();
        actionManager = actionManagerFactory.getActionManager();
        moveManager = actionManagerFactory.getMoveManager();
    }

    /**
     * Place the player in the new level.Called after OutputBoundary.updateWin().
     */
    public void newGame(){
        this.enterLevel(0);
    }
    public void enterLevel(int level){
       actionManagerFactory.enterLevel(level);
    }

    public void keyReleased(KeyEvent e) {
        moveManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
        actionManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
    }
}