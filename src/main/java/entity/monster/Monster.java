package entity.monster;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entity.Character;
import file_reader.deserialization.MonsterDeserialization;

import java.util.HashMap;

import java.util.Random;


/** A Monster that the Player can encounter in the game.*/

@JsonDeserialize(using = MonsterDeserialization.class)
public class Monster extends Character {

    /** The name of the Monster. */
    private final String name;

    /** The type of the Monster. */
    private final String type;

    /** The base attack of the Monster. */
    private final int baseAttack;

    /** The base health of the Monster. */
    private final int baseHealth;

    /** Whether the Monster has a power. */
    private final boolean hasPower;

    /** The power of the Monster. Null if hasPower is false. */
    private MonsterPower power; // not final to allow for extension of changing powers


    /**
     * Creates a Monster with given name and type. The baseAttack and baseHealth of the Monster is
     * randomly assigned from the given ranges. This Monster will not have a power.
     *
     * @param name     Monster name
     * @param type     Monster type
     * @param stats The ranges of possible values of baseHealth and baseAttack, inclusive.
     * @param state Whether Monster has a power.
     */
    public Monster(String name, String type, HashMap<String, int[]> stats, boolean state) {
        this.name = name;
        this.type = type;
        this.hasPower = state;

        Random rand = new Random();
        int[] attackStat = stats.get("Attack");
        int[] healthStat = stats.get("Health");
        this.baseAttack = rand.nextInt(attackStat[1] - attackStat[0] + 1) + attackStat[0];
        // selects a random atk between min and max, inclusive
        this.baseHealth = rand.nextInt(healthStat[1] - healthStat[0] + 1) + healthStat[0];
        // selects a random hp between min and max inclusive
    }

    /**
     * Creates a Monster with given name and type. The baseAttack and baseHealth of the Monster is
     * randomly assigned from the given ranges. This Monster will have a power.
     *
     * @param pwr The power of Monster.
     */
    public Monster(String n, String t, HashMap<String, int[]> stats, boolean state, MonsterPower pwr) {
        this(n, t, stats, state);
        this.power = pwr;
    }

    /**
     * @return The name of the Monster.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return The type of the Monster.
     */
    public String getType() {
        return this.type;
    }
    // for now this method is not coded for multiple types

    /**
     * @return The base attack of the Monster.
     */
    public int getAttack(){
        return this.baseAttack;
    }

    /**
     * @return The base attack of the Monster.
     */
    public int getHealth(){
        return this.baseHealth;
    }

    /**
     * @return Whether the Monster has a power.
     */
    public boolean isHasPower(){
        return this.hasPower;
    }


    /**
     * @return The Power of the Monster.
     */
    public MonsterPower getPower(){
        return this.power;
    }


    /** Represents a Monster as its name. */
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * @return the string representation for the given Monsters power. Returns "None" if Monster has no power.
     */
    public String getPowerString(){
        String power = "None";
        if (this.isHasPower()){
            power = this.getPower().toString();
        }
        return power;
    }
}
