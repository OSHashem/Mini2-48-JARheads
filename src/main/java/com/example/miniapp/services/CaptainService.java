package com.example.miniapp.services;



import com.example.miniapp.models.Captain;
import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {

    @Autowired
    private CaptainRepository captainRepository;


    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);
    }


    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }


    public Captain getCaptainById(Long id) {
        return captainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Captain not found with ID: " + id));
    }


    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }


    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository.findByLicenseNumber(licenseNumber)
                .orElseThrow(() -> new RuntimeException("Captain not found with license number: " + licenseNumber));
    }
}

