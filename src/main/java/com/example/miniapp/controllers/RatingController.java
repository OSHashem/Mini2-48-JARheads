package com.example.miniapp.controllers;

import com.example.miniapp.models.Rating;
import com.example.miniapp.services.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // POST /rating/addRating - Add a new rating
    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    // PUT /rating/update/{id} - Update an existing rating
    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable String id, @RequestBody Rating updatedRating) {
        return ratingService.updateRating(id, updatedRating);
    }

    // DELETE /rating/delete/{id} - Delete a rating by ID
    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable String id) {
        try{
            ratingService.deleteRating(id);
            return "Rating deleted successfully with ID: " + id;
        } catch (IllegalArgumentException e) {
            return "Rating not found for ID: " + id;
        }
    }

    // GET /rating/findByEntity - Find ratings for a specific entity
    @GetMapping("/findByEntity")
    public List<Rating> findRatingsByEntity(@RequestParam Long entityId, @RequestParam String entityType) {
        return ratingService.getRatingsByEntity(entityId, entityType);
    }

    // GET /rating/findAboveScore - Find ratings above a specific score
    @GetMapping("/findAboveScore")
    public List<Rating> findRatingsAboveScore(@RequestParam int minScore) {
        return ratingService.findRatingsAboveScore(minScore);
    }
}
