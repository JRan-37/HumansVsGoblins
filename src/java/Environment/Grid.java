package Environment;

import Utils.Position;

import java.util.Arrays;

public class Grid {

    private GridTiles[][] map;
    private int tileSize;
    private int sizeX;
    private int sizeY;

    public Grid(int sizeX, int sizeY, int tileSize) {
        this.tileSize = tileSize;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        map = new GridTiles[sizeY][sizeX];
        //Arrays.stream(map).forEach(x -> Arrays.fill(x, new GridTiles(tileSize, Tiles.GRASS)));
        for(int i = 0; i < sizeY; i++) {
            for(int j = 0; j < sizeX; j++) {
                map[i][j] = new GridTiles(tileSize, Tiles.GRASS, new Position(i, j));
            }
        }
    }

    public GridTiles getTileAtPosition(Position pos) {
        try {
            map[pos.posY()][pos.posX()].setColors(false);
            return map[pos.posY()][pos.posX()];
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("No Tile");
            return null;
        }
    }

    public void displayMap() {
        int displaySize = map.length * tileSize;
        String[] mapString = new String[displaySize];
        Arrays.fill(mapString, "");

        for(int i = 0; i < sizeY; i++) {
            for(int j = 0; j < sizeX; j++) {
                String[][] currentTile = map[i][j].toStringArray();
                for(int k = 0; k < tileSize; k++) {
                    for(int l = 0; l < tileSize; l++){
                        mapString[i*tileSize + k] += currentTile[k][l];
                    }
                }
            }
        }

        for(int i = 0; i < mapString.length; i++) {
            System.out.println(mapString[i]);
        }
    }
}
