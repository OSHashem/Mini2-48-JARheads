package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    // 1. Find ratings for a given entity by ID and type
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // 2. Retrieve ratings with a score above a specified value
    List<Rating> findByScoreGreaterThan(Integer score);
}
