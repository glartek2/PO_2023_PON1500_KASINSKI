package agh.ics.oop.model;

public class TextMapTest {
    public static void main(String[] args) {
        TextMap textMap = new TextMap();

        // Place strings on the map
        textMap.place("Ala", 0);
        textMap.place("ma", 1);
        textMap.place("sowoniedźwiedzia", 2);

        // Print the initial state
        printTextMap(textMap);

        // Move "ma" to the EAST
        textMap.move("ma", MoveDirection.FORWARD);
        printTextMap(textMap);

        // Move "ma" to the EAST again (it should not move further)
        textMap.move("ma", MoveDirection.BACKWARD);
        printTextMap(textMap);

        // Move "ma" to the WEST
        textMap.move("ma", MoveDirection.BACKWARD);
        printTextMap(textMap);
    }

    private static void printTextMap(TextMap textMap) {
        for (int i = 0; i < textMap.textList.size(); i++) {
            System.out.println("Position " + i + ": " + textMap.textList.get(i));
        }
        System.out.println();
    }
}

