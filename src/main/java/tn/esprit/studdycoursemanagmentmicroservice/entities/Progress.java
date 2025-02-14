package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int progressId;
    private ProgressStatus progressStatus;
    private LocalDateTime started_at;
    private LocalDateTime completed_at;



    private int enrollmentId;
    private int moduleId;
    private int lessonId;



}
