package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Module;
import tn.esprit.studdycoursemanagmentmicroservice.entities.ModuleAttachment;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseProgressService;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseService;
import tn.esprit.studdycoursemanagmentmicroservice.services.EnrollmentService;
import tn.esprit.studdycoursemanagmentmicroservice.services.ModuleAttachmentService;
import tn.esprit.studdycoursemanagmentmicroservice.services.ModuleService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseProgressService courseProgressService;

    private final EnrollmentService enrollmentService;
    private final ModuleService moduleService;
    private final ModuleAttachmentService moduleAttachmentService;

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
            @RequestParam(required = false) Integer enrolledUserId,
            // Pagination
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return courseService.filterCourses(pageable, categoryId, level, query, enrolledUserId);
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

    /***** Course Modules ******/
    @GetMapping("/{id}/modules")
    public List<Module> fetchCourseModules(@PathVariable Long id){
        return this.moduleService.getModulesByCourseId(id);
    }

    @PostMapping("/{id}/modules")
    public Module createModule(@PathVariable Long id, @RequestBody Module module) {
        Course course = courseService.getById(id);
        module.setCourse(course);
        return this.moduleService.create(module);
    }

    @DeleteMapping("/{id}/modules/{moduleId}")
    public void deleteModule(@PathVariable Long id, @PathVariable Long moduleId){
        this.moduleService.delete(moduleId);
    }

    @PostMapping("/{id}/modules/{moduleId}/upload")
    public void uploadModuleAttachment(
            @PathVariable Long id,
            @PathVariable Long moduleId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ModuleAttachment attachment = new ModuleAttachment(fileName, file.getContentType(), file.getBytes());
        Module module = this.moduleService.getById(moduleId);
        attachment.setModule(module);
        this.moduleAttachmentService.store(attachment);
    }

    /*** Statistics ****/

    @GetMapping("/statistics")
    public Map<String, Object> getCourseStatistics(){
        return Map.of(
                "categories", Map.of(
                        "Programming",10,
                        "Design", 5,
                        "Photography", 2
                ),
                "enrollment_by_month", List.of(
                        Month.values(),
                        Arrays.stream(Month.values()).map(m -> Random.from(RandomGenerator.getDefault()).nextInt(10, 1000)).toList()
                )
        );
    }

}
