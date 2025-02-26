package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/paged")
    public Page<Course> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return courseService.paginateCourses(pageable);
    }


    @GetMapping("/{id}")
    public Course getById(@PathVariable long id){return courseService.getById(id);}
    @PostMapping
    public Course addCourse(@RequestBody Course course) {return courseService.addCourse(course);}
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id){courseService.removeCourse(id);}
    @PutMapping
    public Course updateCourse(@RequestBody Course course){return courseService.updateCourse(course);}

}
