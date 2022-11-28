package interface_adapters;

import game_data.GameInstance;
import usecase_gamedata.MapFactory;
import usecase_gamedata.PlayerFactory;
import usecase_playeractions.ActionManager;
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
    private ActionManager moveManager;

    /**
     * Contain actions that depend on a Player only.
     */
    private ActionManager manager;
    private PlayerFactory playerFactory;


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

    /**
     * Initialize a Controller that have the basic actions controlled by default keys.
     * Including Heal, Upgrade, Fight, and Flee.
     */
    public Controller(){
        playerFactory = new PlayerFactory();
        moveManager = new ActionManager();
        manager = new ActionManager();
        //manager.addObserver(new Heal(player,KEYS[0],KEYS[1],KEYS[2]));
        //manager.addObserver(new Upgrade(player,KEYS[3],KEYS[4],KEYS[5]));
        //manager.addObserver(new Combat(player,KEYS[6],KEYS[7]));
    }

    /**
     * Change the Map to map.
     * @param map The Map that player moves on.
     */
    private void setMap(Map map){
        moveManager = new ActionManager(playerFactory.create(),map);
    }

    /**
     * Start the game, calling this initializes Player.
     */
    public void newGame(){
        playerFactory.create();
    }

    /**
     * Start a new level, which creates the Map and place Player on the spawn point
     * @param level the level of the Map
     */
    public void newLevel(int level){
        MapFactory mapFactory = new MapFactory();
        this.setMap(mapFactory.create(level));
        mapFactory.setSpawnPoint(playerFactory.create());
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
        manager.keyPressed(Character.toString(e.getKeyChar()).toUpperCase());
    }
}