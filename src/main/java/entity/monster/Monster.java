package entity.monster;

import entity.Character;

import java.util.HashMap;

import java.util.Random;


/** A Monster that the Player can encounter in the game.*/
public class Monster extends Character {

    /** The name of the Monster. */
    private final String NAME;

    /** The type of the Monster. */
    private final String TYPE; // Maybe not String (so can be of multiple type)

    /** The base attack of the Monster. */
    private final int BASE_ATTACK;

    /** The base health of the Monster. */
    private final int BASE_HEALTH;

    /** Whether the Monster has a power. */
    private final boolean HAS_POWER;

    /** The power of the Monster. Null if hasPower is false. */
    private MonsterPower power; // not final to allow for extension of changing powers


    /**
     * Creates a Monster with given name and type. The baseAttack and baseHealth of the Monster is
     * randomly assigned from the given ranges. This Monster will not have a power.
     *
     * @param n     Monster name
     * @param t     Monster type
     * @param stats The ranges of possible values of baseHealth and baseAttack, inclusive.
     * @param state Whether Monster has a power.
     */
    public Monster(String n, String t, HashMap<String, int[]> stats, boolean state) {
        this.NAME = n;
        this.TYPE = t;
        this.HAS_POWER = state;

        Random rand = new Random();
        int[] attackStat = stats.get("Attack");
        int[] healthStat = stats.get("Health");
        this.BASE_ATTACK = rand.nextInt(attackStat[1] - attackStat[0] + 1) + attackStat[0];
        // selects a random atk between min and max, inclusive
        this.BASE_HEALTH = rand.nextInt(healthStat[1] - healthStat[0] + 1) + healthStat[0];
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
        return this.NAME;
    }

    /**
     * @return The type of the Monster.
     */
    public String getType() {
        return this.TYPE;
    }
    // for now this method is not coded for multiple types

    /**
     * @return The base attack of the Monster.
     */
    public int getAttack(){
        return this.BASE_ATTACK;
    }

    /**
     * @return The base attack of the Monster.
     */
    public int getHealth(){
        return this.BASE_HEALTH;
    }

    /**
     * @return Whether the Monster has a power.
     */
    public boolean isHasPower(){
        return this.HAS_POWER;
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
        return this.NAME;
    }
}
