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

    private InputBoundary essenceUseActionManager;
    private InputBoundaryFactoryInputBoundary inputBoundaryFactory;


    /**
     * Initialize a Controller that have the basic actions controlled by default keys.
     * Including Heal, Upgrade, Fight, and Flee.
     */
    public Controller(PlayerFactory playerFactory, MapFactory mapFactory){
        inputBoundaryFactory = new InputBoundaryFactory(playerFactory, mapFactory);
        actionManager = inputBoundaryFactory.getActionManager();
        moveManager = inputBoundaryFactory.getMoveManager();
        essenceUseActionManager = inputBoundaryFactory.getEssenceUseActionManager();
    }


    public void keyReleased(KeyEvent e) {
        moveManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
        actionManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
        essenceUseActionManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
    }
    public void newGame(){
        this.enterLevel(0);
    }
    public void enterLevel(int level){
        inputBoundaryFactory.enterLevel(level);
    }
}