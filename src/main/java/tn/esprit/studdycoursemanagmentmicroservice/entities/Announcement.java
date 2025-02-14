package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Announcement {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int announcementId;
    private String title;
    private String message;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    private int courseId;
    private int instructorId;
}
