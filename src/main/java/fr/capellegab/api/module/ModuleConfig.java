package fr.capellegab.api.module;

import fr.capellegab.api.event.EventType;
import fr.capellegab.api.event.Priority;

import java.util.Set;

public record ModuleConfig (
    String moduleName,
    Set<EventType> subscribesTo,
    Priority priority
) {
}