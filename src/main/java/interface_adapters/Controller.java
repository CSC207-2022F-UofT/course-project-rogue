package interface_adapters;

import usecase_factories.PlayerFactory;
import usecase_gamedata.InputBoundaryFactory;
import usecase_gamedata.InputBoundaryFactoryInputBoundary;
import usecase_gamedata.MapFactory;
import usecase_playeractions.InputBoundary;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Controller used to control player.
 */
public class Controller implements KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        moveManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
        actionManager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
    }

    public void newGame() {
    }
}