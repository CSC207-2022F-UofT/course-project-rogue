package entity_tests;
import entity.player.States;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatesTest {
    States states;

    @BeforeEach
    void setUp(){
        states = new States();
    }

    @Test
    @DisplayName("Test for get can Move")
    void testGetCanMove(){
        Assertions.assertTrue(states.getCanMove());
    }
    @Test
    @DisplayName("Test for get can Heal")
    void testGetCanHeal(){
        Assertions.assertFalse(states.getCanHeal());
    }

    @Test
    @DisplayName("Test for get can upgrade")
    void testGetCanUpgrade(){
        Assertions.assertFalse(states.getCanUpgrade());
    }

    @Test
    @DisplayName("Test for get is Fighting")
    void testGetFighting(){
        Assertions.assertFalse(states.getFighting());
    }
    @Test
    @DisplayName("Test for get is Upgrading")
    void testGetUpgrading(){
        Assertions.assertFalse(states.getUpgrading());
    }

    @Test
    @DisplayName("Test for get GameOver")
    void testGetGameOver() {Assertions.assertFalse(states.getGameOver());}

    @Test
    @DisplayName("Test for set can Move")
    void testSetCanMove(){
        states.setCanMove(false);
        Assertions.assertFalse(states.getCanMove());
        states.setCanMove(true);
        Assertions.assertTrue(states.getCanMove());
    }
    @Test
    @DisplayName("Test for set can Heal")
    void testSetCanHeal(){
        states.setCanHeal(true);
        Assertions.assertTrue(states.getCanHeal());
        states.setCanHeal(false);
        Assertions.assertFalse(states.getCanHeal());
    }


    @Test
    @DisplayName("Test for set can upgrade")
    void testSetCanUpgrade(){
        states.setCanUpgrade(false);
        Assertions.assertFalse(states.getCanUpgrade());
        states.setCanUpgrade(true);
        Assertions.assertTrue(states.getCanUpgrade());
    }

    @Test
    @DisplayName("Test for set is Fighting")
    void testSetFighting(){
        states.setFighting(true);
        Assertions.assertTrue(states.getFighting());
        states.setFighting(false);
        Assertions.assertFalse(states.getFighting());
    }
    @Test
    @DisplayName("Test for set is upgrading")
    void testSetUpgrading(){
        states.setUpgrading(true);
        Assertions.assertTrue(states.getUpgrading());
        states.setUpgrading(false);
        Assertions.assertFalse(states.getUpgrading());
    }

    @Test
    @DisplayName("Test for set GameOver")
    void testSetGameOver(){
        states.setGameOver();
        Assertions.assertTrue(states.getGameOver());
    }
}
