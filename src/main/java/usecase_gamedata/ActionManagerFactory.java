package usecase_gamedata;

import usecase_essence_use.heal.HealCalculator;
import usecase_essence_use.heal.Healer;
import usecase_essence_use.upgrade.UpgradeCalculator;
import usecase_essence_use.upgrade.Upgrader;
import usecase_factories.PlayerFactory;
import usecase_fight.Fighter;
import usecase_fight.Runner;
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
        actionManager.addObserver(new Healer(playerFactory.create(), new HealCalculator(playerFactory.create()),KEYS[0]));
        actionManager.addObserver(new Upgrader(playerFactory.create(),new UpgradeCalculator(playerFactory.create(), "Armor"),KEYS[2]));
        actionManager.addObserver(new Upgrader(playerFactory.create(),new UpgradeCalculator(playerFactory.create(), "Weapon"),KEYS[1]));
        actionManager.addObserver(new Fighter(playerFactory.create(),KEYS[6]));
        actionManager.addObserver(new Runner(playerFactory.create(), KEYS[7]));
        return actionManager;
    }

}
