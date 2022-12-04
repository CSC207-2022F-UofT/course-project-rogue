package usecase_gamedata;

import usecase_essence_use.EssenceUseActionManager;
import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

public interface InputBoundaryFactoryInputBoundary {


    MoveManager getMoveManager();
    ActionManager getActionManager();
    EssenceUseActionManager getEssenceUseActionManager();
    void enterLevel(int level);

}
