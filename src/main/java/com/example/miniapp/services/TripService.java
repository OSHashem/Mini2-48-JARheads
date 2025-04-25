package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // Add a new trip
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    // Get all trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Get a trip by its ID
    public Trip getTripById(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip.orElse(null);  // Returns null if no trip is found
    }

    // Update a trip's details (e.g., origin, destination, cost)
    public Trip updateTrip(Long id, Trip updatedTrip) {
        Optional<Trip> existingTrip = tripRepository.findById(id);
        if (existingTrip.isPresent()) {
            Trip trip = existingTrip.get();
            trip.setOrigin(updatedTrip.getOrigin());
            trip.setDestination(updatedTrip.getDestination());
            trip.setTripCost(updatedTrip.getTripCost());
            return tripRepository.save(trip);  // Save the updated trip
        }
        return null;  // Return null if the trip is not found
    }

    // Delete a trip by its ID
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // Find trips within a specified date range
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findByTripDateBetween(startDate, endDate);
    }

    // Find trips by captain's ID
    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}
