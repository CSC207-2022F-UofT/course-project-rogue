package usecase_fights;

import entity.Monster.Monster;
import entity.Player;

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
     * (This is temporary as I don't know how you guys want me to balance this)
     *
     * @return The amount of damage that this monster will inflict.
     */
    @Override
    public int calculate() { // should I make the interface a calculator????
        int mAtk = this.monster.getAttack();
        int pRed = this.player.getEquipment("Armor").getStatValue();
        // what happens when damage reduction is somehow greater than monster attack?
        return (mAtk - pRed);
    }
}
