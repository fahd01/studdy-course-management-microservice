package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private float points;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToMany(mappedBy = "questions")
    private List<Quiz>quizzes;

}
