package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.EnrollmentRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.EnrollmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAll(){
        return this.enrollmentRepository.findAll();
    }

    public Enrollment getById(long id){
        return this.enrollmentRepository.findById(id).get();
    }

    public Enrollment addEnrollment(Enrollment enrollment){
        return this.enrollmentRepository.save(enrollment);
    }

    public void removeEnrollment(long id){
        this.enrollmentRepository.deleteById(id);
    }

    public Enrollment updateEnrollment(Enrollment enrollment) {
        return this.enrollmentRepository.save(enrollment);
    }

    public Enrollment getByUserIdAndCourseId(Long userId, Long courseId){
        return this.enrollmentRepository.findByUserIdAndCourseId(userId, courseId).orElseGet( () ->  null );
    }

}
