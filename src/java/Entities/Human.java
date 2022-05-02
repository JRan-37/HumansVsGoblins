package Entities;

import Events.InputEvent;
import Listeners.EventListener;
import Listeners.InputListener;
import Managers.EventManager;
import Utils.Colors;

public class Human extends Character implements EventListener<InputEvent> {


    public Human(int health, int strength) {
        this.health = health;
        this.strength = strength;
        //EventManager.EventRegister.<InputEvent>MMEventStartListening(this);
        /*EventManager.<InputEvent>AddListener(new EventListener<InputEvent>() {
            @Override
            public void onEvent(InputEvent eventType) {
                System.out.println(health + " Human");
            }
        });*/
        EventManager.EventRegister.EventStartListening();
    }

    @Override
    public String toString() {
        return Colors.ANSI_YELLOW + "H " + Colors.ANSI_RESET;
    }

    @Override
    public void onEvent(InputEvent eventType) {
        System.out.println("x");
    }
}
