package Entities;

import Environment.GridTiles;
import Events.InputEvent;
import Listeners.EventListener;
import Utils.Colors;
import Utils.Events;

public class Human extends Character implements EventListener<InputEvent> {


    public Human(int health, int strength, int defense, int accuracy) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.accuracy = accuracy;

    }

    @Override
    public void spawn(GridTiles tile) {
        super.spawn(tile);

        onEnable();
    }

    @Override
    protected void kill() {
        super.kill();

        onDisable();
    }

    @Override
    public String toString() {
        return Colors.ANSI_YELLOW + "H " + Colors.ANSI_RESET;
    }

    @Override
    public void onEvent(InputEvent eventType) {
        moveTo(eventType.input);
    }

    private void onEnable() {
        EventListener.EventStartListening(this, Events.InputEvent);
    }

    private void onDisable() {
        EventListener.EventStopListening(this, Events.InputEvent);
    }

}
