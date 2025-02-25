package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Question;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Quiz;
import tn.esprit.studdycoursemanagmentmicroservice.services.QuestionService;
import tn.esprit.studdycoursemanagmentmicroservice.services.QuizService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping
    public List<Question> getAll(){
        return questionService.getAll();
    }
    @GetMapping("/{id}")
    public Question getById(@PathVariable long id){return questionService.getById(id);}
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {return questionService.addQuestion(question);}
    @DeleteMapping
    public void deleteQuestion(long id){questionService.removeQuestion(id);}
    @PutMapping
    public Question updateQuestion(@RequestBody Question question){return questionService.updateQuestion(question);}


}
