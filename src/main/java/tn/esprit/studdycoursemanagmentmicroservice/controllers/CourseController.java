package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseProgressService;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseService;
import tn.esprit.studdycoursemanagmentmicroservice.services.EnrollmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseProgressService courseProgressService;

    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/filter")
    public Page<Course> filterCourses(
            // Filtering
            @RequestParam(required = false) List<Long> categoryId,
            @RequestParam(required = false) List<String> level,
            @RequestParam(required = false) String query,
            // Pagination
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return courseService.filterCourses(pageable, categoryId, level, query);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable long id){return courseService.getById(id);}
    @PostMapping
    public Course addCourse(@RequestBody Course course) {return courseService.addCourse(course);}
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id){courseService.removeCourse(id);}
    @PutMapping
    public Course updateCourse(@RequestBody Course course){return courseService.updateCourse(course);}

    @GetMapping("/{id}/users/{userId}/progress")
    public Double getProgress(@PathVariable Long id, @PathVariable Long userId){
        return this.courseProgressService.getCourseProgress(userId, id);
    }

    @PostMapping("/{id}/users/{userId}")
    public void enroll(@PathVariable Long id, @PathVariable Long userId){
        this.courseService.enroll(id, userId);
    }
    @GetMapping("/{id}/users/{userId}/enrollments")
    public Enrollment getEnrollment(@PathVariable Long id, @PathVariable Long userId){
        return this.enrollmentService.getByUserIdAndCourseId(userId, id);
    }

}
