package fr.capellegab.api.event;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record Event(
        UUID uuid,
        EventType type,
        String source,
        Map<String, Object> payload,
        Instant timestamp,
        Priority priority
) {
}
