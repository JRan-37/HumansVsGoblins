package Listeners;

public interface EventListener<T> extends EventListenerBase {
    void onEvent(T eventType);
}
