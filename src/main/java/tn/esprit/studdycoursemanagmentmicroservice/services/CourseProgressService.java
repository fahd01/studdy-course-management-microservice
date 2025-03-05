package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleCompletionRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleRepository;

@RequiredArgsConstructor
@Service
public class CourseProgressService {
    
    private final ModuleCompletionRepository moduleCompletionRepository;
    
    private final ModuleRepository moduleRepository;

    public double getCourseProgress(Long userId, Long courseId) {
        int completedModules = moduleCompletionRepository.countCompletedModules(userId, courseId);
        int totalModules = moduleRepository.countByCourseId(courseId);
        if (totalModules == 0) return 0.0;
        return ((double) completedModules / totalModules) * 100;
    }
}