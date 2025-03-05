package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Question;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Quiz;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.QuestionRepository;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.QuizRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<Question> getAll(){
        return this.questionRepository.findAll();
    }

    public Question getById(long id){
        return this.questionRepository.findById(id).get();
    }

    public Question add(Question question){
        return this.questionRepository.save(question);
    }

    public void delete(long id){ this.questionRepository.deleteById(id);}

    public Question update(Question question) {
        return this.questionRepository.save(question);
    }

}
