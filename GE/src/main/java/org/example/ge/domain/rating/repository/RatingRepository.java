package org.example.ge.domain.rating.repository;

import org.example.ge.domain.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByUserId(Long userId);
}
