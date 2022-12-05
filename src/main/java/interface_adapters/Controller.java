package interface_adapters;

import usecase_factories.PlayerFactory;
import usecase_gamedata.InputBoundaryFactory;
import usecase_gamedata.InputBoundaryFactoryInputBoundary;
import usecase_gamedata.MapFactory;

import java.awt.event.KeyEvent;

/**
 * The Controller used to control player.
 */
public class Controller{

    /**
     * Contain actions that depend on a Map.
     * Don't have to be a Mover.
     */
    private InputBoundary moveManager;

    /**
     * Contain actions that depend on a Player only.
     */
    private InputBoundary actionManager;
    private InputBoundaryFactoryInputBoundary inputBoundaryFactory;


    /**
     * Initialize a Controller that have the basic actions controlled by default keys.
     * Including Heal, Upgrade, Fight, and Flee.
     */
    public Controller(PlayerFactory playerFactory, MapFactory mapFactory){
        inputBoundaryFactory = new InputBoundaryFactory(playerFactory, mapFactory);
        actionManager = inputBoundaryFactory.getActionManager();
        moveManager = inputBoundaryFactory.getMoveManager();
    }


    /**
     * Recieves the Key Released from View, and notify to all use cases who are observing if a key is pressed.
     *
     * @param e: the user input key being recieved.
     */
    public void keyReleased(KeyEvent e) {
        moveManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());

    }

    /**
     * Calls enterLevel
     */
    public void newGame(){
        this.enterLevel(0);
    }

    /**
     * Creates level 1 for the player by calling enter Level in usecase which loads the first level in the data
     */
    public void enterLevel(int level){
        inputBoundaryFactory.enterLevel(level);
    }
}