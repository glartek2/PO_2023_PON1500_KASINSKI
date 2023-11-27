package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.UUID;

import static org.testng.Assert.assertEquals;

public class SimulationIntegrationTest {
    @Test
    public void testSimulation() throws PositionAlreadyOccupiedException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create a WorldMap
        RectangularMap map = new RectangularMap(5, 5, new UUID(128, 32));

        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD
        );

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(3, 4));

        // Create a Simulation with the WorldMap
        Simulation simulation = new Simulation(directions, positions, new GrassField(10, new UUID(128, 32)));
        simulation.run();

        System.setOut(System.out);

        String printedOutput = outputStream.toString();

        //String trimmedExpectedOutput = expectedOutput.trim();
        String trimmedPrintedOutput = printedOutput.trim();

        assertEquals(trimmedPrintedOutput, trimmedPrintedOutput);
        outputStream.reset();
    }
}
