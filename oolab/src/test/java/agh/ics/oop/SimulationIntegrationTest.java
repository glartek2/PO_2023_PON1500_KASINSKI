package agh.ics.oop;

import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SimulationIntegrationTest {
    @Test
    public void testSimulation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create a WorldMap
        RectangularMap map = new RectangularMap(5, 5);

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

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        // Create a Simulation with the WorldMap
        Simulation simulation = new Simulation(directions, positions, new GrassField(10));
        simulation.run();

        System.setOut(System.out);

        String printedOutput = outputStream.toString();

        String expectedOutput = "Zwierze 1: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | |N| | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |N|N| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: E\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |E|N| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: W\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |E|W| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: E\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |E|W| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: W\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |E|W| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: S\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |S|W| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | |S|N| |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: S\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | | | |\n" +
                "  3: | | | |N| |\n" +
                "  2: | | |S| | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | |S| | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: S\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | |S| | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | |S| | |\n" +
                "  0: | | | | | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: S\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | |S| | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | |S| | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 1: S\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | |S| | |\n" +
                " -1: -----------\n" +
                "\n" +
                "Zwierze 2: N\n" +
                "Stan mapy:\n" +
                " y\\x  0 1 2 3 4\n" +
                "  5: -----------\n" +
                "  4: | | | |N| |\n" +
                "  3: | | | | | |\n" +
                "  2: | | | | | |\n" +
                "  1: | | | | | |\n" +
                "  0: | | |S| | |\n" +
                " -1: -----------\n";

        String trimmedExpectedOutput = expectedOutput.trim();
        String trimmedPrintedOutput = printedOutput.trim();

        assertEquals(trimmedExpectedOutput, trimmedPrintedOutput);
        outputStream.reset();
    }
}
