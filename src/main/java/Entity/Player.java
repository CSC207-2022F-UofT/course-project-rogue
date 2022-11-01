package Entity;

import java.util.HashMap;

public class Player{
    /*  The Basic Player Template, it is flexible in terms of being able to add an instance of class system if needed
        The inventory is open for adding more items.

        @Param maxHitPoint: Max Hit Point of Player
        @Param currHitPoint: Current Hit Point of Player
        @Param attackPoint: Base Attack Point of the Player
        @Param location: The location of the player based on (x, y)
        @Param inventory: A Hashmap of the player inventory so in python sense, it'll look something like this
        {"Essence": Collectible Class, "Artifact": Collectible Class, "Weapon": Equipment Class,
         "Armor": Equipment Class}
     */
    private final int maxHitPoint;
    private int currHitPoint;
    private final int attackPoint;
    //Base Attack Point of the Player *** I MADE THIS FINAL BECAUSE I DON'T THINK WE WILL CHANGE IT**
    // INSTEAD IT WILL ONLY BE USED AS CALCULATION WITH THE WEAPONS ATK POINT
    private int[] location;
    private CollectibleInventory collectibleInventory;
    private BasicEquipmentSlots equipments;


    public Player(int maxHP, int atkPT, CollectibleInventory inventory, BasicEquipmentSlots equipments, int x, int y){
        this.maxHitPoint = maxHP;
        this.currHitPoint = maxHP;
        this.attackPoint = atkPT;
        //REMINDER TO MYSELF THAT THIS PART IS INCOMPLETE
        this.collectibleInventory = inventory;
        this.equipments = equipments;
        //REMINDING MYSELF TO CHANGE THIS WHEN ITEM CLASS IS DONE
        setLocation(0, x);
        setLocation(1, y);
        //May change starting location later depending on map design
    }

    public Equipment getEquipment(String equipmentType){
        if (equipmentType.equals("Weapon")){
            return this.equipments.getWeapon();
        } else if (equipmentType.equals("Armor")) {
            return this.equipments.getArmor();
        }
    }
    public Collectible getCollectible(String collectibleType){
        return this.collectibleInventory.getCollectible(collectibleType);
    }
    public int getMaxHitPoint(){
        /*
            Gets the instance variable of the Max HP of player
         */
        return this.maxHitPoint;
    }
    public int getCurrHitPoint(){
        /*
            Gets the instance variable of the Current HP of player
         */

        return this.currHitPoint;
    }
    public int getAttackPoint(){
        return this.attackPoint;
    }
    public int[] getPlayerLocation(){
        return this.location;
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
        this.collectibleInventory.setInventory(collectibleType, amount);
    }
    public void setEquipment(String equipmentType, Equipment equipment){
        /* Precondition:
                      - Equipment Type in String ("Sword", "Armor")
                      - equipment that you are changing

         */
        if (equipmentType.equals("Weapon")){
            this.equipments.setWeapon(equipment);
        } else if (equipmentType.equals("Armor")) {
            this.equipments.setArmor(equipment);
        }
    }


}
