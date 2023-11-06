package agh.ics.oop;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OptionsParserTest {
    @Test
    public void testParse() {
        // Given
        String[] args = {"f", "b", "l", "r", "x", "y", "z"};
        List<MoveDirection> expectedDirections = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT
        );

        // When
        List<MoveDirection> parsedDirections = OptionsParser.parse(args);

        // Then
        Assert.assertEquals(expectedDirections, parsedDirections);
    }
}
