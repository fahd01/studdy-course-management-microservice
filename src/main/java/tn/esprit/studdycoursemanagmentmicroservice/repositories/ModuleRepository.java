package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    int countByCourseId(Long courseId);
}
