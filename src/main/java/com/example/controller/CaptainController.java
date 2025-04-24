package com.example.miniapp.controller;

import com.example.miniapp.models.Captain;
import com.example.miniapp.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/captains")
public class CaptainController {

    private final CaptainService captainService;

    @Autowired
    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }


    @PostMapping("/addCaptain")
    public ResponseEntity<Captain> addCaptain(@RequestBody Captain captain) {
        Captain savedCaptain = captainService.addCaptain(captain);
        return new ResponseEntity<>(savedCaptain, HttpStatus.CREATED);
    }


    @GetMapping("/allCaptains")
    public ResponseEntity<List<Captain>> getAllCaptains() {
        List<Captain> captains = captainService.getAllCaptains();
        return new ResponseEntity<>(captains, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Captain> getCaptainById(@PathVariable Long id) {
        Captain captain = captainService.getCaptainById(id);
        return new ResponseEntity<>(captain, HttpStatus.OK);
    }


    @GetMapping("/filterByRating")
    public ResponseEntity<List<Captain>> getCaptainsByRating(@RequestParam Double ratingThreshold) {
        List<Captain> captains = captainService.getCaptainsByRating(ratingThreshold);
        return new ResponseEntity<>(captains, HttpStatus.OK);
    }


    @GetMapping("/filterByLicenseNumber")
    public ResponseEntity<Captain> getCaptainByLicenseNumber(@RequestParam String licenseNumber) {
        Captain captain = captainService.getCaptainByLicenseNumber(licenseNumber);
        return new ResponseEntity<>(captain, HttpStatus.OK);
    }
}
