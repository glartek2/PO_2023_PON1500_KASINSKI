package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean place(WorldElement worldElement, Vector2d position) {
        if (canMoveTo(position)) {
            animals.put(position, (Animal) worldElement);
            return true; // Animal placed successfully
        }

        return false; // Position is out of bounds
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentPosition = animal.getPosition();
        //Vector2d newPosition = animal.getCurrentPosition().add(direction.toMoveVector(animal.getOrientation()));

        animals.remove(currentPosition);
        animal.move(direction, position -> !isOccupied((Vector2d) position) && ((Vector2d) position).follows(new Vector2d(0, 0)) && ((Vector2d) position).precedes(new Vector2d(width - 1, height - 1)));
        animals.put(animal.getPosition(), animal);
    }


    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0).lowerLeft(new Vector2d(this.width + 1, this.height + 1)), new Vector2d(this.width - 1, this.height - 1).upperRight(new Vector2d(0, 0)));
    }

    @Override
    public boolean canMoveTo(Object position) {
        return !isOccupied((Vector2d) position) && ((Vector2d) position).follows(new Vector2d(0, 0)) && ((Vector2d) position).precedes(new Vector2d(width - 1, height - 1));
    }
}
