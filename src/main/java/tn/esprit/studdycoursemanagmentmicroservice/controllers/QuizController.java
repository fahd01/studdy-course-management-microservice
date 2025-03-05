package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Quiz;
import tn.esprit.studdycoursemanagmentmicroservice.services.QuizService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;
    @GetMapping
    public List<Quiz> getAll(){
        return quizService.getAll();
    }
    @GetMapping("/{id}")
    public Quiz getById(@PathVariable long id){return quizService.getById(id);}
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {return quizService.addQuiz(quiz);}
    @DeleteMapping("/{id}")
    public void deleteQuiz(long id){quizService.removeQuiz(id);}
    @PutMapping
    public Quiz updateQuiz(@RequestBody Quiz quiz){return quizService.updateQuiz(quiz);}

}
