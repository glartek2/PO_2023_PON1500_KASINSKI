package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulation {
    private final GrassField grassField;
    private final List<Animal> animals;
    private final List<MoveDirection> moveDirections;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, GrassField grassField) {
        this.grassField = grassField;
        this.moveDirections = directions;
        this.animals = new ArrayList<>();

        Set<Vector2d> set = new HashSet<Vector2d>();
        for (Vector2d position : positions) {
            set.add(position);
        }
        for (Vector2d position : set){
            Animal animal = new Animal(position);
            grassField.place(animal, position);
            this.animals.add(animal);
        }
    }

    public void run() {
        System.out.print("Stan mapy:\n" + grassField + "\n");
        int totalDirections = moveDirections.size();
        int numAnimals = animals.size();

        for (int i = 0; i < totalDirections; i++) {
            MoveDirection direction = moveDirections.get(i);
            Animal currentAnimal = animals.get(i % numAnimals);

            grassField.move(currentAnimal, direction);
            System.out.print("Zwierze " + (i % numAnimals + 1) + ": " + currentAnimal + "\n");
            System.out.print("Stan mapy:\n" + grassField + "\n");
        }
    }
}
