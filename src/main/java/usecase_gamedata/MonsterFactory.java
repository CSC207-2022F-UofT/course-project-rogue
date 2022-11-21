package usecase_gamedata;

import entity.monster.Monster;
import entity.monster.Power;

import java.util.HashMap;

public class MonsterFactory {
    public Monster getMonster(String n, String t, HashMap<String, int[]> stats, boolean state){
        return new Monster(n, t, stats, state);
    }

    public Monster getMonster(String n, String t, HashMap<String, int[]> stats, boolean state, Power pwr){
        return new Monster(n, t, stats, state, pwr);
    }
}
