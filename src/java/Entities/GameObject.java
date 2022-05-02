package Entities;

import Environment.GridTiles;

public abstract class GameObject {

    protected GridTiles currentTile;
    protected int posX;
    protected int posY;

    public int getPosX() {
        return posY;
    }
    public int getPosY() { return posY; }

    public void spawn(GridTiles tile) {
        tile.setGridObject(this);
        currentTile = tile;
        posX = tile.getPosition().posX();
        posY = tile.getPosition().posY();
    }

    public String toString() {
        return "C";
    }
}
