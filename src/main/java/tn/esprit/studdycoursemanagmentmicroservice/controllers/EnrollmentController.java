package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseService;
import tn.esprit.studdycoursemanagmentmicroservice.services.EnrollmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @GetMapping
    public List<Enrollment> getAll(){
        return enrollmentService.getAll();
    }
    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable long id){return enrollmentService.getById(id);}
    @PostMapping
    public Enrollment addEnrollment(@RequestBody Enrollment e) {return enrollmentService.addEnrollment(e);}
    @DeleteMapping
    public void deleteCourse(long id){enrollmentService.removeEnrollment(id);}
    @PutMapping
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment){return enrollmentService.updateEnrollment(enrollment);}


}
