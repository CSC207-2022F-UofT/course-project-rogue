package usecase_fights;

import entity.Monster.Monster;
import entity.Player;

/** A calculator that determines the winning chance of the Player in a fight. */
public class WinCalculator extends Calculator{
    Monster monster;
    Player player;

    public WinCalculator(Monster monster, Player player){
        this.monster = monster;
        this.player = player;
    }

    /**
     * @return The percentage likelihood of the Player winning a fight against Monster, the maximum likelihood being 100
     * and the minimum being 0.
     */
    @Override
    public int calculate(){
        int mAtk = monster.getAttack() - player.getEquipment("Armor").getStatValue();
        int mHp = monster.getHealth();
        int pAtk = player.getAttackPoint() + player.getEquipment("Weapon").getStatValue();
        int pHp = player.getCurrHitPoint();

        return this.getWinChance(pHp, mHp, pAtk, mAtk);
    }

    private int getWinChance(int pHp, int mHp, int pAtk, int mAtk){
        float pHitsRequired = (float)pHp / mAtk; // the number hits required to kill player
        float mHitsRequired = (float)mHp / pAtk; // the number hits required to kill monster

        float bonus = ((pHitsRequired - mHitsRequired)* 5);
        // 5 bonus percent per every 1 hit in the difference b/w hits required

        int winChance = Math.round(50 + bonus);
        if (winChance > 100){
            return 100;
        } else if (winChance < 0) {
            return 0;
        }
        return winChance;
    }
}
