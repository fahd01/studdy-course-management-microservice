package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    @GetMapping("/{id}")
    public Course getById(@PathVariable long id){return courseService.getById(id);}
    @PostMapping("/add-course")
    public Course addCourse(@RequestBody Course c) {return courseService.addCourse(c);}
    @DeleteMapping
    public void deleteCourse(long id){courseService.removeCourse(id);}
    @PutMapping("/update-course")
    public Course updateCourse(Course course){return courseService.updateCourse(course);}

}
