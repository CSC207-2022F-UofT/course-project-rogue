package entity_tests;

import entity.Collectible;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollectibleTest {

    Collectible Artifact1 = new Collectible("artifact");

    @Test
    
    void testChangeNumIncrease(){
        Artifact1.changeNum(2);
        Assertions.assertEquals(2, Artifact1.getNum());
    }

    @Test
    void testChangeNumDecrease(){
        Artifact1.changeNum(4);
        Artifact1.changeNum(-4);
        Assertions.assertEquals(0, Artifact1.getNum());
    }

    @Test
    void testGetName(){
        Assertions.assertEquals("artifact", Artifact1.getName());
    }

    @Test
    void testGetNum(){
        Assertions.assertEquals(0, Artifact1.getNum());
        Artifact1.changeNum(1);
        Assertions.assertEquals(1, Artifact1.getNum());
    }

    @Test
    void testSetCollectibleNum(){
        Artifact1.setNum(5);
        Assertions.assertEquals(5, Artifact1.getNum());
        Artifact1.setNum(3);
        Assertions.assertEquals(3, Artifact1.getNum());
    }

    @Test
    void testToString(){
        Assertions.assertEquals("artifact", Artifact1.toString());
    }
}