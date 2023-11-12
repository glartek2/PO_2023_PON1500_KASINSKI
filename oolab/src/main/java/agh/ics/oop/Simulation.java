package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulation {
    private WorldMap worldMap;
    private final List<Animal> animals;
    private final List<MoveDirection> moveDirections;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, WorldMap worldMap) {
        this.worldMap = worldMap;
        this.moveDirections = directions;
        this.animals = new ArrayList<>();

        Set<Vector2d> set = new HashSet<Vector2d>();
        for (Vector2d position : positions) {
            set.add(position);
        }
        for (Vector2d position : set){
            Animal animal = new Animal(position);
            worldMap.place(animal, position);
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
