package Entities;

import Environment.GridTiles;
import Events.InputEvent;
import Listeners.EventListener;
import Utils.Colors;
import Utils.Events;

//Human object controlled by the player, implements eventlistener to handle player input
public class Human extends Character implements EventListener<InputEvent> {

    //Initialize Human with health, strength, defense and accuracy stats
    public Human(int health, int strength, int defense, int accuracy) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.accuracy = accuracy;

    }

    //calls onEnable() method whenever this object is spawned on the map
    @Override
    public void spawn(GridTiles tile) {
        super.spawn(tile);

        onEnable();
    }

    //calls onDisable() method whenever this object is killed
    @Override
    protected void kill() {
        super.kill();

        onDisable();
    }

    //Overrides toString with a yellow "H " to represent Human objects
    @Override
    public String toString() {
        return Colors.ANSI_YELLOW + "H " + Colors.ANSI_RESET;
    }

    //called when InputEvent is triggered, supplies input to movement method
    @Override
    public void onEvent(InputEvent eventType) {
        moveTo(eventType.input);
    }

    //Adds this object to the eventlistener, listening for InputEvent
    private void onEnable() {
        EventListener.EventStartListening(this, Events.InputEvent);
    }

    //Removes this object from eventlistener, no longer listening for InputEvent
    private void onDisable() {
        EventListener.EventStopListening(this, Events.InputEvent);
    }

}
