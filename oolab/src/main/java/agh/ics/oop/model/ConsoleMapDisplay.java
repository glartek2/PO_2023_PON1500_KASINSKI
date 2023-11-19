package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updateCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Map updated: " + message);
        System.out.print("Stan mapy:\n" + worldMap + "\n");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
