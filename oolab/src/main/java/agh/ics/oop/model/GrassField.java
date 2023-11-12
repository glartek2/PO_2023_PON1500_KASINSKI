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

    private String draw(Vector2d lowerLeft, Vector2d upperRight) {
        StringBuilder builder = new StringBuilder();
        for (int y = upperRight.getY(); y >= lowerLeft.getY(); y--) {
            for (int x = lowerLeft.getX(); x <= upperRight.getX(); x++) {
                Vector2d position = new Vector2d(x, y);
                WorldElement element = objectAt(position);
                if (element != null) {
                    builder.append(element.toString());
                } else {
                    builder.append(" ");
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }


    @Override
    public boolean canMoveTo(Object position) {
        return false;
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(super.getElements());
        elements.addAll(grassList);
        return elements;
    }
}

