import models.PrintMedia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintMediaTest {
    private PrintMedia item1;

    @BeforeEach
    void setUp() {
        item1 = new PrintMedia("Test", 2, "new", "comic", "Bob C.", "Andrew A.", "Rad Books", 22);
    }

    @Test
    void setAuthor() {
        item1.setAuthor("    Bob C.    ");
        assertEquals("Bob C.", item1.getAuthor());
    }

    @Test
    void setIllustrator() {
        item1.setIllustrator("    Andrew A.    ");
        assertEquals("Andrew A.", item1.getIllustrator());
    }

    @Test
    void setPublisher() {
        item1.setPublisher("    Rad Books    ");
        assertEquals("Rad Books", item1.getPublisher());
    }

    @Test
    void setPageCount() {
        assertEquals(22, item1.getPageCount());
    }
}