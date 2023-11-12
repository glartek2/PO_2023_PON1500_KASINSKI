package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassList;

    public GrassField(int grassCount) {
        super();
        this.grassList = new ArrayList<>();
        placeGrass(grassCount);
    }

    private void placeGrass(int grassCount) {
        Random rand = new Random();

        for (int i = 0; i < grassCount; i++) {
            Vector2d grassPosition;
            do {
                int x = rand.nextInt((int) Math.sqrt(grassCount * 10) + 1);
                int y = rand.nextInt((int) Math.sqrt(grassCount * 10) + 1);
                grassPosition = new Vector2d(x, y);
            } while (isOccupied(grassPosition));

            Grass grass = new Grass(grassPosition);
            grassList.add(grass);
            super.place(grass, grassPosition);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}

