package usecase_playeractions;

import interface_adapters.InputBoundary;

import java.util.Observable;


/**
 * A class that stores the actions the user may perform.
 * Use {@code ActionManager.addObserver(Observer o)} to add addition actions(e.g. Heal, UpgradeWeapon, etc.).
 */
@SuppressWarnings("deprecation")
public class ActionManager extends Observable implements InputBoundary {

    /**
     * Notify observers with the command given.
     * @param s the command given
     */
    @Override
    public void keyPressed(String s){
        this.setChanged();
        this.notifyObservers(s.toUpperCase());
    }

}

