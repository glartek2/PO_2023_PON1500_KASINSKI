package agh.ics.oop;

import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final List<Vector2d> positions;
    private final int maxWidth;
    private final int maxHeight;
    private final int count;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int count) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.count = count;
        this.positions = generateRandomPositions();
    }

    private List<Vector2d> generateRandomPositions() {
        List<Vector2d> allPositions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                allPositions.add(new Vector2d(x, y));
            }
        }
        Collections.shuffle(allPositions);
        return allPositions.subList(0, count);
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return positions.iterator();
    }
}
