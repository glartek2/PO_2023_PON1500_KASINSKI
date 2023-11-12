package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class World {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter arguments separated by spaces (press Enter to finish): ");
        //String input = scanner.nextLine();

        //String[] arguments = input.split(" ");

        RectangularMap map = new RectangularMap(5, 5);

        List<MoveDirection> directionsList = OptionsParser.parse(args);
        MoveDirection[] directionsArray = directionsList.toArray(new MoveDirection[0]);

        System.out.print("System wystartowal\n");

        //List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(0, 1));
        //Simulation simulation = new Simulation(directions, positions, map);
        //simulation.run();

        GrassField grassField = new GrassField(1);
        System.out.println(grassField);

        Simulation simulation = new Simulation(Arrays.asList(
                MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.BACKWARD, MoveDirection.LEFT
        ), positions, grassField);
        simulation.run();

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


