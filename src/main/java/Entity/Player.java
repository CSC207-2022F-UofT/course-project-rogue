package java.Entity;


import java.util.ArrayList;
import java.util.HashMap;


public class Player {
    private int maxHitPoint;
    //Maximum HP of the player
    private int currHitPoint;
    //Current HP of the Player
    private final int attackPoint;
    //Base Attack Point of the Player *** I MADE THIS FINAL BECAUSE I DON'T THINK WE WILL CHANGE IT**
    // INSTEAD IT WILL ONLY BE USED AS CALCULATION WITH THE WEAPONS ATK POINT
    private HashMap<Character, Integer> location = new HashMap<Character, Integer>();
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    //A Hashmap of the player inventory so in python sense, it'll look something like this
    //{"Collectibles": Collectible Class, "Win Collectibles": Collectible Class, "Weapon": Equipment Class,
    // "Armor": Equipment Class}


    // NOTE: INTEGER IS PLACEHOLDER UNTIL ITEM CLASS IS CREATED

    public Player(){
        this.maxHitPoint = 100;
        this.currHitPoint = 100;
        this.attackPoint = 10;
        //REMINDER TO MYSELF THAT THIS PART IS INCOMPLETE
        this.inventory.put("Collectibles", 20);
        this.inventory.put("Win Collectibles", 20);
        this.inventory.put("Weapon", 30);
        this.inventory.put("Armor", 40);
        //REMINDING MYSELF TO CHANGE THIS WHEN ITEM CLASS IS DONE
        this.location.put('x', 0);
        this.location.put('y', 0);
        //May change starting location later depending on map design
    }

    public int getCurrHitPoint(){
        return this.currHitPoint;
    }
    public int increaseCurrHitPoint(int increase){
        // Increase HP based on input, if HP after increasing is greater than max, then set the current HP to max, else
        // set current HP to the newly updated HP stat
        int currHP = getCurrHitPoint();
        int newCurrHP = currHP + increase;
        this.currHitPoint = Math.min(newCurrHP, maxHitPoint);
        return getCurrHitPoint();
    }
    public int decreaseCurrHitPoint(int decrease){
        // Decrease HP based on input, if HP after decrease is lesser than 0, then set the current HP to 0, else
        // set current HP to the newly updated HP stat
        int currHP = getCurrHitPoint();
        int newCurrHP = currHP - decrease;
        this.currHitPoint = Math.max(0, newCurrHP);
        return getCurrHitPoint();
    }
    public int getAttackPoint(){
        return this.attackPoint;
    }
    public HashMap<Character, Integer> getLocation(){
        return this.location;
    }
    public HashMap<Character, Integer> locationIncreaseByOne(Character var){
        //Since the player can only move 1 tile at a time and not diagonally, we are increasing x or y tile by 1
        //Only Accepts 'x' or 'y' as input
        int curr = this.location.get(var);
        this.location.put(var, curr + 1);
        return this.getLocation();
        //May need to add exceptions
    }
    public HashMap<Character, Integer> locationDecreaseByOne(Character var){
        //Since the player can only move 1 tile at a time and not diagonally, we are decreasing x or y tile by 1
        //Only Accepts 'x' or 'y' as input
        int curr = this.location.get(var);
        this.location.put(var, curr - 1);
        return this.getLocation();
        //May need to add exceptions
    }

    //TODO: add collectible(), reduce collectible(), change armor(), change weapon()
}
