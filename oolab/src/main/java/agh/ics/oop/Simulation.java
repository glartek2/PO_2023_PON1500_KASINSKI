package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moveDirections;
    private int currentDirectionIndex;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions) {
        this.moveDirections = directions;
        this.currentDirectionIndex = 0;
        this.animals = new ArrayList<>();

        for (Vector2d position : positions) {
            this.animals.add(new Animal(position));
        }
    }


    public void run() {
        int totalDirections = moveDirections.size();
        int numAnimals = animals.size();

        for (int i = 0; i < totalDirections; i++) {
            MoveDirection direction = moveDirections.get(i);
            Animal currentAnimal = animals.get(i % numAnimals);

            currentAnimal.move(direction);
            System.out.print("Zwierze " + (i % numAnimals + 1) + ": " + currentAnimal + "\n");
        }
    }
}
