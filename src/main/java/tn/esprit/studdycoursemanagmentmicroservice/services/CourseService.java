package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.entities.User;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.CourseRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.EnrollmentRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ModuleRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;

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

    public Page<Course> filterCourses(Pageable pageable, List<Long> categoryIds, List<String> levels, String searchQuery, Integer userId){
        Specification filterByCategories = CourseSearchSpecification.categoryIdIn(categoryIds);
        Specification filterByLevels = CourseSearchSpecification.levelIn(levels);
        Specification filterByTitleAndDescription = CourseSearchSpecification.titleOrDescriptionLike(searchQuery);
        Specification filterByEnrolledUser = CourseSearchSpecification.enrolledUser(userId);

        Specification spec = filterByTitleAndDescription.and(filterByCategories).and(filterByLevels).and(filterByEnrolledUser);

        return courseRepository.findAll(spec, pageable);
    }

    // TODO move to enrollment service ?
    public void enroll(Long courseId, Long userId) {
        Enrollment enrolment = new Enrollment();
        User user = userRepository.findById(userId).get();
        Course course = this.getById(courseId);
        enrolment.setUser(user);
        enrolment.setCourse(course);
        enrolment.setEnrollmentDate(LocalDateTime.now());
        enrollmentRepository.save(enrolment);
    }
}
