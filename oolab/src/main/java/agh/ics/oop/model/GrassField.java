package agh.ics.oop.model;

import agh.ics.oop.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassList;

    public GrassField(int grassCount) throws PositionAlreadyOccupiedException {
        super();
        this.grassList = new ArrayList<>();
        placeGrass(grassCount);
    }

    private void placeGrass(int grassCount) throws PositionAlreadyOccupiedException {
        Random rand = new Random();

            int x = (int) Math.sqrt(grassCount * 10) + 1;
            int y = (int) Math.sqrt(grassCount * 10) + 1;

            RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(x, y, grassCount);
            for (Vector2d grassPosition : randomPositionGenerator) {
                Grass grass = new Grass(grassPosition);
                grassList.add(grass);
                super.place(grass, grassPosition);
            }
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(super.getLowerLeft(), super.getUpperRight());
    }

    @Override
    public String toString() {
        return super.toString();
    }


}

