package com.example.miniapp.controllers;

import com.example.miniapp.models.Captain;
import com.example.miniapp.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/captain")
public class CaptainController {

    private final CaptainService captainService;

    @Autowired
    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }


    @PostMapping("/addCaptain")
    public Captain addCaptain(@RequestBody Captain captain) {
        Captain savedCaptain = captainService.addCaptain(captain);
        return savedCaptain;
    }


    @GetMapping("/allCaptains")
    public List<Captain> getAllCaptains() {
        List<Captain> captains = captainService.getAllCaptains();
        return captains;
    }


    @GetMapping("/{id}")
    public Captain getCaptainById(@PathVariable Long id) {
        Captain captain = captainService.getCaptainById(id);
        return captain;
    }


    @GetMapping("/filterByRating")
    public List<Captain> getCaptainsByRating(@RequestParam Double ratingThreshold) {
        List<Captain> captains = captainService.getCaptainsByRating(ratingThreshold);
        return captains;
    }


    @GetMapping("/filterByLicenseNumber")
    public Captain getCaptainByLicenseNumber(@RequestParam String licenseNumber) {
        return captainService.getCaptainByLicenseNumber(licenseNumber);
    }
}
