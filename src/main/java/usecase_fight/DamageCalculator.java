package usecase_fight;

import entity.player.Player;
import entity.monster.Monster;

/** A calculator that determines Monster damage to Player. */
public class DamageCalculator extends Calculator {
    Monster monster;
    Player player;

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
        int pRed = this.player.getArmor().getStatValue();
        return Math.max((mAtk - pRed), 0);
    }
}
