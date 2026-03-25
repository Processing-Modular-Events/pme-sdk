package fr.capellegab.api.module;

import fr.capellegab.api.event.Event;

public interface EventContext {

    void publish(Event event);

    void log(String message);

    void log(String message, Object... args);
}
