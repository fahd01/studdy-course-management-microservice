package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizId;
    private String title;
    private String description;
    private int passing_score;
    private int time_limit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private int module_id;
}
