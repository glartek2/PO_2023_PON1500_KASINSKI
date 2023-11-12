package agh.ics.oop.model;

import java.util.List;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap<T, P> extends MoveValidator {

    boolean place(T object, P position);

    //void move(T object, MoveDirection direction);

    boolean canMoveTo(Object position);

    void move(Animal animal, MoveDirection direction);

    boolean isOccupied(P position);

    Object objectAt(P position);

    List<WorldElement> getElements();
}