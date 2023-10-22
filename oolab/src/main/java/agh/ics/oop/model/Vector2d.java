package agh.ics.oop.model;

public class Vector2d {

    private int x;
    private int y;

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

    public String toString(){
        String napis = "(" + this.x + "," + this.y + ")";
        return napis;
    }

    public boolean precedes(Vector2d other){
        return  (other.x <= this.x && other.y <= this.y);
    }

    public boolean follow(Vector2d other){
        return  (other.x >= this.x && other.y >= this.y);
    }

    public Vector2d add(Vector2d other){
        Vector2d newVector = new Vector2d(0,0);
        newVector.x = this.x + other.x;
        newVector.y = this.y + other.y;
        return newVector;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d newVector = new Vector2d(0,0);
        newVector.x = this.x - other.x;
        newVector.y = this.y - other.y;
        return newVector;
    }

    public Vector2d upperRight(Vector2d other){
        Vector2d newVector = new Vector2d(0,0);
        if (other.x > this.x){
            newVector.x = other.x;
        }else{
            newVector.x = this.x;
        }
        if (other.y > this.y){
            newVector.y = other.y;
        }else{
            newVector.y = this.y;
        }
        return newVector;
    }

    public Vector2d lowerLeft(Vector2d other){
        Vector2d newVector = new Vector2d(0,0);
        if (other.x < this.x){
            newVector.x = other.x;
        }else{
            newVector.x = this.x;
        }
        if (other.y < this.y){
            newVector.y = other.y;
        }else{
            newVector.y = this.y;
        }
        return newVector;
    }

    public Vector2d opposite(){
        Vector2d newVector = new Vector2d(0,0);
        newVector.x = -1 * this.x;
        newVector.y = -1 * this.y;
        return newVector;
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }

}
