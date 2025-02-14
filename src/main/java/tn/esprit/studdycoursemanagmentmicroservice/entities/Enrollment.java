package tn.esprit.studdycoursemanagmentmicroservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;
    private LocalDateTime enrollment_date;
    private CompletionStatus completionStatus;
    private LocalDateTime completion_date;
    private PaymentStatus paymentStatus;


    private int userId;
    private int CourseId;
}
