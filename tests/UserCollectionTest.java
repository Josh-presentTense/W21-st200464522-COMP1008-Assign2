import models.Figure;
import models.PrintMedia;
import models.UserCollection;
import models.VideoMedia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCollectionTest {
    private PrintMedia item1;
    private VideoMedia item2;
    private Figure item3;
    private UserCollection collection = new UserCollection();

    @BeforeEach
    void setUp() {
        item1 = new PrintMedia("Test Book", 2.50, "new", "comic", "Bob C.", "Andrew A.", "Rad Books", 22);
        item2 = new VideoMedia("Test Show", 10.50, "new", "cartoon", "Kyle", "Lightbox", 10, 200);
        item3 = new Figure("Test Figure", 150.00, "new", "figure", "ActionWorld", "Tofu", "Resident Evil", "1/6");
        collection.addCollectable(item1);
        collection.addCollectable(item2);
        collection.addCollectable(item3);
    }

    @Test
    void getNumOfItems() {
        assertEquals(3, collection.getNumOfItems());
    }

    @Test
    void getTotalPrice() {
        assertEquals(162, collection.getTotalPrice());
    }

    @Test
    void getPrintMediaCollection() {
        assertEquals(item1, collection.getPrintMediaCollection());
    }

    @Test
    void getVideoMediaCollection() {
        assertEquals(item2, collection.getVideoMediaCollection());
    }

    @Test
    void getFigureCollection() {
        assertEquals(item3, collection.getFigureCollection());
    }
}