package usecase_gamedata;


import usecase_essence_use.EssenceUseActionManager;
import usecase_essence_use.essenceUseKey.Healer;
import usecase_essence_use.essenceUseKey.Upgrader;
import usecase_factories.PlayerFactory;
import usecase_fight.AfterFight;
import usecase_fight.Fighter;
import usecase_fight.Restarter;
import usecase_fight.Runner;
import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

public class InputBoundaryFactory implements InputBoundaryFactoryInputBoundary{

    private final PlayerFactory playerFactory;
    private final MapFactory mapFactory;
    private final MoveManager moveManager;

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
     * 12: Continue
     */
    private final String[] KEYS = new String[]{"H","Y","N","U","A","S","F","R","W","A","S","D", "C"};


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
        actionManager.addObserver(new Fighter(playerFactory.create(), KEYS[6]));
        actionManager.addObserver(new Runner(playerFactory.create(), KEYS[7]));
        actionManager.addObserver(new Restarter(playerFactory.create(), KEYS[12]));
        actionManager.addObserver(new AfterFight(playerFactory.create(), KEYS[12]));
        return actionManager;
    }

    @Override
    public EssenceUseActionManager getEssenceUseActionManager(){
        EssenceUseActionManager essenceUseManager = new EssenceUseActionManager();
        essenceUseManager.setDefaultKey(playerFactory.create());
        return essenceUseManager;
    }

}
