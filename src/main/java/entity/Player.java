package entity;

public class Player{

    private final int maxHitPoint;
    private int currHitPoint;
    private final int attackPoint;
    private int[] location;
    private CollectibleInventory collectibleInventory;
    private BasicEquipmentSlots equipments;
    /**The Basic Player Template, it is flexible in terms of being able to add an instance of class system if needed
     * The inventory is open for adding more items.
     * @param maxHitPoint: Max Hit Point of Player
     * @param currHitPoint: Current Hit Point of Player
     * @param attackPoint: Base Attack Point of the Player
     * @param location: Array of integers that holds player location coordinates based on (x,y)
     * @param inventory: An inventory class that holds the collectibles or items they have.
     * @param equipments: The player's equipment slot in which they equip equipments to increase their battle strength
     *
     */

    public Player(int maxHitPoint, int attackPoint, CollectibleInventory inventory, BasicEquipmentSlots equipments,
                  Integer[] location){
        /**Constructs Player
         *
         * @param maxHP: Max Hit Point of Player, Current hit point is set to Max at the during construction
         * @param atkPT: Base Attack Point of the Player
         * @param inventory: An inventory class that holds the collectibles or items they have.
         * @param equipments: The player's equipment slot in which they equip equipments to increase their battle strength
         * @param x: x coordinate of the Player
         * @param y: y coordinate of the Player
         *
         * @returns a constructed Player
         */
        this.maxHitPoint = maxHitPoint;
        this.currHitPoint = maxHitPoint;
        this.attackPoint = attackPoint;
        //REMINDER TO MYSELF THAT THIS PART IS INCOMPLETE
        this.collectibleInventory = inventory;
        this.equipments = equipments;
        //REMINDING MYSELF TO CHANGE THIS WHEN ITEM CLASS IS DONE
        this.location = location;
        //May change starting location later depending on map design
    }

    public Equipment getEquipment(String equipmentType){
        /**Gets the equipment that the player is equipping based on the inputted equipment type
         *
         * @param equipmentType: The type of Equipment the Player is equipping
         *                     in this case {"Weapon", "Armor"}
         *
         * @returns returns the Equipment class
         */
        if((equipmentType.equals("Weapon"))) {
            return this.equipments.getWeapon();
        } else if (equipmentType.equals("Armor")){
            return this.equipments.getArmor();
        }

        return null;
    }
    public Collectible getCollectible(String collectibleType){
        /**Gets the desired collectible class based on the CollectibleType String
         *
         * @param collectibleType: The type of Collectible the Player has in their inventory
         *                     in this case {"Essence", "Artifacts"}
         *
         * @returns returns the collectible class of the desired object
         */
        return this.collectibleInventory.getCollectible(collectibleType);
    }
    public int getMaxHitPoint(){
        /**Gets the instance variable of the Max HP of player
         *
         * @returns returns the instance variable of the Max HP of player
         */
        return this.maxHitPoint;
    }
    public int getCurrHitPoint(){
        /**the instance variable of the Current HP of player
         *
         * @returns Returns the instance variable of the Current HP of player
         */

        return this.currHitPoint;
    }
    public int getAttackPoint(){
        /**Gets the instance variable of the Attack Point of player
         *
         * @returns Returns the instance variable of the Attack Point of player
         */
        return this.attackPoint;
    }
    public int[] getPlayerLocation(){
        /**Gets the instance variable of the Current Location of player
         *
         * @returns Returns the instance variable of the Current Location of player
         */
        return this.location;
    }

    public void setCurrHitPoint(int x){
        /**Sets the current hitpoint of Player based on the the inputted integer x
         *
         * @param x: The integer to increase by, if x is positive then increase, else if it is negative, it'll decrease.
         *
         * @returns Adds x to current hit point of player
         */
        this.currHitPoint += x;
    }

    public void setLocation(int axis, int i){
        /**Sets the location of Player based on axis and coordinate i
         *
         * @param axis: The axis x, y on the location array.
         *            0 = x
         *            1 = y
         * @param i: the new x or y coordinate of player
         *
         * @returns Changes the current axis coordinate of player to i
         */
        location[axis] = i;
    }

    public void setInventory(String collectibleType, int amount){
        /**Sets the desired collectible class amount based on the CollectibleType String and Integer amount
         *
         * @param collectibleType: The type of Collectible the Player has in their inventory
         *                         in this case {"Essence", "Artifacts"}
         * @param amount: The amount to increase the desired collectibleType by,
         *              if amount is positive then increase
         *              if amount is negative then decrease
         *
         * @returns Adds amount to the desired collectible type of player
         */
        this.collectibleInventory.setInventory(collectibleType, amount);
    }
    public void setEquipment(String equipmentType, Equipment equipment){
        /**Change the equipment of Equipment Slot based on the equipment type to a new Equipment
         *
         * @param equipmentType: The type of Equipment the Player is equipping
         *                     in this case {"Weapon", "Armor"}
         * @param equipment: The new equipment to equip and replace in the equipment slot
         *
         * @returns Change the equipment of Equipment Slot based on the equipment type to a new Equipment
         */
        if (equipmentType.equals("Weapon")){
            this.equipments.setWeapon(equipment);
        } else if (equipmentType.equals("Armor")) {
            this.equipments.setArmor(equipment);
        }
    }


}
