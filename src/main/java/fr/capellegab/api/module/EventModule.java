package fr.capellegab.api.module;

import fr.capellegab.api.event.Event;

public interface EventModule {
    ModuleConfig config();
    void onEvent(Event event, EventContext eventContext);
}
