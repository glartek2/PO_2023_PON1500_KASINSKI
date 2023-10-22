package agh.ics.oop.model;

public class Vector2d {

    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other){
        return  (other.x <= this.x && other.y <= this.y);
    }

    public boolean follow(Vector2d other){
        return  (other.x >= this.x && other.y >= this.y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        int maxX = Math.max(this.x, other.x);
        int maxY = Math.max(this.y, other.y);
        return new Vector2d(maxX, maxY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int minX = Math.min(this.x, other.x);
        int minY = Math.min(this.y, other.y);
        return new Vector2d(minX, minY);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector2d)) {
            return false;
        }
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }
}
