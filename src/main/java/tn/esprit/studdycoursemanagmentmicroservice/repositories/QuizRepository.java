package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Quiz;
@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
