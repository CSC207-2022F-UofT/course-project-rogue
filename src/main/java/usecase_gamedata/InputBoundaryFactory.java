package usecase_gamedata;

import usecase_essence_use.manager.HealCalculator;
import usecase_essence_use.manager.Healer;
import usecase_essence_use.essenceUseKey.UpgradeCalculator;
import usecase_essence_use.essenceUseKey.Upgrader;
import usecase_factories.PlayerFactory;
import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

public class InputBoundaryFactory implements InputBoundaryFactoryInputBoundary{

    private PlayerFactory playerFactory;
    private MapFactory mapFactory;
    private MoveManager moveManager;

    public InputBoundaryFactory(PlayerFactory playerFactory, MapFactory mapFactory) {
        this.playerFactory = playerFactory;
        this.mapFactory = mapFactory;
        this.moveManager = new MoveManager();
    }

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
     * Change moveManager, so it is on the Map of next level.
     * @param level The level id.
     */
    private void updateMoveManager(int level){
        this.moveManager.changeMap(this.playerFactory.create(),mapFactory.create(level));
    }

    /**
     * Change MoveManager and Player, so they are in the next level.
     * @param level The level ID.
     */
    @Override
    public void enterLevel(int level){
        mapFactory.create(level);
        mapFactory.setSpawnPoint(playerFactory.create(), level);
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
        return actionManager;
    }

}
