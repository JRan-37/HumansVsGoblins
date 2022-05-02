package Environment;

import Entities.GameObject;
import Utils.Colors;
import Utils.Position;

import java.util.Arrays;

public class GridTiles {

    private Tiles[][] grid;
    private GameObject currentObj;
    private Position position;

    public GridTiles(int size, Tiles type, Position position) {
        grid = new Tiles[size][size];
        this.position = position;
        Arrays.stream(grid).forEach(x -> Arrays.fill(x, type));
    }

    public String[][] toStringArray() {
        String[][] stringGrid = new String[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++){
                stringGrid[i][j] = getTileString(grid[i][j]);
            }
        }

        if(currentObj != null) {
            int centerPosition = grid.length / 2 + 1;
            stringGrid[centerPosition][centerPosition] = currentObj.toString();
        }
        return stringGrid;
    }

    public Position getPosition() {
        return position;
    }

    public void setGridObject(GameObject obj) {
        currentObj = obj;
    }

    public void removeGridObject() {
        currentObj = null;
    }

    public GameObject getGridObject() {
        return currentObj;
    }

    private String getTileString(Tiles tile) {
        switch(tile) {
            case DIRT :
                return Colors.ANSI_RED + "+ " + Colors.ANSI_RESET;
            case GRASS:
                return Colors.ANSI_GREEN + "+ " + Colors.ANSI_RESET;
            case ROCK:
                return Colors.ANSI_CYAN + "+ " + Colors.ANSI_RESET;
            default:
                return Colors.ANSI_GREEN + "+ " + Colors.ANSI_RESET;
        }
    }

}
