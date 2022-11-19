package usecase_fights;

import entity.Monster.Monster;
import entity.Player;

/** A calculator that determines the winning chance of the Player in a fight. */
public class WinChance implements Calculated{
    Monster monster;
    Player player;

    public WinChance(Monster monster, Player player){
        this.monster = monster;
        this.player = player;
    }

    /**
     * The maximum win chance a Player can have is 100%.
     * @return
     */
    @Override
    public int calculate(){
        int mAtk = monster.getAttack() - player.getEquipment("Armor").getStatValue();
        int mHp = monster.getHealth();
        int pAtk = player.getAttackPoint();
        int pHp = player.getCurrHitPoint();

        // compare power difference. character with stronger attack (damage reduction should have a 5% win increase)
        // compare health, character with high health has increased survival chance (increase by 5 or lose by 5)
        // if monster hp: 10 and player hp = 15. then 15/10 = 1.5 multiplier
        // compare monster attack to player hp, if monster attack = higher than hp, lower the chance of winning
        //
        // compare player attack to monster hp, if player attack = higher than hp, higher chance of winning
        return 0;
    }
}
