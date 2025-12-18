package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Influencer;
import java.util.Optional;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Optional<Influencer> findBySocialHandle(String socialHandle);
}
