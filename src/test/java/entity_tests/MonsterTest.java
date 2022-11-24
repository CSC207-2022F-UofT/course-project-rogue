//package entity_tests;
//
//import entity.monster.Monster;
//import entity.monster.Power;
//import entity.monster.Steal;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static java.util.Map.entry;
//
//class MonsterTest {
//    int[] atkStat = new int[]{1, 5};
//    int[] hpStat = new int[]{1, 5};
//    HashMap<String, int[]> stats = new HashMap<>(Map.ofEntries(
//                                                                entry("Attack", atkStat),
//                                                                entry("Health", hpStat)));
//    String[] items = new String[]{"Essence"};
//    Power power = new Steal(items);
//
//    Monster monster = new Monster("Slime", "Basic", stats, false);
//    Monster special = new Monster("Stealer", "Basic", stats, true, power);
//
//    /** Tests Monster.getName() and Monster.getType(). */
//    @Test
//    void testMonsterGetNameType() {
//        Assertions.assertAll("Should return Monster name and type",
//                () -> Assertions.assertEquals("Slime", monster.getName()),
//                () -> Assertions.assertEquals("Basic", monster.getType())
//        );
//    }
//
//    /** Tests that Monster.getStats returns a value within the range of minimum and maximum provided. */
//    @Test
//    void testMonsterGetStats(){
//        Assertions.assertAll("Should return an int within the max and min bounds.",
//                () -> Assertions.assertTrue(monster.getAttack() >= 1 && monster.getAttack() <= 5),
//                () -> Assertions.assertTrue(monster.getHealth() >= 1 && monster.getAttack() <= 5)
//        );
//    }
//
//    /** Tests Monster.isHasPower() when Monster has no power and when it does. */
//    @Test
//    void testMonsterHasPower(){
//        Assertions.assertFalse(monster.isHasPower());
//        Assertions.assertTrue(special.isHasPower());
//    }
//
//    /** Tests Monster.getPower() when Monster has a power. */
//    @Test
//    void testMonsterGetPower(){
//        Assertions.assertEquals(power, special.getPower());
//    }
//
//    /** Tests Monster.getPower() when Monster has no power. */
//    @Test
//    void testMonsterGetPowerNoPower() {
//        Assertions.assertNull(monster.getPower());}
//}
