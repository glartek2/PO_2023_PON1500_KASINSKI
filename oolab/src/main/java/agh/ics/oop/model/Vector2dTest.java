package agh.ics.oop.model;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(3, 4);

        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
    }

    @Test
    public void testToString() {
        Vector2d vector = new Vector2d(1, 2);
        assertEquals(vector.toString(), "(1,2)");
    }

    @Test
    public void testPrecedes() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        assertTrue(vector1.precedes(vector2));
        assertFalse(vector2.precedes(vector1));
    }

    @Test
    public void testFollows() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        assertTrue(vector2.follows(vector1));
        assertFalse(vector1.follows(vector2));
    }

    @Test
    public void testUpperRight() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        Vector2d result = vector1.upperRight(vector2);
        assertEquals(result, new Vector2d(3, 4));
    }

    @Test
    public void testLowerLeft() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        Vector2d result = vector1.lowerLeft(vector2);
        assertEquals(result, new Vector2d(1, 2));
    }

    @Test
    public void testAdd() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        Vector2d result = vector1.add(vector2);
        assertEquals(result, new Vector2d(4, 6));
    }

    @Test
    public void testSubtract() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(3, 4);

        Vector2d result = vector1.subtract(vector2);
        assertEquals(result, new Vector2d(-2, -2));
    }

    @Test
    public void testOpposite() {
        Vector2d vector = new Vector2d(1, 2);

        Vector2d result = vector.opposite();
        assertEquals(result, new Vector2d(-1, -2));
    }
}
