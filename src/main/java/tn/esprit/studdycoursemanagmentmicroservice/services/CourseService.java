package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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






}
