package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
