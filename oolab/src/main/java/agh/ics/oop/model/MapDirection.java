package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public String toString(){
        String direction = null;
        switch (this){
            case NORTH -> direction = "Polnoc";
            case SOUTH -> direction = "Poludnie";
            case EAST -> direction = "Wschod";
            case WEST -> direction = "Zachod";
        }
        return direction;
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


