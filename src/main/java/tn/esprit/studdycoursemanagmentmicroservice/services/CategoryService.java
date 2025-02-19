package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Category;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Enrollment;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.CategoryRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.EnrollmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return this.categoryRepository.findAll();

    }
    public Category getById(long id){
        return this.categoryRepository.findById(id).get();
    }

    public Category addCategory(Category category){
        return this.categoryRepository.save(category);
    }

    public void removeCategory(long id){
        this.categoryRepository.deleteById(id);
    }

    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

}
