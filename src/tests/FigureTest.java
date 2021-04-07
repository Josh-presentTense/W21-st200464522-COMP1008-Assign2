import models.Figure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {
    private Figure item1;

    @BeforeEach
    void setUp() {
        item1 = new Figure("Test", 2.50, "new", "figure", "ActionWorld", "Tofu", "Resident Evil", "1/6");
    }

    @Test
    void setCompanyName() {
        item1.setCompanyName("     ActionWorld     ");
        assertEquals("ActionWorld", item1.getCompanyName());
    }

    @Test
    void setCharacterName() {
        item1.setCharacterName("     Tofu     ");
        assertEquals("Tofu", item1.getCharacterName());
    }

    @Test
    void setOrigin() {
        item1.setOrigin("     Resident Evil     ");
        assertEquals("Resident Evil", item1.getOrigin());
    }

    @Test
    void setScale() {
        item1.setScale("     1/6     ");
        assertEquals("1/6", item1.getScale());
    }
}