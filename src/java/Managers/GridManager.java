package Managers;

import Environment.Grid;

public class GridManager {

    private static GridManager instance = null;

    public static GridManager getInstance() {
        return instance == null ? new GridManager() : instance;
    }

    private Grid map;

    private int tileSize = 3;
    private int mapSizeX = 7;
    private int mapSizeY = 4;

    public GridManager() {
        map = new Grid(mapSizeX, mapSizeY, tileSize);
    }

    public Grid getMap() { return map;}

    public void displayMap() {
        map.displayMap();
    }
}
