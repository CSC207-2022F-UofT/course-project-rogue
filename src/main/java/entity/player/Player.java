package entity.player;

import entity.item.Armor;
import entity.Character;
import entity.item.Weapon;
import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Collectible;
import entity.item.Equipment;
import usecase_fight.FightSummary;

import file_reader.deserialization.PlayerDeserialization;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PlayerDeserialization.class)
public class Player extends Character {

    private final int maxHitPoint; // maybe we can combine Player's info into its own class
    private int currHitPoint;
    private final int attackPoint;
    private final int[] location;
    private final CollectibleInventory collectibleInventory;
    private final BasicEquipmentSlots equipments;
    private final States state;
    /** Details of the fight that Player is in. */
    private FightSummary fight;

    /**The Basic Player Template, it is flexible in terms of being able to add an instance of class system if needed
     * The inventory is open for adding more items.
     * @param maxHitPoint: Max Hit Point of Player and also the Current Hit Point during construction
     * @param attackPoint: Base Attack Point of the Player
     * @param inventory: An inventory class that holds the collectibles or items they have.
     * @param equipments: The player's equipment slot in which they equip equipments to increase their battle strength
     *
     */
    public Player(int maxHitPoint, int attackPoint, CollectibleInventory inventory, BasicEquipmentSlots equipments){
        this.maxHitPoint = maxHitPoint;
        this.currHitPoint = maxHitPoint;
        this.attackPoint = attackPoint;
        this.collectibleInventory = inventory;
        this.equipments = equipments;
        this.location = new int[2];
        this.state = new States();
    }

    /**Gets the Weapon that the player is equipping
     *
     * @return returns the Weapon in Equipment Slots
     */
    public Equipment getWeapon(){
        return this.equipments.getWeapon();
    }

    /**Gets the Armor that the player is equipping
     *
     * @return returns the Armor in Equipment Slots
     */
    public Equipment getArmor(){
        return this.equipments.getArmor();
    }

    /** Gets the essence Collectible
     *
     * @return The collectible stored inside the inventory
     */
    public Collectible getEssence(){
        return this.collectibleInventory.getEssence();
    }

    /** Gets the artifact Collectible
     *
     * @return The collectible stored inside the inventory
     */
    public Collectible getArtifact(){

        return this.collectibleInventory.getArtifact();
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

    /** Sets currHitPoint of Player based on the inputted integer x. If the change results in a negative number
     * currHitPoint is set to 0.
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

    /**Sets the location of Player based on the axis
     *
     * @param x: the x-axis to change
     * @param y: the y-axis to change
     *
     */
    public void setLocation(int x, int y){
        location[0] = x;
        location[1] = y;
    }


    /** Changes the number of Essence in the inventory
     *
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */
    public void changeEssenceAmount(int amount){
        this.collectibleInventory.changeEssenceAmount(amount);
    }

    /** Changes the number of Artifact in the inventory
     *
     * @param amount: Adds amoount to current amount, the boundary of amount is
     *                 -infinity < amount < infinity
     */
    public void changeArtifactAmount(int amount){
        this.collectibleInventory.changeArtifactAmount(amount);
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

    /**Sets whether if the player can Heal
     *
     * @param canHeal: True if player can Heal, else false
     */
    public void setCanHeal(boolean canHeal) {
        state.setCanHeal(canHeal);
    }

    /**Sets whether if the player can move
     *
     * @param canMove: True if player can move, else false
     */
    public void setCanMove(boolean canMove){
        state.setCanMove(canMove);
    }

    /**Sets whether if the player can Upgrade
     *
     * @param canUpgrade: True if player can Upgrade, else false
     */
    public void setCanUpgrade(boolean canUpgrade) {
        state.setCanUpgrade(canUpgrade);
    }

    /**Sets whether if the player is Fighting
     *
     * @param fighting: True if player is Fighting, else false
     */
    public void setFighting(boolean fighting) {
        state.setFighting(fighting);
    }

    /**Sets whether if the player is upgrading
     *
     * @param upgrading: True if player is upgrading, else false
     */
    public void setUpgrading(boolean upgrading) {
        state.setUpgrading(upgrading);
    }

    /**
     * Changes Player into GameOver state.
     * To chang out of GameOver state, any other Player state must be set to true.
     */
    public void setGameOver(){state.setGameOver();}

    /**Gets canHeal from states
     *
     */
    public boolean getCanHeal() {
        return state.getCanHeal();
    }

    /**Gets canMove from states
     *
     */
    public boolean getCanMove() {
        return state.getCanMove();
    }

    /**Gets canUpgrade from states
     *
     */
    public boolean getCanUpgrade() {
        return state.getCanUpgrade();
    }

    /**Gets fighting from states
     *
     */
    public boolean getFighting() {
        return state.getFighting();
    }

    /**Gets upgrading from states
     *
     */
    public boolean getUpgrading() {
        return state.getUpgrading();
    }

    /**
     * @return GameOver state of Player.
     */
    public boolean getGameOver() {return state.getGameOver();}

    /**Gets Collectible Inventory from Player
     *
     */
    public CollectibleInventory getCollectibleInventory(){
        return this.collectibleInventory;
    }

    /**Gets Equipment Slot From Player Inventory from Player
     *
     */
    public BasicEquipmentSlots getEquipments(){
        return this.equipments;
    }

    /** Reassigns a new FightSummary to Player. */
    public void setFight(FightSummary summary){
        this.fight = summary;
    }

    /**
     * @return Fight details of Player fight.
     */
    public FightSummary getFight(){
        return this.fight;
    }
}
