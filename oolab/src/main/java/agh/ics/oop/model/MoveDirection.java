package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
public enum MoveDirection {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;

    public Vector2d toMoveVector(MapDirection orientation) {
        switch (this) {
            case FORWARD:
                return orientation.toUnitVector();
            case BACKWARD:
                return orientation.toUnitVector().opposite();
            case LEFT:
                return orientation.previous().toUnitVector();
            case RIGHT:
                return orientation.next().toUnitVector();
            default:
                return new Vector2d(0, 0); // Handle the default case (optional)
        }
    }
}
