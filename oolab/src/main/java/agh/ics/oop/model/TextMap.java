package agh.ics.oop.model;

import agh.ics.oop.model.MoveDirection;

import java.util.HashMap;
import java.util.Map;

public class TextMap implements WorldMap<String, Integer> {

    final Map<Integer, String> textList = new HashMap<>();

    public TextMap() {
    }

    @Override
    public boolean place(String object, Integer position) {
        if (position >= 0 && position <= textList.size()) {
            textList.put(position, object);
            return true;
        }
        return false;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        Integer currentPosition = getKeyByValue(textList, object);

        if (currentPosition == null || (direction != MoveDirection.FORWARD && direction != MoveDirection.BACKWARD)) {
            // The object is not in the list or the direction is not EAST or WEST.
            return;
        }

        if (direction == MoveDirection.FORWARD && currentPosition < textList.size() - 1) {
            // Move EAST if not at the end.
            textList.remove(currentPosition);
            String temp = textList.get(currentPosition + 1);
            textList.remove(currentPosition + 1);
            textList.put(currentPosition + 1, object);
            textList.put(currentPosition, temp);
        } else if (direction == MoveDirection.BACKWARD && currentPosition > 0) {
            // Move WEST if not at the beginning.
            textList.remove(currentPosition);
            String temp = textList.get(currentPosition - 1);
            textList.remove(currentPosition - 1);
            textList.put(currentPosition - 1, object);
            textList.put(currentPosition, temp);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position >= 0 && position < textList.size();
    }

    @Override
    public String objectAt(Integer position) {
        return textList.get(position);
    }

    @Override
    public boolean canMoveTo(Object position) {
        return (int) position >= 0 && (int) position < textList.size();
    }

    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
