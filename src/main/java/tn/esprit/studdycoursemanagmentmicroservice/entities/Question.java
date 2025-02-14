package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String question_text;
    private QuestionType questionType;
    private String CorrectAnswer;
    private DecimalFormat points;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private int quizId;

}
