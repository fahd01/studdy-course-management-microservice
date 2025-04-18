package com.esprit.microservice.stagemicroservice.stagemicroservice.StageRepo;

import com.esprit.microservice.stagemicroservice.stagemicroservice.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRepo extends JpaRepository<Stage, Long> {
    List<Stage> findByTitleContainingIgnoreCase(String title);
}
