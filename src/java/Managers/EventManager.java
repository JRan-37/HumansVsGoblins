package Managers;

import Listeners.EventListener;
import Listeners.EventListenerBase;
import Utils.Events;

import java.util.*;

public class EventManager{

    private static Map<Events, List<EventListenerBase>> listenersList;

    private static EventManager instance = null;

    public static EventManager getInstance() {
        return instance == null ? new EventManager() : instance;
    }

    private EventManager() {
        listenersList = new HashMap<>();
    }

    public static <Even> void AddListener(EventListener<Even> e, Events eName) {

        if(!listenersList.containsKey(eName)) {
            listenersList.put(eName, new ArrayList<>());
        }

        if(!listenersList.get(eName).contains(e)) {
            listenersList.get(eName).add(e);
        }
    }

    public static <Event> void RemoveListener(EventListener<Event> e, Events eName) {

        if(!listenersList.containsKey(eName)){
            return;
        }

        List<EventListenerBase> listenList = listenersList.get(eName);

        for(EventListenerBase event : listenList) {
            EventListener<Event> eventChild = (EventListener<Event>) event;
            if(eventChild == e) {
                listenList.remove(event);
            }
            if(listenList.size() == 0) {
                listenersList.remove(eName);
            }
        }
    }

    public static <E> void TriggerEvent(E e, Events eName){

        if(!listenersList.containsKey(eName)){
            System.out.println("not found");
            return;
        }

        List<EventListenerBase> eventList = listenersList.get(eName);

        for(EventListenerBase event : eventList){
            EventListener<E> eventChild = (EventListener<E>) event;
            eventChild.onEvent(e);
        }
    }

}








