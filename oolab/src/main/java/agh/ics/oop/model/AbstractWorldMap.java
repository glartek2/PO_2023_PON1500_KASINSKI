package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap <WorldElement, Vector2d> {
    protected final Map<Vector2d, WorldElement> worldElementMap = new HashMap<>();

    private List<MapChangeListener> observers = new ArrayList<>();
    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }
    public abstract Boundary getCurrentBounds();

    public boolean place(WorldElement worldElement, Vector2d position) throws PositionAlreadyOccupiedException {

        if (!canMoveTo(position)){
            throw new PositionAlreadyOccupiedException(position);
        }

        worldElementMap.put(position, worldElement);
        notifyObservers(worldElement + " placed at " + position);
        return true; // Animal placed successfully
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentPosition = animal.getPosition();
        //Vector2d newPosition = currentPosition.add(direction.toMoveVector(animal.getOrientation()));

        worldElementMap.remove(currentPosition);
        animal.move(direction, position -> !isOccupied((Vector2d) position));
        worldElementMap.put(animal.getPosition(), animal);
        notifyObservers(animal + " moved to " + animal.getPosition());
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = worldElementMap.get(position);
        return obj == null || obj.getClass() != Animal.class;
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
        Boundary bounds = getCurrentBounds();
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(bounds.lowerLeft(), bounds.upperRight());
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
