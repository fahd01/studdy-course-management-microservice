package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    List<Course> findCoursesByUserId(Long userId);
    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);
}
