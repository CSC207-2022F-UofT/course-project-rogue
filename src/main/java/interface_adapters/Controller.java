package interface_adapters;

import entity.player.Player;
import usecase_playeractions.Control;
import usecase_playeractions.Map;

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
    private Control moveControl;

    /**
     * Contain actions that depend on a Player only.
     */
    private Control control;


    /**
     * The default keys:
     * 0:Heal
     * 1:Heal-yes
     * 2:Heal-No
     * 3:Upgrade
     * 4:Upgrade-Armor
     * 5:Upgrade-Sword
     * 6:Fight
     * 7:Flee
     * 8,9,10,11:moveUP,moveLeft,moveDown,moveRight
     */
    private final String[] KEYS = new String[]{"H","Y","N","U","A","S","F","R","W","A","S","D"};

    private OutputBoundary out;

    /**
     * Initialize a Controller that have the basic actions controlled by default keys.
     * Including Move, Heal, Upgrade, Fight, and Flee.
     * @param player The Player this Controls.
     * @param map The Map that player moves on.
     */
    public Controller(Player player, Map map){
        moveControl = new Control(player,map);
        control = new Control();
        //control.addObserver(new Heal(player,KEYS[0],KEYS[1],KEYS[2]));
        //control.addObserver(new Upgrade(player,KEYS[3],KEYS[4],KEYS[5]));
        //control.addObserver(new Combat(player,KEYS[6],KEYS[7]));
    }

    /**
     * Change the Map to map.
     * @param player Player this controls.
     * @param map The Map that player moves on.
     */
    public void setMap(Player player,Map map){
     moveControl = new Control(player,map);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        moveControl.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
        control.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
    }
}
