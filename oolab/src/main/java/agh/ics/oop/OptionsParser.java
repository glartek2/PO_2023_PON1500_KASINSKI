package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<>();

        for (String arg : args) {
            MoveDirection direction = switch (arg) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "l", "left" -> MoveDirection.LEFT;
                case "r", "right" -> MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(arg + "is not legal move specification");
            };

            if (direction != null) {
                directions.add(direction);
            }
        }

        return directions;
    }

    public static MoveDirection[] parseArray(String[] args) {
        List<MoveDirection> directions = parse(args);
        return directions.toArray(new MoveDirection[0]);
    }
}