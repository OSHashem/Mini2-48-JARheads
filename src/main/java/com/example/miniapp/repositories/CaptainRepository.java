package com.example.miniapp.repositories;



import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    Captain findByLicenseNumber(String licenseNumber);
    List<Captain> findByAvgRatingScoreGreaterThan(double threshold);

}

