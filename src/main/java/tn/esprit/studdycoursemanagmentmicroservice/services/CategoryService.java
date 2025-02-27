package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Category;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.CategoryRepository;

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
        Assert.notNull(category.getId(), "The category passed for update has a null ID");
        return this.categoryRepository.save(category);
    }

}
