package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;
import tn.esprit.studdycoursemanagmentmicroservice.entities.ModuleCompletion;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleCompletionRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleCompletionService {
    private final ModuleCompletionRepository moduleCompletionRepository;

    public List<ModuleCompletion> getByCourseIdAndUserId(Long courseId, Long userId) {
        return this.moduleCompletionRepository.findByUserIdAndCourseId(userId, courseId);
    }
}
