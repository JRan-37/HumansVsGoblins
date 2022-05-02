package Events;

import Managers.EventManager;

public class GameEvent {
    public String name;
    static GameEvent e;

    public GameEvent (String name) {
        this.name = name;
    }

    public static <T> void Trigger(String name) {
        e.name = name;
        EventManager.TriggerEvent(e);
    }
}
