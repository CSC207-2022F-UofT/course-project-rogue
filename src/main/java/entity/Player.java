package entity;

public class Player{

    private final int maxHitPoint;
    private int currHitPoint;
    private final int attackPoint;
    private final int[] location;
    private final CollectibleInventory collectibleInventory;
    private final BasicEquipmentSlots equipments;


    /**The Basic Player Template, it is flexible in terms of being able to add an instance of class system if needed
     * The inventory is open for adding more items.
     * @param maxHitPoint: Max Hit Point of Player and also the Current Hit Point during construction
     * @param attackPoint: Base Attack Point of the Player
     * @param location: Array of integers that holds player location coordinates based on (x,y)
     * @param inventory: An inventory class that holds the collectibles or items they have.
     * @param equipments: The player's equipment slot in which they equip equipments to increase their battle strength
     *
     */
    public Player(int maxHitPoint, int attackPoint, CollectibleInventory inventory, BasicEquipmentSlots equipments,
                  int[] location){
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

    /**Gets the equipment that the player is equipping based on the inputted equipment type
     *
     * @param equipmentType: The type of entity.Equipment the Player is equipping
     *                     in this case {"entity.Weapon", "entity.Armor"}
     *
     * @return returns the entity.Equipment class
     */
    public Equipment getEquipment(String equipmentType) throws IllegalArgumentException{

        if((equipmentType.equals("Weapon"))) {
            return this.equipments.getWeapon();
        } else if (equipmentType.equals("Armor")){
            return this.equipments.getArmor();
        }else {
            throw new IllegalArgumentException();
        }
    }

    /**Gets the desired collectible class based on the CollectibleType String
     *
     * @param collectibleType: The type of entity.Collectible the Player has in their inventory
     *                     in this case {"Essence", "Artifacts"}
     *
     * @return returns the collectible class of the desired object
     */
    public Collectible getCollectible(String collectibleType){

        return this.collectibleInventory.getCollectible(collectibleType);
    }

    /**Gets the instance variable of the Max HP of player
     *
     * @return returns the instance variable of the Max HP of player
     */
    public int getMaxHitPoint(){

        return this.maxHitPoint;
    }

    /**the instance variable of the Current HP of player
     *
     * @return Returns the instance variable of the Current HP of player
     */
    public int getCurrHitPoint(){

        return this.currHitPoint;
    }

    /**Gets the instance variable of the Attack Point of player
     *
     * @return Returns the instance variable of the Attack Point of player
     */
    public int getAttackPoint(){

        return this.attackPoint;
    }

    /**Gets the instance variable of the Current Location of player
     *
     * @return Returns the instance variable of the Current Location of player
     */
    public int[] getPlayerLocation(){

        return this.location;
    }

    /**Sets the current hitpoint of Player based on the the inputted integer x
     *
     * @param x: The integer to increase by, if x is positive then increase, else if it is negative, it'll decrease.
     *
     */
    public void changeCurrHitPoint(int x){
        int afterAmount = this.currHitPoint + x;
        if (afterAmount >= maxHitPoint){
            this.currHitPoint = maxHitPoint;
        } else this.currHitPoint = Math.max(afterAmount, 0);
    }

    /**Sets the location of Player based on axis and coordinate i
     *
     * @param axis: The axis x, y on the location array.
     *            0 = x
     *            1 = y
     * @param i: the new x or y coordinate of player
     *
     */
    public void setLocation(int axis, int i){
        location[axis] = i;
    }


    /**Sets the desired collectible class amount based on the CollectibleType String and Integer amount
     *
     * @param collectibleType: The type of Collectible the Player has in their inventory
     *                         in this case {"Essence", "Artifacts"}
     * @param amount: The amount to increase the desired collectibleType by,
     *              if amount is positive then increase
     *              if amount is negative then decrease
     */
    public void changeCollectibleAmount(String collectibleType, int amount){
        this.collectibleInventory.changeAmount(collectibleType, amount);
    }

    /**Change the Weapon of Equipment Slot based on the new inputted Weapon
     *
     * @param newWeapon: The new equipment to equip and replace in the equipment slot
     */
    public void setEquipment(Weapon newWeapon) {
        this.equipments.setWeapon(newWeapon);
    }

    /**Change the Armor of Equipment Slot based on the new inputted Weapon
     *
     * @param newArmor: The new equipment to equip and replace in the equipment slot
     */
    public void setEquipment(Armor newArmor) {
        this.equipments.setArmor(newArmor);
    }
}
