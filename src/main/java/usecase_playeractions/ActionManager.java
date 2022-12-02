package usecase_playeractions;

import java.util.Observable;


/**
 * A class that stores the actions the user may perform.
 * Use {@code ActionManager.addObserver(Observer o)} to add addition actions(e.g. Heal, UpgradeWeapon, etc.).
 */
public class ActionManager extends Observable {


    /**
     * Initialize the basic ActionManager class with no Observer
     */
    public ActionManager(){}


    /**
     * Notify observers with the command given.
     * @param s the command given
     */
    public void keyPressed(String s){
        this.setChanged();
        this.notifyObservers(s.toUpperCase());
    }

}
