package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void testParse() {
        // Given
        String[] args = {"f", "b", "l", "r", "x", "y", "z"};
        MoveDirection[] expectedDirections = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                null, // Unknown value should result in null
                null,
                null
        };

        // When
        MoveDirection[] parsedDirections = OptionsParser.parse(args);

        // Then
        assertArrayEquals(expectedDirections, parsedDirections);
    }
}
