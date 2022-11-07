package entity_tests;

import entity.Collectible;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleTest {

    Collectible Artifact1 = new Collectible("artifact");

    @Test
    void TestChangeNum(){
        Artifact1.changeNum(2);
        Assertions.assertEquals(2, Artifact1.getNum());
    }

    @Test
    void TestGetName(){
        Assertions.assertEquals("artifact", Artifact1.getName());
    }

    @Test
    void TestGetNum(){
        Assertions.assertEquals(0, Artifact1.getNum());
        Artifact1.changeNum(1);
        Assertions.assertEquals(1, Artifact1.getNum());
    }

    @Test
    void TestSetCollectibleNum(){
        Artifact1.setCollectibleNum(5);
        Assertions.assertEquals(5, Artifact1.getNum());
        Artifact1.setCollectibleNum(3);
        Assertions.assertEquals(3, Artifact1.getNum());
    }

    @Test
    void TestToString(){
        Assertions.assertEquals("artifact", Artifact1.toString());
    }
}