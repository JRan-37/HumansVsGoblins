package Entities;

import Environment.GridTiles;
import Events.DamageEvent;

public class Character extends GameObject{

    protected int health;
    protected int strength;

    public void attack(Character target, Character instigator) {
        target.setHealth(target.getHealth() - strength);
        DamageEvent.Trigger(target, instigator, strength);

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
}
