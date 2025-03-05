package tn.esprit.studdycoursemanagmentmicroservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Quiz;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.QuizRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    public List<Quiz> getAll(){
        return this.quizRepository.findAll();
    }

    public Quiz getById(long id){
        return this.quizRepository.findById(id).get();
    }

    public Quiz addQuiz(Quiz quiz){
        return this.quizRepository.save(quiz);
    }

    public void removeQuiz(long id){
        this.quizRepository.deleteById(id);
    }

    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

}
