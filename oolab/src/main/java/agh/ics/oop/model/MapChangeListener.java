package agh.ics.oop.model;

import java.util.UUID;

public interface MapChangeListener {
    void mapChanged(WorldMap worldMap, String messege, UUID mapID);
}
