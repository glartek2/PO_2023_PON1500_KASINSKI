package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class RectangularMap implements WorldMap<Animal, Vector2d> {
    private final int width;
    private final int height;
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean place(Animal animal, Vector2d position) {

        if (isOccupied(position)) {
            return false; // Position is already occupied
        }

        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width - 1, height - 1))) {
            animals.put(position, animal);
            return true; // Animal placed successfully
        }

        return false; // Position is out of bounds
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentPosition = animal.getCurrentPosition();
        //Vector2d newPosition = animal.getCurrentPosition().add(direction.toMoveVector(animal.getOrientation()));

        animals.remove(currentPosition);
        animal.move(direction, position -> !isOccupied((Vector2d) position) && ((Vector2d) position).follows(new Vector2d(0, 0)) && ((Vector2d) position).precedes(new Vector2d(width - 1, height - 1)));
        animals.put(animal.getCurrentPosition(), animal);
    }

    @Override
    public boolean canMoveTo(Object position) {
        return !isOccupied((Vector2d) position) && ((Vector2d) position).follows(new Vector2d(0, 0)) && ((Vector2d) position).precedes(new Vector2d(width - 1, height - 1));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0).lowerLeft(new Vector2d(this.width + 1, this.height + 1)), new Vector2d(this.width - 1, this.height - 1).upperRight(new Vector2d(0, 0)));
    }

}
