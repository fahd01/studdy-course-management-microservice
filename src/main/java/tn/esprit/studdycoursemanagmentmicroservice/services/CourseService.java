package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public List<Course> getAll(){
       return this.courseRepository.findAll();
    }

    public Course getById(long id){
       return this.courseRepository.findById(id).get();
    }
    public Course addCourse(Course c){
        return this.courseRepository.save(c);
    }

    public void removeCourse(long id){
        this.courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course){
        org.springframework.util.Assert.notNull(course.getId(), "Course Id should not be null in update operation");
        return this.courseRepository.save(course);
    }

    public List<Course> filterCourses(){
        return List.of();
    }

    public Page<Course> paginateCourses(Pageable pageable) {
        return this.courseRepository.findAll(pageable);
    }

}
