package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Category;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Choix;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.CategoryRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.ChoixRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChoixService {
    private final ChoixRepository choixRepository;
    public List<Choix> getAll(){
        return this.choixRepository.findAll();

    }
    public Choix getById(long id){
        return this.choixRepository.findById(id).get();
    }

    public Choix addChoix(Choix choix){
        return this.choixRepository.save(choix);
    }

    public void removeChoix(long id){
        this.choixRepository.deleteById(id);
    }

    public Choix updateChoix(Choix choix ) {
        return this.choixRepository.save(choix);
    }

}
