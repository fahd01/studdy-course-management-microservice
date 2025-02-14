package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ressourceId;
    private String title;
    private String description;
    private String ressource_url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    private int courseId;
}
