package Entity;

import java.util.HashMap;

public class Player{
    /*  The Basic Player Template, it is flexible in terms of being able to add a instance of class system if needed
        The inventory is open for adding more items.

        @Param maxHitPoint


     */
    private final int maxHitPoint;
    //Maximum HP of the player
    private int currHitPoint;
    //Current HP of the Player
    private final int attackPoint;
    //Base Attack Point of the Player *** I MADE THIS FINAL BECAUSE I DON'T THINK WE WILL CHANGE IT**
    // INSTEAD IT WILL ONLY BE USED AS CALCULATION WITH THE WEAPONS ATK POINT
    private int[] location;
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();

    //A Hashmap of the player inventory so in python sense, it'll look something like this
    //{"Essence": Collectible Class, "Artifact": Collectible Class, "Weapon": Equipment Class,
    // "Armor": Equipment Class}
    // May be HashMap<Items, Integer> instead later on


    // NOTE: INTEGER IS PLACEHOLDER UNTIL ITEM CLASS IS CREATED
    public Player(int maxHP, int atkPT, Collectible essence, Collectible artifact, Equipment sword,
                  Equipment armor, int x, int y){
        this.maxHitPoint = maxHP;
        this.currHitPoint = maxHP;
        this.attackPoint = atkPT;
        //REMINDER TO MYSELF THAT THIS PART IS INCOMPLETE
        setItem("Essence", essence);
        setItem("Artifacts", artifact);
        setItem("Weapon", sword);
        setItem("Armor", armor);
        //REMINDING MYSELF TO CHANGE THIS WHEN ITEM CLASS IS DONE
        setLocation('x', x);
        setLocation('y', y);
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
    public int[] getPlayerLocation(){
        return this.location;
    }

    public void setItem(String item, Item type){
        this.inventory.put(item, type);
    }
    public void setCurrHitPoint(int x){
        currHitPoint = x;
    }

    public void setLocation(int axis, int i){
        location[axis] = i;
    }

    public void setInventory(String collectibleType, int amount){
        /*Precondition:
                      - collectibleType in "Artifact" or "Essence"
                      - -inf < amount < inf
          Postcondition:
                      - Sets the amount for the collectibles
         */
        Integer collectible = this.inventory.get(collectibleType);
        currAmount = collectible.getAmount;
        collectible.setAmount(currAmount + amount);
    }
    public void setInventory(String equipmentType, Equipment equipment){
        /* Precondition:
                      - Equipment Type in String ("Sword", "Armor")
                      - equipment that you are changing

         */
        this.inventory.put(equipmentType, equipment);
    }


}
