package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    //private int parent_category_id;
}
