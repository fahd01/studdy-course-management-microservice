package com.esprit.microservice.stagemicroservice.stagemicroservice.Service;

import com.esprit.microservice.stagemicroservice.stagemicroservice.entity.Stage;
import java.util.List;

public interface IService {
    Stage addStage(Stage stage);
    Stage updateStage(Stage stage, Long id);
    void deleteStage(Long id);
    Stage getStageById(Long id);
    List<Stage> getAllStages();
    List<Stage> searchByTitle(String title);

}