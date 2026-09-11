package dev.lemavos.curtails;

import jakarta.persistence.Entity;

@Entity
public interface LInkRepo extends JpaRepository<Link, String> {
    Optional<Link> findByShortenedUrl(String shortenedUrl);
}
