package com.esprit.microservice.stagemicroservice.stagemicroservice.RestController;

import com.esprit.microservice.stagemicroservice.stagemicroservice.Service.IService;
import com.esprit.microservice.stagemicroservice.stagemicroservice.entity.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stages")
@RequiredArgsConstructor
public class RestControllerMicro {

    @Autowired
    private IService stageService;

    @PostMapping
    public Stage addStage(@RequestBody Stage stage) {
        return stageService.addStage(stage);
    }

    @PutMapping("/{id}")
    public Stage updateStage(@RequestBody Stage stage, @PathVariable Long id) {
        return stageService.updateStage(stage, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable Long id) {
        return stageService.getStageById(id);
    }

    @GetMapping
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("/search")
    public List<Stage> searchStages(@RequestParam String title) {
        return stageService.searchByTitle(title);
    }

}