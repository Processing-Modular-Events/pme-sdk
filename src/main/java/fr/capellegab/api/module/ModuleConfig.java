package fr.capellegab.api.module;

import fr.capellegab.api.event.EventType;
import fr.capellegab.api.event.Priority;

import java.util.Set;

public record ModuleConfig(
        String moduleName,
        String version,
        String author,
        String description,
        Set<EventType> subscribesTo,
        Priority priority
) {

    public ModuleConfig {
        if (moduleName == null || moduleName.isBlank())
            throw new IllegalArgumentException("moduleName is required");
        if (version == null || version.isBlank())
            throw new IllegalArgumentException("version is required");
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("author is required");
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("description is required");
        if (subscribesTo == null || subscribesTo.isEmpty())
            throw new IllegalArgumentException("subscribesTo must contain at least one EventType");
        if (priority == null)
            throw new IllegalArgumentException("priority is required");
    }
}
