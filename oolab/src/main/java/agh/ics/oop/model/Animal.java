package agh.ics.oop.model;

public class Animal implements WorldElement {

    private MapDirection orientation;
    private Vector2d currentPosition;

    @Override
    public Vector2d getPosition() {
        return currentPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Animal() {
        this.currentPosition = new Vector2d (2, 2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d initialPosition) {
        this.currentPosition = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return this.currentPosition.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        Vector2d newPosition;
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                newPosition = this.currentPosition.add(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.currentPosition = newPosition;
                }
                break;
            case BACKWARD:
                newPosition = this.currentPosition.subtract(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.currentPosition = newPosition;
                }
                break;
        }

    }
}
