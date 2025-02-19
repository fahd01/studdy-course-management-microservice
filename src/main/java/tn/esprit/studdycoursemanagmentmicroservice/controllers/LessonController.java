package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Lesson;
import tn.esprit.studdycoursemanagmentmicroservice.services.EnrollmentService;
import tn.esprit.studdycoursemanagmentmicroservice.services.LessonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    @GetMapping
    public List<Lesson> getAll(){
        return lessonService.getAll();
    }
    @GetMapping("/{id}")
    public Lesson getById(@PathVariable long id){return lessonService.getById(id);}
    @PostMapping("/add-lesson")
    public Lesson addLesson(@RequestBody Lesson l) {return lessonService.addLesson(l);}
    @DeleteMapping
    public void deleteLesson(long id){lessonService.removeLesson(id);}
    @PutMapping("/update-lesson")
    public Lesson updateLesson(@RequestBody Lesson l){return lessonService.updateLesson(l);}

}
