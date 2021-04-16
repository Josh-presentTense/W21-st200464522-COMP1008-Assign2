import models.CollectibleCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleCollectionTest {
    private CollectibleCollection item1;

    @BeforeEach
    void setUp() {
        item1 = new CollectibleCollection("test", 15, "new", "manga");
    }

    @Test
    void setItemName() {
        item1.setItemName("      test      ");
        assertEquals("test", item1.getItemName());
    }

    @Test
    void setPrice() {
        assertEquals(15, item1.getPrice());
    }

    @Test
    void setItemCondition() {
        item1.setItemCondition("     new     ");
        assertEquals("new", item1.getItemCondition());
    }

    @Test
    void setCollectibleCategory() {
        item1.setCollectibleCategory("   manga");
        assertEquals("manga", item1.getCollectibleCategory());
    }
}