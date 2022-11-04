import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleTest {

    Collectible Artifact1 = new Collectible("artifact");

    @Test
    void TestChangeNum(){
        Artifact1.changeNum(2);
        assertEquals(2, Artifact1.getNum());
    }

    @Test
    void TestGetName(){
        assertEquals("artifact", Artifact1.getName());
    }

    @Test
    void TestGetNum(){
        assertEquals(0, Artifact1.getNum());
        Artifact1.changeNum(1);
        assertEquals(1, Artifact1.getNum());
    }

    @Test
    void TestCheckMinusAvailable() {
        Artifact1.changeNum(1);
        assertFalse(Artifact1.checkMinusAvailable(2));
        assertTrue(Artifact1.checkMinusAvailable(1));
        assertTrue(Artifact1.checkMinusAvailable(0));
    }

    @Test
    void TestSetCollectibleNum(){
        Artifact1.setCollectibleNum(5);
        assertEquals(5, Artifact1.getNum());
        Artifact1.setCollectibleNum(3);
        assertEquals(3, Artifact1.getNum());
    }

    @Test
    void TestToString(){
        assertEquals("artifact", Artifact1.toString());
    }
}