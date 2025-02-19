package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Choix;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Course;
import tn.esprit.studdycoursemanagmentmicroservice.services.ChoixService;
import tn.esprit.studdycoursemanagmentmicroservice.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/choix")
public class ChoixController {
    private final ChoixService choixService;
    @GetMapping
    public List<Choix> getAll(){
        return choixService.getAll();
    }
    @GetMapping("/{id}")
    public Choix getById(@PathVariable long id){return choixService.getById(id);}
    @PostMapping("/add-choix")
    public Choix addChoix(@RequestBody Choix c) {return choixService.addChoix(c);}
    @DeleteMapping
    public void deleteChoix(long id){choixService.removeChoix(id);}
    @PutMapping("/update-choix")
    public Choix updateChoix(Choix choix){return choixService.updateChoix(choix);}

}
