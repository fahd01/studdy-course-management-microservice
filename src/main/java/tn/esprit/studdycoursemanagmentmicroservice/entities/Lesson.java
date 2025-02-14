package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;
    private String title;
    private String description;
    private ContentType contentType;
    private String content_url;
    private int duration;
    private int order;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private int module_id;

}
