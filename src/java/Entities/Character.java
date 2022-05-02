package Entities;

import Environment.GridTiles;
import Events.DamageEvent;
import Managers.GridManager;
import Utils.Inputs;
import Utils.Position;

public class Character extends GameObject{

    protected int health;
    protected int strength;
    protected int accuracy;
    protected int defense;

    public void attack(Character target, Character instigator) {
        int damage = rollDamage(target, instigator);
        if(damage > 0)
            target.setHealth(target.getHealth() - strength);

        DamageEvent.Trigger(target, instigator, strength);

        System.out.println(instigator.toString() + "attacked " + target.toString() + "for " + damage + " damage");

    }

    private int rollDamage(Character target, Character instigator) {
        double hitChance = Math.random() * 100;

        if(hitChance > instigator.accuracy)
            return -1;

        double damage = Math.max(Math.random() * instigator.strength, instigator.strength * 0.2);
        return Math.max((int)damage - target.defense, 0);
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

        contextAction(GridManager.getInstance().getMap().getTileAtPosition(new Position(newY, newX)));

    }

    private void contextAction(GridTiles destination) {
        if(destination == null) {
            System.out.println("Null tile");
            return;
        }

        if(destination.getGridObject() == null)
            move(destination);
        else if(destination.getGridObject() instanceof Character)
            attack((Character)destination.getGridObject(), this);

    }

    private void move(GridTiles destination) {
        destination.setGridObject(this);
        currentTile.removeGridObject();
        currentTile = destination;
        posX = destination.getPosition().posX();
        posY = destination.getPosition().posY();

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
        if(health <= 0) {
            health = 0;
            kill();
        }
    }

    protected void kill() {
        currentTile.removeGridObject();
    }
}
