package agh.ics.oop.model;

public class Animal {

    private MapDirection orientation;
    private Vector2d currentPosition;


    public Animal() {
        this.currentPosition = new Vector2d (2, 2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d initialPosition) {
        this.currentPosition = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString(){
        return currentPosition.toString() + " " + orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return this.currentPosition.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d newPosition;
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                newPosition = this.currentPosition.add(this.orientation.toUnitVector());
                if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))) {
                    this.currentPosition = newPosition;
                }
            }
            case BACKWARD -> {
                newPosition = this.currentPosition.subtract(this.orientation.toUnitVector());
                if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))) {
                    this.currentPosition = newPosition;
                }
            }
        }
    }
}
