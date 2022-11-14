package controller;

import Interface.InputBoundary;
import javafx.beans.InvalidationListener;

import java.util.Scanner;

public class Controller implements InputBoundary {
    @Override
    public char get_upgrade_decision(boolean EquipmentChoice) {
        Scanner reader = new Scanner(System.in);
        char result = ' ';
        if (EquipmentChoice){
            while(result == 'a' || result == 'A' || result == 's' || result == 'S'){
                result = reader.next().trim().charAt(-1);
            }
            return result;
        }
        while (result == 'y' || result == 'Y' || result == 'n' || result == 'N'){
            result = reader.next().trim().charAt(-1);
        }
        return result;
    }

    @Override
    public boolean get_heal_decision() {
        Scanner reader = new Scanner(System.in);
        char result = ' ';
        while (result == 'y' || result == 'Y' || result == 'n' || result == 'N'){
            result = reader.next().trim().charAt(-1);
        }
        return (result == 'y' || result == 'Y');
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
