package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap worldMap;
    private final List<Animal> animals;
    private final List<MoveDirection> moveDirections;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, WorldMap worldMap) {
        this.moveDirections = directions;
        this.worldMap = worldMap;
        this.animals = new ArrayList<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            worldMap.place(animal);
            this.animals.add(animal);
        }
    }


    public void run() {
        int totalDirections = moveDirections.size();
        int numAnimals = animals.size();

        for (int i = 0; i < totalDirections; i++) {
            MoveDirection direction = moveDirections.get(i);
            Animal currentAnimal = animals.get(i % numAnimals);

            worldMap.move(currentAnimal, direction);
            System.out.print("Zwierze " + (i % numAnimals + 1) + ": " + currentAnimal + "\n");
            System.out.print("Stan mapy:\n" + worldMap + "\n");
        }
    }
}
