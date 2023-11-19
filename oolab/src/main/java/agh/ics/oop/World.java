package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class World {

    public static void main(String[] args) throws PositionAlreadyOccupiedException {

        Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter arguments separated by spaces (press Enter to finish): ");
        //String input = scanner.nextLine();

        //String[] arguments = input.split(" ");

        RectangularMap map = new RectangularMap(5, 5);
        ConsoleMapDisplay obs = new ConsoleMapDisplay();
        map.addObserver(obs);

        List<MoveDirection> directionsList = OptionsParser.parse(args);
        //MoveDirection[] directionsArray = directionsList.toArray(new MoveDirection[0]);

        System.out.print("System wystartowal\n");

        //List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(3, 4));
        Simulation simulation = new Simulation(directionsList, positions, map);
        simulation.run();

        GrassField grassField = new GrassField(10);
        grassField.addObserver(obs);
        System.out.println(grassField);

        Simulation simulation2 = new Simulation(directionsList, positions, grassField);
        simulation2.run();

        //for (MoveDirection direction : directionsArray) {
            //animal.move(direction);
            //System.out.println("Animal position after moving: " + animal);
        //}
        //System.out.println("Animal position after moving left: " + animal);

        //run(directions);
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


