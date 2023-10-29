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

        System.out.print("System wystartował\n");
        
        for (MoveDirection direction : directionsArray) {
            animal.move(direction);
            System.out.println("Animal position after moving: " + animal);
        }
        System.out.println("Animal position after moving left: " + animal);

        //run(directions);
        System.out.print("System zakończył działanie\n");


        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));


        // Test toString method
        for (MapDirection direction : MapDirection.values()) {
            System.out.println(direction + ": " + direction.toString());
        }

        // Test next method
        for (MapDirection direction : MapDirection.values()) {
            System.out.println(direction + " -> " + direction.next());
        }

        // Test previous method
        for (MapDirection direction : MapDirection.values()) {
            System.out.println(direction + " -> " + direction.previous());
        }

        // Test toUnitVector method
        for (MapDirection direction : MapDirection.values()) {
            System.out.println(direction + " -> " + direction.toUnitVector());
        }


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


