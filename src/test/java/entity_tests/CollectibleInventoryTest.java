package entity_tests;
import entity.item.Collectible;
import entity.inventory_slots.CollectibleInventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectibleInventoryTest {
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 1);
    CollectibleInventory inventory;

    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    }

    @Test
    @DisplayName("Test Get Collectible Type")
    void testGetCollectible(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(essence, inventory.getEssence()),
                () -> Assertions.assertEquals(artifact, inventory.getArtifact())
        );
    }

    @Test
    @DisplayName("Test to add amount to Essence and Artifact")
    void testAddAmount(){

        Assertions.assertAll(
                () -> inventory.changeEssenceAmount(20),
                () -> Assertions.assertEquals(120, inventory.getEssence().getNum()),
                () -> inventory.changeArtifactAmount(1),
                () -> Assertions.assertEquals(2, inventory.getArtifact().getNum())
        );
    }

    @Test
    @DisplayName("Test to subtract amount to Essence and Artifact")
    void testSubtractAmount(){
        Assertions.assertAll(
                () -> inventory.changeEssenceAmount(-30),
                () -> Assertions.assertEquals(70, inventory.getEssence().getNum()),
                () -> inventory.changeArtifactAmount(-1),
                () -> Assertions.assertEquals(0, inventory.getArtifact().getNum())
        );
    }

}
