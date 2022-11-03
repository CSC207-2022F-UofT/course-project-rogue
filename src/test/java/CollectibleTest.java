import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleTest {

    Collectible Artifact1 = new Collectible("artifact", 1);

    @Test
    void TestCheckMinusAvailable() {
        assertFalse(Artifact1.checkMinusAvailable(2));
        assertTrue(Artifact1.checkMinusAvailable(1));
        assertTrue(Artifact1.checkMinusAvailable(0));
    }

    @Test
    void TestGetName(){
        assertEquals("artifact", Artifact1.getName());
    }

    @Test
    void TestGetNum(){
        assertEquals(1, Artifact1.getNum());
    }

    @Test
    void TestAddNum(){
        Artifact1.addNum(1);
        assertEquals(2, Artifact1.getNum());
    }

    @Test
    void TestDecreaseNum(){
        Artifact1.decreaseNum(1);
        assertEquals(0, Artifact1.getNum());
    }

    @Test
    void TestToString(){
        assertEquals("artifact", Artifact1.toString());
    }
}