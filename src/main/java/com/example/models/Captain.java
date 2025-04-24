package com.example.miniapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "captains")
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String licenseNumber;
    private double avgRatingScore;


    //@OneToMany(mappedBy = "captain", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Trip> trips;

    public Captain() {}

    public Captain(String name, String licenseNumber, double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    public Captain(String name, String licenseNumber, double avgRatingScore, long id) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Double getAvgRatingScore() {
        return avgRatingScore;
    }

    public void setAvgRatingScore(Double avgRatingScore) {
        this.avgRatingScore = avgRatingScore;
    }

    // public List<Trip> getTrips() {
    //     return trips;
    // }

    // public void setTrips(List<Trip> trips) {
    //     this.trips = trips;
    // }
}
