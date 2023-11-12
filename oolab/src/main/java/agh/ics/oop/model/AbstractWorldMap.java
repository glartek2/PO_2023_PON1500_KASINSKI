package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap <WorldElement, Vector2d> {
    protected final Map<Vector2d, WorldElement> worldElementMap = new HashMap<>();

    public boolean place(WorldElement worldElement, Vector2d position) {

        if (!canMoveTo(position)){
            return false;
        }

        worldElementMap.put(position, worldElement);
        return true; // Animal placed successfully
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentPosition = animal.getPosition();
        //Vector2d newPosition = currentPosition.add(direction.toMoveVector(animal.getOrientation()));

        worldElementMap.remove(currentPosition);
        animal.move(direction, position -> !isOccupied((Vector2d) position));
        worldElementMap.put(animal.getPosition(), animal);
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        //Object obj = worldElementMap.get(position);
        //return obj != null && obj.getClass() == Animal.class;
        return worldElementMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return worldElementMap.get(position);
    }

    public List<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(worldElementMap.values());
        return elements;
    }

    protected Vector2d getLowerLeft() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Vector2d position : worldElementMap.keySet()) {
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }

        return new Vector2d(minX, minY);
    }

    protected Vector2d getUpperRight() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Vector2d position : worldElementMap.keySet()) {
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        return new Vector2d(maxX, maxY);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(getLowerLeft(), getUpperRight());
    }

    private String draw(Vector2d lowerLeft, Vector2d upperRight) {
        StringBuilder builder = new StringBuilder();
        for (int y = upperRight.getY(); y >= lowerLeft.getY(); y--) {
            for (int x = lowerLeft.getX(); x <= upperRight.getX(); x++) {
                Vector2d position = new Vector2d(x, y);
                WorldElement element = objectAt(position);
                if (element != null) {
                    builder.append(element.toString());
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
