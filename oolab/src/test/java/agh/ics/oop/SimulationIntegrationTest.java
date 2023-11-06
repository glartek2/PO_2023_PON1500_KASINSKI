package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
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


        Simulation simulation = new Simulation(directions, positions);
        simulation.run();


        System.setOut(System.out);


        String printedOutput = outputStream.toString();


        String[] lines = printedOutput.split("\n");


        assertEquals(lines[0], "Zwierze 1: (2,3) Polnoc");
        assertEquals(lines[1], "Zwierze 2: (3,3) Polnoc");


        assertEquals(lines[2], "Zwierze 1: (2,3) Wschod");
        assertEquals(lines[3], "Zwierze 2: (3,3) Zachod");


        assertEquals(lines[4], "Zwierze 1: (3,3) Wschod");
        assertEquals(lines[5], "Zwierze 2: (2,3) Zachod");

        outputStream.reset();
    }
}