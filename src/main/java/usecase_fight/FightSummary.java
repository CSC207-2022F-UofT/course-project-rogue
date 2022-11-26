package usecase_fight;

import entity.equipment_slots.item.Equipment;
import entity.monster.Monster;

public class FightSummary {
    private final Monster monster;
    /** The amount of damage to be done to Player. */
    private final int damage;
    /** The number of essence being dropped. */
    private final int essenceNum;
    /** The win chance of the Player. */
    private final int winChance;
    /** The equipment being dropped. This won't always be assigned. */
    private Equipment equipment;

    /**
     * Create a FightSummary with details on the amount of essence being dropped, and the Player's win chance.
     *
     * @param monster The Monster in the fight.
     * @param num     The number of Collectible being dropped from the fight.
     * @param chance  The chance Player has to win the fight.
     */
    public FightSummary(Monster monster, int num, int chance, int damage){
        this.monster = monster;
        this.essenceNum = num;
        this.winChance = chance;
        this.damage = damage;
    }

    /**
     * Create a FightSummary with details on collectible, collectible amount, win chance, and equipment drops.
     *
     * @param equipment The equipment being dropped from the fight.
     */
    public FightSummary(Monster monster, int num, int chance, int damage, Equipment equipment){
        this(monster, num, chance, damage);
        this.equipment = equipment;
    }

    /** @return The amount of damage to be done to Player. */
    public int getDamage(){
        return this.damage;
    }

    /** @return The amount of Collectible being dropped. */
    public int getAmountDrop(){
        return this.essenceNum;
    }

    /** @return The win chance of Player. */
    public int getWinChance(){
        return this.winChance;
    }

    /** @return The Equipment being dropped. */
    public Equipment getEquipment(){
        return this.equipment;
    }

    /** @return The Monster in the fight. */
    public Monster getMonster(){
        return this.monster;
    }
}
