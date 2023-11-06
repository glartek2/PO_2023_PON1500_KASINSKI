package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    @Override
    public String toString() {
        char orientationChar;
        switch (this) {
            case NORTH:
                orientationChar = 'N';
                break;
            case EAST:
                orientationChar = 'E';
                break;
            case SOUTH:
                orientationChar = 'S';
                break;
            case WEST:
                orientationChar = 'W';
                break;
            default:
                orientationChar = '?'; // Handle an unknown direction
        }
        return Character.toString(orientationChar);
    }

    public MapDirection next(){
        int nextIndex = (this.ordinal() + 1) % values().length;
        return values()[nextIndex];
    }

    public MapDirection previous(){
        int previousIndex = (this.ordinal() + values().length - 1) % values().length;
        return values()[previousIndex];
    }

    public Vector2d toUnitVector(){
        Vector2d newVector;
        switch (this){
            case NORTH -> {
                newVector = new Vector2d(0, 1);
                return newVector;
            }
            case SOUTH -> {
                newVector = new Vector2d(0, -1);
                return newVector;
            }
            case EAST -> {
                newVector = new Vector2d(1, 0);
                return newVector;
            }
            case WEST -> {
                newVector = new Vector2d(-1, 0);
                return newVector;
            }
        }
        return new Vector2d(0, 0);
    }
}


