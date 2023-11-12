package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextMapTest {

    @Test
    public void testPlaceAndMove() {
        TextMap textMap = new TextMap();

        assertTrue(textMap.place("Ala", 0));
        assertTrue(textMap.place("ma", 1));
        assertTrue(textMap.place("sowoniedzwiedzia", 2));

        assertEquals("Ala", textMap.objectAt(0));
        assertEquals("ma", textMap.objectAt(1));
        assertEquals("sowoniedzwiedzia", textMap.objectAt(2));

        textMap.move("ma", MoveDirection.FORWARD);
        assertEquals("Ala", textMap.objectAt(0));
        assertEquals("sowoniedzwiedzia", textMap.objectAt(1));
        assertEquals("ma", textMap.objectAt(2));

        textMap.move("ma", MoveDirection.BACKWARD);
        assertEquals("Ala", textMap.objectAt(0));
        assertEquals("ma", textMap.objectAt(1));
        assertEquals("sowoniedzwiedzia", textMap.objectAt(2));

        textMap.move("ma", MoveDirection.BACKWARD);
        assertEquals("ma", textMap.objectAt(0));
        assertEquals("Ala", textMap.objectAt(1));
        assertEquals("sowoniedzwiedzia", textMap.objectAt(2));

        textMap.move("ma", MoveDirection.BACKWARD);
        assertEquals("ma", textMap.objectAt(0));
        assertEquals("Ala", textMap.objectAt(1));
        assertEquals("sowoniedzwiedzia", textMap.objectAt(2));
    }

}

