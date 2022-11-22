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
     * Amount of damage dealt is the attack power of the Monster subtracted by the damage reduction of the Player.
     * (This is temporary as I don't know how you guys want me to balance this).
     * If the damage reduction of the Player is greater than attack power of Monster, return 0.
     *
     * @return The amount of damage that this monster will inflict.
     */
    @Override
    public int calculate() {
        int mAtk = this.monster.getAttack();
        int pRed = this.player.getEquipment("Armor").getStatValue();
        return Math.max((mAtk - pRed), 0);
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
