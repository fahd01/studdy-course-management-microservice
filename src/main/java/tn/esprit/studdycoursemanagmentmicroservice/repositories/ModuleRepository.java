package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    int countByCourseId(Long courseId);
    List<Module> getModulesByCourseId(Long courseId);
}
