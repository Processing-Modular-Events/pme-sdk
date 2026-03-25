package fr.capellegab.api;

import fr.capellegab.api.entities.Event;

public interface EventModule {
    ModuleConfig config();
    void onEvent(Event event, EventContext eventContext);
}
