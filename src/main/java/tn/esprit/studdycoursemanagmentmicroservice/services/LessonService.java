package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Lesson;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.EnrollmentRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.LessonRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    public List<Lesson> getAll(){
        return this.lessonRepository.findAll();
    }

    public Lesson getById(long id){
        return this.lessonRepository.findById(id).get();
    }

    public Lesson addLesson(Lesson lesson){
        return this.lessonRepository.save(lesson);
    }

    public void removeLesson(long id){
        this.lessonRepository.deleteById(id);
    }

    public Lesson updateLesson(Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }
}
