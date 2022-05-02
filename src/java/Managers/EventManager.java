package Managers;

import Events.InputEvent;
import Listeners.EventListener;
import Listeners.EventListenerBase;
import java.util.*;

public class EventManager{

    private static List<EventListenerBase> listenersList;

    private static EventManager instance = null;

    public static EventManager getInstance() {
        return instance == null ? new EventManager() : instance;
    }

    private EventManager() {
        listenersList = new ArrayList<>();
    }

    public static <Event> void AddListener(EventListener<Event> e) {

        if(!listenersList.contains(e)) {
            listenersList.add(e);
        }


        System.out.println("Added " + e);
    }

    public static <Event> void RemoveListener(EventListener<Event> e) {
        InputEvent type = e.;

        if(!listenersList.contains(e)){
            return;
        }

        /*List<EventListenerBase> listenList = listenersList.get(type);

        for(EventListenerBase event : listenList) {
            EventListener<Event> eventChild = (EventListener<Event>) event;
            if(eventChild == e) {
                listenList.remove(event);
            }
            if(listenList.size() == 0) {
                listenersList.remove(type);
            }
        }*/
    }

    public static <Event> void TriggerEvent(Event e){
        Class<?> type = e.getClass();
        System.out.println(e);
        //System.out.println(listenersList.values());

        if(!listenersList.contains(e)){
            System.out.println("not found");
            return;
        }

        //List<EventListenerBase> eventList = listenersList.get(type);

        for(EventListenerBase event : listenersList){
            EventListener<Event> eventChild = (EventListener<Event>) event;
            eventChild.onEvent(e);
        }
    }

    private static boolean listenersExist(Class<?> type, EventListenerBase receiver) {
        List<EventListenerBase> receivers;

        /*if(!listenersList.containsKey(type)) {
            return false;
        }*/

        boolean found = false;

        /*receivers = listenersList.get(type);

        for(EventListenerBase event : receivers) {
            if(event == receiver){
                found = true;
                break;
            }
        }*/

        return found;
    }

    public static class EventRegister {
        public static <Event> void EventStartListening(EventListener<Event> caller)
        {
            EventManager.<Event>AddListener((EventListener<Event>) EventManager.getInstance());
        }

        public static <Event> void EventStopListening(EventListener<Event> caller)
        {
            EventManager.<Event>RemoveListener(caller);
        }
    }
}








