package Listeners;

import Managers.EventManager;
import Utils.Events;

public interface EventListener<T> extends EventListenerBase {
    void onEvent(T eventType);

    static <T> void EventStartListening(EventListener<T> caller, Events eventName) {
        EventManager.AddListener(caller, eventName);
    }
    static <T> void EventStopListening(EventListener<T> caller, Events eventName) {
        EventManager.RemoveListener(caller, eventName);
    }
}
