package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int certificateId;
    private LocalDateTime issueDate;
    private String certificate_url;



    private int enrollmentId;
    private int userId;
    private int courseId;
}
