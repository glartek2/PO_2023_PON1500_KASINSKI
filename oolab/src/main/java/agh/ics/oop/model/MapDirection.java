package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        String direction = null;
        switch (this){
            case NORTH -> direction = "Północ";
            case SOUTH -> direction = "Połdunie";
            case EAST -> direction = "Wschód";
            case WEST -> direction = "Zachód";
        }
        return direction;
    }

    public MapDirection next(){
        switch (this){
            case NORTH -> {
                return EAST;
            }
            case SOUTH -> {
                return WEST;
            }
            case EAST -> {
                return SOUTH;
            }
            case WEST -> {
                return NORTH;
            }
        }
        return null;
    }

    public MapDirection previous(){
        switch (this){
            case NORTH -> {
                return WEST;
            }
            case SOUTH -> {
                return EAST;
            }
            case EAST -> {
                return NORTH;
            }
            case WEST -> {
                return SOUTH;
            }
        }
        return null;
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


