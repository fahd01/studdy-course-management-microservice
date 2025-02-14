package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private int rating;
    private String review_text;
    private LocalDateTime reviewDate;
    private ReviewStatus reviewStatus;


    private int courseId;
    private int userId;
}
