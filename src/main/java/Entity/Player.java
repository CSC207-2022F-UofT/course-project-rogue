package Entity;


import java.util.ArrayList;
import java.util.HashMap;


public class Player{
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
    //{"Essence": Collectible Class, "Artifact": Collectible Class, "Weapon": Equipment Class,
    // "Armor": Equipment Class}
    // May be HashMap<Items, Integer> instead later on


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
    public HashMap<Character, Integer> getItem(String category){
        // Subject to Change
        // Idea is to get items and use polymorphism to get
        // 1. If it is collectible, toString will show the string of the number of collectibles
        // 2. If it is equipment, it will show the name and stats of the equipment
        Item item = this.inventory.get(category);
        return item.toString();
    }
    public int getMaxHitPoint(){
        return this.maxHitPoint;
    }
    public int getCurrHitPoint(){
        return this.currHitPoint;
    }
    public int getAttackPoint(){
        return this.attackPoint;
    }
    public HashMap<Character, Integer> getPlayerLocation(){
        return this.location;
    }
    public void changeCurrHitPoint(int x, boolean increase){
        // Precondition:
        //      - x : The number to increase or decrease the current health by
        //      - increase: if True, increase health, else decrease health
        // Increase HP based on input, if HP after increasing is greater than max, then set the current HP to max, else
        // set current HP to the newly updated HP stat
        int currHP = getCurrHitPoint();
        int newCurrHP;
        if (increase){
            newCurrHP = currHP + x;
            this.currHitPoint = Math.min(newCurrHP, maxHitPoint);
        }
        else{
            newCurrHP = currHP - x;
            this.currHitPoint = Math.max(0, newCurrHP);
        }
    }

    public void changeLocationByOne(Character axis, boolean increase){
        // Precondition:
        //      - axis: only 'x' or 'y'
        //      - increase: If true then increase, else decrease axis by 1.
        //Since the player can only move 1 tile at a time and not diagonally, we are increasing
        // (if increase is true) or decreasing (if increase is false) x or y tile by 1
        // TODO: If needed I may need to check for boundary (maybe not because that might be David's job)
        int curr = this.location.get(axis);
        assert(axis == 'x' | axis == 'y');
        // Assert axis for error
        if (increase){
            this.location.put(axis, curr + 1);
        }
        else{
            this.location.put(axis, curr - 1);
        }
    }


    public void manageInventory(String collectibleType, boolean increase) throws Exception {
        // Precondition:
        //              - get the collectibles names "Essence" or "Artifacts"
        //              - increase such collectible if true, else decrease
        // TODO: May need to add a variable to increase or decrease things by.
        if ("Essence, Artifacts".contains(collectibleType)){
            Integer collectible = this.inventory.get(collectibleType);
            if (increase){
                collectible.increase();
            }
            else{
                collectible.decrease();
            }
        }
        else{
            throw new Exception("Collectible Type inputted is incorrect");
        }


        //Or what ever it is named by you Jillian
    }
    public void manageInventory(String equipmentType, Equipment equipment) throws Exception {
        // Precondition:
        //              - Equipment Type in String ("Weapon", "Armor")
        //              - equipment that you are changing
        if ("Sword, Armor".contains(equipmentType)) {
            this.inventory.put(equipmentType, equipment);
        }
        else{
            throw new Exception("Equipment Type inputted is incorrect");
        }
    }
}
