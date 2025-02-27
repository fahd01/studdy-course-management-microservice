package tn.esprit.studdycoursemanagmentmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Category;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.services.CategoryService;
import tn.esprit.studdycoursemanagmentmicroservice.services.EnrollmentService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable long id){return categoryService.getById(id);}
    @PostMapping
    public Category addCategory(@RequestBody Category category) {return categoryService.addCategory(category);}
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id){categoryService.removeCategory(id);}
    @PutMapping
    public Category updateCategory(@RequestBody Category category){return categoryService.updateCategory(category);}

}
