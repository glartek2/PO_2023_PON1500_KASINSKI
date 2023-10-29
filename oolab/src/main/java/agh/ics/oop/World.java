package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;
import java.util.Scanner;


public class World {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter arguments separated by spaces (press Enter to finish): ");
        //String input = scanner.nextLine();

        //String[] arguments = input.split(" ");

        Animal animal = new Animal();
        System.out.println("Animal position and orientation: " + animal);

        List<MoveDirection> directionsList = OptionsParser.parse(args);
        MoveDirection[] directionsArray = directionsList.toArray(new MoveDirection[0]);

        System.out.print("System wystartowal\n");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(directions, positions);
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


