package usecase_fight;

import entity.item.Equipment;
import entity.monster.Monster;

/** A summary of the fight a Player is in. */
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

    /**
     * A fight is a stalemate iff the Player's win chance is 0 and the damage dealt by the Monster is also 0.
     *
     * @return True iff this fight is a stalemate.
     */
    public boolean getStaleMate(){
        return (winChance == 0 && damage == 0);
    }

    /** @return The Equipment being dropped. */
    public Equipment getEquipment(){
        return this.equipment;
    }

    /** @return The Monster in the fight. */
    public Monster getMonster(){
        return this.monster;
    }

    /**
     * @return A list of strings representing this FightSummary.
     */
    public String[] getSummary(){
        String line1 = String.format("You encountered a %s!", this.monster);
        String line2 = String.format("Power: %s, ", this.monster.getPowerString())
                + String.format("Win chance: %d", this.winChance) + "%, "
                + String.format("Damage: %d", this.damage);
        String line3;
        if (equipment == null){
            line3 = String.format("Drops: %d essence", this.essenceNum);
        } else{
            line3 = String.format("Drops: %d essence,", this.essenceNum) +
                    String.format(" %s", this.equipment);
        }
        return new String[]{line1, line2, line3};
    }
}
