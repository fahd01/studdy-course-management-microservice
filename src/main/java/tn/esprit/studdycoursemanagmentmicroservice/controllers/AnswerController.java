package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Answer;
import tn.esprit.studdycoursemanagmentmicroservice.services.AnswerService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;
    @GetMapping
    public List<Answer> getAll(){
        return answerService.getAll();
    }
    @GetMapping("/{id}")
    public Answer getById(@PathVariable long id){return answerService.getById(id);}
    @PostMapping()
    public Answer add(@RequestBody Answer answer) {return answerService.add(answer);}
    @DeleteMapping("@{id}")
    public void delete(long id){answerService.delete(id);}
    @PutMapping()
    public Answer update(@RequestBody Answer answer){return answerService.update(answer);}

}
