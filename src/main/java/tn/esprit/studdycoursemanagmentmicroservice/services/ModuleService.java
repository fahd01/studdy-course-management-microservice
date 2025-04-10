package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public List<Module> getModulesByCourseId(Long courseId) {
        return this.moduleRepository.getModulesByCourseId(courseId);
    }

    public Module getById(Long id) {
        return this.moduleRepository.findById(id).get();
    }

    public Module create(Module module) {
        return this.moduleRepository.save(module);
    }

    public void delete(Long id) {
        this.moduleRepository.deleteById(id);
    }
}
