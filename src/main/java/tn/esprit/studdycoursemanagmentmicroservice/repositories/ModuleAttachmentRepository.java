package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;
import tn.esprit.studdycoursemanagmentmicroservice.entities.ModuleAttachment;

import java.util.List;

@Repository
public interface ModuleAttachmentRepository extends JpaRepository<ModuleAttachment, Long> {
}
