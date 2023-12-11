package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SimulationPresenter implements MapChangeListener{
    private static final double CELL_WIDTH = 50;
    private static final double CELL_HEIGHT = 50;
    private WorldMap map;


    @FXML
    private Label infoLabel;

    @FXML
    private TextField movementTextField;

    @FXML
    private GridPane mapGrid;

    @FXML
    private void onSimulationStartClicked() throws PositionAlreadyOccupiedException {

        String movements = movementTextField.getText();
        String[] movementArray = movements.split(" ");

        List<MoveDirection> directionsList = OptionsParser.parse(movementArray);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(directionsList, positions, this.map);

        List<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation);

        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runAsync();

}

    private void drawMap(WorldMap worldMap) {
        clearGrid();
        Boundary t = worldMap.getCurrentBounds();
        int columns = t.upperRight().getX() - t.lowerLeft().getX();
        int rows = t.upperRight().getY() - t.lowerLeft().getY();

        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                if (this.map.isOccupied(new Vector2d(col, row))) {
                    String cellContent = worldMap.objectAt(new Vector2d(col, row)).toString();
                    Label label = new Label(cellContent);
                    GridPane.setHalignment(label, HPos.CENTER);
                    mapGrid.add(label, col, row);
                }
            }
        }

        // Set appropriate column and row sizes
        for (int col = 0; col < columns; col++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
        for (int row = 0; row < rows; row++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void setMap(WorldMap map) {
        this.map = map;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String messege, UUID mapID) {
        Platform.runLater(() -> {
            drawMap(worldMap);
        });
    }
}
