package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    directions[i] = MoveDirection.FORWARD;
                    break;
                case "b":
                    directions[i] = MoveDirection.BACKWARD;
                    break;
                case "l":
                    directions[i] = MoveDirection.LEFT;
                    break;
                case "r":
                    directions[i] = MoveDirection.RIGHT;
                    break;
                default:
                    continue;
            }
        }
        return directions;
    }
}