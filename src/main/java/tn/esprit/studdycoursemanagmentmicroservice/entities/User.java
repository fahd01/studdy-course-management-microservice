package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String user_name;
    private String email;
    private String password;
    private Role role;
    private String first_name;
    private String last_name;
    private String profile_picture_url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


}
