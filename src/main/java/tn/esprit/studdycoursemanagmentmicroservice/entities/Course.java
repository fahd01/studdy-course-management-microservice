package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String title;
    private String description;

    private int instructorId;
    private String thumbnail_url;
    private CourseStatus status;
    private LocalDateTime created_at;
    private LocalDateTime upadted_at;
    private DecimalFormat price;
    private int duration;
    private DifficultyLevel difficultyLevel;
    private DecimalFormat average_rating;
    private int total_enrollements;


}
