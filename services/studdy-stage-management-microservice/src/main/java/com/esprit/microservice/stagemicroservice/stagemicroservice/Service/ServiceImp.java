package com.esprit.microservice.stagemicroservice.stagemicroservice.Service;

import com.esprit.microservice.stagemicroservice.stagemicroservice.StageRepo.StageRepo;
import com.esprit.microservice.stagemicroservice.stagemicroservice.entity.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImp implements IService {

    private final StageRepo stageRepo;

    @Override
    public Stage addStage(Stage stage) {
        return stageRepo.save(stage);
    }

    @Override
    public Stage updateStage(Stage stageUpdates, Long id) {
        return stageRepo.findById(id)
                .map(existingStage -> {
                    // Directly set all fields from updates
                    existingStage.setTitle(stageUpdates.getTitle());
                    existingStage.setDescription(stageUpdates.getDescription());
                    existingStage.setStartDate(stageUpdates.getStartDate());
                    existingStage.setEndDate(stageUpdates.getEndDate());
                    existingStage.setLocation(stageUpdates.getLocation());
                    existingStage.setCategory(stageUpdates.getCategory());
                    existingStage.setPhone(stageUpdates.getPhone());
                    existingStage.setIsVisible(stageUpdates.getIsVisible());
                    return stageRepo.save(existingStage);
                })
                .orElse(null);
    }

    @Override
    public void deleteStage(Long id) {
        stageRepo.deleteById(id);
    }

    @Override
    public Stage getStageById(Long id) {
        return stageRepo.findById(id).orElse(null);
    }

    @Override
    public List<Stage> getAllStages() {
        return stageRepo.findAll();
    }

    @Override
    public List<Stage> searchByTitle(String title) {
        return stageRepo.findByTitleContainingIgnoreCase(title);
    }
}