package usecase_gamedata;

import usecase_playeractions.ActionManager;
import usecase_playeractions.MoveManager;

public interface InputBoundaryFactoryInputBoundary {


    MoveManager getMoveManager();
    ActionManager getActionManager();

    void enterLevel(int level);

}
