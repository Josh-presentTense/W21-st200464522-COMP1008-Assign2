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
    private UserCollection collection;

    @BeforeEach
    void setUp() {
        item1 = new PrintMedia("Test Book", 2.50, "new", "comic", "Bob C.", "Andrew A.", "Rad Books", 22);
        item2 = new VideoMedia("Test Show", 10.50, "new", "cartoon", "Kyle", "Lightbox", 10, 200);
        item3 = new Figure("Test Figure", 150.00, "new", "figure", "ActionWorld", "Tofu", "Resident Evil", "1/6");
        collection = new UserCollection(item1);
        collection = new UserCollection(item2);
        collection = new UserCollection(item3);
    }

    @Test
    void getNumOfItems() {
        assertEquals(3, UserCollection.getNumOfItems());
    }

    @Test
    void getTotalPrice() {
        assertEquals(162, UserCollection.getTotalPrice());
    }

    @Test
    void collectionPrintMedia() {
        assertEquals(item1, collection.collectionPrintMedia());
    }

    @Test
    void collectionVideoMedia() {
        assertEquals(item2, collection.collectionPrintMedia());
    }

    @Test
    void collectionFigure() {
        assertEquals(item3, collection.collectionPrintMedia());
    }
}