package Entities.Items;

import Events.ItemPickupEvent;
import Entities.GameObject;
import Environment.GridTiles;
import Listeners.EventListener;
import Utils.Events;

//Parent class of all game items, handles pickup event listeners
public class Item extends GameObject implements EventListener<ItemPickupEvent> {

    @Override
    public void spawn(GridTiles tile) {
        super.spawn(tile);
        onEnable();
    }
    @Override
    public String toString() {
        return "I ";
    }

    @Override
    public void onEvent(ItemPickupEvent eventType) {

    }

    //Adds this object to the eventlistener, listening for ItemPickupEvent
    private void onEnable() {
        EventListener.EventStartListening(this, Events.ItemPickupEvent);
    }

    //Removes this object from eventlistener, no longer listening for ItemPickupEvent
    private void onDisable() {
        EventListener.EventStopListening(this, Events.ItemPickupEvent);
    }

}
