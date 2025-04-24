package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public Rating addRating(Rating rating) {

        if (rating.getRatingDate() == null) {
            rating.setRatingDate(LocalDateTime.now());
        }


        if (rating.getScore() < 1 || rating.getScore() > 5) {
            throw new IllegalArgumentException("Score must be between 1 and 5");
        }

        return ratingRepository.save(rating);
    }


    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> existingRatingOpt = ratingRepository.findById(id);

        if (existingRatingOpt.isEmpty()) {
            throw new IllegalArgumentException("Rating with ID " + id + " not found.");
        }

        Rating existingRating = existingRatingOpt.get();

        // Update only score and comment fields
        if (updatedRating.getScore() != null) {
            if (updatedRating.getScore() < 1 || updatedRating.getScore() > 5) {
                throw new IllegalArgumentException("Score must be between 1 and 5");
            }
            existingRating.setScore(updatedRating.getScore());
        }

        if (updatedRating.getComment() != null) {
            existingRating.setComment(updatedRating.getComment());
        }

        return ratingRepository.save(existingRating);
    }

}
