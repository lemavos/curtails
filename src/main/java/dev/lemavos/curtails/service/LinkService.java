package dev.lemavos.curtails;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LinkService {

    private final Map<String, Link> repository = new ConcurrentHashMap<>();

    public List<Link> getAll() {
        return new ArrayList<>(repository.values());
    }

    public Optional<Link> getById(String id) {
        return Optional.ofNullable(repository.get(id));
    }

    public Link save(Link link) {
        String id = link.getId();
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
            link.setId(id);
        }
        repository.put(id, link);
        return link;
    }

    public Optional<Link> update(String id, Link link) {
        return Optional.ofNullable(repository.computeIfPresent(id, (key, existing) -> {
            existing.setUrl(link.getUrl());
            existing.setLabel(link.getLabel());
            return existing;
        }));
    }

    public boolean delete(String id) {
        return repository.remove(id) != null;
    }
}

