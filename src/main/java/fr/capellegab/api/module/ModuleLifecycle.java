package fr.capellegab.api.module;

import fr.capellegab.api.event.Event;

public interface ModuleLifecycle {

    default void onStart() {}

    default void onStop() {}

    default void onError(Event event, Exception exception) {}
}
