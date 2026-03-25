package fr.capellegab.api;

import fr.capellegab.api.entities.EventType;
import fr.capellegab.api.entities.Priority;

public record ModuleConfig (
    String moduleName,
    EventType type,
    Priority priority
) {
}