package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Answer;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.AnswerRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    public List<Answer> getAll(){
        return this.answerRepository.findAll();

    }
    public Answer getById(long id){
        return this.answerRepository.findById(id).get();
    }

    public Answer add(Answer answer){
        return this.answerRepository.save(answer);
    }

    public void delete(long id){
        this.answerRepository.deleteById(id);
    }

    public Answer update(Answer answer ) {
        return this.answerRepository.save(answer);
    }

}
