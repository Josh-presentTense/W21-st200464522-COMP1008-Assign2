import models.VideoMedia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoMediaTest {
    private VideoMedia item1;

    @BeforeEach
    void setUp() {
        item1 = new VideoMedia("Test", 2.50, "new", "cartoon", "Kyle", "Lightbox", 10, 200);
    }

    @Test
    void setDirector() {
        item1.setDirector("     Kyle     ");
        assertEquals("Kyle", item1.getDirector());
    }

    @Test
    void setStudio() {
        item1.setStudio("     Lightbox     ");
        assertEquals("Lightbox", item1.getStudio());
    }

    @Test
    void setEpisodes() {
        assertEquals(10, item1.getEpisodes());
    }

    @Test
    void setRunTime() {
        assertEquals(200, item1.getRunTime());
    }
}