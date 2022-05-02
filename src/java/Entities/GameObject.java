package Entities;

import Environment.Grid;
import Environment.GridTiles;
import Managers.GridManager;
import Utils.Inputs;
import Utils.Position;

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

    protected void moveTo(Inputs input) {
        int newX = posX, newY = posY;
        switch(input) {
            case MOVE_UP :
                newY--;
                break;
            case MOVE_DOWN:
                newY++;
                break;
            case MOVE_LEFT:
                newX--;
                break;
            case MOVE_RIGHT:
                newX++;
                break;
        }

        move(GridManager.getInstance().getMap().getTileAtPosition(new Position(newX, newY)));

    }

    private void move(GridTiles desination) {
        desination.setGridObject(this);
        currentTile.removeGridObject();
        currentTile = desination;
        posX = desination.getPosition().posX();
        posY = desination.getPosition().posY();
    }

    public String toString() {
        return "C";
    }
}
