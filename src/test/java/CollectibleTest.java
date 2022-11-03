import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleTest {

    Collectible Artifact1 = new Collectible("artifact");

    @Test
    void TestAddNum(){
        Artifact1.addNum(2);
        assertEquals(2, Artifact1.getNum());
    }

    @Test
    void TestGetName(){
        assertEquals("artifact", Artifact1.getName());
    }

    @Test
    void TestGetNum(){
        assertEquals(0, Artifact1.getNum());
        Artifact1.addNum(1);
        assertEquals(1, Artifact1.getNum());
    }

    @Test
    void TestDecreaseNum(){
        Artifact1.addNum(1);
        Artifact1.decreaseNum(1);
        assertEquals(0, Artifact1.getNum());
    }

    @Test
    void TestCheckMinusAvailable() {
        Artifact1.addNum(1);
        assertFalse(Artifact1.checkMinusAvailable(2));
        assertTrue(Artifact1.checkMinusAvailable(1));
        assertTrue(Artifact1.checkMinusAvailable(0));
    }

    @Test
    void TestSetCollectibleNum(){
        Artifact1.setCollectibleNum(5);
        assertEquals(5, Artifact1.getNum());
    }

    @Test
    void TestToString(){
        assertEquals("artifact", Artifact1.toString());
    }
}