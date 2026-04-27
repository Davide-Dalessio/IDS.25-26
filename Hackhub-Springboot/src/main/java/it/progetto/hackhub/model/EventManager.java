package it.progetto.hackhub.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<IObserver>> listeners = new HashMap<>();

    public void subscribe(String eventType, IObserver listener) {
        if (!listeners.containsKey(eventType)) {
            listeners.put(eventType, new ArrayList<>());
        }
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, IObserver listener) {
        if (listeners.containsKey(eventType)) {
            listeners.get(eventType).remove(listener);
        }
    }

    public void notify(String eventType, String data) {
        if (listeners.containsKey(eventType)) {
            for (IObserver listener : listeners.get(eventType)) {
                listener.update(data);
            }
        }
    }
}
