package controller;

import Interface.InputBoundary_h_u;
import javafx.beans.InvalidationListener;

import java.util.Scanner;

public class Controller implements InputBoundary_h_u {
    /**
     * The method will return the player decide to upgrade sword or armor.
     * @param EquipmentChoice
     * @return return the choice keyword [A][S]
     */
    @Override
    public String get_upgrade_decision() {
        Scanner reader = new Scanner(System.in);
        String result = new String("");
        while (result.equals("A")||result.equals("S")){
            result = reader.next().trim();
            result = result.substring(result.length()-1).toUpperCase();
        }
        return result;
    }

    /**
     * The method will return if player decide to upgrade/heal
     * @return whether player decide to upgrade
     */
    @Override
    public boolean get_decision() {
        Scanner reader = new Scanner(System.in);
        String result = new String("");
        while (result.equals("Y")||result.equals("N")){
            result = reader.next().trim();
            result = result.substring(result.length()-1).toUpperCase();
        }
        return result.equals("Y");
    }



    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
