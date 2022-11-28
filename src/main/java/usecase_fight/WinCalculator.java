package usecase_fight;

import entity.Monster.Monster;
import entity.Player;

/** A calculator that determines the winning chance of the Player in a fight. */
public class WinCalculator extends Calculator{
    private final Monster monster;
    private final Player player;

    public WinCalculator(Monster monster, Player player){
        this.monster = monster;
        this.player = player;
    }

    /**
     *
     * @return The Monster of this WinCalculator
     */
    public Monster getMonster(){
        return this.monster;
    }

    /**
     *
     * @return The Player of this WinCalculator
     */
    public Player getPlayer(){
        return this.player;
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
        if (pAtk == 0 && mAtk == 0){
            return 0; // if in stalemate, no chance in winning
        } else{
            return this.getWinChance(pHp, mHp, pAtk, mAtk);
        }
    }

    /**
     * Determines the chance of a Player winning the fight, with maximum chance being 100 percent and minimum being zero
     * percent. Win chance is determined by the number of hits required to kill Player vs. Monster.
     *
     * @param pHp Player hp.
     * @param mHp Monster hp
     * @param pAtk Player attack
     * @param mAtk Monster attack
     * @return Win chance, in percent.
     */
    private int getWinChance(int pHp, int mHp, int pAtk, int mAtk){
        // based on condition in calculate, we know mAtk and pAtk are not both zero
        if (mAtk <= 0){ // the monster can never kill the player
            return 100;
        } else if (pAtk <= 0) { // the player can never kill the monster
            return 0;
        }

        // we know that both mAtk and pAtk are positive integers
        // the equations below will be defined
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
