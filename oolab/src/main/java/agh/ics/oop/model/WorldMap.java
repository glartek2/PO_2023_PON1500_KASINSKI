package agh.ics.oop.model;

import java.util.List;
import java.util.UUID;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap<T, P> extends MoveValidator {

    boolean place(T object, P position) throws PositionAlreadyOccupiedException;

    //void move(T object, MoveDirection direction);

    void move(Animal animal, MoveDirection direction);

    boolean isOccupied(P position);

    Object objectAt(P position);

    UUID getMapID();

    List<WorldElement> getElements();
}