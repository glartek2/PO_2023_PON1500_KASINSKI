package agh.ics.oop;

import agh.ics.oop.model.*;
import javafx.application.Application;

import java.util.*;


public class World {

    public static void main(String[] args) throws PositionAlreadyOccupiedException {

        List<MoveDirection> directionsList = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(3, 4));

        List<Simulation> simulations = new ArrayList<>();

        for (int i=0; i<2; i++){
            RectangularMap map = new RectangularMap(5, 5, new UUID(i*6, i*4));
            GrassField grassField = new GrassField(10, new UUID(i*2, i*5));
            ConsoleMapDisplay obs1 = new ConsoleMapDisplay();
            ConsoleMapDisplay obs2 = new ConsoleMapDisplay();
            map.addObserver(obs1);
            grassField.addObserver(obs2);
            simulations.add(new Simulation(directionsList, positions, map));
            simulations.add(new Simulation(directionsList, positions, grassField));
        }





        //RectangularMap map = new RectangularMap(5, 5,  new UUID(128, 32));
        //ConsoleMapDisplay obs = new ConsoleMapDisplay();
        //map.addObserver(obs);

        //MoveDirection[] directionsArray = directionsList.toArray(new MoveDirection[0]);

        System.out.print("System wystartowal\n");

        Application.launch(SimulationApp.class, args);

        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        //simulationEngine.awaitSimulationsEnd();
        simulationEngine.runAsync();
        //simulationEngine.runSync();
        //simulationEngine.runAsyncInThreadPool();



        System.out.print("System zakonczyl dzialanie\n");


    }


    public static void run(MoveDirection[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case FORWARD ->  System.out.println("Zwierzak idzie do przodu");
                case BACKWARD ->  System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.print("Zwierzak skręca w lewo");
                case RIGHT -> System.out.print("Zwierzak skręca w prawo");
            }
            System.out.print(" \n");
        }
    }
}


