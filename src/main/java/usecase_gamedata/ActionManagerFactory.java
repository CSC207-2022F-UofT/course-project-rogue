package usecase_gamedata;

import usecase_factories.PlayerFactory;
import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

public class ActionManagerFactory {

    private PlayerFactory playerFactory;
    private LevelFactory levelFactory;
    private MoveManager moveManager;

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
     * Create a ActionManagerFactory, by calling this, a Player is being created from file.
     */
    public ActionManagerFactory(){
        playerFactory = new PlayerFactory();
        playerFactory.create();
        levelFactory = new LevelFactory();
        moveManager = new MoveManager();
    }

    /**
     * Change moveManager, so it is on the Map of next level.
     * @param level The level id.
     */
    private void updateMoveManager(int level){
        this.moveManager.changeMap(this.playerFactory.create(),levelFactory.create(level));
    }

    /**
     * Change MoveManager and Player, so they are in the next level.
     * @param level The level ID.
     */
    public void enterLevel(int level){
        levelFactory.setSpawnPoint(this.playerFactory.create(),level);
        this.updateMoveManager(level);
    }

    /**
     * @return The moveManager.
     */
    public MoveManager getMoveManager(){
        return this.moveManager;
    }

    public ActionManager getActionManager(){
        ActionManager actionManager = new ActionManager();
        //actionManager.addObserver(new Heal(playerFactory.create();,KEYS[0],KEYS[1],KEYS[2]));
        //actionManager.addObserver(new Upgrade(playerFactory.create();player,KEYS[3],KEYS[4],KEYS[5]));
        //actionManager.addObserver(new Combat(playerFactory.create();,KEYS[6],KEYS[7]));
        return actionManager;
    }

}
