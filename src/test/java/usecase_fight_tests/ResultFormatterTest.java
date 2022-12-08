package usecase_fight_tests;

import entity.item.Armor;
import entity.item.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_fight.ResultFormatter;


public class ResultFormatterTest {

    ResultFormatter rf;
    Weapon weapon;
    Armor armor;

    @BeforeEach
    @DisplayName("Setup method arguments.")
    void setUp(){
        rf = new ResultFormatter();
        weapon = new Weapon("Sharp Stick", 5);
        armor = new Armor("Paper Bag", 1);
    }

    @Test
    @DisplayName("Test formatTie")
    void testFormatTie(){
        String[] result = rf.formatTie();
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("A Draw!", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 0", result[1]),
                () -> Assertions.assertEquals("Items Received: None", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatLoss")
    void testFormatLoss() {
        String[] result = rf.formatLoss("Nothing was stolen!", 10);
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("You lost. Nothing was stolen!", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 10", result[1]),
                () -> Assertions.assertEquals("Items Received: None", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatWin when Armor is exchanged.")
    void testFormatWinExchangeArmor() {
        String[] result = rf.formatWin("", 5, true, armor);
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("You won! ", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 0", result[1]),
                () -> Assertions.assertEquals("Items Received: 5 essence, Paper Bag", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatWin when Weapon is exchanged.")
    void testFormatWinExchangeWeapon() {
        String[] result = rf.formatWin("", 5, true, weapon);
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("You won! ", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 0", result[1]),
                () -> Assertions.assertEquals("Items Received: 5 essence, Sharp Stick", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatWin when no equipment exchanged.")
    void testFormatWinExchangeFalse() {
        String[] result = rf.formatWin("", 5, false, weapon);
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("You won! ", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 0", result[1]),
                () -> Assertions.assertEquals("Items Received: 5 essence", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatWin when no equipment dropped.")
    void testFormatWinNoEquip() {
        String[] result = rf.formatWin("", 5, false, null);
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("You won! ", result[0]),
                () -> Assertions.assertEquals("Damage Taken: 0", result[1]),
                () -> Assertions.assertEquals("Items Received: 5 essence", result[2]),
                () -> Assertions.assertEquals("Press [C] to continue.", result[3]));
    }

    @Test
    @DisplayName("Test formatGameOver.")
    void testFormatGameOver() {
        String[] result = rf.formatGameOver();
        Assertions.assertAll("Check that all strings match",
                () -> Assertions.assertEquals("GameOver.", result[0]),
                () -> Assertions.assertEquals("", result[1]),
                () -> Assertions.assertEquals("", result[2]),
                () -> Assertions.assertEquals("Press [C] to return to main menu.", result[3]));
    }
}
