package agh.ics.oop.model;

import java.util.UUID;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updateCount = 0;


    @Override
    public void mapChanged(WorldMap worldMap, String message, UUID mapID) {
        System.out.println("Operacja nr: " + updateCount);
        System.out.println("Map " + mapID + " updated: " + message);
        System.out.print("Stan mapy:\n" + worldMap + "\n");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
