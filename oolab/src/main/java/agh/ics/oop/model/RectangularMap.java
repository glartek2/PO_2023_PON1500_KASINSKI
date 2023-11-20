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
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0, 0).lowerLeft(new Vector2d(width + 1, height + 1)), new Vector2d(this.width - 1, this.height - 1).upperRight(new Vector2d(0, 0)));
    }

    @Override
    public boolean place(WorldElement worldElement, Vector2d position) throws PositionAlreadyOccupiedException {
        if (canMoveTo(position)) {
            animals.put(position, (Animal) worldElement);
            super.place(worldElement, position);
            notifyObservers(worldElement + " placed at " + position);
            return true; // Animal placed successfully
        }

        throw new PositionAlreadyOccupiedException(position);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentPosition = animal.getPosition();
        //Vector2d newPosition = animal.getCurrentPosition().add(direction.toMoveVector(animal.getOrientation()));

        animals.remove(currentPosition);
        worldElementMap.remove(currentPosition);
        animal.move(direction, position -> !isOccupied((Vector2d) position) && ((Vector2d) position).follows(new Vector2d(0, 0)) && ((Vector2d) position).precedes(new Vector2d(width - 1, height - 1)));
        animals.put(animal.getPosition(), animal);
        worldElementMap.put(animal.getPosition(), animal);
        notifyObservers(animal + " moved to " + animal.getPosition());
    }


    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && (position).follows(new Vector2d(0, 0)) && (position).precedes(new Vector2d(width - 1, height - 1));
    }
}
