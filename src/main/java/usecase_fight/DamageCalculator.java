package usecase_fight;

import entity.Monster.Monster;
import entity.Player;

/** A calculator that determines Monster damage to Player. */
public class DamageCalculator extends Calculator {
    /** Monster in this Calculator. */
    Monster monster;
    /** Monster in this Calculator. */
    Player player;


    /**
     * Creates a new DamageCalculator with the given Monster and Player.
     * @param mon Monster
     * @param play Player
     */
    public DamageCalculator(Monster mon, Player play){
        this.monster = mon;
        this.player = play;
    }

    /**
     * Calculates the amount of damage dealt to Player in a fight.
     * Total damage is determined by: Number of turns * Monster's damage per turn
     *              -> where the number of turns is the number of hits required for Player to kill Monster.
     *              -> where damage per turn is determined by: Monster attack - Player damage reduction.
     * If the damage reduction of the Player is greater than attack power of Monster, return 0.
     *
     * @return The total amount of damage that this monster will inflict.
     */
    @Override
    public int calculate() {
        int mAtk = this.monster.getAttack();
        int pRed = this.player.getEquipment("Armor").getStatValue();
        int attackDmg = Math.max((mAtk - pRed), 0); // attack per turn, minimum of 0
        // if attackDmg is 0, then no damage dealt
        if (attackDmg == 0){
            return attackDmg;
        } else {
            int turns = this.getNumberTurns(attackDmg);
            // turns cannot be 0 to avoid false alarm stalemates
            return attackDmg * turns;
        }
    }

    /**
     * Determines the number of turns in the fight; the number of turns is the lowest number of turns required to kill
     * either the Player or Monster.
     *
     * @param monsterAtk The damage per turn of the Monster. Value is always > 0.
     * @return The number of turns in the fight with the minimum being 1 turn.
     */
    private int getNumberTurns(int monsterAtk){
        int pHp = player.getCurrHitPoint();
        int mHp = monster.getHealth();
        int pAtk = player.getAttackPoint() + player.getEquipment("Weapon").getStatValue();

        float pHitsRequired = (float) pHp / monsterAtk; // the number hits required to kill player

        if (pAtk <= 0){ // player can never kill monster
            return Math.max(Math.round(pHitsRequired), 1); // turns determined by number of hits required to kill player
            // returns a minimum of 1 turn
        }
        float mHitsRequired = (float) mHp / pAtk; // the number hits required to kill monster

        int result = Math.round(Math.min(pHitsRequired, mHitsRequired)); // value will be equal to or greater than 0
        return Math.max(result, 1); // returns a minimum of 1 turn
    }

    /**
     *
     * @return Monster in this Calculator.
     */
    public Monster getMonster(){ // for testing purposes
        return this.monster;
    }

    /**
     *
     * @return Player in this Calculator
     */
    public Player getPlayer(){ // for testing purposes
        return this.player;
    }
}
