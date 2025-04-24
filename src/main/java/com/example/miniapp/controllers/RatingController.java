package com.example.miniapp.controllers;

import com.example.miniapp.models.Rating;
import com.example.miniapp.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // POST /api/ratings - Add a new rating
    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.addRating(rating);
        return ResponseEntity.ok(savedRating);
    }

    // PUT /api/ratings/{id} - Update an existing rating
    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable String id, @RequestBody Rating updatedRating) {
        Rating updated = ratingService.updateRating(id, updatedRating);
        return ResponseEntity.ok(updated);
    }
}

