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
        MoveDirection directions = OptionsParser.parse(arguments);
        run(arguments);
        System.out.print("System zakończył działanie\n");
    }


    public static void run(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f" ->  System.out.println("Zwierzak idzie do przodu");
                case "b" ->  System.out.println("Zwierzak idzie do tyłu");
                case "l" -> System.out.print("Zwierzak skręca w lewo");
                case "r" -> System.out.print("Zwierzak skręca w prawo");
            }
            System.out.print(" \n");
        }
    }
}


