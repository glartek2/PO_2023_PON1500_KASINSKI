package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        String direction = "a";
        System.out.print("System wystartował\n");
        run(direction);
        System.out.print("System zakończył działanie");
    }


    public static void run(String direction) {
        System.out.print("Zwierzak idzie do przodu\n");
    }
}
