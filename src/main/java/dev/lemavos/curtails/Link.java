package dev.lemavos.curtails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Link {

    @Id
    private String id;

    private String originalUrl;
    private String shortenedUrl;
    private LocalDateTime createdAt;

    // Getters and setters

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
