package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Scanner;


public class World {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter arguments separated by spaces (press Enter to finish): ");
        String input = scanner.nextLine();

        String[] arguments = input.split(" ");

        System.out.print("System wystartował\n");
        MoveDirection[] directions = OptionsParser.parse(arguments);
        run(directions);
        System.out.print("System zakończył działanie\n");
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


