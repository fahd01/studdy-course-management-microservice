package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int module_id;
    private String title;
    private String description;
    private int order;
    private LocalDateTime creaeted_at;
    private LocalDateTime updated_at;

    private int course_id;
}
