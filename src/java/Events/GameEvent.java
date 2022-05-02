package Events;

import Managers.EventManager;
import Utils.Events;

public class GameEvent {
    public String name;
    static GameEvent e;

    public GameEvent (String name) {
        this.name = name;
    }

    public static <T> void Trigger(String name) {
        e = new GameEvent(name);
        EventManager.TriggerEvent(e, Events.GameEvent);
    }
}
