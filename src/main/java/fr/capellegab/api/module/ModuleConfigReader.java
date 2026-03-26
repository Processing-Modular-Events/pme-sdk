package fr.capellegab.api.module;

import fr.capellegab.api.event.EventType;
import fr.capellegab.api.event.Priority;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class ModuleConfigReader {

    private static final String DEFAULT_FILE = "module.yml";

    private ModuleConfigReader() {}

    public static ModuleConfig load() {
        return load(DEFAULT_FILE);
    }

    public static ModuleConfig load(String filename) {
        InputStream input = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filename);

        if (input == null) {
            throw new IllegalStateException("File " + filename + " not found in classpath (src/main/resources/)");
        }

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(input);

        String name = requireString(data, "name");
        String version = requireString(data, "version");
        String author = requireString(data, "author");
        String description = requireString(data, "description");
        Priority priority = Priority.valueOf(requireString(data, "priority").toUpperCase());

        @SuppressWarnings("unchecked")
        List<String> subscribesList = (List<String>) data.get("subscribes-to");
        if (subscribesList == null || subscribesList.isEmpty()) {
            throw new IllegalStateException("subscribes-to is required in " + filename);
        }

        Set<EventType> subscribesTo = subscribesList.stream()
                .map(s -> EventType.valueOf(s.toUpperCase()))
                .collect(Collectors.toSet());

        return new ModuleConfig(name, version, author, description, subscribesTo, priority);
    }

    private static String requireString(Map<String, Object> data, String key) {
        Object value = data.get(key);
        if (value == null || value.toString().isBlank()) {
            throw new IllegalStateException(key + " is required in module.yml");
        }
        return value.toString();
    }
}
